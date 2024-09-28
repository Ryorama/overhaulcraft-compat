package com.ryorama.tstpcontent.block.cuisine_delight;

import com.ryorama.tstpcontent.block.cuisine_delight.entity.DarkPotBlockEntity;
import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import com.ryorama.tstpcontent.item.cuisinedelight.DarkPotItem;
import dev.xkmc.cuisinedelight.content.logic.IngredientConfig;
import dev.xkmc.cuisinedelight.init.data.CDConfig;
import dev.xkmc.cuisinedelight.init.data.LangData;
import dev.xkmc.l2modularblock.impl.BlockEntityBlockMethodImpl;
import dev.xkmc.l2modularblock.mult.CreateBlockStateBlockMethod;
import dev.xkmc.l2modularblock.mult.DefaultStateBlockMethod;
import dev.xkmc.l2modularblock.mult.OnClickBlockMethod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class DarkPotBlock implements DefaultStateBlockMethod, CreateBlockStateBlockMethod, OnClickBlockMethod {

    public static final BlockEntityBlockMethodImpl<DarkPotBlockEntity> ENTITY =
            new BlockEntityBlockMethodImpl<>(TstpContentModBlocks.BE_DARK_POT, DarkPotBlockEntity.class);

    public static final DarkPotBlock STATE = new DarkPotBlock();
    public static final DarkPotTrayMethod TRAY = new DarkPotTrayMethod();

    protected static final BooleanProperty[] DIRE = {
            BlockStateProperties.SOUTH,
            BlockStateProperties.WEST,
            BlockStateProperties.NORTH,
            BlockStateProperties.EAST
    };

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRE);
    }

    @Override
    public BlockState getDefaultState(BlockState state) {
        for (var e : DIRE) {
            state = state.setValue(e, false);
        }
        return state;
    }

    @Override
    public InteractionResult onClick(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof DarkPotBlockEntity be) {
            ItemStack handStack = player.getItemInHand(hand);
            var config = IngredientConfig.get().getEntry(handStack);
            if (!be.canCook()) {
                if (player instanceof ServerPlayer serverPlayer) {
                    serverPlayer.sendSystemMessage(LangData.MSG_NO_HEAT.get(), true);
                }
                return InteractionResult.FAIL;
            }
            if (be.cookingData.contents.size() >= CDConfig.COMMON.maxIngredient.get()) {
                if (!level.isClientSide()) {
                    ((ServerPlayer) player).sendSystemMessage(LangData.MSG_FULL.get(), true);
                }
                return InteractionResult.FAIL;
            }
            if (!level.isClientSide) {
                int count = 1 + be.baseItem.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY);
                if (be.slowCook()) {
                    be.cookingData.setSpeed(0.5f);
                }
                ItemStack add = handStack.split(count);
                be.cookingData.addItem(add, level.getGameTime());
                ItemStack remain = add.getCraftingRemainingItem();
                remain.setCount(add.getCount());
                player.getInventory().placeItemBackInInventory(remain);
                be.sync();
            } else {
                DarkPotItem.playSound(player, level, ModSounds.BLOCK_SKILLET_ADD_FOOD.get());
            }
        }




        Direction dire = hit.getDirection();
        if (dire.getAxis() == Direction.Axis.Y) return InteractionResult.PASS;
        ItemStack stack = player.getItemInHand(hand);
        if (!stack.is(TstpContentModBlocks.DARK_POT.asItem())) return InteractionResult.PASS;
        int ni = findDist(level, pos, state, dire.getCounterClockWise());
        int pi = findDist(level, pos, state, dire.getClockWise());
        int total = ni + pi + 1;
        if (stack.getCount() < total) return InteractionResult.FAIL;
        if (!checkPlaceable(level, pos, dire, ni, pi)) return InteractionResult.FAIL;
        var xpos = pos.mutable().move(dire.getCounterClockWise(), ni);
        for (int i = -ni; i <= pi; i++) {
            level.setBlockAndUpdate(pos, level.getBlockState(pos).setValue(DIRE[dire.get2DDataValue()], true));
            BlockState target = state.getBlock().defaultBlockState().setValue(DIRE[dire.getOpposite().get2DDataValue()], true);
            if (i != -ni) {
                target = target.setValue(DIRE[dire.getCounterClockWise().get2DDataValue()], true);
            }
            if (i != pi) {
                target = target.setValue(DIRE[dire.getClockWise().get2DDataValue()], true);
            }
            level.setBlockAndUpdate(pos.relative(dire), target);
            xpos.move(dire.getClockWise());
        }
        return InteractionResult.SUCCESS;
    }

    private static int findDist(Level level, BlockPos pos, BlockState state, Direction dire) {
        int ans = 0;
        var xpos = pos.mutable();
        BlockState xstate = state;
        while (xstate.is(state.getBlock()) && xstate.getValue(DIRE[dire.get2DDataValue()])) {
            ans++;
            xpos.move(dire);
            xstate = level.getBlockState(xpos);
        }
        return ans;
    }

    private static boolean checkPlaceable(Level level, BlockPos pos, Direction dire, int ni, int pi) {
        var xpos = pos.mutable().move(dire).move(dire.getCounterClockWise(), ni);
        for (int i = -ni; i <= pi; i++) {
            if (!level.getBlockState(xpos).canBeReplaced())
                return false;
            xpos.move(dire.getClockWise());
        }
        return true;
    }

}