package com.ryorama.overhaulcraft.mixins.sablecollisiondamage;

import com.ryorama.overhaulcraft.OverhaulCraft;
import dev.ryanhcode.sable.api.physics.callback.BlockSubLevelCollisionCallback;
import net.minecraft.core.BlockPos;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "com.sable.collision_damage.SablePreSolverDamage$UniversalFragileCallback")
public class SablePreSolverDamage$UniversalFragileCallbackMixin {
    @Inject(at = @At("HEAD"), method = "sable$onCollision", cancellable = true)
    public void sable$onCollision(BlockPos pos, Vector3d hitPos, double impactVelocity, CallbackInfoReturnable<BlockSubLevelCollisionCallback.CollisionResult> cir) {
        if (!OverhaulCraft.CONFIG.enableShipSpeedDamage) cir.setReturnValue(BlockSubLevelCollisionCallback.CollisionResult.NONE);
    }
}
