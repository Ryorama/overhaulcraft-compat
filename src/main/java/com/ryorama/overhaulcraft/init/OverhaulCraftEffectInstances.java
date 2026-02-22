package com.ryorama.overhaulcraft.init;

import net.minecraft.world.effect.MobEffectInstance;

public class OverhaulCraftEffectInstances {

    public static final MobEffectInstance RANDOMIUMSIGHTEFFECT;
    public static final MobEffectInstance DRACONIUMSIGHTEFFECT;
    public static final MobEffectInstance SULFURSIGHTEFFECT;
    public static final MobEffectInstance NITERSIGHTEFFECT;

    static {
        RANDOMIUMSIGHTEFFECT = new MobEffectInstance(OverhaulCraftEffects.RANDOMIUMSIGHT, 6000, 0, false, true, true);
        DRACONIUMSIGHTEFFECT = new MobEffectInstance(OverhaulCraftEffects.DRACONIUMSIGHT, 6000, 0, false, true, true);
        SULFURSIGHTEFFECT = new MobEffectInstance(OverhaulCraftEffects.SULFURSIGHT, 6000, 0, false, true, true);
        NITERSIGHTEFFECT = new MobEffectInstance(OverhaulCraftEffects.NITERSIGHT, 6000, 0, false, true, true);
    }
}
