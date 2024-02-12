
package com.ryorama.tstpcontent.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

import com.ryorama.tstpcontent.init.TstpContentModItems;

public class MushroomTBlockBlock extends FlowerBlock {
	public MushroomTBlockBlock() {
		super(MobEffects.REGENERATION, 100,
				BlockBehaviour.Properties.of(Material.PLANT)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("tstp_content:grass")), () -> new SoundEvent(new ResourceLocation("block.grass.step")),
								() -> new SoundEvent(new ResourceLocation("tstp_content:grass")), () -> new SoundEvent(new ResourceLocation("tstp_content:grass")), () -> new SoundEvent(new ResourceLocation("tstp_content:grass"))))
						.instabreak().noCollission());
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(TstpContentModItems.MUSHROOM_T.get()));
	}
}
