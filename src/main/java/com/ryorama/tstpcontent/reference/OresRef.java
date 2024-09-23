package com.ryorama.tstpcontent.reference;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class OresRef {
    public static final TagKey<Block> RANDOMIUM = makeWrapperTag("ores/randomium");

    private static TagKey<Block> makeWrapperTag(String tagname) {
        return BlockTags.create(new ResourceLocation("forge", tagname));
    }
}
