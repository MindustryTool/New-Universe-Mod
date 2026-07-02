package org.mindustrytool.NewUniverse.content.borealis.erisa;

import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.blocks.production.GenericCrafter;

/**
 * Holds Glacius building blocks: power generators, production crafters, and distribution.
 * Called by {@link ErisaBlocks#loadContent()}.
 */
public class ErisaBuildingBlocks {

    // Power
    public ConsumeGenerator yggdrasilGenerator;
    public PowerGenerator yggdrasilCore;
    public Block yggdrasilArray; // generic Block for multi-region array

    // Production
    public GenericCrafter foundry, refinery, fabricator, assembly;

    // Distribution
    public Conduit conduit;
    public Duct duct;

    private ErisaBuildingBlocks() {}

    public static ErisaBuildingBlocks load(ErisaItems items) {
        var b = new ErisaBuildingBlocks();

        // ── Glacius power ──────────────────────────────────────────────

        b.yggdrasilGenerator = new ConsumeGenerator("yggdrasil-generator") {{
            size = 2;
            powerProduction = 3f;
            itemDuration = 90f;
            consumeItem(items.duras, 1);
            health = 400;
        }};

        b.yggdrasilCore = new PowerGenerator("yggdrasil-core") {{
            size = 4;
            powerProduction = 15f;
            health = 2000;
        }};

        b.yggdrasilArray = new ConsumeGenerator("yggdrasil-array") {{
            size = 3;
            powerProduction = 8f;
            itemDuration = 120f;
            consumeItem(items.navitas, 1);
            health = 1200;
        }};

        // ── Glacius production ─────────────────────────────────────────

        b.foundry = new GenericCrafter("foundry") {{
            size = 2;
            craftTime = 60f;
            outputItem = new ItemStack(items.simus, 1);
            consumeItem(items.duras, 1);
            consumePower(1f);
            health = 300;
        }};

        b.refinery = new GenericCrafter("refinery") {{
            size = 2;
            craftTime = 90f;
            outputItem = new ItemStack(items.ferraloy, 1);
            consumeItems(new ItemStack(items.simus, 2), new ItemStack(items.duras, 1));
            consumePower(2f);
            health = 350;
        }};

        b.fabricator = new GenericCrafter("fabricator") {{
            size = 3;
            craftTime = 120f;
            outputItem = new ItemStack(items.ferraloy, 2);
            consumeItems(
                new ItemStack(items.simus, 3),
                new ItemStack(items.navitas, 1),
                new ItemStack(items.duras, 1)
            );
            consumePower(4f);
            health = 800;
        }};

        b.assembly = new GenericCrafter("assembly") {{
            size = 3;
            craftTime = 150f;
            outputItem = new ItemStack(items.ferraloy, 3);
            consumeItems(
                new ItemStack(items.simus, 4),
                new ItemStack(items.navitas, 2),
                new ItemStack(items.duras, 2)
            );
            consumePower(6f);
            health = 900;
        }};

        // ── Glacius distribution ───────────────────────────────────────

        b.conduit = new Conduit("erisa-conduit") {{
            health = 60;
        }};

        b.duct = new Duct("erisa-duct") {{
            health = 50;
        }};

        return b;
    }
}
