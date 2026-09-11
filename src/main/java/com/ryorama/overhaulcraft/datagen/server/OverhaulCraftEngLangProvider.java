package com.ryorama.overhaulcraft.datagen.server;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftItems;
import com.ryorama.overhaulcraft.init.OverhaulCraftOreBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
        add("config.overhaulcraft.option.playBossMusic", "Play Boss Music");
        add("config.overhaulcraft.option.playTerrariaMusic", "Play Terraria Music");
        add("config.overhaulcraft.option.moreTerrariaContent", "Extra Terraria Content");
        add("config.overhaulcraft.option.enableShipSpeedDamage", "Enable Ship Speed Damage");

        add("tooltip.overhaulcraft.item.customization_globe.1", "Use to customize your character");
        add("tooltip.overhaulcraft.item.customization_globe.2", "Consumed on use");
    }

    private void addItems() {
        addItem(OverhaulCraftItems.RANDOMIUM_ORE_CHUNK, "Randomium Ore Chunk");
        addItem(OverhaulCraftItems.COBBLEDIM_TELEPORT_ITEM, "Mysterious Ball");
        addItem(OverhaulCraftItems.CUSTOMIZATION_GLOBE, "Customization Globe");
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
            if (ore.contains("fluorite") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Fluorite Ore");
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
            if (ore.contains("ruby") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Ruby Ore");
            }
            if (ore.contains("sapphire") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Sapphire Ore");
            }
            if (ore.contains("amethyst") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Amethyst Ore");
            }
            if (ore.contains("draconium") && ore.contains(id)) {
                addBlock(block, getNameFromId(id) + " Draconium Ore");
            }
        }
    }

    public String getNameFromId(String id) {
        String id1;
        id1 = id.substring(id.indexOf("/") + 1);
        String id2 = id1.substring(0, 1).toUpperCase() + id1.substring(1);

        return id2.replace("_", " ");
    }
}
