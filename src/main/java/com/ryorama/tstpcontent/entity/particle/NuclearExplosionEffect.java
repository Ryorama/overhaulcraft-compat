package com.ryorama.tstpcontent.entity.particle;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import team.lodestar.lodestone.handlers.ScreenshakeHandler;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

public class NuclearExplosionEffect extends Mob {

    public NuclearExplosionEffect(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
        ScreenshakeInstance screenshakeInstance = new ScreenshakeInstance(100);
        screenshakeInstance.setIntensity(10);
        ScreenshakeHandler.addScreenshake(screenshakeInstance);
    }

    @Override
    public void tick() {
        super.tick();
    }
}
