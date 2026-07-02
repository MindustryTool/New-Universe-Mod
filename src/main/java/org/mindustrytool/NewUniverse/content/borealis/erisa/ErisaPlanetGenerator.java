package org.mindustrytool.NewUniverse.content.borealis.erisa;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import mindustry.game.Schematics;
import mindustry.world.TileGen;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.Block;
import mindustry.world.meta.Env;

import static mindustry.Vars.state;

public class ErisaPlanetGenerator extends PlanetGenerator {
    private final ErisaBlocks blocks;

    // 2D terrain array indexed as terrain[tempBand][heightBand]
    // Height bands (4): deepWater, shallowWater, land, high
    // Temp bands  (3): cold, temperate, warm
    Block[][] terrain;

    {
        baseSeed = 100;
    }

    public ErisaPlanetGenerator(ErisaBlocks blocks) {
        this.blocks = blocks;
        terrain = new Block[][]{
            // cold     — deepIce,   ice,       snow,       permafrost
            {blocks.deepIce, blocks.ice, blocks.snow, blocks.permafrost},
            // temperate — deepIce,   ice,       regolith,   permafrost
            {blocks.deepIce, blocks.ice, blocks.regolith, blocks.permafrost},
            // warm     — slagIce,   vent,      vent,       crust
            {blocks.slagIce, blocks.vent, blocks.vent, blocks.crust},
        };
    }

    // ── Height / temperature helpers ────────────────────────────────

    float rawHeight(Vec3 position) {
        return Simplex.noise3d(seed, 6, 0.5, 1.0 / 3.0, position.x, position.y, position.z) * 1.2f;
    }

    float getTemp(Vec3 position) {
        float latitude = Math.abs(position.y);
        float tnoise = Simplex.noise3d(seed, 4, 0.5, 1.0 / 2.0, position.x, position.y + 999f, position.z);
        return Mathf.clamp(latitude + tnoise * 0.3f);
    }

    Block getBlock(Vec3 position) {
        float height = rawHeight(position);
        float temp = getTemp(position);

        int heightIdx = Mathf.clamp((int) (height * terrain[0].length), 0, terrain[0].length - 1);
        int tempIdx = Mathf.clamp((int) (temp * terrain.length), 0, terrain.length - 1);

        return terrain[tempIdx][heightIdx];
    }

    // ── PlanetGenerator overrides ────────────────────────────────────

    @Override
    public void genTile(Vec3 position, TileGen gen) {
        Block block = getBlock(position);
        gen.floor = block;
        gen.block = block.asFloor().wall;
    }

    @Override
    public float getHeight(Vec3 position) {
        return Math.max(rawHeight(position), 0f);
    }

    @Override
    public void getColor(Vec3 position, Color out) {
        Block block = getBlock(position);
        float height = rawHeight(position);
        float temp = getTemp(position);

        // Base color from block's mapColor
        out.set(block.mapColor);

        // Mix in dust color (reddish-brown) based on height and temperature
        Color dustColor = Color.valueOf("8B5E3C");
        float dustFactor = Mathf.clamp((1f - height * 0.5f) * temp * 0.6f);
        out.lerp(dustColor, dustFactor);

        // Add slight red tint to warmer areas
        Color redTint = Color.valueOf("C0754A");
        float redFactor = Mathf.clamp(temp * 0.3f);
        out.lerp(redTint, redFactor);

        out.a(1f - block.albedo);
    }

    @Override
    protected float noise(float x, float y, double octaves, double falloff, double scl, double mag) {
        return (float) (Simplex.noise2d(seed, octaves, falloff, 1.0 / scl, x, y) * mag);
    }

    @Override
    protected void generate() {
        cells(4);
        distort(10f, 12f);

        // ── Custom ore pass ──────────────────────────────────────
        pass((x, y) -> {
            if (!floor.asFloor().hasSurface()) return;

            if ((floor == blocks.regolith || floor == blocks.permafrost)
                    && noise(x, y, 2, 0.7, 50, 1) > 0.55f) {
                ore = blocks.oreDuras;
            }

            if (floor == blocks.ice && noise(x, y, 2, 0.7, 45, 1) > 0.5f) {
                ore = blocks.oreCophalast;
            }

            if (floor == blocks.crust && noise(x, y, 2, 0.7, 35, 1) > 0.55f) {
                ore = blocks.oreNavitas;
            }

            if (floor == blocks.permafrost && noise(x, y, 2, 0.7, 30, 1) > 0.6f) {
                ore = blocks.orePausis;
            }

            if (floor == blocks.slagIce && noise(x, y, 2, 0.7, 40, 1) > 0.5f) {
                ore = blocks.oreVastum;
            }
        });

        trimDark();
        median(2);

        int spawnX = width / 2, spawnY = height / 2;
        inverseFloodFill(tiles.getn(spawnX, spawnY));

        Schematics.placeLaunchLoadout(spawnX, spawnY);

        state.rules.env = Env.terrestrial | Env.oxygen;
        state.rules.waves = true;
        state.rules.waveSpacing = 1200f;
    }
}
