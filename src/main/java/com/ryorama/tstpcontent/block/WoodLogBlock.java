
package com.ryorama.tstpcontent.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;

public class WoodLogBlock extends Block {
	public WoodLogBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0"))))
				.strength(1f, 10f));
	}
}
