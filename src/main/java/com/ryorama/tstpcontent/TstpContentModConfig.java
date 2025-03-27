package com.ryorama.tstpcontent;

import dev.ghen.thirst.foundation.config.CommonConfig;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;

@Config(id = TstpContentMod.MODID)
public class TstpContentModConfig {
    @Configurable
    public boolean threadedNukeExplosion = true;
    @Configurable
    public float conversionCrucibleRadius = 10;
    @Configurable
    public boolean restrictDimensionTravelToPlanets = false;
    @Configurable
    public boolean restrictNetherAndEndToPlanets = false;
    @Configurable
    public boolean peacefulHunger = false;
    @Configurable
    public boolean peacefulThirst = false;
}