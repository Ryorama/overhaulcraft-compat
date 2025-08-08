package com.ryorama.tstpcontent.client.render.entity;

import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.github.alexmodguy.alexscaves.client.ClientProxy;
import com.github.alexmodguy.alexscaves.client.render.ACRenderTypes;
import com.github.alexthe666.citadel.client.shader.PostEffectRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.ryorama.tstpcontent.client.model.entity.RadsterEntityModel;
import com.ryorama.tstpcontent.client.render.entity.layers.RadsterCollarLayer;
import com.ryorama.tstpcontent.entities.RadsterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class RadsterEntityRenderer extends GeoEntityRenderer<RadsterEntity> {
    private final EntityRendererProvider.Context context;

    public RadsterEntityRenderer(EntityRendererProvider.Context context) {

        super(context, new RadsterEntityModel());
        this.shadowRadius = 0.3F;
        this.context = context;
        this.addRenderLayer(new RadsterCollarLayer(this));
    }

    @Override
    public float getMotionAnimThreshold(RadsterEntity animatable) {
        return 0.001F;
    }

    @Override
    public RenderType getRenderType(RadsterEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        if (AlexsCaves.CLIENT_CONFIG.radiationGlowEffect.get()) {
            ACRenderTypes.getRadiationGlow(getTextureLocation(animatable));
        }
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void render(RadsterEntity hamster, float yaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        if (AlexsCaves.CLIENT_CONFIG.radiationGlowEffect.get()) {
            PostEffectRegistry.renderEffectForNextTick(ClientProxy.IRRADIATED_SHADER);
        }

        float adultScale = 1.0F;
        float babyScale = 0.6F;

        if (hamster.isBaby()) poseStack.scale(babyScale, babyScale, babyScale);
        else poseStack.scale(adultScale, adultScale, adultScale);

        super.render(hamster, yaw, partialTick, poseStack, bufferSource, packedLight);
    }
}