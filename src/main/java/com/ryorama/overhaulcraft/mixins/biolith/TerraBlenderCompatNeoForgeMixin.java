package com.ryorama.overhaulcraft.mixins.biolith;

import com.llamalad7.mixinextras.sugar.Local;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.terraformersmc.biolith.api.biome.BiolithFittestNodes;
import com.terraformersmc.biolith.impl.compat.TerraBlenderCompatNeoForge;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@IfModLoaded("biolith")
@IfModLoaded("confluence_dimension_patch")
@Mixin(TerraBlenderCompatNeoForge.class)
public class TerraBlenderCompatNeoForgeMixin {
    @Inject(at = @At("TAIL"), method = "getBiome", cancellable = true)
    public void getBiome(int x, int y, int z, Climate.TargetPoint noisePoint, Climate.ParameterList<Holder<Biome>> biomeEntries, CallbackInfoReturnable<BiolithFittestNodes<Holder<Biome>>> ci) {
        biomeEntries.values().forEach(biomes -> {
            if (biomes.getSecond().getKey().registryKey().location().getNamespace().equals("confluence")) {
                ci.setReturnValue(null);
            }
        });
    }


    //ToDo: Remove Confluence Surface Rules From Overworld when CDP installed
    @Inject(at = @At(value = "INVOKE", target = "Lterrablender/api/SurfaceRuleManager;addSurfaceRules(Lterrablender/api/SurfaceRuleManager$RuleCategory;Ljava/lang/String;Lnet/minecraft/world/level/levelgen/SurfaceRules$RuleSource;)V"), method = "lambda$registerSurfaceRules$0", cancellable = true)
    private static void registerSurfaceRules(CallbackInfo ci, @Local(name = "namespace") String namespace) {
        OverhaulCraft.LOGGER.info("TerraBlenderCompatNeoForge namespace: " + namespace);
        if (namespace.equals("confluence")) {
            ci.cancel();
        }
    }
}
