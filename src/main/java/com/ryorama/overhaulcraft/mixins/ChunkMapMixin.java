package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@IfModLoaded("confluence_dimension_patch")
@Mixin(ChunkMap.class)
public abstract class ChunkMapMixin {
    @Shadow
    @Final
    private RandomState randomState;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void apply(CallbackInfo ci, @Local(argsOnly = true) ServerLevel level, @Local(argsOnly = true) ChunkGenerator generator) {
        if (level.dimension() != OtherWorld.LEVEL && level.dimension() != CobblemonDim.LEVEL) {
            IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsNotReplacable();
            IDimensionAccessor.of(randomState).oc$setIsNotReplacable();
        }

        if (level.dimension() == OtherWorld.LEVEL) {
            IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsConfluence();
            IDimensionAccessor.of(randomState).oc$setIsConfluence();

        }

        if (level.dimension() == CobblemonDim.LEVEL) {
            IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsCobblemon();
            IDimensionAccessor.of(randomState).oc$setIsCobblemon();
        }
    }
}