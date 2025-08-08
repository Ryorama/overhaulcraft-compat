package com.ryorama.tstpcontent.mixins.geckolib;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.client.render.entity.layers.ACPotionEffectLayerGeckoLib;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

@Mixin(GeoEntityRenderer.class)
public abstract class GeoEntityRendererMixin<T extends Entity & GeoAnimatable> extends EntityRenderer<T> implements GeoRenderer<T> {
    @Shadow(remap = false) public abstract GeoEntityRenderer<T> addRenderLayer(GeoRenderLayer<T> renderLayer);

    @Shadow(remap = false) protected T animatable;

    protected GeoEntityRendererMixin(EntityRendererProvider.Context arg) {
        super(arg);
    }

    @Inject(at = @At("TAIL"), method = "<init>", remap = false)
    public void init(EntityRendererProvider.Context renderManager, GeoModel model, CallbackInfo ci) {
        //TstpContentMod.LOGGER.info("Register AC Potion Affect Layer for GeckoLib on entity: " + this.animatable);
        this.addRenderLayer(new ACPotionEffectLayerGeckoLib<>(this));
    }
}
