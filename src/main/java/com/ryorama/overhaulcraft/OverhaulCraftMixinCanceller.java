package com.ryorama.overhaulcraft;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OverhaulCraftMixinCanceller implements MixinCanceller {
    Set<String> mixinList = Set.of(
            "com.terraformersmc.biolith.impl.mixin.MixinMultiNoiseBiomeSource",
            "org.confluence.mod.mixin.client.gui.WorldSelectionList$WorldListEntryMixin",
            "org.confluence.mod.mixin.item.DataComponentsMixin",
            "org.confluence.mod.mixin.item.InventoryMixin",
            "org.mesdag.confluence_dimension_patch.mixin.BiomeSourceMixin",
            "org.mesdag.confluence_dimension_patch.mixin.ChunkMapMixin",
            "org.mesdag.confluence_dimension_patch.mixin.NoiseBasedChunkGeneratorMixin",
            "org.mesdag.confluence_dimension_patch.mixin.RandomStateMixin",
            "org.mesdag.confluence_dimension_patch.mixin.RegistryDataLoader$RegistryDataMixin",
            "weather2.mixin.client.RenderParticlesOverride"
    );

    @Override
    public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
        return mixinList.contains(mixinClassName);
    }
}