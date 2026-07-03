package org.mindustrytool.NewUniverse.content.borealis.content.enviroment;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.Prop;
import mindustry.world.blocks.environment.StaticWall;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisEnvironmentBlocks {

    // floors
    public Block stoneFloor;
    public Block redFloor;
    public Block iceFloor;
    public Block darkblueFloor;
    public Block darkDirtFloor;
    public Block blueCrystalFloor;
    public Block denseBlueCrystalFloor;

    // walls
    public Block wallBlock;
    public Block redWall;
    public Block redDirtWall;
    public Block iceWall;
    public Block darkblueWall;
    public Block blueCrystalWall;

    // props (decorative, no collision)
    public Block boulder;
    public Block redBoulder;
    public Block iceBoulder;
    public Block darkblueBoulder;
    public Block darkDirtBoulder;
    public Block redCrystalCluster;
    public Block blueCrystalBlocks;

    public void loadContent() {
        floors();
        walls();
        props();
    }

    private void floors() {
        stoneFloor = new Floor("stone-floor", 3) {{
            mapColor = Color.valueOf("6b6b6b");
            status = StatusEffects.none;
        }};

        redFloor = new Floor("red-floor", 3) {{
            mapColor = Color.valueOf("b06040");
            status = StatusEffects.none;
        }};

        iceFloor = new Floor("ice-floor", 3) {{
            mapColor = Color.valueOf("b0d0e8");
            status = StatusEffects.freezing;
            statusDuration = 120f;
        }};

        darkblueFloor = new Floor("darkblue-floor", 3) {{
            mapColor = Color.valueOf("304060");
            status = StatusEffects.none;
        }};

        darkDirtFloor = new Floor("dark-dirt-floor", 3) {{
            mapColor = Color.valueOf("4a3a2a");
            status = StatusEffects.none;
        }};

        blueCrystalFloor = new Floor("blue-crystal-floor", 4) {{
            mapColor = Color.valueOf("4080c0");
            status = StatusEffects.none;
        }};

        denseBlueCrystalFloor = new Floor("dense-blue-crystal-floor", 4) {{
            mapColor = Color.valueOf("2060a0");
            status = StatusEffects.none;
        }};
    }

    private void walls() {
        wallBlock = new StaticWall("stone-wall") {{
            variants = 3;
        }};

        redWall = new StaticWall("red-wall") {{
            variants = 3;
        }};

        redDirtWall = new StaticWall("red-dirt-wall") {{
            variants = 3;
        }};

        iceWall = new StaticWall("ice-wall") {{
            variants = 3;
        }};

        darkblueWall = new StaticWall("darkblue-wall") {{
            variants = 3;
        }};

        blueCrystalWall = new StaticWall("blue-crystal-wall") {{
            variants = 3;
        }};
    }

    private void props() {
        boulder = new Prop("boulder") {{ variants = 3; }};
        redBoulder = new Prop("red-boulder") {{ variants = 3; }};
        iceBoulder = new Prop("ice-boulder") {{ variants = 3; }};
        darkblueBoulder = new Prop("darkblue-boulder") {{ variants = 3; }};
        darkDirtBoulder = new Prop("dark-dirt-boulder") {{ variants = 3; }};
        redCrystalCluster = new Prop("red-crystal-cluster") {{ variants = 3; }};
        blueCrystalBlocks = new Prop("blue-crystal-blocks") {{ variants = 3; }};
    }
}
