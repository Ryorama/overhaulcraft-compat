package com.ryorama.tstpcontent.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ryorama.tstpcontent.entity.tile.HamsterWheelGeneratorBlockEntity;
import com.ryorama.tstpcontent.client.model.HamsterWheelGeneratorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import javax.annotation.Nullable;

public class HamsterWheelGeneratorRenderer extends GeoBlockRenderer<HamsterWheelGeneratorBlockEntity> {
    public HamsterWheelGeneratorRenderer(BlockEntityRendererProvider.Context context) {
        super(context, new HamsterWheelGeneratorModel());
    }

    @Override
    public RenderType getRenderType(HamsterWheelGeneratorBlockEntity animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}