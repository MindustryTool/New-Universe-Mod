package org.mindustrytool.NewUniverse.content.borealis.erisa;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.game.Schematics;
import mindustry.world.TileGen;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.Block;
import mindustry.world.meta.Env;

import static mindustry.Vars.state;

public class ErisaPlanetGenerator extends PlanetGenerator {
    Block[][] terrain;

    public ErisaPlanetGenerator() {
        baseSeed = 100;

        terrain = new Block[][]{
            {Blocks.water, Blocks.ice, Blocks.snow, Blocks.stone},
            {Blocks.water, Blocks.ice, Blocks.stone, Blocks.stone},
            {Blocks.water, Blocks.stone, Blocks.stone, Blocks.stone},
        };
    }

    float rawHeight(Vec3 position) {
        return Simplex.noise3d(seed, 6, 0.5, 1.0 / 3.0, position.x, position.y, position.z) * 1.2f;
    }

    float getTemp(Vec3 position) {
        float latitude = Math.abs(position.y);
        float noise = Simplex.noise3d(seed, 4, 0.5, 1.0 / 2.0, position.x, position.y + 999f, position.z);
        return Mathf.clamp(latitude + noise * 0.3f);
    }

    Block getBlock(Vec3 position) {
        float height = rawHeight(position);
        float temp = getTemp(position);

        int heightIdx = Mathf.clamp((int) (height * terrain[0].length), 0, terrain[0].length - 1);
        int tempIdx = Mathf.clamp((int) (temp * terrain.length), 0, terrain.length - 1);

        return terrain[tempIdx][heightIdx];
    }

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

        out.set(block.mapColor);

        Color dustColor = Color.valueOf("8B5E3C");
        float dustFactor = Mathf.clamp((1f - height * 0.5f) * temp * 0.6f);
        out.lerp(dustColor, dustFactor);

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

        pass((x, y) -> {
            if (!floor.asFloor().hasSurface()) return;

            if ((floor == Blocks.stone)
                    && noise(x, y, 2, 0.7, 50, 1) > 0.55f) {
                ore = Blocks.oreCopper;
            }

            if (floor == Blocks.ice && noise(x, y, 2, 0.7, 45, 1) > 0.5f) {
                ore = Blocks.oreLead;
            }

            if (floor == Blocks.snow && noise(x, y, 2, 0.7, 35, 1) > 0.55f) {
                ore = Blocks.oreTitanium;
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
