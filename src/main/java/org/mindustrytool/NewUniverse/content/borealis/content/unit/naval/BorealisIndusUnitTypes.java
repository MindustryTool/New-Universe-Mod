package org.mindustrytool.NewUniverse.content.borealis.content.unit.naval;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.gen.UnitWaterMove;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.NoArgsConstructor;

@Singleton
@NoArgsConstructor(onConstructor_ = @Inject)
public class BorealisIndusUnitTypes {

    public UnitType indus;
    public UnitType imperi;
    public UnitType sruza;
    public UnitType crater;
    public UnitType cetus;

    public void loadContent() {
        indus();
        imperi();
        sruza();
        crater();
        cetus();
    }

    private void indus() {
        indus = new UnitType("indus") {{
            constructor = UnitWaterMove::create;
            health = 275;
            armor = 3;
            speed = 0.7f;
            hitSize = 10;
            omniMovement = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            trailLength = 15;
            naval = true;

            weapons.add(new Weapon("new-universe-indus-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -3.5f;
                y = -1;
                shootY = 4;
                shootX = 0.3f;
                reload = 20;
                shootCone = 10;
                inaccuracy = 1;
                recoil = 1.5f;
                rotateSpeed = 10;
                shootSound = Sounds.shootDuo;
                shoot = new ShootSpread() {{
                    shots = 3;
                }};

                bullet = new BasicBulletType() {{
                    damage = 10;
                    speed = 3;
                    lifetime = 45;
                    width = 6;
                    height = 9;
                    trailLength = 3;
                    shootEffect = Fx.shootSmall;
                }};
            }});
        }};
    }

    private void imperi() {
        imperi = new UnitType("imperi") {{
            constructor = UnitWaterMove::create;
            health = 625;
            armor = 6;
            speed = 0.8f;
            rotateSpeed = 3f;
            hitSize = 15;
            omniMovement = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            trailLength = 20;
            trailScl = 2;
            waveTrailX = 6.5f;
            waveTrailY = -12;
            naval = true;

            weapons.add(new Weapon("new-universe-imperi-weapon-1") {{
                mirror = false;
                alternate = false;
                rotate = true;
                top = true;
                x = 0;
                y = 4.5f;
                shootY = 5.7f;
                reload = 30;
                shootCone = 5;
                inaccuracy = 1;
                recoil = 1.5f;
                shake = 0.25f;
                rotateSpeed = 6;
                shootSound = Sounds.shootArtillery;

                bullet = new ArtilleryBulletType() {{
                    damage = 10;
                    speed = 4;
                    lifetime = 70;
                    splashDamage = 10;
                    splashDamageRadius = 16;
                    width = 7;
                    height = 11;
                    trailWidth = 3.5f;
                    trailLength = 5;
                    shootEffect = Fx.shootSmall;
                }};
            }});

            weapons.add(new Weapon("new-universe-imperi-weapon-2") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -6.25f;
                y = -6.25f;
                shootY = 5.5f;
                shootX = 0.025f;
                reload = 22.5f;
                shootCone = 10;
                inaccuracy = 2;
                recoil = 1.5f;
                shake = 0.25f;
                rotateSpeed = 7.5f;
                shootSound = Sounds.shootDuo;

                bullet = new BasicBulletType() {{
                    damage = 10;
                    speed = 5;
                    lifetime = 45;
                    trailLength = 3;
                    trailWidth = 2.5f;
                    height = 9;
                    shootEffect = Fx.shootSmall;
                }};
            }});
        }};
    }

    private void sruza() {
        sruza = new UnitType("sruza") {{
            constructor = UnitWaterMove::create;
            health = 940;
            armor = 5;
            speed = 0.85f;
            rotateSpeed = 3f;
            baseRotateSpeed = 3;
            hitSize = 20;
            itemCapacity = 200;
            omniMovement = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            naval = true;
            rippleScale = 3;
            groundLayer = 60;
            trailLength = 22;
            trailScl = 1.5f;
            waveTrailX = 7;
            waveTrailY = -9;
            buildSpeed = 0;
            mineTier = 0;

            weapons.add(new Weapon("new-universe-sruza-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -7;
                y = -5;
                shootY = 3;
                reload = 12;
                shootCone = 10;
                inaccuracy = 3;
                recoil = 1.5f;
                shake = 0.2f;
                minWarmup = 1;
                shootSound = Sounds.shootCyclone;

                bullet = new BasicBulletType() {{
                    damage = 40;
                    speed = 7;
                    lifetime = 30;
                    splashDamage = 10;
                    splashDamageRadius = 16;
                    width = 8;
                    height = 11;
                    trailLength = 2;
                    trailWidth = 3;
                    pierceArmor = true;
                    hitShake = 0.2f;
                    impact = true;
                    shootEffect = Fx.shootSmall;
                    fragBullets = 2;
                    fragLifeMax = 2;
                    fragSpread = 20;
                    fragAngle = 5;
                    fragRandomSpread = 50;

                    fragBullet = new BasicBulletType() {{
                        damage = 10;
                        speed = 7;
                        lifetime = 15;
                        splashDamage = 10;
                        splashDamageRadius = 16;
                        width = 7;
                        height = 9;
                        trailLength = 2;
                    }};
                }};
            }});
        }};
    }

    private void crater() {
        crater = new UnitType("crater") {{
            constructor = UnitWaterMove::create;
            health = 11000;
            armor = 13;
            speed = 0.7f;
            rotateSpeed = 1.5f;
            hitSize = 40;
            omniMovement = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            naval = true;
            rippleScale = 4;
            trailLength = 40;
            trailScl = 3;
            waveTrailX = 11.5f;
            waveTrailY = -24;
            allowedInPayloads = false;

            weapons.add(new Weapon("new-universe-crater-weapon-1") {{
                mirror = true;
                rotate = true;
                top = true;
                x = 9;
                y = -5;
                shootY = 7;
                reload = 37.5f;
                shootCone = 5;
                inaccuracy = 1;
                recoil = 1.5f;
                shake = 1;
                rotateSpeed = 3.5f;
                shootSound = Sounds.shootSpectre;

                bullet = new BasicBulletType() {{
                    damage = 50;
                    speed = 7;
                    lifetime = 30;
                    trailLength = 3;
                    width = 7;
                    height = 17;
                    hitShake = 0.2f;
                    shootEffect = Fx.shootSmall;
                    makeFire = true;
                    bulletInterval = 5;

                    intervalBullet = new ArtilleryBulletType() {{
                        damage = 0;
                        width = 0;
                        height = 0;
                        speed = 0;
                        lifetime = 1;
                        trailEffect = Fx.fire;
                        impact = true;
                        despawnEffect = Fx.none;
                        hitEffect = Fx.none;
                    }};
                }};
            }});

            weapons.add(new Weapon("new-universe-crater-weapon-2") {{
                mirror = true;
                rotate = true;
                top = true;
                x = 17.5f;
                y = -15;
                shootY = 3;
                reload = 65;
                shootCone = 5;
                inaccuracy = 6.5f;
                recoil = 1.5f;
                shake = 0.5f;
                rotateSpeed = 10;
                shootSound = Sounds.shootMissileSmall;

                bullet = new MissileBulletType() {{
                    damage = 25;
                    speed = 4;
                    splashDamage = 15;
                    splashDamageRadius = 16;
                    shootEffect = Fx.shootSmall;
                }};
            }});

            weapons.add(new Weapon("new-universe-crater-weapon-3") {{
                mirror = true;
                rotate = true;
                top = true;
                x = -9;
                y = 9.5f;
                shootY = 4;
                shootX = 0.2f;
                reload = 10;
                rotateSpeed = 15;
                autoTarget = true;
                controllable = false;
                shootSound = Sounds.shoot;

                bullet = new BulletType() {{
                    damage = 25;
                }};
            }});
        }};
    }

    private void cetus() {
        cetus = new UnitType("cetus") {{
            constructor = UnitWaterMove::create;
            health = 23500;
            armor = 14;
            speed = 0.55f;
            rotateSpeed = 1f;
            hitSize = 60;
            itemCapacity = 1000;
            omniMovement = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            naval = true;
            rippleScale = 10;
            trailLength = 50;
            trailScl = 3;
            waveTrailX = 20;
            waveTrailY = -36.5f;
            canDrown = false;
            allowedInPayloads = false;

            weapons.add(new Weapon("new-universe-cetus-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = true;
                x = -15;
                y = 16;
                shootY = 5.5f;
                reload = 60;
                shootCone = 10;
                inaccuracy = 2;
                recoil = 2;
                shake = 2;
                rotateSpeed = 3.5f;
                shootSound = Sounds.explosionQuad;
                shoot = new ShootSpread() {{
                    shots = 5;
                    shotDelay = 5;
                }};

                bullet = new BasicBulletType() {{
                    damage = 40;
                    speed = 9;
                    splashDamage = 20;
                    splashDamageRadius = 52;
                    impact = true;
                    hitShake = 1;
                    trailLength = 4;
                    width = 7;
                    height = 17;
                    bulletInterval = 5;
                    shootEffect = Fx.shootBig;

                    intervalBullet = new LightningBulletType() {{
                        damage = 10;
                        lightningLength = 4;
                    }};
                }};
            }});

            weapons.add(new Weapon("new-universe-cetus-weapon-2") {{
                mirror = false;
                alternate = false;
                rotate = true;
                top = true;
                x = 0;
                y = -6;
                shootY = 8.5f;
                reload = 300;
                shootCone = 5;
                inaccuracy = 3.5f;
                recoil = 3;
                shake = 3;
                rotateSpeed = 1.5f;
                autoTarget = true;
                controllable = false;
                shootSound = Sounds.acceleratorLaunch;
                chargeSound = Sounds.chargeVela;
                shoot = new ShootSpread() {{
                    shots = 10;
                    shotDelay = 4;
                    firstShotDelay = 50;
                }};

                bullet = new ArtilleryBulletType() {{
                    damage = 150;
                    speed = 15;
                    lifetime = 50;
                    splashDamage = 50;
                    splashDamageRadius = 32;
                    splashDamagePierce = true;
                    impact = true;
                    hitShake = 1;
                    trailLength = 12;
                    trailWidth = 4;
                    width = 15;
                    height = 22;
                    drag = 0.03f;
                    shootEffect = Fx.shootSmokeSmite;
                    bulletInterval = 5;
                    trailColor = Color.valueOf("BF92F8");
                    fragBullets = 1;

                    intervalBullet = new LightningBulletType() {{
                        damage = 20;
                        lightningLength = 4;
                    }};

                    fragBullet = new LightningBulletType() {{
                        damage = 75;
                        splashDamage = 75;
                        splashDamageRadius = 120;
                        despawnSound = Sounds.blockExplodeElectricBig;
                        hitSound = Sounds.blockExplodeElectricBig;
                    }};
                }};
            }});

            weapons.add(new Weapon("new-universe-cetus-weapon-3") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = 21;
                y = -18;
                shootY = 5.5f;
                reload = 60;
                shootCone = 10;
                inaccuracy = 2;
                recoil = 2;
                shake = 2;
                rotateSpeed = 3.5f;
                shootSound = Sounds.explosionQuad;
                shoot = new ShootSpread() {{
                    shots = 5;
                    shotDelay = 5;
                }};

                bullet = new BasicBulletType() {{
                    damage = 40;
                    speed = 9;
                    splashDamage = 20;
                    splashDamageRadius = 52;
                    impact = true;
                    hitShake = 1;
                    trailLength = 4;
                    width = 7;
                    height = 17;
                    bulletInterval = 5;
                    shootEffect = Fx.shootBig;

                    intervalBullet = new LightningBulletType() {{
                        damage = 10;
                        lightningLength = 4;
                    }};
                }};
            }});
        }};
    }
}
