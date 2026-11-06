package com.ryorama.overhaulcraft;

import net.neoforged.neoforge.common.ModConfigSpec;

public class OverhaulCraftClientConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue PLAY_BOSS_MUSIC = BUILDER.define("playBossMusic", false);
    public static final ModConfigSpec.BooleanValue PLAY_TERRARIA_MUSIC = BUILDER.define("playTerrariaMusic", false);
    public static final ModConfigSpec.ConfigValue<Integer> MUSIC_CHECK_DELAY = BUILDER.define("musicCheckDelay", 1);
    public static final ModConfigSpec.ConfigValue<Integer> COSMONAUTICS_PLASMA_RENDERER_DELAY_PER_SECONDS = BUILDER.define("cosmonauticsPlasmaRendererDelayPerSeconds", 2);

    public static final ModConfigSpec SPEC = BUILDER.build();
}
