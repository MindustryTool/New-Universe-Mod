package org.mindustrytool.NewUniverse.content.borealis.content.unit.air;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.bullet.PointLaserBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.NoArgsConstructor;

@Singleton
@NoArgsConstructor(onConstructor_ = @Inject)
public class BorealisDiphdaUnitTypes {

    public UnitType diphda;
    public UnitType procyon;
    public UnitType sirius;
    public UnitType altiar;
    public UnitType spearhead;

    public void loadContent() {
        diphda();
        procyon();
        sirius();
        altiar();
        spearhead();
    }

    private void diphda() {
        diphda = new UnitType("diphda") {{
            constructor = UnitEntity::create;
            flying = true;
            health = 90;
            armor = 1;
            speed = 2.5f;
            rotateSpeed = 5f;
            hitSize = 9;
            omniMovement = false;
            lowAltitude = true;
            faceTarget = true;
            rotateMoveFirst = true;
            range = 190;
            maxRange = 200;
            itemCapacity = 20;
            trailLength = 6;
            trailScl = 1;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            groundLayer = 80;

            weapons.add(new Weapon("new-universe-diphda-weapon") {{
                mirror = false;
                alternate = true;
                rotate = false;
                x = 0;
                shootY = 1;
                reload = 8;
                shoot.shots = 5;
                shootCone = 20;
                inaccuracy = 2;
                recoil = 1.5f;
                shake = 0;
                shootSound = Sounds.shootLaser;

                bullet = new LaserBoltBulletType() {{
                    damage = 20;
                    speed = 4;
                    lifetime = 50;
                    trailLength = 3;
                    width = 2;
                    shootEffect = Fx.hitLaser;
                    backColor = Color.valueOf("FEB380");
                    frontColor = Color.valueOf("FFD4A0");
                }};
            }});
        }};
    }

    private void procyon() {
        procyon = new UnitType("procyon") {{
            constructor = UnitEntity::create;
            flying = true;
            health = 330;
            armor = 3;
            speed = 2f;
            rotateSpeed = 7f;
            hitSize = 14;
            omniMovement = false;
            lowAltitude = true;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 4;
            engineOffset = 2.75f;
            trailLength = 6;

            weapons.add(new Weapon("new-universe-procyon-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -5;
                y = 1;
                shootY = 3;
                reload = 20;
                shootCone = 30;
                inaccuracy = 1;
                recoil = 1.5f;
                shake = 1;
                baseRotation = 5;
                rotateSpeed = 17.5f;
                shootSound = Sounds.shootLaser;
                shoot = new ShootSpread() {{
                    shots = 5;
                    spread = 10;
                }};

                bullet = new LaserBoltBulletType() {{
                    damage = 25;
                    speed = 5.5f;
                    lifetime = 30;
                    trailLength = 6;
                    homingPower = 0.05f;
                    homingRange = 25;
                    homingDelay = 1;
                    backColor = Color.valueOf("FEB380");
                    frontColor = Color.valueOf("FFD4A0");
                }};
            }});
        }};
    }

    private void sirius() {
        sirius = new UnitType("sirius") {{
            constructor = UnitEntity::create;
            flying = true;
            health = 800;
            armor = 5;
            speed = 1.8f;
            rotateSpeed = 4f;
            hitSize = 23;
            omniMovement = false;
            lowAltitude = true;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 3;
            engineOffset = -0.5f;
            descentSpeed = 1;
            riseSpeed = 1;
            trailLength = 7;

            weapons.add(new Weapon("new-universe-sirius-weapon-1") {{
                mirror = true;
                alternate = false;
                rotate = true;
                top = true;
                x = -6;
                y = -4;
                shootY = 4.5f;
                shootX = 1;
                reload = 10;
                shootCone = 5;
                inaccuracy = 2;
                recoil = 1.5f;
                shake = 2;
                alwaysContinuous = true;
                shootSound = Sounds.loopPulse;

                bullet = new ContinuousFlameBulletType() {{
                    damage = 20;
                    speed = 0;
                }};
            }});

            weapons.add(new Weapon("new-universe-sirius-weapon-2") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -6.5f;
                y = 6.5f;
                shootY = 3;
                reload = 15;
                shootCone = 5;
                recoil = 1.5f;
                baseRotation = 4;
                shootSound = Sounds.shootMissile;

                bullet = new MissileBulletType() {{
                    damage = 25;
                    speed = 4;
                }};
            }});
        }};
    }

    private void altiar() {
        altiar = new UnitType("altiar") {{
            constructor = UnitEntity::create;
            flying = true;
            health = 7000;
            armor = 10;
            speed = 0.7f;
            rotateSpeed = 2f;
            hitSize = 40;
            range = 350;
            maxRange = 380;
            itemCapacity = 200;
            omniMovement = false;
            lowAltitude = true;
            hoverable = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 0;
            trailLength = 4;
            allowedInPayloads = false;

            weapons.add(new Weapon("new-universe-altiar-weapon") {{
                mirror = false;
                alternate = false;
                rotate = true;
                top = true;
                x = 0;
                y = -3;
                shootY = 7;
                reload = 200;
                shootCone = 2.5f;
                recoil = 3;
                shake = 3;
                shootStatus = StatusEffects.slow;
                rotateSpeed = 2;
                baseRotation = 0.2f;
                shootSound = Sounds.shootArtillerySapBig;

                bullet = new ArtilleryBulletType() {{
                    damage = 280;
                    speed = 9;
                    lifetime = 90;
                    splashDamage = 80;
                    splashDamageRadius = 120;
                    pierceArmor = true;
                    armorMultiplier = 2;
                    hitShake = 3;
                    despawnShake = 3;
                    trailLength = 6;
                    width = 11;
                    height = 15;
                    impact = true;
                    collidesGround = true;
                    collidesAir = true;
                    fragBullets = 7;
                    fragLifeMax = 3;
                    fragSpread = 10;
                    fragAngle = 10;
                    fragRandomSpread = 0;

                    fragBullet = new BasicBulletType() {{
                        damage = 150;
                        speed = 4;
                        lifetime = 30;
                        splashDamage = 50;
                        splashDamageRadius = 89;
                        width = 9;
                        height = 9;
                        pierceArmor = true;
                        hitShake = 2;
                        despawnShake = 2;
                        trailLength = 10;
                        impact = true;
                    }};
                }};
            }});
        }};
    }

    private void spearhead() {
        spearhead = new UnitType("spearhead") {{
            constructor = UnitEntity::create;
            flying = true;
            health = 19000;
            armor = 11;
            speed = 0.75f;
            rotateSpeed = 1f;
            hitSize = 57.5f;
            range = 250;
            maxRange = 280;
            itemCapacity = 400;
            lowAltitude = true;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 6;
            trailLength = 9;
            allowedInPayloads = false;

            controller = u -> new mindustry.ai.types.AssemblerAI();

            abilities.add(new ForceFieldAbility(80, 0.5f, 500, 60 * 10) {{
                breakSound = Sounds.shieldBreak;
                hitSound = Sounds.shieldHit;
            }});

            weapons.add(new Weapon("new-universe-spearhead-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -16;
                y = -8;
                shootY = 3;
                reload = 25;
                shootCone = 20;
                recoil = 3.5f;
                shake = 2.5f;
                baseRotation = 0.65f;
                rotateSpeed = 3;
                autoTarget = true;
                controllable = false;
                shootSound = Sounds.shootMalign;

                bullet = new PointLaserBulletType() {{
                    damage = 60;
                    speed = 0;
                    pierceArmor = true;
                    armorMultiplier = 2;
                    hitShake = 1;
                    shootEffect = Fx.absorb;
                    lightningColor = Color.valueOf("FEB380");
                }};
            }});

            weapons.add(new Weapon("new-universe-spearhead-weapon-2") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -10;
                y = 16;
                shootY = 3;
                reload = 17;
                shootCone = 20;
                recoil = 2;
                shake = 1;
                baseRotation = 2;
                rotateSpeed = 5;
                autoTarget = true;
                controllable = false;
                shootSound = Sounds.shootMalign;

                bullet = new PointLaserBulletType() {{
                    damage = 40;
                    speed = 0;
                    shootEffect = Fx.absorb;
                    hitShake = 1;
                }};
            }});
        }};
    }
}
