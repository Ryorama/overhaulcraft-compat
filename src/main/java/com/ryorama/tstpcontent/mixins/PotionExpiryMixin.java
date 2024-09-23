package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.reference.OresRef;
import com.thevortex.potionsmaster.events.PotionExpiry;
import com.thevortex.potionsmaster.network.PacketHandler;
import com.thevortex.potionsmaster.network.PotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotionExpiry.class)
public class PotionExpiryMixin {
    @Inject(at = @At("HEAD"), method = "sendAll", remap = false)
    private static void sendAll(Player player, CallbackInfo ci) {
        PotionPacket pkt2 = new PotionPacket(OresRef.RANDOMIUM.toString());
        PacketHandler.sendTo(pkt2, (ServerPlayer)player);
    }
}
