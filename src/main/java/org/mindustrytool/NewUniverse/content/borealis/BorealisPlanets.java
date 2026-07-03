package org.mindustrytool.NewUniverse.content.borealis;

import arc.graphics.Color;
import lombok.RequiredArgsConstructor;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.graphics.g3d.HexMesh;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import org.mindustrytool.NewUniverse.content.borealis.erisa.ErisaPlanetGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisPlanets {
    public Planet borealisSun;
    public Planet erisa;

    public void loadContent() {
        borealisSun = new Planet("borealis", null, 4f, 0) {{
            bloom = true;
            accessible = false;
        }};

        erisa = new Planet("erisa", borealisSun, 1.2f, 4) {{
            generator = new ErisaPlanetGenerator();
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
