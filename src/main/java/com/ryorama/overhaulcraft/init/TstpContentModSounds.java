package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.TstpContentMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TstpContentModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, TstpContentMod.MODID);

	public static final DeferredHolder<SoundEvent, SoundEvent> DAY1 = REGISTRY.register("day1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "day1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NIGHT = REGISTRY.register("night", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "night")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RAIN = REGISTRY.register("rain", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "rain")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND1 = REGISTRY.register("underground1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "underground1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SPACE = REGISTRY.register("space", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "space")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERWORLD = REGISTRY.register("underworld", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "underworld")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CORRUPTION = REGISTRY.register("corruption", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "corruption")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CRIMSON = REGISTRY.register("crimson", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "crimson")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HALLOW = REGISTRY.register("hallow", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "hallow")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND_CORRUPTION = REGISTRY.register("underground_corruption", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "underground_corruption")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND_CRIMSON = REGISTRY.register("underground_crimson", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "underground_crimson")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND_HALLOW = REGISTRY.register("underground_hallow", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "underground_hallow")));
	public static final DeferredHolder<SoundEvent, SoundEvent> OCEAN = REGISTRY.register("ocean", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "ocean")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DUNGEON = REGISTRY.register("dungeon", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "dungeon")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSHROOM = REGISTRY.register("mushroom", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "mushroom")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS1 = REGISTRY.register("boss1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "boss1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS2 = REGISTRY.register("boss2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "boss2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS3 = REGISTRY.register("boss3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "boss3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS4 = REGISTRY.register("boss4", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "boss4")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS5 = REGISTRY.register("boss5", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "boss5")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SLIME_RAIN = REGISTRY.register("slime_rain", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "slime_rain")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GOBLIN_ARMY = REGISTRY.register("goblin_army", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "goblin_army")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EERIE = REGISTRY.register("eerie", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TstpContentMod.MODID, "eerie")));

}
