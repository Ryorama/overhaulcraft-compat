package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.utils.TstpTags;
import com.thevortex.potionsmaster.items.potions.effect.oresight.OreSightEffect;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class OverhaulCraftEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.MOB_EFFECT);

    public static RegistrySupplier<MobEffect> RANDOMIUMSIGHT = REGISTRY.register("randomium_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TstpTags.RANDOMIUM_ORE.toString(), 9766589));
    public static RegistrySupplier<MobEffect> DRACONIUMSIGHT = REGISTRY.register("draconium_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TstpTags.DRACONIUM_ORE.toString(), 7671180));
    public static RegistrySupplier<MobEffect> SULFURSIGHT = REGISTRY.register("sulfur_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TstpTags.SULFUR_ORE.toString(), 14147613));
    public static RegistrySupplier<MobEffect> NITERSIGHT = REGISTRY.register("niter_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TstpTags.NITER_ORE.toString(), 14079691));
}
