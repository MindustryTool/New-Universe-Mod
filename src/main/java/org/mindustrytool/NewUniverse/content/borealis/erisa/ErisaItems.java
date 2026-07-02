package org.mindustrytool.NewUniverse.content.borealis.erisa;

import javax.inject.Inject;
import javax.inject.Singleton;

import arc.graphics.Color;
import lombok.RequiredArgsConstructor;
import mindustry.type.Item;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ErisaItems {

    // ------------------------------------------------------------------
    //  Items (from sprites/items/)
    // ------------------------------------------------------------------

    /**
     * Gold-like conductive metal. Precious, high cost, excellent conductivity.
     */
    public Item aurum;

    /**
     * Volcanic mineral compound. Moderately explosive.
     */
    public Item cophalast;

    /**
     * Durable structural alloy. Very hard, ideal for armor plating.
     */
    public Item duras;

    /**
     * Versatile manufacturing composite. Easy to shape, moderate strength.
     */
    public Item fabris;

    /**
     * Ferrous-alloy composite. Advanced material for precision components.
     */
    public Item ferraloy;

    /**
     * Cryo-coolant fluid. Used in thermal regulation systems.
     */
    public Item flaxol;

    /**
     * Reinforced structural plating. Extremely durable, low conductivity.
     */
    public Item fortial;

    /**
     * Radioactive crystal. Emits hazardous radiation, glows green.
     */
    public Item horani;

    /**
     * Energy-dense fuel compound. Highly flammable and volatile.
     */
    public Item navitas;

    /**
     * Cryo-stabilizer compound. Used to regulate thermal reactions.
     */
    public Item pausis;

    /**
     * Raw mineral ore. Unprocessed, rough, abundant.
     */
    public Item rudis;

    /**
     * Construction-grade sand. Common building material.
     */
    public Item sand;

    /**
     * Processed metal plates. Flat, uniform, ready for assembly.
     */
    public Item simus;

    /**
     * Heat-resistant glass compound. Withstands extreme temperatures.
     */
    public Item temperedGlass;

    /**
     * Organic polymer fiber. Flexible, resilient, tentacle-like.
     */
    public Item tentias;

    /**
     * Hazardous waste material. Low value, slightly radioactive.
     */
    public Item vastum;

    /**
     * Viscous industrial lubricant. Thick, sticky, moderately flammable.
     */
    public Item viscosy;

    /**
     * Exotic crystalline mineral. Extremely rare, highly valuable.
     */
    public Item xearula;

    public void loadContent() {
        aurum = new Item("aurum", Color.valueOf("ffd700")) {{
            hardness = 2;
            cost = 8;
            color = Color.valueOf("ffd700");
        }};

        cophalast = new Item("cophalast", Color.valueOf("d06040")) {{
            hardness = 3;
            cost = 4;
            explosiveness = 0.5f;
            color = Color.valueOf("d06040");
        }};

        duras = new Item("duras", Color.valueOf("8899aa")) {{
            hardness = 7;
            cost = 5;
            color = Color.valueOf("8899aa");
        }};

        fabris = new Item("fabris", Color.valueOf("c0a070")) {{
            hardness = 4;
            cost = 4;
            color = Color.valueOf("c0a070");
        }};

        ferraloy = new Item("ferraloy", Color.valueOf("b0a0e0")) {{
            hardness = 6;
            cost = 7;
            color = Color.valueOf("b0a0e0");
        }};

        flaxol = new Item("flaxol", Color.valueOf("60e0ff")) {{
            hardness = 1;
            cost = 3;
            flammability = 0.1f;
            color = Color.valueOf("60e0ff");
        }};

        fortial = new Item("fortial", Color.valueOf("708090")) {{
            hardness = 8;
            cost = 6;
            color = Color.valueOf("708090");
        }};

        horani = new Item("horani", Color.valueOf("80ff40")) {{
            hardness = 4;
            cost = 9;
            radioactivity = 0.6f;
            color = Color.valueOf("80ff40");
        }};

        navitas = new Item("navitas", Color.valueOf("ffcc00")) {{
            hardness = 2;
            cost = 5;
            flammability = 0.7f;
            explosiveness = 0.4f;
            color = Color.valueOf("ffcc00");
        }};

        pausis = new Item("pausis", Color.valueOf("4060c0")) {{
            hardness = 3;
            cost = 4;
            color = Color.valueOf("4060c0");
        }};

        rudis = new Item("rudis", Color.valueOf("8b7355")) {{
            hardness = 2;
            cost = 2;
            color = Color.valueOf("8b7355");
        }};

        sand = new Item("sand", Color.valueOf("d4c878")) {{
            hardness = 1;
            cost = 1;
            color = Color.valueOf("d4c878");
        }};

        simus = new Item("simus", Color.valueOf("b0b0c0")) {{
            hardness = 4;
            cost = 3;
            color = Color.valueOf("b0b0c0");
        }};

        temperedGlass = new Item("tempered-glass", Color.valueOf("c0e8ff")) {{
            hardness = 3;
            cost = 4;
            color = Color.valueOf("c0e8ff");
        }};

        tentias = new Item("tentias", Color.valueOf("a080c0")) {{
            hardness = 2;
            cost = 5;
            color = Color.valueOf("a080c0");
        }};

        vastum = new Item("vastum", Color.valueOf("5a5a3a")) {{
            hardness = 1;
            cost = 1;
            radioactivity = 0.3f;
            color = Color.valueOf("5a5a3a");
        }};

        viscosy = new Item("viscosy", Color.valueOf("804020")) {{
            hardness = 1;
            cost = 3;
            flammability = 0.4f;
            color = Color.valueOf("804020");
        }};

        xearula = new Item("xearula", Color.valueOf("ff40ff")) {{
            hardness = 5;
            cost = 10;
            radioactivity = 0.3f;
            color = Color.valueOf("ff40ff");
        }};
    }
}
