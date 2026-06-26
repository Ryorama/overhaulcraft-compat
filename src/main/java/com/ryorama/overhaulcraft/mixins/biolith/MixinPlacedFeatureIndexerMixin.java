//package com.ryorama.overhaulcraft.mixins.biolith;
//
//import com.bawnorton.mixinsquared.TargetHandler;
//import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
//import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
//import net.minecraft.core.Holder;
//import net.minecraft.world.level.biome.FeatureSorter;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//import org.spongepowered.asm.mixin.Mixin;
//
//import java.util.List;
//import java.util.function.Function;
//
//@Mixin(value = FeatureSorter.class, priority = 1500)
//public class MixinPlacedFeatureIndexerMixin {
//    @TargetHandler(mixin = "com.terraformersmc.biolith.impl.mixin.MixinPlacedFeatureIndexer", name = "biolith$wrapFeatureIndexer")
//    @WrapMethod(method = "buildFeaturesPerStep")
//    private static <T> List<FeatureSorter.StepFeatureData> biolith$wrapFeatureIndexer(List<T> biomes, Function<T, List<Holder<PlacedFeature>>> biomesToPlacedFeaturesList, boolean listInvolvedBiomesOnFailure, Operation<List<FeatureSorter.StepFeatureData>> original) {
//
//    }
//}
