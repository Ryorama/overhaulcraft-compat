package com.ryorama.tstpcontent.block;

import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import com.starfish_studios.hamsters.block.HamsterWheelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import java.util.concurrent.atomic.AtomicInteger;

public class HamsterWheelGeneratorBlock extends HamsterWheelBlock {
    public HamsterWheelGeneratorBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        BlockEntity _ent = world.getBlockEntity(pos);
        BlockEntity _bottomEnt = world.getBlockEntity(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
        int _amount = 10;

        if (_ent != null && _bottomEnt != null) {
            if (new Object() {
                public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
                    AtomicInteger _retval = new AtomicInteger(0);
                    BlockEntity _ent = level.getBlockEntity(pos);
                    if (_ent != null)
                        _ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
                    return _retval.get();
                }
            }.extractEnergySimulate(world, pos, 10) >= 10) {
                _ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> capability.extractEnergy(_amount, false));
                _bottomEnt.getCapability(ForgeCapabilities.ENERGY, Direction.UP).ifPresent(capability -> capability.receiveEnergy(_amount, false));
            }
        }

        if (isOccupied(world, pos)) {
            if (_ent != null) {
                _ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> capability.receiveEnergy(_amount, false));
            }
        }

        world.scheduleTick(pos, this, 20);
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        world.scheduleTick(pos, this, 20);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return TstpContentModBlockEntities.HAMSTER_WHEEL_GENERATOR.get().create(pos, state);
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return true;
    }
}