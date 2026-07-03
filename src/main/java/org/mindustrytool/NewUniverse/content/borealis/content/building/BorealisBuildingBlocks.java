package org.mindustrytool.NewUniverse.content.borealis.content.building;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisBuildingBlocks {
    private final BorealisItems borealisItems;

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
        }};

        coreCentrum = new CoreBlock("core-centrum") {{
            requirements(Category.effect, ItemStack.with(
                borealisItems.farasAlloy, 200,
                borealisItems.flaxol, 150,
                borealisItems.simus, 100,
                Items.silicon, 80
            ));
            size = 4;
            health = 6000;
            itemCapacity = 8000;
            unitCapModifier = 16;
            thrusterLength = 28f / 4f;
            squareSprite = false;
        }};

        corePreatorium = new CoreBlock("core-preatorium") {{
            requirements(Category.effect, ItemStack.with(
                borealisItems.navitas, 300,
                borealisItems.duras, 250,
                borealisItems.cophalast, 150,
                borealisItems.tentias, 100,
                Items.plastanium, 200,
                Items.surgeAlloy, 100
            ));
            size = 5;
            health = 15000;
            itemCapacity = 15000;
            unitCapModifier = 32;
            thrusterLength = 32f / 4f;
            squareSprite = false;
        }};
    }
}