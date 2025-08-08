package com.ryorama.overhaulcraft.mixins;

import com.ryorama.overhaulcraft.events.BlockStateUpdatedEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public class LevelMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/LevelChunk;setBlockState(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Z)Lnet/minecraft/world/level/block/state/BlockState;", shift = At.Shift.AFTER), method = "setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;II)Z")
    public void setBlock(BlockPos arg, BlockState arg2, int i, int j, CallbackInfoReturnable<Boolean> cir) {
        NeoForge.EVENT_BUS.post(new BlockStateUpdatedEvent((Level)(Object)this, arg2, arg));
    }
}
