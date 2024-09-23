package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.reference.OresRef;
import com.thevortex.potionsmaster.items.potions.effect.oresight.OreSightEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TstpContentModEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TstpContentMod.MODID);

    public static RegistryObject<MobEffect> RANDOMIUMSIGHT = REGISTRY.register("randomiumpotioneffect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, OresRef.RANDOMIUM.toString(), 9766589));
}
