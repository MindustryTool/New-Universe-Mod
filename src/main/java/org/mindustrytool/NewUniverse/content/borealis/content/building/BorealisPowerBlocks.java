package org.mindustrytool.NewUniverse.content.borealis.content.building;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;

import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;
import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisLiquids;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisPowerBlocks {
    private final BorealisItems items;
    private final BorealisLiquids liquids;

    public Block runeGenerator;
    public Block crystalReactor;
    public Block bifrostArray;
    public Block yggdrasilCore;
    public Block runeCapacitor;
    public Block powerNode;
    public Block powerNodeLarge;

    public void loadContent() {
        runeGenerator = new ConsumeGenerator("rune-generator") {{
            requirements(Category.power, ItemStack.with(items.simus, 15, items.flaxol, 10));
            size = 2;
            health = 160;
            powerProduction = 60f;
            itemDuration = 60f;
            consumeItem(items.pausis);
            generateEffect = mindustry.content.Fx.generatespark;
        }};

        crystalReactor = new ConsumeGenerator("crystal-reactor") {{
            requirements(Category.power, ItemStack.with(items.farasAlloy, 30, items.navitas, 20));
            size = 3;
            health = 480;
            powerProduction = 180f;
            itemDuration = 90f;
            hasLiquids = true;
            consumeItem(items.vastum);
            consumeLiquid(liquids.barbavior, 0.1f);
            generateEffect = mindustry.content.Fx.generatespark;
        }};

        bifrostArray = new SolarGenerator("bifrost-array") {{
            requirements(Category.power, ItemStack.with(items.farasAlloy, 40, items.flaxol, 30, items.temperedGlass, 20));
            size = 3;
            powerProduction = 60f;
        }};

        yggdrasilCore = new ConsumeGenerator("yggdrasil-core") {{
            requirements(Category.power, ItemStack.with(items.duras, 50, items.navitas, 50, items.cophalast, 20));
            size = 4;
            health = 1280;
            powerProduction = 600f;
            itemDuration = 120f;
            consumeItem(items.cophalast);
            generateEffect = mindustry.content.Fx.generatespark;
        }};

        runeCapacitor = new Battery("rune-capacitor") {{
            requirements(Category.power, ItemStack.with(items.simus, 10, items.flaxol, 10));
            size = 2;
            health = 120;
            consumePowerBuffered(5000f);
        }};

        powerNode = new PowerNode("power-node") {{
            requirements(Category.power, ItemStack.with(items.simus, 2));
            size = 1;
            health = 40;
            maxNodes = 10;
            laserRange = 40f;
        }};

        powerNodeLarge = new PowerNode("power-node-large") {{
            requirements(Category.power, ItemStack.with(items.farasAlloy, 8, items.simus, 4));
            size = 2;
            health = 160;
            maxNodes = 20;
            laserRange = 80f;
        }};
    }
}
