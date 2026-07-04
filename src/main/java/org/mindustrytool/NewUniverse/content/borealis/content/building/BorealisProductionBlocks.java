package org.mindustrytool.NewUniverse.content.borealis.content.building;

import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;

import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;
import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisLiquids;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisProductionBlocks {
    private final BorealisItems items;
    private final BorealisLiquids liquids;

    // TIER 1 - MIDGARD

    public Block runeForge;

    public Block alfKiln;
    public Block flaxolCrucible;

    public Block dwarfAnvil;
    public Block farasSmelter;

    public Block seidrCauldron;
    public Block aetherForge;

    public Block aesirResonator;
    public Block odinsForge;

    public void loadContent() {
        runeForge = new GenericCrafter("rune-forge") {{
            requirements(Category.crafting, ItemStack.with(items.rudis, 30, items.pausis, 10));
            size = 2;
            craftTime = 60f;
            hasPower = true;
            hasItems = true;
            consumePower(1f);
            consumeItems(ItemStack.with(items.rudis, 3, items.pausis, 1));
            outputItem = new ItemStack(items.simus, 2);
            craftEffect = Fx.none;
            updateEffect = Fx.none;
        }};

        alfKiln = new GenericCrafter("alf-kiln") {{
            requirements(Category.crafting, ItemStack.with(items.sand, 30));
            size = 2;
            craftTime = 45f;
            hasPower = true;
            hasItems = true;
            consumePower(1.5f);
            consumeItems(ItemStack.with(items.sand, 3));
            outputItem = new ItemStack(items.temperedGlass, 2);
            craftEffect = Fx.none;
        }};

        flaxolCrucible = new GenericCrafter("flaxol-crucible") {{
            requirements(Category.crafting, ItemStack.with(items.sand, 30, items.pausis, 15));
            size = 2;
            craftTime = 75f;
            hasPower = true;
            hasItems = true;
            consumePower(1.2f);
            consumeItems(ItemStack.with(items.sand, 3, items.pausis, 1));
            outputItem = new ItemStack(items.flaxol, 2);
            craftEffect = Fx.none;
        }};

        dwarfAnvil = new GenericCrafter("dwarf-anvil") {{
            requirements(Category.crafting, ItemStack.with(items.simus, 30, items.temperedGlass, 20));
            size = 2;
            craftTime = 90f;
            hasPower = true;
            hasItems = true;
            consumePower(2f);
            consumeItems(ItemStack.with(items.simus, 2, items.temperedGlass, 1));
            outputItem = new ItemStack(items.fabris, 2);
            craftEffect = Fx.none;
        }};

        farasSmelter = new GenericCrafter("faras-smelter") {{
            requirements(Category.crafting, ItemStack.with(items.simus, 20, items.flaxol, 20));
            size = 2;
            craftTime = 80f;
            hasPower = true;
            hasItems = true;
            consumePower(2.5f);
            consumeItems(ItemStack.with(items.simus, 1, items.flaxol, 1));
            outputItem = new ItemStack(items.farasAlloy, 2);
            craftEffect = Fx.none;
        }};

        seidrCauldron = new GenericCrafter("seidr-cauldron") {{
            requirements(Category.crafting, ItemStack.with(items.fabris, 30, items.vastum, 20));
            size = 3;
            craftTime = 120f;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            consumePower(3f);
            consumeItems(ItemStack.with(items.fabris, 2, items.vastum, 1));
            consumeLiquid(liquids.barbavior, 0.3f);
            outputItem = new ItemStack(items.tentias, 1);
            craftEffect = Fx.none;
        }};

        aetherForge = new GenericCrafter("aether-forge") {{
            requirements(Category.crafting, ItemStack.with(items.farasAlloy, 40, items.fabris, 20));
            size = 3;
            craftTime = 110f;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            consumePower(3.5f);
            consumeItems(ItemStack.with(items.farasAlloy, 2, items.fabris, 1));
            consumeLiquid(liquids.horani, 0.2f);
            outputItem = new ItemStack(items.navitas, 2);
            craftEffect = Fx.none;
        }};

        aesirResonator = new GenericCrafter("aesir-resonator") {{
            requirements(Category.crafting, ItemStack.with(items.navitas, 50, items.tentias, 30, items.farasAlloy, 30));
            size = 3;
            craftTime = 150f;
            hasPower = true;
            hasItems = true;
            consumePower(5f);
            consumeItems(ItemStack.with(items.navitas, 2, items.tentias, 1, items.farasAlloy, 1));
            outputItem = new ItemStack(items.duras, 2);
            craftEffect = Fx.none;
        }};

        odinsForge = new GenericCrafter("odins-forge") {{
            requirements(Category.crafting, ItemStack.with(items.duras, 60, items.navitas, 60, items.tentias, 40));
            size = 4;
            craftTime = 240f;
            hasPower = true;
            hasItems = true;
            consumePower(10f);
            consumeItems(ItemStack.with(items.duras, 2, items.navitas, 2, items.tentias, 1));
            outputItem = new ItemStack(items.cophalast, 2);
            craftEffect = Fx.none;
        }};
    }
}
