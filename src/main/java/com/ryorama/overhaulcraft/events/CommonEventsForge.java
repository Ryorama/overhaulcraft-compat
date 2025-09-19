package com.ryorama.overhaulcraft.events;

import com.aetherteam.aether.block.AetherBlocks;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.ryorama.overhaulcraft.TstpContentMod;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import quek.undergarden.registry.UGBlocks;
import twilightforest.init.TFBlocks;

@EventBusSubscriber(modid = TstpContentMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class CommonEventsForge {
    @SubscribeEvent
    public static void portalCreated(BlockEvent.PortalSpawnEvent event) {
        if (TstpContentMod.CONFIG.restrictNetherAndEndToPlanets) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void blockstateUpdatedEvent(BlockStateUpdatedEvent event) {
        if (TstpContentMod.CONFIG.restrictDimensionTravelToPlanets) {
            BlockState[] portalBlocks = {
                    TFBlocks.TWILIGHT_PORTAL.get().defaultBlockState(),
                    //SkiesBlocks.everbright_portal.defaultBlockState(),
                    //SkiesBlocks.everdawn_portal.defaultBlockState(),
                    AetherBlocks.AETHER_PORTAL.get().defaultBlockState(),
                    //ToyboxModBlocks.TOYBOX_PORTAL.get().defaultBlockState(),
                    DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState(),
                    //TheabyssModBlocks.FROST_WORLD_PORTAL.get().defaultBlockState(),
                    //TheabyssModBlocks.THE_ABYSS_PORTAL.get().defaultBlockState(),
                    //TheForgottenDimensionsModBlocks.PERMA_FROST_PORTAL_BLOCK.get().defaultBlockState(),
                    //TheForgottenDimensionsModBlocks.SKYRIUM_PORTAL_BLOCK.get().defaultBlockState(),
                    //ModBlocks.FIERY_PORTAL.get().defaultBlockState(),
                    //ModBlocks.VELLIUM_PORTAL.get().defaultBlockState(),
                    //ModBlocks.BLOOD_FOREST_PORTAL.get().defaultBlockState(),
                    //ModBlocks.SHADOW_FOREST_PORTAL.get().defaultBlockState(),
                    //ModBlocks.GLOWSHROOM_FOREST_PORTAL.get().defaultBlockState(),
                    //AstralDimensionModBlocks.ASTRAL_DIMENSION_PORTAL.get().defaultBlockState(),
                    UGBlocks.UNDERGARDEN_PORTAL.get().defaultBlockState()
            };

            for (int i = 0; i < portalBlocks.length; i++) {
                if (event.getBlockState() == portalBlocks[i]) {
                    event.getLevel().setBlock(event.getBlockPos(), Blocks.AIR.defaultBlockState(), 0);
                }
            }
        }
    }
}
