package com.ryorama.tstpcontent.mixins.oreganized;

import com.ryorama.tstpcontent.compat.oreganized.GargoyleArmPointTypeRep;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmInteractionPointType;
import galena.oreganized.compat.create.CreateCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CreateCompat.class)
public class CreateCompatMixin {
    /**
     * @author Ryorama
     * @reason Fix compat for create 0.5
     */
    @Overwrite(remap = false)
    public static void register() {
        ArmInteractionPointType.register(new GargoyleArmPointTypeRep());
    }
}