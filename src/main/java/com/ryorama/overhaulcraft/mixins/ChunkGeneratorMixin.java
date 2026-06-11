package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import com.ryorama.overhaulcraft.mixed.IStructureSet;
import net.minecraft.core.Holder;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@IfModLoaded("confluence_dimension_patch")
@Mixin(ChunkGenerator.class)
public abstract class ChunkGeneratorMixin {
    @ModifyExpressionValue(method = "lambda$createStructures$14", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/structure/placement/StructurePlacement;isStructureChunk(Lnet/minecraft/world/level/chunk/ChunkGeneratorStructureState;II)Z"))
    private boolean skip(boolean original, @Local(argsOnly = true) ChunkGeneratorStructureState structureState, @Local(argsOnly = true) Holder<StructureSet> holder) {
        if (original && !IDimensionAccessor.of(structureState).oc$isOverworld()) {
            if (IDimensionAccessor.of(structureState).oc$isConfluence() && !IStructureSet.of(holder.value()).oc$isNotFromConfluence()) {
                return true;
            }
            if (IDimensionAccessor.of(structureState).oc$isCobblemon() && !IStructureSet.of(holder.value()).oc$isNotFromCobblemon()) {
                return true;
            }
        }

        return false;
    }
}