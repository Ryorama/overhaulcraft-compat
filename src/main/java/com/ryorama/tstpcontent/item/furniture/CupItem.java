package com.ryorama.tstpcontent.item.furniture;

import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import com.ryorama.tstpcontent.init.TstpContentModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.*;

public class CupItem extends Item
{
    private boolean hasLiquid = false;

    public CupItem(boolean hasLiquid)
    {
        super(new Properties().stacksTo(hasLiquid ? 1 : 64));
        this.hasLiquid = hasLiquid;
    }

    @Override
    public Component getName(ItemStack stack)
    {
        if(stack.hasTag())
        {
            CompoundTag nbt = stack.getTag();
            if(nbt.contains("Name", 8))
            {
                return Component.literal(nbt.getString("Name"));
            }
        }
        return super.getName(stack);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity)
    {
        if(entity instanceof Player)
        {
            Player player = (Player) entity;
            if(hasLiquid)
            {
                if (player.getFoodData().needsFood()) {
                    int heal = stack.getTag().getInt("HealAmount");
                    player.getFoodData().eat(heal, 0.5F);
                    return new ItemStack(TstpContentModItems.CUP.get());
                }
            }
        }
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack cup)
    {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack)
    {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext)
    {
        Level level = useOnContext.getLevel();
        Player player = useOnContext.getPlayer();
        InteractionHand hand = useOnContext.getHand();
        BlockPos pos = player.blockPosition();
        Direction facing = useOnContext.getHorizontalDirection();
        Vec3 clickedLocation = useOnContext.getClickLocation();

        BlockState blockState = level.getBlockState(player.blockPosition());
        Block block = blockState.getBlock();

        if(!block.canBeReplaced(blockState, new BlockPlaceContext(useOnContext)))
        {
            pos = pos.offset(new Vec3i((int) clickedLocation.x, (int) clickedLocation.y, (int) clickedLocation.z));
        }

        ItemStack itemstack = player.getItemInHand(hand);

        if(!itemstack.isEmpty() && player.mayUseItemAt(pos, facing, itemstack) && level.isUnobstructed(blockState, pos, CollisionContext.empty()))
        {
            BlockState blockState1 = TstpContentModBlocks.CUP.get().getStateForPlacement(new BlockPlaceContext(player, hand, player.getItemInHand(hand), new BlockHitResult(clickedLocation, facing, useOnContext.getClickedPos(), false)));

            if(placeBlockAt(itemstack, player, level, pos, facing, (float) clickedLocation.x, (float) clickedLocation.y, (float) clickedLocation.z, blockState1))
            {
                SoundType soundtype = level.getBlockState(pos).getBlock().getSoundType(level.getBlockState(pos), level, pos, player);
                level.playSound(player, pos, soundtype.getPlaceSound(), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                itemstack.shrink(1);
            }

            return InteractionResult.SUCCESS;
        }
        else
        {
            return InteractionResult.FAIL;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public int getColorFromCompound(ItemStack cup)
    {
        if(cup.hasTag())
        {
            if(cup.getTag().contains("Colour"))
            {
                int[] colour = cup.getTag().getIntArray("Colour");
                Color color = new Color(colour[0], colour[1], colour[2]);
                return color.getRGB();
            }
        }
        return 16777215;
    }

    public boolean placeBlockAt(ItemStack stack, Player player, Level world, BlockPos pos, Direction side, float hitX, float hitY, float hitZ, BlockState newState)
    {
        if(!world.setBlock(pos, newState, 11)) return false;

        BlockState state = world.getBlockState(pos);
        if(state.getBlock() == TstpContentModBlocks.CUP.get()) {
            if (stack.getTag() != null) {
                BlockItem.setBlockEntityData(stack, TstpContentModBlockEntities.CUP.get(), stack.getTag());
            }
        }

        return true;
    }
}