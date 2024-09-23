package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.reference.OresRef;
import com.thevortex.potionsmaster.events.PotionExpiry;
import com.thevortex.potionsmaster.network.PacketHandler;
import com.thevortex.potionsmaster.network.PotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
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

    /**
     * @author Ryorama
     * @reason Allow checking if effect is from this mod
     */
    @Overwrite(remap = false)
    private static boolean isOreSightPotion(MobEffect potion) {
        return ForgeRegistries.MOB_EFFECTS.getKey(potion).getNamespace().contains("potionsmaster") || ForgeRegistries.MOB_EFFECTS.getKey(potion).getNamespace().contains("tstp_content") && ForgeRegistries.MOB_EFFECTS.getKey(potion).getPath().contains("ore_sight");
    }
}
