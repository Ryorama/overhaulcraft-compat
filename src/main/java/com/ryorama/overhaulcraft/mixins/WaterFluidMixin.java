package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.smushytaco.solar_apocalypse.SolarApocalypse;
import com.smushytaco.solar_apocalypse.WorldDayCalculation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.WaterFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@IfModLoaded("solar_apocalypse")
@Mixin(WaterFluid.class)
public class WaterFluidMixin {
    @ModifyReturnValue(method = "canConvertToSource", at = @At("RETURN"))
    private boolean hookIsInfinite(boolean original, Level level) {
        return !(WorldDayCalculation.INSTANCE.isOldEnough(level, SolarApocalypse.INSTANCE.getConfig().getPhaseOneDay()) && original);
    }
}
