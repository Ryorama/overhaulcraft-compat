package com.ryorama.tstpcontent.events;

import com.ryorama.tstpcontent.TstpContentMod;
import net.mcreator.cannibalscalling.init.CannibalsCallingModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
}
