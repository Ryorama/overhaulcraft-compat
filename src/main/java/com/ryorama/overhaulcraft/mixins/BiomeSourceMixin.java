package com.ryorama.overhaulcraft.mixins;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import com.terraformersmc.biolith.impl.Biolith;
import com.terraformersmc.biolith.impl.biome.InterfaceBiomeSource;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@IfModLoaded("confluence_dimension_patch")
@Mixin(BiomeSource.class)
public abstract class BiomeSourceMixin implements IDimensionAccessor, InterfaceBiomeSource {
    @Unique
    private boolean oc$isOverworld = false;
    @Unique
    private boolean oc$isConfluence = false;
    @Unique
    private boolean oc$isCobblemon = false;

    @Override
    public void oc$setIsOverworld(boolean value) {
        this.oc$isOverworld = value;
    }

    @Override
    public boolean oc$isOverworld() {
        return oc$isOverworld;
    }

    @Override
    public void oc$setIsConfluence(boolean value) {
        this.oc$isConfluence = value;
    }

    @Override
    public boolean oc$isConfluence() {
        return oc$isConfluence;
    }

    @Override
    public void oc$setIsCobblemon(boolean value) {
        this.oc$isCobblemon = value;
    }

    @Override
    public boolean oc$isCobblemon() {
        return oc$isCobblemon;
    }

    @Unique
    private ResourceKey<DimensionType> biolith$dimensionType = InterfaceBiomeSource.DIMENSION_TYPE_UNDEFINED;

    @Override
    public ResourceKey<DimensionType> biolith$getDimensionType() {
        return biolith$dimensionType;
    }

    @Override
    public void biolith$setDimensionType(Holder<DimensionType> dimensionTypeEntry) {
        dimensionTypeEntry.unwrapKey().ifPresent(this::biolith$setDimensionType);
    }

    @Override
    public void biolith$setDimensionType(ResourceKey<DimensionType> dimensionTypeKey) {
        if (!biolith$dimensionType.location().equals(InterfaceBiomeSource.DIMENSION_TYPE_UNDEFINED.location()) &&
                !biolith$dimensionType.location().equals(dimensionTypeKey.location())) {
            Biolith.LOGGER.warn("Dimension Type modified: from '{}' to '{}'",
                    biolith$dimensionType.location(), dimensionTypeKey.location());
        }

        biolith$dimensionType = dimensionTypeKey;
    }
}