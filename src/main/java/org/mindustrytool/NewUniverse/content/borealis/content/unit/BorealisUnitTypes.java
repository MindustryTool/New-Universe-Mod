package org.mindustrytool.NewUniverse.content.borealis.content.unit;

import org.mindustrytool.NewUniverse.content.borealis.content.unit.air.BorealisDiphdaUnitTypes;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.ground.BorealisNoaUnitTypes;
import org.mindustrytool.NewUniverse.content.borealis.content.unit.naval.BorealisIndusUnitTypes;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisUnitTypes {

    private final BorealisDiphdaUnitTypes air;
    private final BorealisNoaUnitTypes ground;
    private final BorealisIndusUnitTypes naval;

    public void loadContent() {
        air.loadContent();
        ground.loadContent();
        naval.loadContent();
    }
}
