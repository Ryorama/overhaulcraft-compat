package com.ryorama.overhaulcraft.mixins.confluence.gameevents;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.confluence.mod.common.gameevent.BloodMoonGameEvent;
import org.confluence.mod.common.gameevent.GoblinArmyGameEvent;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GoblinArmyGameEvent.class)
public class GoblinArmyGameEventMixin {
    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;sendSystemMessage(Lnet/minecraft/network/chat/Component;)V"), method = "onStart")
    public void onStart(ServerPlayer player, Component component, Operation<Void> original) {
        if (!player.level().dimension().equals(OtherWorld.LEVEL)) {
            player.sendSystemMessage(component);
        }
    }

    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;sendSystemMessage(Lnet/minecraft/network/chat/Component;)V"), method = "onEnd")
    public void onEnd(ServerPlayer player, Component component, Operation<Void> originalr) {
        if (!player.level().dimension().equals(OtherWorld.LEVEL)) {
            player.sendSystemMessage(component);
        }
    }
}
