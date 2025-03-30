package com.ryorama.tstpcontent.init;

import net.minecraft.world.effect.MobEffectInstance;

public class TstpContentEffectInstances {

    public static final MobEffectInstance RANDOMIUMSIGHTEFFECT;
    public static final MobEffectInstance DRACONIUMSIGHTEFFECT;
    public static final MobEffectInstance SULFURSIGHTEFFECT;
    public static final MobEffectInstance NITERSIGHTEFFECT;

    static {
        RANDOMIUMSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.RANDOMIUMSIGHT.get(), 6000, 0, false, true, true);
        DRACONIUMSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.DRACONIUMSIGHT.get(), 6000, 0, false, true, true);
        SULFURSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.SULFURSIGHT.get(), 6000, 0, false, true, true);
        NITERSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.NITERSIGHT.get(), 6000, 0, false, true, true);
    }
}
