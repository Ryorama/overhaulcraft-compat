package com.ryorama.tstpcontent.utils;

import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.github.alexmodguy.alexscaves.server.entity.ACEntityRegistry;
import com.github.alexmodguy.alexscaves.server.entity.item.NuclearExplosionEntity;
import mekanism.api.Coord4D;
import mekanism.api.radiation.IRadiationManager;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

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
}
