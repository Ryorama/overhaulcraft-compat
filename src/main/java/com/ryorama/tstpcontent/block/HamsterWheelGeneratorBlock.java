package com.ryorama.tstpcontent.block;

import com.ryorama.tstpcontent.block.entity.HamsterWheelGeneratorBlockEntity;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import com.starfish_studios.hamsters.block.HamsterWheelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;

public class HamsterWheelGeneratorBlock extends HamsterWheelBlock {
    public HamsterWheelGeneratorBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(0.6F).noOcclusion().isSuffocating((state, world, pos) -> false));
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> entityType) {
        return createTickerHelper(entityType, TstpContentModBlockEntities.HAMSTER_WHEEL_GENERATOR.get(), HamsterWheelGeneratorBlockEntity::tick);
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
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