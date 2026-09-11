package com.ryorama.overhaulcraft.mixins.confluence;

import com.ryorama.overhaulcraft.utils.IOverhaulPlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.event.ScreenEvent;
import org.confluence.mod.client.event.GameClientEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameClientEvents.class)
public class GameClientEventsMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/client/event/ScreenEvent$Init$Post;addListener(Lnet/minecraft/client/gui/components/events/GuiEventListener;)V"), method = "screen$Init$Post", cancellable = true)
    private static void screen$Init$Post(ScreenEvent.Init.Post event, CallbackInfo ci) {
        if (Minecraft.getInstance().player != null) {
            Player player = Minecraft.getInstance().player;
            if (!((IOverhaulPlayerData)player).getTerrariaFuncUnlocked()) {
                ci.cancel();
            }
        }
    }
}
