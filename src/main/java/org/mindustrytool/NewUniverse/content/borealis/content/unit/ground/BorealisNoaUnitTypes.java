package org.mindustrytool.NewUniverse.content.borealis.content.unit.ground;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.abilities.ShieldRegenFieldAbility;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.entities.bullet.LightningBulletType;
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
public class BorealisNoaUnitTypes {

    public UnitType noa;
    public UnitType external;
    public UnitType siriusMech;
    public UnitType ion;
    public UnitType xyrus;

    public void loadContent() {
        noa(); external(); siriusMech(); ion(); xyrus();
    }

    private void noa() {
        noa = new UnitType("noa") {{
            constructor = UnitEntity::create;
            health = 160;
            armor = 1;
            speed = 0.5f;
            hitSize = 10;
            range = 144;
            maxRange = 160;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            mechSideSway = 0.3f;

            weapons.add(new Weapon("new-universe-noa-weapon") {{
                mirror = true;
                alternate = true;
                rotate = false;
                x = -5;
                y = 0;
                shootY = 4.5f;
                shootX = -0.5f;
                reload = 25;
                shootCone = 5;
                inaccuracy = 1;
                recoil = 1.5f;
                shake = 1;
                shootSound = Sounds.explosionCleroi;

                bullet = new LaserBoltBulletType() {{
                    damage = 10;
                    speed = 4.5f;
                    lifetime = 32;
                    trailLength = 3;
                    backColor = Color.valueOf("4E97C2");
                    frontColor = Color.valueOf("90F2FF");
                }};
            }});
        }};
    }

    private void external() {
        external = new UnitType("external") {{
            constructor = UnitEntity::create;
            health = 600;
            armor = 5;
            speed = 0.45f;
            rotateSpeed = 3f;
            baseRotateSpeed = 4;
            hitSize = 14;
            range = 140;
            maxRange = 150;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            squareShape = true;
            outlineColor = Color.valueOf("282829");
            mechStride = 7;

            weapons.add(new Weapon("new-universe-external-weapon") {{
                mirror = true;
                alternate = true;
                rotate = false;
                x = -7.8f;
                y = 1.5f;
                shootY = 11;
                reload = 30;
                shootCone = 10;
                inaccuracy = 1;
                recoil = 2.5f;
                shake = 0.5f;
                shootSound = Sounds.shootMissileSmall;

                bullet = new MissileBulletType() {{
                    damage = 55;
                    speed = 3.5f;
                    lifetime = 35;
                    trailColor = Color.valueOf("90F2FF");
                    backColor = Color.valueOf("90F2FF");
                    frontColor = Color.valueOf("90F2FF");
                }};
                shoot = new ShootSpread() {{
                    shots = 3;
                }};
            }});
        }};
    }

    private void siriusMech() {
        siriusMech = new UnitType("sirius-mech") {{
            constructor = UnitEntity::create;
            health = 880;
            armor = 11;
            speed = 0.35f;
            rotateSpeed = 3f;
            baseRotateSpeed = 3;
            hitSize = 17;
            range = 190;
            maxRange = 200;
            itemCapacity = 100;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            mechStride = 6;
            mechStepParticles = true;

            weapons.add(new Weapon("new-universe-sirius-mech-weapon") {{
                mirror = true;
                alternate = true;
                rotate = false;
                x = -8.5f;
                y = 0.5f;
                shootY = 9.2f;
                shootX = 0.5f;
                reload = 65;
                shootCone = 10;
                recoil = 4;
                shake = 2;
                shootSound = Sounds.shootBeamPlasma;

                bullet = new ArtilleryBulletType() {{
                    damage = 100;
                    speed = 8;
                    splashDamage = 60;
                    splashDamageRadius = 35;
                    trailLength = 6;
                    width = 15;
                    height = 15;
                    drag = 0.03f;
                    trailColor = Color.valueOf("4E97C2");
                }};
            }});
        }};
    }

    private void ion() {
        ion = new UnitType("ion") {{
            constructor = UnitEntity::create;
            health = 10000;
            armor = 9;
            speed = 0.35f;
            rotateSpeed = 2f;
            baseRotateSpeed = 3;
            hitSize = 25;
            range = 192;
            maxRange = 208;
            itemCapacity = 150;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            groundLayer = 60;
            mechStride = 11;
            mechSideSway = 0.9f;
            mechFrontSway = 0.7f;
            mechStepParticles = true;
            allowedInPayloads = false;

            abilities.add(new ShieldRegenFieldAbility(1f, 60f, 1f, 200f));

            weapons.add(new Weapon("new-universe-ion-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = false;
                x = -14.38f;
                y = -0.8f;
                shootY = 15;
                reload = 60;
                shootCone = 5;
                recoil = 5;
                shake = 2;
                shootSound = Sounds.explosionObviate;
                shoot = new ShootSpread() {{
                    shots = 3;
                    shotDelay = 3;
                }};

                bullet = new BombBulletType() {{
                    damage = 100;
                    speed = 8;
                    lifetime = 35;
                    splashDamage = 25;
                    splashDamageRadius = 3;
                    pierceArmor = true;
                    armorMultiplier = 3;
                    width = 13;
                    height = 20;
                    impact = true;
                    backColor = Color.valueOf("4E97C2");
                    frontColor = Color.valueOf("90F2FF");
                    trailColor = Color.valueOf("4E97C2");
                    fragBullets = 7;
                    fragLifeMax = 2;
                    fragRandomSpread = 80;
                    fragSpread = 80;
                    fragAngle = 80;
                    fragOffsetMax = 3;

                    fragBullet = new ArtilleryBulletType() {{
                        damage = 120;
                        speed = 3;
                        drag = 0.01f;
                        hitSize = 6;
                        fragBullets = 0;
                    }};
                }};
            }});

            weapons.add(new Weapon("new-universe-ion-weapon-2") {{
                mirror = true;
                rotate = true;
                top = true;
                x = -6;
                y = 4;
                shootY = 3;
                reload = 45;
                shootCone = 5;
                baseRotation = 2;
                rotateSpeed = 10;
                shootSound = Sounds.shootLancer;

                bullet = new mindustry.entities.bullet.LaserBulletType() {{
                    damage = 50;
                    speed = 0;
                    drag = 0.03f;
                }};
            }});
        }};
    }

    private void xyrus() {
        xyrus = new UnitType("xyrus") {{
            constructor = UnitEntity::create;
            health = 25500;
            armor = 20;
            speed = 0.3f;
            rotateSpeed = 2f;
            baseRotateSpeed = 4;
            hitSize = 30;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            mechStride = 11.5f;
            mechSideSway = 0.8f;
            mechFrontSway = 1.8f;
            mechStepParticles = true;
            allowedInPayloads = false;

            weapons.add(new Weapon("new-universe-xyrus-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = false;
                x = -18.5f;
                y = -2;
                shootY = 15;
                reload = 85;
                shootCone = 10;
                recoil = 3;
                shake = 2;
                inaccuracy = 1;
                shootSound = Sounds.shootNavanax;

                bullet = new ArtilleryBulletType() {{
                    damage = 0;
                    speed = 12;
                    lifetime = 60;
                    splashDamage = 250;
                    splashDamageRadius = 64;
                    pierceArmor = true;
                    armorMultiplier = 3;
                    scaledSplashDamage = true;
                    splashDamagePierce = true;
                    hitShake = 1;
                    despawnShake = 1;
                    trailLength = 9;
                    trailWidth = 4;
                    width = 25;
                    height = 20;
                    drag = 0.05f;
                    frontColor = Color.valueOf("90F2FF");
                    backColor = Color.valueOf("4E97C2");
                    trailColor = Color.valueOf("90F2FF");
                    fragBullets = 10;
                    delayFrags = true;
                    bulletInterval = 10;

                    intervalBullet = new LightningBulletType() {{
                        damage = 20;
                        lightning = 2;
                        lightningColor = Color.valueOf("90F2FF");
                    }};

                    fragBullet = new LightningBulletType() {{
                        damage = 50;
                        lightning = 2;
                        lightningColor = Color.valueOf("90F2FF");
                        hitShake = 1;
                    }};
                }};
            }});

            weapons.add(new Weapon("new-universe-xyrus-weapon-2") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = 7.7f;
                y = 1.5f;
                shootY = 4;
                reload = 40;
                shootCone = 5;
                recoil = 1.5f;
                shake = 1;
                baseRotation = 4;
                rotateSpeed = 4;
                controllable = false;
                shootSound = Sounds.shootMalign;

                bullet = new PointLaserBulletType() {{
                    damage = 100;
                    speed = 0;
                    color = Color.valueOf("4E97C2");
                    lightningColor = Color.valueOf("90F2FF");
                }};
            }});
        }};
    }
}
