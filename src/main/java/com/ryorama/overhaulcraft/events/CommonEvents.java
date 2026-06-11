package com.ryorama.overhaulcraft.events;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import com.ryorama.overhaulcraft.utils.IOverhaulPlayerData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import org.confluence.mod.common.attachment.PlayerSpecialData;
import org.confluence.mod.common.data.saved.Team;

@EventBusSubscriber(modid = OverhaulCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void mobSpawnEvent(MobSpawnEvent.PositionCheck event) {
        if (!ExtraFunc.isCobblemonDim(event.getEntity().level())) {
            if (ExtraFunc.isFromCobblemon(BuiltInRegistries.ENTITY_TYPE, event.getEntity().getType())) {
                event.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
            }
        } else {
            if (!ExtraFunc.isFromCobblemon(BuiltInRegistries.ENTITY_TYPE, event.getEntity().getType())) {
                event.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
            }
        }
    }

    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
    }

    @SubscribeEvent
    public static void entityJoinLevelEvent(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = ((Player) event.getEntity());

            PlayerSpecialData.of(player).setTeam(Team.WHITE);
            PlayerSpecialData.of(player).setPvP(true);
        }
    }

    @SubscribeEvent
    public static void entityTravelToDimensionEvent(EntityTravelToDimensionEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = ((Player) event.getEntity());

            if (event.getDimension().location().equals(ResourceLocation.tryParse("overhaulcraft:cobblemon_dim"))) {
                if (!((IOverhaulPlayerData) player).getCobblemonFuncUnlocked()) {
                    ((IOverhaulPlayerData) player).setCobblemonFuncUnlocked(true);
                }
            } else if (event.getDimension().location().equals(ResourceLocation.tryParse("confluence_dimension_patch:otherworld"))) {
                if (!((IOverhaulPlayerData) player).getTerrariaFuncUnlocked()) {
                    ((IOverhaulPlayerData) player).setTerrariaFuncUnlocked(true);
                }
            }
        }
    }


}
