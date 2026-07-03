package org.mindustrytool.NewUniverse.content.borealis.content;

import mindustry.type.Item;
import mindustry.type.UnitType;
import mindustry.world.Block;
import org.mindustrytool.NewUniverse.content.borealis.content.building.BorealisBuildingBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.building.BorealisTurretBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.enviroment.BorealisEnvironmentBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.enviroment.ore.BorealisOreBlocks;
import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;
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
    private final BorealisIndusUnitTypes naval;
    private final BorealisNoaUnitTypes ground;
    private final BorealisCoreUnitTypes core;
    private final BorealisVeggvisUnitTypes veggvis;
    private final BorealisJuniorUnitTypes junior;
    private final BorealisDiphdaUnitTypes air;
    private final BorealisBuildingBlocks buildingBlocks;
    private final BorealisTurretBlocks turretBlocks;
    private final BorealisEnvironmentBlocks environmentBlocks;
    private final BorealisOreBlocks oreBlocks;

    // items
    public Item cophalast;
    public Item duras;
    public Item fabris;
    public Item farasAlloy;
    public Item flaxol;
    public Item fortial;
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

    public void loadContent() {
        items.loadContent();
        cophalast = items.cophalast;
        duras = items.duras;
        fabris = items.fabris;
        farasAlloy = items.farasAlloy;
        flaxol = items.flaxol;
        fortial = items.fortial;
        navitas = items.navitas;
        pausis = items.pausis;
        rudis = items.rudis;
        sand = items.sand;
        simus = items.simus;
        temperedGlass = items.temperedGlass;
        tentias = items.tentias;
        vastum = items.vastum;

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

        buildingBlocks.loadContent();
        coreBasis = buildingBlocks.coreBasis;
        coreCentrum = buildingBlocks.coreCentrum;
        corePreatorium = buildingBlocks.corePreatorium;

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
        oreBlocks.loadContent();
    }
}
