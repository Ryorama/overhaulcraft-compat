package com.ryorama.overhaulcraft.init;

import net.minecraft.world.effect.MobEffectInstance;

public class TstpContentEffectInstances {

    public static final MobEffectInstance RANDOMIUMSIGHTEFFECT;
    public static final MobEffectInstance DRACONIUMSIGHTEFFECT;
    public static final MobEffectInstance SULFURSIGHTEFFECT;
    public static final MobEffectInstance NITERSIGHTEFFECT;

    static {
        RANDOMIUMSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.RANDOMIUMSIGHT, 6000, 0, false, true, true);
        DRACONIUMSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.DRACONIUMSIGHT, 6000, 0, false, true, true);
        SULFURSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.SULFURSIGHT, 6000, 0, false, true, true);
        NITERSIGHTEFFECT = new MobEffectInstance(TstpContentModEffects.NITERSIGHT, 6000, 0, false, true, true);
    }
}
