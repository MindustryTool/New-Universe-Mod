package org.mindustrytool.NewUniverse.content.borealis.erisa;

import arc.Core;
import arc.graphics.Color;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Geometry;
import arc.math.geom.Point2;
import arc.math.geom.Vec2;
import arc.math.geom.Vec3;
import arc.struct.*;
import arc.util.Structs;
import arc.util.Tmp;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import mindustry.ai.Astar;
import mindustry.ai.BaseRegistry;
import mindustry.content.Blocks;
import mindustry.content.Liquids;
import mindustry.content.Planets;
import mindustry.game.Schematics;
import mindustry.game.Team;
import mindustry.game.Waves;
import mindustry.gen.Iconc;
import mindustry.maps.generators.BaseGenerator;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.TileGen;
import mindustry.world.Tiles;
import mindustry.world.blocks.environment.Floor;
import org.jetbrains.annotations.Nullable;
import org.mindustrytool.NewUniverse.content.borealis.content.BorealisContents;

import javax.inject.Inject;

import static mindustry.Vars.*;

public class ErisaPlanetGenerator extends PlanetGenerator {
    public static boolean indirectPaths = false;
    public static boolean genLakes = false;

    BaseGenerator baseGenerator = new BaseGenerator();
    float heightYOffset = 42.7f;
    float scl = 5f;
    float waterOffset = 0.04f;
    float heightScl = 1.01f;

    Block[][] arr;
    ObjectMap<Block, Block> dec = new ObjectMap<>();

    public Block waterBlock;
    public Block iceFloor, stoneFloor, redFloor, darkDirtFloor, darkblueFloor, blueCrystalFloor, denseBlueCrystalFloor, sandFloor;
    public Block oreCophalast, oreDuras, oreNavitas, oreVastum, oreWallPausis, oreRudis, oreSand;
    public Block stoneWall, redWall, redDirtWall, iceWall, darkblueWall;

    float water;
    Vec3 basePos = new Vec3(0.9341721, 0.0, 0.3568221);
    public Planet erisaPlanet;
    public Block iceBoulder;

    @Inject
    public ErisaPlanetGenerator() {
        baseSeed = 100;
    }

    public void init(BorealisContents c) {
        waterBlock = Blocks.water;
        iceFloor = c.iceFloor;
        stoneFloor = c.stoneFloor;
        redFloor = c.redFloor;
        darkDirtFloor = c.darkDirtFloor;
        darkblueFloor = c.darkblueFloor;
        blueCrystalFloor = c.blueCrystalFloor;
        denseBlueCrystalFloor = c.denseBlueCrystalFloor;
        sandFloor = c.sandFloor;
        oreCophalast = c.oreCophalast;
        oreDuras = c.oreDuras;
        oreNavitas = c.oreNavitas;
        oreVastum = c.oreVastum;
        oreWallPausis = c.oreWallPausis;
        oreRudis = c.oreRudis;
        oreSand = c.oreSand;
        stoneWall = c.wallBlock;
        redWall = c.redWall;
        redDirtWall = c.redDirtWall;
        iceWall = c.iceWall;
        darkblueWall = c.darkblueWall;
        iceBoulder = c.iceBoulder;
        dec.put(stoneFloor, c.boulder);
        dec.put(redFloor, c.redBoulder);
        dec.put(iceFloor, c.iceBoulder);
        dec.put(darkblueFloor, c.darkblueBoulder);
        dec.put(darkDirtFloor, c.darkDirtBoulder);
        dec.put(blueCrystalFloor, c.blueCrystalBlocks);
        dec.put(denseBlueCrystalFloor, c.blueCrystalBlocks);
        dec.put(sandFloor, c.boulder);
        rebuildTerrain();
    }

    public void rebuildTerrain() {
        arr = new Block[][]{
                {Blocks.water, sandFloor, sandFloor, sandFloor, redFloor, redFloor, stoneFloor, stoneFloor, iceFloor, iceFloor, denseBlueCrystalFloor, denseBlueCrystalFloor, denseBlueCrystalFloor},
                {Blocks.water, Blocks.sand, sandFloor, sandFloor, redFloor, stoneFloor, darkDirtFloor, darkblueFloor, blueCrystalFloor, denseBlueCrystalFloor, denseBlueCrystalFloor, denseBlueCrystalFloor, denseBlueCrystalFloor},
                {Blocks.deepwater, Blocks.water, Blocks.sand, sandFloor, stoneFloor, darkDirtFloor, darkblueFloor, blueCrystalFloor, denseBlueCrystalFloor, denseBlueCrystalFloor, denseBlueCrystalFloor, blueCrystalFloor, stoneFloor},
                {Blocks.deepwater, Blocks.water, Blocks.water, iceFloor, stoneFloor, stoneFloor, darkDirtFloor, darkblueFloor, blueCrystalFloor, denseBlueCrystalFloor, blueCrystalFloor, stoneFloor, stoneFloor},
                {Blocks.ice, iceFloor, iceFloor, iceFloor, stoneFloor, stoneFloor, darkblueFloor, blueCrystalFloor, denseBlueCrystalFloor, blueCrystalFloor, stoneFloor, stoneFloor, stoneFloor},
                {Blocks.ice, iceFloor, iceFloor, Blocks.snow, stoneFloor, stoneFloor, darkDirtFloor, darkblueFloor, blueCrystalFloor, stoneFloor, stoneFloor, stoneFloor, stoneFloor},
                {Blocks.ice, Blocks.ice, Blocks.snow, Blocks.snow, stoneFloor, darkDirtFloor, darkblueFloor, stoneFloor, stoneFloor, stoneFloor, stoneFloor, stoneFloor, stoneFloor},
                {Blocks.ice, Blocks.ice, Blocks.snow, Blocks.snow, stoneFloor, darkDirtFloor, darkblueFloor, stoneFloor, redFloor, sandFloor, sandFloor, sandFloor, sandFloor},
                {Blocks.water, Blocks.snow, Blocks.snow, iceFloor, stoneFloor, darkDirtFloor, darkblueFloor, stoneFloor, redFloor, redFloor, sandFloor, sandFloor, sandFloor},
                {Blocks.water, Blocks.snow, iceFloor, iceFloor, stoneFloor, stoneFloor, darkDirtFloor, darkblueFloor, redFloor, redFloor, sandFloor, sandFloor, sandFloor},
                {Blocks.deepwater, Blocks.water, Blocks.sand, sandFloor, sandFloor, stoneFloor, stoneFloor, darkDirtFloor, darkblueFloor, redFloor, redFloor, sandFloor, sandFloor},
                {Blocks.deepwater, Blocks.water, Blocks.sand, sandFloor, sandFloor, sandFloor, stoneFloor, stoneFloor, darkDirtFloor, darkblueFloor, redFloor, redFloor, stoneFloor},
                {Blocks.deepwater, Blocks.deepwater, Blocks.water, Blocks.water, Blocks.sand, sandFloor, sandFloor, stoneFloor, stoneFloor, darkDirtFloor, darkblueFloor, redFloor, redFloor},
        };
        water = 2f / arr[0].length;
    }

    float rawHeight(Vec3 position) {
        return (Mathf.pow(Simplex.noise3d(seed, 7, 0.5f, 1f / 3f, position.x * scl, position.y * scl + heightYOffset, position.z * scl) * heightScl, 2.3f) + waterOffset) / (1f + waterOffset);
    }

    @Override
    public void onSectorCaptured(Sector sector) {
        sector.planet.reloadMeshAsync();
    }

    @Override
    public void onSectorLost(Sector sector) {
        sector.planet.reloadMeshAsync();
    }

    @Override
    public void beforeSaveWrite(Sector sector) {
        sector.planet.reloadMeshAsync();
    }

    @Override
    public boolean isEmissive() {
        return true;
    }

    public boolean allowNumberedLaunch(Sector s) {
        return s.hasBase() && !s.isAttacked() && (s.info.bestCoreType.size >= 4 || s.isBeingPlayed() && state.rules.defaultTeam.cores().contains(b -> b.block.size >= 4));
    }

    @Override
    public boolean allowLanding(Sector sector) {
        return sector.planet.allowLaunchToNumbered && (sector.hasBase() || sector.near().contains(this::allowNumberedLaunch));
    }

    @Override
    public @Nullable Sector findLaunchCandidate(Sector destination, @Nullable Sector selected) {
        if (destination.preset == null || !destination.preset.requireUnlock) {
            if (selected != null && selected.isNear(destination) && allowNumberedLaunch(selected)) {
                return selected;
            } else {
                return destination.near().find(this::allowNumberedLaunch);
            }
        } else {
            return super.findLaunchCandidate(destination, selected);
        }
    }

    @Override
    public void getLockedText(Sector hovered, StringBuilder out) {
        if ((hovered.preset == null || !hovered.preset.requireUnlock) && hovered.near().contains(Sector::hasBase)) {
            if (hovered.isShielded()) {
                out.append("[red]").append(Iconc.defense).append("[]").append(Core.bundle.get("sector.shielded"));
            } else {
                out.append("[red]").append(Iconc.cancel).append("[]").append(Blocks.coreFoundation.emoji()).append(Core.bundle.get("sector.foundationrequired"));
            }
        } else {
            super.getLockedText(hovered, out);
        }
    }

    @Override
    public float getHeight(Vec3 position) {
        float height = rawHeight(position);
        return Math.max(height, water);
    }

    @Override
    public void getColor(Vec3 position, Color out) {
        Block block = getBlock(position, true);
        out.set(block.mapColor).a(1f - block.albedo);
    }

    @Override
    public void getEmissiveColor(Vec3 position, Color out) {
        float dst = 999f, captureDst = 999f, lightScl = 0f;

        Object[] sectors = erisaPlanet.sectors.items;
        int size = erisaPlanet.sectors.size;

        for (int i = 0; i < size; i++) {
            var sector = (Sector) sectors[i];

            if (sector.hasEnemyBase() && !sector.isCaptured()) {
                dst = Math.min(dst, position.dst(sector.tile.v) - (sector.preset != null ? sector.preset.difficulty / 10f * 0.03f - 0.03f : 0f));
            } else if (sector.hasBase()) {
                float cdst = position.dst(sector.tile.v);
                if (cdst < captureDst) {
                    captureDst = cdst;
                    lightScl = sector.info.lightCoverage;
                }
            }
        }

        lightScl = Math.min(lightScl / 50000f, 1.3f);
        if (lightScl < 1f) lightScl = Interp.pow5Out.apply(lightScl);

        float freq = 0.05f;
        //TODO: once the old megabase returns, change it to 0.55f
        if (position.dst(basePos) < 0.3f ?

                dst * metalDstScl + Simplex.noise3d(seed + 1, 3, 0.4, 5.5f, position.x, position.y + 200f, position.z) * 0.08f + ((basePos.dst(position) + 0.00f) % freq < freq / 2f ? 1f : 0f) * 0.07f < 0.08f/* || dst <= 0.0001f*/ :
                dst * metalDstScl + Simplex.noise3d(seed, 3, 0.4, 9f, position.x, position.y + 370f, position.z) * 0.06f < 0.045) {

            out.set(Team.crux.color)
                    .mul(0.8f + Simplex.noise3d(seed, 1, 1, 9f, position.x, position.y + 99f, position.z) * 0.4f)
                    .lerp(Team.sharded.color, 0.2f * Simplex.noise3d(seed, 1, 1, 9f, position.x, position.y + 999f, position.z)).toFloatBits();
        } else if (captureDst * metalDstScl + Simplex.noise3d(seed, 3, 0.4, 9f, position.x, position.y + 600f, position.z) * 0.07f < 0.05 * lightScl) {
            out.set(Team.sharded.color).mul(0.7f + Simplex.noise3d(seed, 1, 1, 9f, position.x, position.y + 99f, position.z) * 0.4f)
                    .lerp(Team.crux.color, 0.3f * Simplex.noise3d(seed, 1, 1, 9f, position.x, position.y + 999f, position.z)).toFloatBits();

        }
    }

    @Override
    public void genTile(Vec3 position, TileGen tile) {
        tile.floor = getBlock(position, false);
        if (tile.floor == Blocks.darkPanel6) tile.floor = Blocks.darkPanel3;
        tile.block = tile.floor.asFloor().wall;

        if (Ridged.noise3d(seed + 1, position.x, position.y, position.z, 2, 22) > 0.31) {
            tile.block = Blocks.air;
        }
    }

    static double metalDstScl = 0.25;

    Block getBlock(Vec3 position, boolean visualOnly) {
        float height = rawHeight(position);
        float px = position.x * scl, py = position.y * scl, pz = position.z * scl;

        float rad = scl;
        float temp = Mathf.clamp(Math.abs(py * 2f) / (rad));
        float tnoise = Simplex.noise3d(seed, 7, 0.56, 1f / 3f, px, py + 999f - 0.1f, pz);
        temp = Mathf.lerp(temp, tnoise, 0.5f);
        height *= 1.2f;
        height = Mathf.clamp(height);

        Block res = arr[Mathf.clamp((int) (temp * arr.length), 0, arr[0].length - 1)][Mathf.clamp((int) (height * arr[0].length), 0, arr[0].length - 1)];
        if (visualOnly && position.within(basePos, 0.65f)) {

            float dst = 999f;

            Object[] sectors = erisaPlanet.sectors.items;
            int size = erisaPlanet.sectors.size;

            for (int i = 0; i < size; i++) {
                var sector = (Sector) sectors[i];

                if (sector.hasEnemyBase()) {
                    dst = Math.min(dst, position.dst(sector.tile.v));
                }
            }

            float freq = 0.05f, freq2 = 0.07f;

            if (dst * 0.85f + Simplex.noise3d(seed, 3, 0.4, 5.5f, position.x, position.y + 200f, position.z) * 0.015f + ((basePos.dst(position) + 0.00f) % freq < freq / 2f ? 1f : 0f) * 0.07f < 0.15f) {
                return ((basePos.dst(position) + 0.01f) % freq2 < freq2 * 0.65f) ? Blocks.metalFloor : Blocks.darkPanel6;
            }
        }
        return res;
    }

    @Override
    protected float noise(float x, float y, double octaves, double falloff, double scl, double mag) {
        Vec3 v = sector.rect.project(x, y).scl(5f);
        return Simplex.noise3d(seed, octaves, falloff, 1f / scl, v.x, v.y, v.z) * (float) mag;
    }

    @Override
    protected void generate() {

        class Room {
            final int x;
            final int y;
            final int radius;
            final ObjectSet<Room> connected = new ObjectSet<>();

            Room(int x, int y, int radius) {
                this.x = x;
                this.y = y;
                this.radius = radius;
                connected.add(this);
            }

            void join(int x1, int y1, int x2, int y2) {
                float nscl = rand.random(100f, 140f) * 6f;
                int stroke = rand.random(3, 9);
                brush(pathfind(x1, y1, x2, y2, tile -> (tile.solid() ? 50f : 0f) + noise(tile.x, tile.y, 2, 0.4f, 1f / nscl) * 500, Astar.manhattan), stroke);
            }

            void connect(Room to) {
                if (!connected.add(to) || to == this) return;

                Vec2 midpoint = Tmp.v1.set(to.x, to.y).add(x, y).scl(0.5f);
                rand.nextFloat();

                if (indirectPaths) {
                    midpoint.add(Tmp.v2.set(1, 0f).setAngle(Angles.angle(to.x, to.y, x, y) + 90f * (rand.chance(0.5) ? 1f : -1f)).scl(Tmp.v1.dst(x, y) * 2f));
                } else {
                    //add randomized offset to avoid straight lines
                    midpoint.add(Tmp.v2.setToRandomDirection(rand).scl(Tmp.v1.dst(x, y)));
                }

                midpoint.sub(width / 2f, height / 2f).limit(width / 2f / Mathf.sqrt3).add(width / 2f, height / 2f);

                int mx = (int) midpoint.x, my = (int) midpoint.y;

                join(x, y, mx, my);
                join(mx, my, to.x, to.y);
            }

            void joinLiquid(int x1, int y1, int x2, int y2) {
                float nscl = rand.random(100f, 140f) * 6f;
                int rad = rand.random(7, 11);
                int avoid = 2 + rad;
                var path = pathfind(x1, y1, x2, y2, tile -> (tile.solid() || !tile.floor().isLiquid ? 70f : 0f) + noise(tile.x, tile.y, 2, 0.4f, 1f / nscl) * 500, Astar.manhattan);
                path.each(t -> {
                    //don't place liquid paths near the core
                    if (Mathf.dst2(t.x, t.y, x2, y2) <= avoid * avoid) {
                        return;
                    }

                    for (int x = -rad; x <= rad; x++) {
                        for (int y = -rad; y <= rad; y++) {
                            int wx = t.x + x, wy = t.y + y;
                            if (Structs.inBounds(wx, wy, width, height) && Mathf.within(x, y, rad)) {
                                Tile other = tiles.getn(wx, wy);
                                other.setBlock(Blocks.air);
                                if (Mathf.within(x, y, rad - 1) && !other.floor().isLiquid) {
                                    Floor floor = other.floor();
                                    //TODO does not respect tainted floors
                                    other.setFloor((Floor) Blocks.water);
                                }
                            }
                        }
                    }
                });
            }

            void connectLiquid(Room to) {
                if (to == this) return;

                Vec2 midpoint = Tmp.v1.set(to.x, to.y).add(x, y).scl(0.5f);
                rand.nextFloat();

                //add randomized offset to avoid straight lines
                midpoint.add(Tmp.v2.setToRandomDirection(rand).scl(Tmp.v1.dst(x, y)));
                midpoint.sub(width / 2f, height / 2f).limit(width / 2f / Mathf.sqrt3).add(width / 2f, height / 2f);

                int mx = (int) midpoint.x, my = (int) midpoint.y;

                joinLiquid(x, y, mx, my);
                joinLiquid(mx, my, to.x, to.y);
            }
        }

        cells(4);
        distort(10f, 12f);

        float constraint = 1.3f;
        float radius = width / 2f / Mathf.sqrt3;
        int rooms = rand.random(2, 5);
        Seq<Room> roomseq = new Seq<>();

        for (int i = 0; i < rooms; i++) {
            Tmp.v1.trns(rand.random(360f), rand.random(radius / constraint));
            float rx = (width / 2f + Tmp.v1.x);
            float ry = (height / 2f + Tmp.v1.y);
            float maxrad = radius - Tmp.v1.len();
            float rrad = Math.min(rand.random(9f, maxrad / 2f), 30f);
            roomseq.add(new Room((int) rx, (int) ry, (int) rrad));
        }

        //check positions on the map to place the player spawn. this needs to be in the corner of the map
        Room spawn = null;
        Seq<Room> enemies = new Seq<>();
        int enemySpawns = rand.random(1, Math.max((int) (sector.threat * 4), 1));
        int offset = rand.nextInt(360);
        float length = width / 2.55f - rand.random(13, 23);
        int angleStep = 5;
        int waterCheckRad = 5;
        for (int i = 0; i < 360; i += angleStep) {
            int angle = offset + i;
            int cx = (int) ((float) width / 2 + Angles.trnsx(angle, length));
            int cy = (int) ((float) height / 2 + Angles.trnsy(angle, length));

            int waterTiles = 0;

            //check for water presence
            for (int rx = -waterCheckRad; rx <= waterCheckRad; rx++) {
                for (int ry = -waterCheckRad; ry <= waterCheckRad; ry++) {
                    Tile tile = tiles.get(cx + rx, cy + ry);
                    if (tile == null || tile.floor().liquidDrop != null) {
                        waterTiles++;
                    }
                }
            }

            if (waterTiles <= 4 || (i + angleStep >= 360)) {
                roomseq.add(spawn = new Room(cx, cy, rand.random(8, 15)));

                for (int j = 0; j < enemySpawns; j++) {
                    float enemyOffset = rand.range(60f);
                    Tmp.v1.set(cx - (float) width / 2, cy - (float) height / 2).rotate(180f + enemyOffset).add((float) width / 2, (float) height / 2);
                    Room espawn = new Room((int) Tmp.v1.x, (int) Tmp.v1.y, rand.random(8, 16));
                    roomseq.add(espawn);
                    enemies.add(espawn);
                }

                break;
            }
        }

        //clear radius around each room
        for (Room room : roomseq) {
            erase(room.x, room.y, room.radius);
        }

        //randomly connect rooms together
        int connections = rand.random(Math.max(rooms - 1, 1), rooms + 3);
        for (int i = 0; i < connections; i++) {
            roomseq.random(rand).connect(roomseq.random(rand));
        }

        if (spawn != null) for (Room room : roomseq) {
            spawn.connect(room);
        }

        Room fspawn = spawn;

        cells(1);

        int tileLen = tiles.width * tiles.height;
        int total = 0, waters = 0;

        for (int i = 0; i < tileLen; i++) {
            Tile tile = tiles.geti(i);
            if (tile.block() == Blocks.air) {
                total++;
                if (tile.floor().liquidDrop == Liquids.water) {
                    waters++;
                }
            }
        }

        boolean naval = (float) waters / total >= 0.19f;

        //create water pathway if the map is flooded
        if (naval) {
            for (Room room : enemies) {
                room.connectLiquid(spawn);
            }
        }

        distort(10f, 6f);

        //rivers
        pass((x, y) -> {
            if (block.solid) return;

            Vec3 v = sector.rect.project(x, y);

            float rr = Simplex.noise2d(sector.id, (float) 2, 0.6f, 1f / 7f, x, y) * 0.1f;
            float value = Ridged.noise3d(2, v.x, v.y, v.z, 1, 1f / 55f) + rr - rawHeight(v) * 0f;
            float rrscl = rr * 44 - 2;

            if (value > 0.17f && !Mathf.within(x, y, fspawn.x, fspawn.y, 12 + rrscl)) {
                boolean deep = value > 0.17f + 0.1f && !Mathf.within(x, y, fspawn.x, fspawn.y, 15 + rrscl);
                if (!(floor == iceFloor || floor.asFloor().isLiquid)) {
                    floor = deep ? Blocks.deepwater : Blocks.water;
                }
            }
        });

        //shoreline setup
        pass((x, y) -> {
            int deepRadius = 3;

            if (floor.asFloor().isLiquid && floor.asFloor().shallow) {

                for (int cx = -deepRadius; cx <= deepRadius; cx++) {
                    for (int cy = -deepRadius; cy <= deepRadius; cy++) {
                        if ((cx) * (cx) + (cy) * (cy) <= deepRadius * deepRadius) {
                            int wx = cx + x, wy = cy + y;

                            Tile tile = tiles.get(wx, wy);
                            if (tile != null && (!tile.floor().isLiquid || tile.block() != Blocks.air)) {
                                //found something solid, skip replacing anything
                                return;
                            }
                        }
                    }
                }

                floor = Blocks.water;
            }
        });

        if (naval) {
            int deepRadius = 2;

            //TODO code is very similar, but annoying to extract into a separate function
            pass((x, y) -> {
                if (floor.asFloor().isLiquid && !floor.asFloor().isDeep() && !floor.asFloor().shallow) {

                    for (int cx = -deepRadius; cx <= deepRadius; cx++) {
                        for (int cy = -deepRadius; cy <= deepRadius; cy++) {
                            if ((cx) * (cx) + (cy) * (cy) <= deepRadius * deepRadius) {
                                int wx = cx + x, wy = cy + y;

                                Tile tile = tiles.get(wx, wy);
                                if (tile != null && (tile.floor().shallow || !tile.floor().isLiquid)) {
                                    //found something shallow, skip replacing anything
                                    return;
                                }
                            }
                        }
                    }

                    floor = Blocks.deepwater;
                }
            });
        }

        Seq<Block> ores = Seq.with(oreRudis, oreSand);
        float poles = Math.abs(sector.tile.v.y);
        float nmag = 0.5f;
        float scl = 1f;
        float addscl = 1.3f;

        if (Simplex.noise3d(seed, 2, 0.5, scl, sector.tile.v.x, sector.tile.v.y, sector.tile.v.z) * nmag + poles > 0.25f * addscl) {
            ores.add(oreNavitas);
        }

        if (Simplex.noise3d(seed, 2, 0.5, scl, sector.tile.v.x + 1, sector.tile.v.y, sector.tile.v.z) * nmag + poles > 0.5f * addscl) {
            ores.add(oreVastum);
        }

        if (Simplex.noise3d(seed, 2, 0.5, scl, sector.tile.v.x + 2, sector.tile.v.y, sector.tile.v.z) * nmag + poles > 0.55f * addscl) {
            ores.add(oreWallPausis);
        }

        if (Simplex.noise3d(seed, 2, 0.5, scl, sector.tile.v.x + 3, sector.tile.v.y, sector.tile.v.z) * nmag + poles > 0.65f * addscl) {
            ores.add(oreCophalast);
        }

        if (Simplex.noise3d(seed, 2, 0.5, scl, sector.tile.v.x + 4, sector.tile.v.y, sector.tile.v.z) * nmag + poles > 0.75f * addscl) {
            ores.add(oreDuras);
        }

        FloatSeq frequencies = new FloatSeq();
        for (int i = 0; i < ores.size; i++) {
            frequencies.add(rand.random(-0.1f, 0.01f) - i * 0.01f + poles * 0.04f);
        }

        pass((x, y) -> {
            if (!floor.asFloor().hasSurface()) return;

            int offsetX = x - 4, offsetY = y + 23;
            for (int i = ores.size - 1; i >= 0; i--) {
                Block entry = ores.get(i);
                float freq = frequencies.get(i);
                if (Math.abs(0.5f - noise(offsetX, offsetY + i * 999, 2, 0.7, (40 + i * 2))) > 0.22f + i * 0.01 &&
                        Math.abs(0.5f - noise(offsetX, offsetY - i * 999, 1, 1, (30 + i * 4))) > 0.37f + freq) {
                    ore = entry;
                    break;
                }
            }
        });

        trimDark();

        median(2);

        inverseFloodFill(tiles.getn(spawn.x, spawn.y));

        tech();

        pass((x, y) -> {
            if (genLakes && floor.asFloor().hasSurface()) {
                float noise = noise(x + 782, y, 5, 0.75f, 260f, 1f);
                if (noise > 0.67f && !roomseq.contains(e -> Mathf.within(x, y, e.x, e.y, 14))) {
                    if (noise > 0.72f) {
                        floor = Blocks.water;
                    } else {
                        floor = (floor == sandFloor ? sandFloor : darkDirtFloor);
                    }
                }
            }

            if (rand.chance(0.0075)) {
                boolean any = false;
                boolean all = true;
                for (Point2 p : Geometry.d4) {
                    Tile other = tiles.get(x + p.x, y + p.y);
                    if (other != null && other.block() == Blocks.air) {
                        any = true;
                    } else {
                        all = false;
                    }
                }
                if (any && (block == iceWall || (all && block == Blocks.air && floor == iceFloor && rand.chance(0.03)))) {
                    block = iceBoulder;
                }
            }

            //random stuff
            dec:
            {
                for (int i = 0; i < 4; i++) {
                    Tile near = tiles.get(x + Geometry.d4[i].x, y + Geometry.d4[i].y);
                    if (near != null && near.block() != Blocks.air) {
                        break dec;
                    }
                }

                if (rand.chance(0.01) && floor.asFloor().hasSurface() && block == Blocks.air) {
                    block = dec.get(floor, floor.asFloor().decoration);
                }
            }
        });

        float difficulty = sector.threat;
        int ruinCount = rand.random(-2, 4);

        if (ruinCount > 0) {
            IntSeq ints = new IntSeq(width * height / 4);

            int padding = 25;

            //create list of potential positions
            for (int x = padding; x < width - padding; x++) {
                for (int y = padding; y < height - padding; y++) {
                    Tile tile = tiles.getn(x, y);
                    if (!tile.solid() && (tile.drop() != null || tile.floor().liquidDrop != null)) {
                        ints.add(tile.pos());
                    }
                }
            }

            ints.shuffle(rand);

            int placed = 0;
            float diffRange = 0.4f;
            //try each position
            for (int i = 0; i < ints.size && placed < ruinCount; i++) {
                int val = ints.items[i];
                int x = Point2.x(val), y = Point2.y(val);

                //do not overwrite player spawn
                if (Mathf.within(x, y, spawn.x, spawn.y, 18f)) {
                    continue;
                }

                float range = difficulty + rand.random(diffRange);

                Tile tile = tiles.getn(x, y);
                BaseRegistry.BasePart part = null;
                if (tile.overlay().itemDrop != null) {
                    part = bases.forResource(tile.drop()).getFrac(range);
                } else if (tile.floor().liquidDrop != null && rand.chance(0.05)) {
                    part = bases.forResource(tile.floor().liquidDrop).getFrac(range);
                } else if (rand.chance(0.05)) { //ore-less parts are less likely to occur.
                    part = bases.parts.getFrac(range);
                }

                //actually place the part
                if (part != null && BaseGenerator.tryPlace(part, x, y, Team.derelict, rand, (cx, cy) -> {
                    Tile other = tiles.getn(cx, cy);
                    if (other.floor().hasSurface()) {
                        other.setOverlay(Blocks.oreScrap);
                        for (int j = 1; j <= 2; j++) {
                            for (Point2 p : Geometry.d8) {
                                Tile t = tiles.get(cx + p.x * j, cy + p.y * j);
                                if (t != null && t.floor().hasSurface() && rand.chance(j == 1 ? 0.4 : 0.2)) {
                                    t.setOverlay(Blocks.oreScrap);
                                }
                            }
                        }
                    }
                })) {
                    placed++;

                    int debrisRadius = Math.max(part.schematic.width, part.schematic.height) / 2 + 3;
                    Geometry.circle(x, y, tiles.width, tiles.height, debrisRadius, (cx, cy) -> {
                        float dst = Mathf.dst(cx, cy, x, y);
                        float removeChance = Mathf.lerp(0.05f, 0.5f, dst / debrisRadius);

                        Tile other = tiles.getn(cx, cy);
                        if (other.build != null && other.isCenter()) {
                            if (other.team() == Team.derelict && rand.chance(removeChance)) {
                                other.remove();
                            } else if (rand.chance(0.5)) {
                                other.build.health = other.build.health - rand.random(other.build.health * 0.9f);
                            }
                        }
                    });
                }
            }
        }

        //remove invalid ores
        for (Tile tile : tiles) {
            if (tile.overlay().needsSurface && !tile.floor().hasSurface()) {
                tile.setOverlay(Blocks.air);
            }
        }

        Schematics.placeLaunchLoadout(spawn.x, spawn.y);

        for (Room enemySpawn : enemies) {
            tiles.getn(enemySpawn.x, enemySpawn.y).setOverlay(Blocks.spawn);
        }

        if (sector.hasEnemyBase()) {
            baseGenerator.generate(tiles, enemies.map(r -> tiles.getn(r.x, r.y)), tiles.get(spawn.x, spawn.y), state.rules.waveTeam, sector, difficulty);

            state.rules.attackMode = sector.info.attack = true;
        } else {
            state.rules.winWave = sector.info.winWave = 10 + 5 * (int) Math.max(difficulty * 10, 1);
        }

        float waveTimeDec = 0.4f;

        state.rules.waveSpacing = Mathf.lerp(60 * 65 * 2, 60f * 60f * 1f, Math.max(difficulty - waveTimeDec, 0f));
        state.rules.waves = true;
        state.rules.env = sector.planet.defaultEnv;
        state.rules.enemyCoreBuildRadius = 600f;

        //spawn air only when spawn is blocked
        state.rules.spawns = Waves.generate(difficulty, new Rand(sector.id), state.rules.attackMode, state.rules.attackMode && spawner.countGroundSpawns() == 0, naval);
    }

    @Override
    public void postGenerate(Tiles tiles) {
        if (sector.hasEnemyBase()) {
            baseGenerator.postGenerate();

            //spawn air enemies
            if (spawner.countGroundSpawns() == 0) {
                state.rules.spawns = Waves.generate(sector.threat, new Rand(sector.id), state.rules.attackMode, true, false);
            }
        }
    }
}
