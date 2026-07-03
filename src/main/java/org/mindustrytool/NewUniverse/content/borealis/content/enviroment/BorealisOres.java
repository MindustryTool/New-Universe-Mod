package org.mindustrytool.NewUniverse.content.borealis.content.enviroment;

import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;

import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisOres {
    private final BorealisItems borealisItems;

    public Block oreCophalast;
    public Block oreDuras;
    public Block oreNavitas;
    public Block oreVastum;
    public Block oreWallPausis;

    public void loadContent() {
        oreCophalast = new OreBlock("ore-cophalast", borealisItems.cophalast) {{
            variants = 3;
            oreDefault = true;
        }};

        oreDuras = new OreBlock("ore-duras", borealisItems.duras) {{
            variants = 3;
            oreDefault = true;
        }};

        oreNavitas = new OreBlock("ore-navitas", borealisItems.navitas) {{
            variants = 3;
            oreDefault = true;
        }};

        oreVastum = new OreBlock("ore-vastum", borealisItems.vastum) {{
            variants = 3;
            oreDefault = true;
        }};

        oreWallPausis = new OreBlock("ore-wall-pausis", borealisItems.pausis) {{
            variants = 3;
            oreDefault = true;
        }};
    }
}
