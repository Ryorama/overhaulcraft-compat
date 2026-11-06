package com.ryorama.overhaulcraft.mixins.dog;

import it.yuruni.dog.client.sound.DogBossMusic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DogBossMusic.class)
public class DogBossMusicMixin {
    @Inject(at = @At("HEAD"), method = "swapToEulogy", cancellable = true)
    private static void swapToEulogy(CallbackInfo ci) {
        ci.cancel();
    }
}
