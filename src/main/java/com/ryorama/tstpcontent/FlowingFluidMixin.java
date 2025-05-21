package com.ryorama.tstpcontent;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.solar_apocalypse.SolarApocalypse;
import com.smushytaco.solar_apocalypse.WorldDayCalculation;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.material.FlowingFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FlowingFluid.class)
public class FlowingFluidMixin {
    @ModifyReturnValue(method = "canSpreadTo", at = @At("RETURN"))
    protected boolean canSpreadTo(boolean original) {
        if (Minecraft.getInstance().level != null) {
            return !(WorldDayCalculation.INSTANCE.isOldEnough(Minecraft.getInstance().level, SolarApocalypse.INSTANCE.getConfig().getPhaseOneDay()) && original);
        }
        return original;
    }
}