package com.ryorama.tstpcontent.events;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.ryorama.tstpcontent.TstpContentMod;
import net.mcreator.cannibalscalling.init.CannibalsCallingModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.dimension.DimensionDefaults;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.QueryableShipData;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.core.impl.game.ShipTeleportDataImpl;
import org.valkyrienskies.core.impl.game.ships.ShipObjectClientWorld;
import org.valkyrienskies.core.impl.game.ships.ShipObjectWorld;
import org.valkyrienskies.mod.common.IShipObjectWorldProvider;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.hooks.CommonHooksImpl;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;

import java.awt.*;
import java.util.List;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {

    @SubscribeEvent
    public static void addItemsToCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS)) {
            event.accept(CannibalsCallingModItems.HUMAN_MEAT.get());
            event.accept(CannibalsCallingModItems.COOKED_HUMAN_MEAT.get());
            event.accept(CannibalsCallingModItems.INHUMAN_MEAT.get());
        }
    }


    //ToDo: Fix
    /*
    @SubscribeEvent
    public static void tickEvent(TickEvent.LevelTickEvent event) {
        VSGameUtilsKt.getShipObjectWorld(event.level);
        for (int s = 0; s < loadedShips.size(); s++) {
           Vector3dc pos = ((Ship)loadedShips.get(s)).getTransform().getPositionInWorld();
           if (pos.y() >= 315) {

               ValkyrienSkiesMod.getVsCore().teleportShip(((ServerShipWorld)event.level), (((ServerShip)loadedShips.get(s))), new ShipTeleportDataImpl());

           }
        }
    }
    */
}
