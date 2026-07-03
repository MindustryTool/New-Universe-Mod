package org.mindustrytool.NewUniverse.content.borealis.content.building;

import mindustry.world.Block;
import mindustry.world.blocks.power.SolarGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisPowerBlocks {

    public Block pwr2a;
    public Block pwr2b;
    public Block pwr3a;
    public Block pwr3b;
    public Block pwr3c;
    public Block pwr3d;
    public Block pwr4a;

    public void loadContent() {
        pwr2a = new SolarGenerator("pwr-2a") {{
            size = 2;
        }};

        pwr2b = new SolarGenerator("pwr-2b") {{
            size = 2;
        }};

        pwr3a = new SolarGenerator("pwr-3a") {{
            size = 3;
        }};

        pwr3b = new SolarGenerator("pwr-3b") {{
            size = 3;
        }};

        pwr3c = new SolarGenerator("pwr-3c") {{
            size = 3;
        }};

        pwr3d = new SolarGenerator("pwr-3d") {{
            size = 3;
        }};

        pwr4a = new SolarGenerator("pwr-4a") {{
            size = 4;
        }};
    }
}
