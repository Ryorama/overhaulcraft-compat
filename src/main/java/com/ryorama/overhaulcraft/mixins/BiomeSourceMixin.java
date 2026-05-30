package com.ryorama.overhaulcraft.mixins;

import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BiomeSource.class)
public abstract class BiomeSourceMixin implements IDimensionAccessor {
    @Unique
    private boolean oc$notOverworld = false;
    @Unique
    private boolean oc$isConfluence = false;
    @Unique
    private boolean oc$isCobblemon = false;

    @Override
    public void oc$setIsNotOverworld() {
        this.oc$notOverworld = true;
    }

    @Override
    public boolean oc$isNotOverworld() {
        return oc$notOverworld;
    }

    @Override
    public void oc$setIsConfluence() {
        this.oc$isConfluence = false;
    }

    @Override
    public boolean oc$isConfluence() {
        return oc$isConfluence;
    }

    @Override
    public void oc$setIsCobblemon() {
        this.oc$isCobblemon = false;
    }

    @Override
    public boolean oc$isCobblemon() {
        return oc$isCobblemon;
    }
}