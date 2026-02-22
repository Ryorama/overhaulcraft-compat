package com.ryorama.overhaulcraft.datagen.server;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TstpItemTags extends ItemTagsProvider {
    public TstpItemTags(PackOutput packOutPut, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, ExistingFileHelper existingFileHelper) {
        super(packOutPut, lookupProvider, tagLookup, OverhaulCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getKnownItems().forEach(this::addOreTags);
    }

    private void addOreTags(Item item) {
        String oretype = item.getDescription().toString();
        if(oretype.contains("aluminum")) {
            tag(ItemTags.create(ResourceLocation.parse("aluminum"))).add(item);
        }
        if(oretype.contains("lead")) {
            tag(ItemTags.create(ResourceLocation.parse("lead"))).add(item);
        }
        if(oretype.contains("nickel")) {
            tag(ItemTags.create(ResourceLocation.parse("nickel"))).add(item);
        }
        if(oretype.contains("osmium")) {
            tag(ItemTags.create(ResourceLocation.parse("osmium"))).add(item);
        }
        if(oretype.contains("platinum")) {
            tag(ItemTags.create(ResourceLocation.parse("platinum"))).add(item);
        }
        if(oretype.contains("silver")) {
            tag(ItemTags.create(ResourceLocation.parse("silver"))).add(item);
        }
        if(oretype.contains("tin_")) {
            tag(ItemTags.create(ResourceLocation.parse("tin"))).add(item);
        }
        if(oretype.contains("uranium")) {
            tag(ItemTags.create(ResourceLocation.parse("uranium"))).add(item);
        }
        if(oretype.contains("zinc")) {
            tag(ItemTags.create(ResourceLocation.parse("zinc"))).add(item);
        }
        if(oretype.contains("coal")) {
            tag(ItemTags.COAL_ORES).add(item);
        }
        if(oretype.contains("copper")) {
            tag(ItemTags.COPPER_ORES).add(item);
        }
        if(oretype.contains("diamond")) {
            tag(ItemTags.DIAMOND_ORES).add(item);
        }
        if(oretype.contains("emerald")) {
            tag(ItemTags.EMERALD_ORES).add(item);
        }
        if(oretype.contains("gold")) {
            tag(ItemTags.GOLD_ORES).add(item);
        }
        if(oretype.contains("iron")) {
            tag(ItemTags.IRON_ORES).add(item);
        }
        if(oretype.contains("lapis")) {
            tag(ItemTags.LAPIS_ORES).add(item);
        }
        if(oretype.contains("redstone")) {
            tag(ItemTags.REDSTONE_ORES).add(item);
        }
        if (oretype.contains("randomium")) {
            tag(ItemTags.create(ResourceLocation.parse("randomium"))).add(item);
        }
    }

    protected List<Item> getKnownItems()
    {
        return OverhaulCraftItems.REGISTRY.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toList());
    }
}