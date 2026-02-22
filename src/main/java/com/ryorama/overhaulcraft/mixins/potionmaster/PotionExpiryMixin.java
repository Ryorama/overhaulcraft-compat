package com.ryorama.overhaulcraft.mixins.potionmaster;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.utils.TstpTags;
import com.thevortex.potionsmaster.events.PotionExpiry;
import com.thevortex.potionsmaster.network.PacketHandler;
import com.thevortex.potionsmaster.network.PotionPacket;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@IfModLoaded("potionsmaster")
@Mixin(PotionExpiry.class)
public class PotionExpiryMixin {
    @Inject(at = @At("HEAD"), method = "sendAll", remap = false)
    private static void sendAll(Player player, CallbackInfo ci) {
        PotionPacket pktrand = new PotionPacket(TstpTags.RANDOMIUM_ORE.toString());
        PotionPacket pktdraconium = new PotionPacket(TstpTags.DRACONIUM_ORE.toString());
        PotionPacket pktniter = new PotionPacket(TstpTags.NITER_ORE_ITEM.toString());
        PotionPacket pktsulfur = new PotionPacket(TstpTags.SULFUR_ORE.toString());
        PacketHandler.sendTo(pktrand, (ServerPlayer)player);
        PacketHandler.sendTo(pktdraconium, (ServerPlayer)player);
        PacketHandler.sendTo(pktniter, (ServerPlayer)player);
        PacketHandler.sendTo(pktsulfur, (ServerPlayer)player);
    }

    /**
     * @author Ryorama
     * @reason Allow checking if effect is from this mod
     */
    @Overwrite(remap = false)
    private static boolean isOreSightPotion(Holder<MobEffect> potion) {
        return potion.getKey().location().getNamespace().contains("potionsmaster") || potion.getKey().location().getNamespace().contains("tstp_content") && potion.getKey().location().getPath().contains("ore_sight");
    }
}
