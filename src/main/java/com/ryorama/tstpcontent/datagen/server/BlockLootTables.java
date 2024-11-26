package com.ryorama.tstpcontent.datagen.server;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.init.TstpContentModBlocks;
import net.allthemods.alltheores.blocks.BlockList;
import net.mehvahdjukaar.randomium.common.RandomiumOreBlock;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Collectors;

public class BlockLootTables extends VanillaBlockLoot {
    @Override
    public void generate()
    {
        dropSelf(TstpContentModBlocks.CALORITE_MACHINE_CASING.get());
        dropSelf(TstpContentModBlocks.OSTRUM_MACHINE_CASING.get());
        dropSelf(TstpContentModBlocks.HVAC_BLOCK.get());
        dropSelf(TstpContentModBlocks.LIGHT_RF_ELECTRICITY_GENERATOR.get());
        dropSelf(TstpContentModBlocks.DARK_RF_ELECTRICITY_GENERATOR.get());
        dropSelf(TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get());
        getKnownBlocks().forEach(this::dropRaw);
    }

    private void dropRaw(Block block) {
        if((block instanceof DropExperienceBlock) || (block instanceof RedStoneOreBlock) || (block instanceof RandomiumOreBlock)) {
            String oretype = block.getName().toString();
            if(oretype.contains("aluminum")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.ALUMINUM_RAW.get());
            }); }
            if(oretype.contains("lead")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.LEAD_RAW.get());
            }); }
            if(oretype.contains("nickel")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.NICKEL_RAW.get());
            }); }
            if(oretype.contains("osmium")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.OSMIUM_RAW.get());
            }); }
            if(oretype.contains("platinum")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.PLATINUM_RAW.get());
            }); }
            if(oretype.contains("silver")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.SILVER_RAW.get());
            }); }
            if(oretype.contains("tin")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.TIN_RAW.get());
            }); }
            if(oretype.contains("uranium")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.URANIUM_RAW.get());
            }); }
            if(oretype.contains("zinc")) { this.add(block, (block1) -> {
                return createOreDrop(block1, BlockList.ZINC_RAW.get());
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
        Iterable<Block> iterable = TstpContentModBlocks.REGISTRY.getEntries().stream().map(RegistryObject::get).filter(block -> !(block instanceof LiquidBlock)).collect(Collectors.toList());
        TstpContentMod.LOGGER.info(iterable);
        return iterable;
    }
}