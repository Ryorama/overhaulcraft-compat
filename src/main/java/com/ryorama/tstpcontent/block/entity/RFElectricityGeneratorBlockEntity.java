package com.ryorama.tstpcontent.block.entity;

import com.mrcrayfish.furniture.refurbished.Config;
import com.mrcrayfish.furniture.refurbished.block.ElectricityGeneratorBlock;
import com.mrcrayfish.furniture.refurbished.blockentity.ElectricitySourceLootBlockEntity;
import com.mrcrayfish.furniture.refurbished.blockentity.ILevelAudio;
import com.mrcrayfish.furniture.refurbished.blockentity.IPowerSwitch;
import com.mrcrayfish.furniture.refurbished.blockentity.IProcessingBlock;
import com.mrcrayfish.furniture.refurbished.core.ModSounds;
import com.mrcrayfish.furniture.refurbished.electricity.NodeSearchResult;
import com.mrcrayfish.furniture.refurbished.inventory.BuildableContainerData;
import com.mrcrayfish.furniture.refurbished.util.Utils;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.energy.EnergyStorage;

import java.util.concurrent.atomic.AtomicInteger;

public class RFElectricityGeneratorBlockEntity extends ElectricitySourceLootBlockEntity implements IProcessingBlock, IPowerSwitch, ILevelAudio {
    public static final int DATA_ENERGY = 0;
    public static final int DATA_TOTAL_ENERGY = 1;
    public static final int DATA_ENABLED = 2;
    public static final int DATA_OVERLOADED = 3;
    public static final int DATA_POWERED = 4;
    public static final int DATA_NODE_COUNT = 5;
    protected final Vec3 audioPosition;
    protected int totalEnergy;
    protected int energy;
    protected boolean enabled;
    protected int nodeCount;
    protected final ContainerData data;

    public RFElectricityGeneratorBlockEntity(BlockPos pos, BlockState state) {
        this(TstpContentModBlockEntities.RF_ELECTRICITY_GENERATOR.get(), pos, state);
    }

    public RFElectricityGeneratorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state, 0);
        this.data = new BuildableContainerData((builder) -> {
            builder.add(0, () -> {
                return this.energy;
            }, (value) -> {
            });
            builder.add(1, () -> {
                return this.totalEnergy;
            }, (value) -> {
            });
            builder.add(2, () -> {
                return this.enabled ? 1 : 0;
            }, (value) -> {
            });
            builder.add(3, () -> {
                return this.overloaded ? 1 : 0;
            }, (value) -> {
            });
            builder.add(4, () -> {
                return this.isNodePowered() ? 1 : 0;
            }, (value) -> {
            });
            builder.add(5, () -> {
                return this.nodeCount;
            }, (value) -> {
            });
        });
        this.audioPosition = pos.getCenter().add(0.0, -0.375, 0.0);
    }

    public int getNodeMaximumConnections() {
        return Config.SERVER.electricity.maximumLinksPerElectricityGenerator.get();
    }

    @Override
    public boolean isMatchingContainerMenu(AbstractContainerMenu abstractContainerMenu) {
        return false;
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
    public void togglePower() {
        this.enabled = !this.enabled;
        if (this.enabled) {
            NodeSearchResult result = this.searchNodeNetwork(false);
            if (!result.overloaded()) {
                if (this.overloaded) {
                    this.overloaded = false;
                }
            } else {
                this.enabled = false;
            }
        }

        this.setChanged();
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
    public int retrieveEnergy(boolean b) {
        int x = getBlockPos().getX();
        int y = getBlockPos().getY();
        int z = getBlockPos().getZ();

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
                this.energy += 20;
                BlockEntity _ent = level.getBlockEntity(new BlockPos(x, y, z));
                int _amount = 1000;
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));


                return this.energy;
            }
        }


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
        return this.enabled && !this.isNodeOverloaded();
    }

    @Override
    public boolean isNodePowered() {
        BlockState state = this.getBlockState();
        return state.hasProperty(ElectricityGeneratorBlock.POWERED) ? state.getValue(ElectricityGeneratorBlock.POWERED) : false;
    }

    @Override
    public void setNodePowered(boolean powered) {
        BlockState state = this.getBlockState();
        if (state.hasProperty(ElectricityGeneratorBlock.POWERED)) {
            this.level.setBlock(this.worldPosition, state.setValue(ElectricityGeneratorBlock.POWERED, powered), 3);
        }
    }

    @Override
    protected Component getDefaultName() {
        return Utils.translation("container", "electricity_generator", new Object[0]);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        if (compound.get("energyStorage") instanceof IntTag intTag)
            energyStorage.deserializeNBT(intTag);

        if (compound.contains("Enabled", 1)) {
            this.enabled = compound.getBoolean("Enabled");
        }
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        compound.put("energyStorage", energyStorage.serializeNBT());
        compound.putBoolean("Enabled", this.enabled);
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        if (!this.enabled) {
            this.searchNodeNetwork(false);
        }

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
}
