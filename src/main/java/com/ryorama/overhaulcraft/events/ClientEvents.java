package com.ryorama.overhaulcraft.events;

import com.mrcrayfish.furniture.refurbished.client.registration.ScreenRegister;
import com.ryorama.overhaulcraft.TstpContentMod;
import com.ryorama.overhaulcraft.init.TstpConentModMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = TstpContentMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        //event.registerEntityRenderer(TstpContentEntityTypes.RADSTER.get(), RadsterEntityRenderer::new);
    }

    public static void registerScreens(ScreenRegister register) {
        //register.apply(TstpConentModMenuTypes.RF_ELECTRICITY_GENERATOR.get(), RFElectricityGeneratorScreen::new);
    }
}
