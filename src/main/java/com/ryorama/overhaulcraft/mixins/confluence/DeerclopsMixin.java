package com.ryorama.overhaulcraft.mixins.confluence;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.confluence.lib.api.entity.Boss;
import org.confluence.terraentity.api.entity.ISharedFlagControllerHolder;
import org.confluence.terraentity.entity.boss.AbstractTerraBossBase;
import org.confluence.terraentity.entity.boss.Deerclops;
import org.confluence.terraentity.init.TESounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Deerclops.class)
public abstract class DeerclopsMixin extends AbstractTerraBossBase implements Boss, ISharedFlagControllerHolder {
    public DeerclopsMixin(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At("CTOR_HEAD"), method = "<init>(Lnet/minecraft/world/level/Level;)V")
    public void Deerclops(Level level, CallbackInfo ci) {
        this.playSound(TESounds.ROAR.get());
    }
}
