package org.mindustrytool.NewUniverse.content.borealis.content.item;

import arc.graphics.Color;
import mindustry.type.Liquid;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisLiquids {

    public Liquid barbavior;
    public Liquid horani;
    public Liquid fortial;

    public void loadContent() {
        barbavior = new Liquid("barbavior", Color.valueOf("8B7355")) {{
            viscosity = 0.5f;
            temperature = 0.4f;
            heatCapacity = 0.8f;
            barColor = Color.valueOf("6B5335");
        }};

        fortial = new Liquid("fortial", Color.valueOf("E8F0FF")) {{
            gas = true;
            viscosity = 0.1f;
            temperature = 0.3f;
            heatCapacity = 0.5f;
            flammability = 0.3f;
            barColor = Color.valueOf("C0D8E8");
        }};

        horani = new Liquid("horani", Color.valueOf("2A7A5A")) {{
            viscosity = 0.6f;
            temperature = 0.5f;
            heatCapacity = 0.7f;
            barColor = Color.valueOf("1A5A3A");
        }};
    }
}
