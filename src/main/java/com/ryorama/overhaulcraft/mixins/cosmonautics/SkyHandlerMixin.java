package com.ryorama.overhaulcraft.mixins.cosmonautics;

import com.ryorama.overhaulcraft.OverhaulCraft;
import dev.devce.rocketnautics.client.SkyHandler;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkyHandler.class)
public class SkyHandlerMixin {
    @Inject(at = @At("HEAD"), method = "ensureStarPlasmaTexture", cancellable = true)
    private static void ensureStarPlasmaTexture(CallbackInfo ci) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level != null) {
            long ticks = minecraft.level.getGameTime();
            int delay = OverhaulCraft.CONFIG.cosmonauticsPlasmaRendererDelayPerSeconds * 20;
            if (!(ticks % delay == 0)) {
                ci.cancel();
            }
        }
    }
}
