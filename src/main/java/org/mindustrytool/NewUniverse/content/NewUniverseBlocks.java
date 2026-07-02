package org.mindustrytool.NewUniverse.content;

import arc.graphics.Color;
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

public class NewUniverseBlocks {
    public static Floor
            glaciusIce,
            glaciusRegolith,
            glaciusPermafrost,
            glaciusVent,
            glaciusDeepIce,
            glaciusSnow,
            glaciusCrust,
            glaciusSlagIce;

    public static StaticWall
            glaciusIceWall,
            glaciusRegolithWall,
            glaciusCrystalWall,
            glaciusVolcanicWall;

    public static OreBlock
            oreCryoCrystal,
            oreFrozenIron,
            oreVolcanicSulfur,
            oreCophalast,
            oreDuras,
            oreNavitas,
            orePausis,
            oreVastum;

    // ── Turrets ─────────────────────────────────────────────────────
    public static ItemTurret
            glaciusMjolnir,
            glaciusGramr,
            glaciusGungnir,
            glaciusHermodr,
            glaciusLaevateinn,
            glaciusLopt,
            glaciusGjallarhorn,
            glaciusSvafnir,
            glaciusNidhoggr;

    // ── Power ───────────────────────────────────────────────────────
    public static ConsumeGenerator
            glaciusYggdrasilGenerator;
    public static PowerGenerator
            glaciusYggdrasilCore;
    public static Block // using generic Block for multi-region array
            glaciusYggdrasilArray;

    // ── Production ──────────────────────────────────────────────────
    public static GenericCrafter
            glaciusFoundry,
            glaciusRefinery,
            glaciusFabricator,
            glaciusAssembly;

    // ── Distribution ────────────────────────────────────────────────
    public static Conduit
            glaciusConduit;
    public static Duct
            glaciusDuct;

    public static void load() {
        // ── Glacius floors ──────────────────────────────────────────

        glaciusIce = new Floor("glacius-ice") {{
            speedMultiplier = 0.5f;
            variants = 3;
            mapColor = Color.valueOf("c8e0f0");
            supportsOverlay = true;
        }};

        glaciusRegolith = new Floor("glacius-regolith") {{
            variants = 3;
            mapColor = Color.valueOf("6b6b6b");
            supportsOverlay = true;
        }};

        glaciusPermafrost = new Floor("glacius-permafrost") {{
            variants = 2;
            mapColor = Color.valueOf("8b9bb0");
            supportsOverlay = true;
        }};

        glaciusVent = new Floor("glacius-vent") {{
            variants = 2;
            mapColor = Color.valueOf("d4874a");
            albedo = 0.3f;
            supportsOverlay = true;
        }};

        glaciusDeepIce = new Floor("glacius-deep-ice") {{
            speedMultiplier = 0.3f;
            drownTime = 600;
            mapColor = Color.valueOf("7080a0");
            supportsOverlay = true;
        }};

        glaciusSnow = new Floor("glacius-snow") {{
            speedMultiplier = 0.4f;
            variants = 4;
            mapColor = Color.valueOf("e8e8f0");
            supportsOverlay = true;
        }};

        glaciusCrust = new Floor("glacius-crust") {{
            speedMultiplier = 0.6f;
            variants = 2;
            mapColor = Color.valueOf("b0c8d8");
            supportsOverlay = true;
        }};

        glaciusSlagIce = new Floor("glacius-slag-ice") {{
            variants = 2;
            mapColor = Color.valueOf("806050");
            isLiquid = true;
            supportsOverlay = true;
        }};

        // ── Glacius walls ──────────────────────────────────────────
        // Floor→wall linking via naming convention:
        //   Floor.init() auto-links "glacius-ice" → "glacius-ice-wall"

        glaciusIceWall = new StaticWall("glacius-ice-wall");
        glaciusRegolithWall = new StaticWall("glacius-regolith-wall");
        glaciusCrystalWall = new StaticWall("glacius-crystal-wall") {{
            mapColor = Color.valueOf("6080d0");
        }};
        glaciusVolcanicWall = new StaticWall("glacius-volcanic-wall") {{
            mapColor = Color.valueOf("785038");
        }};

        // ── Glacius ores ───────────────────────────────────────────

        oreCryoCrystal = new OreBlock("ore-cryo-crystal", NewUniverseItems.cryoCrystal) {{
            oreThreshold = 0.8f;
            oreScale = 20;
            supportsOverlay = true;
        }};

        oreFrozenIron = new OreBlock("ore-frozen-iron", NewUniverseItems.frozenIron) {{
            oreThreshold = 0.9f;
            oreScale = 24;
            supportsOverlay = true;
        }};

        oreVolcanicSulfur = new OreBlock("ore-volcanic-sulfur", NewUniverseItems.volcanicSulfur) {{
            oreThreshold = 0.85f;
            oreScale = 18;
            supportsOverlay = true;
        }};

        oreCophalast = new OreBlock("ore-cophalast", NewUniverseItems.cophalast) {{
            oreThreshold = 0.82f;
            oreScale = 22;
            supportsOverlay = true;
        }};

        oreDuras = new OreBlock("ore-duras", NewUniverseItems.duras) {{
            oreThreshold = 0.88f;
            oreScale = 20;
            supportsOverlay = true;
        }};

        oreNavitas = new OreBlock("ore-navitas", NewUniverseItems.navitas) {{
            oreThreshold = 0.85f;
            oreScale = 24;
            supportsOverlay = true;
        }};

        orePausis = new OreBlock("ore-pausis", NewUniverseItems.pausis) {{
            oreThreshold = 0.9f;
            oreScale = 18;
            supportsOverlay = true;
        }};

        oreVastum = new OreBlock("ore-vastum", NewUniverseItems.vastum) {{
            oreThreshold = 0.8f;
            oreScale = 26;
            supportsOverlay = true;
        }};

        // ── Glacius turrets ────────────────────────────────────────

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
        glaciusMjolnir = new ItemTurret("glacius-mjolnir") {{
            size = 3;
            reload = 30f;
            range = 160f;
            maxAmmo = 40;
            ammo(
                NewUniverseItems.cryoCrystal, cryoBullet,
                NewUniverseItems.frozenIron, ironBullet
            );
            health = 800;
        }};

        // Gramr — short-range rapid-fire
        glaciusGramr = new ItemTurret("glacius-gramr") {{
            size = 2;
            reload = 10f;
            range = 120f;
            maxAmmo = 60;
            ammo(
                NewUniverseItems.cryoCrystal, rapidBullet,
                NewUniverseItems.frozenIron, new BasicBulletType(3f, 8) {{
                    width = 5f; height = 7f; lifetime = 25f;
                    shootEffect = Fx.shootSmall; ammoMultiplier = 5f;
                }}
            );
            health = 400;
        }};

        // Gungnir — long-range precision
        glaciusGungnir = new ItemTurret("glacius-gungnir") {{
            size = 3;
            reload = 45f;
            range = 200f;
            maxAmmo = 25;
            ammo(
                NewUniverseItems.cryoAlloy, alloyBullet,
                NewUniverseItems.volcanicSulfur, sulfurBullet
            );
            health = 900;
        }};

        // Hermodr — versatile medium turret
        glaciusHermodr = new ItemTurret("glacius-hermodr") {{
            size = 2;
            reload = 20f;
            range = 150f;
            maxAmmo = 35;
            ammo(
                NewUniverseItems.frozenIron, ironBullet,
                NewUniverseItems.cryoCrystal, cryoBullet
            );
            health = 500;
        }};

        // Laevateinn — flame/close-range
        glaciusLaevateinn = new ItemTurret("glacius-laevateinn") {{
            size = 3;
            reload = 25f;
            range = 130f;
            maxAmmo = 30;
            ammo(
                NewUniverseItems.volcanicSulfur, new BasicBulletType(2.5f, 18) {{
                    width = 8f; height = 10f; lifetime = 28f;
                    shootEffect = Fx.shootSmall; ammoMultiplier = 3f;
                    pierce = true;
                    fragBullet = new BasicBulletType(1f, 5) {{
                        width = 4f; height = 6f; lifetime = 15f;
                        ammoMultiplier = 0f;
                    }};
                    fragBullets = 3;
                }},
                NewUniverseItems.cryoCrystal, cryoBullet
            );
            health = 750;
        }};

        // Lopt — heavy artillery
        glaciusLopt = new ItemTurret("glacius-lopt") {{
            size = 4;
            reload = 60f;
            range = 250f;
            maxAmmo = 15;
            ammo(
                NewUniverseItems.volcanicSulfur, heavyBullet,
                NewUniverseItems.cryoAlloy, new BasicBulletType(5f, 60) {{
                    width = 16f; height = 20f; lifetime = 60f;
                    shootEffect = Fx.shootBig; ammoMultiplier = 1f;
                    knockback = 6f; pierce = true;
                    splashDamage = 40f; splashDamageRadius = 45f;
                }}
            );
            health = 2000;
        }};

        // Gjallarhorn — long-range support
        glaciusGjallarhorn = new ItemTurret("glacius-gjallarhorn") {{
            size = 3;
            reload = 40f;
            range = 190f;
            maxAmmo = 20;
            ammo(
                NewUniverseItems.cryoAlloy, alloyBullet,
                NewUniverseItems.frozenIron, new BasicBulletType(4.5f, 22) {{
                    width = 10f; height = 14f; lifetime = 42f;
                    ammoMultiplier = 2f; knockback = 3f;
                }}
            );
            health = 850;
        }};

        // Svafnir — anti-air rapid turret
        glaciusSvafnir = new ItemTurret("glacius-svafnir") {{
            size = 2;
            reload = 8f;
            range = 160f;
            maxAmmo = 50;
            targetAir = true;
            targetGround = false;
            ammo(
                NewUniverseItems.cryoCrystal, new BasicBulletType(5f, 9) {{
                    width = 5f; height = 7f; lifetime = 35f;
                    shootEffect = Fx.shootSmall; ammoMultiplier = 4f;
                }},
                NewUniverseItems.cryoAlloy, new BasicBulletType(6f, 15) {{
                    width = 7f; height = 9f; lifetime = 38f;
                    shootEffect = Fx.shootBig; ammoMultiplier = 3f;
                }}
            );
            health = 450;
        }};

        // Nidhoggr — heavy rapid-fire close assault
        glaciusNidhoggr = new ItemTurret("glacius-nidhoggr") {{
            size = 4;
            reload = 12f;
            range = 140f;
            maxAmmo = 80;
            ammo(
                NewUniverseItems.frozenIron, new BasicBulletType(3.5f, 15) {{
                    width = 8f; height = 10f; lifetime = 30f;
                    shootEffect = Fx.shootBig; ammoMultiplier = 3f;
                }},
                NewUniverseItems.volcanicSulfur, new BasicBulletType(3f, 22) {{
                    width = 9f; height = 12f; lifetime = 32f;
                    shootEffect = Fx.shootBig; ammoMultiplier = 2f;
                    pierce = true;
                }}
            );
            health = 1800;
        }};

        // ── Glacius power ──────────────────────────────────────────

        glaciusYggdrasilGenerator = new ConsumeGenerator("glacius-yggdrasil-generator") {{
            size = 2;
            powerProduction = 3f;
            itemDuration = 90f;
            consumeItem(NewUniverseItems.cryoCrystal, 1);
            health = 400;
            envEnabled = Env.any;
        }};

        glaciusYggdrasilCore = new PowerGenerator("glacius-yggdrasil-core") {{
            size = 4;
            powerProduction = 15f;
            health = 2000;
            envEnabled = Env.any;
        }};

        glaciusYggdrasilArray = new ConsumeGenerator("glacius-yggdrasil-array") {{
            size = 3;
            powerProduction = 8f;
            itemDuration = 120f;
            consumeItem(NewUniverseItems.volcanicSulfur, 1);
            health = 1200;
            envEnabled = Env.any;
        }};

        // ── Glacius production ─────────────────────────────────────

        glaciusFoundry = new GenericCrafter("glacius-foundry") {{
            size = 2;
            craftTime = 60f;
            outputItem = new ItemStack(NewUniverseItems.frozenIron, 1);
            consumeItem(NewUniverseItems.cryoCrystal, 1);
            consumePower(1f);
            health = 300;
            envEnabled = Env.any;
        }};

        glaciusRefinery = new GenericCrafter("glacius-refinery") {{
            size = 2;
            craftTime = 90f;
            outputItem = new ItemStack(NewUniverseItems.cryoAlloy, 1);
            consumeItems(new ItemStack(NewUniverseItems.frozenIron, 2), new ItemStack(NewUniverseItems.cryoCrystal, 1));
            consumePower(2f);
            health = 350;
            envEnabled = Env.any;
        }};

        glaciusFabricator = new GenericCrafter("glacius-fabricator") {{
            size = 3;
            craftTime = 120f;
            outputItem = new ItemStack(NewUniverseItems.cryoAlloy, 2);
            consumeItems(
                new ItemStack(NewUniverseItems.frozenIron, 3),
                new ItemStack(NewUniverseItems.volcanicSulfur, 1),
                new ItemStack(NewUniverseItems.cryoCrystal, 1)
            );
            consumePower(4f);
            health = 800;
            envEnabled = Env.any;
        }};

        glaciusAssembly = new GenericCrafter("glacius-assembly") {{
            size = 3;
            craftTime = 150f;
            outputItem = new ItemStack(NewUniverseItems.cryoAlloy, 3);
            consumeItems(
                new ItemStack(NewUniverseItems.frozenIron, 4),
                new ItemStack(NewUniverseItems.volcanicSulfur, 2),
                new ItemStack(NewUniverseItems.cryoCrystal, 2)
            );
            consumePower(6f);
            health = 900;
            envEnabled = Env.any;
        }};

        // ── Glacius distribution ───────────────────────────────────

        glaciusConduit = new Conduit("glacius-conduit") {{
            health = 60;
            envEnabled = Env.any;
        }};

        glaciusDuct = new Duct("glacius-duct") {{
            health = 50;
            envEnabled = Env.any;
        }};
    }
}
