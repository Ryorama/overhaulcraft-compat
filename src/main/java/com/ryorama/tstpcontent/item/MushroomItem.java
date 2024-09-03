
package com.ryorama.tstpcontent.item;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class MushroomItem extends Item {
	public MushroomItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player entity, InteractionHand hand) {
		if (!level.isClientSide()) {
			level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:eat")), SoundSource.PLAYERS, 1, 1);
		} else {
			level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:eat")), SoundSource.PLAYERS, 1, 1, false);
		}

		entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 2, false, false));
		entity.getItemInHand(hand).shrink(1);

		return InteractionResultHolder.pass(entity.getItemInHand(hand));
	}
}
