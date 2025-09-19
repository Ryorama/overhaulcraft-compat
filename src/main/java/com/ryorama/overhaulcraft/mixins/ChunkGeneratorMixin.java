package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import com.ryorama.overhaulcraft.utils.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.confluence.mod.common.init.ModBiomes;
import org.confluence.mod.common.init.block.NatureBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@IfModLoaded("confluence_dimension_patch")
@Mixin(ChunkGenerator.class)
public class ChunkGeneratorMixin {
    public FastNoise noise;

    @Inject(at = @At("TAIL"), method = "applyBiomeDecoration")
    public void applyBiomeDecoration(WorldGenLevel worldGenLevel, ChunkAccess chunkAccess, StructureManager structureManager, CallbackInfo ci, @Local ChunkPos chunkpos) {
        if (worldGenLevel != null) {
            if (worldGenLevel.getLevel() != null) {
                Level level = worldGenLevel.getLevel();
                if (level.dimensionTypeRegistration().is(ResourceLocation.fromNamespaceAndPath("confluence_dimension_patch", "otherworld"))) {
                    if (noise == null) {
                        noise = new FastNoise((int) worldGenLevel.getSeed());
                    }
                    float threshold = -0.8f;
                    int underworld_height = -65;
                    int underworld_base = -128 + 15;

                    for (int x = chunkpos.getMinBlockX(); x <= chunkpos.getMaxBlockX(); x++) {
                        for (int z = chunkpos.getMinBlockZ(); z <= chunkpos.getMaxBlockZ(); z++) {
                            for (int y = worldGenLevel.getMinBuildHeight(); y <= worldGenLevel.getMaxBuildHeight(); y++) {
                                BlockPos blockPos = new BlockPos(x, y, z);
                                BlockState state = null;
                                if (worldGenLevel.isAreaLoaded(blockPos, 16)) {
                                    float n = GetTerrainNoise(x, y, z);

                                    float underworld_density = (y - underworld_height) / 5.0f;
                                    float underworld_base_density = (y - underworld_base) / 15.0f;
                                    float combined_underworld = n + underworld_density;
                                    float combined_underworld_base = n + underworld_base_density;

                                    if (y <= underworld_height) {
                                        ExtraFunc.convertToBiome(level, blockPos, ModBiomes.ASH_WASTELAND.location(), 1);
                                    }

                                    if (y >= underworld_height + 20 && worldGenLevel.getBlockState(blockPos) == Blocks.WATER.defaultBlockState()) {
                                        state = Blocks.CAVE_AIR.defaultBlockState();
                                    }

                                    if (combined_underworld < threshold) {
                                        state = Blocks.CAVE_AIR.defaultBlockState();
                                    }

                                    if (y < underworld_base) {
                                        state = Blocks.LAVA.defaultBlockState();
                                    }

                                    if (combined_underworld_base < threshold) {
                                        state = NatureBlocks.ASH_BLOCK.get().defaultBlockState();
                                    }

                                    if (y <= -128) {
                                        state = Blocks.BEDROCK.defaultBlockState();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private float GetTerrainNoise(int x, int y, int z) {
        return noise.GetSimplexFractal(x * 1.25f, y * 2.0f, z * 1.25f) * 5;
    }
}