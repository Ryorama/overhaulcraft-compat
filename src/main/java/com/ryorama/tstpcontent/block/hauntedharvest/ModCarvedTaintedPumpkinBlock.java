/*
package com.ryorama.tstpcontent.block.hauntedharvest;

import net.mehvahdjukaar.hauntedharvest.blocks.ModCarvedPumpkinBlock;
import net.mehvahdjukaar.hauntedharvest.blocks.PumpkinType;
import net.mehvahdjukaar.hauntedharvest.reg.ModTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;

import java.util.function.Predicate;

public class ModCarvedTaintedPumpkinBlock extends CarvedPumpkinBlock implements EntityBlock {
    private final PumpkinType type;
    private static final Predicate<BlockState> PUMPKINS_PREDICATE = (blockState) -> {
        return blockState != null && blockState.getBlock() instanceof ModCarvedTaintedPumpkinBlock;
    };

    public ModCarvedTaintedPumpkinBlock(BlockBehaviour.Properties properties, PumpkinType type) {
        super(properties);
        this.type = type;
    }

    public PumpkinType getType(BlockState state) {
        return this.type;
    }

    public static Vector2i getHitSubPixel(BlockHitResult hit) {
        Vec3 pos = hit.getLocation();
        Vec3 v = pos.yRot((float)((double)hit.getDirection().toYRot() * Math.PI / 180.0));
        double fx = v.x % 1.0 * 16.0;
        if (fx < 0.0) {
            fx += 16.0;
        }

        int x = Mth.clamp((int)fx, -15, 15);
        int y = 15 - (int)Mth.clamp(Math.abs(v.y % 1.0 * 16.0), 0.0, 15.0);
        if (pos.y < 0.0) {
            y = 15 - y;
        }

        return new Vector2i(x, y);
    }

    public static boolean isCarverItem(ItemStack stack) {
        return stack.is(ModTags.CARVERS) || stack.getItem() instanceof SwordItem;
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        BlockEntity var8 = level.getBlockEntity(pos);
        if (var8 instanceof ModCarvedTaintedPumpkinBlockTile te) {
            if (te.isAccessibleBy(player) && !te.isWaxed()) {
                ItemStack stack = player.getItemInHand(handIn);
                Item i = stack.getItem();
                if (i instanceof HoneycombItem) {
                    if (player instanceof ServerPlayer) {
                        ServerPlayer serverPlayer = (ServerPlayer)player;
                        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
                    }

                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }

                    level.levelEvent(player, 3003, pos, 0);
                    te.setWaxed(true);
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }

                ModCarvedPumpkinBlock.CarveMode mode = te.getCarveMode();
                if (mode != ModCarvedPumpkinBlock.CarveMode.NONE) {
                    if (hit.getDirection() == state.getValue(FACING) && mode.canManualDraw() && isCarverItem(stack)) {
                        Vector2i v = getHitSubPixel(hit);
                        int x = v.x();
                        int y = v.y();
                        te.setPixel(x, y, !te.getPixel(x, y));
                        te.setChanged();
                        return InteractionResult.sidedSuccess(level.isClientSide);
                    }

                    if (!level.isClientSide && mode.canOpenGui()) {
                        te.sendOpenGuiPacket(level, pos, player);
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }

        return InteractionResult.PASS;
    }

    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModCarvedTaintedPumpkinBlockTile(pPos, pState);
    }

    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        BlockEntity var5 = level.getBlockEntity(pos);
        if (var5 instanceof ModCarvedTaintedPumpkinBlockTile te) {
            return te.getItemWithNBT();
        } else {
            return super.getCloneItemStack(level, pos, state);
        }
    }
}
 */