package com.ryorama.overhaulcraft.mixins.confluence;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.confluence.lib.client.DPSMeter;
import org.confluence.lib.client.event.LibGameEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LibGameEvents.class)
public class LibGameEventsMixin {
    /**
     * @author Ryorama
     * @reason Remove item glint
     */
    @Overwrite(remap = false)
    public static void clientTick$Post(ClientTickEvent.Pre event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            DPSMeter.checkDPSTime(player.level().getGameTime());
        }
    }
}
