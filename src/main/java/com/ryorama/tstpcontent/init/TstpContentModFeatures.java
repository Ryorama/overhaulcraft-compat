
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryorama.tstpcontent.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import com.ryorama.tstpcontent.world.features.plants.MushroomTBlockFeature;
import com.ryorama.tstpcontent.world.features.plants.GrassFeature;
import com.ryorama.tstpcontent.world.features.ores.IronOreFeature;
import com.ryorama.tstpcontent.world.features.ores.IceFeature;
import com.ryorama.tstpcontent.world.features.ores.CopperOreFeature;
import com.ryorama.tstpcontent.TstpContentMod;

@Mod.EventBusSubscriber
public class TstpContentModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TstpContentMod.MODID);
	public static final RegistryObject<Feature<?>> COPPER_ORE = REGISTRY.register("copper_ore", CopperOreFeature::feature);
	public static final RegistryObject<Feature<?>> IRON_ORE = REGISTRY.register("iron_ore", IronOreFeature::feature);
	public static final RegistryObject<Feature<?>> ICE = REGISTRY.register("ice", IceFeature::feature);
	public static final RegistryObject<Feature<?>> MUSHROOM_T_BLOCK = REGISTRY.register("mushroom_t_block", MushroomTBlockFeature::feature);
	public static final RegistryObject<Feature<?>> GRASS = REGISTRY.register("grass", GrassFeature::feature);
}
