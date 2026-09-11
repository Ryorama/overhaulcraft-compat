package com.ryorama.overhaulcraft.events;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftCommands;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import com.ryorama.overhaulcraft.utils.IOverhaulPlayerData;
import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import org.confluence.mod.common.attachment.PlayerSpecialData;
import org.confluence.mod.common.data.saved.Team;
import org.confluence.mod.util.ModUtils;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;

@EventBusSubscriber(modid = OverhaulCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
    }

    @SubscribeEvent
    public static void entityJoinLevelEvent(EntityJoinLevelEvent event) {
        if (ExtraFunc.isModLoaded("confluence")) {
            if (event.getEntity() instanceof Player) {
                Player player = ((Player) event.getEntity());

                PlayerSpecialData.of(player).setTeam(Team.WHITE);
                PlayerSpecialData.of(player).setPvP(true);
            }
        }
    }

    @SubscribeEvent
    public static void entityTravelToDimensionEvent(EntityTravelToDimensionEvent event) {
        if (ExtraFunc.isModLoaded("confluence_dimension_patch")) {
            if (event.getEntity() instanceof Player) {
                Player player = ((Player) event.getEntity());

                if (event.getDimension() == CobblemonDim.LEVEL) {
                    if (!((IOverhaulPlayerData) player).getCobblemonFuncUnlocked()) {
                        ((IOverhaulPlayerData) player).setCobblemonFuncUnlocked(true);
                    }
                } else if (event.getDimension() == OtherWorld.LEVEL) {
                    if (!((IOverhaulPlayerData) player).getTerrariaFuncUnlocked()) {
                        ((IOverhaulPlayerData) player).setTerrariaFuncUnlocked(true);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void mobSpawn$PositionCheckEvent(MobSpawnEvent.PositionCheck event) {
        Mob mob = event.getEntity();
        if (mob.level().dimension().equals(CobblemonDim.LEVEL) && !ExtraFunc.isFromCobblemon(BuiltInRegistries.ENTITY_TYPE, mob.getType())) {
            event.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
        }

        if (!mob.level().dimension().equals(CobblemonDim.LEVEL) && ExtraFunc.isFromCobblemon(BuiltInRegistries.ENTITY_TYPE, mob.getType())) {
            event.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
        }
    }

    @SubscribeEvent
    public static void registerCommandsEvent(RegisterCommandsEvent event) {
        OverhaulCraftCommands.setTerrariaFuncUnlocked(event.getDispatcher());
        OverhaulCraftCommands.setCobblemonFuncUnlocked(event.getDispatcher());
    }
}
