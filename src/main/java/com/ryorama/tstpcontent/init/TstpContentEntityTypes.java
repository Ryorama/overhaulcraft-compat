package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.entities.RadsterEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TstpContentEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TstpContentMod.MODID);

    public static final RegistryObject<EntityType<RadsterEntity>> RADSTER = REGISTRY.register("radster", () ->
            EntityType.Builder.of(RadsterEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(TstpContentMod.MODID, "radster").toString())
    );
}
