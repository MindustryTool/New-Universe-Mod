package org.mindustrytool.NewUniverse.content.borealis.content.unit.air;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
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
public class BorealisVeggvisUnitTypes {

    public UnitType veggvis;
    public UnitType hermod;
    public UnitType valkyrie;
    public UnitType odin;
    public UnitType ragnarok;

    public void loadContent() {
        veggvis(); hermod(); valkyrie(); odin(); ragnarok();
    }

    private void veggvis() {
        veggvis = new UnitType("veggvis") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 180;
            armor = 2;
            speed = 2.2f;
            rotateSpeed = 6f;
            hitSize = 10;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            trailLength = 5;

            weapons.add(new Weapon("new-universe-veggvis-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -4;
                y = 0;
                shootY = 3;
                reload = 18;
                shootCone = 10;
                inaccuracy = 2;
                recoil = 1.5f;
                shake = 0;
                shootSound = Sounds.shootDuo;

                bullet = new BasicBulletType() {{
                    damage = 12;
                    speed = 5;
                    lifetime = 35;
                    width = 4;
                    height = 6;
                    trailLength = 2;
                    shootEffect = Fx.shootSmall;
                }};
            }});
        }};
    }

    private void hermod() {
        hermod = new UnitType("hermod") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 420;
            armor = 4;
            speed = 2f;
            rotateSpeed = 5f;
            hitSize = 15;
            itemCapacity = 40;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 3;
            trailLength = 6;

            weapons.add(new Weapon("new-universe-hermod-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -6;
                y = -2;
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
                    damage = 15;
                    speed = 5.5f;
                    lifetime = 30;
                    width = 4;
                    height = 7;
                    trailLength = 3;
                }};
            }});

            weapons.add(new Weapon("new-universe-hermod-weapon-2") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -5;
                y = 5;
                shootY = 3;
                reload = 30;
                shootCone = 5;
                recoil = 2;
                shake = 0.5f;
                shootSound = Sounds.shootMissile;

                bullet = new MissileBulletType() {{
                    damage = 30;
                    speed = 4;
                    lifetime = 30;
                }};
            }});
        }};
    }

    private void valkyrie() {
        valkyrie = new UnitType("valkyrie") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 1100;
            armor = 6;
            speed = 1.6f;
            rotateSpeed = 4f;
            hitSize = 22;
            itemCapacity = 80;
            vulnerableWithPayloads = true;
            singleTarget = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 4;
            trailLength = 7;

            weapons.add(new Weapon("new-universe-valkyrie-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -8;
                y = -3;
                shootY = 5;
                reload = 20;
                shootCone = 8;
                inaccuracy = 1;
                recoil = 2;
                shake = 1;
                shootSound = Sounds.shootLaser;
                shoot = new ShootSpread() {{
                    shots = 3;
                    spread = 3;
                }};

                bullet = new BasicBulletType() {{
                    damage = 20;
                    speed = 6;
                    lifetime = 35;
                    width = 5;
                    height = 8;
                    trailLength = 3;
                }};
            }});

            weapons.add(new Weapon("new-universe-valkyrie-weapon-2") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -7;
                y = 6;
                shootY = 4;
                reload = 40;
                shootCone = 5;
                recoil = 2.5f;
                shake = 1;
                shootSound = Sounds.shootMissile;

                bullet = new MissileBulletType() {{
                    damage = 50;
                    speed = 4;
                    lifetime = 35;
                    splashDamage = 10;
                    splashDamageRadius = 16;
                }};
            }});
        }};
    }

    private void odin() {
        odin = new UnitType("odin") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 5200;
            armor = 9;
            speed = 1.2f;
            rotateSpeed = 3f;
            hitSize = 35;
            itemCapacity = 150;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 5;
            trailLength = 8;
            allowedInPayloads = false;

            weapons.add(new Weapon("new-universe-odin-weapon-1") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -12;
                y = -4;
                shootY = 6;
                reload = 15;
                shootCone = 6;
                inaccuracy = 1;
                recoil = 2;
                shake = 1;
                shootSound = Sounds.shootSpectre;
                shoot = new ShootSpread() {{
                    shots = 4;
                    spread = 4;
                }};

                bullet = new BasicBulletType() {{
                    damage = 25;
                    speed = 6.5f;
                    lifetime = 35;
                    width = 6;
                    height = 10;
                    trailLength = 4;
                }};
            }});

            weapons.add(new Weapon("new-universe-odin-weapon-2") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -10;
                y = 8;
                shootY = 4;
                reload = 50;
                shootCone = 5;
                recoil = 3;
                shake = 1.5f;
                shootSound = Sounds.shootMissile;

                bullet = new MissileBulletType() {{
                    damage = 70;
                    speed = 4;
                    lifetime = 40;
                    splashDamage = 20;
                    splashDamageRadius = 20;
                }};
            }});

            weapons.add(new Weapon("new-universe-odin-weapon-3") {{
                mirror = true;
                rotate = true;
                top = true;
                x = -14;
                y = 0;
                shootY = 3;
                reload = 60;
                rotateSpeed = 12;
                autoTarget = true;
                controllable = false;
                shootSound = Sounds.shoot;

                bullet = new BulletType() {{
                    damage = 30;
                }};
            }});
        }};
    }

    private void ragnarok() {
        ragnarok = new UnitType("ragnarok") {{
            constructor = UnitEntity::create;
            flying = true;
            lowAltitude = true;
            health = 15000;
            armor = 12;
            speed = 0.9f;
            rotateSpeed = 2f;
            hitSize = 50;
            itemCapacity = 300;
            vulnerableWithPayloads = true;
            singleTarget = true;
            alwaysCreateOutline = true;
            outlineColor = Color.valueOf("282829");
            engineSize = 6;
            trailLength = 10;
            allowedInPayloads = false;

            weapons.add(new Weapon("new-universe-ragnarok-weapon") {{
                mirror = true;
                alternate = true;
                rotate = true;
                top = true;
                x = -16;
                y = 0;
                shootY = 7;
                reload = 12;
                shootCone = 5;
                recoil = 3;
                shake = 2;
                shootSound = Sounds.shootSpectre;
                shoot = new ShootSpread() {{
                    shots = 6;
                    spread = 5;
                }};

                bullet = new BasicBulletType() {{
                    damage = 35;
                    speed = 7;
                    lifetime = 40;
                    width = 7;
                    height = 12;
                    trailLength = 5;
                    splashDamage = 10;
                    splashDamageRadius = 12;
                }};
            }});
        }};
    }
}
