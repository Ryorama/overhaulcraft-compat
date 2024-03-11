
package com.ryorama.tstpcontent.world.features.ores;

import com.ryorama.tstpcontent.world.features.TstpFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.Set;
import java.util.List;

import com.ryorama.tstpcontent.init.TstpContentModBlocks;

public class IronOreFeature extends TstpFeature {
	public static IronOreFeature FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new IronOreFeature();
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("tstp_content:terraria_dim")));

	public IronOreFeature() {
		super();
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		if (generate_dimensions.contains(world.getLevel().dimension())) {
			if (context.random().nextIntBetweenInclusive(0, 50) == 0 && world.getBlockState(context.origin()) == TstpContentModBlocks.GRASS_BLOCK.get().defaultBlockState() || world.getBlockState(context.origin()) == TstpContentModBlocks.DIRT_BLOCK.get().defaultBlockState() && world.getBlockState(context.origin()) == TstpContentModBlocks.STONE_BLOCK.get().defaultBlockState())
			placeOre(world, context.random(), context.origin(), context.random().nextIntBetweenInclusive(5, 8), world.getBlockState(context.origin()), TstpContentModBlocks.IRON_ORE.get().defaultBlockState());
		}
		return true;
	}
}
