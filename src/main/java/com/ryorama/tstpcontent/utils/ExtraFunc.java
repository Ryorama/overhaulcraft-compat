package com.ryorama.tstpcontent.utils;

import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.github.alexmodguy.alexscaves.server.entity.ACEntityRegistry;
import com.github.alexmodguy.alexscaves.server.entity.item.NuclearExplosionEntity;
import com.github.alexmodguy.alexscaves.server.misc.ACAdvancementTriggerRegistry;
import com.ryorama.tstpcontent.TstpContentMod;
import mekanism.api.Coord4D;
import mekanism.api.radiation.IRadiationManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.mutable.MutableInt;

import java.nio.file.Path;
import java.util.*;

public class ExtraFunc {
    //Tweaked method for creating a nuke explosion on a new thread to improve performance - Using Entity Pos
    public static void createNukeExplosionThreaded(Level level, Entity baseEntity) {
       NuclearExposionThread nuclearExposionThread = new NuclearExposionThread();
       if (!nuclearExposionThread.isAlive()) {
           nuclearExposionThread.start();
       }
       nuclearExposionThread.createNukeUsingEntityPos(level, baseEntity);
    }

    //Tweaked method for creating a nuke explosion on a new thread to improve performance - Using Vec3
    public static void createNukeExplosionUsingVec3Threaded(Level level, Vec3 vec3) {
        NuclearExposionThread nuclearExposionThread = new NuclearExposionThread();
        if (!nuclearExposionThread.isAlive()) {
            nuclearExposionThread.start();
        }
        nuclearExposionThread.createNukeUsingVec3(level, vec3);
    }


    //Original Method for creating a new from Alex's Caves
    public static void createNukeExplosion(Level level, Entity baseEntity) {
        NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
        explosion.copyPosition(baseEntity);
        explosion.setSize((AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get()).floatValue());
        level.addFreshEntity(explosion);
        IRadiationManager radiationManager = IRadiationManager.INSTANCE;
        if (radiationManager.isRadiationEnabled()) {
            radiationManager.radiate(new Coord4D(new Vec3i((int) baseEntity.position().x, (int) baseEntity.position().y, (int) baseEntity.position().z), level), 10 * AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get());
        }
    }

    public static void createNukeExplosionWithSize(Level level, Entity baseEntity, float size) {
        NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
        explosion.copyPosition(baseEntity);
        explosion.setSize(size);
        level.addFreshEntity(explosion);
        IRadiationManager radiationManager = IRadiationManager.INSTANCE;
        if (radiationManager.isRadiationEnabled()) {
            radiationManager.radiate(new Coord4D(new Vec3i((int) baseEntity.position().x, (int) baseEntity.position().y, (int) baseEntity.position().z), level), 10 * size);
        }
    }

    public static void createNukeExplosionWithVec3(Level level, Vec3 vec3) {
        NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
        explosion.setPos(vec3);
        explosion.setSize((AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get()).floatValue());
        level.addFreshEntity(explosion);
        IRadiationManager radiationManager = IRadiationManager.INSTANCE;
        if (radiationManager.isRadiationEnabled()) {
            radiationManager.radiate(new Coord4D(new Vec3i((int) vec3.x, (int) vec3.y, (int) vec3.z), level), 10 * AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get());
        }
    }

    public static class NuclearExposionThread extends Thread {
        public void createNukeUsingEntityPos(Level level, Entity baseEntity) {
            NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
            explosion.copyPosition(baseEntity);
            explosion.setSize((AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get()).floatValue());
            level.addFreshEntity(explosion);
            IRadiationManager radiationManager = IRadiationManager.INSTANCE;
            if (radiationManager.isRadiationEnabled()) {
                radiationManager.radiate(new Coord4D(new Vec3i((int) baseEntity.position().x, (int) baseEntity.position().y, (int) baseEntity.position().z), level), 10 * AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get());
            }
        }

        public void createNukeUsingVec3(Level level, Vec3 vec3) {
            NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
            explosion.setPos(vec3);
            explosion.setSize((AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get()).floatValue());
            level.addFreshEntity(explosion);
            IRadiationManager radiationManager = IRadiationManager.INSTANCE;
            if (radiationManager.isRadiationEnabled()) {
                radiationManager.radiate(new Coord4D(new Vec3i((int) vec3.x, (int) vec3.y, (int) vec3.z), level), 10 * AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get());
            }
        }
    }

    //Method from Alex's Caves | com/github/alexmodguy/alexscaves/server/block/blockentity/ConversionCrucibleBlockEntity
    public void convertToBiome(Level level, BlockPos blockPos, ResourceLocation biome, int size) {
        Optional<Holder.Reference<Biome>> biomeHolder = level.registryAccess().registryOrThrow(Registries.BIOME).getHolder(ForgeRegistries.BIOMES.getResourceKey(ForgeRegistries.BIOMES.getValue(biome)).get());
        if (!biomeHolder.isEmpty()) {
            AABB aabb = new AABB(blockPos.offset(-32, -32, -32), blockPos.offset(32, 32, 32));
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

    //Method from Alex's Caves | com/github/alexmodguy/alexscaves/server/block/blockentity/ConversionCrucibleBlockEntity
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

    public static ItemStack getItemStackFromResourceLocation(ResourceLocation resourceLocation) {
        if (ForgeRegistries.ITEMS.getValue(resourceLocation) != null) {
            return Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(resourceLocation)).getDefaultInstance();
        }
        return new ItemStack(Items.DIRT);
    }

    public static ItemStack getItemStackFromString(String namespace, String path) {
        ResourceLocation resourceLocation = new ResourceLocation(namespace, path);
        if (ForgeRegistries.ITEMS.getValue(resourceLocation) != null) {
            return Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(resourceLocation)).getDefaultInstance();
        }
        return new ItemStack(Items.DIRT);
    }

    public static ResourceLocation getPlayerSkinByUUID(Level level, UUID uuid) {
        if (level.isClientSide()) {
            PlayerInfo playerinfo = Minecraft.getInstance().getConnection().getPlayerInfo(uuid);
            return playerinfo == null ? DefaultPlayerSkin.getDefaultSkin(uuid) : playerinfo.getSkinLocation();
        }
        return new ResourceLocation("minecraft:textures/entity/player/steve.png");
    }

    public static boolean isModInstalled(String modid) {
        return ModList.get().isLoaded(modid);
    }
}
