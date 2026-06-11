//package com.ryorama.overhaulcraft.datagen.server;
//
//import com.ryorama.overhaulcraft.OverhaulCraft;
//import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.data.worldgen.BootstrapContext;
//import net.minecraft.data.worldgen.features.FeatureUtils;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.BlockTags;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
//import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
//
//import java.util.List;
//
//public class OverhaulCraftConfiguredFeatureProvider {
//    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_ORE_FEATURE;
//    public static final ResourceKey<PlacedFeature> PLACED_ORE_FEATURE;
//
//    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
//        List<OreConfiguration.TargetBlockState> ores = new java.util.ArrayList<>(List.of(
//                OreConfiguration.target(
//                        new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
//                        set.STONE_ORE_BLOCK.get().defaultBlockState()
//                ),
//                OreConfiguration.target(
//                        new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
//                        set.SLATE_ORE_BLOCK.get().defaultBlockState()
//                ),
//                OreConfiguration.target(
//                        new BlockMatchTest(Blocks.NETHERRACK),
//                        set.NETHER_ORE_BLOCK.get().defaultBlockState()
//                ),
//                OreConfiguration.target(
//                        new BlockMatchTest(Blocks.END_STONE),
//                        set.END_ORE_BLOCK.get().defaultBlockState()
//                ),
//                OreConfiguration.target(
//                        new TagMatchTest(BlockTags.create(ResourceLocation.fromNamespaceAndPath("allthemodium", "ancient_stone"))),
//                        set.OTHER_ORE_BLOCK.get().defaultBlockState()
//                )
//        ));
//
//        FeatureUtils.register(
//                context,
//                set.CONFIGURED_ORE_FEATURE,
//                Feature.ORE,
//                new OreConfiguration(ores, 5)
//        );
//    }
//
//    static {
//        CONFIGURED_ORE_FEATURE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, String.format("ore_%s", name)));
//        PLACED_ORE_FEATURE = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, String.format("ore_%s_placed", name)));
//    }
//}
