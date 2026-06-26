package com.ryorama.overhaulcraft.mixins.biolith;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.BlockColumn;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@IfModLoaded("biolith")
@Mixin(value = SurfaceSystem.class, priority = 1500)
public class MixinSurfaceBuilderMixin {
//    @TargetHandler(mixin = "com.terraformersmc.biolith.impl.mixin.MixinSurfaceBuilder", name = "biolith$injectSurfaceBuilders")
//    @Inject(at = @At(value = "HEAD"), method = "@MixinSquared:Handler", cancellable = true)
//    private void buildSurface(Holder<Biome> instance, ResourceKey<Biome> targetKey, Operation<Boolean> original, BiomeManager biomeAccess, ChunkAccess chunk, BlockColumn blockColumn, int m, int n, int o, CallbackInfoReturnable<Boolean> cir) {
//        if (IDimensionAccessor.of((SurfaceSystem)(Object)this).oc$isConfluence()) {
//            cir.cancel();
//        }
//    }
}