package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TstpContentModPotions {

    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, TstpContentMod.MODID);

    public static final RegistryObject<Potion> RANDOMIUM_SIGHT = REGISTRY.register("randomium_sight", () -> new Potion("randomium_sight", TstpContentEffectInstances.RANDOMIUMSIGHTEFFECT));
    public static final RegistryObject<Potion> DRACONIUM_SIGHT = REGISTRY.register("draconium_sight", () -> new Potion("draconium_sight", TstpContentEffectInstances.DRACONIUMSIGHTEFFECT));
    public static final RegistryObject<Potion> SULFUR_SIGHT = REGISTRY.register("sulfur_sight", () -> new Potion("sulfur_sight", TstpContentEffectInstances.SULFURSIGHTEFFECT));
    public static final RegistryObject<Potion> NITER_SIGHT = REGISTRY.register("niter_sight", () -> new Potion("niter_sight", TstpContentEffectInstances.NITERSIGHTEFFECT));
}
