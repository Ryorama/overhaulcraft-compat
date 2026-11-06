package com.ryorama.overhaulcraft.mixins.cobbleloots;

import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import dev.ripio.cobbleloots.event.custom.CobblelootsFishingEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CobblelootsFishingEvents.class)
public class CobblelootsFishingEventsMixin {
    @Inject(at = @At("HEAD"), method = "onFishingSuccess", cancellable = true)
    private static void onFishingSuccess(ServerLevel level, ServerPlayer player, BlockPos hookPos, ItemStack rodStack, CallbackInfo ci) {
        if (!level.dimension().equals(CobblemonDim.LEVEL)) {
            ci.cancel();
        }
    }
}
