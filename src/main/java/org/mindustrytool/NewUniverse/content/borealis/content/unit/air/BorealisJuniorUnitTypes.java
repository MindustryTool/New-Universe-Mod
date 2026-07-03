package org.mindustrytool.NewUniverse.content.borealis.content.unit.air;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
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
public class BorealisJuniorUnitTypes {

    public UnitType junior;
    public UnitType centia;
    public UnitType veralia;
    public UnitType impetuo;
    public UnitType auxiol;
    public UnitType prider;

    public void loadContent() {
        junior();
        centia();
        veralia();
        impetuo();
        auxiol();
        prider();
    }

    private void junior() {
        junior = new UnitType("junior") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 60;
            armor = 1;
            speed = 3f;
            rotateSpeed = 8f;
            hitSize = 6;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            trailLength = 3;

            weapons.add(new Weapon("new-universe-junior-weapon") {{
                mirror = false;
                alternate = true;
                rotate = false;
                x = 0;
                shootY = 2;
                reload = 20;
                shootCone = 15;
                inaccuracy = 3;
                recoil = 1;
                shake = 0;
                shootSound = Sounds.shootLaser;

                bullet = new BasicBulletType() {{
                    damage = 5;
                    speed = 4;
                    lifetime = 30;
                    width = 2;
                    height = 4;
                    trailLength = 1;
                    shootEffect = Fx.shootSmall;
                }};
            }});
        }};
    }

    private void centia() {
        centia = new UnitType("centia") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 150;
            armor = 2;
            speed = 2.5f;
            rotateSpeed = 7f;
            hitSize = 9;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            trailLength = 4;

            weapons.add(new Weapon("new-universe-centia-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -4;
                y = 0;
                shootY = 3;
                reload = 16;
                shootCone = 10;
                inaccuracy = 2;
                recoil = 1.5f;
                shake = 0;
                shootSound = Sounds.shootDuo;

                bullet = new BasicBulletType() {{
                    damage = 10;
                    speed = 5;
                    lifetime = 35;
                    width = 3;
                    height = 6;
                    trailLength = 2;
                    shootEffect = Fx.shootSmall;
                }};
            }});
        }};
    }

    private void veralia() {
        veralia = new UnitType("veralia") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 380;
            armor = 4;
            speed = 2.2f;
            rotateSpeed = 6f;
            hitSize = 14;
            itemCapacity = 30;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 3;
            trailLength = 5;

            weapons.add(new Weapon("new-universe-veralia-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -6;
                y = 0;
                shootY = 4;
                reload = 14;
                shootCone = 8;
                inaccuracy = 2;
                recoil = 1.5f;
                shake = 0.5f;
                shootSound = Sounds.shootLaser;
                shoot = new ShootSpread() {{
                    shots = 2;
                    spread = 3;
                }};

                bullet = new BasicBulletType() {{
                    damage = 14;
                    speed = 5.5f;
                    lifetime = 30;
                    width = 4;
                    height = 7;
                    trailLength = 3;
                }};
            }});
        }};
    }

    private void impetuo() {
        impetuo = new UnitType("impetuo") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 900;
            armor = 6;
            speed = 1.8f;
            rotateSpeed = 5f;
            hitSize = 20;
            itemCapacity = 60;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 4;
            trailLength = 6;

            weapons.add(new Weapon("new-universe-impetuo-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -8;
                y = 0;
                shootY = 5;
                reload = 12;
                shootCone = 6;
                inaccuracy = 1;
                recoil = 2;
                shake = 0.5f;
                shootSound = Sounds.shootLaser;
                shoot = new ShootSpread() {{
                    shots = 3;
                    spread = 4;
                }};

                bullet = new BasicBulletType() {{
                    damage = 18;
                    speed = 6;
                    lifetime = 35;
                    width = 5;
                    height = 8;
                    trailLength = 4;
                }};
            }});
        }};
    }

    private void auxiol() {
        auxiol = new UnitType("auxiol") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 3500;
            armor = 8;
            speed = 1.4f;
            rotateSpeed = 4f;
            hitSize = 30;
            itemCapacity = 120;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 5;
            trailLength = 7;
            allowedInPayloads = false;

            weapons.add(new Weapon("new-universe-auxiol-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -10;
                y = -3;
                shootY = 5;
                reload = 10;
                shootCone = 5;
                recoil = 2;
                shake = 0.5f;
                shootSound = Sounds.shootSpectre;
                shoot = new ShootSpread() {{
                    shots = 4;
                    spread = 4;
                }};

                bullet = new BasicBulletType() {{
                    damage = 22;
                    speed = 6.5f;
                    lifetime = 35;
                    width = 6;
                    height = 9;
                    trailLength = 4;
                }};
            }});

            weapons.add(new Weapon("new-universe-auxiol-weapon-2") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -8;
                y = 6;
                shootY = 4;
                reload = 35;
                shootCone = 5;
                recoil = 2.5f;
                shake = 1;
                shootSound = Sounds.shootMissile;

                bullet = new mindustry.entities.bullet.MissileBulletType() {{
                    damage = 60;
                    speed = 4;
                    lifetime = 35;
                    splashDamage = 15;
                    splashDamageRadius = 18;
                }};
            }});
        }};
    }

    private void prider() {
        prider = new UnitType("prider") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 12000;
            armor = 11;
            speed = 1f;
            rotateSpeed = 3f;
            hitSize = 45;
            itemCapacity = 250;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 6;
            trailLength = 9;
            allowedInPayloads = false;

            weapons.add(new Weapon("new-universe-prider-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -14;
                y = 0;
                shootY = 7;
                reload = 10;
                shootCone = 5;
                recoil = 3;
                shake = 1.5f;
                shootSound = Sounds.shootSpectre;
                shoot = new ShootSpread() {{
                    shots = 5;
                    spread = 5;
                }};

                bullet = new BasicBulletType() {{
                    damage = 30;
                    speed = 7;
                    lifetime = 40;
                    width = 7;
                    height = 11;
                    trailLength = 5;
                    splashDamage = 10;
                    splashDamageRadius = 14;
                }};
            }});
        }};
    }
}
