package com.ryorama.tstpcontent.utils;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TstpTags {
    public static final TagKey<Block> RANDOMIUM_ORE = BlockTags.create(Reference.ore("randomium"));
    public static final TagKey<Item> RANDOMIUM_ORE_ITEM = ItemTags.create(Reference.ore("randomium"));

}
