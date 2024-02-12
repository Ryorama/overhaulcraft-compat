
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.block.entity.HamsterWheelGeneratorBlockEntity;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import com.ryorama.tstpcontent.block.entity.HVACBlockBlockEntity;
import com.ryorama.tstpcontent.TstpContentMod;

public class TstpContentModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TstpContentMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> HVAC_BLOCK = register("hvac_block", TstpContentModBlocks.HVAC_BLOCK, HVACBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<HamsterWheelGeneratorBlockEntity>> HAMSTER_WHEEL_GENERATOR = REGISTRY.register(
			"hamster_wheel_generator",
			() -> BlockEntityType.Builder.of(HamsterWheelGeneratorBlockEntity::new, TstpContentModBlocks.HAMSTER_WHEEL_GENERATOR.get()).build(null)
	);
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
