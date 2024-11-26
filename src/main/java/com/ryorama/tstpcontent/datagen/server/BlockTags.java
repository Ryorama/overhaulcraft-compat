package com.ryorama.tstpcontent.datagen.server;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import com.ryorama.tstpcontent.utils.TstpTags;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.mehvahdjukaar.randomium.common.RandomiumOreBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BlockTags extends BlockTagsProvider {

    public BlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, TstpContentMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(TstpContentModBlocks.HVAC_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(TstpContentModBlocks.OSTRUM_MACHINE_CASING.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(TstpContentModBlocks.CALORITE_MACHINE_CASING.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(TstpContentModBlocks.HVAC_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(TstpContentModBlocks.OSTRUM_MACHINE_CASING.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(TstpContentModBlocks.CALORITE_MACHINE_CASING.get());

        getKnownBlocks().forEach(this::addMineableTag);
        getKnownBlocks().forEach(this::addPickaxeTag);
    }

    private void addMineableTag(Block block) {
        if((block instanceof DropExperienceBlock) || (block instanceof RedStoneOreBlock) || (block instanceof RandomiumOreBlock)) {
            String oretype = block.getName().toString();
            if(oretype.contains("aluminum")) {
                tag(ItemTagRegistry.ALUMINUM_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("lead")) {
                tag(ItemTagRegistry.LEAD_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("nickel")) {
                tag(ItemTagRegistry.NICKEL_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("osmium")) {
                tag(ItemTagRegistry.OSMIUM_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("platinum")) {
                tag(ItemTagRegistry.PLATINUM_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("silver")) {
                tag(ItemTagRegistry.SILVER_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("tin")) {
                tag(ItemTagRegistry.TIN_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("uranium")) {
                tag(ItemTagRegistry.URANIUM_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("zinc")) {
                tag(ItemTagRegistry.ZINC_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("coal")) {
                tag(net.minecraft.tags.BlockTags.COAL_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("copper")) {
                tag(net.minecraft.tags.BlockTags.COPPER_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("diamond")) {
                tag(net.minecraft.tags.BlockTags.DIAMOND_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("emerald")) {
                tag(net.minecraft.tags.BlockTags.EMERALD_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("gold")) {
                tag(net.minecraft.tags.BlockTags.GOLD_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("iron")) {
                tag(net.minecraft.tags.BlockTags.IRON_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("lapis")) {
                tag(net.minecraft.tags.BlockTags.LAPIS_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if(oretype.contains("redstone")) {
                tag(net.minecraft.tags.BlockTags.REDSTONE_ORES).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
            if (oretype.contains("randomium")) {
                tag(TstpTags.RANDOMIUM_ORE).add(block);
                tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
        }
    }

    private void addPickaxeTag(Block block) {
        if((block instanceof DropExperienceBlock) || (block instanceof RedStoneOreBlock) || (block instanceof RandomiumOreBlock)) {
            String oretype = block.getName().toString();
            if(oretype.contains("aluminum")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            if(oretype.contains("lead")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            if(oretype.contains("nickel")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            if(oretype.contains("osmium")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            if(oretype.contains("platinum")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            }
            if(oretype.contains("silver")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            if(oretype.contains("tin")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            if(oretype.contains("uranium")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            }
            if(oretype.contains("zinc")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            if(oretype.contains("randomium")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            if(oretype.contains("copper")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            if(oretype.contains("diamond")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            if(oretype.contains("emerald")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            if(oretype.contains("gold")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            if(oretype.contains("iron")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            if(oretype.contains("lapis")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            if(oretype.contains("redstone")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            if (oretype.contains("randomium")) {
                tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
            }
        }
    }

    protected Iterable<Block> getKnownBlocks()
    {
        return TstpContentModBlocks.REGISTRY.getEntries().stream().map(RegistryObject::get).filter(block -> !(block instanceof LiquidBlock)).collect(Collectors.toList());
    }
}