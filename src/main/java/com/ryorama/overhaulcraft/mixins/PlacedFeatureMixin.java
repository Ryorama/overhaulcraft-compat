package com.ryorama.overhaulcraft.mixins;

import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
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

@Mixin(PlacedFeature.class)
public abstract class PlacedFeatureMixin {
    @Shadow
    @Final
    private Holder<ConfiguredFeature<?, ?>> feature;

    @Inject(method = "placeWithContext", at = @At("HEAD"), cancellable = true)
    private void skip(PlacementContext context, RandomSource source, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (IDimensionAccessor.of(context.generator().getBiomeSource()).oc$isOverworld()) {
            if (Confluence.MODID.equals(feature.getKey().location().getNamespace()) || feature.getKey().location().getNamespace().contains("cobblemon")) {
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
