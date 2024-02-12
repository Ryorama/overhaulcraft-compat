
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryorama.tstpcontent.init;

import com.starfish_studios.hamsters.Hamsters;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import com.ryorama.tstpcontent.item.MushroomtItem;
import com.ryorama.tstpcontent.item.LifeCrystalItem;
import com.ryorama.tstpcontent.item.IronItemItem;
import com.ryorama.tstpcontent.item.IronBarItem;
import com.ryorama.tstpcontent.item.CopperItem;
import com.ryorama.tstpcontent.item.CopperBarItem;
import com.ryorama.tstpcontent.TstpContentMod;

public class TstpContentModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TstpContentMod.MODID);
	public static final RegistryObject<Item> GRASS_BLOCK = block(TstpContentModBlocks.GRASS_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DIRT_BLOCK = block(TstpContentModBlocks.DIRT_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> STONE_BLOCK = block(TstpContentModBlocks.STONE_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> COPPER_ORE = block(TstpContentModBlocks.COPPER_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> IRON_ORE = block(TstpContentModBlocks.IRON_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> COPPER = REGISTRY.register("copper", () -> new CopperItem());
	public static final RegistryObject<Item> IRON_ITEM = REGISTRY.register("iron_item", () -> new IronItemItem());
	public static final RegistryObject<Item> COPPER_BAR = REGISTRY.register("copper_bar", () -> new CopperBarItem());
	public static final RegistryObject<Item> IRON_BAR = REGISTRY.register("iron_bar", () -> new IronBarItem());
	public static final RegistryObject<Item> CACTUS = block(TstpContentModBlocks.CACTUS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FOREST_LOG = block(TstpContentModBlocks.FOREST_LOG, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FOREST_LEAVES = block(TstpContentModBlocks.FOREST_LEAVES, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SAND = block(TstpContentModBlocks.SAND, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SNOW = block(TstpContentModBlocks.SNOW, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ICE = block(TstpContentModBlocks.ICE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MUSHROOM_T = REGISTRY.register("mushroom_t", () -> new MushroomtItem());
	public static final RegistryObject<Item> MUSHROOM_T_BLOCK = block(TstpContentModBlocks.MUSHROOM_T_BLOCK, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> GRASS = block(TstpContentModBlocks.GRASS, null);
	public static final RegistryObject<Item> LIFE_CRYSTAL = REGISTRY.register("life_crystal", () -> new LifeCrystalItem());
	public static final RegistryObject<Item> HVAC_BLOCK = block(TstpContentModBlocks.HVAC_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> HAMSTER_WHEEL_GENERATOR = block(TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR, Hamsters.hamsterCreativeTab);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
