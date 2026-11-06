package com.ryorama.overhaulcraft.mixins.cobbleloots;

import com.llamalad7.mixinextras.sugar.Local;
import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import dev.ripio.cobbleloots.event.custom.CobblelootsLootBallEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CobblelootsLootBallEvents.class)
public class CobblelootsLootBallEventsMixin {
    @Inject(at = @At("HEAD"), method = "generateLootBallOnChunk", cancellable = true)
    private static void generateLootBallOnChunk(ServerLevel level, LevelChunk levelChunk, RandomSource randomSource, CallbackInfoReturnable<Boolean> cir) {
        if (!level.dimension().equals(CobblemonDim.LEVEL)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getChunkAt(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/chunk/LevelChunk;"), method = "spawnLootBallNearRandomPlayer", cancellable = true)
    private static void spawnLootBallNearRandomPlayer(MinecraftServer server, RandomSource randomSource, CallbackInfo ci, @Local(name = "level") ServerLevel level) {
        if (!level.dimension().equals(CobblemonDim.LEVEL)) {
            ci.cancel();
        }
    }
}