package com.ryorama.overhaulcraft.datagen.server;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftOreBlocks;
import com.ryorama.overhaulcraft.utils.TstpTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class OverhaulCraftItemTags extends ItemTagsProvider {
    public OverhaulCraftItemTags(PackOutput packOutPut, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, ExistingFileHelper existingFileHelper) {
        super(packOutPut, lookupProvider, tagLookup, OverhaulCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        OverhaulCraftOreBlocks.ITEM_REGISTRY.getEntries().forEach(itemDeferredHolder -> addOreTags(itemDeferredHolder.get()));
    }

    private void addOreTags(Item item) {
        String ore = item.getDescription().toString();
        if(ore.contains("aluminum")) {
            tag(ItemTags.create(ResourceLocation.parse("aluminum"))).add(item);
        }
        if (ore.contains("fluorite")) {
            tag(ItemTags.create(ResourceLocation.parse("fluorite"))).add(item);
        }
        if(ore.contains("lead")) {
            tag(ItemTags.create(ResourceLocation.parse("lead"))).add(item);
        }
        if(ore.contains("nickel")) {
            tag(ItemTags.create(ResourceLocation.parse("nickel"))).add(item);
        }
        if(ore.contains("osmium")) {
            tag(ItemTags.create(ResourceLocation.parse("osmium"))).add(item);
        }
        if(ore.contains("platinum")) {
            tag(ItemTags.create(ResourceLocation.parse("platinum"))).add(item);
        }
        if(ore.contains("silver")) {
            tag(ItemTags.create(ResourceLocation.parse("silver"))).add(item);
        }
        if(ore.contains("tin_")) {
            tag(ItemTags.create(ResourceLocation.parse("tin"))).add(item);
        }
        if(ore.contains("uranium")) {
            tag(ItemTags.create(ResourceLocation.parse("uranium"))).add(item);
        }
        if(ore.contains("zinc")) {
            tag(ItemTags.create(ResourceLocation.parse("zinc"))).add(item);
        }
        if(ore.contains("coal")) {
            tag(ItemTags.COAL_ORES).add(item);
        }
        if(ore.contains("copper")) {
            tag(ItemTags.COPPER_ORES).add(item);
        }
        if(ore.contains("diamond")) {
            tag(ItemTags.DIAMOND_ORES).add(item);
        }
        if(ore.contains("emerald")) {
            tag(ItemTags.EMERALD_ORES).add(item);
        }
        if(ore.contains("gold")) {
            tag(ItemTags.GOLD_ORES).add(item);
        }
        if(ore.contains("iron")) {
            tag(ItemTags.IRON_ORES).add(item);
        }
        if(ore.contains("lapis")) {
            tag(ItemTags.LAPIS_ORES).add(item);
        }
        if(ore.contains("redstone")) {
            tag(ItemTags.REDSTONE_ORES).add(item);
        }
        if (ore.contains("randomium")) {
            tag(ItemTags.create(ResourceLocation.parse("randomium"))).add(item);
        }
        if (ore.contains("ruby")) {
            tag(ItemTags.create(ResourceLocation.parse("ruby"))).add(item);
        }
        if (ore.contains("sapphire")) {
            tag(ItemTags.create(ResourceLocation.parse("sapphire"))).add(item);
        }
        if (ore.contains("amethyst")) {
            tag(ItemTags.create(ResourceLocation.parse("amethyst"))).add(item);
        }
        if (ore.contains("draconium")) {
            tag(TstpTags.DRACONIUM_ORE_ITEM);
        }
    }
}