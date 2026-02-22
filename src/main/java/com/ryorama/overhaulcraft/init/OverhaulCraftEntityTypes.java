package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;

public class OverhaulCraftEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.ENTITY_TYPE);
}
