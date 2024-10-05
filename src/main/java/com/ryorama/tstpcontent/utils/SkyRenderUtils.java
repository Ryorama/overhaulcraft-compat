package com.ryorama.tstpcontent.utils;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexFormat;
import dev.architectury.event.events.client.ClientReloadShadersEvent;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.cerulan.blockofsky.BlockOfSkyMod;
import net.cerulan.blockofsky.client.LevelRendererBOS;
import net.cerulan.blockofsky.client.SkyBlockEntityRenderer;
import net.minecraft.client.Camera;
import net.minecraft.client.CloudStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import java.io.IOException;

public class SkyRenderUtils {
    private static ShaderInstance skyShaderOverworld;
    private static int skyWidthOverworld = -1;
    private static int skyHeightOverworld = -1;
    private static TextureTarget skyRenderTargetOverworld;
    public static boolean updateSkyOverworld = false;
    private static boolean isRenderingSkyOverworld = false;
    public static final RenderType SKY_RENDER_TYPE_OVERWORLD;

    public static void init() {
        BlockEntityRendererRegistry.register(BlockOfSkyMod.SKY_BE_TYPE.get(), SkyBlockEntityRenderer::new);
        ClientReloadShadersEvent.EVENT.register((resource, uwu) -> {
            try {
                uwu.registerShader(new ShaderInstance(resource, "blockofsky_sky_overworld", DefaultVertexFormat.POSITION), SkyRenderUtils::setSkyShaderOverworld);
            } catch (IOException var3) {
                IOException ex = var3;
                System.err.println("Failed to load shader");
                ex.printStackTrace();
            }

        });
    }
    public static ShaderInstance getSkyShaderOverworld() {
        return skyShaderOverworld;
    }


    public static void setSkyShaderOverworld(ShaderInstance shader) {
        skyShaderOverworld = shader;
    }

    private static void setSkyTextureOverworld() {
        if (skyRenderTargetOverworld != null) {
            RenderSystem.setShaderTexture(0, skyRenderTargetOverworld.getColorTextureId());
        } else {
            RenderSystem.setShaderTexture(0, 0);
        }

    }

    public static void renderSkyOverworld(SkyRenderUtils.RenderData renderData) {
        if (!isRenderingSkyOverworld) {
            Minecraft mc = Minecraft.getInstance();
            Window window = mc.getWindow();
            int ww = window.getWidth();
            int wh = window.getHeight();
            if (ww > 0 && wh > 0) {
                boolean update = false;
                if (skyRenderTargetOverworld == null || skyWidthOverworld != ww || skyHeightOverworld != wh) {
                    update = true;
                    skyWidthOverworld = ww;
                    skyHeightOverworld = wh;
                }

                if (update) {
                    if (skyRenderTargetOverworld != null) {
                        skyRenderTargetOverworld.destroyBuffers();
                    }

                    skyRenderTargetOverworld = new TextureTarget(skyWidthOverworld, skyHeightOverworld, true, Minecraft.ON_OSX);
                }

                mc.gameRenderer.setRenderBlockOutline(false);
                mc.levelRenderer.graphicsChanged();
                skyRenderTargetOverworld.bindWrite(true);
                isRenderingSkyOverworld = true;
                RenderTarget mainRenderTarget = mc.getMainRenderTarget();
                renderActualSkyOverworld(mc, renderData);
                isRenderingSkyOverworld = false;
                mc.gameRenderer.setRenderBlockOutline(true);
                skyRenderTargetOverworld.unbindRead();
                skyRenderTargetOverworld.unbindWrite();
                mc.levelRenderer.graphicsChanged();
                mainRenderTarget.bindWrite(true);
            }
        }
    }

    public static void renderActualSkyOverworld(Minecraft mc, SkyRenderUtils.RenderData renderData) {
        if (mc != null && mc.level != null && mc.player != null) {
            PoseStack poseStack = renderData.poseStack();
            float delta = renderData.partialTick();
            Matrix4f projectionMatrix = renderData.projectionMatrix();
            LevelRenderer levelRenderer = mc.levelRenderer;
            LevelRendererBOS levelRendererBOS = (LevelRendererBOS)levelRenderer;
            GameRenderer gameRenderer = mc.gameRenderer;
            Camera camera = gameRenderer.getMainCamera();
            Vec3 cameraPos = camera.getPosition();
            LightTexture lightTexture = gameRenderer.lightTexture();
            FogRenderer.setupColor(camera, delta, mc.level, mc.options.getEffectiveRenderDistance(), gameRenderer.getDarkenWorldAmount(delta));
            FogRenderer.levelFogColor();
            RenderSystem.clear(16640, Minecraft.ON_OSX);
            float renderDistance = gameRenderer.getRenderDistance();
            FogRenderer.setupFog(camera, FogRenderer.FogMode.FOG_SKY, renderDistance, false, delta);
            RenderSystem.setShader(GameRenderer::getPositionShader);
            levelRenderer.renderSky(poseStack, projectionMatrix, delta, camera, false, () -> {
                FogRenderer.setupFog(camera, FogRenderer.FogMode.FOG_SKY, renderDistance, false, delta);
            });
            PoseStack modelViewStack = RenderSystem.getModelViewStack();
            modelViewStack.pushPose();
            modelViewStack.mulPoseMatrix(poseStack.last().pose());
            RenderSystem.applyModelViewMatrix();
            if (mc.options.getCloudsType() != CloudStatus.OFF) {
                RenderSystem.setShader(GameRenderer::getPositionTexColorNormalShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                levelRenderer.renderClouds(poseStack, projectionMatrix, delta, cameraPos.x, cameraPos.y, cameraPos.z);
            }

            RenderSystem.depthMask(false);
            levelRendererBOS.BOS$renderSnowAndRain(lightTexture, delta, cameraPos.x, cameraPos.y, cameraPos.z);
            RenderSystem.depthMask(true);
            RenderSystem.disableBlend();
            modelViewStack.popPose();
            RenderSystem.applyModelViewMatrix();
            FogRenderer.setupNoFog();
        }
    }

    static {
        SKY_RENDER_TYPE_OVERWORLD = RenderType.create("blockofsky_sky_overworld", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setShaderState(new RenderStateShard.ShaderStateShard(SkyRenderUtils::getSkyShaderOverworld)).setTextureState(new RenderStateShard.EmptyTextureStateShard(SkyRenderUtils::setSkyTextureOverworld, () -> {
        })).createCompositeState(false));
    }

    public record RenderData(PoseStack poseStack, float partialTick, Matrix4f projectionMatrix) {
        public RenderData(PoseStack poseStack, float partialTick, Matrix4f projectionMatrix) {
            this.poseStack = poseStack;
            this.partialTick = partialTick;
            this.projectionMatrix = projectionMatrix;
        }

        public PoseStack poseStack() {
            return this.poseStack;
        }

        public float partialTick() {
            return this.partialTick;
        }

        public Matrix4f projectionMatrix() {
            return this.projectionMatrix;
        }
    }
}
