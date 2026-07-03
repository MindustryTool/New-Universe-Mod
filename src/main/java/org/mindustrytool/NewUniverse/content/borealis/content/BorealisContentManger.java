package org.mindustrytool.NewUniverse.content.borealis.content;

import lombok.RequiredArgsConstructor;
import org.mindustrytool.NewUniverse.content.borealis.content.item.BorealisItems;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.BorealisUnitTypes;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisContentManger {
    private final BorealisItems borealisItems;
    private final BorealisUnitTypes borealisUnitTypes;

    public void loadContent() {
        borealisItems.loadContent();
        borealisUnitTypes.loadContent();
    }
}
