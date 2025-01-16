package com.ryorama.tstpcontent.utils;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TstpTags {
    //Randomium
    public static final TagKey<Block> RANDOMIUM_ORE = BlockTags.create(Reference.ore("randomium"));
    public static final TagKey<Item> RANDOMIUM_ORE_ITEM = ItemTags.create(Reference.ore("randomium"));

    //Lithium
    public static final TagKey<Block> LITHIUM_ORE = BlockTags.create(Reference.ore("lithium"));
    public static final TagKey<Item> LITHIUM_ORE_ITEM = ItemTags.create(Reference.ore("lithium"));

    //Sulfur
    public static final TagKey<Block> SULFUR_ORE = BlockTags.create(Reference.ore("sulfur"));
    public static final TagKey<Item> SULFUR_ORE_ITEM = ItemTags.create(Reference.ore("sulfur"));


    //Niter
    public static final TagKey<Block> NITER_ORE = BlockTags.create(Reference.ore("niter"));
    public static final TagKey<Item> NITER_ORE_ITEM = ItemTags.create(Reference.ore("niter"));

    //Draconium
    public static final TagKey<Block> DRACONIUM_ORE = BlockTags.create(Reference.ore("draconium"));
    public static final TagKey<Item> DRACONIUM_ORE_ITEM = ItemTags.create(Reference.ore("draconium"));
}
