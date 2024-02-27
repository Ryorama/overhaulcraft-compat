package com.ryorama.tstpcontent.block.entity;

import com.ryorama.tstpcontent.block.HamsterWheelGeneratorBlock;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import com.ryorama.tstpcontent.utils.EnergyManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class HamsterWheelGeneratorBlockEntity extends BlockEntity implements IAnimatable {
    public AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private LazyOptional<EnergyManager> energy;
    public EnergyManager energyManager = new EnergyManager(10, 5000);
    public HamsterWheelGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(TstpContentModBlockEntities.HAMSTER_WHEEL_GENERATOR.get(), pos, state);
        this.energy = LazyOptional.of(() -> this.energyManager);
    }

    protected static final AnimationBuilder SPIN = new AnimationBuilder().addAnimation("animation.sf_nba.hamster_wheel.spin", ILoopType.EDefaultLoopTypes.LOOP);

    private <E extends IAnimatable> PlayState controller(AnimationEvent<E> event) {
        assert this.level != null;

        BlockPos blockPos = this.getBlockPos();
        if (HamsterWheelGeneratorBlock.isOccupied(this.level, blockPos)) {
            event.getController().setAnimation(SPIN);
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, HamsterWheelGeneratorBlockEntity entity) {
        entity.tick(level, pos, state);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (!level.isClientSide()) {
            if (HamsterWheelGeneratorBlock.isOccupied(level,pos)) {
                energyManager.addEnergy(3);
            }
        }

        handlePower();
    }

    public void handlePower() {
        if (this.energyManager.getEnergyStored() >= this.energyManager.getMaxExtract() && this.energyManager.canExtract()) {
            for (final var direction : Direction.values()) {
                final BlockEntity blockEntity = this.level.getBlockEntity(this.worldPosition.relative(direction));

                if (blockEntity != null) {
                    blockEntity.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite()).ifPresent(storage -> {
                        if (blockEntity != this && storage.getEnergyStored() < storage.getMaxEnergyStored()) {
                            this.energyManager.drainEnergy(this.energyManager.getMaxExtract());
                            final int received = storage.receiveEnergy(this.energyManager.getMaxExtract(), false);
                        }
                    });
                }
            }
        }
    }

    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0.0F, this::controller));
    }

    public AnimationFactory getFactory() {
        return this.factory;
    }
    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        LazyOptional<T> energyCapability = energyManager.getCapability(capability);
        if (energyCapability.isPresent()) {
            return energyCapability;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.energy.invalidate();
    }
}
