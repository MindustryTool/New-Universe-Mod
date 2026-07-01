package com.frogg;

import arc.util.CommandHandler;
import arc.util.Log;
import mindustry.mod.Mod;

/**
 * Main entry point for the Frogg Mindustry mod.
 *
 * HJSON content files in content/{items,units,...}/ are auto-loaded by
 * the game's Mods.loadContent() — no Java code needed to register them.
 *
 * Use loadContent() only for content that requires programmatic logic
 * (custom AI, conditional stats, dynamic effects, etc.).
 */
public class FroggMod extends Mod {

    public FroggMod() {
        Log.info("Frogg mod loaded.");
        // Register event listeners here if needed:
        // Events.on(EventType.ClientLoadEvent.class, e -> { ... });
    }

    @Override
    public void loadContent() {
        Log.info("Frogg: loading custom content.");
        // HJSON files in content/ are auto-loaded by Mods.loadContent().
        // Register programmatic content here when needed:
        //
        // FroggItems.load();
        // FroggUnits.load();
        // FroggBlocks.load();
    }

    @Override
    public void init() {
        // Called after all plugins created and commands registered.
        // Use for server-side initialization.
    }

    @Override
    public void registerServerCommands(CommandHandler handler) {
        // Register server-side console commands.
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        // Register client-side console commands.
    }
}
