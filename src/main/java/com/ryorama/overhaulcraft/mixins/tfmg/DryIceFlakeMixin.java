package com.ryorama.overhaulcraft.mixins.tfmg;

import com.drmangotea.tfmg.base.spark.DryIceFlake;
import com.drmangotea.tfmg.base.spark.Spark;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.pixelbank.burnt.procedures.ExtinguishBlockProcedure;
import net.pixelbank.burnt.procedures.ExtinguishEntityProcedure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@IfModLoaded("burnt")
@Mixin(DryIceFlake.class)
public abstract class DryIceFlakeMixin extends Spark {
    public DryIceFlakeMixin(EntityType<? extends Spark> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("HEAD"), method = "onHitEntity")
    protected void onHitEntity(EntityHitResult entityHit, CallbackInfo ci) {
        ExtinguishEntityProcedure.execute(this.level(), entityHit.getEntity());
    }

    @Inject(at = @At("HEAD"), method = "onHitBlock")
    protected void onHitBlock(BlockHitResult blockHit, CallbackInfo ci) {
        ExtinguishBlockProcedure.execute(this.level(), blockHit.getBlockPos().getX(), blockHit.getBlockPos().getY(), blockHit.getBlockPos().getZ());
    }
}