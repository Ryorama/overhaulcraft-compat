package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ChunkGenerator.class)
public class ChunkGeneratorMixin {
    @Inject(at = @At("TAIL"), method = "applyBiomeDecoration")
    public void applyBiomeDecoration(WorldGenLevel worldGenLevel, ChunkAccess chunkAccess, StructureManager structureManager, CallbackInfo ci) {
        if (worldGenLevel.getLevel().dimension().location().equals(new ResourceLocation("tstp_content:terraria_dim"))) {
            ChunkPos chunkPos = chunkAccess.getPos();
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
            Random rand = new Random();

            for (int x = chunkPos.getMinBlockX(); x <= chunkPos.getMaxBlockX(); x++) {
                for (int z = chunkPos.getMinBlockZ(); z <= chunkPos.getMaxBlockZ(); z++) {
                    for (int y = worldGenLevel.getMinBuildHeight(); y <= worldGenLevel.getMaxBuildHeight(); y++) {
                        pos.set(x, y, z);
                        if (worldGenLevel.getLevel().hasChunkAt(pos)) {
                            if (y <= 20) {
                                if (worldGenLevel.getBlockState(pos) == TstpContentModBlocks.STONE.get().defaultBlockState() && !worldGenLevel.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isSolid()) {
                                    if (rand.nextInt(2500) == 0) {
                                        worldGenLevel.setBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), TstpContentModBlocks.LIFE_CRYSTAL_BLOCK.get().defaultBlockState(), 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
