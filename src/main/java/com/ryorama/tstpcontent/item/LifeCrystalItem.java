
package com.ryorama.tstpcontent.item;

import ichttt.mods.firstaid.common.damagesystem.PlayerDamageModel;
import ichttt.mods.firstaid.common.util.CommonUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class LifeCrystalItem extends Item {
	public LifeCrystalItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		if (!world.isClientSide()) {
			world.playSound(null, entity.blockPosition(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:health_crystal")), SoundSource.PLAYERS, 1, 1);
		} else {
			world.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:health_crystal")), SoundSource.PLAYERS, 1, 1, false);
		}

		if (entity.getAttribute(Attributes.MAX_HEALTH).getBaseValue() < 60) {
			entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((Player) entity).getAttribute(Attributes.MAX_HEALTH).getBaseValue() + 2);

			PlayerDamageModel playerDamageModel = (PlayerDamageModel) CommonUtils.getDamageModel(entity);
			playerDamageModel.runScaleLogic(entity);

			if (!entity.isCreative()) {
				entity.getItemInHand(hand).shrink(1);
			}
		}

		return InteractionResultHolder.success(entity.getItemInHand(hand));
	}
}
