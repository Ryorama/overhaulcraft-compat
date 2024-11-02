package com.ryorama.tstpcontent.utils;

import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.github.alexmodguy.alexscaves.server.entity.ACEntityRegistry;
import com.github.alexmodguy.alexscaves.server.entity.item.NuclearExplosionEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class Utils {
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
    }

    public static void createNukeExplosionWithVec3(Level level, Vec3 vec3) {
        NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
        explosion.setPos(vec3);
        explosion.setSize((AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get()).floatValue());
        level.addFreshEntity(explosion);
    }

    public static class NuclearExposionThread extends Thread {
        public void createNukeUsingEntityPos(Level level, Entity baseEntity) {
            NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
            explosion.copyPosition(baseEntity);
            explosion.setSize((AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get()).floatValue());
            level.addFreshEntity(explosion);
        }

        public void createNukeUsingVec3(Level level, Vec3 vec3) {
            NuclearExplosionEntity explosion = (NuclearExplosionEntity)((EntityType) ACEntityRegistry.NUCLEAR_EXPLOSION.get()).create(level);
            explosion.setPos(vec3);
            explosion.setSize((AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get()).floatValue());
            level.addFreshEntity(explosion);
        }
    }
}
