package com.ryorama.tstpcontent.events;

import com.aetherteam.aether.block.AetherBlocks;
import com.dreamcritting.shadowlands.init.ModBlocks;
import com.dreamcritting.toybox.init.ToyboxModBlocks;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.legacy.blue_skies.registries.SkiesBlocks;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.entities.RadsterEntity;
import com.ryorama.tstpcontent.init.TstpContentEntityTypes;
import net.mcreator.astraldimension.init.AstralDimensionModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.the_forgotten_dimensions.init.TheForgottenDimensionsModBlocks;
import net.yezon.theabyss.init.TheabyssModBlocks;
import quek.undergarden.registry.UGBlocks;
import twilightforest.init.TFBlocks;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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
                    SkiesBlocks.everbright_portal.defaultBlockState(),
                    SkiesBlocks.everdawn_portal.defaultBlockState(),
                    AetherBlocks.AETHER_PORTAL.get().defaultBlockState(),
                    ToyboxModBlocks.TOYBOX_PORTAL.get().defaultBlockState(),
                    DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState(),
                    TheabyssModBlocks.FROST_WORLD_PORTAL.get().defaultBlockState(),
                    TheabyssModBlocks.THE_ABYSS_PORTAL.get().defaultBlockState(),
                    TheForgottenDimensionsModBlocks.PERMA_FROST_PORTAL_BLOCK.get().defaultBlockState(),
                    TheForgottenDimensionsModBlocks.SKYRIUM_PORTAL_BLOCK.get().defaultBlockState(),
                    ModBlocks.FIERY_PORTAL.get().defaultBlockState(),
                    ModBlocks.VELLIUM_PORTAL.get().defaultBlockState(),
                    ModBlocks.BLOOD_FOREST_PORTAL.get().defaultBlockState(),
                    ModBlocks.SHADOW_FOREST_PORTAL.get().defaultBlockState(),
                    ModBlocks.GLOWSHROOM_FOREST_PORTAL.get().defaultBlockState(),
                    AstralDimensionModBlocks.ASTRAL_DIMENSION_PORTAL.get().defaultBlockState(),
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
