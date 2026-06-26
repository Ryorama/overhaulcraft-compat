package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.mehvahdjukaar.randomium.common.RandomiumOreBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class OverhaulCraftOreBlocks {
    public static final DeferredRegister.Blocks BLOCK_REGISTRY = DeferredRegister.createBlocks(OverhaulCraft.MODID);
    public static final DeferredRegister.Items ITEM_REGISTRY = DeferredRegister.createItems(OverhaulCraft.MODID);


    public static List<String> oreVarIds = new ArrayList<>();

    public static void init(IEventBus bus) {
        oreVarIds.add("diorite");
        oreVarIds.add("andesite");
        oreVarIds.add("granite");
        oreVarIds.add("sulfur");
        oreVarIds.add("cinnabar");
        oreVarIds.add("netherrack");
        oreVarIds.add("end");
        oreVarIds.add("abyss");
        oreVarIds.add("holystone");
        oreVarIds.add("cake");
        oreVarIds.add("crimstone");
        oreVarIds.add("ebonstone");
        oreVarIds.add("pearlstone");
        oreVarIds.add("gloomslate");
        oreVarIds.add("sculk");
        oreVarIds.add("depthrock");
        oreVarIds.add("shiverstone");

        BLOCK_REGISTRY.register("uranium_ore", () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().strength(3, 3)));
        for (String id : oreVarIds) {
            registerOre("coal", id, 3, 3);
            registerOre("copper", id, 5, 6);
            registerOre("iron", id, 5, 6);
            registerOre("gold", id, 3, 3);
            registerOre("lapis", id, 3, 3);
            registerRedstoneOre(id, 4, 3);
            registerOre("diamond", id, 4, 3);
            registerOre("emerald", id, 3, 3);
            //registerOre("aluminum", id, 3, 3);
            registerOre("fluorite", id, 3, 3);
            registerOre("lead", id, 3, 3);
            registerOre("nickel", id, 3, 3);
            registerOre("osmium", id, 3, 3);
            registerOre("platinum", id, 3, 3);
            registerOre("tin", id, 3, 3);
            registerOre("zinc", id, 3, 3);
            registerOre("uranium", id, 3, 3);
            registerOre("ruby", id, 3, 3);
            registerOre("sapphire", id, 3, 3);
            registerOre("amethyst", id, 3, 3);
            registerOre("draconium", id, 6, 6);
            registerRandomiumOre(id, 4, 3);
        }

        BLOCK_REGISTRY.getEntries().forEach((OverhaulCraftOreBlocks::registerBlockItem));
        BLOCK_REGISTRY.register(bus);
        ITEM_REGISTRY.register(bus);
    }

    private static void registerBlockItem(DeferredHolder<Block, ?> block) {
        ITEM_REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void registerOre(String ore, String id, float destroyTime, float explosionResistance) {
        if (ore.equals("diamond")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite") || id.equals("depthrock") || id.equals("shiverstone")) return;
        }
        if (ore.equals("iron")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite") || id.equals("depthrock") || id.equals("shiverstone")) return;
        }
        if (ore.equals("coal")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite") || id.equals("depthrock") || id.equals("shiverstone")) return;
        }
        if (ore.equals("gold")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite") || id.equals("depthrock") || id.equals("netherrack")) return;
        }
        if (ore.equals("copper")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite")) return;
        }
        if (ore.equals("emerald")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite")) return;
        }
        if (ore.equals("lapis")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite")) return;
        }
        if (ore.equals("lead")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite")) return;
        }
        if (ore.equals("zinc")) {
            if (id.equals("andesite") || id.equals("diorite") || id.equals("granite")) return;
        }
        if (ore.equals("draconium")) {
            if (id.equals("netherrack") || id.equals("end")) return;
        }
        BLOCK_REGISTRY.register(id + "_" + ore + "_ore", () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(getModOreSound(id)).requiresCorrectToolForDrops().strength(destroyTime, explosionResistance)));
    }

    public static void registerRandomiumOre(String id, float destroyTime, float explosionResistance) {
        if (ExtraFunc.isModInstalled("randomium")) {
            BLOCK_REGISTRY.register(id + "_randomium_ore", () -> new RandomiumOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().strength(destroyTime, explosionResistance)));
        } else {
            BLOCK_REGISTRY.register(id + "_randomium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(getModOreSound(id)).requiresCorrectToolForDrops().strength(destroyTime, explosionResistance)));
        }
    }

    public static void registerRedstoneOre(String id, float destroyTime, float explosionResistance) {
        if (id.equals("andesite") || id.equals("diorite") || id.equals("granite")) return;
        BLOCK_REGISTRY.register(id + "_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(getModOreSound(id)).requiresCorrectToolForDrops().strength(destroyTime, explosionResistance)));
    }

    public static SoundType getModOreSound(String id) {
        if (id.equals("netherrack")) {
            return SoundType.NETHERRACK;
        }
        if (id.equals("cake_layer")) {
            return SoundType.WOOL;
        }
        return SoundType.STONE;
    }
}
