package org.mindustrytool.NewUniverse.content.borealis.erisa;

import arc.graphics.Color;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;

/**
 * Holds Glacius environment blocks: floors and walls.
 * Called by {@link ErisaBlocks#loadContent()}.
 */
public class ErisaEnvironmentBlocks {

    public Floor ice, regolith, permafrost, vent, deepIce, snow, crust, slagIce;
    public StaticWall iceWall, regolithWall, crystalWall, volcanicWall;

    private ErisaEnvironmentBlocks() {}

    public static ErisaEnvironmentBlocks load() {
        var b = new ErisaEnvironmentBlocks();

        // ── Glacius floors ──────────────────────────────────────────────

        b.ice = new Floor("ice") {{
            speedMultiplier = 0.5f;
            variants = 3;
            mapColor = Color.valueOf("c8e0f0");
            supportsOverlay = true;
        }};

        b.regolith = new Floor("regolith") {{
            variants = 3;
            mapColor = Color.valueOf("6b6b6b");
            supportsOverlay = true;
        }};

        b.permafrost = new Floor("permafrost") {{
            variants = 2;
            mapColor = Color.valueOf("8b9bb0");
            supportsOverlay = true;
        }};

        b.vent = new Floor("vent") {{
            variants = 2;
            mapColor = Color.valueOf("d4874a");
            albedo = 0.3f;
            supportsOverlay = true;
        }};

        b.deepIce = new Floor("deep-ice") {{
            speedMultiplier = 0.3f;
            drownTime = 600;
            mapColor = Color.valueOf("7080a0");
            supportsOverlay = true;
        }};

        b.snow = new Floor("snow") {{
            speedMultiplier = 0.4f;
            variants = 4;
            mapColor = Color.valueOf("e8e8f0");
            supportsOverlay = true;
        }};

        b.crust = new Floor("crust") {{
            speedMultiplier = 0.6f;
            variants = 2;
            mapColor = Color.valueOf("b0c8d8");
            supportsOverlay = true;
        }};

        b.slagIce = new Floor("slag-ice") {{
            variants = 2;
            mapColor = Color.valueOf("806050");
            isLiquid = true;
            supportsOverlay = true;
        }};

        // ── Glacius walls ──────────────────────────────────────────────
        // Floor→wall linking via naming convention:
        //   Floor.init() auto-links "ice" → "ice-wall"

        b.iceWall = new StaticWall("ice-wall");
        b.regolithWall = new StaticWall("regolith-wall");
        b.crystalWall = new StaticWall("crystal-wall") {{
            mapColor = Color.valueOf("6080d0");
        }};
        b.volcanicWall = new StaticWall("volcanic-wall") {{
            mapColor = Color.valueOf("785038");
        }};

        return b;
    }
}
