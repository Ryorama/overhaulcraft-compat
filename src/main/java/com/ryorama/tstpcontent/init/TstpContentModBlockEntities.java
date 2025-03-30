package com.ryorama.tstpcontent.init;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import com.ryorama.tstpcontent.blockentity.RFElectricityGeneratorBlockEntity;
import com.ryorama.tstpcontent.blockentity.furniture.BlockEntityCookieJar;
import com.ryorama.tstpcontent.blockentity.furniture.BlockEntityCup;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import com.ryorama.tstpcontent.blockentity.HVACBlockBlockEntity;
import com.ryorama.tstpcontent.TstpContentMod;

@RegistryContainer
public class TstpContentModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TstpContentMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> HVAC_BLOCK = register("hvac_block", TstpContentModBlocks.HVAC_BLOCK, HVACBlockBlockEntity::new);
	public static final RegistryEntry<BlockEntityType<RFElectricityGeneratorBlockEntity>> RF_ELECTRICITY_GENERATOR = RegistryEntry.blockEntity(new ResourceLocation("tstp_content", "rf_electricity_generator"), RFElectricityGeneratorBlockEntity::new, () -> {
		return new Block[]{TstpContentModBlocks.LIGHT_RF_ELECTRICITY_GENERATOR.get(), TstpContentModBlocks.DARK_RF_ELECTRICITY_GENERATOR.get()};
	});

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	public static final RegistryObject<BlockEntityType<?>> CUP = register("furniture/cup", TstpContentModBlocks.CUP, BlockEntityCup::new);
	public static final RegistryObject<BlockEntityType<?>> COOKIE_JAR = register("furniture/cookie_jar", TstpContentModBlocks.COOKIE_JAR, BlockEntityCookieJar::new);
}
