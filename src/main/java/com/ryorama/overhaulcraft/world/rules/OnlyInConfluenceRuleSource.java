package com.ryorama.overhaulcraft.world.rules;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;

public record OnlyInConfluenceRuleSource(SurfaceRules.RuleSource otherworld) implements SurfaceRules.RuleSource {
    public static final KeyDispatchDataCodec<OnlyInConfluenceRuleSource> CODEC = KeyDispatchDataCodec.of(RecordCodecBuilder.mapCodec(instance -> instance.group(
            SurfaceRules.RuleSource.CODEC.fieldOf("otherworld").forGetter(OnlyInConfluenceRuleSource::otherworld)
    ).apply(instance, OnlyInConfluenceRuleSource::new)));

    @Override
    public KeyDispatchDataCodec<OnlyInConfluenceRuleSource> codec() {
        return CODEC;
    }

    @Override
    public SurfaceRules.SurfaceRule apply(SurfaceRules.Context context) {
        if (IDimensionAccessor.of(context.system).oc$isNotOverworld()) {
            return otherworld.apply(context);
        }
        return (x, y, z) -> null;
    }
}