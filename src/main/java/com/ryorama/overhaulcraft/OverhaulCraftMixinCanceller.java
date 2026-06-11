package com.ryorama.overhaulcraft;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.ArrayList;
import java.util.List;

public class OverhaulCraftMixinCanceller implements MixinCanceller {
    List<String> mixinList = new ArrayList<>();

    public OverhaulCraftMixinCanceller() {
        mixinList.add("com.teamabnormals.atmospheric.core.mixin.CamelMixin");
        mixinList.add("com.teamabnormals.atmospheric.core.mixin.client.CamelRendererMixin");
        mixinList.add("org.confluence.mod.mixin.client.gui.WorldSelectionList$WorldListEntryMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.BiomeSourceMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.ChunkGeneratorMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.ChunkGeneratorStructureStateMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.ChunkMapMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.ModBiomesMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.OverworldUtilsMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.NoiseBasedChunkGeneratorMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.PlacedFeatureMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.StructureSetMixin");
        mixinList.add("org.mesdag.confluence_dimension_patch.mixin.SurfaceSystemMixin");
    }

    @Override
    public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
        for (String mixin : mixinList) {
            if (mixinClassName.equals(mixin)) {
                return true;
            }
        }
        return false;
    }
}