package com.ryorama.tstpcontent.events;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.client.render.HamsterWheelGeneratorRenderer;
import com.ryorama.tstpcontent.client.render.NuclearExplosionEffectRenderer;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import com.ryorama.tstpcontent.init.TstpContentModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TstpContentMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(TstpContentModBlockEntities.HAMSTER_WHEEL_GENERATOR.get(), HamsterWheelGeneratorRenderer::new);
        event.registerEntityRenderer(TstpContentModEntities.NUCLEAR_EXPLOSION_EFFECT.get(), NuclearExplosionEffectRenderer::new);
    }
}
