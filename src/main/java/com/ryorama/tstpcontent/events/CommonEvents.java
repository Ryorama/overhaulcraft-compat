package com.ryorama.tstpcontent.events;

import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import twilightforest.init.TFBlocks;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {
    @SubscribeEvent
    public static void portalCreated(BlockEvent.PortalSpawnEvent event) {
        if (TstpContentMod.CONFIG.restrictNetherAndEndToPlanets) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void blockstateUpdatedEvent(BlockStateUpdatedEvent event) {
        if (event.getBlockState() == TFBlocks.TWILIGHT_PORTAL.get().defaultBlockState()) {
            event.getLevel().setBlock(event.getBlockPos(), Blocks.AIR.defaultBlockState(), 0);
        }
    }
}
