package com.ryorama.overhaulcraft;

import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;

@Config(id = com.ryorama.overhaulcraft.OverhaulCraft.MODID)
public class OverhaulCraftConfig {
    @Configurable
    public boolean restrictDimensionTravelToPlanets = false;
    @Configurable
    public boolean restrictNetherAndEndToPlanets = false;
    @Configurable
    public float conversionCrucibleRadius = 10f;
    @Configurable
    public boolean peacefulHunger = false;
    @Configurable
    public boolean peacefulThirst = false;
    @Configurable
    @Configurable.Comment("Plays custom music for bosses")
    public boolean playBossMusic = false;
    @Configurable
    @Configurable.Comment("Play Terraria Music when in the confluence dimension")
    public boolean playTerrariaMusic = false;
    @Configurable
    public boolean enableGregtechRecipes = false;
}