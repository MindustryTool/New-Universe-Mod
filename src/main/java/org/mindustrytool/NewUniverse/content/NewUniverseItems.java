package org.mindustrytool.NewUniverse.content;

import arc.graphics.Color;
import mindustry.type.Item;

/**
 * Programmatic item definitions for the Borealis star system.
 * <p>
 * Items are instantiated via double-brace initialization and registered
 * later through Feather dependency injection.
 * <p>
 * Called from {@link org.mindustrytool.NewUniverse.NewUniverseMod#loadContent()}.
 */
public class NewUniverseItems {

    /** Blue crystalline energy source. High radioactivity, low flammability. */
    public static Item cryoCrystal = new Item("cryo-crystal", Color.valueOf("60a0ff")) {{
        hardness = 3;
        cost = 4;
        radioactivity = 0.4f;
        explosiveness = 0.1f;
        flammability = 0.05f;
        color = Color.valueOf("60a0ff");
    }};

    /** Grey ice-iron ore for structural applications. Dense, non-flammable. */
    public static Item frozenIron = new Item("frozen-iron", Color.valueOf("8899aa")) {{
        hardness = 5;
        cost = 3;
        color = Color.valueOf("8899aa");
        flammability = 0.01f;
    }};

    /** Yellow volcanic chemical. Highly flammable and explosive. */
    public static Item volcanicSulfur = new Item("volcanic-sulfur", Color.valueOf("d4b040")) {{
        flammability = 0.8f;
        explosiveness = 0.6f;
        cost = 5;
        color = Color.valueOf("d4b040");
        radioactivity = 0.1f;
    }};

    /** Advanced cryo-enhanced composite. Very hard, moderately radioactive. */
    public static Item cryoAlloy = new Item("cryo-alloy", Color.valueOf("80c0ff")) {{
        hardness = 7;
        cost = 8;
        color = Color.valueOf("80c0ff");
        radioactivity = 0.1f;
    }};

    /** Basic waste byproduct from glacius mining operations. */
    public static Item glaciusRubble = new Item("glacius-rubble", Color.valueOf("8a8a8a")) {{
        hardness = 1;
        cost = 1;
        color = Color.valueOf("8a8a8a");
    }};

    // ------------------------------------------------------------------
    //  New Items (from sprites/items/)
    // ------------------------------------------------------------------

    /** Gold-like conductive metal. Precious, high cost, excellent conductivity. */
    public static Item aurum = new Item("aurum", Color.valueOf("ffd700")) {{
        hardness = 2;
        cost = 8;
        color = Color.valueOf("ffd700");
    }};

    /** Volcanic mineral compound. Moderately explosive. */
    public static Item cophalast = new Item("cophalast", Color.valueOf("d06040")) {{
        hardness = 3;
        cost = 4;
        explosiveness = 0.5f;
        color = Color.valueOf("d06040");
    }};

    /** Durable structural alloy. Very hard, ideal for armor plating. */
    public static Item duras = new Item("duras", Color.valueOf("8899aa")) {{
        hardness = 7;
        cost = 5;
        color = Color.valueOf("8899aa");
    }};

    /** Versatile manufacturing composite. Easy to shape, moderate strength. */
    public static Item fabris = new Item("fabris", Color.valueOf("c0a070")) {{
        hardness = 4;
        cost = 4;
        color = Color.valueOf("c0a070");
    }};

    /** High-grade alloy composite. Advanced material for precision components. */
    public static Item farasAloy = new Item("faras-aloy", Color.valueOf("b0a0e0")) {{
        hardness = 6;
        cost = 7;
        color = Color.valueOf("b0a0e0");
    }};

    /** Cryo-coolant fluid. Used in thermal regulation systems. */
    public static Item flaxol = new Item("flaxol", Color.valueOf("60e0ff")) {{
        hardness = 1;
        cost = 3;
        flammability = 0.1f;
        color = Color.valueOf("60e0ff");
    }};

    /** Reinforced structural plating. Extremely durable, low conductivity. */
    public static Item fortial = new Item("fortial", Color.valueOf("708090")) {{
        hardness = 8;
        cost = 6;
        color = Color.valueOf("708090");
    }};

    /** Radioactive crystal. Emits hazardous radiation, glows green. */
    public static Item horani = new Item("horani", Color.valueOf("80ff40")) {{
        hardness = 4;
        cost = 9;
        radioactivity = 0.6f;
        color = Color.valueOf("80ff40");
    }};

    /** Energy-dense fuel compound. Highly flammable and volatile. */
    public static Item navitas = new Item("navitas", Color.valueOf("ffcc00")) {{
        hardness = 2;
        cost = 5;
        flammability = 0.7f;
        explosiveness = 0.4f;
        color = Color.valueOf("ffcc00");
    }};

    /** Cryo-stabilizer compound. Used to regulate thermal reactions. */
    public static Item pausis = new Item("pausis", Color.valueOf("4060c0")) {{
        hardness = 3;
        cost = 4;
        color = Color.valueOf("4060c0");
    }};

    /** Raw mineral ore. Unprocessed, rough, abundant. */
    public static Item rudis = new Item("rudis", Color.valueOf("8b7355")) {{
        hardness = 2;
        cost = 2;
        color = Color.valueOf("8b7355");
    }};

    /** Construction-grade sand. Common building material. */
    public static Item sand = new Item("sand", Color.valueOf("d4c878")) {{
        hardness = 1;
        cost = 1;
        color = Color.valueOf("d4c878");
    }};

    /** Processed metal plates. Flat, uniform, ready for assembly. */
    public static Item simus = new Item("simus", Color.valueOf("b0b0c0")) {{
        hardness = 4;
        cost = 3;
        color = Color.valueOf("b0b0c0");
    }};

    /** Heat-resistant glass compound. Withstands extreme temperatures. */
    public static Item temperedGlass = new Item("tempered-glass", Color.valueOf("c0e8ff")) {{
        hardness = 3;
        cost = 4;
        color = Color.valueOf("c0e8ff");
    }};

    /** Organic polymer fiber. Flexible, resilient, tentacle-like. */
    public static Item tentias = new Item("tentias", Color.valueOf("a080c0")) {{
        hardness = 2;
        cost = 5;
        color = Color.valueOf("a080c0");
    }};

    /** Hazardous waste material. Low value, slightly radioactive. */
    public static Item vastum = new Item("vastum", Color.valueOf("5a5a3a")) {{
        hardness = 1;
        cost = 1;
        radioactivity = 0.3f;
        color = Color.valueOf("5a5a3a");
    }};

    /** Viscous industrial lubricant. Thick, sticky, moderately flammable. */
    public static Item viscosy = new Item("viscosy", Color.valueOf("804020")) {{
        hardness = 1;
        cost = 3;
        flammability = 0.4f;
        color = Color.valueOf("804020");
    }};

    /** Exotic crystalline mineral. Extremely rare, highly valuable. */
    public static Item xearula = new Item("xearula", Color.valueOf("ff40ff")) {{
        hardness = 5;
        cost = 10;
        radioactivity = 0.3f;
        color = Color.valueOf("ff40ff");
    }};

    /**
     * Initializes and registers all items.
     * <p>
     * Called from {@code NewUniverseMod.loadContent()} during mod startup.
     * Registration occurs automatically via the Item constructor; this method
     * exists as a future hook point for cross-item setup.
     */
    public static void load() {
        // All items are instantiated via their static field initializers above.
        // No additional registration logic is required at this time.
    }
}
