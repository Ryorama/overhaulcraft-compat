package com.ryorama.tstpcontent.goal;

import com.ryorama.tstpcontent.block.HamsterWheelGeneratorBlock;
import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import com.starfish_studios.hamsters.block.HamsterWheelBlock;
import com.starfish_studios.hamsters.entity.Hamster;
import com.starfish_studios.hamsters.registry.HamstersBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Predicate;

public class HamsterGoToGeneratorWheelGoal extends Goal {
    
    public TamableAnimal entity;
    private EntityDataAccessor<Integer> WAIT_TIME_BEFORE_RUN;
    private EntityDataAccessor<Integer> WAIT_TIME_WHEN_RUNNING;
    private final Predicate<BlockState> VALID_GATHERING_BLOCKS = (blockState) -> {
        if (!blockState.is(TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get())) {
            return false;
        } else {
            return !blockState.hasProperty(BlockStateProperties.WATERLOGGED) || !(Boolean)blockState.getValue(BlockStateProperties.WATERLOGGED);
        }
    };
    private @Nullable Vec3 wheelPos;

    public HamsterGoToGeneratorWheelGoal(TamableAnimal entity, EntityDataAccessor<Integer> waitTimeBeforeRun, EntityDataAccessor<Integer> waitTimeBeforeRunning) {
        this.setFlags(EnumSet.of(Flag.MOVE));
        this.entity = entity;
        this.WAIT_TIME_BEFORE_RUN = waitTimeBeforeRun;
        this.WAIT_TIME_WHEN_RUNNING = waitTimeBeforeRunning;
    }

    public boolean canUse() {
        Optional<BlockPos> optional = this.findNearbyResource();
        if (optional.isPresent() && !HamsterWheelGeneratorBlock.isOccupied(entity.level(), optional.get()) && getWaitTimeBeforeRunTicks() == 0) {
            entity.getNavigation().moveTo((double)(optional.get()).getX() + 0.5, (optional.get()).getY(), (double)(optional.get()).getZ() + 0.5, 1.2000000476837158);
            return !entity.level().isRaining() && !entity.isSleeping() && !entity.isInSittingPose();
        } else {
            return false;
        }
    }

    public boolean canContinueToUse() {
        Optional<BlockPos> optional = this.findNearbyResource();
        if (optional.isPresent() && !HamsterWheelGeneratorBlock.isOccupied(entity.level(), optional.get()) && getWaitTimeBeforeRunTicks() == 0) {
            return !entity.level().isRaining() && !entity.isSleeping() && !entity.isInSittingPose();
        } else {
            return false;
        }
    }

    public void stop() {
        entity.getNavigation().stop();
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        Optional<BlockPos> optional = this.findNearbyResource();
        if (!optional.isEmpty()) {
            if (HamsterWheelGeneratorBlock.isOccupied(entity.level(), optional.get())) {
                this.stop();
            }


            if (!HamsterWheelGeneratorBlock.isOccupied(entity.level(), optional.get()) && this.getWaitTimeBeforeRunTicks() == 0) {
                Vec3 vec3 = Vec3.atBottomCenterOf(optional.get());
                if (vec3.distanceTo(entity.position()) > 1.4) {
                    this.wheelPos = vec3;
                    this.setWantedPos();
                    return;
                }

                if (this.wheelPos == null) {
                    this.wheelPos = vec3;
                }

                if (entity.position().distanceTo(this.wheelPos) <= 1.4) {
                    setWaitTimeWhenRunningTicks(entity.getRandom().nextInt(300) + 100);
                    HamsterWheelGeneratorBlock.sitDown(entity.level(), optional.get(), entity);
                    this.stop();
                }
            }
        }

    }

    private void setWantedPos() {
        entity.getMoveControl().setWantedPosition(this.wheelPos.x(), this.wheelPos.y(), this.wheelPos.z(), 0.699999988079071);
    }

    private Optional<BlockPos> findNearbyResource() {
        return this.findNearestBlock(this.VALID_GATHERING_BLOCKS);
    }

    private Optional<BlockPos> findNearestBlock(Predicate<BlockState> predicate) {
        BlockPos blockPos = entity.blockPosition();
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for(int i = 0; (double)i <= 5.0; i = i > 0 ? -i : 1 - i) {
            for(int j = 0; (double)j < 5.0; ++j) {
                for(int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                    for(int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                        mutableBlockPos.setWithOffset(blockPos, k, i - 1, l);
                        if (blockPos.closerThan(mutableBlockPos, 5.0) && predicate.test(entity.level().getBlockState(mutableBlockPos))) {
                            return Optional.of(mutableBlockPos);
                        }
                    }
                }
            }
        }

        return Optional.empty();
    }

    public int getWaitTimeBeforeRunTicks() {
        return entity.getEntityData().get(WAIT_TIME_BEFORE_RUN);
    }

    public void setWaitTimeWhenRunningTicks(int ticks) {
        entity.getEntityData().set(WAIT_TIME_WHEN_RUNNING, ticks);
    }
}