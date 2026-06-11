package com.ryorama.overhaulcraft.datagen.server;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftBlocks;
import com.ryorama.overhaulcraft.init.OverhaulCraftOreBlocks;
import com.ryorama.overhaulcraft.utils.TstpTags;
import net.mehvahdjukaar.randomium.common.RandomiumOreBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
            tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("aluminum"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("lead")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("lead"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("nickel")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("nickel"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("osmium")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("osmium"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("platinum")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("platinum"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("silver")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("silver"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("tin_")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("tin"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("uranium")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("uranium"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("zinc")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(BlockTags.create(ResourceLocation.parse("zinc"))).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("coal")) {
            tag(net.minecraft.tags.BlockTags.COAL_ORES).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("copper")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(net.minecraft.tags.BlockTags.COPPER_ORES).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("diamond")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(net.minecraft.tags.BlockTags.DIAMOND_ORES).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("emerald")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(net.minecraft.tags.BlockTags.EMERALD_ORES).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("gold")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(net.minecraft.tags.BlockTags.GOLD_ORES).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("iron")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(net.minecraft.tags.BlockTags.IRON_ORES).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("lapis")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            tag(net.minecraft.tags.BlockTags.LAPIS_ORES).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if(ore.contains("redstone")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(net.minecraft.tags.BlockTags.REDSTONE_ORES).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if (ore.contains("randomium")) {
            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            tag(TstpTags.RANDOMIUM_ORE).add(block);
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        if (ore.contains("draconium")) {
            tag(TstpTags.DRACONIUM_ORE).add(block);
        }
    }
}