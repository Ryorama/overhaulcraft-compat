/*
package com.ryorama.tstpcontent.client.render.entity.layers;

import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.github.alexmodguy.alexscaves.client.ClientProxy;
import com.github.alexmodguy.alexscaves.client.render.ACRenderTypes;
import com.github.alexmodguy.alexscaves.server.potion.ACEffectRegistry;
import com.github.alexmodguy.alexscaves.server.potion.DarknessIncarnateEffect;
import com.github.alexmodguy.alexscaves.server.potion.IrradiatedEffect;
import com.github.alexthe666.citadel.client.shader.PostEffectRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class ACPotionEffectLayerGeckoLib<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    private static final ResourceLocation TEXTURE_BUBBLE = new ResourceLocation("alexscaves:textures/entity/deep_one/bubble.png");
    private static final ResourceLocation TEXTURE_WATER = new ResourceLocation("textures/block/water_still.png");

    public ACPotionEffectLayerGeckoLib(GeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferIn, VertexConsumer buffer, float partialTicks, int packedLight, int packedOverlay) {
        //TstpContentMod.LOGGER.info("Running AC Potion Effect Layer Renderer for GeckoLib on entity" + animatable);
        if (animatable instanceof LivingEntity living) {
            if (living.hasEffect(ACEffectRegistry.IRRADIATED.get()) && AlexsCaves.CLIENT_CONFIG.radiationGlowEffect.get()) {
                PostEffectRegistry.renderEffectForNextTick(ClientProxy.IRRADIATED_SHADER);
                int level = living.getEffect(ACEffectRegistry.IRRADIATED.get()).getAmplifier() + 1;
                VertexConsumer ivertexbuilder = bufferIn.getBuffer(level >= IrradiatedEffect.BLUE_LEVEL ? ACRenderTypes.getBlueRadiationGlow(getTextureResource(animatable)) : ACRenderTypes.getRadiationGlow(getTextureResource(animatable)));
                float alpha = level >= IrradiatedEffect.BLUE_LEVEL ? 0.9F : Math.min(level * 0.33F, 1F);
                poseStack.pushPose();
                this.getRenderer().postRender(poseStack, animatable, bakedModel, bufferIn, buffer,false, partialTicks, packedLight, renderer.getPackedOverlay(animatable, 0, partialTicks), 1, 1, 1, alpha);
                //this.getParentModel().renderToBuffer(poseStack, ivertexbuilder, packedLightIn, LivingEntityRenderer.getOverlayCoords((LivingEntity) entity, 0), 1, 1F, 1, alpha);
                poseStack.popPose();
            }
            if (living.hasEffect(ACEffectRegistry.BUBBLED.get()) && living.isAlive()) {
                float bodyYaw = Mth.rotLerp(partialTicks, living.yBodyRotO, living.yBodyRot);
                poseStack.pushPose();
                float size = (float) Math.ceil(Math.max(living.getBbHeight(), living.getBbWidth()));
                poseStack.translate(0, 1.4 - size * 0.5F, 0);
                poseStack.mulPose(Axis.YP.rotationDegrees(180 - bodyYaw));
                poseStack.scale(1.1F, 1.1F, 1.1F);
                //float waterAnimOffset = (float) (Math.round(ageInTicks * 0.4)) % 16.0F;
                float waterAnimOffset = (float) (Math.round(((LivingEntity) animatable).tickCount * 0.4)) % 16.0f;
                renderBubble(living, partialTicks, poseStack, bufferIn.getBuffer(ACRenderTypes.getBubbledCull(TEXTURE_WATER)), size - 0.1F, packedLight, size * 0.5F, size * 0.5F * 0.0625F, -0.0625F * waterAnimOffset, true);
                renderBubble(living, partialTicks, poseStack, bufferIn.getBuffer(ACRenderTypes.getBubbledNoCull(TEXTURE_BUBBLE)), size, packedLight, 1, 1, 0, false);
                poseStack.popPose();
            }
            if (living.hasEffect(ACEffectRegistry.DARKNESS_INCARNATE.get()) && AlexsCaves.CLIENT_CONFIG.radiationGlowEffect.get() && living.isAlive()) {
                VertexConsumer ivertexbuilder = bufferIn.getBuffer(ACRenderTypes.entityTranslucent(getTextureResource(animatable)));
                poseStack.pushPose();
                float alpha = DarknessIncarnateEffect.getIntensity(living, partialTicks, 25F);
                this.getRenderer().postRender(poseStack, animatable, bakedModel, bufferIn, buffer, false, partialTicks, 0, renderer.getPackedOverlay(animatable, 0, partialTicks), 0, 0, 0, alpha);
                //this.getParentModel().renderToBuffer(poseStack, ivertexbuilder, 0, LivingEntityRenderer.getOverlayCoords((LivingEntity) entity, 0), 0F, 0F, 0F, alpha);
                poseStack.popPose();
            }
        }
    }
    private static void renderBubble(LivingEntity entity, float partialTicks, PoseStack poseStack, VertexConsumer consumer, float size, int packedLight, float textureScaleXZ, float textureScaleY, float uvOffset, boolean water) {
        Matrix4f cubeAt = poseStack.last().pose();
        Matrix3f matrix3f = poseStack.last().normal();
        float cubeStart = size * -0.5F;
        float cubeEnd = size * 0.5F;
        renderCubeFace(entity, cubeAt, matrix3f, consumer, packedLight, cubeStart, cubeEnd, cubeStart, cubeEnd, cubeEnd, cubeEnd, cubeEnd, cubeEnd, textureScaleXZ, textureScaleY, uvOffset, water);
        renderCubeFace(entity, cubeAt, matrix3f, consumer, packedLight, cubeStart, cubeEnd, cubeEnd, cubeStart, cubeStart, cubeStart, cubeStart, cubeStart, textureScaleXZ, textureScaleY, uvOffset, water);
        renderCubeFace(entity, cubeAt, matrix3f, consumer, packedLight, cubeEnd, cubeEnd, cubeEnd, cubeStart, cubeStart, cubeEnd, cubeEnd, cubeStart, textureScaleXZ, textureScaleY, uvOffset, water);
        renderCubeFace(entity, cubeAt, matrix3f, consumer, packedLight, cubeStart, cubeStart, cubeStart, cubeEnd, cubeStart, cubeEnd, cubeEnd, cubeStart, textureScaleXZ, textureScaleY, uvOffset, water);
        renderCubeFace(entity, cubeAt, matrix3f, consumer, packedLight, cubeStart, cubeEnd, cubeStart, cubeStart, cubeStart, cubeStart, cubeEnd, cubeEnd, textureScaleXZ, textureScaleY, uvOffset, water);
        renderCubeFace(entity, cubeAt, matrix3f, consumer, packedLight, cubeStart, cubeEnd, cubeEnd, cubeEnd, cubeEnd, cubeEnd, cubeStart, cubeStart, textureScaleXZ, textureScaleY, uvOffset, water);
    }

    private static void renderCubeFace(LivingEntity entity, Matrix4f matrix4f, Matrix3f matrix3f, VertexConsumer vertexConsumer, int packedLightIn, float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float textureScaleXZ, float textureScaleY, float uvOffset, boolean water) {
        int overlayCoords = OverlayTexture.NO_OVERLAY;
        int colorR = 255;
        int colorG = 255;
        int colorB = 255;
        int colorA = water ? 200 : 255;
        if (water) {
            int waterColorAt = entity.level().getBiome(entity.blockPosition()).get().getWaterColor();
            colorR = waterColorAt >> 16 & 255;
            colorG = waterColorAt >> 8 & 255;
            colorB = waterColorAt & 255;
        }
        vertexConsumer.vertex(matrix4f, f1, f3, f5).color(colorR, colorG, colorB, colorA).uv((float) 0, (float) textureScaleY + uvOffset).overlayCoords(overlayCoords).uv2(packedLightIn).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
        vertexConsumer.vertex(matrix4f, f2, f3, f6).color(colorR, colorG, colorB, colorA).uv((float) textureScaleXZ, (float) textureScaleY + uvOffset).overlayCoords(overlayCoords).uv2(packedLightIn).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
        vertexConsumer.vertex(matrix4f, f2, f4, f7).color(colorR, colorG, colorB, colorA).uv((float) textureScaleXZ, (float) uvOffset).overlayCoords(overlayCoords).uv2(packedLightIn).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
        vertexConsumer.vertex(matrix4f, f1, f4, f8).color(colorR, colorG, colorB, colorA).uv((float) 0, (float) uvOffset).overlayCoords(overlayCoords).uv2(packedLightIn).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
    }
}
 */