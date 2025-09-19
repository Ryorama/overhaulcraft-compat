package com.ryorama.tstpcontent.mixins.hamster;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.starfish_studios.hamsters.compat.CreateCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@IfModLoaded("hamsters")
@Mixin(CreateCompat.class)
public class CreateCompatMixin {

    /**
     * @author Ryorama
     * @reason Fix create 6.0 compat
     */
    @Overwrite(remap = false)
    public static void setup(){
        //BlockStressValues.CAPACITIES.register(HamstersBlocks.HAMSTER_WHEEL, Dou); //.DEFAULT_CAPACITIES.put(Hamsters.id("hamster_wheel"), 16.0D);
    }
}
