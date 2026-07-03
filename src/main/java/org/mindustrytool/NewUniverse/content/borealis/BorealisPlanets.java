package org.mindustrytool.NewUniverse.content.borealis;

import arc.graphics.Color;
import lombok.RequiredArgsConstructor;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.graphics.g3d.HexMesh;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import org.mindustrytool.NewUniverse.content.borealis.content.BorealisContents;
import org.mindustrytool.NewUniverse.content.borealis.erisa.ErisaPlanetGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisPlanets {
    private final BorealisContents contents;

    public Planet borealisSun;
    public Planet erisa;

    public void loadContent() {
        borealisSun = new Planet("borealis", null, 4f, 0) {{
            bloom = true;
            accessible = false;
        }};

        ErisaPlanetGenerator gen = new ErisaPlanetGenerator();
        gen.waterBlock = Blocks.water;
        gen.iceFloor = contents.iceFloor;
        gen.stoneFloor = contents.stoneFloor;
        gen.redFloor = contents.redFloor;
        gen.darkDirtFloor = contents.darkDirtFloor;
        gen.darkblueFloor = contents.darkblueFloor;
        gen.blueCrystalFloor = contents.blueCrystalFloor;
        gen.denseBlueCrystalFloor = contents.denseBlueCrystalFloor;
        gen.oreCophalast = contents.oreCophalast;
        gen.oreDuras = contents.oreDuras;
        gen.oreNavitas = contents.oreNavitas;
        gen.oreVastum = contents.oreVastum;
        gen.oreWallPausis = contents.oreWallPausis;
        gen.stoneWall = contents.wallBlock;
        gen.redWall = contents.redWall;
        gen.redDirtWall = contents.redDirtWall;
        gen.iceWall = contents.iceWall;
        gen.darkblueWall = contents.darkblueWall;
        gen.rebuildTerrain();

        erisa = new Planet("erisa", borealisSun, 1.2f, 4) {{
            generator = gen;
            sectorSeed = 42;
            startSector = 10;
            defaultCore = Blocks.coreShard;
            meshLoader = () -> new HexMesh(erisa, 6);
            accessible = true;
            alwaysUnlocked = true;
            ruleSetter = r -> {
                r.waves = true;
                r.loadout = ItemStack.list(
                    Items.copper, 40,
                    Items.lead, 20
                );
            };
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.08f;
            atmosphereColor = Color.valueOf("b07050");
            iconColor = Color.valueOf("b08050");
            updateLighting = false;
        }};
    }
}
