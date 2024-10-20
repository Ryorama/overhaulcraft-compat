
package com.ryorama.tstpcontent.block;

import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GrassBlockBlock extends Block {
	public GrassBlockBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tstp_content:dig0"))))
				.strength(1f, 3f).randomTicks());
	}

	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
		if (!worldIn.isClientSide()) {

			if (!worldIn.isAreaLoaded(pos, 3)) return;
			BlockPos pos2 = pos.offset(0, 1, 0);
			if (!worldIn.isEmptyBlock(pos2)) {
				if (worldIn.getBlockState(pos2).isSolid() && worldIn.getBlockState(pos2).getBlock() instanceof AirBlock == false) {
					worldIn.setBlock(pos, TstpContentModBlocks.DIRT_BLOCK.get().defaultBlockState(), 0);
					return;
				}
				if (worldIn.getBlockState(pos2).getBlock().defaultBlockState() == Blocks.AIR.defaultBlockState()) {
					if (random.nextInt(100 * 10) <= 2) {
						worldIn.setBlock(pos2, TstpContentModBlocks.GRASS.get().defaultBlockState(), 0);
						if (random.nextInt(15) == 0) {
							worldIn.setBlock(pos2, TstpContentModBlocks.MUSHROOM_PLANT.get().defaultBlockState(), 0);
						}
					}
				}
			}
			for (int i = 0; i < 4; ++i) {
				BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
				if (blockpos.getY() == pos.getY() - 1) {
					return;
				}
				if (worldIn.isEmptyBlock(blockpos)) return;
				if (worldIn.getBlockState(blockpos.above()).getBlock() == Blocks.AIR)
					if (worldIn.getBlockState(blockpos).getBlock() == TstpContentModBlocks.DIRT_BLOCK.get()) {
						worldIn.setBlock(blockpos, this.defaultBlockState(), 0);
					}
			}
		}
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}
}
