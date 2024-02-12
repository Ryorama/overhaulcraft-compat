
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryorama.tstpcontent.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import com.ryorama.tstpcontent.world.biome.TerrariaForestBiome;
import com.ryorama.tstpcontent.world.biome.TerrariaDesertBiome;
import com.ryorama.tstpcontent.world.biome.TerrairaArcticBiome;
import com.ryorama.tstpcontent.TstpContentMod;

public class TstpContentModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, TstpContentMod.MODID);
	public static final RegistryObject<Biome> TERRARIA_DESERT = REGISTRY.register("terraria_desert", TerrariaDesertBiome::createBiome);
	public static final RegistryObject<Biome> TERRARIA_FOREST = REGISTRY.register("terraria_forest", TerrariaForestBiome::createBiome);
	public static final RegistryObject<Biome> TERRAIRA_ARCTIC = REGISTRY.register("terraira_arctic", TerrairaArcticBiome::createBiome);
}
