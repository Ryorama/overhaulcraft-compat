package com.ryorama.overhaulcraft.mixins.confluence;

import org.confluence.lib.util.LibUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LibUtils.class)
public class LibUtilsMixin {
    /**
     * @author Ryorama
     * @reason Limit max stack size back to default
     */
    @Overwrite(remap = false)
    public static int getMaxStackSize(int original) {
        return original;
    }
}
