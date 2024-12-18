package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.TagsRef;
import com.thevortex.potionsmaster.items.potions.effect.oresight.OreSightEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TstpContentModEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TstpContentMod.MODID);

    public static RegistryObject<MobEffect> RANDOMIUMSIGHT = REGISTRY.register("randomium_ore_sight_effect", () -> new OreSightEffect(MobEffectCategory.BENEFICIAL, TagsRef.RANDOMIUM.toString(), 9766589));
}
