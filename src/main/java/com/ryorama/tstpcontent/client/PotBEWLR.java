package com.ryorama.tstpcontent.client;

import com.google.common.base.Suppliers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.ryorama.tstpcontent.init.TstpContentModItems;
import com.ryorama.tstpcontent.item.cuisinedelight.DarkPotItem;
import dev.xkmc.cuisinedelight.content.logic.CookingData;
import dev.xkmc.cuisinedelight.init.CuisineDelightClient;
import dev.xkmc.l2library.util.Proxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Supplier;

public class PotBEWLR extends BlockEntityWithoutLevelRenderer {

    public static final Supplier<BlockEntityWithoutLevelRenderer> INSTANCE = Suppliers.memoize(() ->
            new PotBEWLR(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels()));

    public static final IClientItemExtensions EXTENSIONS = new IClientItemExtensions() {

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return INSTANCE.get();
        }

    };

    public PotBEWLR(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
    }

    public void onResourceManagerReload(ResourceManager p_172555_) {
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext type, PoseStack poseStack,
                             MultiBufferSource bufferSource, int light, int overlay) {
        if (stack.isEmpty() || stack.getItem() != TstpContentModItems.DARK_POT.get()) return;
        poseStack.popPose();
        poseStack.pushPose();
        ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();
        int i = 0;
        BakedModel model = Minecraft.getInstance().getModelManager().getModel(CuisineDelightClient.SKILLET_MODEL);
        renderer.render(stack, type, false, poseStack, bufferSource, light, overlay, model);
        CookingData data = DarkPotItem.getData(stack);
        if (data != null && !data.contents.isEmpty()) {
            data.update(Proxy.getClientWorld().getGameTime());
            poseStack.pushPose();
            model.applyTransform(type, poseStack, false);
            float time = 0;
            LocalPlayer player = Proxy.getClientPlayer();
            if (player.getMainHandItem() == stack || player.getOffhandItem() == stack) {
                time = player.getCooldowns().getCooldownPercent(stack.getItem(), Minecraft.getInstance().getPartialTick());
            }
            DarkPotRenderer.renderItem(time, data, poseStack, bufferSource, light, overlay);
            poseStack.popPose();
        }
    }

}