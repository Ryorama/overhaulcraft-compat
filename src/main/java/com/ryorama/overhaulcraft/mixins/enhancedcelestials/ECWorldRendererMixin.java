//package com.ryorama.overhaulcraft.mixins.enhancedcelestials;
//
//import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
//import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
//import com.llamalad7.mixinextras.sugar.Local;
//
//import dev.corgitaco.enhancedcelestials2core.client.ECWorldRenderer;
//import net.minecraft.client.multiplayer.ClientLevel;
//import org.mesdag.confluence_dimension_patch.common.OtherWorld;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//
//@Mixin(ECWorldRenderer.class)
//public class ECWorldRendererMixin {
//    @WrapOperation(at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderColor(FFFF)V"), method = "lambda$changeMoonColor$0")
//    private static void changeMoonColor(float red, float green, float blue, float alpha, Operation<Void> original, @Local ClientLevel level) {
//        if (level.dimension().equals(OtherWorld.LEVEL)) {
//            original.call(1f, 1f, 1f, 1f);
//        } else {
//            original.call(red, green, blue, alpha);
//        }
//    }
//}
