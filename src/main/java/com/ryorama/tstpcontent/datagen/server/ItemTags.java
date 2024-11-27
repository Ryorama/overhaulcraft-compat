package com.ryorama.tstpcontent.datagen.server;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.init.TstpContentModItems;
import com.ryorama.tstpcontent.utils.TstpTags;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput packOutPut, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, ExistingFileHelper existingFileHelper) {
        super(packOutPut, lookupProvider, tagLookup, TstpContentMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getKnownItems().forEach(this::addOreTags);
    }

    private void addOreTags(Item item) {
        String oretype = item.getDescription().toString();
        if(oretype.contains("aluminum")) {
            tag(ItemTagRegistry.ALUMINUM_ORE_ITEM).add(item);
        }
        if(oretype.contains("lead")) {
            tag(ItemTagRegistry.LEAD_ORE_ITEM).add(item);
        }
        if(oretype.contains("nickel")) {
            tag(ItemTagRegistry.NICKEL_ORE_ITEM).add(item);
        }
        if(oretype.contains("osmium")) {
            tag(ItemTagRegistry.OSMIUM_ORE_ITEM).add(item);
        }
        if(oretype.contains("platinum")) {
            tag(ItemTagRegistry.PLATINUM_ORE_ITEM).add(item);
        }
        if(oretype.contains("silver")) {
            tag(ItemTagRegistry.SILVER_ORE_ITEM).add(item);
        }
        if(oretype.contains("tin_")) {
            tag(ItemTagRegistry.TIN_ORE_ITEM).add(item);
        }
        if(oretype.contains("uranium")) {
            tag(ItemTagRegistry.URANIUM_ORE_ITEM).add(item);
        }
        if(oretype.contains("zinc")) {
            tag(ItemTagRegistry.ZINC_ORE_ITEM).add(item);
        }
        if(oretype.contains("coal")) {
            tag(ItemTagRegistry.COAL_ORE_ITEM).add(item);
        }
        if(oretype.contains("copper")) {
            tag(ItemTagRegistry.COPPER_ORE_ITEM).add(item);
        }
        if(oretype.contains("diamond")) {
            tag(ItemTagRegistry.DIAMOND_ORE_ITEM).add(item);
        }
        if(oretype.contains("emerald")) {
            tag(ItemTagRegistry.EMERALD_ORE_ITEM).add(item);
        }
        if(oretype.contains("gold")) {
            tag(ItemTagRegistry.GOLD_ORE_ITEM).add(item);
        }
        if(oretype.contains("iron")) {
            tag(ItemTagRegistry.IRON_ORE_ITEM).add(item);
        }
        if(oretype.contains("lapis")) {
            tag(ItemTagRegistry.LAPIS_ORE_ITEM).add(item);
        }
        if(oretype.contains("redstone")) {
            tag(ItemTagRegistry.REDSTONE_ORE_ITEM).add(item);
        }
        if (oretype.contains("randomium")) {
            tag(TstpTags.RANDOMIUM_ORE_ITEM).add(item);
        }
    }

    protected List<Item> getKnownItems()
    {
        return TstpContentModItems.REGISTRY.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
    }
}