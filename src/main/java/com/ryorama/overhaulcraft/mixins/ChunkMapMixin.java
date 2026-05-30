package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChunkMap.class)
public abstract class ChunkMapMixin {
    @Shadow
    @Final
    ServerLevel level;

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/ChunkGenerator;createState(Lnet/minecraft/core/HolderLookup;Lnet/minecraft/world/level/levelgen/RandomState;J)Lnet/minecraft/world/level/chunk/ChunkGeneratorStructureState;"))
    private ChunkGeneratorStructureState apply(ChunkGeneratorStructureState original, @Local(argsOnly = true) ChunkGenerator generator) {
        if (level.dimension() != Level.OVERWORLD) {
            IDimensionAccessor.of(original).oc$setIsNotOverworld();
            IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsNotOverworld();
            if (level.dimension().location().equals(ResourceLocation.parse("confluence_dimension_patch:otherworld"))) {
                IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsConfluence();
            }
            if (level.dimension().location().equals(ResourceLocation.parse("overhaulcraft:cobblemon_dim"))) {
                IDimensionAccessor.of(generator.getBiomeSource()).oc$setIsCobblemon();
            }
        }
        return original;
    }
}