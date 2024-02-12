
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.block.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import com.ryorama.tstpcontent.TstpContentMod;

public class TstpContentModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TstpContentMod.MODID);
	public static final RegistryObject<Block> GRASS_BLOCK = REGISTRY.register("grass_block", () -> new GrassBlockBlock());
	public static final RegistryObject<Block> DIRT_BLOCK = REGISTRY.register("dirt_block", () -> new DirtBlockBlock());
	public static final RegistryObject<Block> STONE_BLOCK = REGISTRY.register("stone_block", () -> new StoneBlockBlock());
	public static final RegistryObject<Block> COPPER_ORE = REGISTRY.register("copper_ore", () -> new CopperOreBlock());
	public static final RegistryObject<Block> IRON_ORE = REGISTRY.register("iron_ore", () -> new IronOreBlock());
	public static final RegistryObject<Block> CACTUS = REGISTRY.register("cactus", () -> new CactusBlock());
	public static final RegistryObject<Block> FOREST_LOG = REGISTRY.register("forest_log", () -> new ForestLogBlock());
	public static final RegistryObject<Block> FOREST_LEAVES = REGISTRY.register("forest_leaves", () -> new ForestLeavesBlock());
	public static final RegistryObject<Block> SAND = REGISTRY.register("sand", () -> new SandBlock());
	public static final RegistryObject<Block> SNOW = REGISTRY.register("snow", () -> new SnowBlock());
	public static final RegistryObject<Block> ICE = REGISTRY.register("ice", () -> new IceBlock());
	public static final RegistryObject<Block> MUSHROOM_T_BLOCK = REGISTRY.register("mushroom_t_block", () -> new MushroomTBlockBlock());
	public static final RegistryObject<Block> GRASS = REGISTRY.register("grass", () -> new GrassBlock());
	public static final RegistryObject<Block> HVAC_BLOCK = REGISTRY.register("hvac_block", () -> new HVACBlockBlock());
	public static final RegistryObject<Block> HAMSTER_WHEEL_GENERATOR = REGISTRY.register("hamster_wheel_generator", () -> new HamsterWheelGeneratorBlock());
}
