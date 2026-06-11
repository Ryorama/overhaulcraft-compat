package com.ryorama.overhaulcraft.datagen.server;


import com.ryorama.overhaulcraft.init.OverhaulCraftBlocks;
import com.ryorama.overhaulcraft.init.OverhaulCraftOreBlocks;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockLootTables extends VanillaBlockLoot {

    public BlockLootTables(HolderLookup.Provider provider) {
        super(provider);
    }

    @Override
    public void generate() {
        OverhaulCraftOreBlocks.BLOCK_REGISTRY.getEntries().forEach(blockDeferredHolder -> createOreDrops(blockDeferredHolder.get()));
    }

    private void createOreDrops(Block block) {
        String ore = block.getName().toString();
        if (ore.contains("aluminum")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.ALUMINUM.RAW.get());
            });
        }
        if (ore.contains("lead")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.LEAD.RAW.get());
            });
        }
        if (ore.contains("nickel")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.NICKEL.RAW.get());
            });
        }
        if (ore.contains("osmium")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.OSMIUM.RAW.get());
            });
        }
        if (ore.contains("platinum")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.PLATINUM.RAW.get());
            });
        }
        if (ore.contains("silver")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.SILVER.RAW.get());
            });
        }
        if (ore.contains("tin_")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.TIN.RAW.get());
            });
        }
        if (ore.contains("uranium")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.URANIUM.RAW.get());
            });
        }
        if (ore.contains("fluorite")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.FLUORITE.GEM.get());
            });
        }
        if (ore.contains("zinc")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.ZINC.RAW.get());
            });
        }
        if (ore.contains("coal")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, Items.COAL);
            });
        }
        if (ore.contains("copper")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, Items.RAW_COPPER);
            });
        }
        if (ore.contains("diamond")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, Items.DIAMOND);
            });
        }
        if (ore.contains("emerald")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, Items.EMERALD);
            });
        }
        if (ore.contains("gold")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, Items.RAW_GOLD);
            });
        }
        if (ore.contains("iron")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, Items.RAW_IRON);
            });
        }
        if (ore.contains("lapis")) {
            this.add(block, this::createLapisOreDrops);
        }
        if (ore.contains("redstone")) {
            this.add(block, this::createRedstoneOreDrops);
        }
        if (ore.contains("randomium")) {
            dropWhenSilkTouch(block);
        }
        if (ore.contains("ruby")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.RUBY.GEM.get());
            });
        }
        if (ore.contains("sapphire")) {
            this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.SAPPHIRE.GEM.get());
            });
        }
        if (ore.contains("draconium")) {
            dropSelf(block);
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        List<Block> blocks = new ArrayList<>();
        OverhaulCraftBlocks.REGISTRY.getEntries().forEach(blockDeferredHolder -> blocks.add(blockDeferredHolder.get()));
        OverhaulCraftOreBlocks.BLOCK_REGISTRY.getEntries().forEach(blockDeferredHolder -> blocks.add(blockDeferredHolder.get()));
        return blocks;
    }
}