package com.ryorama.overhaulcraft.init;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.ryorama.overhaulcraft.TstpContentMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

@RegistryContainer
public class TstpContentModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(TstpContentMod.MODID, Registries.BLOCK_ENTITY_TYPE);
	//public static final RegistrySupplier<BlockEntityType<?>> HVAC_BLOCK = register("hvac_block", TstpContentModBlocks.HVAC_BLOCK, HVACBlockBlockEntity::new);
	//public static final RegistryEntry<BlockEntityType<RFElectricityGeneratorBlockEntity>> RF_ELECTRICITY_GENERATOR = RegistryEntry.blockEntity(ResourceLocation.fromNamespaceAndPath("tstp_content", "rf_electricity_generator"), RFElectricityGeneratorBlockEntity::new, () -> {
		//return new Block[]{TstpContentModBlocks.LIGHT_RF_ELECTRICITY_GENERATOR.get(), TstpContentModBlocks.DARK_RF_ELECTRICITY_GENERATOR.get()};
	//});

	private static RegistrySupplier<BlockEntityType<?>> register(String registryname, RegistrySupplier<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
