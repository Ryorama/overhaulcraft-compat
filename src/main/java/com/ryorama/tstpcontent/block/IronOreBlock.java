
package com.ryorama.tstpcontent.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class IronOreBlock extends Block {
	public IronOreBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:tink1")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:tink0")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:tink0")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:tink0"))))
				.strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
