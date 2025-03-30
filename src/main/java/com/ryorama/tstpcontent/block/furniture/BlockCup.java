package com.ryorama.tstpcontent.block.furniture;

import com.ryorama.tstpcontent.blockentity.furniture.BlockEntityCup;
import com.ryorama.tstpcontent.init.TstpContentModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class BlockCup extends Block implements EntityBlock {

    private static final VoxelShape BOUNDING_BOX = Shapes.box(5 * 0.0625, 0.0, 5 * 0.0625, 11 * 0.0625, 7.5 * 0.0625, 11 * 0.0625);

    public BlockCup() {
        super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.1f).noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player.isCrouching() && !player.isCreative() && player.getFoodData().needsFood()) {
            if (level.getBlockEntity(pos) instanceof BlockEntityCup) {
                BlockEntityCup tileEntityCup = (BlockEntityCup) level.getBlockEntity(pos);
                ItemStack cup = tileEntityCup.getDrink();
                if (cup != null && cup.hasTag()) {
                    tileEntityCup.clear();
                    if (!level.isClientSide()) {
                        int heal = cup.getTag().getInt("HealAmount");
                        player.getFoodData().eat(heal, 0.5F);
                    } else {
                        level.playSound(player, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS, 1.0F, 1.0F);
                        level.playSound(player, player.getOnPos(), SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }
                    return InteractionResult.PASS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState blockState, @Nullable LivingEntity placer, ItemStack stack) {
        if (stack.hasTag()) {
            CompoundTag nbt = stack.getTag();
            if (nbt.contains("Colour")) {
                int[] rgb = nbt.getIntArray("Colour");
                BlockEntityCup tileEntityCup = (BlockEntityCup) level.getBlockEntity(pos);
                tileEntityCup.setColour(rgb);
                tileEntityCup.setItem(stack);
            }
        }
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
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityCup(pos, state);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if (blockEntity instanceof BlockEntityCup) {
            BlockEntityCup tileEntityCup = (BlockEntityCup) blockEntity;
            ItemEntity item = new ItemEntity(level, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, tileEntityCup.getDrink() != null ? tileEntityCup.getDrink().copy() : new ItemStack(TstpContentModItems.CUP.get()));
            item.setDefaultPickUpDelay();
            level.addFreshEntity(item);
        } else {
            ItemEntity item = new ItemEntity(level, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, new ItemStack(TstpContentModItems.CUP.get()));
            item.setDefaultPickUpDelay();
            level.addFreshEntity(item);
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        {
            if (blockGetter.getBlockEntity(pos) instanceof BlockEntityCup) {
                BlockEntityCup tileEntityCup = (BlockEntityCup) blockGetter.getBlockEntity(pos);
                if (tileEntityCup.getDrink() != null) {
                    return tileEntityCup.getDrink().copy();
                }
            }
            return new ItemStack(TstpContentModItems.CUP.get());
        }
    }
}
