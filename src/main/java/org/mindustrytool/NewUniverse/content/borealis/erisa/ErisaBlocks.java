package org.mindustrytool.NewUniverse.content.borealis.erisa;

import arc.graphics.Color;
import lombok.RequiredArgsConstructor;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.ItemStack;
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
import mindustry.world.meta.Env;

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
        // ── Glacius floors ──────────────────────────────────────────────

        ice = new Floor("ice") {{
            speedMultiplier = 0.5f;
            variants = 3;
            mapColor = Color.valueOf("c8e0f0");
            supportsOverlay = true;
        }};

        regolith = new Floor("regolith") {{
            variants = 3;
            mapColor = Color.valueOf("6b6b6b");
            supportsOverlay = true;
        }};

        permafrost = new Floor("permafrost") {{
            variants = 2;
            mapColor = Color.valueOf("8b9bb0");
            supportsOverlay = true;
        }};

        vent = new Floor("vent") {{
            variants = 2;
            mapColor = Color.valueOf("d4874a");
            albedo = 0.3f;
            supportsOverlay = true;
        }};

        deepIce = new Floor("deep-ice") {{
            speedMultiplier = 0.3f;
            drownTime = 600;
            mapColor = Color.valueOf("7080a0");
            supportsOverlay = true;
        }};

        snow = new Floor("snow") {{
            speedMultiplier = 0.4f;
            variants = 4;
            mapColor = Color.valueOf("e8e8f0");
            supportsOverlay = true;
        }};

        crust = new Floor("crust") {{
            speedMultiplier = 0.6f;
            variants = 2;
            mapColor = Color.valueOf("b0c8d8");
            supportsOverlay = true;
        }};

        slagIce = new Floor("slag-ice") {{
            variants = 2;
            mapColor = Color.valueOf("806050");
            isLiquid = true;
            supportsOverlay = true;
        }};

        // ── Glacius walls ──────────────────────────────────────────────
        // Floor→wall linking via naming convention:
        //   Floor.init() auto-links "ice" → "ice-wall"

        iceWall = new StaticWall("ice-wall");
        regolithWall = new StaticWall("regolith-wall");
        crystalWall = new StaticWall("crystal-wall") {{
            mapColor = Color.valueOf("6080d0");
        }};
        volcanicWall = new StaticWall("volcanic-wall") {{
            mapColor = Color.valueOf("785038");
        }};

        // ── Glacius ores ───────────────────────────────────────────────

        oreCophalast = new OreBlock("ore-cophalast", items.cophalast) {{
            oreThreshold = 0.82f;
            oreScale = 22;
            supportsOverlay = true;
        }};

        oreDuras = new OreBlock("ore-duras", items.duras) {{
            oreThreshold = 0.88f;
            oreScale = 20;
            supportsOverlay = true;
        }};

        oreNavitas = new OreBlock("ore-navitas", items.navitas) {{
            oreThreshold = 0.85f;
            oreScale = 24;
            supportsOverlay = true;
        }};

        orePausis = new OreBlock("ore-pausis", items.pausis) {{
            oreThreshold = 0.9f;
            oreScale = 18;
            supportsOverlay = true;
        }};

        oreVastum = new OreBlock("ore-vastum", items.vastum) {{
            oreThreshold = 0.8f;
            oreScale = 26;
            supportsOverlay = true;
        }};

        // ── Glacius turrets ────────────────────────────────────────────

        var cryoBullet = new BasicBulletType(3f, 12) {{
            width = 7f;
            height = 9f;
            lifetime = 40f;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            ammoMultiplier = 3f;
        }};

        var ironBullet = new BasicBulletType(4f, 20) {{
            width = 9f;
            height = 12f;
            lifetime = 35f;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootSmallSmoke;
            knockback = 2f;
            ammoMultiplier = 2f;
        }};

        var sulfurBullet = new BasicBulletType(3.5f, 25) {{
            width = 10f;
            height = 13f;
            lifetime = 40f;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            knockback = 3f;
            ammoMultiplier = 2f;
            pierce = true;
        }};

        var alloyBullet = new BasicBulletType(5f, 35) {{
            width = 12f;
            height = 15f;
            lifetime = 45f;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            knockback = 4f;
            ammoMultiplier = 2f;
            pierce = true;
            splashDamage = 15f;
            splashDamageRadius = 25f;
        }};

        var heavyBullet = new BasicBulletType(4f, 45) {{
            width = 14f;
            height = 18f;
            lifetime = 50f;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            knockback = 5f;
            ammoMultiplier = 1f;
            pierce = true;
            splashDamage = 30f;
            splashDamageRadius = 35f;
        }};

        var rapidBullet = new BasicBulletType(3f, 10) {{
            width = 6f;
            height = 8f;
            lifetime = 30f;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootSmallSmoke;
            ammoMultiplier = 4f;
        }};

        // Mjolnir — mid-range balanced turret
        mjolnir = new ItemTurret("mjolnir") {{
            size = 3;
            reload = 30f;
            range = 160f;
            maxAmmo = 40;
            ammo(
                items.duras, cryoBullet,
                items.simus, ironBullet
            );
            health = 800;
        }};

        // Gramr — short-range rapid-fire
        gramr = new ItemTurret("gramr") {{
            size = 3;
            reload = 10f;
            range = 120f;
            maxAmmo = 60;
            ammo(
                items.duras, rapidBullet,
                items.simus, new BasicBulletType(3f, 8) {{
                    width = 5f; height = 7f; lifetime = 25f;
                    shootEffect = Fx.shootSmall; ammoMultiplier = 5f;
                }}
            );
            health = 400;
        }};

        // Gungnir — long-range precision
        gungnir = new ItemTurret("gungnir") {{
            size = 3;
            reload = 45f;
            range = 200f;
            maxAmmo = 25;
            ammo(
                items.ferraloy, alloyBullet,
                items.navitas, sulfurBullet
            );
            health = 900;
        }};

        // Hermodr — versatile medium turret
        hermodr = new ItemTurret("hermodr") {{
            size = 3;
            reload = 20f;
            range = 150f;
            maxAmmo = 35;
            ammo(
                items.simus, ironBullet,
                items.duras, cryoBullet
            );
            health = 500;
        }};

        // Laevateinn — flame/close-range
        laevateinn = new ItemTurret("laevateinn") {{
            size = 4;
            reload = 25f;
            range = 130f;
            maxAmmo = 30;
            ammo(
                items.navitas, new BasicBulletType(2.5f, 18) {{
                    width = 8f; height = 10f; lifetime = 28f;
                    shootEffect = Fx.shootSmall; ammoMultiplier = 3f;
                    pierce = true;
                    fragBullet = new BasicBulletType(1f, 5) {{
                        width = 4f; height = 6f; lifetime = 15f;
                        ammoMultiplier = 0f;
                    }};
                    fragBullets = 3;
                }},
                items.duras, cryoBullet
            );
            health = 750;
        }};

        // Lopt — heavy artillery
        lopt = new ItemTurret("lopt") {{
            size = 4;
            reload = 60f;
            range = 250f;
            maxAmmo = 15;
            ammo(
                items.navitas, heavyBullet,
                items.ferraloy, new BasicBulletType(5f, 60) {{
                    width = 16f; height = 20f; lifetime = 60f;
                    shootEffect = Fx.shootBig; ammoMultiplier = 1f;
                    knockback = 6f; pierce = true;
                    splashDamage = 40f; splashDamageRadius = 45f;
                }}
            );
            health = 2000;
        }};

        // Gjallarhorn — long-range support
        gjallarhorn = new ItemTurret("gjallarhorn") {{
            size = 4;
            reload = 40f;
            range = 190f;
            maxAmmo = 20;
            ammo(
                items.ferraloy, alloyBullet,
                items.simus, new BasicBulletType(4.5f, 22) {{
                    width = 10f; height = 14f; lifetime = 42f;
                    ammoMultiplier = 2f; knockback = 3f;
                }}
            );
            health = 850;
        }};

        // Svafnir — anti-air rapid turret
        svafnir = new ItemTurret("svafnir") {{
            size = 4;
            reload = 8f;
            range = 160f;
            maxAmmo = 50;
            targetAir = true;
            targetGround = false;
            ammo(
                items.duras, new BasicBulletType(5f, 9) {{
                    width = 5f; height = 7f; lifetime = 35f;
                    shootEffect = Fx.shootSmall; ammoMultiplier = 4f;
                }},
                items.ferraloy, new BasicBulletType(6f, 15) {{
                    width = 7f; height = 9f; lifetime = 38f;
                    shootEffect = Fx.shootBig; ammoMultiplier = 3f;
                }}
            );
            health = 450;
        }};

        // Nidhoggr — heavy rapid-fire close assault
        nidhoggr = new ItemTurret("nidhoggr") {{
            size = 4;
            reload = 12f;
            range = 140f;
            maxAmmo = 80;
            ammo(
                items.simus, new BasicBulletType(3.5f, 15) {{
                    width = 8f; height = 10f; lifetime = 30f;
                    shootEffect = Fx.shootBig; ammoMultiplier = 3f;
                }},
                items.navitas, new BasicBulletType(3f, 22) {{
                    width = 9f; height = 12f; lifetime = 32f;
                    shootEffect = Fx.shootBig; ammoMultiplier = 2f;
                    pierce = true;
                }}
            );
            health = 1800;
        }};

        // ── Glacius power ──────────────────────────────────────────────

        yggdrasilGenerator = new ConsumeGenerator("yggdrasil-generator") {{
            size = 2;
            powerProduction = 3f;
            itemDuration = 90f;
            consumeItem(items.duras, 1);
            health = 400;
            envEnabled = Env.any;
        }};

        yggdrasilCore = new PowerGenerator("yggdrasil-core") {{
            size = 4;
            powerProduction = 15f;
            health = 2000;
            envEnabled = Env.any;
        }};

        yggdrasilArray = new ConsumeGenerator("yggdrasil-array") {{
            size = 3;
            powerProduction = 8f;
            itemDuration = 120f;
            consumeItem(items.navitas, 1);
            health = 1200;
            envEnabled = Env.any;
        }};

        // ── Glacius production ─────────────────────────────────────────

        foundry = new GenericCrafter("foundry") {{
            size = 2;
            craftTime = 60f;
            outputItem = new ItemStack(items.simus, 1);
            consumeItem(items.duras, 1);
            consumePower(1f);
            health = 300;
            envEnabled = Env.any;
        }};

        refinery = new GenericCrafter("refinery") {{
            size = 2;
            craftTime = 90f;
            outputItem = new ItemStack(items.ferraloy, 1);
            consumeItems(new ItemStack(items.simus, 2), new ItemStack(items.duras, 1));
            consumePower(2f);
            health = 350;
            envEnabled = Env.any;
        }};

        fabricator = new GenericCrafter("fabricator") {{
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
            envEnabled = Env.any;
        }};

        assembly = new GenericCrafter("assembly") {{
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
            envEnabled = Env.any;
        }};

        // ── Glacius distribution ───────────────────────────────────────

        conduit = new Conduit("conduit") {{
            health = 60;
            envEnabled = Env.any;
        }};

        duct = new Duct("duct") {{
            health = 50;
            envEnabled = Env.any;
        }};
    }
}
