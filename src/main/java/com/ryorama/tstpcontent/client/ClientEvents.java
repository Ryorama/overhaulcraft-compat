package com.ryorama.tstpcontent.client;

import com.ryorama.tstpcontent.utils.SkyRenderUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber({Dist.CLIENT})
@OnlyIn(Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public void render(RenderLevelStageEvent event) {
        /*
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_TRIPWIRE_BLOCKS) {
            SkyRenderUtils.renderSkyOverworld(new SkyRenderUtils.RenderData(event.getPoseStack(), event.getPartialTick(), event.getProjectionMatrix()));
        }
         */
    }
}
