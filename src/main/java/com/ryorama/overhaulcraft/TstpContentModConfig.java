package com.ryorama.overhaulcraft;

import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;

@Config(id = com.ryorama.overhaulcraft.TstpContentMod.MODID)
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
    @Configurable
    @Configurable.Comment("Max amount of items a hamster can consume")
    public int maxHamsterCheekSize = 3;
    @Configurable
    @Configurable.Comment("Plays all Terraria music when outside of deticated dimension")
    public boolean playAllTerrariaMusic = false;
}