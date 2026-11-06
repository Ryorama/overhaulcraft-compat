package com.ryorama.overhaulcraft.mixins.confluence;

import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.confluence.terra_guns.common.entity.bullet.BaseBulletEntity;
import org.confluence.terra_guns.common.entity.bullet.CustomBulletEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(CustomBulletEntity.class)
public abstract class CustomBulletEntityMixin extends BaseBulletEntity {
    public CustomBulletEntityMixin(EntityType<? extends BaseBulletEntity> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo ci) {
        int simulationDistance = Objects.requireNonNull(this.level().getServer()).getPlayerList().getSimulationDistance();
        if (this.getOwner() != null) {
            if (this.getOwner() instanceof Player player) {
                if (simulationDistance > 0 && (ExtraFunc.isInDespawnDistance(this.blockPosition().getX(), player.blockPosition().getX(), simulationDistance) || ExtraFunc.isInDespawnDistance(this.blockPosition().getY(), player.blockPosition().getY(), simulationDistance) || ExtraFunc.isInDespawnDistance(this.blockPosition().getZ(), player.blockPosition().getZ(), simulationDistance))) {
                    this.remove(RemovalReason.DISCARDED);
                }
            }
        }
    }
}
