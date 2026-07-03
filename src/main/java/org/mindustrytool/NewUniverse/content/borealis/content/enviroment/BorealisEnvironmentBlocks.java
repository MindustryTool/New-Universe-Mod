package org.mindustrytool.NewUniverse.content.borealis.content.enviroment;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.Prop;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisEnvironmentBlocks {

    // test block from omaloon pattern
    public Block testFloor;

    // props (decorative, no collision)
    public Block boulder;
    public Block redBoulder;
    public Block iceBoulder;
    public Block darkblueBoulder;
    public Block darkDirtBoulder;
    public Block redCrystalCluster;
    public Block blueCrystalBlocks;

    public void loadContent() {
        test();
        props();
    }

    private void test() {
        testFloor = new Floor("test-floor", 3) {{ mapColor.set(Color.valueOf("808080")); }};
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
