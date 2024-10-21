package com.ryorama.tstpcontent;

import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;

@Config(id = TstpContentMod.MODID)
public class TstpContentModConfig {
    @Configurable
    public boolean threadedNukeExplosion = true;
}