package com.ryorama.tstpcontent.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.client.model.NuclearExplosionEffectModel;
import com.ryorama.tstpcontent.entity.particle.NuclearExplosionEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import team.lodestar.lodestone.handlers.RenderHandler;
import team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry;
import team.lodestar.lodestone.systems.rendering.VFXBuilders;

public class NuclearExplosionEffectRenderer extends MobRenderer<NuclearExplosionEffect, NuclearExplosionEffectModel> {
    Lodestone

    public NuclearExplosionEffectRenderer(EntityRendererProvider.Context context) {
        super(context, new NuclearExplosionEffectModel(), 1);
    }

    @Override
    public void render(NuclearExplosionEffect nuclearExplosionEffect, float p_114486_, float p_114487_, PoseStack poseStack, MultiBufferSource multiBufferSource, int p_114490_) {
        super.render(nuclearExplosionEffect, p_114486_, p_114487_, poseStack, multiBufferSource, p_114490_);

        TstpContentMod.LOGGER.info("Render Sphere");
        VFXBuilders.WorldVFXBuilder worldVFXBuilder = VFXBuilders.createWorld();
        worldVFXBuilder.setPosTexDefaultFormat();
        worldVFXBuilder.renderSphere(multiBufferSource.getBuffer(LodestoneRenderTypeRegistry.ADDITIVE_TEXTURE_TRIANGLE.applyAndCache(new ResourceLocation(""))), poseStack, 100, 10, 10);

    }

    @Override
    public ResourceLocation getTextureLocation(NuclearExplosionEffect nuclearExplosionEffect) {
        return new ResourceLocation("");
    }
}
