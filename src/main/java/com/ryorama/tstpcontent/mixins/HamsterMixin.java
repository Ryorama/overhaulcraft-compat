package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.block.HamsterWheelGeneratorBlock;
import com.ryorama.tstpcontent.goal.HamsterGoToGeneratorWheelGoal;
import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import com.starfish_studios.hamsters.entity.Hamster;
import com.starfish_studios.hamsters.entity.SeatEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Hamster.class)
public abstract class HamsterMixin extends TamableAnimal {

    public HamsterGoToGeneratorWheelGoal hamsterGoToGeneratorWheelGoal;

    @Final
    @Shadow(remap = false)
    private static EntityDataAccessor<Integer> WAIT_TIME_BEFORE_RUN;

    @Final
    @Shadow(remap = false)
    private static EntityDataAccessor<Integer> WAIT_TIME_WHEN_RUNNING;

    protected HamsterMixin(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("HEAD"), method = "registerGoals", remap = false)
    public void registerGoals(CallbackInfo ci) {
        this.hamsterGoToGeneratorWheelGoal = new HamsterGoToGeneratorWheelGoal(this, WAIT_TIME_BEFORE_RUN, WAIT_TIME_WHEN_RUNNING);
        this.goalSelector.addGoal(4, this.hamsterGoToGeneratorWheelGoal);
    }

    @Inject(at = @At("HEAD"), method = "tick", remap = false)
    public void tick(CallbackInfo ci) {
        if (!(this.getVehicle() instanceof SeatEntity)) {
            super.tick();
        } else {
            BlockState state = this.level().getBlockState(this.blockPosition());
            if (state.is(TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get())) {
                BlockPos pos1;
                if (state.getValue(HamsterWheelGeneratorBlock.FACING) == Direction.SOUTH) {
                    pos1 = this.blockPosition().east(1);
                } else if (state.getValue(HamsterWheelGeneratorBlock.FACING) == Direction.NORTH) {
                    pos1 = this.blockPosition().west(1);
                } else if (state.getValue(HamsterWheelGeneratorBlock.FACING) == Direction.EAST) {
                    pos1 = this.blockPosition().north(1);
                } else {
                    pos1 = this.blockPosition().south(1);
                }

                this.setSleeping(false);
                this.setInSittingPose(false);
                this.lookAt(EntityAnchorArgument.Anchor.FEET, new Vec3(((float)pos1.getX() + 0.5F), ((float)pos1.getY() + 0.5F), ((float)pos1.getZ() + 0.5F)));
            }
        }
    }

    @Shadow(remap = false)
    public void setSleeping(boolean isSleeping) {}
}