
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryorama.tstpcontent.init;

import com.mrcrayfish.framework.api.registry.RegistryEntry;
import com.mrcrayfish.furniture.refurbished.block.ElectricityGeneratorBlock;
import com.mrcrayfish.furniture.refurbished.block.MetalType;
import com.mrcrayfish.furniture.refurbished.util.Utils;
import com.ryorama.tstpcontent.block.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import com.ryorama.tstpcontent.TstpContentMod;

public class TstpContentModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TstpContentMod.MODID);
	public static final RegistryObject<Block> GRASS_BLOCK = REGISTRY.register("grass_block", () -> new GrassBlockBlock());
	public static final RegistryObject<Block> DIRT_BLOCK = REGISTRY.register("dirt_block", () -> new DirtBlockBlock());
	public static final RegistryObject<Block> SAND_BLOCK = REGISTRY.register("sand_block", () -> new SandBlockBlock());
	public static final RegistryObject<Block> SNOW = REGISTRY.register("snow", () -> new SnowBlock());
	public static final RegistryObject<Block> GRASS = REGISTRY.register("grass", () -> new GrassBlock());
	public static final RegistryObject<Block> WOOD_LOG = REGISTRY.register("wood_log", () -> new WoodLogBlock());
	public static final RegistryObject<Block> CACTUS = REGISTRY.register("cactus", () -> new CactusBlock());
	public static final RegistryObject<Block> FOREST_LEAVES = REGISTRY.register("forest_leaves", () -> new ForestLeavesBlock());
	public static final RegistryObject<Block> ICE = REGISTRY.register("ice", () -> new IceBlock());
	public static final RegistryObject<Block> COPPER_ORE = REGISTRY.register("copper_ore", () -> new CopperOreBlock());
	public static final RegistryObject<Block> STONE = REGISTRY.register("stone", () -> new StoneBlock());
	public static final RegistryObject<Block> IRON_ORE = REGISTRY.register("iron_ore", () -> new IronOreBlock());
	public static final RegistryObject<Block> MUSHROOM_PLANT = REGISTRY.register("mushroom_plant", () -> new MushroomPlantBlock());
	public static final RegistryObject<Block> LIFE_CRYSTAL_BLOCK = REGISTRY.register("life_crystal_block", () -> new LifeCrystalBlockBlock());
	public static final RegistryObject<Block> CALORITE_MACHINE_CASING = REGISTRY.register("calorite_machine_casing", () -> new CaloriteMachineCasingBlock());
	public static final RegistryObject<Block> OSTRUM_MACHINE_CASING = REGISTRY.register("ostrum_machine_casing", () -> new OstrumMachineCasingBlock());
	public static final RegistryObject<Block> HVAC_BLOCK = REGISTRY.register("hvac_block", () -> new HVACBlockBlock());
	public static final RegistryEntry<RFElectricityGeneratorBlock> LIGHT_RF_ELECTRICITY_GENERATOR = RegistryEntry.blockWithItem(new ResourceLocation("tstp_content", "light_rf_electricity_generator"), () -> {
		return new RFElectricityGeneratorBlock(MetalType.LIGHT, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instrument(NoteBlockInstrument.IRON_XYLOPHONE).strength(5.0F, 6.0F).lightLevel((state) -> {
			return (Boolean)state.getValue(ElectricityGeneratorBlock.POWERED) ? 2 : 0;
		}).requiresCorrectToolForDrops().forceSolidOn());
	});

	public static final RegistryEntry<RFElectricityGeneratorBlock> DARK_RF_ELECTRICITY_GENERATOR = RegistryEntry.blockWithItem(new ResourceLocation("tstp_content", "dark_rf_electricity_generator"), () -> {
		return new RFElectricityGeneratorBlock(MetalType.DARK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.IRON_XYLOPHONE).strength(5.0F, 6.0F).lightLevel((state) -> {
			return (Boolean)state.getValue(ElectricityGeneratorBlock.POWERED) ? 2 : 0;
		}).requiresCorrectToolForDrops().forceSolidOn());
	});
}
