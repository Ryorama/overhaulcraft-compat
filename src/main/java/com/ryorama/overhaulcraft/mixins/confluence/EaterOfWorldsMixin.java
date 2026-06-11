package com.ryorama.overhaulcraft.mixins.confluence;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.confluence.lib.api.entity.Boss;
import org.confluence.terraentity.api.entity.IHeightControlMob;
import org.confluence.terraentity.entity.boss.AbstractTerraBossBase;
import org.confluence.terraentity.entity.boss.EaterOfWorlds;
import org.confluence.terraentity.init.TESounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EaterOfWorlds.class)
public abstract class EaterOfWorldsMixin extends AbstractTerraBossBase implements Boss, IHeightControlMob.Empty {
    public EaterOfWorldsMixin(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At("CTOR_HEAD"), method = "<init>(Lnet/minecraft/world/level/Level;Z)V")
    public void EaterOfWorlds(Level level, boolean genSegments, CallbackInfo ci) {
        this.playSound(TESounds.ROAR.get());
    }
}
