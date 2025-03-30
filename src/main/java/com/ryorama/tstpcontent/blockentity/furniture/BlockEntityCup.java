package com.ryorama.tstpcontent.blockentity.furniture;

import com.ryorama.tstpcontent.client.ISimpleInventory;
import com.ryorama.tstpcontent.init.TstpContentModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityCup extends BlockEntity implements ISimpleInventory
{
    private ItemStack item = null;
    public int red, green, blue;

    public BlockEntityCup(BlockPos blockPos, BlockState blockState) {
        super(TstpContentModBlockEntities.CUP.get(), blockPos, blockState);
    }

    public void setItem(ItemStack item)
    {
        this.item = item.copy();
    }

    public void setColour(int[] rgb)
    {
        this.red = rgb[0];
        this.green = rgb[1];
        this.blue = rgb[2];
    }

    public ItemStack getDrink()
    {
        return item;
    }

    @Override
    public void load(CompoundTag tagCompound)
    {
        super.load(tagCompound);
        if(tagCompound.contains("Item", 9))
        {
            ListTag tagList = (ListTag) tagCompound.get("Item");
            if(tagList.size() > 0)
            {
                this.item = new ItemStack(tagList.getCompound(0));
            }
        }
        this.red = tagCompound.getInt("Red");
        this.green = tagCompound.getInt("Green");
        this.blue = tagCompound.getInt("Blue");
    }

    @Override
    public void saveAdditional(CompoundTag tagCompound)
    {
        super.saveAdditional(tagCompound);
        ListTag tagList = new ListTag();
        CompoundTag nbt = new CompoundTag();
        if(item != null)
        {
            item.save(nbt);
            tagList.add(nbt);
        }
        tagCompound.put("Item", tagList);
        tagCompound.putInt("Red", red);
        tagCompound.putInt("Green", green);
        tagCompound.putInt("Blue", blue);
    }

    @Override
    public int getSize()
    {
        return 1;
    }

    @Override
    public ItemStack getItem(int i)
    {
        return getDrink();
    }

    @Override
    public void clear()
    {
        red = 0;
        green = 0;
        blue = 0;
        item = null;
    }
}