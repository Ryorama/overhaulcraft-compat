package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.block.HamsterWheelGeneratorBlock;
import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import com.starfish_studios.hamsters.block.HamsterWheelBlock;
import com.starfish_studios.hamsters.entity.Hamster;
import com.starfish_studios.hamsters.entity.SeatEntity;
import com.starfish_studios.hamsters.registry.HamstersBlocks;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.function.Predicate;

@Mixin(Hamster.class)
public abstract class HamsterMixin extends TamableAnimal {

    protected HamsterMixin(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Mixin(targets = "com.starfish_studios.hamsters.entity.Hamster$HamsterLookControl")
    public abstract static class HamsterLookControl extends LookControl {
        public Hamster hamster = ((Hamster) (Object) this);

        public HamsterLookControl(Mob mob) {
            super(mob);
        }

        @Inject(at = @At("HEAD"), method = "tick", remap = false)
        public void tick(CallbackInfo ci) {

            if (!(hamster.getVehicle() instanceof SeatEntity)) {
                super.tick();
            } else {
                BlockState state = hamster.level().getBlockState(hamster.blockPosition());
                if (state.is(TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get())) {
                    BlockPos pos1;
                    if (state.getValue(HamsterWheelBlock.FACING) == Direction.SOUTH) {
                        pos1 = hamster.blockPosition().east(1);
                    } else if (state.getValue(HamsterWheelBlock.FACING) == Direction.NORTH) {
                        pos1 = hamster.blockPosition().west(1);
                    } else if (state.getValue(HamsterWheelBlock.FACING) == Direction.EAST) {
                        pos1 = hamster.blockPosition().north(1);
                    } else {
                        pos1 = hamster.blockPosition().south(1);
                    }

                    hamster.setSleeping(false);
                    hamster.setInSittingPose(false);
                    hamster.lookAt(EntityAnchorArgument.Anchor.FEET, new Vec3(((float) pos1.getX() + 0.5F), ((float) pos1.getY() + 0.5F), ((float) pos1.getZ() + 0.5F)));
                }
            }
        }
    }

    @Mixin(targets = "com.starfish_studios.hamsters.entity.Hamster$HamsterGoToWheelGoal")
    public abstract static class HamsterGoToWheelGoal extends Goal {
        public Hamster hamster = ((Hamster) (Object) this);

        private final Predicate<BlockState> NEW_VALID_GATHERING_BLOCKS = (blockState) -> {
            if (!blockState.is(HamstersBlocks.HAMSTER_WHEEL.get()) && !blockState.is(TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get())) {
                return false;
            } else {
                return !blockState.hasProperty(BlockStateProperties.WATERLOGGED) || !(Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED);
            }
        };
        @Shadow
        private @Nullable Vec3 wheelPos;

        /**
         * @author Ryorama
         * @reason Add support for generator wheel
         */
        @Overwrite(remap = false)
        public boolean canUse() {
            Optional<BlockPos> optional = this.findNearbyResource();
            if ((optional.isPresent() && !HamsterWheelBlock.isOccupied(hamster.level(), optional.get()) && hamster.getWaitTimeBeforeRunTicks() == 0) || (optional.isPresent() && !HamsterWheelGeneratorBlock.isOccupied(hamster.level(), optional.get()) && hamster.getWaitTimeBeforeRunTicks() == 0)) {
                hamster.getNavigation().moveTo((double) (optional.get()).getX() + 0.5, (optional.get()).getY(), (double) (optional.get()).getZ() + 0.5, 1.2000000476837158);
                return !hamster.level().isRaining() && !hamster.isSleeping() && !hamster.isInSittingPose();
            } else {
                return false;
            }
        }

        /**
         * @author Ryorama
         * @reason Add support for generator wheel
         */
        @Overwrite(remap = false)
        public boolean canContinueToUse() {
            Optional<BlockPos> optional = this.findNearbyResource();
            if ((optional.isPresent() && !HamsterWheelBlock.isOccupied(hamster.level(), optional.get()) && hamster.getWaitTimeBeforeRunTicks() == 0) || (optional.isPresent() && !HamsterWheelGeneratorBlock.isOccupied(hamster.level(), optional.get()) && hamster.getWaitTimeBeforeRunTicks() == 0)) {
                return !hamster.level().isRaining() && !hamster.isSleeping() && !hamster.isInSittingPose();
            } else {
                return false;
            }
        }

        /**
         * @author Ryorama
         * @reason Add support for generator wheel
         */
        @Overwrite(remap = false)
        public void tick() {
            Optional<BlockPos> optional = this.findNearbyResource();
            if (HamsterWheelBlock.isOccupied(hamster.level(), optional.get()) || HamsterWheelGeneratorBlock.isOccupied(hamster.level(), optional.get())) {
                this.stop();
            }

            if ((!HamsterWheelBlock.isOccupied(hamster.level(), optional.get()) && hamster.getWaitTimeBeforeRunTicks() == 0) || (!HamsterWheelGeneratorBlock.isOccupied(hamster.level(), optional.get()) && hamster.getWaitTimeBeforeRunTicks() == 0)) {
                Vec3 vec3 = Vec3.atBottomCenterOf(optional.get());
                if (vec3.distanceTo(hamster.position()) > 1.4) {
                    this.wheelPos = vec3;
                    this.setWantedPos();
                    return;
                }

                if (this.wheelPos == null) {
                    this.wheelPos = vec3;
                }

                if (hamster.position().distanceTo(this.wheelPos) <= 1.4) {
                    hamster.setWaitTimeWhenRunningTicks(hamster.getRandom().nextInt(300) + 100);

                    if (hamster.level().getBlockState(optional.get()) == HamstersBlocks.HAMSTER_WHEEL.get().defaultBlockState()) {
                        HamsterWheelBlock.sitDown(hamster.level(), optional.get(), hamster);
                    } else if (hamster.level().getBlockState(optional.get()) == TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get().defaultBlockState()) {
                        HamsterWheelGeneratorBlock.sitDown(hamster.level(), optional.get(), hamster);
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
}