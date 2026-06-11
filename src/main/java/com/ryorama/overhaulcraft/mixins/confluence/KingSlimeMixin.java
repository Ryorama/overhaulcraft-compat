package com.ryorama.overhaulcraft.mixins.confluence;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import org.confluence.lib.api.entity.Boss;
import org.confluence.terraentity.api.entity.ai.IBossFSM;
import org.confluence.terraentity.entity.boss.KingSlime;
import org.confluence.terraentity.entity.util.DeathAnimOptions;
import org.confluence.terraentity.init.TESounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KingSlime.class)
public abstract class KingSlimeMixin extends Slime implements DeathAnimOptions, IBossFSM, Boss {
    public KingSlimeMixin(EntityType<? extends Slime> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("CTOR_HEAD"), method = "<init>(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V")
    public void KingSlime(EntityType slime, Level level, CallbackInfo ci) {
        this.playSound(TESounds.ROAR.get());
    }
}
