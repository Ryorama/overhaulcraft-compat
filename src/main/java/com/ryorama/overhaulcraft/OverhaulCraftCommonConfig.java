package com.ryorama.overhaulcraft;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class OverhaulCraftCommonConfig {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue RESTRICT_DIMENSION_TRAVEL_TO_PLANETS = BUILDER.define("restrictDimensionTravelToPlanets", false);
    public static final ModConfigSpec.BooleanValue RESTRICT_NETHER_AND_END_TO_PLANETS = BUILDER.define("restrictNetherAndEndToPlanets", false);
    public static final ModConfigSpec.ConfigValue<Float> CONVERSION_CRUCIBLE_RADIUS = BUILDER.define("conversionCrucibleRadius", 10f);
    public static final ModConfigSpec.BooleanValue PEACEFUL_HUNGER = BUILDER.define("peacefulHunger", false);
    public static final ModConfigSpec.BooleanValue PEACEFUL_THIRST = BUILDER.define("peacefulThirst", false);
    public static final ModConfigSpec.BooleanValue ENABLE_GREGTECH_RECIPES = BUILDER.define("enableGregtechRecipes", false);
    public static final ModConfigSpec.BooleanValue STAT_DECREASE_DURING_BOSS = BUILDER.define("statDecreaseDuringBoss", false);
    public static final ModConfigSpec.ConfigValue<Integer> TWILIGHT_FOREST_GEAR_TICK_DELAY = BUILDER.define("twilightForestGearTickDelay", 2);
    public static final ModConfigSpec.ConfigValue<List<String>> SUPPLEMENTARIES_CAGE_ENTITY_BLACKLIST = BUILDER.define("supplementariesCageEntityBacklist", new ArrayList<>());

    public static final ModConfigSpec SPEC = BUILDER.build();
}