package org.mindustrytool.NewUniverse.content.borealis;

import lombok.RequiredArgsConstructor;
import org.mindustrytool.NewUniverse.content.borealis.content.BorealisContents;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisManager {
    private final BorealisPlanets borealisPlanets;
    private final BorealisContents borealisContents;

    public void loadContent() {
        borealisContents.loadContent();

        borealisPlanets.loadContent();
    }
}
