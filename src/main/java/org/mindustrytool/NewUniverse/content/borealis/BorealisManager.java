package org.mindustrytool.NewUniverse.content.borealis;

import lombok.RequiredArgsConstructor;
import org.mindustrytool.NewUniverse.content.borealis.erisa.ErisaBlocks;
import org.mindustrytool.NewUniverse.content.borealis.erisa.ErisaItems;
import org.mindustrytool.NewUniverse.content.borealis.erisa.ErisaTechTree;
import org.mindustrytool.NewUniverse.content.borealis.erisa.ErisaUnitTypes;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisManager {
    private final ErisaItems erisaItems;
    private final ErisaBlocks erisaBlocks;
    private final ErisaUnitTypes erisaUnitTypes;

    private final BorealisPlanets borealisPlanets;
    private final ErisaTechTree erisaTechTree;

    public void loadContent() {
        erisaItems.loadContent();
        erisaBlocks.loadContent();
        erisaUnitTypes.loadContent();

        borealisPlanets.loadContent();

        erisaTechTree.loadContent();
    }
}
