package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import weather2.config.ConfigParticle;

@IfModLoaded("weather2")
@Mixin(LevelRenderer.class)
public class LevelRendererMixin {
    @WrapOperation(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;renderSnowAndRain(Lnet/minecraft/client/renderer/LightTexture;FDDD)V"))
    public void renderSnowAndRain(LevelRenderer instance, LightTexture lightTexture, float partialTick, double camX, double camY, double camZ, Operation<Void> original) {
        if (ConfigParticle.Particle_vanilla_precipitation) {
            instance.renderSnowAndRain(lightTexture, partialTick, camX, camY, camZ);
        }
    }
}