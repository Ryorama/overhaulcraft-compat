package com.ryorama.overhaulcraft.mixins.burnt;

import net.minecraft.world.level.LevelAccessor;
import net.pixelbank.burnt.procedures.ExtinguishBlockProcedure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExtinguishBlockProcedure.class)
public class ExtinguishBlockProcedureMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/TagKey;)Z", ordinal = 0), method = "execute(Lnet/minecraft/world/level/LevelAccessor;DDDZ)V")
    private static void execute(LevelAccessor world, double x, double y, double z, boolean showSpray, CallbackInfo ci) {

    }
}