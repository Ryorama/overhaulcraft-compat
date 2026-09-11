package com.ryorama.overhaulcraft.mixins;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@IfModLoaded("confluence_dimension_patch")
@Mixin(BiomeSource.class)
public abstract class BiomeSourceMixin implements IDimensionAccessor {
    @Unique
    private boolean oc$isOverworld = false;
    @Unique
    private boolean oc$isConfluence = false;
    @Unique
    private boolean oc$isCobblemon = false;

    @Override
    public void oc$setIsOverworld(boolean value) {
        this.oc$isOverworld = value;
    }

    @Override
    public boolean oc$isOverworld() {
        return oc$isOverworld;
    }

    @Override
    public void oc$setIsConfluence(boolean value) {
        this.oc$isConfluence = value;
    }

    @Override
    public boolean oc$isConfluence() {
        return oc$isConfluence;
    }

    @Override
    public void oc$setIsCobblemon(boolean value) {
        this.oc$isCobblemon = value;
    }

    @Override
    public boolean oc$isCobblemon() {
        return oc$isCobblemon;
    }
}