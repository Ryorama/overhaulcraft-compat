package com.ryorama.tstpcontent.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.block.furniture.BlockCookieJar;
import com.ryorama.tstpcontent.blockentity.furniture.BlockEntityCookieJar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BlockEntityCookieJarRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {

    public BlockEntityCookieJarRenderer(final BlockEntityRendererProvider.Context context) {
        super();
    }

    private ItemStack cookie = new ItemStack(Items.COOKIE);
    private ItemEntity entityItem;

    public void render(T blockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        BlockEntityCookieJar blockEntityCookieJar = (BlockEntityCookieJar) blockEntity;
        poseStack.pushPose();
        //GL11.glPushMatrix();
        //GL11.glDisable(GL11.GL_LIGHTING);

        float x = 0;
        float y = 0;
        float z = 0;
        poseStack.translate(x + 0.5F,y + 0.05F,z + 0.18F);
        poseStack.last().normal().rotateLocal(180, 0, 1, 1);
        poseStack.translate(0, -0.1, 0);
        poseStack.scale(0.9F, 0.9F, 0.9F);

        int metadata = blockEntityCookieJar.getBlockState().getValue(BlockCookieJar.COOKIE_COUNT);
        for(int c = 0; c < metadata; c++)
        {
            if (blockEntity.hasLevel()) {
                TstpContentMod.LOGGER.info("Render Cookie in Jar");
                entityItem = new ItemEntity(blockEntity.getLevel(), 0D, 0D, 0D, cookie);
                Minecraft.getInstance().getEntityRenderDispatcher().render(entityItem, 0.0D, 0.0D, 0.1D * c, 0.0F, 0.0F, poseStack, multiBufferSource, 0);
            }
        }

        //GL11.glEnable(GL11.GL_LIGHTING);
        //GL11.glPopMatrix();
        poseStack.popPose();
    }
}