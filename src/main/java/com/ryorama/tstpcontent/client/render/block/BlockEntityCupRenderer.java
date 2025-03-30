package com.ryorama.tstpcontent.client.render.block;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.ryorama.tstpcontent.blockentity.furniture.BlockEntityCup;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.lwjgl.opengl.GL11;

public class BlockEntityCupRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {

    public BlockEntityCupRenderer(final BlockEntityRendererProvider.Context context) {
        super();
    }

    @Override
    public void render(T blockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        BlockEntityCup blockEntityCup = (BlockEntityCup) blockEntity;
        if(blockEntityCup.getDrink() != null)
        {
            poseStack.pushPose();

            float x = 0;
            float y = 0;
            float z = 0;
            GL11.glTranslatef(x + 0.5F, y,z + 0.5F);

            GlStateManager._enableBlend();
            GlStateManager.glBlendFuncSeparate(770, 771, 1, 0);
            GL11.glColor4f(blockEntityCup.red / 255F, blockEntityCup.green / 255F, blockEntityCup.blue / 255F, 1.0F);

            renderCuboid(-0.124F, 0.5F * 0.0625F, -0.124F, 0.124F, 0.4F, 0.124F);

            GlStateManager._disableBlend();
            poseStack.popPose();
        }

        /*
         if(blockEntityCup.getDrink() != null)
        {
            poseStack.pushPose();
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y, (float) z + 0.5F);

                GlStateManager.enableBlend();
                OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                GlStateManager.disableLighting();
                GlStateManager.disableTexture2D();
                GlStateManager.color(tileEntityCup.red / 255F, tileEntityCup.green / 255F, tileEntityCup.blue / 255F, 1.0F);
                GlStateManager.enableRescaleNormal();

                renderCuboid(-0.124F, 0.5F * 0.0625F, -0.124F, 0.124F, 0.4F, 0.124F);

                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
                GlStateManager.enableLighting();
                GlStateManager.enableTexture2D();
            }
            GlStateManager.popMatrix();
        }
         */
    }

    public void renderCuboid(float x1, float y1, float z1, float x2, float y2, float z2)
    {
        GL11.glBegin(GL11.GL_QUADS);
        {
            GL11.glVertex3f(x1, y1, z1);
            GL11.glVertex3f(x1, y1, z2);
            GL11.glVertex3f(x1, y2, z2);
            GL11.glVertex3f(x1, y2, z1);

            GL11.glVertex3f(x2, y1, z1);
            GL11.glVertex3f(x1, y1, z1);
            GL11.glVertex3f(x1, y2, z1);
            GL11.glVertex3f(x2, y2, z1);

            GL11.glVertex3f(x1, y1, z2);
            GL11.glVertex3f(x2, y1, z2);
            GL11.glVertex3f(x2, y2, z2);
            GL11.glVertex3f(x1, y2, z2);

            GL11.glVertex3f(x2, y1, z2);
            GL11.glVertex3f(x2, y1, z1);
            GL11.glVertex3f(x2, y2, z1);
            GL11.glVertex3f(x2, y2, z2);

            GL11.glVertex3f(x1, y2, z1);
            GL11.glVertex3f(x1, y2, z2);
            GL11.glVertex3f(x2, y2, z2);
            GL11.glVertex3f(x2, y2, z1);

            GL11.glVertex3f(x1, y1, z1);
            GL11.glVertex3f(x1, y1, z2);
            GL11.glVertex3f(x2, y1, z2);
            GL11.glVertex3f(x2, y1, z1);
        }
        GL11.glEnd();
    }
}