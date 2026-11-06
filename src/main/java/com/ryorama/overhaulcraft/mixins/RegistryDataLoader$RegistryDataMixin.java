package com.ryorama.overhaulcraft.mixins;

import com.google.common.collect.ImmutableList;
import com.llamalad7.mixinextras.sugar.Local;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import com.ryorama.overhaulcraft.world.filter.OnlyInCobblemonPlacementFilter;
import com.ryorama.overhaulcraft.world.placement.OnlyInCobblemonStructurePlacement;
import com.ryorama.overhaulcraft.world.placement.OnlyInOtherworldStructurePlacement;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.neoforged.neoforge.registries.RegistryBuilder;
import org.confluence.mod.Confluence;
import org.mesdag.confluence_dimension_patch.common.OnlyInOtherworldPlacementFilter;
import org.mesdag.confluence_dimension_patch.mixin.PlacedFeatureAccessor;
import org.mesdag.confluence_dimension_patch.mixin.StructureSetAccessor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@IfModLoaded("confluence_dimension_patch")
@Mixin(RegistryDataLoader.RegistryData.class)
public abstract class RegistryDataLoader$RegistryDataMixin<T> {
    @Shadow
    @Final
    private ResourceKey<? extends Registry<T>> key;

    @Inject(method = "create", at = @At(value = "INVOKE", target = "Ljava/util/function/Consumer;accept(Ljava/lang/Object;)V"))
    private void modifyRegistry(CallbackInfoReturnable<Object> cir, @Local RegistryBuilder<T> builder) {
        if (Registries.PLACED_FEATURE.equals(key)) {
            builder.onAdd((registry, id, key, value) -> {
                if (Confluence.MODID.equals(key.location().getNamespace())) {
                    List<PlacementModifier> placement = ((PlacedFeature) value).placement();
                    ImmutableList.Builder<PlacementModifier> modifier = ImmutableList.builder();
                    modifier.add(OnlyInOtherworldPlacementFilter.INSTANCE);
                    modifier.addAll(placement);
                    ((PlacedFeatureAccessor) value).setPlacement(modifier.build());
                }
                if (ExtraFunc.isFromCobblemon(key.location().getNamespace())) {
                    List<PlacementModifier> placement = ((PlacedFeature) value).placement();
                    ImmutableList.Builder<PlacementModifier> modifier = ImmutableList.builder();
                    modifier.add(OnlyInCobblemonPlacementFilter.INSTANCE);
                    modifier.addAll(placement);
                    ((PlacedFeatureAccessor) value).setPlacement(modifier.build());
                }
            });
        } else if (Registries.STRUCTURE_SET.equals(key)) {
            builder.onAdd((registry, id, key, value) -> {
                if (Confluence.MODID.equals(key.location().getNamespace())) {
                    StructurePlacement placement = ((StructureSet) value).placement();
                    ((StructureSetAccessor) value).setPlacement(new OnlyInOtherworldStructurePlacement(placement));
                }
                if (ExtraFunc.isFromCobblemon(key.location().getNamespace())) {
                    StructurePlacement placement = ((StructureSet) value).placement();
                    ((StructureSetAccessor) value).setPlacement(new OnlyInCobblemonStructurePlacement(placement));
                }
            });
        }
    }
}