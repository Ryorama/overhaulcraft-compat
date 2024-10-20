package com.ryorama.tstpcontent;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = TstpContentMod.MODID)
public class TstpContentModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean threadedNukeExplosion = true;
}