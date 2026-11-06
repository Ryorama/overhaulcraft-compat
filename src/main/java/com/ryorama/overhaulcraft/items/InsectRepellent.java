package com.ryorama.overhaulcraft.items;

import com.github.alexthe666.alexsmobs.effect.AMEffectRegistry;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class InsectRepellent extends Item {
    public InsectRepellent(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.overhaulcraft.insect_repellent"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (ExtraFunc.isModInstalled("alexsmobs")) player.addEffect(new MobEffectInstance(AMEffectRegistry.MOSQUITO_REPELLENT, 6000));
        if (!player.isCreative()) {
            player.getItemInHand(usedHand).shrink(1);
        }
        return InteractionResultHolder.pass(player.getItemInHand(usedHand));
    }
}