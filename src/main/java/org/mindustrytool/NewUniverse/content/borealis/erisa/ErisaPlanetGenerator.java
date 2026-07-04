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

    public Block waterBlock;
    public Block iceFloor, stoneFloor, redFloor, darkDirtFloor, darkblueFloor, blueCrystalFloor, denseBlueCrystalFloor, sandFloor;
    public Block oreCophalast, oreDuras, oreNavitas, oreVastum, oreWallPausis, oreRudis, oreSand;
    public Block stoneWall, redWall, redDirtWall, iceWall, darkblueWall;

    public ErisaPlanetGenerator() {
        baseSeed = 100;
        useDefaults();
    }

    public void useDefaults() {
        waterBlock = Blocks.water;
        iceFloor = Blocks.ice;
        stoneFloor = Blocks.stone;
        redFloor = Blocks.stone;
        darkDirtFloor = Blocks.stone;
        darkblueFloor = Blocks.stone;
        blueCrystalFloor = Blocks.stone;
        denseBlueCrystalFloor = Blocks.stone;
        sandFloor = Blocks.sand;
        oreCophalast = Blocks.oreCopper;
        oreDuras = Blocks.oreLead;
        oreNavitas = Blocks.oreTitanium;
        oreVastum = Blocks.oreThorium;
        oreWallPausis = Blocks.oreScrap;
        oreRudis = Blocks.oreCopper;
        oreSand = Blocks.oreScrap;
        stoneWall = Blocks.stoneWall;
        redWall = Blocks.stoneWall;
        redDirtWall = Blocks.stoneWall;
        iceWall = Blocks.iceWall;
        darkblueWall = Blocks.stoneWall;
        rebuildTerrain();
    }

    public void rebuildTerrain() {
        terrain = new Block[][]{
            {waterBlock, iceFloor, stoneFloor, darkblueFloor, denseBlueCrystalFloor},
            {waterBlock, iceFloor, stoneFloor, blueCrystalFloor, denseBlueCrystalFloor},
            {waterBlock, blueCrystalFloor, darkDirtFloor, darkblueFloor, stoneFloor},
            {waterBlock, redFloor, sandFloor, darkDirtFloor, stoneFloor},
            {waterBlock, sandFloor, sandFloor, redFloor, redFloor},
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
            if ((floor == stoneFloor || floor == redFloor || floor == darkblueFloor)
                    && noise(x, y, 2, 0.7, 50, 1) > 0.55f) {
                ore = oreCophalast;
            }
            if ((floor == blueCrystalFloor || floor == denseBlueCrystalFloor)
                    && noise(x, y, 2, 0.7, 45, 1) > 0.5f) {
                ore = oreDuras;
            }
            if (floor == iceFloor && noise(x, y, 2, 0.7, 45, 1) > 0.5f) {
                ore = oreNavitas;
            }
            if (floor == darkDirtFloor && noise(x, y, 2, 0.7, 35, 1) > 0.55f) {
                ore = oreVastum;
            }
            if (floor == darkblueFloor && noise(x, y, 2, 0.7, 40, 1) > 0.5f) {
                ore = oreWallPausis;
            }
            if (floor == redFloor && noise(x, y, 2, 0.7, 35, 1) > 0.6f) {
                ore = oreRudis;
            }
            if (floor == sandFloor && noise(x, y, 2, 0.7, 40, 1) > 0.5f) {
                ore = oreSand;
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
