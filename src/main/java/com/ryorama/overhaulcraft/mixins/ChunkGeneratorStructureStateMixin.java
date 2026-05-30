package com.ryorama.overhaulcraft.mixins;

import com.cobblemon.mod.common.Cobblemon;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import com.ryorama.overhaulcraft.mixed.IStructureSet;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import org.confluence.mod.Confluence;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ChunkGeneratorStructureState.class)
public abstract class ChunkGeneratorStructureStateMixin implements IDimensionAccessor {
    @Shadow
    @Final
    private List<Holder<StructureSet>> possibleStructureSets;
    @Unique
    private boolean oc$notOverworld = false;

    @Override
    public void oc$setIsNotOverworld() {
        this.oc$notOverworld = true;
    }

    @Override
    public boolean oc$isNotOverworld() {
        return oc$notOverworld;
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void mark(RandomState randomState, BiomeSource biomeSource, long levelSeed, long cocentricRingsSeed, List<Holder<StructureSet>> possibleStructureSets, CallbackInfo ci) {
        for (Holder<StructureSet> holder : this.possibleStructureSets) {
            ResourceKey<StructureSet> key = holder.getKey();
            IStructureSet.of(holder.value()).oc$setIsNotFromConfluence(key == null || !Confluence.MODID.equals(key.location().getNamespace()));
            IStructureSet.of(holder.value()).oc$setIsNotFromCobblemon(key == null || !key.location().getNamespace().contains("cobblemon"));
        }
    }
}
