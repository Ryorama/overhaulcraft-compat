package com.ryorama.overhaulcraft.mixins.cobblemon;

import com.cobblemon.mod.common.api.spawning.spawner.Spawner;
import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Spawner.class)
public interface SpawnerMixin {
    @Inject(at = @At("HEAD"), method = "isValidStartPoint", cancellable = true)
    default void isValidStartPoint(Level world, ChunkAccess chunk, BlockPos.MutableBlockPos startPos, CallbackInfoReturnable<Boolean> cir) {
        if (!world.dimension().equals(CobblemonDim.LEVEL)) {
            cir.setReturnValue(false);
        }
    }
}
