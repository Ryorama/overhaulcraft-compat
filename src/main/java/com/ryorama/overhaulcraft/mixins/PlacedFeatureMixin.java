package com.ryorama.overhaulcraft.mixins;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import org.confluence.mod.Confluence;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@IfModLoaded("confluence_dimension_patch")
@Mixin(PlacedFeature.class)
public abstract class PlacedFeatureMixin {
    @Shadow
    @Final
    private Holder<ConfiguredFeature<?, ?>> feature;

    @Inject(method = "placeWithContext", at = @At("HEAD"), cancellable = true)
    private void skip(PlacementContext context, RandomSource source, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
       if (feature.getKey() != null) {
           if (IDimensionAccessor.of(context.generator().getBiomeSource()).oc$isOverworld()) {
               if (Confluence.MODID.equals(feature.getKey().location().getNamespace()) || feature.getKey().location().getNamespace().contains("cobblemon")) {
                   cir.setReturnValue(false);
               }
           }
           if (IDimensionAccessor.of(context.generator().getBiomeSource()).oc$isConfluence()) {
               if (ExtraFunc.COBBLEMON_MODID.equals(feature.getKey().location().getNamespace())) {
                   cir.setReturnValue(false);
               }
           }
           if (IDimensionAccessor.of(context.generator().getBiomeSource()).oc$isCobblemon()) {
               if (Confluence.MODID.equals(feature.getKey().location().getNamespace())) {
                   cir.setReturnValue(false);
               }
           }
       }
    }
}
