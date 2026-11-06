package com.ryorama.overhaulcraft.mixins.confluence;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.confluence.mod.common.block.natural.CrimsonHeartBlock;
import org.confluence.mod.common.init.ModSoundEvents;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(CrimsonHeartBlock.class)
public abstract class CrimsonHeartMixin extends Block {
    public CrimsonHeartMixin(Properties properties) {
        super(properties);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lorg/confluence/mod/util/ModUtils;summonBoss(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lorg/confluence/mod/common/entity/boss/BaseBoss;Z)V"), method = "onPlayerBroken")
    protected void onPlayerBroken(Level level, BlockPos pos, CallbackInfo ci) {
        level.playSound(null, pos, ModSoundEvents.ROAR.get(), SoundSource.BLOCKS);
    }

    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;broadcastSystemMessage(Lnet/minecraft/network/chat/Component;Z)V"), method = "onPlayerBroken")
    protected void onPlayerBroken(PlayerList playerList, Component message, boolean bypassHiddenChat, Operation<Void> original) {
        List<ServerPlayer> players = playerList.getPlayers();
        for (ServerPlayer player : players) {
            if (player.level().dimension().equals(OtherWorld.LEVEL)) {
                player.sendSystemMessage(message);
            }
        }
    }
}