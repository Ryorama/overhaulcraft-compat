package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import com.starfish_studios.hamsters.entity.Hamster;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow(remap = false)
    public abstract void lerpTo(double p_20977_, double p_20978_, double p_20979_, float p_20980_, float p_20981_, int p_20982_, boolean p_20983_);

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("HEAD"), method = "aiStep", remap = false)
    public void aiStep(CallbackInfo ci) {
        if ((Entity)this instanceof Hamster) {
            if (this.level().getBlockState(this.blockPosition()).is(TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get())) {
                this.setDeltaMovement(0.0, 0.0, 0.0);
            }
        }
    }

}
