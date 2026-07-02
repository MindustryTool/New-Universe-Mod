package org.mindustrytool.NewUniverse.content.borealis.erisa;

import arc.graphics.Color;
import arc.struct.Seq;
import lombok.RequiredArgsConstructor;
import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.RegenAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.abilities.StatusFieldAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.bullet.PointLaserBulletType;
import mindustry.gen.MechUnit;
import mindustry.gen.UnitEntity;
import mindustry.gen.UnitWaterMove;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ErisaUnitTypes {

    // ████████████████████████████████████████████████████████████████████████
    //  Air tier (flying) — Existing units with weapons added
    // ████████████████████████████████████████████████████████████████████████

    public UnitType herja;
    public UnitType eir;
    public UnitType hlokk;
    public UnitType gondul;
    public UnitType skogul;

    // ████████████████████████████████████████████████████████████████████████
    //  Mech tier (ground) — Changed to MechUnit::create + weapons added
    // ████████████████████████████████████████████████████████████████████████

    public UnitType jotunn;
    public UnitType ymir;
    public UnitType thrymr;
    public UnitType bergelmir;
    public UnitType surtr;

    // ████████████████████████████████████████████████████████████████████████
    //  Naval tier — Changed to UnitWaterMove::create + weapons added
    // ████████████████████████████████████████████████████████████████████████

    public UnitType aegir;
    public UnitType ran;
    public UnitType njordr;
    public UnitType jormun;
    public UnitType lyngbakr;

    // ████████████████████████████████████████████████████████████████████████
    //  Special units
    // ████████████████████████████████████████████████████████████████████████

    /** Heavy flying dreadnought. From HJSON Air-1-5. */
    public UnitType spearhead;

    /** Aerial support gunship. */
    public UnitType altiar;

    /** Colossal naval fortress. */
    public UnitType cetus;

    // ████████████████████████████████████████████████████████████████████████
    //  Flying-2 Attacker — Fenrir line (Norse giant creatures)
    // ████████████████████████████████████████████████████████████████████████

    public UnitType fenrir;
    public UnitType garmr;
    public UnitType draugr;
    public UnitType ragnar;

    // ████████████████████████████████████████████████████████████████████████
    //  Flying-3 Attacker — Diphda, Procyon, Sirius
    // ████████████████████████████████████████████████████████████████████████

    public UnitType diphda;
    public UnitType procyon;
    public UnitType sirius;

    // ████████████████████████████████████████████████████████████████████████
    //  Supporter line — Norse gods (flying support units)
    // ████████████████████████████████████████████████████████████████████████

    public UnitType mimir;
    public UnitType hermodr;
    public UnitType bragi;
    public UnitType forseti;
    public UnitType tyr;
    public UnitType vidarr;

    // ████████████████████████████████████████████████████████████████████████
    //  Core ground — Einherjar (Mech units)
    // ████████████████████████████████████████████████████████████████████████

    public UnitType einherjar;
    public UnitType berserkr;
    public UnitType ulfhednar;

    // ████████████████████████████████████████████████████████████████████████
    //  Groupings
    // ████████████████████████████████████████████████████████████████████████

    public Seq<UnitType> airUnits;
    public Seq<UnitType> mechUnits;
    public Seq<UnitType> navalUnits;
    public Seq<UnitType> fenrirLine;
    public Seq<UnitType> diphdaLine;
    public Seq<UnitType> supporterLine;
    public Seq<UnitType> einherjarLine;
    public Seq<UnitType> allUnits;

    /**
     * Initializes all unit type instance fields.
     */
    public void loadContent() {
        herja = new UnitType("herja") {{
            constructor = UnitEntity::create;
            speed = 1.8f;
            health = 800;
            armor = 3f;
            hitSize = 40;
            flying = true;
            lowAltitude = true;
            engineSize = 2;
            trailLength = 4;
            weapons = Seq.with(
                new Weapon("herja-weapon") {{
                    reload = 20;
                    alternate = true;
                    x = 8;
                    y = 0;
                    shootCone = 20;
                    rotate = true;
                    rotateSpeed = 10;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3f, 10) {{
                        width = 5;
                        height = 7;
                        lifetime = 40;
                        trailLength = 3;
                        trailColor = Color.valueOf("80c0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletSmall;
                        despawnEffect = Fx.despawn;
                        keepVelocity = true;
                        collidesTiles = true;
                        collidesAir = true;
                        collidesGround = true;
                    }};
                }}
            );
        }};

        eir = new UnitType("eir") {{
            constructor = UnitEntity::create;
            speed = 1.6f;
            health = 3200;
            armor = 6f;
            hitSize = 60;
            flying = true;
            lowAltitude = true;
            engineSize = 3;
            trailLength = 5;
            weapons = Seq.with(
                new Weapon("eir-weapon") {{
                    reload = 25;
                    alternate = true;
                    x = 10;
                    y = 0;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 8;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3.5f, 22) {{
                        width = 6;
                        height = 8;
                        lifetime = 45;
                        trailLength = 4;
                        trailColor = Color.valueOf("80c0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletBig;
                        despawnEffect = Fx.despawn;
                        keepVelocity = true;
                        splashDamage = 5;
                        splashDamageRadius = 12;
                    }};
                }}
            );
        }};

        hlokk = new UnitType("hlokk") {{
            constructor = UnitEntity::create;
            speed = 1.4f;
            health = 6800;
            armor = 9f;
            hitSize = 87;
            flying = true;
            lowAltitude = true;
            engineSize = 4;
            trailLength = 6;
            weapons = Seq.with(
                new Weapon("hlokk-weapon") {{
                    reload = 20;
                    alternate = true;
                    x = 14;
                    y = 0;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 6;
                    shootSound = Sounds.shootLaser;
                    bullet = new LaserBoltBulletType() {{
                        damage = 35;
                        speed = 4f;
                        lifetime = 50;
                        width = 4;
                        height = 7;
                        trailLength = 4;
                        trailColor = Color.valueOf("60a0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitLaser;
                        despawnEffect = Fx.despawn;
                        keepVelocity = true;
                        frontColor = Color.valueOf("80c0ff");
                        backColor = Color.valueOf("4080c0");
                        lightningColor = Color.valueOf("80c0ff");
                    }};
                }}
            );
        }};

        gondul = new UnitType("gondul") {{
            constructor = UnitEntity::create;
            speed = 1.2f;
            health = 12000;
            armor = 12f;
            hitSize = 130;
            flying = true;
            lowAltitude = true;
            engineSize = 5;
            trailLength = 8;
            weapons = Seq.with(
                new Weapon("gondul-weapon") {{
                    reload = 30;
                    alternate = true;
                    x = 18;
                    y = 0;
                    shootCone = 10;
                    rotate = true;
                    rotateSpeed = 5;
                    shootSound = Sounds.shootLaser;
                    bullet = new PointLaserBulletType() {{
                        damage = 80;
                        lifetime = 30;
                        hitShake = 1;
                        shootEffect = Fx.absorb;
                        hitEffect = Fx.hitLaser;
                        keepVelocity = true;
                        buildingDamageMultiplier = 1.2f;
                    }};
                }}
            );
        }};

        skogul = new UnitType("skogul") {{
            constructor = UnitEntity::create;
            speed = 1.0f;
            health = 19000;
            armor = 15f;
            hitSize = 196;
            flying = true;
            lowAltitude = true;
            engineSize = 6;
            trailLength = 9;
            weapons = Seq.with(
                new Weapon("skogul-mainwp") {{
                    reload = 25;
                    alternate = true;
                    x = -16;
                    y = -8;
                    shootCone = 20;
                    rotate = true;
                    rotateSpeed = 3;
                    recoil = 3.5f;
                    shake = 2.5f;
                    shootSound = Sounds.shootMalign;
                    bullet = new PointLaserBulletType() {{
                        damage = 60;
                        lifetime = 25;
                        hitShake = 1;
                        shootEffect = Fx.absorb;
                        pierceArmor = true;
                        armorMultiplier = 2f;
                        impact = true;
                        scaleKeepVelocity = true;
                        keepVelocity = true;
                        spawnBullets = Seq.with(
                            new LightningBulletType() {{
                                damage = 20;
                                lifetime = 40;
                                speed = 1f;
                                hitSize = 4;
                                drawSize = 40;
                                lightningDamage = 20;
                                lightningLength = 15;
                                lightningLengthRand = 5;
                                lightningCone = 20;
                                lightningAngle = 30;
                                lightningColor = Color.valueOf("FEB380");
                                shootSound = Sounds.explosion;
                                collidesAir = true;
                                collidesGround = true;
                                fragBullets = 9;
                                fragVelocityMin = 0.2f;
                                fragVelocityMax = 1f;
                                fragLifeMin = 1f;
                                fragLifeMax = 1f;
                            }}
                        );
                    }};
                }},
                new Weapon("skogul-wp2") {{
                    reload = 17;
                    alternate = true;
                    x = -10;
                    y = 16;
                    shootCone = 20;
                    rotate = true;
                    rotateSpeed = 5;
                    shake = 1;
                    recoil = 2f;
                    shootSound = Sounds.shootMalign;
                    bullet = new PointLaserBulletType() {{
                        damage = 40;
                        lifetime = 22;
                        hitShake = 1;
                        shootEffect = Fx.absorb;
                        inaccuracy = 1f;
                        scaleKeepVelocity = true;
                        keepVelocity = true;
                        spawnBullets = Seq.with(
                            new LightningBulletType() {{
                                damage = 10;
                                lifetime = 40;
                                speed = 1f;
                                hitSize = 4;
                                drawSize = 40;
                                lightningDamage = 10;
                                lightningLength = 10;
                                lightningLengthRand = 5;
                                lightningCone = 50;
                                lightningAngle = 20;
                                lightningColor = Color.valueOf("FEB380");
                                shootSound = Sounds.explosion;
                                collidesAir = true;
                                collidesGround = true;
                            }}
                        );
                    }};
                }}
            );
        }};

        // ████████████████████████████████████████████████████████████████████████
        //  Mech tier (ground)
        // ████████████████████████████████████████████████████████████████████████

        jotunn = new UnitType("jotunn") {{
            constructor = MechUnit::create;
            speed = 0.6f;
            health = 2000;
            armor = 6f;
            hitSize = 37;
            weapons = Seq.with(
                new Weapon("jotunn-weapon") {{
                    reload = 35;
                    alternate = true;
                    x = 6;
                    y = 0;
                    shootCone = 10;
                    rotate = false;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(2.5f, 18) {{
                        width = 5;
                        height = 7;
                        lifetime = 50;
                        trailLength = 2;
                        trailColor = Color.valueOf("d4b040");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletSmall;
                        despawnEffect = Fx.despawn;
                        keepVelocity = true;
                    }};
                }}
            );
        }};

        ymir = new UnitType("ymir") {{
            constructor = MechUnit::create;
            speed = 0.55f;
            health = 5200;
            armor = 10f;
            hitSize = 62;
            weapons = Seq.with(
                new Weapon("ymir-weapon") {{
                    reload = 30;
                    alternate = true;
                    x = 10;
                    y = 0;
                    shootCone = 10;
                    rotate = false;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(2.8f, 35) {{
                        width = 6;
                        height = 9;
                        lifetime = 55;
                        trailLength = 3;
                        trailColor = Color.valueOf("d4b040");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletBig;
                        despawnEffect = Fx.despawn;
                        keepVelocity = true;
                        splashDamage = 8;
                        splashDamageRadius = 16;
                    }};
                }}
            );
        }};

        thrymr = new UnitType("thrymr") {{
            constructor = MechUnit::create;
            speed = 0.5f;
            health = 10000;
            armor = 14f;
            hitSize = 74;
            weapons = Seq.with(
                new Weapon("thrymr-weapon") {{
                    reload = 40;
                    alternate = true;
                    x = 14;
                    y = 0;
                    shootCone = 8;
                    rotate = false;
                    shootSound = Sounds.shootArtillery;
                    bullet = new BasicBulletType(3f, 50) {{
                        width = 8;
                        height = 11;
                        lifetime = 60;
                        trailLength = 5;
                        trailColor = Color.valueOf("ff8844");
                        shootEffect = Fx.shootBig;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;
                        keepVelocity = true;
                        splashDamage = 25;
                        splashDamageRadius = 24;
                        knockback = 1.5f;
                    }};
                }}
            );
        }};

        bergelmir = new UnitType("bergelmir") {{
            constructor = MechUnit::create;
            speed = 0.45f;
            health = 17000;
            armor = 18f;
            hitSize = 118;
            weapons = Seq.with(
                new Weapon("bergelmir-weapon") {{
                    reload = 50;
                    alternate = true;
                    x = 20;
                    y = 0;
                    shootCone = 8;
                    rotate = false;
                    shootSound = Sounds.shootArtillery;
                    bullet = new BasicBulletType(3.2f, 70) {{
                        width = 10;
                        height = 13;
                        lifetime = 65;
                        trailLength = 6;
                        trailColor = Color.valueOf("ff6644");
                        shootEffect = Fx.shootBig;
                        hitEffect = Fx.massiveExplosion;
                        despawnEffect = Fx.massiveExplosion;
                        keepVelocity = true;
                        splashDamage = 40;
                        splashDamageRadius = 32;
                        knockback = 2f;
                    }};
                }}
            );
        }};

        surtr = new UnitType("surtr") {{
            constructor = MechUnit::create;
            speed = 0.4f;
            health = 25000;
            armor = 22f;
            hitSize = 159;
            weapons = Seq.with(
                new Weapon("surtr-weapon") {{
                    reload = 45;
                    alternate = true;
                    x = 24;
                    y = 0;
                    shootCone = 10;
                    rotate = false;
                    shootSound = Sounds.shootMalign;
                    bullet = new FlakBulletType(3f, 120) {{
                        width = 12;
                        height = 16;
                        lifetime = 55;
                        trailLength = 8;
                        trailColor = Color.valueOf("ff4400");
                        shootEffect = Fx.shootTitan;
                        hitEffect = Fx.titanExplosion;
                        despawnEffect = Fx.titanExplosion;
                        keepVelocity = true;
                        splashDamage = 80;
                        splashDamageRadius = 40;
                        knockback = 3f;
                        pierceCap = 2;
                        collidesGround = true;
                        collidesAir = true;
                    }};
                }}
            );
            abilities = Seq.with(
                new ForceFieldAbility(60, 0.3f, 200, 400) {{ }}
            );
        }};

        // ████████████████████████████████████████████████████████████████████████
        //  Naval tier
        // ████████████████████████████████████████████████████████████████████████

        aegir = new UnitType("aegir") {{
            constructor = UnitWaterMove::create;
            speed = 0.8f;
            health = 3000;
            armor = 5f;
            hitSize = 50;
            naval = true;
            trailLength = 12;
            rippleScale = 2;
            weapons = Seq.with(
                new Weapon("aegir-weapon") {{
                    reload = 25;
                    alternate = true;
                    x = 6;
                    y = 0;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 8;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3f, 15) {{
                        width = 5;
                        height = 7;
                        lifetime = 50;
                        trailLength = 3;
                        trailColor = Color.valueOf("60a0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletSmall;
                        keepVelocity = true;
                    }};
                }}
            );
        }};

        ran = new UnitType("ran") {{
            constructor = UnitWaterMove::create;
            speed = 0.72f;
            health = 7000;
            armor = 8f;
            hitSize = 79;
            naval = true;
            trailLength = 18;
            rippleScale = 3;
            weapons = Seq.with(
                new Weapon("ran-weapon") {{
                    reload = 30;
                    alternate = true;
                    x = 10;
                    y = 0;
                    shootCone = 12;
                    rotate = true;
                    rotateSpeed = 6;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3.2f, 28) {{
                        width = 6;
                        height = 9;
                        lifetime = 55;
                        trailLength = 4;
                        trailColor = Color.valueOf("60a0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletBig;
                        keepVelocity = true;
                        splashDamage = 10;
                        splashDamageRadius = 18;
                    }};
                }}
            );
        }};

        njordr = new UnitType("njordr") {{
            constructor = UnitWaterMove::create;
            speed = 0.65f;
            health = 13000;
            armor = 12f;
            hitSize = 79;
            naval = true;
            trailLength = 24;
            rippleScale = 4;
            weapons = Seq.with(
                new Weapon("njordr-weapon") {{
                    reload = 35;
                    alternate = true;
                    x = 14;
                    y = 0;
                    shootCone = 10;
                    rotate = true;
                    rotateSpeed = 5;
                    shootSound = Sounds.shootArtillery;
                    bullet = new BasicBulletType(3.5f, 45) {{
                        width = 8;
                        height = 11;
                        lifetime = 60;
                        trailLength = 6;
                        trailColor = Color.valueOf("4080ff");
                        shootEffect = Fx.shootBig;
                        hitEffect = Fx.blastExplosion;
                        keepVelocity = true;
                        splashDamage = 20;
                        splashDamageRadius = 24;
                        knockback = 1.5f;
                    }};
                }}
            );
        }};

        jormun = new UnitType("jormun") {{
            constructor = UnitWaterMove::create;
            speed = 0.57f;
            health = 21000;
            armor = 16f;
            hitSize = 159;
            naval = true;
            trailLength = 32;
            rippleScale = 6;
            weapons = Seq.with(
                new Weapon("jormun-weapon") {{
                    reload = 40;
                    alternate = true;
                    x = 18;
                    y = 0;
                    shootCone = 10;
                    rotate = true;
                    rotateSpeed = 4;
                    shootSound = Sounds.shootMissileLarge;
                    bullet = new MissileBulletType(3.8f, 65) {{
                        width = 8;
                        height = 12;
                        lifetime = 60;
                        trailLength = 8;
                        trailColor = Color.valueOf("4080ff");
                        shootEffect = Fx.shootBig;
                        hitEffect = Fx.massiveExplosion;
                        keepVelocity = true;
                        splashDamage = 35;
                        splashDamageRadius = 30;
                        knockback = 2f;
                        homingPower = 3f;
                        homingRange = 80;
                        weaveScale = 2f;
                        weaveMag = 0.5f;
                    }};
                }}
            );
        }};

        lyngbakr = new UnitType("lyngbakr") {{
            constructor = UnitWaterMove::create;
            speed = 0.5f;
            health = 30000;
            armor = 20f;
            hitSize = 223;
            naval = true;
            trailLength = 40;
            rippleScale = 8;
            weapons = Seq.with(
                new Weapon("lyngbakr-weapon") {{
                    reload = 50;
                    alternate = true;
                    x = 24;
                    y = 0;
                    shootCone = 8;
                    rotate = true;
                    rotateSpeed = 3;
                    shootSound = Sounds.shootMalign;
                    bullet = new BasicBulletType(3.5f, 120) {{
                        width = 12;
                        height = 16;
                        lifetime = 70;
                        trailLength = 10;
                        trailColor = Color.valueOf("2060ff");
                        shootEffect = Fx.shootTitan;
                        hitEffect = Fx.titanExplosion;
                        despawnEffect = Fx.titanExplosion;
                        keepVelocity = true;
                        splashDamage = 60;
                        splashDamageRadius = 40;
                        knockback = 3f;
                        pierceCap = 1;
                        fragBullets = 4;
                        fragVelocityMin = 0.5f;
                        fragVelocityMax = 1.5f;
                        fragBullet = new BasicBulletType(4f, 25) {{
                            width = 6;
                            height = 8;
                            lifetime = 30;
                            trailLength = 3;
                            trailColor = Color.valueOf("4080ff");
                            hitEffect = Fx.hitBulletBig;
                            splashDamage = 10;
                            splashDamageRadius = 16;
                        }};
                    }};
                }}
            );
        }};

        // ████████████████████████████████████████████████████████████████████████
        //  Special units
        // ████████████████████████████████████████████████████████████████████████

        /** Heavy flying dreadnought. */
        spearhead = new UnitType("spearhead") {{
            constructor = UnitEntity::create;
            speed = 0.75f;
            health = 19000;
            armor = 14f;
            hitSize = 183;
            flying = true;
            lowAltitude = true;
            engineSize = 6;
            trailLength = 9;
            weapons = Seq.with(
                new Weapon("spearhead-mainwp") {{
                    reload = 25;
                    alternate = true;
                    x = -16;
                    y = -8;
                    shootCone = 20;
                    rotate = true;
                    rotateSpeed = 3;
                    recoil = 3.5f;
                    shake = 2.5f;
                    shootSound = Sounds.shootMalign;
                    bullet = new PointLaserBulletType() {{
                        damage = 60;
                        lifetime = 25;
                        hitShake = 1;
                        shootEffect = Fx.absorb;
                        pierceArmor = true;
                        armorMultiplier = 2f;
                        impact = true;
                        scaleKeepVelocity = true;
                        keepVelocity = true;
                        spawnBullets = Seq.with(
                            new LightningBulletType() {{
                                damage = 20;
                                lifetime = 40;
                                speed = 1f;
                                hitSize = 4;
                                drawSize = 40;
                                lightningDamage = 20;
                                lightningLength = 15;
                                lightningLengthRand = 5;
                                lightningCone = 20;
                                lightningAngle = 30;
                                lightningColor = Color.valueOf("FEB380");
                                shootSound = Sounds.explosion;
                                collidesAir = true;
                                collidesGround = true;
                                fragBullets = 9;
                                fragVelocityMin = 0.2f;
                                fragVelocityMax = 1f;
                                fragLifeMin = 1f;
                                fragLifeMax = 1f;
                            }}
                        );
                    }};
                }},
                new Weapon("spearhead-wp2") {{
                    reload = 17;
                    alternate = true;
                    x = -10;
                    y = 16;
                    shootCone = 20;
                    rotate = true;
                    rotateSpeed = 5;
                    shake = 1;
                    recoil = 2f;
                    shootSound = Sounds.shootMalign;
                    bullet = new PointLaserBulletType() {{
                        damage = 40;
                        lifetime = 22;
                        hitShake = 1;
                        shootEffect = Fx.absorb;
                        inaccuracy = 1f;
                        scaleKeepVelocity = true;
                        keepVelocity = true;
                        spawnBullets = Seq.with(
                            new LightningBulletType() {{
                                damage = 10;
                                lifetime = 40;
                                speed = 1f;
                                hitSize = 4;
                                drawSize = 40;
                                lightningDamage = 10;
                                lightningLength = 10;
                                lightningLengthRand = 5;
                                lightningCone = 50;
                                lightningAngle = 20;
                                lightningColor = Color.valueOf("FEB380");
                                shootSound = Sounds.explosion;
                                collidesAir = true;
                                collidesGround = true;
                            }}
                        );
                    }};
                }}
            );
            abilities = Seq.with(
                new ForceFieldAbility(80, 0.5f, 0, 500) {{ }}
            );
        }};

        /** Aerial support gunship. */
        altiar = new UnitType("altiar") {{
            constructor = UnitEntity::create;
            speed = 1.2f;
            health = 8000;
            armor = 8f;
            hitSize = 130;
            flying = true;
            lowAltitude = true;
            engineSize = 4;
            trailLength = 6;
            weapons = Seq.with(
                new Weapon("altiar-weapon") {{
                    reload = 15;
                    alternate = false;
                    x = 0;
                    y = 0;
                    shootCone = 30;
                    rotate = true;
                    rotateSpeed = 15;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3.5f, 30) {{
                        width = 6;
                        height = 9;
                        lifetime = 45;
                        trailLength = 4;
                        trailColor = Color.valueOf("80c0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletBig;
                        keepVelocity = true;
                        splashDamage = 12;
                        splashDamageRadius = 20;
                    }};
                }}
            );
        }};

        /** Colossal naval fortress. */
        cetus = new UnitType("cetus") {{
            constructor = UnitWaterMove::create;
            speed = 0.5f;
            health = 25000;
            armor = 18f;
            hitSize = 70;
            naval = true;
            rippleScale = 10;
            trailLength = 50;
            weapons = Seq.with(
                new Weapon("cetus-mainwp") {{
                    reload = 12;
                    alternate = true;
                    x = -7;
                    y = -5;
                    shootCone = 10;
                    rotate = true;
                    rotateSpeed = 5;
                    recoil = 2f;
                    shake = 0.2f;
                    shootSound = Sounds.shootCyclone;
                    bullet = new BasicBulletType(7f, 40) {{
                        width = 8;
                        height = 11;
                        lifetime = 30;
                        trailLength = 2;
                        hitEffect = Fx.explosion;
                        despawnEffect = Fx.explosion;
                        keepVelocity = true;
                        splashDamage = 10;
                        splashDamageRadius = 16;
                        pierceArmor = true;
                        fragBullets = 2;
                        fragVelocityMin = 0.5f;
                        fragVelocityMax = 1.5f;
                        fragLifeMin = 1f;
                        fragLifeMax = 2f;
                        fragBullet = new BasicBulletType(7f, 10) {{
                            width = 7;
                            height = 9;
                            lifetime = 15;
                            trailLength = 2;
                            hitEffect = Fx.explosion;
                            despawnEffect = Fx.explosion;
                            keepVelocity = true;
                            splashDamage = 10;
                            splashDamageRadius = 16;
                        }};
                    }};
                }},
                new Weapon("cetus-wp1") {{
                    reload = 30;
                    alternate = true;
                    x = -3;
                    y = -1;
                    shootCone = 10;
                    rotate = true;
                    rotateSpeed = 10;
                    shootSound = Sounds.shootDuo;
                    bullet = new BasicBulletType(5f, 15) {{
                        width = 6;
                        height = 9;
                        lifetime = 35;
                        trailLength = 3;
                        hitEffect = Fx.hitBulletSmall;
                        keepVelocity = true;
                    }};
                }},
                new Weapon("cetus-wp2") {{
                    reload = 30;
                    alternate = true;
                    x = 3;
                    y = 1;
                    shootCone = 10;
                    rotate = true;
                    rotateSpeed = 10;
                    shootSound = Sounds.shootDuo;
                    bullet = new BasicBulletType(5f, 15) {{
                        width = 6;
                        height = 9;
                        lifetime = 35;
                        trailLength = 3;
                        hitEffect = Fx.hitBulletSmall;
                        keepVelocity = true;
                    }};
                }}
            );
            abilities = Seq.with(
                new ShieldArcAbility() {{ radius = 30; regen = 1f; max = 200; }}
            );
        }};

        // ████████████████████████████████████████████████████████████████████████
        //  Flying-2 Attacker — Fenrir line (Norse giant creatures)
        // ████████████████████████████████████████████████████████████████████████

        fenrir = new UnitType("fenrir") {{
            constructor = UnitEntity::create;
            speed = 1.8f;
            health = 600;
            armor = 2f;
            hitSize = 50;
            flying = true;
            lowAltitude = true;
            engineSize = 2;
            trailLength = 3;
            weapons = Seq.with(
                new Weapon("fenrir-weapon") {{
                    reload = 18;
                    alternate = true;
                    x = 6;
                    y = 0;
                    shootCone = 20;
                    rotate = true;
                    rotateSpeed = 12;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3f, 8) {{
                        width = 4;
                        height = 6;
                        lifetime = 35;
                        trailLength = 2;
                        trailColor = Color.valueOf("80c0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletSmall;
                        keepVelocity = true;
                    }};
                }}
            );
        }};

        garmr = new UnitType("garmr") {{
            constructor = UnitEntity::create;
            speed = 1.6f;
            health = 1800;
            armor = 4f;
            hitSize = 79;
            flying = true;
            lowAltitude = true;
            engineSize = 3;
            trailLength = 4;
            weapons = Seq.with(
                new Weapon("garmr-weapon") {{
                    reload = 20;
                    alternate = true;
                    x = 10;
                    y = 0;
                    shootCone = 18;
                    rotate = true;
                    rotateSpeed = 10;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3.2f, 16) {{
                        width = 5;
                        height = 8;
                        lifetime = 40;
                        trailLength = 3;
                        trailColor = Color.valueOf("80c0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletSmall;
                        keepVelocity = true;
                    }};
                }}
            );
        }};

        draugr = new UnitType("draugr") {{
            constructor = UnitEntity::create;
            speed = 1.4f;
            health = 5000;
            armor = 7f;
            hitSize = 79;
            flying = true;
            lowAltitude = true;
            engineSize = 4;
            trailLength = 5;
            weapons = Seq.with(
                new Weapon("draugr-weapon") {{
                    reload = 22;
                    alternate = true;
                    x = 14;
                    y = 0;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 8;
                    shootSound = Sounds.shootLaser;
                    bullet = new LaserBoltBulletType() {{
                        damage = 28;
                        speed = 4f;
                        lifetime = 45;
                        width = 4;
                        height = 7;
                        trailLength = 4;
                        trailColor = Color.valueOf("60a0ff");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitLaser;
                        keepVelocity = true;
                        frontColor = Color.valueOf("80c0ff");
                        backColor = Color.valueOf("4080c0");
                        lightningColor = Color.valueOf("80c0ff");
                    }};
                }}
            );
        }};

        ragnar = new UnitType("ragnar") {{
            constructor = UnitEntity::create;
            speed = 1.1f;
            health = 14000;
            armor = 12f;
            hitSize = 159;
            flying = true;
            lowAltitude = true;
            engineSize = 6;
            trailLength = 7;
            weapons = Seq.with(
                new Weapon("ragnar-weapon") {{
                    reload = 35;
                    alternate = true;
                    x = 20;
                    y = 0;
                    shootCone = 12;
                    rotate = true;
                    rotateSpeed = 5;
                    shootSound = Sounds.shootLaser;
                    bullet = new PointLaserBulletType() {{
                        damage = 65;
                        lifetime = 28;
                        hitShake = 1;
                        shootEffect = Fx.absorb;
                        hitEffect = Fx.hitLaser;
                        keepVelocity = true;
                    }};
                }}
            );
        }};

        // ████████████████████████████████████████████████████████████████████████
        //  Flying-3 Attacker — Diphda, Procyon, Sirius
        // ████████████████████████████████████████████████████████████████████████

        diphda = new UnitType("diphda") {{
            constructor = UnitEntity::create;
            speed = 2.5f;
            health = 400;
            armor = 1f;
            hitSize = 40;
            flying = true;
            lowAltitude = true;
            engineSize = 1;
            trailLength = 6;
            omniMovement = false;
            rotateSpeed = 5;
            weapons = Seq.with(
                new Weapon("diphda-weapon") {{
                    reload = 8;
                    alternate = true;
                    x = 0;
                    y = 1;
                    shootCone = 20;
                    rotate = false;
                    inaccuracy = 2f;
                    shootSound = Sounds.shootLaser;
                    bullet = new LaserBoltBulletType() {{
                        damage = 20;
                        speed = 4f;
                        lifetime = 50;
                        width = 3;
                        trailLength = 3;
                        trailColor = Color.valueOf("FEB380");
                        shootEffect = Fx.hitLaser;
                        keepVelocity = true;
                        frontColor = Color.valueOf("FEB380");
                        backColor = Color.valueOf("C06040");
                        lightningColor = Color.valueOf("FEB380");
                    }};
                }}
            );
        }};

        procyon = new UnitType("procyon") {{
            constructor = UnitEntity::create;
            speed = 2.2f;
            health = 1200;
            armor = 3f;
            hitSize = 60;
            flying = true;
            lowAltitude = true;
            engineSize = 2;
            trailLength = 7;
            rotateSpeed = 4;
            weapons = Seq.with(
                new Weapon("procyon-weapon") {{
                    reload = 12;
                    alternate = true;
                    x = 8;
                    y = 0;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 8;
                    inaccuracy = 1f;
                    shootSound = Sounds.shootLaser;
                    bullet = new LaserBoltBulletType() {{
                        damage = 35;
                        speed = 4.5f;
                        lifetime = 55;
                        width = 4;
                        height = 7;
                        trailLength = 4;
                        trailColor = Color.valueOf("FEB380");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitLaser;
                        keepVelocity = true;
                        frontColor = Color.valueOf("FFC080");
                        backColor = Color.valueOf("C08040");
                        lightningColor = Color.valueOf("FEB380");
                    }};
                }}
            );
        }};

        sirius = new UnitType("sirius") {{
            constructor = UnitEntity::create;
            speed = 1.9f;
            health = 4000;
            armor = 6f;
            hitSize = 87;
            flying = true;
            lowAltitude = true;
            engineSize = 3;
            trailLength = 8;
            rotateSpeed = 3;
            weapons = Seq.with(
                new Weapon("sirius-weapon") {{
                    reload = 28;
                    alternate = true;
                    x = 12;
                    y = 0;
                    shootCone = 12;
                    rotate = true;
                    rotateSpeed = 6;
                    shootSound = Sounds.shootMalign;
                    bullet = new PointLaserBulletType() {{
                        damage = 50;
                        lifetime = 25;
                        hitShake = 1;
                        shootEffect = Fx.absorb;
                        hitEffect = Fx.hitLaser;
                        keepVelocity = true;
                    }};
                }},
                new Weapon("sirius-sup-weapon") {{
                    reload = 20;
                    alternate = true;
                    x = -6;
                    y = 8;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 8;
                    shootSound = Sounds.shootLaser;
                    bullet = new LaserBoltBulletType() {{
                        damage = 25;
                        speed = 4f;
                        lifetime = 45;
                        width = 3;
                        trailLength = 3;
                        trailColor = Color.valueOf("FEB380");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitLaser;
                        keepVelocity = true;
                        frontColor = Color.valueOf("FFC080");
                        backColor = Color.valueOf("C08040");
                    }};
                }}
            );
        }};

        // ████████████████████████████████████████████████████████████████████████
        //  Supporter line — Norse gods (flying support units)
        // ████████████████████████████████████████████████████████████████████████

        mimir = new UnitType("mimir") {{
            constructor = UnitEntity::create;
            speed = 1.6f;
            health = 500;
            armor = 2f;
            hitSize = 30;
            flying = true;
            lowAltitude = true;
            engineSize = 1;
            trailLength = 3;
            weapons = Seq.with(
                new Weapon("mimir-weapon") {{
                    reload = 25;
                    alternate = true;
                    x = 5;
                    y = 0;
                    shootCone = 20;
                    rotate = true;
                    rotateSpeed = 10;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3f, 8) {{
                        width = 4;
                        height = 6;
                        lifetime = 40;
                        trailLength = 2;
                        trailColor = Color.valueOf("80ff80");
                        shootEffect = Fx.shootHeal;
                        hitEffect = Fx.heal;
                        keepVelocity = true;
                        healPercent = 2f;
                    }};
                }}
            );
            abilities = Seq.with(
                new RegenAbility() {{ percentAmount = 0.3f; }}
            );
        }};

        hermodr = new UnitType("hermodr") {{
            constructor = UnitEntity::create;
            speed = 1.4f;
            health = 1400;
            armor = 4f;
            hitSize = 40;
            flying = true;
            lowAltitude = true;
            engineSize = 2;
            trailLength = 4;
            weapons = Seq.with(
                new Weapon("hermodr-weapon") {{
                    reload = 22;
                    alternate = true;
                    x = 8;
                    y = 0;
                    shootCone = 18;
                    rotate = true;
                    rotateSpeed = 8;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(3f, 12) {{
                        width = 5;
                        height = 7;
                        lifetime = 45;
                        trailLength = 3;
                        trailColor = Color.valueOf("80ff80");
                        shootEffect = Fx.shootHeal;
                        hitEffect = Fx.heal;
                        keepVelocity = true;
                        healPercent = 3f;
                    }};
                }}
            );
            abilities = Seq.with(
                new RepairFieldAbility(20, 40, 60) {{ }}
            );
        }};

        bragi = new UnitType("bragi") {{
            constructor = UnitEntity::create;
            speed = 1.2f;
            health = 3800;
            armor = 7f;
            hitSize = 60;
            flying = true;
            lowAltitude = true;
            engineSize = 3;
            trailLength = 5;
            weapons = Seq.with(
                new Weapon("bragi-weapon") {{
                    reload = 28;
                    alternate = true;
                    x = 10;
                    y = 0;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 6;
                    shootSound = Sounds.shootLaser;
                    bullet = new LaserBoltBulletType() {{
                        damage = 20;
                        speed = 4f;
                        lifetime = 50;
                        width = 4;
                        height = 7;
                        trailLength = 4;
                        trailColor = Color.valueOf("80ff80");
                        shootEffect = Fx.shootHeal;
                        hitEffect = Fx.heal;
                        keepVelocity = true;
                        frontColor = Color.valueOf("80ff80");
                        backColor = Color.valueOf("40c040");
                        lightningColor = Color.valueOf("80ff80");
                        healPercent = 4f;
                    }};
                }}
            );
            abilities = Seq.with(
                new RepairFieldAbility(30, 50, 120) {{ }}
            );
        }};

        forseti = new UnitType("forseti") {{
            constructor = UnitEntity::create;
            speed = 1.0f;
            health = 8000;
            armor = 10f;
            hitSize = 87;
            flying = true;
            lowAltitude = true;
            engineSize = 4;
            trailLength = 6;
            weapons = Seq.with(
                new Weapon("forseti-weapon") {{
                    reload = 32;
                    alternate = true;
                    x = 14;
                    y = 0;
                    shootCone = 12;
                    rotate = true;
                    rotateSpeed = 5;
                    shootSound = Sounds.shoot;
                    bullet = new PointLaserBulletType() {{
                        damage = 45;
                        lifetime = 25;
                        hitShake = 1;
                        shootEffect = Fx.absorb;
                        hitEffect = Fx.heal;
                        keepVelocity = true;
                        healPercent = 5f;
                    }};
                }}
            );
            abilities = Seq.with(
                new StatusFieldAbility(StatusEffects.overclock, 60f, 100, 120) {{ }}
            );
        }};

        tyr = new UnitType("tyr") {{
            constructor = UnitEntity::create;
            speed = 0.9f;
            health = 16000;
            armor = 14f;
            hitSize = 118;
            flying = true;
            lowAltitude = true;
            engineSize = 5;
            trailLength = 7;
            weapons = Seq.with(
                new Weapon("tyr-weapon") {{
                    reload = 35;
                    alternate = true;
                    x = 18;
                    y = 0;
                    shootCone = 10;
                    rotate = true;
                    rotateSpeed = 4;
                    shootSound = Sounds.shootMalign;
                    bullet = new PointLaserBulletType() {{
                        damage = 70;
                        lifetime = 28;
                        hitShake = 2;
                        shootEffect = Fx.absorb;
                        hitEffect = Fx.hitBeam;
                        keepVelocity = true;
                        pierceArmor = true;
                        healPercent = 3f;
                    }};
                }},
                new Weapon("tyr-sup-weapon1") {{
                    reload = 20;
                    alternate = true;
                    x = -8;
                    y = 10;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 6;
                    shootSound = Sounds.shootLaser;
                    bullet = new LaserBoltBulletType() {{
                        damage = 30;
                        speed = 4.5f;
                        lifetime = 45;
                        width = 4;
                        trailLength = 3;
                        trailColor = Color.valueOf("80ff80");
                        shootEffect = Fx.shootHeal;
                        hitEffect = Fx.heal;
                        keepVelocity = true;
                        frontColor = Color.valueOf("80ff80");
                        backColor = Color.valueOf("40c040");
                        healPercent = 3f;
                    }};
                }}
            );
            abilities = Seq.with(
                new ForceFieldAbility(100, 0.4f, 0, 600) {{ }}
            );
        }};

        vidarr = new UnitType("vidarr") {{
            constructor = UnitEntity::create;
            speed = 0.7f;
            health = 30000;
            armor = 20f;
            hitSize = 183;
            flying = true;
            lowAltitude = true;
            engineSize = 7;
            trailLength = 9;
            weapons = Seq.with(
                new Weapon("vidarr-weapon") {{
                    reload = 40;
                    alternate = true;
                    x = 24;
                    y = 0;
                    shootCone = 8;
                    rotate = true;
                    rotateSpeed = 3;
                    shootSound = Sounds.shootMalign;
                    bullet = new PointLaserBulletType() {{
                        damage = 120;
                        lifetime = 30;
                        hitShake = 3;
                        shootEffect = Fx.absorb;
                        hitEffect = Fx.massiveExplosion;
                        keepVelocity = true;
                        pierceArmor = true;
                        armorMultiplier = 2f;
                        impact = true;
                        scaleKeepVelocity = true;
                        spawnBullets = Seq.with(
                            new LightningBulletType() {{
                                damage = 30;
                                lifetime = 35;
                                speed = 1f;
                                hitSize = 5;
                                drawSize = 50;
                                lightningDamage = 30;
                                lightningLength = 20;
                                lightningLengthRand = 8;
                                lightningCone = 30;
                                lightningAngle = 40;
                                lightningColor = Color.valueOf("80ff80");
                                shootSound = Sounds.explosion;
                            }}
                        );
                    }};
                }},
                new Weapon("vidarr-sup-weapon1") {{
                    reload = 15;
                    alternate = true;
                    x = -12;
                    y = 14;
                    shootCone = 15;
                    rotate = true;
                    rotateSpeed = 5;
                    shootSound = Sounds.shootMalign;
                    bullet = new LaserBoltBulletType() {{
                        damage = 40;
                        speed = 4.5f;
                        lifetime = 50;
                        width = 5;
                        height = 8;
                        trailLength = 4;
                        trailColor = Color.valueOf("80ff80");
                        shootEffect = Fx.shootHeal;
                        hitEffect = Fx.healWave;
                        keepVelocity = true;
                        frontColor = Color.valueOf("80ff80");
                        backColor = Color.valueOf("40c040");
                        healPercent = 5f;
                    }};
                }}
            );
            abilities = Seq.with(
                new ForceFieldAbility(120, 0.3f, 0, 1000) {{ }},
                new RepairFieldAbility(40, 60, 200) {{ }}
            );
        }};

        // ████████████████████████████████████████████████████████████████████████
        //  Core ground — Einherjar (Mech units)
        // ████████████████████████████████████████████████████████████████████████

        einherjar = new UnitType("einherjar") {{
            constructor = MechUnit::create;
            speed = 0.65f;
            health = 900;
            armor = 4f;
            hitSize = 34;
            weapons = Seq.with(
                new Weapon("einherjar-weapon") {{
                    reload = 30;
                    alternate = true;
                    x = 5;
                    y = 0;
                    shootCone = 10;
                    rotate = false;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(2.5f, 12) {{
                        width = 4;
                        height = 6;
                        lifetime = 45;
                        trailLength = 2;
                        trailColor = Color.valueOf("d4b040");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletSmall;
                        keepVelocity = true;
                    }};
                }}
            );
        }};

        berserkr = new UnitType("berserkr") {{
            constructor = MechUnit::create;
            speed = 0.58f;
            health = 2400;
            armor = 7f;
            hitSize = 43;
            weapons = Seq.with(
                new Weapon("berserkr-weapon") {{
                    reload = 28;
                    alternate = true;
                    x = 8;
                    y = 0;
                    shootCone = 10;
                    rotate = false;
                    shootSound = Sounds.shoot;
                    bullet = new BasicBulletType(2.8f, 25) {{
                        width = 6;
                        height = 8;
                        lifetime = 50;
                        trailLength = 3;
                        trailColor = Color.valueOf("d4b040");
                        shootEffect = Fx.shootSmall;
                        hitEffect = Fx.hitBulletBig;
                        keepVelocity = true;
                        splashDamage = 8;
                        splashDamageRadius = 14;
                    }};
                }}
            );
        }};

        ulfhednar = new UnitType("ulfhednar") {{
            constructor = MechUnit::create;
            speed = 0.5f;
            health = 6000;
            armor = 11f;
            hitSize = 51;
            weapons = Seq.with(
                new Weapon("ulfhednar-weapon") {{
                    reload = 35;
                    alternate = true;
                    x = 12;
                    y = 0;
                    shootCone = 8;
                    rotate = false;
                    shootSound = Sounds.shootArtillery;
                    bullet = new BasicBulletType(3f, 45) {{
                        width = 8;
                        height = 11;
                        lifetime = 55;
                        trailLength = 5;
                        trailColor = Color.valueOf("ff8844");
                        shootEffect = Fx.shootBig;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;
                        keepVelocity = true;
                        splashDamage = 20;
                        splashDamageRadius = 22;
                        knockback = 1.5f;
                    }};
                }}
            );
        }};

        // ████████████████████████████████████████████████████████████████████████
        //  Groupings
        // ████████████████████████████████████████████████████████████████████████

        airUnits = Seq.with(
            herja, eir, hlokk, gondul, skogul
        );

        mechUnits = Seq.with(
            jotunn, ymir, thrymr, bergelmir, surtr
        );

        navalUnits = Seq.with(
            aegir, ran, njordr, jormun, lyngbakr
        );

        fenrirLine = Seq.with(
            fenrir, garmr, draugr, ragnar
        );

        diphdaLine = Seq.with(
            diphda, procyon, sirius
        );

        supporterLine = Seq.with(
            mimir, hermodr, bragi, forseti, tyr, vidarr
        );

        einherjarLine = Seq.with(
            einherjar, berserkr, ulfhednar
        );

        allUnits = Seq.with(
            herja, eir, hlokk, gondul, skogul,
            jotunn, ymir, thrymr, bergelmir, surtr,
            aegir, ran, njordr, jormun, lyngbakr,
            spearhead, altiar, cetus,
            fenrir, garmr, draugr, ragnar,
            diphda, procyon, sirius,
            mimir, hermodr, bragi, forseti, tyr, vidarr,
            einherjar, berserkr, ulfhednar
        );
    }
}
