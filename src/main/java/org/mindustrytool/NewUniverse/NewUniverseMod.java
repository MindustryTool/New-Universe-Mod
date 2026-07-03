package org.mindustrytool.NewUniverse;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.util.Log;
import lombok.Getter;
import mindustry.Vars;
import mindustry.ctype.ContentType;
import mindustry.mod.Mod;
import mindustry.world.Block;
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
        logSpriteDiagnostics();
    }

    private void logSpriteDiagnostics() {
        int total = 0;
        TextureRegion errorRegion = Core.atlas.find("error");

        for (Block block : Vars.content.blocks()) {
            if (!block.name.startsWith("new-universe-")) continue;
            total++;

            String name = block.name;
            TextureRegion found = Core.atlas.find(name);
            boolean baseFallback = found == errorRegion;

            boolean anyVariantFallback = false;
            if (block.variants > 0) {
                for (int i = 0; i < block.variants; i++) {
                    TextureRegion vr = Core.atlas.find(name + (i + 1));
                    if (vr == errorRegion) {
                        anyVariantFallback = true;
                        break;
                    }
                }
            }

            boolean isFallback = baseFallback || anyVariantFallback;

            String type = block instanceof mindustry.world.blocks.environment.Floor ? "Floor" :
                    block instanceof mindustry.world.blocks.environment.StaticWall ? "Wall" :
                    block instanceof mindustry.world.blocks.environment.Prop ? "Prop" : "Other";

            Log.info("&lc[Diag] &ly" + name + "&lw (" + type + ") variants=" + block.variants + " " + (isFallback ? "&lrFALLBACK" : "&lcOK"));
        }

        Log.info("&lc[Diagnostic] Total " + total + " blocks.");
    }
}
