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
            // ── Item progression ──────────────────────────────────
            nodeProduce(erisaItems.duras, () -> {
                nodeProduce(erisaItems.rudis, () -> {
                    nodeProduce(erisaItems.simus, () -> {
                        nodeProduce(erisaItems.ferraloy, () -> {
                            nodeProduce(erisaItems.fortial, () -> {
                                nodeProduce(erisaItems.xearula, () -> {
                                });
                            });
                        });
                        nodeProduce(erisaItems.fabris, () -> {
                            nodeProduce(erisaItems.temperedGlass, () -> {
                            });
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
                nodeProduce(erisaItems.navitas, () -> {
                    nodeProduce(erisaItems.cophalast, () -> {
                    });
                    nodeProduce(erisaItems.horani, () -> {
                    });
                });
                nodeProduce(erisaItems.aurum, () -> {
                });
            });
            nodeProduce(erisaItems.pausis, () -> {
                nodeProduce(erisaItems.flaxol, () -> {
                });
            });

            // ── Blocks (environmental) ────────────────────────────
            node(erisaBlocks.iceWall);
            node(erisaBlocks.crystalWall);
            node(erisaBlocks.regolithWall);
            node(erisaBlocks.volcanicWall);

            // ── Ores ──────────────────────────────────────────────
            node(erisaBlocks.oreCophalast);
            node(erisaBlocks.oreDuras);
            node(erisaBlocks.oreNavitas);
            node(erisaBlocks.orePausis);
            node(erisaBlocks.oreVastum);

            // ── Distribution ──────────────────────────────────────
            node(erisaBlocks.conduit);
            node(erisaBlocks.duct);

            // ── Power ─────────────────────────────────────────────
            node(erisaBlocks.yggdrasilGenerator, () -> {
                node(erisaBlocks.yggdrasilArray, () -> {
                    node(erisaBlocks.yggdrasilCore);
                });
            });

            // ── Production ────────────────────────────────────────
            node(erisaBlocks.foundry, () -> {
                node(erisaBlocks.refinery, () -> {
                    node(erisaBlocks.fabricator, () -> {
                        node(erisaBlocks.assembly);
                    });
                });
            });

            // ── Turrets ───────────────────────────────────────────
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

            // ── Air tier units (Norse valkyries) ──────────────────
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

            // ── Flying-2 Attacker (Glacius Fenrir line) ──────────
            node(erisaUnitTypes.fenrir, () -> {
                node(erisaUnitTypes.garmr, () -> {
                    node(erisaUnitTypes.draugr, () -> {
                        node(erisaUnitTypes.ragnar, () -> {
                        });
                    });
                });
            });

            // ── Flying-3 Attacker (Diphda line) ──────────────────
            node(erisaUnitTypes.diphda, () -> {
                node(erisaUnitTypes.procyon, () -> {
                    node(erisaUnitTypes.sirius, () -> {
                    });
                });
            });

            // ── Supporter line (Norse gods) ──────────────────────
            node(erisaUnitTypes.mimir, () -> {
                node(erisaUnitTypes.hermodr, () -> {
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

            // ── Mech tier units (Jotunn giants) ──────────────────
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

            // ── Core ground (Einherjar — Valhalla warriors) ──────
            node(erisaUnitTypes.einherjar, () -> {
                node(erisaUnitTypes.berserkr, () -> {
                    node(erisaUnitTypes.ulfhednar, () -> {
                    });
                });
            });

            // ── Naval tier units ──────────────────────────────────
            node(erisaUnitTypes.aegir, () -> {
                node(erisaUnitTypes.ran, () -> {
                    node(erisaUnitTypes.njordr, () -> {
                        node(erisaUnitTypes.jormun, () -> {
                            node(erisaUnitTypes.lyngbakr, () -> {
                                node(erisaUnitTypes.cetus, () -> {
                                });
                            });
                        });
                    });
                });
            });
        });
    }
}
