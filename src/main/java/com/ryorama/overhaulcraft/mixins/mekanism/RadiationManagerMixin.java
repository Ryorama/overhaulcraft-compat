package com.ryorama.overhaulcraft.mixins.mekanism;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import mekanism.api.radiation.IRadiationManager;
import mekanism.common.lib.radiation.RadiationManager;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@IfModLoaded("mekanism")
@Mixin(RadiationManager.class)
public abstract class RadiationManagerMixin implements IRadiationManager {
    /*
    @Shadow(remap = false) public abstract boolean isRadiationEnabled();

    @Inject(at = @At("HEAD"), method = "updateEntityRadiation", remap = false)
    public void updateEntityRadiation(LivingEntity entity, CallbackInfo ci) {
        if (this.isRadiationEnabled()) {
            if (entity instanceof IRadiationManager) {
                return;
            }
        }
    }
    */
}
