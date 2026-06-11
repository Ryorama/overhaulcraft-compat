package com.ryorama.overhaulcraft.world.rules;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;

public record OnlyInCoblemonRuleSource(SurfaceRules.RuleSource cobblemon_dim) implements SurfaceRules.RuleSource {
    public static final KeyDispatchDataCodec<OnlyInCoblemonRuleSource> CODEC = KeyDispatchDataCodec.of(RecordCodecBuilder.mapCodec(instance -> instance.group(
            SurfaceRules.RuleSource.CODEC.fieldOf("cobblemon_dim").forGetter(OnlyInCoblemonRuleSource::cobblemon_dim)
    ).apply(instance, OnlyInCoblemonRuleSource::new)));

    @Override
    public KeyDispatchDataCodec<OnlyInCoblemonRuleSource> codec() {
        return CODEC;
    }

    @Override
    public SurfaceRules.SurfaceRule apply(SurfaceRules.Context context) {
        return IDimensionAccessor.of(context.system).oc$isCobblemon() ? cobblemon_dim.apply(context) : (x, y, z) -> null;
    }
}