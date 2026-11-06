package com.ryorama.overhaulcraft.mixins.twilightforest;

import com.ryorama.overhaulcraft.OverhaulCraftCommonConfig;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import twilightforest.events.TravellersGearEvents;

@Mixin(TravellersGearEvents.class)
public class TravellersGearEventsMixin {
    @Inject(at = @At("HEAD"), method = "updateOtherModifiers", cancellable = true)
    private void updateOtherModifiers(EntityTickEvent.Post event, CallbackInfo ci) {
        if (!ExtraFunc.hasSecondsPassed(event.getEntity().level().getGameTime(), OverhaulCraftCommonConfig.TWILIGHT_FOREST_GEAR_TICK_DELAY.get())) {
            ci.cancel();
        }
    }
}