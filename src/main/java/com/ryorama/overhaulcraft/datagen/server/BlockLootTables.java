package com.ryorama.overhaulcraft.datagen.server;


import com.ryorama.overhaulcraft.init.TstpContentModBlocks;
import net.allthemods.alltheores.AllTheOres;
import net.allthemods.alltheores.registry.ATORegistry;
import net.mehvahdjukaar.randomium.common.RandomiumOreBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.stream.Collectors;

public class BlockLootTables extends VanillaBlockLoot {

    public BlockLootTables(HolderLookup.Provider provider) {
        super(provider);
    }

    @Override
    public void generate()
    {
        dropSelf(TstpContentModBlocks.CALORITE_MACHINE_CASING.get());
        dropSelf(TstpContentModBlocks.OSTRUM_MACHINE_CASING.get());
        //dropSelf(TstpContentModBlocks.HVAC_BLOCK.get());
        //dropSelf(TstpContentModBlocks.LIGHT_RF_ELECTRICITY_GENERATOR.get());
        //dropSelf(TstpContentModBlocks.DARK_RF_ELECTRICITY_GENERATOR.get());
        getKnownBlocks().forEach(this::dropRaw);
    }

    private void dropRaw(Block block) {
        if((block instanceof DropExperienceBlock) || (block instanceof RedStoneOreBlock) || (block instanceof RandomiumOreBlock)) {
            String oretype = block.getName().toString();
            if(oretype.contains("aluminum")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.ALUMINUM.RAW.get());
            }); }
            if(oretype.contains("lead")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.LEAD.RAW.get());
            }); }
            if(oretype.contains("nickel")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.NICKEL.RAW.get());
            }); }
            if(oretype.contains("osmium")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.OSMIUM.RAW.get());
            }); }
            if(oretype.contains("platinum")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.PLATINUM.RAW.get());
            }); }
            if(oretype.contains("silver")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.SILVER.RAW.get());
            }); }
            if(oretype.contains("tin_")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.TIN.RAW.get());
            }); }
            if(oretype.contains("uranium")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.URANIUM.RAW.get());
            }); }
            if(oretype.contains("zinc")) { this.add(block, (block1) -> {
                return createOreDrop(block1, ATORegistry.ZINC.RAW.get());
            }); }
            if(oretype.contains("coal")) { this.add(block, (block1) -> {
                return createOreDrop(block1, Items.COAL);
            }); }
            if(oretype.contains("copper")) { this.add(block, (block1) -> {
                return createOreDrop(block1, Items.RAW_COPPER);
            }); }
            if(oretype.contains("diamond")) { this.add(block, (block1) -> {
                return createOreDrop(block1, Items.DIAMOND);
            }); }
            if(oretype.contains("emerald")) { this.add(block, (block1) -> {
                return createOreDrop(block1, Items.EMERALD);
            }); }
            if(oretype.contains("gold")) { this.add(block, (block1) -> {
                return createOreDrop(block1, Items.RAW_GOLD);
            }); }
            if(oretype.contains("iron")) { this.add(block, (block1) -> {
                return createOreDrop(block1, Items.RAW_IRON);
            }); }
            if(oretype.contains("lapis")) { this.add(block, this::createLapisOreDrops); }
            if(oretype.contains("redstone")) { this.add(block, this::createRedstoneOreDrops); }
            if(oretype.contains("randomium")) {
                dropWhenSilkTouch(block);
            }
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return TstpContentModBlocks.REGISTRY.getEntries().stream().map(DeferredHolder::get).filter(block -> !(block instanceof LiquidBlock)).collect(Collectors.toList());
    }
}