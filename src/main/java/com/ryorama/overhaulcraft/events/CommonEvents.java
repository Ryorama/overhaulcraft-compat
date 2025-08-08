package com.ryorama.overhaulcraft.events;

import com.ryorama.overhaulcraft.TstpContentMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = TstpContentMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
        TstpContentMod.LOGGER.info("Registering TSTP Entity Attributes");
        //event.put(TstpContentEntityTypes.RADSTER.get(), RadsterEntity.createAttributes().build());
    }
}
