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
                            nodeProduce(NewUniverseItems.duras, () -> {
                                nodeProduce(NewUniverseItems.fortial, () -> {
                                    nodeProduce(NewUniverseItems.farasAloy, () -> {
                                        nodeProduce(NewUniverseItems.xearula, () -> {
                                        });
                                    });
                                });
                            });
                            nodeProduce(NewUniverseItems.fabris, () -> {
                                nodeProduce(NewUniverseItems.simus, () -> {
                                    nodeProduce(NewUniverseItems.temperedGlass, () -> {
                                    });
                                });
                            });
                        });
                    });
                    nodeProduce(NewUniverseItems.rudis, () -> {
                        nodeProduce(NewUniverseItems.aurum, () -> {
                            nodeProduce(NewUniverseItems.horani, () -> {
                            });
                        });
                        nodeProduce(NewUniverseItems.navitas, () -> {
                        });
                    });
                });
                nodeProduce(NewUniverseItems.pausis, () -> {
                    nodeProduce(NewUniverseItems.flaxol, () -> {
                    });
                });
            });
            nodeProduce(NewUniverseItems.tentias, () -> {
                nodeProduce(NewUniverseItems.viscosy, () -> {
                    nodeProduce(NewUniverseItems.vastum, () -> {
                    });
                });
            });
            nodeProduce(NewUniverseItems.sand, () -> {
            });
            nodeProduce(NewUniverseItems.cophalast, () -> {
            });

            // ── Blocks (environmental) ────────────────────────────
            node(NewUniverseBlocks.glaciusIceWall);
            node(NewUniverseBlocks.glaciusCrystalWall);
            node(NewUniverseBlocks.glaciusVolcanicWall);

            // ── Ores ──────────────────────────────────────────────
            node(NewUniverseBlocks.oreCophalast);
            node(NewUniverseBlocks.oreDuras);
            node(NewUniverseBlocks.oreNavitas);
            node(NewUniverseBlocks.orePausis);
            node(NewUniverseBlocks.oreVastum);

            // ── Distribution ──────────────────────────────────────
            node(NewUniverseBlocks.glaciusConduit);
            node(NewUniverseBlocks.glaciusDuct);

            // ── Power ─────────────────────────────────────────────
            node(NewUniverseBlocks.glaciusYggdrasilGenerator, () -> {
                node(NewUniverseBlocks.glaciusYggdrasilArray, () -> {
                    node(NewUniverseBlocks.glaciusYggdrasilCore);
                });
            });

            // ── Production ────────────────────────────────────────
            node(NewUniverseBlocks.glaciusFoundry, () -> {
                node(NewUniverseBlocks.glaciusRefinery, () -> {
                    node(NewUniverseBlocks.glaciusFabricator, () -> {
                        node(NewUniverseBlocks.glaciusAssembly);
                    });
                });
            });

            // ── Turrets ───────────────────────────────────────────
            node(NewUniverseBlocks.glaciusMjolnir, () -> {
                node(NewUniverseBlocks.glaciusGramr, () -> {
                    node(NewUniverseBlocks.glaciusHermodr, () -> {
                        node(NewUniverseBlocks.glaciusSvafnir);
                        node(NewUniverseBlocks.glaciusLaevateinn);
                        node(NewUniverseBlocks.glaciusGjallarhorn);
                    });
                    node(NewUniverseBlocks.glaciusGungnir, () -> {
                        node(NewUniverseBlocks.glaciusLopt, () -> {
                            node(NewUniverseBlocks.glaciusNidhoggr);
                        });
                    });
                });
            });

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
