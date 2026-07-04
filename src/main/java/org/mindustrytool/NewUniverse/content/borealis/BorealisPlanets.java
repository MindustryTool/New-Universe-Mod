package org.mindustrytool.NewUniverse.content.borealis;

import arc.graphics.Color;
import arc.struct.Seq;
import arc.struct.StringMap;
import lombok.RequiredArgsConstructor;
import mindustry.game.Schematic;
import mindustry.game.Schematic.Stile;
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
    private final ErisaPlanetGenerator erisaPlanetGenerator;

    private final BorealisContents contents;

    public Planet borealisSun;
    public Planet erisa;

    public void loadContent() {
        borealisSun = new Planet("borealis", null, 4f, 0) {{
            bloom = true;
            accessible = false;
        }};

        erisaPlanetGenerator.init(contents);

        erisa = new Planet("Erisa", borealisSun, 1f, 3) {{
            generator = erisaPlanetGenerator;
            meshLoader = () -> new HexMesh(erisa, 6);
            accessible = true;
            alwaysUnlocked = true;
            ruleSetter = r -> {
                r.waves = true;
                r.loadout = ItemStack.list(
                    contents.rudis, 30,
                    contents.sand, 20
                );
            };
            startSector = 15;
            defaultCore = contents.coreBasis;
            iconColor = Color.valueOf("b08050");
            landCloudColor = Color.blue.cpy().a(0.3F);
            atmosphereColor = Color.blue.cpy().a(0.7F);
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
        }};

        erisaPlanetGenerator.erisaPlanet = erisa;
        erisaPlanetGenerator.defaultLoadout = new Schematic(
            Seq.with(new Stile(contents.coreBasis, 0, 0, null, (byte)0)),
            new StringMap(),
            contents.coreBasis.size,
            contents.coreBasis.size
        );
    }
}
