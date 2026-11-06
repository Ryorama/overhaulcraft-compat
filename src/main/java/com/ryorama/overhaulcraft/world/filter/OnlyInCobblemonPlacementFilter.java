package com.ryorama.overhaulcraft.world.filter;

import com.mojang.serialization.MapCodec;
import com.ryorama.overhaulcraft.init.OverhaulCraftPlacements;
import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class OnlyInCobblemonPlacementFilter extends PlacementFilter {
    public static final OnlyInCobblemonPlacementFilter INSTANCE = new OnlyInCobblemonPlacementFilter();
    public static final MapCodec<OnlyInCobblemonPlacementFilter> CODEC = MapCodec.unit(INSTANCE);

    private OnlyInCobblemonPlacementFilter() {}

    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        return context.getLevel().getLevel().dimension() == CobblemonDim.LEVEL;
    }

    @Override
    public PlacementModifierType<?> type() {
        return OverhaulCraftPlacements.ONLY_IN_COBBLEMON_PLACEMENT_FILTER.get();
    }
}