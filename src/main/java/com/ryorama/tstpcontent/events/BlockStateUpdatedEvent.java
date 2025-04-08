package com.ryorama.tstpcontent.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.Event;

public class BlockStateUpdatedEvent extends Event {
    private final Level level;
    private final BlockState blockState;

    public BlockPos blockPos;
    public BlockStateUpdatedEvent(Level level, BlockState blockState, BlockPos blockPos) {
        this.level = level;
        this.blockState = blockState;
        this.blockPos = blockPos;
    }

    public BlockState getBlockState() {
        return blockState != null ? blockState : Blocks.AIR.defaultBlockState();
    }

    public Level getLevel() {
        return level;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }
}
