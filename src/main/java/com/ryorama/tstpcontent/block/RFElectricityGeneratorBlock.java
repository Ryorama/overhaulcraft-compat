package com.ryorama.tstpcontent.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.furniture.refurbished.block.FurnitureHorizontalEntityBlock;
import com.mrcrayfish.furniture.refurbished.block.MetalType;
import com.mrcrayfish.furniture.refurbished.blockentity.ElectricityGeneratorBlockEntity;
import com.mrcrayfish.furniture.refurbished.core.ModBlockEntities;
import com.mrcrayfish.furniture.refurbished.data.tag.BlockTagSupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RFElectricityGeneratorBlock extends FurnitureHorizontalEntityBlock implements BlockTagSupplier {
    private final MetalType type;

    public RFElectricityGeneratorBlock(MetalType type, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(POWERED, false));
        this.type = type;
    }

    public MetalType getMetalType() {
        return this.type;
    }

    @Override
    protected Map<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> immutableList) {
        return ImmutableMap.copyOf((Map)immutableList.stream().collect(Collectors.toMap((state) -> {
            return immutableList;
        }, (o) -> {
            return Shapes.block();
        })));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{POWERED});
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ElectricityGeneratorBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? createTicker(type, ModBlockEntities.ELECTRICITY_GENERATOR.get(), ElectricityGeneratorBlockEntity::clientTick) : null;
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        if ((Boolean)state.getValue(POWERED)) {
            Direction direction = (Direction)state.getValue(DIRECTION);
            Vec3 vec = (new Vec3(3.5, 16.0, 3.5)).scale(0.0625);
            vec = vec.yRot((float)direction.get2DDataValue() * -1.5707964F - 1.5707964F);
            vec = vec.add((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()).add(0.5, 0.0, 0.5);
            level.addParticle(ParticleTypes.SMOKE, vec.x, vec.y, vec.z, 0.0, 0.0, 0.0);
            level.addParticle(ParticleTypes.SMOKE, vec.x, vec.y, vec.z, 0.0, 0.0, 0.0);
        }

    }

    @Override
    public List<TagKey<Block>> getTags() {
        return List.of(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    }
}
