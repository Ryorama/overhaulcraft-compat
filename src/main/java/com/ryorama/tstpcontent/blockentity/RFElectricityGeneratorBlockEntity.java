package com.ryorama.tstpcontent.blockentity;

import com.mrcrayfish.furniture.refurbished.Config;
import com.mrcrayfish.furniture.refurbished.blockentity.*;
import com.mrcrayfish.furniture.refurbished.client.audio.AudioManager;
import com.mrcrayfish.furniture.refurbished.core.ModSounds;
import com.mrcrayfish.furniture.refurbished.electricity.NodeSearchResult;
import com.mrcrayfish.furniture.refurbished.inventory.BuildableContainerData;
import com.mrcrayfish.furniture.refurbished.util.Utils;
import com.ryorama.tstpcontent.block.RFElectricityGeneratorBlock;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class RFElectricityGeneratorBlockEntity extends ElectricitySourceLootBlockEntity implements IProcessingBlock, ILevelAudio {
    protected final Vec3 audioPosition;
    protected int totalEnergy;
    protected int energy;
    protected int nodeCount;
    public static final int DATA_ENERGY = 0;
    public static final int DATA_TOTAL_ENERGY = 1;
    public static final int DATA_OVERLOADED = 2;
    public static final int DATA_NODE_COUNT = 3;

    protected final ContainerData data = new BuildableContainerData(builder -> {
        builder.add(DATA_ENERGY, () -> energy, value -> {});
        builder.add(DATA_TOTAL_ENERGY, () -> totalEnergy, value -> {});
        builder.add(DATA_OVERLOADED, () -> overloaded ? 1 : 0, value -> {});
        builder.add(DATA_NODE_COUNT, () -> nodeCount, value -> {});
    });
    private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

    public RFElectricityGeneratorBlockEntity(BlockPos pos, BlockState state) {
        this(TstpContentModBlockEntities.RF_ELECTRICITY_GENERATOR.get(), pos, state);
    }

    public RFElectricityGeneratorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state, 0);
        this.audioPosition = pos.getCenter().add(0.0, -0.375, 0.0);
    }

    public void onNodeOverloaded() {
        this.setChanged();
    }

    public NodeSearchResult searchNodeNetwork(boolean cancelAtLimit) {
        NodeSearchResult result = super.searchNodeNetwork(cancelAtLimit);
        this.nodeCount = result.nodes().size();
        return result;
    }

    public boolean processTick() {
        int x = getBlockPos().getX();
        int y = getBlockPos().getY();
        int z = getBlockPos().getZ();

        System.out.println("Working");
        if (new Object() {
            public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = level.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
                return _retval.get();
            }
        }.extractEnergySimulate(level, new BlockPos(x, y, z), 1000) >= 1000) {
            {
                BlockEntity _ent = level.getBlockEntity(new BlockPos(x, y, z));
                int _amount = 1000;
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));

                this.addEnergy(4);
            }
        }

        boolean processing = false;
        if(this.canProcess())
        {
            if(!this.requiresEnergy() || this.getEnergy() > 0)
            {
                processing = true;

                // Get the time required to complete a process
                int totalProcessingTime = this.updateAndGetTotalProcessingTime();

                // Increase the process time if not yet reach the final process time and consume energy
                int processingTime = this.getProcessingTime();
                if(processingTime < totalProcessingTime)
                {
                    this.setProcessingTime(processingTime + 1);
                    if(this.requiresEnergy() && this.getEnergyMode() == EnergyMode.ONLY_WHEN_PROCESSING)
                    {
                        this.addEnergy(-1);
                    }
                }

                // Finally check if the process time is finished and output the result
                if(processingTime >= totalProcessingTime)
                {
                    this.onCompleteProcess();
                    this.setProcessingTime(0);
                }
            }
        }
        // If not processing, reset processing time back to zero
        if(!processing)
        {
            this.setProcessingTime(0);
        }

        return processing;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, RFElectricityGeneratorBlockEntity generator) {
        if (level.isClientSide()) {
            AudioManager.get().playLevelAudio(generator);
        }
    }

    public int getNodeMaximumConnections() {
        return Config.SERVER.electricity.maximumLinksPerElectricityGenerator.get();
    }

    @Override
    public boolean isMatchingContainerMenu(AbstractContainerMenu abstractContainerMenu) {
        return false;
    }

    public IProcessingBlock.EnergyMode getEnergyMode() {
        return EnergyMode.ONLY_WHEN_PROCESSING;
    }
    @Override
    public SoundEvent getSound() {
        return ModSounds.BLOCK_ELECTRICITY_GENERATOR_ENGINE.get();
    }

    @Override
    public SoundSource getSource() {
        return SoundSource.BLOCKS;
    }

    @Override
    public Vec3 getAudioPosition() {
        return this.audioPosition;
    }

    @Override
    public boolean canPlayAudio() {
        return this.isNodePowered() && !this.isRemoved();
    }

    @Override
    public int getAudioHash() {
        return worldPosition.hashCode();
    }

    @Override
    public boolean isAudioEqual(ILevelAudio iLevelAudio) {
        return iLevelAudio == this;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void addEnergy(int i) {
        this.energy += i;
    }

    @Override
    public boolean requiresEnergy() {
        return true;
    }

    @Override
    public int retrieveEnergy(boolean simulate) {
        return 0;
    }

    @Override
    public int updateAndGetTotalProcessingTime() {
        return this.getTotalProcessingTime();
    }

    @Override
    public int getTotalProcessingTime() {
        return 1;
    }

    @Override
    public int getProcessingTime() {
        return 0;
    }

    @Override
    public void setProcessingTime(int time) {
        if (this.isNodePowered()) {
            if (time == 0) {
                this.setNodePowered(false);
            }
        } else if (time == 1) {
            this.setNodePowered(true);
        }
    }

    @Override
    public void onCompleteProcess() {

    }

    @Override
    public boolean canProcess() {
        return !this.isNodeOverloaded();
    }

    @Override
    public boolean isNodePowered() {
        BlockState state = this.getBlockState();
        return state.hasProperty(RFElectricityGeneratorBlock.POWERED) ? state.getValue(RFElectricityGeneratorBlock.POWERED) : false;
    }

    @Override
    public void setNodePowered(boolean powered) {
        BlockState state = this.getBlockState();
        if (state.hasProperty(RFElectricityGeneratorBlock.POWERED)) {
            this.level.setBlock(this.worldPosition, state.setValue(RFElectricityGeneratorBlock.POWERED, powered), 3);
        }
    }

    @Override
    protected Component getDefaultName() {
        return Utils.translation("container", "rf_electricity_generator", new Object[0]);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        if (compound.get("energyStorage") instanceof IntTag intTag)
            this.energyStorage.deserializeNBT(intTag);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        compound.put("energyStorage", this.energyStorage.serializeNBT());
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        this.searchNodeNetwork(false);

        return null;
    }

    private final EnergyStorage energyStorage = new EnergyStorage(400000, 1000, 1000, 0) {
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
        if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER)
            return handlers[facing.ordinal()].cast();
        if (!this.remove && capability == ForgeCapabilities.ENERGY)
            return LazyOptional.of(() -> energyStorage).cast();
        return super.getCapability(capability, facing);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        for (LazyOptional<? extends IItemHandler> handler : handlers)
            handler.invalidate();
    }

    @Override
    public void earlyNodeTick(Level level) {
        if (!level.isClientSide()) {
            this.processTick();
        }
        super.earlyNodeTick(level);
    }
}
