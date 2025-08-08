package com.ryorama.tstpcontent.events;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.entities.RadsterEntity;
import com.ryorama.tstpcontent.init.TstpContentEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
        TstpContentMod.LOGGER.info("Registering TSTP Entity Attributes");
        event.put(TstpContentEntityTypes.RADSTER.get(), RadsterEntity.createAttributes().build());
    }
}
