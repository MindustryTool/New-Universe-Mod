package org.mindustrytool.NewUniverse.content.borealis.erisa;

import lombok.RequiredArgsConstructor;
import org.mindustrytool.NewUniverse.content.borealis.BorealisPlanets;

import javax.inject.Inject;
import javax.inject.Singleton;

import static mindustry.content.TechTree.*;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ErisaTechTree {
    private final ErisaItems erisaItems;
    private final ErisaBlocks erisaBlocks;
    private final ErisaUnitTypes erisaUnitTypes;

    private final BorealisPlanets borealisPlanets;

    public void loadContent() {
        borealisPlanets.erisa.techTree = nodeRoot("erisa", borealisPlanets.erisa, () -> {
            // ── Environmental blocks (always available) ─────────
            node(erisaBlocks.iceWall);
            node(erisaBlocks.crystalWall);
            node(erisaBlocks.regolithWall);
            node(erisaBlocks.volcanicWall);

            node(erisaBlocks.oreCophalast);
            node(erisaBlocks.oreDuras);
            node(erisaBlocks.oreNavitas);
            node(erisaBlocks.orePausis);
            node(erisaBlocks.oreVastum);

            // ── Basic infrastructure ────────────────────────────
            node(erisaBlocks.conduit);
            node(erisaBlocks.duct);

            // ── Tech tree — items gate blocks ───────────────────
            // Progression: mine duras → foundry → simus → turrets + refinery
            nodeProduce(erisaItems.duras, () -> {
                // Production: duras → foundry → simus
                node(erisaBlocks.foundry, () -> {
                    nodeProduce(erisaItems.simus, () -> {
                        // Turrets (simus ammo)
                        node(erisaBlocks.mjolnir, () -> {
                            node(erisaBlocks.gramr, () -> {
                                node(erisaBlocks.hermodr, () -> {
                                    node(erisaBlocks.svafnir);
                                    node(erisaBlocks.laevateinn);
                                    node(erisaBlocks.gjallarhorn);
                                });
                                node(erisaBlocks.gungnir, () -> {
                                    node(erisaBlocks.lopt, () -> {
                                        node(erisaBlocks.nidhoggr);
                                    });
                                });
                            });
                        });
                        // Advanced production: simus + duras → ferraloy
                        node(erisaBlocks.refinery, () -> {
                            nodeProduce(erisaItems.ferraloy, () -> {
                                node(erisaBlocks.fabricator, () -> {
                                    node(erisaBlocks.assembly);
                                });
                                nodeProduce(erisaItems.fortial, () -> {
                                    nodeProduce(erisaItems.xearula, () -> {
                                    });
                                });
                            });
                        });
                    });
                });
                // Basic power: duras → yggdrasil-generator
                node(erisaBlocks.yggdrasilGenerator, () -> {
                    node(erisaBlocks.yggdrasilArray, () -> {
                        node(erisaBlocks.yggdrasilCore);
                    });
                });
                // Raw item chain
                nodeProduce(erisaItems.rudis, () -> {
                    nodeProduce(erisaItems.fabris, () -> {
                        nodeProduce(erisaItems.temperedGlass, () -> {
                        });
                    });
                    nodeProduce(erisaItems.sand, () -> {
                    });
                    nodeProduce(erisaItems.tentias, () -> {
                        nodeProduce(erisaItems.viscosy, () -> {
                            nodeProduce(erisaItems.vastum, () -> {
                            });
                        });
                    });
                });
            });

            // Fuel: navitas → cophalast, horani
            nodeProduce(erisaItems.navitas, () -> {
                nodeProduce(erisaItems.cophalast, () -> {
                });
                nodeProduce(erisaItems.horani, () -> {
                });
            });

            // Cryo: pausis → flaxol
            nodeProduce(erisaItems.pausis, () -> {
                nodeProduce(erisaItems.flaxol, () -> {
                });
            });

            // Precious: aurum
            nodeProduce(erisaItems.aurum, () -> {
            });

            // ── Unit lines ──────────────────────────────────────────
            // Air tier (Norse valkyries)
            node(erisaUnitTypes.herja, () -> {
                node(erisaUnitTypes.eir, () -> {
                    node(erisaUnitTypes.hlokk, () -> {
                        node(erisaUnitTypes.gondul, () -> {
                            node(erisaUnitTypes.skogul, () -> {
                                node(erisaUnitTypes.spearhead, () -> {
                                });
                            });
                        });
                    });
                });
            });

            // Flying-2 Attacker (Fenrir line)
            node(erisaUnitTypes.fenrir, () -> {
                node(erisaUnitTypes.garmr, () -> {
                    node(erisaUnitTypes.draugr, () -> {
                        node(erisaUnitTypes.ragnar, () -> {
                        });
                    });
                });
            });

            // Flying-3 Attacker (Diphda line)
            node(erisaUnitTypes.diphda, () -> {
                node(erisaUnitTypes.procyon, () -> {
                    node(erisaUnitTypes.sirius, () -> {
                    });
                });
            });

            // Supporter line (Norse gods)
            node(erisaUnitTypes.mimir, () -> {
                node(erisaUnitTypes.hermodrUnit, () -> {
                    node(erisaUnitTypes.bragi, () -> {
                        node(erisaUnitTypes.forseti, () -> {
                            node(erisaUnitTypes.tyr, () -> {
                                node(erisaUnitTypes.vidarr, () -> {
                                });
                            });
                        });
                    });
                });
            });

            // Mech tier (Jotunn giants)
            node(erisaUnitTypes.jotunn, () -> {
                node(erisaUnitTypes.ymir, () -> {
                    node(erisaUnitTypes.thrymr, () -> {
                        node(erisaUnitTypes.bergelmir, () -> {
                            node(erisaUnitTypes.surtr, () -> {
                                node(erisaUnitTypes.altiar, () -> {
                                });
                            });
                        });
                    });
                });
            });

            // Core ground (Einherjar)
            node(erisaUnitTypes.einherjar, () -> {
                node(erisaUnitTypes.berserkr, () -> {
                    node(erisaUnitTypes.ulfhednar, () -> {
                    });
                });
            });

            // Naval tier
            node(erisaUnitTypes.aegir, () -> {
                node(erisaUnitTypes.ran, () -> {
                    node(erisaUnitTypes.njordr, () -> {
                        node(erisaUnitTypes.jormun, () -> {
                            node(erisaUnitTypes.lyngbakr, () -> {
                            });
                        });
                    });
                });
            });
        });
    }
}
