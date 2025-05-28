package com.ryorama.tstpcontent.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import com.ryorama.tstpcontent.TstpContentMod;

public class TstpContentModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TstpContentMod.MODID);

	public static final RegistryObject<SoundEvent> ARMADILLO_EAT = REGISTRY.register("entity.armadillo.eat", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.eat")));
	public static final RegistryObject<SoundEvent> ARMADILLO_HURT = REGISTRY.register("entity.armadillo.hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.hurt")));
	public static final RegistryObject<SoundEvent> ARMADILLO_HURT_REDUCED = REGISTRY.register("entity.armadillo.hurt_reduced", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.hurt_reduced")));
	public static final RegistryObject<SoundEvent> ARMADILLO_AMBIENT = REGISTRY.register("entity.armadillo.ambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.ambient")));
	public static final RegistryObject<SoundEvent> ARMADILLO_STEP = REGISTRY.register("entity.armadillo.step", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.step")));
	public static final RegistryObject<SoundEvent> ARMADILLO_DEATH = REGISTRY.register("entity.armadillo.death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.death")));
	public static final RegistryObject<SoundEvent> ARMADILLO_ROLL = REGISTRY.register("entity.armadillo.roll", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.roll")));
	public static final RegistryObject<SoundEvent> ARMADILLO_LAND = REGISTRY.register("entity.armadillo.land", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.land")));
	public static final RegistryObject<SoundEvent> ARMADILLO_SCUTE_DROP = REGISTRY.register("entity.armadillo.scute_drop", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.scute_drop")));
	public static final RegistryObject<SoundEvent> ARMADILLO_UNROLL_FINISH = REGISTRY.register("entity.armadillo.unroll_finish", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.unroll_finish")));
	public static final RegistryObject<SoundEvent> ARMADILLO_PEEK = REGISTRY.register("entity.armadillo.peek", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.peek")));
	public static final RegistryObject<SoundEvent> ARMADILLO_UNROLL_START = REGISTRY.register("entity.armadillo.unroll_start", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.unroll_start")));
	public static final RegistryObject<SoundEvent> ARMADILLO_BRUSH = REGISTRY.register("entity.armadillo.brush", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("entity.armadillo.brush")));
}
