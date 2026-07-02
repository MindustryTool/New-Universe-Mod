package org.mindustrytool.NewUniverse.content;

import arc.struct.Seq;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

/**
 * Programmatic unit type definitions for Glacius, a cold planet.
 * <p>
 * Glacius units have higher armor and health but lower speed compared to
 * Serpulo equivalents. Defined in tiers 1-5 for air, mech, and naval lines,
 * plus three special boss/support units.
 * <p>
 * Called from {@link org.mindustrytool.NewUniverse.NewUniverseMod#loadContent()}.
 */
public class NewUniverseUnitTypes {

    // ── Air tier (flying) ──────────────────────────────────────────────

    public static UnitType glaciusHerja = new UnitType("glacius-herja") {{
        constructor = UnitEntity::create;
        speed = 1.8f;
        health = 800;
        armor = 3f;
        hitSize = 14;
        flying = true;
        lowAltitude = true;
        engineSize = 2;
        trailLength = 4;
    }};

    public static UnitType glaciusEir = new UnitType("glacius-eir") {{
        constructor = UnitEntity::create;
        speed = 1.6f;
        health = 3200;
        armor = 6f;
        hitSize = 22;
        flying = true;
        lowAltitude = true;
        engineSize = 3;
        trailLength = 5;
    }};

    public static UnitType glaciusHlokk = new UnitType("glacius-hlokk") {{
        constructor = UnitEntity::create;
        speed = 1.4f;
        health = 6800;
        armor = 9f;
        hitSize = 30;
        flying = true;
        lowAltitude = true;
        engineSize = 4;
        trailLength = 6;
    }};

    public static UnitType glaciusGondul = new UnitType("glacius-gondul") {{
        constructor = UnitEntity::create;
        speed = 1.2f;
        health = 12000;
        armor = 12f;
        hitSize = 38;
        flying = true;
        lowAltitude = true;
        engineSize = 5;
        trailLength = 8;
    }};

    public static UnitType glaciusSkogul = new UnitType("glacius-skogul") {{
        constructor = UnitEntity::create;
        speed = 1.0f;
        health = 19000;
        armor = 15f;
        hitSize = 65;
        flying = true;
        lowAltitude = true;
        engineSize = 6;
        trailLength = 9;
    }};

    // ── Mech tier (ground) ────────────────────────────────────────────

    public static UnitType glaciusJotunn = new UnitType("glacius-jotunn") {{
        constructor = UnitEntity::create;
        speed = 0.6f;
        health = 2000;
        armor = 6f;
        hitSize = 16;
    }};

    public static UnitType glaciusYmir = new UnitType("glacius-ymir") {{
        constructor = UnitEntity::create;
        speed = 0.55f;
        health = 5200;
        armor = 10f;
        hitSize = 24;
    }};

    public static UnitType glaciusThrymr = new UnitType("glacius-thrymr") {{
        constructor = UnitEntity::create;
        speed = 0.5f;
        health = 10000;
        armor = 14f;
        hitSize = 32;
    }};

    public static UnitType glaciusBergelmir = new UnitType("glacius-bergelmir") {{
        constructor = UnitEntity::create;
        speed = 0.45f;
        health = 17000;
        armor = 18f;
        hitSize = 42;
    }};

    public static UnitType glaciusSurtr = new UnitType("glacius-surtr") {{
        constructor = UnitEntity::create;
        speed = 0.4f;
        health = 25000;
        armor = 22f;
        hitSize = 52;
    }};

    // ── Naval tier ────────────────────────────────────────────────────

    public static UnitType glaciusAegir = new UnitType("glacius-aegir") {{
        constructor = UnitEntity::create;
        speed = 0.8f;
        health = 3000;
        armor = 5f;
        hitSize = 18;
        naval = true;
        trailLength = 12;
        rippleScale = 2;
    }};

    public static UnitType glaciusRan = new UnitType("glacius-ran") {{
        constructor = UnitEntity::create;
        speed = 0.72f;
        health = 7000;
        armor = 8f;
        hitSize = 26;
        naval = true;
        trailLength = 18;
        rippleScale = 3;
    }};

    public static UnitType glaciusNjordr = new UnitType("glacius-njordr") {{
        constructor = UnitEntity::create;
        speed = 0.65f;
        health = 13000;
        armor = 12f;
        hitSize = 36;
        naval = true;
        trailLength = 24;
        rippleScale = 4;
    }};

    public static UnitType glaciusJormun = new UnitType("glacius-jormun") {{
        constructor = UnitEntity::create;
        speed = 0.57f;
        health = 21000;
        armor = 16f;
        hitSize = 46;
        naval = true;
        trailLength = 32;
        rippleScale = 6;
    }};

    public static UnitType glaciusLyngbakr = new UnitType("glacius-lyngbakr") {{
        constructor = UnitEntity::create;
        speed = 0.5f;
        health = 30000;
        armor = 20f;
        hitSize = 62;
        naval = true;
        trailLength = 40;
        rippleScale = 8;
    }};

    // ── Special units ─────────────────────────────────────────────────

    /** Heavy flying dreadnought. Slow but heavily armored. */
    public static UnitType spearhead = new UnitType("spearhead") {{
        constructor = UnitEntity::create;
        speed = 0.75f;
        health = 19000;
        armor = 14f;
        hitSize = 70;
        flying = true;
        lowAltitude = true;
        engineSize = 6;
        trailLength = 9;
    }};

    /** Aerial support gunship. Moderate speed and armor. */
    public static UnitType altiar = new UnitType("altiar") {{
        constructor = UnitEntity::create;
        speed = 1.2f;
        health = 8000;
        armor = 8f;
        hitSize = 50;
        flying = true;
        lowAltitude = true;
        engineSize = 4;
        trailLength = 6;
    }};

    /** Colossal naval fortress. Extremely durable but very slow. */
    public static UnitType cetus = new UnitType("cetus") {{
        constructor = UnitEntity::create;
        speed = 0.5f;
        health = 25000;
        armor = 18f;
        hitSize = 70;
        naval = true;
        rippleScale = 10;
        trailLength = 50;
    }};

    // ── Groupings ─────────────────────────────────────────────────────

    public static Seq<UnitType> glaciusAirUnits = Seq.with(
        glaciusHerja, glaciusEir, glaciusHlokk, glaciusGondul, glaciusSkogul
    );

    public static Seq<UnitType> glaciusMechUnits = Seq.with(
        glaciusJotunn, glaciusYmir, glaciusThrymr, glaciusBergelmir, glaciusSurtr
    );

    public static Seq<UnitType> glaciusNavalUnits = Seq.with(
        glaciusAegir, glaciusRan, glaciusNjordr, glaciusJormun, glaciusLyngbakr
    );

    public static Seq<UnitType> glaciusAllUnits = Seq.with(
        glaciusHerja, glaciusEir, glaciusHlokk, glaciusGondul, glaciusSkogul,
        glaciusJotunn, glaciusYmir, glaciusThrymr, glaciusBergelmir, glaciusSurtr,
        glaciusAegir, glaciusRan, glaciusNjordr, glaciusJormun, glaciusLyngbakr,
        spearhead, altiar, cetus
    );

    /**
     * Initializes all unit type static fields.
     * <p>
     * Called from {@code NewUniverseMod.loadContent()} during mod startup.
     * Fields are initialized via their static initializers; this method
     * exists as a hook to ensure the class is loaded and for future setup.
     */
    public static void load() {
        // All unit types are instantiated via static field initializers above.
    }
}
