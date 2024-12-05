package com.ryorama.tstpcontent.mixins.hamster;

import com.ryorama.tstpcontent.block.HamsterWheelGeneratorBlock;
import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import com.starfish_studios.hamsters.block.HamsterWheelBlock;
import com.starfish_studios.hamsters.entity.Hamster;
import com.starfish_studios.hamsters.registry.HamstersBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Optional;
import java.util.function.Predicate;

@Mixin(targets = "com.starfish_studios.hamsters.entity.Hamster$HamsterGoToWheelGoal")
public abstract class HamsterGoToWheelGoalMixin extends Goal {
    @Shadow(remap = false) @Final private Hamster this$0;

    private final Predicate<BlockState> NEW_VALID_GATHERING_BLOCKS = (blockState) -> {
        if (!blockState.is(HamstersBlocks.HAMSTER_WHEEL.get()) && !blockState.is(TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get())) {
            return false;
        } else {
            return !blockState.hasProperty(BlockStateProperties.WATERLOGGED) || !(Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED);
        }
    };
    @Shadow(remap = false)
    private @Nullable Vec3 wheelPos;

    /**
     * @author Ryorama
     * @reason Add support for generator wheel
     */
    @Overwrite(remap = false)
    public boolean canUse() {
        Optional<BlockPos> optional = this.findNearbyResource();
        if ((optional.isPresent() && !HamsterWheelBlock.isOccupied(this$0.level(), optional.get()) && this$0.getWaitTimeBeforeRunTicks() == 0) || (optional.isPresent() && !HamsterWheelGeneratorBlock.isOccupied(this$0.level(), optional.get()) && this$0.getWaitTimeBeforeRunTicks() == 0)) {
            this$0.getNavigation().moveTo((double) (optional.get()).getX() + 0.5, (optional.get()).getY(), (double) (optional.get()).getZ() + 0.5, 1.2000000476837158);
            return !this$0.level().isRaining() && !this$0.isSleeping() && !this$0.isInSittingPose();
        } else {
            return false;
        }
    }

    /**
     * @author Ryorama
     * @reason Add support for generator wheel
     */
    @Overwrite()
    public boolean canContinueToUse() {
        Optional<BlockPos> optional = this.findNearbyResource();
        if ((optional.isPresent() && !HamsterWheelBlock.isOccupied(this$0.level(), optional.get()) && this$0.getWaitTimeBeforeRunTicks() == 0) || (optional.isPresent() && !HamsterWheelGeneratorBlock.isOccupied(this$0.level(), optional.get()) && this$0.getWaitTimeBeforeRunTicks() == 0)) {
            return !this$0.level().isRaining() && !this$0.isSleeping() && !this$0.isInSittingPose();
        } else {
            return false;
        }
    }

    /**
     * @author Ryorama
     * @reason Add support for generator wheel
     */
    @Overwrite()
    public void tick() {
        Optional<BlockPos> optional = this.findNearbyResource();
        if (HamsterWheelBlock.isOccupied(this$0.level(), optional.get()) || HamsterWheelGeneratorBlock.isOccupied(this$0.level(), optional.get())) {
            this.stop();
        }

        if ((!HamsterWheelBlock.isOccupied(this$0.level(), optional.get()) && this$0.getWaitTimeBeforeRunTicks() == 0) || (!HamsterWheelGeneratorBlock.isOccupied(this$0.level(), optional.get()) && this$0.getWaitTimeBeforeRunTicks() == 0)) {
            Vec3 vec3 = Vec3.atBottomCenterOf(optional.get());
            if (vec3.distanceTo(this$0.position()) > 1.4) {
                this.wheelPos = vec3;
                this.setWantedPos();
                return;
            }

            if (this.wheelPos == null) {
                this.wheelPos = vec3;
            }

            if (this$0.position().distanceTo(this.wheelPos) <= 1.4) {
                this$0.setWaitTimeWhenRunningTicks(this$0.getRandom().nextInt(300) + 100);

                if (this$0.level().getBlockState(optional.get()) == HamstersBlocks.HAMSTER_WHEEL.get().defaultBlockState()) {
                    HamsterWheelBlock.sitDown(this$0.level(), optional.get(), this$0);
                } else if (this$0.level().getBlockState(optional.get()) == TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get().defaultBlockState()) {
                    HamsterWheelGeneratorBlock.sitDown(this$0.level(), optional.get(), this$0);
                }
                this.stop();
            }
        }
    }

    @Shadow(remap = false)
    private void setWantedPos() {}

    /**
     * @author Ryorama
     * @reason Add support for generator wheel
     */
    @Overwrite(remap = false)
    private Optional<BlockPos> findNearbyResource() {
        return this.findNearestBlock(NEW_VALID_GATHERING_BLOCKS);
    }

    @Shadow(remap = false)
    protected abstract Optional<BlockPos> findNearestBlock(Predicate<BlockState> predicate);
}