package com.ryorama.overhaulcraft.mixins;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.world.level.levelgen.RandomState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@IfModLoaded("confluence_dimension_patch")
@Mixin(RandomState.class)
public abstract class RandomStateMixin implements IDimensionAccessor {
    @Unique
    private boolean oc$isNotReplacable;
    @Unique
    private boolean oc$isConfluence;
    @Unique
    private boolean oc$isCobblemon;

    @Override
    public void oc$setIsNotReplacable() {
        this.oc$isNotReplacable = true;
    }

    @Override
    public boolean oc$IsNotReplacable() {
        return oc$isNotReplacable;
    }

    @Override
    public void oc$setIsConfluence() {
        this.oc$isConfluence = true;
    }

    @Override
    public boolean oc$isConfluence() {
        return oc$isConfluence;
    }

    @Override
    public void oc$setIsCobblemon() {
        this.oc$isCobblemon = true;
    }

    @Override
    public boolean oc$isCobblemon() {
        return oc$isCobblemon;
    }
}