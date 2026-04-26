package com.ryorama.overhaulcraft.utils;

import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.github.alexmodguy.alexscaves.server.entity.ACEntityRegistry;
import com.github.alexmodguy.alexscaves.server.entity.item.NuclearExplosionEntity;
import com.ryorama.overhaulcraft.OverhaulCraft;
import de.keksuccino.melody.resources.audio.MelodyAudioException;
import de.keksuccino.melody.resources.audio.SimpleAudioFactory;
import mekanism.api.radiation.IRadiationManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.fml.ModList;
import org.apache.commons.lang3.mutable.MutableInt;
import org.confluence.mod.common.init.ModBiomes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ExtraFunc {

    public static boolean isInDimensiom(Player player, ResourceLocation dimension) {
        return player.level().dimensionTypeRegistration().is(dimension);
    }

    //Method from Alex's Caves | https://github.com/AlexModGuy/AlexsCaves/blob/4718f4287c65b810aecb211789b45f54d405a94d/src/main/java/com/github/alexmodguy/alexscaves/server/entity/item/NuclearBombEntity.java#L102
    public static void createNukeExplosion(Level level, Entity baseEntity) {
        NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
        explosion.copyPosition(baseEntity);
        explosion.setSize((AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get()).floatValue());
        level.addFreshEntity(explosion);
        IRadiationManager radiationManager = IRadiationManager.INSTANCE;
        if (radiationManager.isRadiationEnabled()) {
            radiationManager.radiate(level, baseEntity.getOnPos(), 10 * AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get());
        }
    }

    //Method from Alex's Caves | https://github.com/AlexModGuy/AlexsCaves/blob/4718f4287c65b810aecb211789b45f54d405a94d/src/main/java/com/github/alexmodguy/alexscaves/server/entity/item/NuclearBombEntity.java#L102
    public static void createNukeExplosionWithSize(Level level, Entity baseEntity, float size) {
        NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
        explosion.copyPosition(baseEntity);
        explosion.setSize(size);
        level.addFreshEntity(explosion);
        IRadiationManager radiationManager = IRadiationManager.INSTANCE;
        if (radiationManager.isRadiationEnabled()) {
            radiationManager.radiate(level, baseEntity.getOnPos(), size);
        }
    }

    //Method from Alex's Caves | https://github.com/AlexModGuy/AlexsCaves/blob/4718f4287c65b810aecb211789b45f54d405a94d/src/main/java/com/github/alexmodguy/alexscaves/server/block/blockentity/ConversionCrucibleBlockEntity.java#L322
    public static void convertToBiome(Level level, BlockPos blockPos, ResourceLocation biome, int size) {
        Optional<Holder.Reference<Biome>> biomeHolder = level.registryAccess().registryOrThrow(Registries.BIOME).getHolder(biome);
        if (!biomeHolder.isEmpty()) {
            AABB aabb = new AABB(blockPos.offset(-32, -32, -32).getCenter(), blockPos.offset(32, 32, 32).getCenter());
            List<ChunkAccess> list = new ArrayList();
            BoundingBox biomeConversionBox = new BoundingBox(blockPos.getX() - size, blockPos.getY() - size, blockPos.getZ() - size, blockPos.getX() + size, blockPos.getY() + size, blockPos.getZ() + size);
            if (level instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel)level;

                for(int k = SectionPos.blockToSectionCoord(biomeConversionBox.minZ()); k <= SectionPos.blockToSectionCoord(biomeConversionBox.maxZ()); ++k) {
                    for(int l = SectionPos.blockToSectionCoord(biomeConversionBox.minX()); l <= SectionPos.blockToSectionCoord(biomeConversionBox.maxX()); ++l) {
                        ChunkAccess chunkaccess = serverLevel.getChunk(l, k, ChunkStatus.FULL, false);
                        if (chunkaccess != null) {
                            list.add(chunkaccess);
                        }
                    }
                }

                MutableInt mutableint = new MutableInt(0);

                for(ChunkAccess chunkaccess1 : list) {
                    chunkaccess1.fillBiomesFromNoise(makeResolver(mutableint, chunkaccess1, biomeConversionBox, biomeHolder.get()), serverLevel.getChunkSource().randomState().sampler());
                    chunkaccess1.setUnsaved(true);
                }

                serverLevel.getChunkSource().chunkMap.resendBiomesForChunks(list);
            }

        }
    }

    //Method from Alex's Caves | https://github.com/AlexModGuy/AlexsCaves/blob/4718f4287c65b810aecb211789b45f54d405a94d/src/main/java/com/github/alexmodguy/alexscaves/server/block/blockentity/ConversionCrucibleBlockEntity.java#L356
    private static BiomeResolver makeResolver(MutableInt biomeCounter, ChunkAccess chunkAccess, BoundingBox boundingBox, Holder<Biome> biomeHolder) {
        return (quartX, quartY, quartZ, sampler) -> {
            int i = QuartPos.toBlock(quartX);
            int j = QuartPos.toBlock(quartY);
            int k = QuartPos.toBlock(quartZ);
            Holder<Biome> holder = chunkAccess.getNoiseBiome(quartX, quartY, quartZ);
            if (boundingBox.isInside(i, j, k)) {
                biomeCounter.increment();
                return biomeHolder;
            } else {
                return holder;
            }
        };
    }


    public static void updateCurrentMusic(Holder<SoundEvent> soundEvent, Level level) {
        if (level.isClientSide()) {
            MusicManager musicManager = Minecraft.getInstance().getMusicManager();
            Music music = new Music(soundEvent, 1, 2, true);
            if (!musicManager.isPlayingMusic(music)) {
                musicManager.stopPlaying();
                musicManager.startPlaying(music);
            }
        }
    }

    public static boolean isModInstalled(String modid) {
        return ModList.get().isLoaded(modid);
    }

    public static boolean accurateIsDay(Level level) {
        return level.getDayTime() % 24000L < 15000L || level.getDayTime() % 24000L > 22500L;
    }

    public static boolean isPlayerInHell(Player player) {
        if (player.level().getBiome(player.getOnPos()) == ModBiomes.ASH_WASTELAND || player.level().getBiome(player.getOnPos()) == ModBiomes.ASH_FOREST) {
            return true;
        }
        return false;
    }

    public static boolean enoughOfBlocksForMusic(Level level, Player player, int range, Block block) {
        int blockCount = 0;
        for(int x = -range; x < range; ++x) {
            for (int y = -range; y < range; ++y) {
                for (int z = -range; z < range; ++z) {
                    BlockPos pos2 = new BlockPos((int) (player.position().x() + x), (int) (player.position().y() + y), (int) (player.position().z() + z));
                    BlockState blockState = level.getBlockState(pos2);

                    if (blockState.is(block)) {
                        blockCount++;
                    }
                }
            }
        }
        System.out.println("Music Block Count: " + blockCount);
        if (blockCount >= range) {
            return true;
        }
        return false;
    }

    public static boolean enoughOfBlocksForMusic(Level level, Player player, int range, Block... block) {
        int blockCount = 0;
        List<Block> blockList = Arrays.stream(block).toList();

        for(int x = -range; x < range; ++x) {
            for (int y = -range; y < range; ++y) {
                for (int z = -range; z < range; ++z) {
                    BlockPos pos2 = new BlockPos((int) (player.position().x() + x), (int) (player.position().y() + y), (int) (player.position().z() + z));
                    BlockState blockState = level.getBlockState(pos2);

                    for (int l = 0; l < blockList.size(); l++) {
                        if (blockState.is(blockList.get(l))) {
                            blockCount++;
                        }
                    }
                }
            }
        }
        System.out.println("Music Block Count: " + blockCount);
        if (blockCount >= range) {
            return true;
        }
        return false;
    }

    public static boolean canPlayTerrariaMusic(Player player) {
        if (OverhaulCraft.CONFIG.playTerrariaMusic) {
            if (isModInstalled("confluence_dimension_patch")) {
                if (isInDimensiom(player, ResourceLocation.fromNamespaceAndPath("confluence_dimension_patch", "otherworld"))) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
