package com.ryorama.tstpcontent.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.ryorama.tstpcontent.block.cuisine_delight.entity.DarkPotBlockEntity;
import dev.xkmc.cuisinedelight.content.client.FluidRenderHelper;
import dev.xkmc.cuisinedelight.content.logic.CookTransformConfig;
import dev.xkmc.cuisinedelight.content.logic.CookingData;
import dev.xkmc.cuisinedelight.content.logic.IngredientConfig;
import dev.xkmc.cuisinedelight.content.logic.transform.FluidTransform;
import dev.xkmc.cuisinedelight.content.logic.transform.Stage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class DarkPotRenderer implements BlockEntityRenderer<DarkPotBlockEntity> {
    public static void renderItem(float time, CookingData data, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();
        int i = 1;
        float fly = time * (1 - time) * 4;
        FluidRenderHelper helper = new FluidRenderHelper();
        poseStack.pushPose();
        poseStack.translate(0, -29 / 64f + fly * 16 / 32f, 0);
        for (var entry : data.contents) {
            ItemStack food = entry.getItem();
            var handle = CookTransformConfig.get(food);
            if (handle instanceof FluidTransform fluid) {
                helper.addFluid(fluid);
                continue;
            }
            ItemStack render = handle.renderStack(entry.getStage(data), food);

            Random random = new Random(entry.seed());
            poseStack.translate(0, (fly * 4 + 1) / 32f, 0);
            poseStack.pushPose();
            poseStack.mulPose(Axis.YP.rotationDegrees(random.nextFloat() * 360f));
            poseStack.mulPose(Axis.ZP.rotationDegrees(time * 360));
            poseStack.mulPose(Axis.YP.rotationDegrees(random.nextFloat() * 360f));
            poseStack.mulPose(Axis.XP.rotationDegrees(90));
            int itemLight = light;
            var config = IngredientConfig.get().getEntry(food);
            assert config != null;
            boolean overcooked = entry.getStage(data) == Stage.OVERCOOKED;
            boolean burnt = entry.getMaxStirTime(data) > config.stir_time;
            itemLight = handle.lightAdjust(itemLight, overcooked, burnt);
            renderer.renderStatic(render, ItemDisplayContext.GROUND, itemLight,
                    overlay, poseStack, buffer, Minecraft.getInstance().level, i++);
            poseStack.popPose();
        }
        poseStack.popPose();
        helper.render(poseStack, buffer, light);
    }

    @Override
    public void render(DarkPotBlockEntity darkPotBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {

    }
}
