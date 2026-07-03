package org.mindustrytool.NewUniverse.content.borealis.content.building;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.part.DrawPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;

import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisTurretBlocks {
    private final BorealisItems borealisItems;

    public Block ferios;
    public Block augero;
    public Block dustria;
    public Block agatias;
    public Block tormentis;
    public Block pila;
    public Block propius;
    public Block lucis;
    public Block novolary;

    public void loadContent() {
        ferios = new ItemTurret("ferios") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.farasAlloy, 40,
                borealisItems.simus, 25
            ));
            size = 3;
            range = 155f;
            reload = 25f;
            shake = 1f;
            recoil = 1.5f;
            shootCone = 12f;
            inaccuracy = 3f;
            rotateSpeed = 8f;
            shootY = 2f;
            shootSound = Sounds.shootDuo;

            ammo(
                borealisItems.farasAlloy, new BasicBulletType(3.5f, 18) {{
                    width = 7f; height = 9f; lifetime = 45f; ammoMultiplier = 3;
                    hitColor = backColor = trailColor = Color.valueOf("A0A0A0");
                    frontColor = Color.valueOf("C0C0C0");
                }},
                borealisItems.navitas, new BasicBulletType(4.5f, 32) {{
                    width = 8f; height = 11f; lifetime = 50f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("1E90FF");
                    frontColor = Color.valueOf("4FC3FF");
                    homingPower = 0.15f; homingRange = 60f;
                }}
            );

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-side-r") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = 2f; moveY = -1f; moveRot = -12f; under = true;
                    }},
                    new RegionPart("-side-l") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = -2f; moveY = -1f; moveRot = 12f; under = true;
                    }},
                    new RegionPart("-mid") {{
                        progress = DrawPart.PartProgress.recoil; moveY = -2f; under = true;
                    }}
                );
            }};
        }};

        augero = new ItemTurret("augero") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.rudis, 30,
                borealisItems.simus, 20
            ));
            size = 3;
            range = 110f;
            reload = 12f;
            shake = 1f;
            recoil = 0.8f;
            shootCone = 25f;
            inaccuracy = 8f;
            rotateSpeed = 10f;
            shootY = 2f;
            shoot = new ShootSpread(3, 8f);
            shootSound = Sounds.shootDuo;

            ammo(
                borealisItems.rudis, new BasicBulletType(3f, 10) {{
                    width = 5f; height = 7f; lifetime = 35f; ammoMultiplier = 4;
                    hitColor = backColor = trailColor = Color.valueOf("B22222");
                    frontColor = Color.valueOf("E04040");
                }},
                borealisItems.simus, new BasicBulletType(3.5f, 15) {{
                    width = 6f; height = 8f; lifetime = 35f; ammoMultiplier = 3;
                    hitColor = backColor = trailColor = Color.valueOf("CC8844");
                    frontColor = Color.valueOf("E0A060");
                }}
            );

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-blade-r") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = 2f; moveRot = -20f; under = true;
                    }},
                    new RegionPart("-blade-l") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = -2f; moveRot = 20f; under = true;
                    }},
                    new RegionPart("-mid") {{
                        progress = DrawPart.PartProgress.recoil; moveY = -1.5f; under = true;
                    }}
                );
            }};
        }};

        dustria = new ItemTurret("dustria") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.farasAlloy, 35,
                borealisItems.flaxol, 20
            ));
            size = 3;
            range = 150f;
            reload = 20f;
            shake = 1f;
            recoil = 1.2f;
            shootCone = 10f;
            inaccuracy = 4f;
            rotateSpeed = 9f;
            shootY = 2f;
            shoot = new ShootAlternate(3f);
            shootSound = Sounds.shootDuo;

            ammo(
                borealisItems.farasAlloy, new BasicBulletType(3.5f, 16) {{
                    width = 6f; height = 8f; lifetime = 42f; ammoMultiplier = 3;
                    hitColor = backColor = trailColor = Color.valueOf("A0A0A0");
                    frontColor = Color.valueOf("C0C0C0");
                }},
                borealisItems.flaxol, new BasicBulletType(4f, 22) {{
                    width = 7f; height = 9f; lifetime = 40f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("708090");
                    frontColor = Color.valueOf("9090A0");
                }}
            );

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-side-r") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = 2f; moveRot = -15f; under = true;
                    }},
                    new RegionPart("-side-l") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = -2f; moveRot = 15f; under = true;
                    }},
                    new RegionPart("-mid") {{
                        progress = DrawPart.PartProgress.recoil; moveY = -1.8f; under = true;
                    }}
                );
            }};
        }};

        agatias = new ItemTurret("agatias") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.navitas, 50,
                borealisItems.temperedGlass, 30
            ));
            size = 3;
            range = 175f;
            reload = 35f;
            shake = 2f;
            recoil = 2f;
            shootCone = 6f;
            inaccuracy = 1f;
            rotateSpeed = 6f;
            shootY = 2f;
            shootSound = Sounds.shootDuo;

            ammo(
                borealisItems.navitas, new BasicBulletType(6f, 35) {{
                    width = 8f; height = 12f; lifetime = 30f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("1E90FF");
                    frontColor = Color.valueOf("4FC3FF");
                    pierce = true; pierceCap = 2;
                }},
                borealisItems.temperedGlass, new BasicBulletType(5f, 28) {{
                    width = 7f; height = 14f; lifetime = 35f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("C0E8FF");
                    frontColor = Color.valueOf("E0F4FF");
                    pierce = true; pierceCap = 3;
                }}
            );

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-side-r") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = 1.5f; moveRot = -10f; under = true;
                    }},
                    new RegionPart("-side-l") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = -1.5f; moveRot = 10f; under = true;
                    }},
                    new RegionPart("-mid") {{
                        progress = DrawPart.PartProgress.recoil; moveY = -2.5f; under = true;
                    }}
                );
            }};
        }};

        tormentis = new ItemTurret("tormentis") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.duras, 60,
                borealisItems.cophalast, 40,
                borealisItems.navitas, 30
            ));
            size = 4;
            range = 170f;
            reload = 38f;
            shake = 3f;
            recoil = 3f;
            shootCone = 8f;
            inaccuracy = 2f;
            rotateSpeed = 5f;
            shootY = 3f;
            shoot = new ShootAlternate(4f);
            shootSound = Sounds.shootDuo;

            ammo(
                borealisItems.duras, new BasicBulletType(5f, 45) {{
                    width = 10f; height = 14f; lifetime = 35f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("6A0DAD");
                    frontColor = Color.valueOf("9B30FF");
                }},
                borealisItems.cophalast, new BasicBulletType(5.5f, 55) {{
                    width = 11f; height = 15f; lifetime = 32f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("FFD700");
                    frontColor = Color.valueOf("FFE44D");
                }}
            );

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-side-r") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = 3f; moveY = -1f; moveRot = -15f; under = true;
                    }},
                    new RegionPart("-side-l") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = -3f; moveY = -1f; moveRot = 15f; under = true;
                    }},
                    new RegionPart("-barrel-r") {{
                        progress = DrawPart.PartProgress.recoil;
                        moveX = 1.5f; moveY = -3f; under = true;
                    }},
                    new RegionPart("-barrel-l") {{
                        progress = DrawPart.PartProgress.recoil;
                        moveX = -1.5f; moveY = -3f; under = true;
                    }},
                    new RegionPart("-mid") {{
                        progress = DrawPart.PartProgress.recoil; moveY = -2f; under = true;
                    }}
                );
            }};
        }};

        pila = new ItemTurret("pila") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.fabris, 50,
                borealisItems.tentias, 30
            ));
            size = 4;
            range = 90f;
            reload = 8f;
            shake = 1f;
            recoil = 0.5f;
            shootCone = 30f;
            inaccuracy = 10f;
            rotateSpeed = 12f;
            shootY = 2f;
            shoot = new ShootSpread(2, 6f);
            shootSound = Sounds.shootDuo;

            ammo(
                borealisItems.fabris, new BasicBulletType(4f, 12) {{
                    width = 5f; height = 7f; lifetime = 22f; ammoMultiplier = 5;
                    hitColor = backColor = trailColor = Color.valueOf("7FFFD4");
                    frontColor = Color.valueOf("B0FFE0");
                }},
                borealisItems.tentias, new BasicBulletType(4.5f, 18) {{
                    width = 6f; height = 8f; lifetime = 22f; ammoMultiplier = 4;
                    hitColor = backColor = trailColor = Color.valueOf("404040");
                    frontColor = Color.valueOf("606060");
                }}
            );

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-blade-r") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = 3f; moveRot = -25f; under = true;
                    }},
                    new RegionPart("-blade-l") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = -3f; moveRot = 25f; under = true;
                    }},
                    new RegionPart("-mid") {{
                        progress = DrawPart.PartProgress.recoil; moveY = -1.5f; under = true;
                    }}
                );
            }};
        }};

        propius = new ItemTurret("propius") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.fortial, 45,
                borealisItems.pausis, 35,
                borealisItems.farasAlloy, 30
            ));
            size = 4;
            range = 250f;
            reload = 55f;
            shake = 4f;
            recoil = 4f;
            shootCone = 5f;
            inaccuracy = 1f;
            rotateSpeed = 4f;
            shootY = 3f;
            shootSound = Sounds.shootDuo;

            ammo(
                borealisItems.fortial, new BasicBulletType(6f, 50) {{
                    width = 9f; height = 11f; lifetime = 45f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("E8F0FF");
                    frontColor = Color.valueOf("FFFFFF");
                    knockback = 3f;
                    shootEffect = Fx.shootBig;
                }},
                borealisItems.pausis, new BasicBulletType(5f, 40) {{
                    width = 8f; height = 10f; lifetime = 55f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("FF7F50");
                    frontColor = Color.valueOf("FFA070");
                }}
            );

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-barrel-r") {{
                        progress = DrawPart.PartProgress.recoil;
                        moveX = 1.5f; moveY = -4f; under = true;
                    }},
                    new RegionPart("-barrel-l") {{
                        progress = DrawPart.PartProgress.recoil;
                        moveX = -1.5f; moveY = -4f; under = true;
                    }},
                    new RegionPart("-mid") {{
                        progress = DrawPart.PartProgress.recoil; moveY = -2.5f; under = true;
                    }}
                );
            }};
        }};

        lucis = new PowerTurret("lucis") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.navitas, 80,
                borealisItems.temperedGlass, 50,
                borealisItems.fabris, 30
            ));
            size = 4;
            range = 185f;
            reload = 28f;
            shake = 2f;
            recoil = 1f;
            shootCone = 6f;
            rotateSpeed = 5f;
            shootY = 2f;
            shootSound = Sounds.shootLancer;
            consumePower(5f);

            shootType = new LaserBulletType(80) {{
                colors = new Color[]{Color.valueOf("4FC3FF").cpy().a(0.4f), Color.valueOf("1E90FF"), Color.white};
                buildingDamageMultiplier = 0.5f; armorMultiplier = 3f;
                hitEffect = Fx.hitLancer; hitSize = 4; lifetime = 18f;
                drawSize = 400f; collidesAir = true; length = 195f;
                pierceCap = 3;
            }};

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-blade-r") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = 3f; moveRot = -20f; under = true;
                    }},
                    new RegionPart("-blade-l") {{
                        progress = DrawPart.PartProgress.warmup;
                        moveX = -3f; moveRot = 20f; under = true;
                    }},
                    new RegionPart("-mid") {{
                        progress = DrawPart.PartProgress.recoil; moveY = -2f; under = true;
                    }}
                );
            }};
        }};

        novolary = new ItemTurret("novolary") {{
            requirements(Category.turret, ItemStack.with(
                borealisItems.navitas, 100,
                borealisItems.duras, 70,
                borealisItems.cophalast, 50,
                borealisItems.flaxol, 40
            ));
            size = 4;
            range = 190f;
            reload = 45f;
            shake = 4f;
            recoil = 3f;
            shootCone = 6f;
            inaccuracy = 1f;
            rotateSpeed = 4f;
            shootY = 2f;
            recoils = 3;
            shoot = new ShootBarrel() {{
                shots = 3;
                barrels = new float[]{-5f, 1f, 0f, 0f, 1f, 0f, 5f, 1f, 0f};
                shotDelay = 3f;
            }};
            shootSound = Sounds.shootSalvo;

            ammo(
                borealisItems.navitas, new BasicBulletType(5f, 40) {{
                    width = 9f; height = 13f; lifetime = 40f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("1E90FF");
                    frontColor = Color.valueOf("4FC3FF");
                    knockback = 1.5f;
                    shootEffect = Fx.shootBig;
                }},
                borealisItems.cophalast, new BasicBulletType(5.5f, 55) {{
                    width = 10f; height = 14f; lifetime = 38f; ammoMultiplier = 2;
                    hitColor = backColor = trailColor = Color.valueOf("FFD700");
                    frontColor = Color.valueOf("FFE44D");
                    knockback = 2f;
                }}
            );

            drawer = new DrawTurret() {{
                parts.addAll(
                    new RegionPart("-barrel-l") {{
                        progress = DrawPart.PartProgress.recoil;
                        recoilIndex = 0; moveX = -5f; moveY = -3f; under = true;
                    }},
                    new RegionPart("-barrel-m") {{
                        progress = DrawPart.PartProgress.recoil;
                        recoilIndex = 1; moveX = 0f; moveY = -3f; under = true;
                    }},
                    new RegionPart("-barrel-r") {{
                        progress = DrawPart.PartProgress.recoil;
                        recoilIndex = 2; moveX = 5f; moveY = -3f; under = true;
                    }}
                );
            }};
        }};
    }
}
