package com.ryorama.tstpcontent.mixins;

import net.lointain.cosmos.procedures.ApplyGravityLogicProcedure;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ApplyGravityLogicProcedure.class)
public class ApplyGravityLogicProcedureMixin {


    /**
     * @author Ryorama
     * @reason Remove gravity as it is bugged
     */
    @Overwrite(remap = false)
    public static boolean execute(LevelAccessor world, String dimension) {
       return false;
    }
}
