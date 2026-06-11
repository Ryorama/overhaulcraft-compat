package com.ryorama.overhaulcraft.mixins.confluence;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import org.confluence.lib.util.LibUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LibUtils.class)
public class LibUtilsMixin {
    @ModifyReturnValue(at = @At("RETURN"), method = "getMaxStackSize", remap = false)
    private static int getMaxStackSize(int original) {
        return original;
    }
}
