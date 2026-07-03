package org.mindustrytool.NewUniverse.content.borealis.content.item;

import arc.graphics.Color;
import mindustry.type.Item;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisItems {

    /**
     * Golden crystalline mineral. Extremely hard, sharp, and glossy.
     * High-end material for end-game technology.
     */
    public Item cophalast;

    /**
     * Deep purple cubic crystal. Super dense and heavy with extreme durability.
     * Used for armor plating and fortress walls.
     */
    public Item duras;

    /**
     * Light jade synthetic fiber. Extremely tough and resilient,
     * with thermal and electrical insulation properties.
     * Used for high-end armor, special wiring, and filters.
     */
    public Item fabris;

    /**
     * Standard iron/steel alloy ingot. Heavy, durable structural material.
     * Used for machine frames, conveyor belts, and general construction.
     */
    public Item farasAlloy;

    /**
     * Ash-gray semiconductor material. Smooth, high-tech matte finish.
     * Refined from raw minerals; core ingredient for electronics,
     * logic chips, robots, solar panels, and automation systems.
     */
    public Item flaxol;

    /**
     * Compressed protective gas. Dense vapor or liquid plasma,
     * ivory-white with a pale blue tint. Used as shielding gas,
     * high-pressure propellant, or coolant.
     */
    public Item fortial;

    /**
     * High-tech energy-conducting alloy. Deep blue with neon highlights,
     * sharp-edged and highly reflective. Conducts immense energy
     * without melting. Used in reactor cores, accelerators,
     * and energy weapons.
     */
    public Item navitas;

    /**
     * Porous organic sediment. Coral pink-orange, lightweight and brittle.
     * Easy to extract and process.
     */
    public Item pausis;

    /**
     * Crude mineral ore. Dark pinkish-red, rough and sharp-edged.
     * Requires processing in a crusher or furnace to extract usable metal.
     */
    public Item rudis;

    /**
     * Compressed sand and sandstone grains. Yellow granular clusters.
     * Used as filtration material or raw ingredient for glass-making.
     */
    public Item sand;

    /**
     * Processed metal plates or bundled flat bars. Earthy orange-brass color.
     * Used for wiring cores, heat sinks, and circuitry.
     */
    public Item simus;

    /**
     * Tempered safety glass. Transparent, light blue, sharp-edged,
     * and highly reflective. Used for lenses and observation windows.
     */
    public Item temperedGlass;

    /**
     * Dark obsidian or compact dark matter. Deep gray-black,
     * four-pointed star-shaped crystal. Absorbs light; used as
     * binding cores or thermal insulation plating.
     */
    public Item tentias;

    /**
     * Symmetrical mint-green crystal cluster. Natural, brittle,
     * and cold to the touch. Found in frozen environments.
     */
    public Item vastum;

    public void loadContent() {
        cophalast = new Item("cophalast", Color.valueOf("FFD700")) {{
            hardness = 5;
            cost = 8;
        }};

        duras = new Item("duras", Color.valueOf("6A0DAD")) {{
            hardness = 7;
            cost = 6;
        }};

        fabris = new Item("fabris", Color.valueOf("7FFFD4")) {{
            hardness = 4;
            cost = 5;
        }};

        farasAlloy = new Item("faras-alloy", Color.valueOf("A0A0A0")) {{
            hardness = 5;
            cost = 4;
        }};

        flaxol = new Item("flaxol", Color.valueOf("708090")) {{
            hardness = 3;
            cost = 5;
        }};

        fortial = new Item("fortial", Color.valueOf("E8F0FF")) {{
            hardness = 1;
            cost = 4;
            flammability = 0.3f;
        }};

        navitas = new Item("navitas", Color.valueOf("1E90FF")) {{
            hardness = 4;
            cost = 7;
        }};

        pausis = new Item("pausis", Color.valueOf("FF7F50")) {{
            hardness = 2;
            cost = 3;
        }};

        rudis = new Item("rudis", Color.valueOf("B22222")) {{
            hardness = 2;
            cost = 1;
        }};

        sand = new Item("sand", Color.valueOf("D4C878")) {{
            hardness = 1;
            cost = 1;
        }};

        simus = new Item("simus", Color.valueOf("CC8844")) {{
            hardness = 4;
            cost = 3;
        }};

        temperedGlass = new Item("tempered-glass", Color.valueOf("C0E8FF")) {{
            hardness = 3;
            cost = 4;
        }};

        tentias = new Item("tentias", Color.valueOf("404040")) {{
            hardness = 5;
            cost = 5;
        }};

        vastum = new Item("vastum", Color.valueOf("50C878")) {{
            hardness = 2;
            cost = 2;
        }};
    }
}
