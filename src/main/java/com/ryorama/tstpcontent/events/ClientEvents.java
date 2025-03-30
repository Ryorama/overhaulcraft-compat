package com.ryorama.tstpcontent.events;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.client.render.block.BlockEntityCookieJarRenderer;
import com.ryorama.tstpcontent.client.render.block.BlockEntityCupRenderer;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        TstpContentMod.LOGGER.info("Registering Tstp Stuff");
        //event.registerBlockEntityRenderer(TstpContentModBlockEntities.CUP.get(), BlockEntityCupRenderer::new);
        //event.registerBlockEntityRenderer(TstpContentModBlockEntities.COOKIE_JAR.get(), BlockEntityCookieJarRenderer::new);
    }
}
