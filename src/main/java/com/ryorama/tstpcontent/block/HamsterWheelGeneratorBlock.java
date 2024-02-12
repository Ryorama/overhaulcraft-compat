package com.ryorama.tstpcontent.block;

import com.ryorama.tstpcontent.block.entity.HVACBlockBlockEntity;
import com.ryorama.tstpcontent.block.entity.HamsterWheelGeneratorBlockEntity;
import com.starfish_studios.hamsters.block.HamsterWheelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class HamsterWheelGeneratorBlock extends HamsterWheelBlock {
    public HamsterWheelGeneratorBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(0.6F).noOcclusion().isSuffocating((state, world, pos) -> false));
    }

    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if (isOccupied(world, pos)) {
            BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
            int _amount = 10;
            if (_ent != null) {
                _ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> capability.receiveEnergy(_amount, false));
            }
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HamsterWheelGeneratorBlockEntity(pos, state);
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }
}
