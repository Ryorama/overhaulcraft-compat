package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OverhaulCraftSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, OverhaulCraft.MODID);

	public static final DeferredHolder<SoundEvent, SoundEvent> DAY1 = REGISTRY.register("day1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "day1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NIGHT = REGISTRY.register("night", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "night")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RAIN = REGISTRY.register("rain", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "rain")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND1 = REGISTRY.register("underground1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "underground1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SPACE = REGISTRY.register("space", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "space")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERWORLD = REGISTRY.register("underworld", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "underworld")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CORRUPTION = REGISTRY.register("corruption", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "corruption")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CRIMSON = REGISTRY.register("crimson", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "crimson")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HALLOW = REGISTRY.register("hallow", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "hallow")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND_CORRUPTION = REGISTRY.register("underground_corruption", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "underground_corruption")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND_CRIMSON = REGISTRY.register("underground_crimson", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "underground_crimson")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND_HALLOW = REGISTRY.register("underground_hallow", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "underground_hallow")));
	public static final DeferredHolder<SoundEvent, SoundEvent> OCEAN = REGISTRY.register("ocean", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "ocean")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DUNGEON = REGISTRY.register("dungeon", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "dungeon")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSHROOM = REGISTRY.register("mushroom", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "mushroom")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS1 = REGISTRY.register("boss1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "boss1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS2 = REGISTRY.register("boss2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "boss2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS3 = REGISTRY.register("boss3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "boss3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS4 = REGISTRY.register("boss4", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "boss4")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOSS5 = REGISTRY.register("boss5", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "boss5")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEERCLOPS = REGISTRY.register("deerclops", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "deerclops")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SLIME_RAIN = REGISTRY.register("slime_rain", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "slime_rain")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GOBLIN_ARMY = REGISTRY.register("goblin_army", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "goblin_army")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EERIE = REGISTRY.register("eerie", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "eerie")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PUMPKIN_MOON = REGISTRY.register("pumpkin_moon", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "pumpkin_moon")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FROST_MOON = REGISTRY.register("frost_moon", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "frost_moon")));
}
