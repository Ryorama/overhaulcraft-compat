package com.ryorama.tstpcontent.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

public class Utils {
    public static boolean isInSpace(LevelAccessor world) {
        return ((ServerLevelAccessor)world).getLevel().dimension().location().equals(new ResourceLocation("cosmos:solar_sys_d")) || ((ServerLevelAccessor)world).getLevel().dimension().location().equals(new ResourceLocation("cosmos:alpha_sys_d"));
    }
}
