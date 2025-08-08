package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.TstpContentMod;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;

public class TstpContentEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(TstpContentMod.MODID, Registries.ENTITY_TYPE);

    /*
    public static final RegistryObject<EntityType<RadsterEntity>> RADSTER = REGISTRY.register("radster", () ->
            EntityType.Builder.of(RadsterEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(TstpContentMod.MODID, "radster").toString())
    );
     */
}
