package com.ryorama.overhaulcraft.mixins.windswept;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.rosemods.windswept.common.item.WoodenBucketItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WoodenBucketItem.class)
public abstract class WoodenBucketItemMixin extends BucketItem {
    @Shadow public abstract boolean isEmpty();

    public WoodenBucketItemMixin(Fluid content, Properties properties) {
        super(content, properties);
    }

    @ModifyReturnValue(at = @At("RETURN"), method = "getBurnTime")
    public int getBurnTime(int original) {
        return this.isEmpty() ? 600 : 0;
    }
}
