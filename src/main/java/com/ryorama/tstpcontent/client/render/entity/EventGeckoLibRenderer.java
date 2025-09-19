package com.ryorama.tstpcontent.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.eventbus.api.Event;
import software.bernie.geckolib.model.GeoModel;

public class EventGeckoLibRenderer extends Event {
    private Entity entity;
    private GeoModel model;
    private PoseStack poseStack;
    private float partialTicks;

    public EventGeckoLibRenderer(Entity entity, GeoModel model, PoseStack poseStack, float partialTicks) {
        this.entity = entity;
        this.model = model;
        this.poseStack = poseStack;
        this.partialTicks = partialTicks;
    }

    public Entity getEntity() {
        return entity;
    }

    public GeoModel getModel() {
        return model;
    }

    public PoseStack getPoseStack() {
        return poseStack;
    }

    public float getPartialTicks() {
        return partialTicks;
    }

    public static class SetupRotations extends EventGeckoLibRenderer {
        private float bodyYRot;

        public SetupRotations(Entity entity, GeoModel model, PoseStack poseStack, float bodyYRot, float partialTicks) {
            super(entity, model, poseStack, partialTicks);
            this.bodyYRot = bodyYRot;
        }

        public float getBodyYRot() {
            return bodyYRot;
        }
    }

    public static class AccessToBufferSource extends EventGeckoLibRenderer {
        private float bodyYRot;
        private MultiBufferSource bufferSource;
        private int packedLight;

        public AccessToBufferSource(Entity entity, GeoModel model, PoseStack poseStack, float bodyYRot, float partialTicks, MultiBufferSource bufferSource, int packedLight) {
            super(entity, model, poseStack, partialTicks);
            this.bodyYRot = bodyYRot;
            this.bufferSource = bufferSource;
            this.packedLight = packedLight;
        }

        public float getBodyYRot() {
            return bodyYRot;
        }

        public MultiBufferSource getBufferSource() {
            return bufferSource;
        }

        public int getPackedLight() {
            return packedLight;
        }
    }

    public static class PreSetupAnimations extends AccessToBufferSource {

        public PreSetupAnimations(Entity entity, GeoModel model, PoseStack poseStack, float bodyYRot, float partialTicks, MultiBufferSource bufferSource, int packedLight) {
            super(entity, model, poseStack, bodyYRot, partialTicks, bufferSource, packedLight);
        }
    }

    public static class PostSetupAnimations extends AccessToBufferSource {

        public PostSetupAnimations(Entity entity, GeoModel model, PoseStack poseStack, float bodyYRot, float partialTicks, MultiBufferSource bufferSource, int packedLight) {
            super(entity, model, poseStack, bodyYRot, partialTicks, bufferSource, packedLight);
        }
    }

    public static class PostRenderModel extends AccessToBufferSource {

        public PostRenderModel(Entity entity, GeoModel model, PoseStack poseStack, float bodyYRot, float partialTicks, MultiBufferSource bufferSource, int packedLight) {
            super(entity, model, poseStack, bodyYRot, partialTicks, bufferSource, packedLight);
        }
    }
}