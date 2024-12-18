package com.ryorama.tstpcontent.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagsRef {
    public static final TagKey<Block> RANDOMIUM = makeWrapperTagBlock("ores/randomium");

    public static final TagKey<Item> URANIUM_ROD = makeWrapperTagItem("");

    private static TagKey<Block> makeWrapperTagBlock(String tagname) {
        return BlockTags.create(new ResourceLocation("forge", tagname));
    }

    private static TagKey<Item> makeWrapperTagItem(String tagname) {
        return ItemTags.create(new ResourceLocation("forge", tagname));
    }
}
