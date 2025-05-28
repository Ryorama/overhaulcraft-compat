package com.ryorama.tstpcontent.events;

import com.mrcrayfish.furniture.refurbished.client.registration.ScreenRegister;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.init.TstpConentModMenuTypes;
import com.ryorama.tstpcontent.inventory.RFElectricityGeneratorScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        TstpContentMod.LOGGER.info("Registering Tstp Stuff");
    }

    public static void registerScreens(ScreenRegister register) {
        register.apply(TstpConentModMenuTypes.RF_ELECTRICITY_GENERATOR.get(), RFElectricityGeneratorScreen::new);
    }
}
