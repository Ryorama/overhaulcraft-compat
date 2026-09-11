//package com.ryorama.overhaulcraft.datagen.server;
//
//import net.allthemods.alltheores.datagen.data.ATOBiomeModiferProvider;
//import net.allthemods.alltheores.datagen.data.worldgen.ATOConfiguredFeatureProvider;
//import net.allthemods.alltheores.datagen.data.worldgen.ATOPlacedFeatureProvider;
//import net.minecraft.core.RegistrySetBuilder;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.data.PackOutput;
//import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
//import net.neoforged.neoforge.registries.NeoForgeRegistries;
//
//import java.util.Set;
//import java.util.concurrent.CompletableFuture;
//
//public class OverhaulCraftDatapackGenerator extends DatapackBuiltinEntriesProvider {
//    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
//            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ATOBiomeModiferProvider::bootstrap)
//            .add(Registries.CONFIGURED_FEATURE, ATOConfiguredFeatureProvider::bootstrap)
//            .add(Registries.PLACED_FEATURE, ATOPlacedFeatureProvider::bootstrap);
//
//    public OverhaulCraftDatapackGenerator(PackOutput output, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries, Set<String> modIds) {
//        super(output, registries, modIds);
//    }
//}
