package com.ryorama.tstpcontent.events;

import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {
    @SubscribeEvent
    public static void portalCreated(BlockEvent.PortalSpawnEvent event) {
        if (TstpContentMod.CONFIG.restrictNetherAndEndToPlanets) {
            event.setCanceled(true);
        }
    }
}
