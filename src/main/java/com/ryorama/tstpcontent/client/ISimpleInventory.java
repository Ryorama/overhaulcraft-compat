package com.ryorama.tstpcontent.client;

import net.minecraft.world.item.ItemStack;

public interface ISimpleInventory
{
    int getSize();

    ItemStack getItem(int i);

    void clear();
}