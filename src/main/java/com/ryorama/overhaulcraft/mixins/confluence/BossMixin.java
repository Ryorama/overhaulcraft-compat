package com.ryorama.overhaulcraft.mixins.confluence;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.confluence.lib.api.entity.Boss;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Boss.class)
public interface BossMixin {
    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;sendSystemMessage(Lnet/minecraft/network/chat/Component;)V"), method = "sendBossSpawnMessage")
    private static void sendBossSpawnMessage(Player player, Component message, Operation<Void> original) {
        if (player.level().dimension().equals(OtherWorld.LEVEL)) {
            player.sendSystemMessage(message);
        }
    }

    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;sendSystemMessage(Lnet/minecraft/network/chat/Component;)V"), method = "sendBossDeathMessage")
    private static void sendBossDeathMessage(Player player, Component message, Operation<Void> original) {
        if (player.level().dimension().equals(OtherWorld.LEVEL)) {
            player.sendSystemMessage(message);
        }
    }
}
