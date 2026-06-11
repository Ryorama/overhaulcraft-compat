package com.ryorama.overhaulcraft.mixins.confluence;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import org.confluence.mod.common.item.accessory.GuideVooDooDollItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GuideVooDooDollItem.class)
public class GuideVoodDooDollItemMixin {
    @ModifyReturnValue(at = @At("RETURN"), method = "isFoil")
    public boolean isFoil(boolean original) {
        return false;
    }
}
