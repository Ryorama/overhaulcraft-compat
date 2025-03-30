package com.ryorama.tstpcontent.block.furniture;

import com.ryorama.tstpcontent.blockentity.furniture.BlockEntityCookieJar;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class BlockCookieJar extends Block implements EntityBlock
{
    public static final IntegerProperty COOKIE_COUNT = IntegerProperty.create("cookie_count", 0, 6);

    private static final VoxelShape BOUNDING_BOX = Shapes.box(4 * 0.0625, 0.0, 4 * 0.0625, 12 * 0.0625, 0.65, 12 * 0.0625);

    public BlockCookieJar()
    {
        super(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.GLASS).noOcclusion());
        this.registerDefaultState(getStateDefinition().any().setValue(COOKIE_COUNT, 0));
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack stack)
    {
        if(!level.isClientSide())
        {
            for(int i = 0; i < blockState.getValue(COOKIE_COUNT); i++)
            {
                ItemEntity cookie = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, new ItemStack(Items.COOKIE));
                level.addFreshEntity(cookie);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)    {
        ItemStack heldItem = player.getItemInHand(hand);
        int metadata = state.getValue(COOKIE_COUNT);
        if(!heldItem.isEmpty())
        {
            if(heldItem.getItem() == Items.COOKIE && metadata < 6)
            {
                level.setBlock(pos, state.setValue(COOKIE_COUNT, metadata + 1), 2);
                heldItem.shrink(1);
                return InteractionResult.PASS;
            }
        }
        if(metadata > 0)
        {
            level.setBlock(pos, state.setValue(COOKIE_COUNT, metadata - 1), 2);
            if(!level.isClientSide)
            {
                ItemEntity var14 = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, new ItemStack(Items.COOKIE));
                level.addFreshEntity(var14);
            }
            level.sendBlockUpdated(pos, state, state, 3);
            return InteractionResult.PASS;
        }
        return InteractionResult.PASS;
    }

    public static VoxelShape box(double p_49797_, double p_49798_, double p_49799_, double p_49800_, double p_49801_, double p_49802_) {
        return BOUNDING_BOX;
    }

    public VoxelShape getShape(BlockGetter p_60652_, BlockPos p_60653_, CollisionContext p_60654_) {
        return BOUNDING_BOX;
    }

    public VoxelShape getCollisionShape(BlockGetter p_60813_, BlockPos p_60814_) {
        return BOUNDING_BOX;
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new BlockEntityCookieJar(pos, state);
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        BlockEntityCookieJar jar = (BlockEntityCookieJar) level.getBlockEntity(pos);
        return jar.getSize();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(COOKIE_COUNT);
    }

    /*
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, COOKIE_COUNT);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    */
}