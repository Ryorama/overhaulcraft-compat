package com.ryorama.overhaulcraft.datagen.server;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftBlocks;
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

public class TstpBlockTags extends BlockTagsProvider {

    public TstpBlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, OverhaulCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getKnownBlocks().forEach(this::addOreTags);
    }

    private void addOreTags(Block block) {
        if((block instanceof DropExperienceBlock) || (block instanceof RedStoneOreBlock) || (block instanceof RandomiumOreBlock)) {
            String oretype = block.getName().toString();
            if(oretype.contains("aluminum")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("aluminum"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("lead")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("lead"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("nickel")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("nickel"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("osmium")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("osmium"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("platinum")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("platinum"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("silver")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("silver"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("tin_")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("tin"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("uranium")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("uranium"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("zinc")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
                tag(BlockTags.create(ResourceLocation.parse("zinc"))).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("coal")) {
                tag(net.minecraft.tags.BlockTags.COAL_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("copper")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
                tag(net.minecraft.tags.BlockTags.COPPER_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("diamond")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                tag(net.minecraft.tags.BlockTags.DIAMOND_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("emerald")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                tag(net.minecraft.tags.BlockTags.EMERALD_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("gold")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                tag(net.minecraft.tags.BlockTags.GOLD_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("iron")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
                tag(net.minecraft.tags.BlockTags.IRON_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("lapis")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
                tag(net.minecraft.tags.BlockTags.LAPIS_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("redstone")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                tag(net.minecraft.tags.BlockTags.REDSTONE_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if (oretype.contains("randomium")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                tag(TstpTags.RANDOMIUM_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
        }
    }

    protected Iterable<Block> getKnownBlocks()
    {
        return OverhaulCraftBlocks.REGISTRY.getEntries().stream().map(DeferredHolder::get).filter(block -> !(block instanceof LiquidBlock)).collect(Collectors.toList());
    }
}