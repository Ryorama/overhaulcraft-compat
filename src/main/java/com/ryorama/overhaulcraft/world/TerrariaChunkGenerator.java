package com.ryorama.overhaulcraft.world;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import com.ryorama.overhaulcraft.utils.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.confluence.mod.common.init.ModBiomes;
import org.confluence.mod.common.init.block.NatureBlocks;

public class TerrariaChunkGenerator extends NoiseBasedChunkGenerator {

    public static final MapCodec<NoiseBasedChunkGenerator> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(BiomeSource.CODEC.fieldOf("biome_source").forGetter((arg) -> arg.getBiomeSource()), NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter((arg) -> arg.generatorSettings())).apply(instance, instance.stable(TerrariaChunkGenerator::new)));
    public FastNoise noise;

    public TerrariaChunkGenerator(BiomeSource biomeSource, Holder<NoiseGeneratorSettings> noiseGeneratorSettingsHolder) {
        super(biomeSource, noiseGeneratorSettingsHolder);
    }

    @Override
    public void applyBiomeDecoration(WorldGenLevel worldGenLevel, ChunkAccess chunkAccess, StructureManager structureManager) {
        /*
        ChunkPos chunkpos = chunkAccess.getPos();
        Level level = worldGenLevel.getLevel();
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
                    float n = GetTerrainNoise(x, y, z);

                    float underworld_density = (y - underworld_height) / 5.0f;
                    float underworld_base_density = (y - underworld_base) / 15.0f;
                    float combined_underworld = n + underworld_density;
                    float combined_underworld_base = n + underworld_base_density;

                    if (y <= underworld_height) ExtraFunc.convertToBiome(level, blockPos, ModBiomes.ASH_WASTELAND.location(), 1);
                    if (y >= underworld_height + 20 && worldGenLevel.getBlockState(blockPos) == Blocks.WATER.defaultBlockState()) state = Blocks.CAVE_AIR.defaultBlockState();
                    if (combined_underworld < threshold) state = Blocks.CAVE_AIR.defaultBlockState();
                    if (y < underworld_base) state = Blocks.LAVA.defaultBlockState();
                    if (combined_underworld_base < threshold) state = NatureBlocks.ASH_BLOCK.get().defaultBlockState();
                    if (y <= -128) state = Blocks.BEDROCK.defaultBlockState();
                    if (state != null) worldGenLevel.setBlock(blockPos, state, 0);
                }
            }
        }
        */
    }

    private float GetTerrainNoise(int x, int y, int z) {
        return noise.GetSimplexFractal(x * 1.25f, y * 2.0f, z * 1.25f) * 5;
    }
}