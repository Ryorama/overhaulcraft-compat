package com.ryorama.tstpcontent.events;

import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    //ToDo: Sort out Kotlin implementation
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
