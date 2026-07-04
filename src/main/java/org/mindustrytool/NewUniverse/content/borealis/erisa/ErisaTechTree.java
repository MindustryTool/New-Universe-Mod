package org.mindustrytool.NewUniverse.content.borealis.erisa;

import mindustry.content.TechTree;
import mindustry.type.ItemStack;

import org.mindustrytool.NewUniverse.content.borealis.content.BorealisContents;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ErisaTechTree {
    private final BorealisContents content;

    public void loadContent() {
        TechTree.nodeRoot("erisa", content.coreBasis, () -> {
            // T1 - MIDGARD: foundation
            TechTree.node(content.rootDrill, () -> {
                TechTree.node(content.oreRudis, () -> {});
                TechTree.node(content.oreSand, () -> {});
                TechTree.node(content.stoneRampart, () -> {});
            });

            TechTree.node(content.runeForge, () -> {
                TechTree.node(content.alfKiln, () -> {});
                TechTree.node(content.flaxolCrucible, () -> {
                    TechTree.node(content.powerNode, () -> {});
                });
            });

            TechTree.nodeProduce(content.simus, () -> {
                TechTree.nodeProduce(content.temperedGlass, () -> {});
                TechTree.nodeProduce(content.flaxol, () -> {});
            });

            // T2 - SVARTALFHEIM: crafting
            TechTree.node(content.dwarfAnvil, () -> {
                TechTree.node(content.farasSmelter, () -> {
                    TechTree.node(content.runeGenerator, () -> {
                        TechTree.node(content.runeCapacitor, () -> {});
                        TechTree.node(content.powerNodeLarge, () -> {});
                    });
                });
            });

            TechTree.nodeProduce(content.fabris, () -> {});
            TechTree.nodeProduce(content.farasAlloy, () -> {});

            TechTree.node(content.dwarfBorer, () -> {});

            // T3 - VANAHEIM: liquid phase
            TechTree.node(content.seidrCauldron, () -> {
                TechTree.node(content.aetherForge, () -> {
                    TechTree.node(content.alloyBulwark, () -> {});
                });
            });

            TechTree.nodeProduce(content.tentias, () -> {});
            TechTree.nodeProduce(content.navitas, () -> {});

            TechTree.node(content.crystalReactor, () -> {});
            TechTree.node(content.bifrostArray, () -> {});

            // T4 - JOTUNHEIM: heavy forging
            TechTree.node(content.aesirResonator, () -> {
                TechTree.node(content.bifrostExtractor, () -> {});
            });

            TechTree.nodeProduce(content.duras, () -> {});

            TechTree.node(content.tentiasBarrier, () -> {});

            // T5 - ASGARD: divine
            TechTree.node(content.odinsForge, () -> {
                TechTree.node(content.yggdrasilCore, () -> {});
            });

            TechTree.nodeProduce(content.cophalast, () -> {});
        });
    }
}
