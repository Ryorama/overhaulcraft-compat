package com.ryorama.tstpcontent.events;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.init.TstpContentModEntities;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(TstpContentModEntities.NUCLEAR_EXPLOSION_EFFECT.get(), Mob.createMobAttributes().build());
    }
}
