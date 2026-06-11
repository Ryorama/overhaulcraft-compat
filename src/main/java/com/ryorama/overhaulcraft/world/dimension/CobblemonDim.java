package com.ryorama.overhaulcraft.world.dimension;

import com.ryorama.overhaulcraft.OverhaulCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class CobblemonDim {
    public static final ResourceKey<DimensionType> DIMENSION_TYPE;
    public static final ResourceKey<Level> LEVEL;

    static {
        DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "otherworld"));
        LEVEL = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "otherworld"));
    }
}
