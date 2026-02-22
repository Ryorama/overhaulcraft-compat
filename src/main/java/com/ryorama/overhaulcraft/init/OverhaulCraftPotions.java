package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.alchemy.Potion;

public class OverhaulCraftPotions {

    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.POTION);

    public static final RegistrySupplier<Potion> RANDOMIUM_SIGHT = REGISTRY.register("randomium_sight", () -> new Potion("randomium_sight", OverhaulCraftEffectInstances.RANDOMIUMSIGHTEFFECT));
    public static final RegistrySupplier<Potion> DRACONIUM_SIGHT = REGISTRY.register("draconium_sight", () -> new Potion("draconium_sight", OverhaulCraftEffectInstances.DRACONIUMSIGHTEFFECT));
    public static final RegistrySupplier<Potion> SULFUR_SIGHT = REGISTRY.register("sulfur_sight", () -> new Potion("sulfur_sight", OverhaulCraftEffectInstances.SULFURSIGHTEFFECT));
    public static final RegistrySupplier<Potion> NITER_SIGHT = REGISTRY.register("niter_sight", () -> new Potion("niter_sight", OverhaulCraftEffectInstances.NITERSIGHTEFFECT));
}
