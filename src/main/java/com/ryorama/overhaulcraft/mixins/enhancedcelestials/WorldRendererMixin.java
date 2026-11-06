package com.ryorama.overhaulcraft.mixins.enhancedcelestials;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.sugar.Local;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.resources.ResourceLocation;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@IfModLoaded("enhancedcelestials2core")
@Mixin(value = LevelRenderer.class, priority = 1500)
public class WorldRendererMixin {
    @TargetHandler(mixin = "dev.corgitaco.enhancedcelestials2core.mixin.client.WorldRendererMixin", name = "bindCustomMoonTexture")
    @Inject(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Ldev/corgitaco/enhancedcelestials2core/EnhancedCelestials;lunarForecastWorldData(Lnet/minecraft/world/level/Level;)Ljava/util/Optional;"), cancellable = true)
    private void bindCustomMoonTextureMod(int moonTextureId, ResourceLocation moonLocation, Operation<Void> original, CallbackInfo ci, @Local ClientLevel level) {
        if (level.dimension().equals(OtherWorld.LEVEL)) {
            original.call(moonTextureId, moonLocation);
            ci.cancel();
        }
    }

    @TargetHandler(mixin = "dev.corgitaco.enhancedcelestials2core.mixin.client.WorldRendererMixin", name = "getSuperMoonSize")
    @Inject(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Ldev/corgitaco/enhancedcelestials2core/EnhancedCelestials;lunarForecastWorldData(Lnet/minecraft/world/level/Level;)Ljava/util/Optional;"), cancellable = true)
    private void getSuperMoonSize(float original, CallbackInfoReturnable<Float> cir, @Local ClientLevel level) {
        if (level.dimension().equals(OtherWorld.LEVEL)) {
            cir.setReturnValue(original);
        }
    }
}
