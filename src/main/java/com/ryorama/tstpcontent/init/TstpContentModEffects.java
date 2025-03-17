package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.TstpTags;
import com.thevortex.potionsmaster.items.potions.effect.oresight.OreSightEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TstpContentModEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TstpContentMod.MODID);

    public static RegistryObject<MobEffect> RANDOMIUMSIGHT = REGISTRY.register("randomium_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TstpTags.RANDOMIUM_ORE.toString(), 9766589));
    public static RegistryObject<MobEffect> DRACONIUMSIGHT = REGISTRY.register("draconium_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TstpTags.DRACONIUM_ORE.toString(), 7671180));
    public static RegistryObject<MobEffect> SULFURSIGHT = REGISTRY.register("sulfur_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TstpTags.SULFUR_ORE.toString(), 14147613));
    public static RegistryObject<MobEffect> NITERSIGHT = REGISTRY.register("niter_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TstpTags.NITER_ORE.toString(), 14079691));
}
