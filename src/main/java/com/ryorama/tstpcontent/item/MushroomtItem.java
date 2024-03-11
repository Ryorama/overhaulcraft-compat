
package com.ryorama.tstpcontent.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class MushroomtItem extends Item {
	public MushroomtItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f)
				.build()));
	}

	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if (!world.isClientSide()) {
			world.playSound(null, player.blockPosition(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:eat")), SoundSource.PLAYERS, 1, 1);
		} else {
			world.playLocalSound(player.getX(), player.getY(), player.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:eat")), SoundSource.PLAYERS, 1, 1, false);
		}
		player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 2, false, false));
		stack.shrink(1);

		return InteractionResultHolder.pass(stack);
	}
}