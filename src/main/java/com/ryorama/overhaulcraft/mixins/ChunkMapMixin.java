package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@IfModLoaded("confluence_dimension_patch")
@Mixin(ChunkMap.class)
public abstract class ChunkMapMixin {
    @Shadow
    @Final
    ServerLevel level;

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/ChunkGenerator;createState(Lnet/minecraft/core/HolderLookup;Lnet/minecraft/world/level/levelgen/RandomState;J)Lnet/minecraft/world/level/chunk/ChunkGeneratorStructureState;"))
    private ChunkGeneratorStructureState apply(ChunkGeneratorStructureState original, @Local(argsOnly = true) ChunkGenerator generator) {
        if (level.dimension() == Level.OVERWORLD) {
            IDimensionAccessor.of(original).oc$setIsOverworld(true);
            IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsOverworld(true);
        }

        if (level.dimension() == OtherWorld.LEVEL) {
            IDimensionAccessor.of(original).oc$setIsConfluence(true);
            IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsConfluence(true);

        }

        if (level.dimension() == CobblemonDim.LEVEL) {
            IDimensionAccessor.of(original).oc$setIsCobblemon(true);
            IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsCobblemon(true);
        }

        return original;
    }
}