
package com.ryorama.tstpcontent.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.ForgeRegistries;

public class MushroomPlantBlock extends FlowerBlock {
	public MushroomPlantBlock() {
		super(() -> MobEffects.HEAL, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:grass")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.step")),
				() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:grass")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:grass")),
				() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:grass")))).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
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
}
