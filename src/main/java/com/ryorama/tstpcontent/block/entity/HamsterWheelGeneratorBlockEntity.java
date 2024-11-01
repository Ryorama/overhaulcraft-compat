package com.ryorama.tstpcontent.block.entity;

import com.ryorama.tstpcontent.block.HamsterWheelGeneratorBlock;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import com.starfish_studios.hamsters.block.entity.HamsterWheelBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class HamsterWheelGeneratorBlockEntity extends BlockEntity implements GeoBlockEntity {
    protected static final RawAnimation SPIN = RawAnimation.begin().thenLoop("animation.sf_nba.hamster_wheel.spin");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public HamsterWheelGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(TstpContentModBlockEntities.HAMSTER_WHEEL_GENERATOR.get(), pos, state);
    }
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController[]{new AnimationController(this, "controller", 0, this::controller)});
    }

    private <E extends HamsterWheelBlockEntity> PlayState controller(AnimationState<E> event) {
        assert this.level != null;

        BlockPos blockPos = this.getBlockPos();
        if (HamsterWheelGeneratorBlock.isOccupied(this.level, blockPos)) {
            event.getController().setAnimation(SPIN);
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        if (compound.get("energyStorage") instanceof IntTag intTag)
            energyStorage.deserializeNBT(intTag);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        compound.put("energyStorage", energyStorage.serializeNBT());
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    private final EnergyStorage energyStorage = new EnergyStorage(5000, 50, 50, 0) {
        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            int retval = super.receiveEnergy(maxReceive, simulate);
            if (!simulate) {
                setChanged();
                level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 2);
            }
            return retval;
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            int retval = super.extractEnergy(maxExtract, simulate);
            if (!simulate) {
                setChanged();
                level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 2);
            }
            return retval;
        }
    };

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && capability == ForgeCapabilities.ENERGY)
            return LazyOptional.of(() -> energyStorage).cast();
        return super.getCapability(capability, facing);
    }
}
