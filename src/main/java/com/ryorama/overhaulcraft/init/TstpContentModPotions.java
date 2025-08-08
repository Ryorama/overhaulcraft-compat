package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.TstpContentMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.alchemy.Potion;

public class TstpContentModPotions {

    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(TstpContentMod.MODID, Registries.POTION);

    public static final RegistrySupplier<Potion> RANDOMIUM_SIGHT = REGISTRY.register("randomium_sight", () -> new Potion("randomium_sight", TstpContentEffectInstances.RANDOMIUMSIGHTEFFECT));
    public static final RegistrySupplier<Potion> DRACONIUM_SIGHT = REGISTRY.register("draconium_sight", () -> new Potion("draconium_sight", TstpContentEffectInstances.DRACONIUMSIGHTEFFECT));
    public static final RegistrySupplier<Potion> SULFUR_SIGHT = REGISTRY.register("sulfur_sight", () -> new Potion("sulfur_sight", TstpContentEffectInstances.SULFURSIGHTEFFECT));
    public static final RegistrySupplier<Potion> NITER_SIGHT = REGISTRY.register("niter_sight", () -> new Potion("niter_sight", TstpContentEffectInstances.NITERSIGHTEFFECT));
}
