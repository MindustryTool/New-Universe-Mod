package org.mindustrytool.NewUniverse.content.borealis.erisa;

import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.world.blocks.defense.turrets.ItemTurret;

/**
 * Holds Glacius turret blocks.
 * Called by {@link ErisaBlocks#loadContent()}.
 */
public class ErisaTurretBlocks {

    public ItemTurret mjolnir, gramr, gungnir, hermodr, laevateinn, lopt,
            gjallarhorn, svafnir, nidhoggr;

    private ErisaTurretBlocks() {}

    public static ErisaTurretBlocks load(ErisaItems items) {
        var b = new ErisaTurretBlocks();

        // ── Shared bullet types ─────────────────────────────────────────

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

        // ── Glacius turrets ────────────────────────────────────────────

        // Mjolnir — mid-range balanced turret
        b.mjolnir = new ItemTurret("mjolnir") {{
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
        b.gramr = new ItemTurret("gramr") {{
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
        b.gungnir = new ItemTurret("gungnir") {{
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
        b.hermodr = new ItemTurret("hermodr") {{
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
        b.laevateinn = new ItemTurret("laevateinn") {{
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
        b.lopt = new ItemTurret("lopt") {{
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
        b.gjallarhorn = new ItemTurret("gjallarhorn") {{
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
        b.svafnir = new ItemTurret("svafnir") {{
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
        b.nidhoggr = new ItemTurret("nidhoggr") {{
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

        return b;
    }
}
