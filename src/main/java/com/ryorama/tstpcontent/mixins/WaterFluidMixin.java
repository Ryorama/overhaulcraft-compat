package com.ryorama.tstpcontent.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.solar_apocalypse.SolarApocalypse;
import com.smushytaco.solar_apocalypse.WorldDayCalculation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.WaterFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WaterFluid.class)
public class WaterFluidMixin {
    @ModifyReturnValue(method = "canConvertToSource", at = @At("RETURN"))
    private boolean hookIsInfinite(boolean original, Level world) {
        return !WorldDayCalculation.INSTANCE.isOldEnough(world, SolarApocalypse.INSTANCE.getConfig().getPhaseOneDay()) && original;
    }
}
