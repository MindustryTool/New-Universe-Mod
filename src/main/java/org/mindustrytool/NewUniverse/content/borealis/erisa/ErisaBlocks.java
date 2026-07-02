package org.mindustrytool.NewUniverse.content.borealis.erisa;

import lombok.RequiredArgsConstructor;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.blocks.production.GenericCrafter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ErisaBlocks {

    // ── Floors ──────────────────────────────────────────────────────────
    public Floor
            ice,
            regolith,
            permafrost,
            vent,
            deepIce,
            snow,
            crust,
            slagIce;

    // ── Walls ───────────────────────────────────────────────────────────
    public StaticWall
            iceWall,
            regolithWall,
            crystalWall,
            volcanicWall;

    // ── Ores ────────────────────────────────────────────────────────────
    public OreBlock
            oreCophalast,
            oreDuras,
            oreNavitas,
            orePausis,
            oreVastum;

    // ── Turrets ─────────────────────────────────────────────────────────
    public ItemTurret
            mjolnir,
            gramr,
            gungnir,
            hermodr,
            laevateinn,
            lopt,
            gjallarhorn,
            svafnir,
            nidhoggr;

    // ── Power ───────────────────────────────────────────────────────────
    public ConsumeGenerator
            yggdrasilGenerator;
    public PowerGenerator
            yggdrasilCore;
    public Block // using generic Block for multi-region array
            yggdrasilArray;

    // ── Production ──────────────────────────────────────────────────────
    public GenericCrafter
            foundry,
            refinery,
            fabricator,
            assembly;

    // ── Distribution ────────────────────────────────────────────────────
    public Conduit
            conduit;
    public Duct
            duct;

    private final ErisaItems items;

    public void loadContent() {
        // Environment (floors + walls)
        var env = ErisaEnvironmentBlocks.load();
        ice = env.ice;
        regolith = env.regolith;
        permafrost = env.permafrost;
        vent = env.vent;
        deepIce = env.deepIce;
        snow = env.snow;
        crust = env.crust;
        slagIce = env.slagIce;
        iceWall = env.iceWall;
        regolithWall = env.regolithWall;
        crystalWall = env.crystalWall;
        volcanicWall = env.volcanicWall;

        // Ores
        var ores = ErisaOreBlocks.load(items);
        oreCophalast = ores.oreCophalast;
        oreDuras = ores.oreDuras;
        oreNavitas = ores.oreNavitas;
        orePausis = ores.orePausis;
        oreVastum = ores.oreVastum;

        // Turrets
        var turrets = ErisaTurretBlocks.load(items);
        mjolnir = turrets.mjolnir;
        gramr = turrets.gramr;
        gungnir = turrets.gungnir;
        hermodr = turrets.hermodr;
        laevateinn = turrets.laevateinn;
        lopt = turrets.lopt;
        gjallarhorn = turrets.gjallarhorn;
        svafnir = turrets.svafnir;
        nidhoggr = turrets.nidhoggr;

        // Buildings (power + production + distribution)
        var buildings = ErisaBuildingBlocks.load(items);
        yggdrasilGenerator = buildings.yggdrasilGenerator;
        yggdrasilCore = buildings.yggdrasilCore;
        yggdrasilArray = buildings.yggdrasilArray;
        foundry = buildings.foundry;
        refinery = buildings.refinery;
        fabricator = buildings.fabricator;
        assembly = buildings.assembly;
        conduit = buildings.conduit;
        duct = buildings.duct;
    }
}
