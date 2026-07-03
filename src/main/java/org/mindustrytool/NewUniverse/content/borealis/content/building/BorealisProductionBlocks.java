package org.mindustrytool.NewUniverse.content.borealis.content.building;

import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisProductionBlocks {

    public Block prod2a;
    public Block prod2b;
    public Block prod2c;
    public Block prod2d;
    public Block prod2e;
    public Block prod2f;
    public Block prod2g;
    public Block prod2h;
    public Block prod2i;
    public Block prod2k;
    public Block prod3a;
    public Block prod3b;
    public Block prod3c;
    public Block prod3d;
    public Block prod3e;

    public void loadContent() {
        prod2a = new GenericCrafter("prod-2a") {{
            size = 2;
        }};

        prod2b = new GenericCrafter("prod-2b") {{
            size = 2;
        }};

        prod2c = new GenericCrafter("prod-2c") {{
            size = 2;
        }};

        prod2d = new GenericCrafter("prod-2d") {{
            size = 2;
        }};

        prod2e = new GenericCrafter("prod-2e") {{
            size = 2;
        }};

        prod2f = new GenericCrafter("prod-2f") {{
            size = 2;
        }};

        prod2g = new GenericCrafter("prod-2g") {{
            size = 2;
        }};

        prod2h = new GenericCrafter("prod-2h") {{
            size = 2;
        }};

        prod2i = new GenericCrafter("prod-2i") {{
            size = 2;
        }};

        prod2k = new GenericCrafter("prod-2k") {{
            size = 2;
        }};

        prod3a = new GenericCrafter("prod-3a") {{
            size = 3;
        }};

        prod3b = new GenericCrafter("prod-3b") {{
            size = 3;
        }};

        prod3c = new GenericCrafter("prod-3c") {{
            size = 3;
        }};

        prod3d = new GenericCrafter("prod-3d") {{
            size = 3;
        }};

        prod3e = new GenericCrafter("prod-3e") {{
            size = 3;
        }};
    }
}
