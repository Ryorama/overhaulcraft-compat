package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.WolfVarient;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(Wolf.class)
public abstract class WolfMixin extends TamableAnimal implements NeutralMob, WolfVarient {
    private static final EntityDataAccessor<Integer> DATA_VARIANT;
    private static Map<Biome, Integer> varientSpawnData = new HashMap<>();

    protected WolfMixin(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("TAIL"), method = "<init>")
    public void init(EntityType arg, Level arg2, CallbackInfo ci) {
        Registry<Biome> biomeRegistryAcess = arg2.registryAccess().registryOrThrow(Registries.BIOME);

        varientSpawnData.put(biomeRegistryAcess.get(Biomes.SNOWY_TAIGA), 1);
        varientSpawnData.put(biomeRegistryAcess.get(Biomes.OLD_GROWTH_PINE_TAIGA), 2);
        varientSpawnData.put(biomeRegistryAcess.get(Biomes.OLD_GROWTH_SPRUCE_TAIGA), 3);
        varientSpawnData.put(biomeRegistryAcess.get(Biomes.TAIGA), 4);
        varientSpawnData.put(biomeRegistryAcess.get(Biomes.SPARSE_JUNGLE), 5);
        varientSpawnData.put(biomeRegistryAcess.get(Biomes.GROVE), 6);
        varientSpawnData.put(biomeRegistryAcess.get(Biomes.SAVANNA_PLATEAU), 7);
        varientSpawnData.put(biomeRegistryAcess.get(Biomes.WOODED_BADLANDS), 8);
        varientSpawnData.put(biomeRegistryAcess.get(Biomes.FOREST), 9);
    }
    @Inject(at = @At("TAIL"), method = "addAdditionalSaveData")
    public void addAdditionalSaveData(CompoundTag arg, CallbackInfo ci) {
        arg.putInt("VariantType", this.entityData.get(DATA_VARIANT));
    }

    @Inject(at = @At("TAIL"), method = "readAdditionalSaveData")
    public void readAdditionalSaveData(CompoundTag arg, CallbackInfo ci) {
        this.entityData.set(DATA_VARIANT, arg.getInt("VariantType"));
    }

    @Inject(at = @At("TAIL"), method = "defineSynchedData")
    protected void defineSynchedData(CallbackInfo ci) {
        this.entityData.define(DATA_VARIANT, 0);
    }

    @Override
    public EntityDataAccessor<Integer> getVariant() {
        return DATA_VARIANT;
    }

    @Override
    public Map<Biome, Integer> getVariantSpawnData() {
        return varientSpawnData;
    }

    /**
     * @author Ryorama
     * @reason Replace
     */
    @Overwrite
    public int getMaxSpawnClusterSize() {
        return 8;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        Biome biome = serverLevelAccessor.getBiome(this.blockPosition()).get();
        List<Biome> biomeList = varientSpawnData.keySet().stream().toList();
        List<Integer> idList = varientSpawnData.values().stream().toList();

        for (int b = 0; b < varientSpawnData.size(); b++) {
            TstpContentMod.LOGGER.info("Wolf Spawn Biome: " + biomeList.get(b));
            TstpContentMod.LOGGER.info("Wolf Variant Id: " + idList.get(b));
            TstpContentMod.LOGGER.info("Wolf Biome: " + biome);

            if (biome.equals(biomeList.get(b))) {
                this.entityData.set(DATA_VARIANT, idList.get(b + 1));
            }
        }

        if (this.entityData.get(DATA_VARIANT) == 0) {
            this.entityData.set(DATA_VARIANT, 4);
        }

        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    static {
        DATA_VARIANT = SynchedEntityData.defineId(Wolf.class, EntityDataSerializers.INT);
    }
}