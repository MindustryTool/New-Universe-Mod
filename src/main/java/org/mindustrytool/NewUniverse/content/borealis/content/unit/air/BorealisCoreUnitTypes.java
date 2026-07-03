package org.mindustrytool.NewUniverse.content.borealis.content.unit.air;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LaserBoltBulletType;
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
public class BorealisCoreUnitTypes {

    public UnitType miles;
    public UnitType caesar;
    public UnitType imperium;

    public void loadContent() {
        miles();
        caesar();
        imperium();
    }

    private void miles() {
        miles = new UnitType("miles") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 120;
            armor = 1;
            speed = 4f;
            rotateSpeed = 10f;
            hitSize = 8;
            itemCapacity = 30;
            buildSpeed = 4f;
            mineTier = 1;
            omniMovement = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");

            weapons.add(new Weapon("new-universe-miles-weapon") {{
                mirror = false;
                alternate = true;
                rotate = false;
                x = 0;
                shootY = 2;
                reload = 15;
                shootCone = 15;
                inaccuracy = 3;
                recoil = 1;
                shake = 0;
                shootSound = Sounds.shootLaser;

                bullet = new BasicBulletType() {{
                    damage = 8;
                    speed = 5;
                    lifetime = 35;
                    width = 3;
                    height = 5;
                    trailLength = 2;
                    shootEffect = Fx.shootSmall;
                }};
            }});
        }};
    }

    private void caesar() {
        caesar = new UnitType("caesar") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 350;
            armor = 3;
            speed = 3.5f;
            rotateSpeed = 8f;
            hitSize = 14;
            itemCapacity = 60;
            buildSpeed = 6f;
            mineTier = 2;
            omniMovement = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 3;
            engineOffset = 3;
            trailLength = 4;

            weapons.add(new Weapon("new-universe-caesar-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -5;
                y = 0;
                shootY = 3;
                reload = 12;
                shootCone = 10;
                inaccuracy = 2;
                recoil = 1.5f;
                shake = 0.5f;
                shootSound = Sounds.shootLaser;

                bullet = new LaserBoltBulletType() {{
                    damage = 12;
                    speed = 5;
                    lifetime = 30;
                    trailLength = 4;
                    width = 2;
                    backColor = Color.valueOf("FEB380");
                    frontColor = Color.valueOf("FFD4A0");
                }};
            }});
        }};
    }

    private void imperium() {
        imperium = new UnitType("imperium") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 1200;
            armor = 6;
            speed = 3f;
            rotateSpeed = 6f;
            hitSize = 22;
            itemCapacity = 120;
            buildSpeed = 8f;
            mineTier = 3;
            omniMovement = false;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 5;
            engineOffset = 4;
            trailLength = 6;

            weapons.add(new Weapon("new-universe-imperium-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -8;
                y = -2;
                shootY = 5;
                reload = 10;
                shootCone = 8;
                recoil = 2;
                shake = 0.5f;
                shootSound = Sounds.shootLaser;
                shoot = new ShootSpread() {{
                    shots = 2;
                    spread = 4;
                }};

                bullet = new BasicBulletType() {{
                    damage = 15;
                    speed = 6;
                    lifetime = 35;
                    width = 5;
                    height = 7;
                    trailLength = 3;
                    shootEffect = Fx.shootSmall;
                }};
            }});

            weapons.add(new Weapon("new-universe-imperium-weapon-2") {{
                mirror = false;
                alternate = true;
                rotate = true;
                top = true;
                x = 0;
                y = 4;
                shootY = 3;
                reload = 25;
                shootCone = 5;
                inaccuracy = 1;
                recoil = 2.5f;
                shake = 1;
                shootSound = Sounds.shootMissile;

                bullet = new BasicBulletType() {{
                    damage = 30;
                    speed = 4;
                    lifetime = 40;
                    splashDamage = 15;
                    splashDamageRadius = 12;
                    width = 7;
                    height = 9;
                    trailLength = 4;
                    shootEffect = Fx.shootBig;
                }};
            }});
        }};
    }
}
