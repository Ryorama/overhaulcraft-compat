package com.ryorama.overhaulcraft.datagen.server;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftOreBlocks;
import com.ryorama.overhaulcraft.utils.TstpTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class OverhaulCraftBlockTags extends BlockTagsProvider {

    public OverhaulCraftBlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, OverhaulCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        OverhaulCraftOreBlocks.BLOCK_REGISTRY.getEntries().forEach(blockDeferredHolder -> addOreTags(blockDeferredHolder.get()));
    }

    private void addOreTags(Block block) {
        String ore = block.getName().toString();
        if(ore.contains("aluminum")) {
            tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("aluminum"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if (ore.contains("fluorite")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("fluorite"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("lead")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("lead"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("nickel")) {
            tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("nickel"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("osmium")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("osmium"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("platinum")) {
            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("platinum"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("silver")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("silver"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("tin_")) {
            tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("tin"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("uranium")) {
            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("uranium"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("zinc")) {
            tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("zinc"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("coal")) {
            tag(BlockTags.COAL_ORES).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("copper")) {
            tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.COPPER_ORES).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("diamond")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.DIAMOND_ORES).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("emerald")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.EMERALD_ORES).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("gold")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.GOLD_ORES).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("iron")) {
            tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.IRON_ORES).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("lapis")) {
            tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.LAPIS_ORES).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("redstone")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.REDSTONE_ORES).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if (ore.contains("randomium")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(TstpTags.RANDOMIUM_ORE).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if (ore.contains("ruby")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("ruby"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE);
        }
        if (ore.contains("sapphire")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("sapphire"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE);
        }
        if (ore.contains("amethyst")) {
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("amethyst"))).add(block);
            tag(BlockTags.MINEABLE_WITH_PICKAXE);
        }
        if (ore.contains("draconium")) {
            tag(TstpTags.DRACONIUM_ORE).add(block);
        }
    }
}