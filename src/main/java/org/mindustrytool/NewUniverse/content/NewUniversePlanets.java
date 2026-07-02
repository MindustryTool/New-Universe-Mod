package org.mindustrytool.NewUniverse.content;

import arc.graphics.Color;
import mindustry.graphics.g3d.HexMesh;
import mindustry.content.Blocks;
import mindustry.content.Planets;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import org.mindustrytool.NewUniverse.planets.NewUniversePlanetGenerator;

public class NewUniversePlanets {

    public static Planet borealisSun;
    public static Planet erisa;

    public static void load() {
        borealisSun = new Planet("borealis", null, 4f, 0) {{
            bloom = true;
            accessible = false;
        }};

        erisa = new Planet("erisa", borealisSun, 1.2f, 4) {{
            generator = new NewUniversePlanetGenerator();
            sectorSeed = 42;
            startSector = 10;
            defaultCore = Blocks.coreShard;
            meshLoader = () -> new HexMesh(erisa, 6);
            accessible = true;
            alwaysUnlocked = true;
            ruleSetter = r -> {
                r.waves = true;
                r.loadout = ItemStack.list(
                    NewUniverseItems.cryoCrystal, 80,
                    NewUniverseItems.frozenIron, 40
                );
            };
            atmosphereRadIn = 0.1f;
            atmosphereRadOut = 0.5f;
            atmosphereColor = Color.valueOf("b07050");
            iconColor = Color.valueOf("b08050");
        }};
    }
}
