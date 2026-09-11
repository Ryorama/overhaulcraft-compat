package com.ryorama.overhaulcraft.items;

import net.conczin.mca.network.Network;
import net.conczin.mca.network.s2c.OpenGuiRequest;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class CustomizationGlobe extends Item {
    public CustomizationGlobe() {
        super(new Properties().stacksTo(1).fireResistant());
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!player.level().isClientSide()) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            Network.sendToPlayer(new OpenGuiRequest(OpenGuiRequest.Type.VILLAGER_EDITOR, serverPlayer), serverPlayer);
            if (!player.isCreative()) player.getItemInHand(usedHand).shrink(1);
        }
        return InteractionResultHolder.pass(player.getItemInHand(usedHand));
    }

    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.overhaulcraft.item.customization_globe.1"));
        tooltipComponents.add(Component.translatable("tooltip.overhaulcraft.item.customization_globe.2"));
    }
}
