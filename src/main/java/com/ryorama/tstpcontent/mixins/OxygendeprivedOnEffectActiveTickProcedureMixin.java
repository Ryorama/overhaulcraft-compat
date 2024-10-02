package com.ryorama.tstpcontent.mixins;

import net.lointain.cosmos.procedures.OxygendeprivedOnEffectActiveTickProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(OxygendeprivedOnEffectActiveTickProcedure.class)
public class OxygendeprivedOnEffectActiveTickProcedureMixin
{
    /**
     * @author Ryorama
     * @reason Remove in favor of Ad Astra's oxygen system
     */
    @Overwrite(remap = false)
    public static void execute(LevelAccessor world, Entity entity) {}
}
