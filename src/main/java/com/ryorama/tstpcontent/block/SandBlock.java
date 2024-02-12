
package com.ryorama.tstpcontent.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class SandBlock extends FallingBlock {
	public SandBlock() {
		super(BlockBehaviour.Properties.of(Material.SAND).sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("tstp_content:dig0")), () -> new SoundEvent(new ResourceLocation("block.sand.step")),
				() -> new SoundEvent(new ResourceLocation("tstp_content:dig0")), () -> new SoundEvent(new ResourceLocation("tstp_content:dig0")), () -> new SoundEvent(new ResourceLocation("tstp_content:dig0")))).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
