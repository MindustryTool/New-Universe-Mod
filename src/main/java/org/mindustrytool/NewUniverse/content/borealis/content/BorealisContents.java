package org.mindustrytool.NewUniverse.content.borealis.content;

import mindustry.type.Item;
import mindustry.type.UnitType;
import mindustry.world.Block;
import org.mindustrytool.NewUniverse.content.borealis.content.building.BorealisCoreBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.building.BorealisDistributionBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.building.BorealisPowerBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.building.BorealisProductionBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.building.BorealisTurretBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.enviroment.BorealisEnvironmentBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.enviroment.BorealisOres;
import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;
import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisLiquids;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.air.BorealisCoreUnitTypes;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.air.BorealisDiphdaUnitTypes;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.air.BorealisJuniorUnitTypes;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.air.BorealisVeggvisUnitTypes;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.ground.BorealisNoaUnitTypes;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.naval.BorealisIndusUnitTypes;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisContents {

    private final BorealisItems items;
    private final BorealisLiquids liquids;
    private final BorealisIndusUnitTypes naval;
    private final BorealisNoaUnitTypes ground;
    private final BorealisCoreUnitTypes core;
    private final BorealisVeggvisUnitTypes veggvis;
    private final BorealisJuniorUnitTypes junior;
    private final BorealisDiphdaUnitTypes air;
    private final BorealisCoreBlocks coreBlocks;
    private final BorealisDistributionBlocks distributionBlocks;
    private final BorealisPowerBlocks powerBlocks;
    private final BorealisProductionBlocks productionBlocks;
    private final BorealisTurretBlocks turretBlocks;
    private final BorealisEnvironmentBlocks environmentBlocks;
    private final BorealisOres ores;

    // items
    public Item cophalast;

    // liquids
    public mindustry.type.Liquid barbavior;
    public mindustry.type.Liquid fortial;
    public mindustry.type.Liquid horani;

    public Item duras;
    public Item fabris;
    public Item farasAlloy;
    public Item flaxol;
    public Item navitas;
    public Item pausis;
    public Item rudis;
    public Item sand;
    public Item simus;
    public Item temperedGlass;
    public Item tentias;
    public Item vastum;

    // core air units
    public UnitType miles;
    public UnitType caesar;
    public UnitType imperium;

    // attacker units
    public UnitType veggvisUnit;
    public UnitType hermod;
    public UnitType valkyrie;
    public UnitType odin;
    public UnitType ragnarok;

    // supporter units
    public UnitType juniorUnit;
    public UnitType centia;
    public UnitType veralia;
    public UnitType impetuo;
    public UnitType auxiol;
    public UnitType prider;

    // air units
    public UnitType diphda;
    public UnitType procyon;
    public UnitType sirius;
    public UnitType altiar;
    public UnitType spearhead;

    // ground units
    public UnitType noa;
    public UnitType external;
    public UnitType siriusMech;
    public UnitType ion;
    public UnitType xyrus;

    // naval units
    public UnitType indus;
    public UnitType imperi;
    public UnitType sruza;
    public UnitType crater;
    public UnitType cetus;

    // building blocks
    public Block coreBasis;
    public Block coreCentrum;
    public Block corePreatorium;

    // distribution
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

    // power (preview)
    public Block pwr2a;
    public Block pwr2b;
    public Block pwr3a;
    public Block pwr3b;
    public Block pwr3c;
    public Block pwr3d;
    public Block pwr4a;

    // production (preview)
    public Block prod2a;
    public Block prod2b;
    public Block prod2c;
    public Block prod2d;
    public Block prod2e;
    public Block prod2f;
    public Block prod2g;
    public Block prod2h;
    public Block prod2i;
    public Block prod2k;
    public Block prod3a;
    public Block prod3b;
    public Block prod3c;
    public Block prod3d;
    public Block prod3e;

    // turrets
    public Block ferios;
    public Block augero;
    public Block dustria;
    public Block agatias;
    public Block tormentis;
    public Block pila;
    public Block propius;
    public Block lucis;
    public Block novolary;

    // environment floors
    public Block stoneFloor;
    public Block redFloor;
    public Block iceFloor;
    public Block darkblueFloor;
    public Block darkDirtFloor;
    public Block blueCrystalFloor;
    public Block denseBlueCrystalFloor;

    // environment walls
    public Block wallBlock;
    public Block redWall;
    public Block redDirtWall;
    public Block iceWall;
    public Block darkblueWall;
    public Block blueCrystalWall;

    // environment ores
    public Block oreCophalast;
    public Block oreDuras;
    public Block oreNavitas;
    public Block oreVastum;
    public Block oreWallPausis;

    // environment props
    public Block boulder;
    public Block redBoulder;
    public Block iceBoulder;
    public Block darkblueBoulder;
    public Block darkDirtBoulder;
    public Block redCrystalCluster;
    public Block blueCrystalBlocks;

    public void loadContent() {
        items.loadContent();
        cophalast = items.cophalast;
        duras = items.duras;
        fabris = items.fabris;
        farasAlloy = items.farasAlloy;
        flaxol = items.flaxol;
        navitas = items.navitas;
        pausis = items.pausis;
        rudis = items.rudis;
        sand = items.sand;
        simus = items.simus;
        temperedGlass = items.temperedGlass;
        tentias = items.tentias;
        vastum = items.vastum;

        liquids.loadContent();
        barbavior = liquids.barbavior;
        fortial = liquids.fortial;
        horani = liquids.horani;

        core.loadContent();
        miles = core.miles;
        caesar = core.caesar;
        imperium = core.imperium;

        veggvis.loadContent();
        veggvisUnit = veggvis.veggvis;
        hermod = veggvis.hermod;
        valkyrie = veggvis.valkyrie;
        odin = veggvis.odin;
        ragnarok = veggvis.ragnarok;

        junior.loadContent();
        juniorUnit = junior.junior;
        centia = junior.centia;
        veralia = junior.veralia;
        impetuo = junior.impetuo;
        auxiol = junior.auxiol;
        prider = junior.prider;

        air.loadContent();
        diphda = air.diphda;
        procyon = air.procyon;
        sirius = air.sirius;
        altiar = air.altiar;
        spearhead = air.spearhead;

        ground.loadContent();
        noa = ground.noa;
        external = ground.external;
        siriusMech = ground.siriusMech;
        ion = ground.ion;
        xyrus = ground.xyrus;

        naval.loadContent();
        indus = naval.indus;
        imperi = naval.imperi;
        sruza = naval.sruza;
        crater = naval.crater;
        cetus = naval.cetus;

        coreBlocks.loadContent();
        coreBasis = coreBlocks.coreBasis;
        coreCentrum = coreBlocks.coreCentrum;
        corePreatorium = coreBlocks.corePreatorium;

        ores.loadContent();
        oreCophalast = ores.oreCophalast;
        oreDuras = ores.oreDuras;
        oreNavitas = ores.oreNavitas;
        oreVastum = ores.oreVastum;
        oreWallPausis = ores.oreWallPausis;

        distributionBlocks.loadContent();
        conduit = distributionBlocks.conduit;
        conduitRouter = distributionBlocks.conduitRouter;
        conduitJunction = distributionBlocks.conduitJunction;
        conduitBridge = distributionBlocks.conduitBridge;
        liquidContainer = distributionBlocks.liquidContainer;
        liquidTank = distributionBlocks.liquidTank;
        duct = distributionBlocks.duct;
        armoredDuct = distributionBlocks.armoredDuct;
        ductRouter = distributionBlocks.ductRouter;
        ductBridge = distributionBlocks.ductBridge;
        overflowDuct = distributionBlocks.overflowDuct;
        unoverflowDuct = distributionBlocks.unoverflowDuct;

        powerBlocks.loadContent();
        pwr2a = powerBlocks.pwr2a;
        pwr2b = powerBlocks.pwr2b;
        pwr3a = powerBlocks.pwr3a;
        pwr3b = powerBlocks.pwr3b;
        pwr3c = powerBlocks.pwr3c;
        pwr3d = powerBlocks.pwr3d;
        pwr4a = powerBlocks.pwr4a;

        productionBlocks.loadContent();
        prod2a = productionBlocks.prod2a;
        prod2b = productionBlocks.prod2b;
        prod2c = productionBlocks.prod2c;
        prod2d = productionBlocks.prod2d;
        prod2e = productionBlocks.prod2e;
        prod2f = productionBlocks.prod2f;
        prod2g = productionBlocks.prod2g;
        prod2h = productionBlocks.prod2h;
        prod2i = productionBlocks.prod2i;
        prod2k = productionBlocks.prod2k;
        prod3a = productionBlocks.prod3a;
        prod3b = productionBlocks.prod3b;
        prod3c = productionBlocks.prod3c;
        prod3d = productionBlocks.prod3d;
        prod3e = productionBlocks.prod3e;

        turretBlocks.loadContent();
        ferios = turretBlocks.ferios;
        augero = turretBlocks.augero;
        dustria = turretBlocks.dustria;
        agatias = turretBlocks.agatias;
        tormentis = turretBlocks.tormentis;
        pila = turretBlocks.pila;
        propius = turretBlocks.propius;
        lucis = turretBlocks.lucis;
        novolary = turretBlocks.novolary;

        environmentBlocks.loadContent();
        stoneFloor = environmentBlocks.stoneFloor;
        redFloor = environmentBlocks.redFloor;
        iceFloor = environmentBlocks.iceFloor;
        darkblueFloor = environmentBlocks.darkblueFloor;
        darkDirtFloor = environmentBlocks.darkDirtFloor;
        blueCrystalFloor = environmentBlocks.blueCrystalFloor;
        denseBlueCrystalFloor = environmentBlocks.denseBlueCrystalFloor;
        wallBlock = environmentBlocks.wallBlock;
        redWall = environmentBlocks.redWall;
        redDirtWall = environmentBlocks.redDirtWall;
        iceWall = environmentBlocks.iceWall;
        darkblueWall = environmentBlocks.darkblueWall;
        blueCrystalWall = environmentBlocks.blueCrystalWall;
        boulder = environmentBlocks.boulder;
        redBoulder = environmentBlocks.redBoulder;
        iceBoulder = environmentBlocks.iceBoulder;
        darkblueBoulder = environmentBlocks.darkblueBoulder;
        darkDirtBoulder = environmentBlocks.darkDirtBoulder;
        redCrystalCluster = environmentBlocks.redCrystalCluster;
        blueCrystalBlocks = environmentBlocks.blueCrystalBlocks;
    }
}
