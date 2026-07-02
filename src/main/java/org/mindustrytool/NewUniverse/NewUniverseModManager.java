package org.mindustrytool.NewUniverse;

import lombok.RequiredArgsConstructor;
import org.mindustrytool.NewUniverse.content.borealis.BorealisManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class NewUniverseModManager {
    private final BorealisManager borealisManager;

    public void loadContent() {
        borealisManager.loadContent();
    }
}
