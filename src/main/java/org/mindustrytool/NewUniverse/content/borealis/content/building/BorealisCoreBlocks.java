package org.mindustrytool.NewUniverse.content.borealis.content.building;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.air.BorealisCoreUnitTypes;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisCoreBlocks {
    private final BorealisItems borealisItems;
    private final BorealisCoreUnitTypes coreUnits;

    public Block coreBasis;
    public Block coreCentrum;
    public Block corePreatorium;

    public void loadContent() {
        coreBasis = new CoreBlock("core-basis") {{
            requirements(Category.effect, ItemStack.with(
                    borealisItems.rudis, 80,
                    borealisItems.sand, 40
            ));
            alwaysUnlocked = true;
            size = 3;
            health = 2000;
            itemCapacity = 4000;
            unitCapModifier = 8;
            thrusterLength = 24f / 4f;
            squareSprite = false;
            unitType = coreUnits.miles;
        }};

        coreCentrum = new CoreBlock("core-centrum") {{
            requirements(Category.effect, ItemStack.with(
                    borealisItems.farasAlloy, 200,
                    borealisItems.flaxol, 150,
                    borealisItems.simus, 100,
                    borealisItems.temperedGlass, 80
            ));
            size = 4;
            health = 6000;
            itemCapacity = 8000;
            unitCapModifier = 16;
            thrusterLength = 28f / 4f;
            squareSprite = false;
            unitType = coreUnits.caesar;
        }};

        corePreatorium = new CoreBlock("core-preatorium") {{
            requirements(Category.effect, ItemStack.with(
                    borealisItems.navitas, 300,
                    borealisItems.duras, 250,
                    borealisItems.cophalast, 150,
                    borealisItems.tentias, 100,
                    borealisItems.fabris, 200,
                    borealisItems.flaxol, 100
            ));
            size = 5;
            health = 15000;
            itemCapacity = 15000;
            unitCapModifier = 32;
            thrusterLength = 32f / 4f;
            squareSprite = false;
            unitType = coreUnits.imperium;
        }};
    }
}
