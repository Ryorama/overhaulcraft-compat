package com.ryorama.tstpcontent.init;

import net.minecraft.world.effect.MobEffectInstance;

public class TstpContentEffectInstances {

    public static final MobEffectInstance RANDOMIUMSIGHTEFFECT;

    static {
        RANDOMIUMSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.RANDOMIUMSIGHT.get(), 6000, 0, false, true, true);
    }
}
