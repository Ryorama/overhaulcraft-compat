package com.ryorama.overhaulcraft.events;

import com.aetherteam.aether.block.AetherBlocks;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.ryorama.overhaulcraft.OverhaulCraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import quek.undergarden.registry.UGBlocks;
import twilightforest.init.TFBlocks;

@EventBusSubscriber(modid = OverhaulCraft.MODID, bus = EventBusSubscriber.Bus.GAME)
public class CommonEventsForge {
    @SubscribeEvent
    public static void blockstateUpdatedEvent(BlockStateUpdatedEvent event) {
        if (OverhaulCraft.CONFIG.restrictDimensionTravelToPlanets) {
            BlockState[] portalBlocks = {
                    TFBlocks.TWILIGHT_PORTAL.get().defaultBlockState(),
                    AetherBlocks.AETHER_PORTAL.get().defaultBlockState(),
                    DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState(),
                    UGBlocks.UNDERGARDEN_PORTAL.get().defaultBlockState()
            };

            for (BlockState portalBlock : portalBlocks) {
                if (event.getBlockState() == portalBlock) {
                    event.getLevel().setBlock(event.getBlockPos(), Blocks.AIR.defaultBlockState(), 0);
                }
            }
        }

        if (OverhaulCraft.CONFIG.restrictNetherAndEndToPlanets) {
            BlockState[] portalBlocks = {
                    Blocks.NETHER_PORTAL.defaultBlockState(),
                    Blocks.END_PORTAL.defaultBlockState()
            };

            for (BlockState portalBlock : portalBlocks) {
                if (event.getBlockState() == portalBlock) {
                    event.getLevel().setBlock(event.getBlockPos(), Blocks.AIR.defaultBlockState(), 0);
                }
            }
        }
    }
}
