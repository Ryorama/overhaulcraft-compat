package com.ryorama.overhaulcraft.init;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.ryorama.overhaulcraft.OverhaulCraft;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

@RegistryContainer
public class OverhaulCraftBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.BLOCK_ENTITY_TYPE);

	private static RegistrySupplier<BlockEntityType<?>> register(String registryname, RegistrySupplier<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
