package com.ryorama.tstpcontent.utils;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.level.biome.Biome;

import java.util.Map;

public interface WolfVarient {
    EntityDataAccessor<Integer> getVariant();
    Map<Biome, Integer> getVariantSpawnData();
}
