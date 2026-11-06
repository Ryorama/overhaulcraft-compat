package com.ryorama.overhaulcraft.world.placement;

import com.mojang.serialization.MapCodec;
import com.ryorama.overhaulcraft.init.OverhaulCraftPlacements;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import org.mesdag.confluence_dimension_patch.mixin.StructurePlacementAccessor;

import java.util.Optional;

public class OnlyInCobblemonStructurePlacement extends StructurePlacement {
    public static final MapCodec<OnlyInCobblemonStructurePlacement> CODEC = StructurePlacement.CODEC.fieldOf("delegate")
            .xmap(OnlyInCobblemonStructurePlacement::new, OnlyInCobblemonStructurePlacement::getDelegate);

    private final StructurePlacement delegate;

    public OnlyInCobblemonStructurePlacement(StructurePlacement delegate) {
        super(Vec3i.ZERO, FrequencyReductionMethod.DEFAULT, 1, 0, Optional.empty());
        this.delegate = delegate;
    }

    public StructurePlacement getDelegate() {
        return delegate;
    }

    @Override
    protected Vec3i locateOffset() {
        return ((StructurePlacementAccessor) delegate).callLocateOffset();
    }

    @Override
    protected StructurePlacement.FrequencyReductionMethod frequencyReductionMethod() {
        return ((StructurePlacementAccessor) delegate).callFrequencyReductionMethod();
    }

    @Override
    protected float frequency() {
        return ((StructurePlacementAccessor) delegate).callFrequency();
    }

    @Override
    protected int salt() {
        return ((StructurePlacementAccessor) delegate).callSalt();
    }

    @Override
    protected Optional<StructurePlacement.ExclusionZone> exclusionZone() {
        return ((StructurePlacementAccessor) delegate).callExclusionZone();
    }

    private static boolean in(ChunkGeneratorStructureState state) {
        return IDimensionAccessor.of(state.randomState()).oc$isCobblemon();
    }

    @Override
    public boolean isStructureChunk(ChunkGeneratorStructureState structureState, int x, int z) {
        return in(structureState) && delegate.isStructureChunk(structureState, x, z);
    }

    @Override
    public boolean applyAdditionalChunkRestrictions(int regionX, int regionZ, long levelSeed) {
        return delegate.applyAdditionalChunkRestrictions(regionX, regionZ, levelSeed);
    }

    @Override
    public boolean applyInteractionsWithOtherStructures(ChunkGeneratorStructureState structureState, int x, int z) {
        return in(structureState) && delegate.applyInteractionsWithOtherStructures(structureState, x, z);
    }

    @Override
    protected boolean isPlacementChunk(ChunkGeneratorStructureState structureState, int x, int z) {
        return in(structureState) && ((StructurePlacementAccessor) delegate).callIsPlacementChunk(structureState, x, z);
    }

    @Override
    public BlockPos getLocatePos(ChunkPos chunkPos) {
        return delegate.getLocatePos(chunkPos);
    }

    @Override
    public StructurePlacementType<?> type() {
        return OverhaulCraftPlacements.ONLY_IN_COBBLEMON_STRUCTURE_PLACEMENT.get();
    }
}
