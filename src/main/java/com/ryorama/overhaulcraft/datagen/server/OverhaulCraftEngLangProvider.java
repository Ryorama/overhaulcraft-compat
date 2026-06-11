package com.ryorama.overhaulcraft.datagen.server;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftBlocks;
import com.ryorama.overhaulcraft.init.OverhaulCraftItems;
import com.ryorama.overhaulcraft.init.OverhaulCraftOreBlocks;
import com.ryorama.overhaulcraft.utils.TstpTags;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class OverhaulCraftEngLangProvider extends LanguageProvider {
    public OverhaulCraftEngLangProvider(PackOutput output) {
        super(output, OverhaulCraft.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItems();
        addBlocks();

        add("item_group.overhaulcraft.ore_compat", "OverhaulCraft: Ore Component");

        add("config.overhaulcraft.option.restrictDimensionTravelToPlanets", "Restrict Dimension Travel To Planets");
        add("config.overhaulcraft.option.restrictNetherAndEndToPlanets", "Restrict Nether And End To Planets");
        add("config.overhaulcraft.option.conversionCrucibleRadius", "Conversion Crucible Radius");
        add("config.overhaulcraft.option.peacefulHunger", "Enable Hunger in Peaceful Mode");
        add("config.overhaulcraft.option.peacefulThirst", "Enable Thirst in Peaceful Mode");
        add("config.overhaulcraft.option.playBossMusic", "PLay Boss Music");
        add("config.overhaulcraft.option.playTerrariaMusic", "Play Terraria Music");
        add("config.overhaulcraft.option.moreTerrariaContent", "Extra Terraria Content");
        add("config.overhaulcraft.option.enableShipSpeedDamage", "Enable Ship Speed Damage");
    }

    private void addItems() {
        addItem(OverhaulCraftItems.RANDOMIUM_ORE_CHUNK, "Randomium Ore Chunk");
    }

    private void addBlocks() {
        OverhaulCraftOreBlocks.BLOCK_REGISTRY.getEntries().forEach(this::addOreBlock);
    }

    private void addOreBlock(DeferredHolder<Block, ?> block) {
        String ore = block.get().builtInRegistryHolder().getKey().location().getPath().toString();

        for (String id : OverhaulCraftOreBlocks.oreVarIds) {
            if (ore.contains("aluminum") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Aluminum Ore");
            }
            if (ore.contains("lead") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Lead Ore");
            }
            if (ore.contains("nickel") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Nickel Ore");
            }
            if (ore.contains("osmium") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Osmium Ore");
            }
            if (ore.contains("platinum") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Platinum Ore");
            }
            if (ore.contains("silver") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Silver Ore");
            }
            if (ore.contains("tin_") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Tin Ore");
            }
            if (ore.contains("uranium") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Uranium Ore");
            }
            if (ore.contains("zinc") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Zinc Ore");
            }
            if (ore.contains("coal") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Coal Ore");
            }
            if (ore.contains("copper") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Copper Ore");
            }
            if (ore.contains("diamond") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Diamond Ore");
            }
            if (ore.contains("emerald") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Emerald Ore");
            }
            if (ore.contains("gold") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Gold Ore");
            }
            if (ore.contains("iron") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Iron Ore");
            }
            if (ore.contains("lapis") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Lapis Ore");
            }
            if (ore.contains("redstone") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Redstone Ore");
            }
            if (ore.contains("randomium") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Randomium Ore");
            }
            if (ore.contains("draconium") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Draconium Ore");
            }
        }
    }

    public String getNameFromId(String id) {
        String id1;
        id1 = id.substring(0, 1).toUpperCase() + id.substring(1);
        if (id.equals("cake_layer")) {
            id1 = "Cake Layer";
        }

        if (id.equals("sculk_stone")) {
            id1 = "Sculk";
        }

        if (id.equals("end_stone")) {
            id1 = "End";
        }

        return id1.replace("_", " ");
    }
}
