package com.ryorama.overhaulcraft.mixins.rctmod;

import com.gitlab.srcmc.rctmod.api.service.TrainerSpawner;
import com.gitlab.srcmc.rctmod.world.entities.TrainerMob;
import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TrainerSpawner.class)
public class TrainerSpawnerMixin {
    @Inject(at = @At("HEAD"), method = "attemptSpawnFor(Lnet/minecraft/world/entity/player/Player;)Z", cancellable = true)
    public void attemptSpawnFor(Player player, CallbackInfoReturnable<Boolean> cir) {
        if (!player.level().dimension().equals(CobblemonDim.LEVEL)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(at = @At("HEAD"), method = "attemptSpawnFor(Lnet/minecraft/world/entity/player/Player;Ljava/lang/String;Lnet/minecraft/core/BlockPos;ZZZDD)Lcom/gitlab/srcmc/rctmod/world/entities/TrainerMob;", cancellable = true)
    public void attemptSpawnFor(Player player, String trainerId, BlockPos pos, boolean setHome, boolean noOrigin, boolean guaruantee, double globalChance, double globalChanceMin, CallbackInfoReturnable<TrainerMob> cir) {
        if (!player.level().dimension().equals(CobblemonDim.LEVEL)) {
            cir.setReturnValue(null);
        }
    }
}