package com.ryorama.overhaulcraft.events;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import com.ryorama.overhaulcraft.utils.IOverhaulPlayerData;
import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import org.confluence.mod.common.attachment.PlayerSpecialData;
import org.confluence.mod.common.data.saved.Team;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;

@EventBusSubscriber(modid = OverhaulCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
    }

    @SubscribeEvent
    public static void entityJoinLevelEvent(EntityJoinLevelEvent event) {
        if (ExtraFunc.isModInstalled("confluence")) {
            if (event.getEntity() instanceof Player) {
                Player player = ((Player) event.getEntity());

                PlayerSpecialData.of(player).setTeam(Team.WHITE);
                PlayerSpecialData.of(player).setPvP(true);
            }
        }
    }

    @SubscribeEvent
    public static void entityTravelToDimensionEvent(EntityTravelToDimensionEvent event) {
        if (ExtraFunc.isModInstalled("confluence_dimension_patch")) {
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
}
