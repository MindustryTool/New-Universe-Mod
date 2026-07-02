package org.mindustrytool.NewUniverse.content.borealis.erisa;

import mindustry.world.blocks.environment.OreBlock;

/**
 * Holds Glacius ore blocks.
 * Called by {@link ErisaBlocks#loadContent()}.
 */
public class ErisaOreBlocks {

    public OreBlock oreCophalast, oreDuras, oreNavitas, orePausis, oreVastum;

    private ErisaOreBlocks() {}

    public static ErisaOreBlocks load(ErisaItems items) {
        var b = new ErisaOreBlocks();

        // ── Glacius ores ───────────────────────────────────────────────

        b.oreCophalast = new OreBlock("ore-cophalast", items.cophalast) {{
            oreThreshold = 0.82f;
            oreScale = 22;
            supportsOverlay = true;
        }};

        b.oreDuras = new OreBlock("ore-duras", items.duras) {{
            oreThreshold = 0.88f;
            oreScale = 20;
            supportsOverlay = true;
        }};

        b.oreNavitas = new OreBlock("ore-navitas", items.navitas) {{
            oreThreshold = 0.85f;
            oreScale = 24;
            supportsOverlay = true;
        }};

        b.orePausis = new OreBlock("ore-pausis", items.pausis) {{
            oreThreshold = 0.9f;
            oreScale = 18;
            supportsOverlay = true;
        }};

        b.oreVastum = new OreBlock("ore-vastum", items.vastum) {{
            oreThreshold = 0.8f;
            oreScale = 26;
            supportsOverlay = true;
        }};

        return b;
    }
}
