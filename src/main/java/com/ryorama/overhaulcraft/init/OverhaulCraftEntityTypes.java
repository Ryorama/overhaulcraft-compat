package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.compat.confluence.entity.npc.AbstractTerraMcaNPC;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.conczin.mca.entity.ai.relationship.Gender;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;

public class OverhaulCraftEntityTypes {
//    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.ENTITY_TYPE);
//
//    public static final DeferredHolder<EntityType<?>, EntityType<?>> GUIDE_MCA = registerOnCondition(ExtraFunc.isModInstalled("confluence"), "guide", () -> EntityType.Builder.of((entityType, level) -> new AbstractTerraMcaNPC(entityType, level, Gender.MALE), MobCategory.MISC).build("guide"));
//
//    static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<?>> registerOnCondition(boolean condition, String name, EntityType.EntityFactory<T> factory) {
//        if (condition) return REGISTRY.register();
//        return null;
//    }
}
