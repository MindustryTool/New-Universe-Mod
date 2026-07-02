package org.mindustrytool.NewUniverse.content;

import static mindustry.content.TechTree.*;

public class NewUniverseTechTree {

    public static void load() {
        NewUniversePlanets.erisa.techTree = nodeRoot("erisa", NewUniversePlanets.erisa, () -> {
            // ── Item progression ──────────────────────────────────
            nodeProduce(NewUniverseItems.cryoCrystal, () -> {
                nodeProduce(NewUniverseItems.frozenIron, () -> {
                    nodeProduce(NewUniverseItems.volcanicSulfur, () -> {
                        nodeProduce(NewUniverseItems.cryoAlloy, () -> {
                        });
                    });
                });
            });

            // ── Blocks (environmental) ────────────────────────────
            node(NewUniverseBlocks.glaciusIceWall);
            node(NewUniverseBlocks.glaciusCrystalWall);
            node(NewUniverseBlocks.glaciusVolcanicWall);

            // ── Air tier units ────────────────────────────────────
            node(NewUniverseUnitTypes.glaciusHerja, () -> {
                node(NewUniverseUnitTypes.glaciusEir, () -> {
                    node(NewUniverseUnitTypes.glaciusHlokk, () -> {
                        node(NewUniverseUnitTypes.glaciusGondul, () -> {
                            node(NewUniverseUnitTypes.glaciusSkogul, () -> {
                                node(NewUniverseUnitTypes.spearhead, () -> {
                                });
                            });
                        });
                    });
                });
            });

            // ── Mech tier units ───────────────────────────────────
            node(NewUniverseUnitTypes.glaciusJotunn, () -> {
                node(NewUniverseUnitTypes.glaciusYmir, () -> {
                    node(NewUniverseUnitTypes.glaciusThrymr, () -> {
                        node(NewUniverseUnitTypes.glaciusBergelmir, () -> {
                            node(NewUniverseUnitTypes.glaciusSurtr, () -> {
                                node(NewUniverseUnitTypes.altiar, () -> {
                                });
                            });
                        });
                    });
                });
            });

            // ── Naval tier units ──────────────────────────────────
            node(NewUniverseUnitTypes.glaciusAegir, () -> {
                node(NewUniverseUnitTypes.glaciusRan, () -> {
                    node(NewUniverseUnitTypes.glaciusNjordr, () -> {
                        node(NewUniverseUnitTypes.glaciusJormun, () -> {
                            node(NewUniverseUnitTypes.glaciusLyngbakr, () -> {
                                node(NewUniverseUnitTypes.cetus, () -> {
                                });
                            });
                        });
                    });
                });
            });
        });
    }
}
