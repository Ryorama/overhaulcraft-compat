package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.entity.particle.NuclearExplosionEffect;
import com.ryorama.tstpcontent.entity.tile.HamsterWheelGeneratorBlockEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TstpContentModEntities {

    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TstpContentMod.MODID);

    public static final RegistryObject<EntityType<NuclearExplosionEffect>> NUCLEAR_EXPLOSION_EFFECT = REGISTRY.register(
            "nuclear_explosion_effect",
            () -> EntityType.Builder.of(NuclearExplosionEffect::new, MobCategory.MISC).sized(1, 1).fireImmune().updateInterval(1).build("nuclear_explosion_effect")
    );


}
