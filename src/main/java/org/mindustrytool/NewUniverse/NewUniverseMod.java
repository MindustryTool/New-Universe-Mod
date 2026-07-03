package org.mindustrytool.NewUniverse;

import arc.util.Log;
import lombok.Getter;
import mindustry.mod.Mod;
import org.codejargon.feather.Feather;

public class NewUniverseMod extends Mod {
    private static @Getter Feather feather;

    public NewUniverseMod() {
        feather = Feather.with();

        Log.info("New Universe mod loaded.");
    }

    @Override
    public void loadContent() {
        Log.info("New Universe: loading custom content.");

        feather.instance(NewUniverseModManager.class).loadContent();

        Log.info("New Universe: loaded custom content.");
    }

    @Override
    public void init() {

    }
}
