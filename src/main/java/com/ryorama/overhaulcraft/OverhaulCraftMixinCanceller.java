package com.ryorama.overhaulcraft;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class OverhaulCraftMixinCanceller implements MixinCanceller {
    @Override
    public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
        /*
        if (mixinClassName.equals("com.smushytaco.solar_apocalypse.mixins.WaterIsFinite")) {
            return true;
        }
        */
        return false;
    }
}