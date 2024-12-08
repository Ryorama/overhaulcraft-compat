package com.ryorama.tstpcontent.mixins.phc2tree;

import com.pam.pamhc2trees.worldgen.ConfiguredFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ConfiguredFeatures.class)
public class ConfiguredFeaturesMixin {
    /**
     * @author Ryorama
     * @reason Remove tree generation in favor of croptopia
     */
    @Overwrite(remap = false)
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        return;
    }
}