package org.mindustrytool.NewUniverse.planets;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import mindustry.game.Schematics;
import mindustry.world.TileGen;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.Block;
import mindustry.world.meta.Env;
import org.mindustrytool.NewUniverse.content.NewUniverseBlocks;

import static mindustry.Vars.state;

public class NewUniversePlanetGenerator extends PlanetGenerator {
    // 2D terrain array indexed as terrain[tempBand][heightBand]
    // Height bands (4): deepWater, shallowWater, land, high
    // Temp bands  (3): cold, temperate, warm
    Block[][] terrain = {
        // cold     — deepIce,   ice,       snow,       permafrost
        {NewUniverseBlocks.glaciusDeepIce, NewUniverseBlocks.glaciusIce, NewUniverseBlocks.glaciusSnow, NewUniverseBlocks.glaciusPermafrost},
        // temperate — deepIce,   ice,       regolith,   permafrost
        {NewUniverseBlocks.glaciusDeepIce, NewUniverseBlocks.glaciusIce, NewUniverseBlocks.glaciusRegolith, NewUniverseBlocks.glaciusPermafrost},
        // warm     — slagIce,   vent,      vent,       crust
        {NewUniverseBlocks.glaciusSlagIce, NewUniverseBlocks.glaciusVent, NewUniverseBlocks.glaciusVent, NewUniverseBlocks.glaciusCrust},
    };

    {
        baseSeed = 100;
    }

    /** Empty load() stub for consistent content registration pattern. */
    public static void load() {
    }

    // ── Height / temperature helpers ────────────────────────────────

    float rawHeight(Vec3 position) {
        return Simplex.noise3d(seed, 6, 0.5, 1.0 / 3.0, position.x, position.y, position.z) * 2f;
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
        out.set(block.mapColor).a(1f - block.albedo);
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

            if ((floor == NewUniverseBlocks.glaciusRegolith || floor == NewUniverseBlocks.glaciusPermafrost)
                    && noise(x, y, 2, 0.7, 40, 1) > 0.5f) {
                ore = NewUniverseBlocks.oreFrozenIron;
            }

            if (floor == NewUniverseBlocks.glaciusIce && noise(x, y, 2, 0.7, 40, 1) > 0.6f) {
                ore = NewUniverseBlocks.oreCryoCrystal;
            }

            if (floor == NewUniverseBlocks.glaciusVent && noise(x, y, 2, 0.7, 40, 1) > 0.4f) {
                ore = NewUniverseBlocks.oreVolcanicSulfur;
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
