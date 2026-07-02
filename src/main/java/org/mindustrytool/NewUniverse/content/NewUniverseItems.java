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
