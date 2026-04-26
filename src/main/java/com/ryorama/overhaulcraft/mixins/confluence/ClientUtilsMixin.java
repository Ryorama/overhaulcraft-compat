package com.ryorama.overhaulcraft.mixins.confluence;

import org.confluence.mod.util.ClientUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientUtils.class)
public class ClientUtilsMixin {
    @Inject(at = @At("HEAD"), method = "shouldDisplayTeam", cancellable = true)
    private static void shouldDisplayTeam(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
