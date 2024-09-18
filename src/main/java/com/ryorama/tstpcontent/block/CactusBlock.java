
package com.ryorama.tstpcontent.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class CactusBlock extends Block {
	public CactusBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0"))))
				.strength(1f, 10f));
	}
}
