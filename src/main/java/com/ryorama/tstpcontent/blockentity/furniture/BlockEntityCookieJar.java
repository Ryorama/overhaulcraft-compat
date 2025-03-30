package com.ryorama.tstpcontent.blockentity.furniture;

import com.ryorama.tstpcontent.block.furniture.BlockCookieJar;
import com.ryorama.tstpcontent.client.ISimpleInventory;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityCookieJar extends BlockEntity implements ISimpleInventory
{
    public BlockEntityCookieJar(BlockPos blockPos, BlockState blockState) {
        super(TstpContentModBlockEntities.COOKIE_JAR.get(), blockPos, blockState);
    }

    @Override
    public int getSize()
    {
        return getBlockState().getValue(BlockCookieJar.COOKIE_COUNT);
    }

    @Override
    public ItemStack getItem(int i)
    {
        return new ItemStack(Items.COOKIE);
    }

    @Override
    public void clear()
    {
    }
}