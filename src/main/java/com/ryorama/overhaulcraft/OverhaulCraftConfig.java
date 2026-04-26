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
    public boolean threadedNukeExplosion = false;
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
    @Configurable.Comment("Play Terraria Music\nWill only play in the mods dimension if Confluence Dimension Patch is installed")
    public boolean playTerrariaMusic = false;
    @Configurable.Comment("Adds & changes content from confluence to closer relate to Terraria")
    @Configurable
    public boolean moreTerrariaContent = true;
}