package org.mindustrytool.NewUniverse.content.borealis.content.building;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.DuctBridge;
import mindustry.world.blocks.distribution.DuctRouter;
import mindustry.world.blocks.distribution.OverflowDuct;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidJunction;
import mindustry.world.blocks.liquid.LiquidRouter;

import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisDistributionBlocks {
    private final BorealisItems borealisItems;

    public Block conduit;
    public Block conduitRouter;
    public Block conduitJunction;
    public Block conduitBridge;
    public Block liquidContainer;
    public Block liquidTank;
    public Block duct;
    public Block armoredDuct;
    public Block ductRouter;
    public Block ductBridge;
    public Block overflowDuct;
    public Block unoverflowDuct;

    public void loadContent() {
        conduit = new Conduit("conduit") {{
            requirements(Category.liquid, ItemStack.with(
                borealisItems.fabris, 1
            ));
            health = 45;
        }};

        conduitRouter = new LiquidRouter("conduit-router") {{
            requirements(Category.liquid, ItemStack.with(
                borealisItems.fabris, 4,
                borealisItems.simus, 2
            ));
            liquidCapacity = 20f;
        }};

        conduitJunction = new LiquidJunction("conduit-junction") {{
            requirements(Category.liquid, ItemStack.with(
                borealisItems.fabris, 2,
                borealisItems.simus, 2
            ));
        }};

        conduitBridge = new LiquidBridge("conduit-bridge") {{
            requirements(Category.liquid, ItemStack.with(
                borealisItems.fabris, 4,
                borealisItems.simus, 8
            ));
            range = 4;
            hasPower = false;
        }};

        liquidContainer = new LiquidRouter("liquid-container") {{
            requirements(Category.liquid, ItemStack.with(
                borealisItems.farasAlloy, 10,
                borealisItems.simus, 15
            ));
            liquidCapacity = 700f;
            size = 2;
            solid = true;
        }};

        liquidTank = new LiquidRouter("liquid-tank") {{
            requirements(Category.liquid, ItemStack.with(
                borealisItems.farasAlloy, 25,
                borealisItems.simus, 25
            ));
            size = 3;
            liquidCapacity = 1500f;
            health = 500;
            solid = true;
        }};

        duct = new Duct("duct") {{
            requirements(Category.distribution, ItemStack.with(
                borealisItems.farasAlloy, 1
            ));
            health = 90;
            speed = 4f;
        }};

        armoredDuct = new Duct("armored-duct") {{
            requirements(Category.distribution, ItemStack.with(
                borealisItems.farasAlloy, 2,
                borealisItems.navitas, 1
            ));
            health = 140;
            speed = 4f;
            armored = true;
        }};

        ductRouter = new DuctRouter("duct-router") {{
            requirements(Category.distribution, ItemStack.with(
                borealisItems.farasAlloy, 4,
                borealisItems.cophalast, 2
            ));
            health = 90;
            speed = 4f;
        }};

        ductBridge = new DuctBridge("duct-bridge") {{
            requirements(Category.distribution, ItemStack.with(
                borealisItems.farasAlloy, 15
            ));
            health = 90;
            speed = 4f;
        }};

        overflowDuct = new OverflowDuct("overflow-duct") {{
            requirements(Category.distribution, ItemStack.with(
                borealisItems.cophalast, 8,
                borealisItems.farasAlloy, 8
            ));
            health = 90;
            speed = 4f;
        }};

        unoverflowDuct = new OverflowDuct("unoverflow-duct") {{
            requirements(Category.distribution, ItemStack.with(
                borealisItems.cophalast, 8,
                borealisItems.farasAlloy, 8
            ));
            health = 90;
            speed = 4f;
            invert = true;
        }};
    }
}
