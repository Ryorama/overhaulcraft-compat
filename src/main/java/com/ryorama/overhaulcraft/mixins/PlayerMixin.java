package com.ryorama.overhaulcraft.mixins;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.utils.IOverhaulPlayerData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity implements IOverhaulPlayerData {
    private static final EntityDataAccessor<Boolean> TERRARIA_FUNC_UNLOCKED;
    private static final EntityDataAccessor<Boolean> COBBLEMON_FUNC_UNLOCKED;

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    //Thanks to Peaceful Hunger by jason13official for original code: https://legacy.curseforge.com/minecraft/mc-mods/peaceful-hunger
    @Redirect(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty peaceful_hunger$tickInject(Level instance) {
        if (OverhaulCraft.CONFIG.peacefulHunger) {
            return Difficulty.EASY;
        }
        return instance.getDifficulty();
    }

    @Inject(at = @At("TAIL"), method = "readAdditionalSaveData")
    public void readAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
        setTerrariaFuncUnlocked(compound.getBoolean("terraria_func_unlocked"));
        setCobblemonFuncUnlocked(compound.getBoolean("cobblemon_func_unlocked"));
    }

    @Inject(at = @At("TAIL"), method = "addAdditionalSaveData")
    public void addAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
        compound.putBoolean("terraria_func_unlocked", getTerrariaFuncUnlocked());
        compound.putBoolean("cobblemon_func_unlocked", getCobblemonFuncUnlocked());
    }

    @Override
    public void setTerrariaFuncUnlocked(boolean value) {
        this.getEntityData().set(TERRARIA_FUNC_UNLOCKED, value);
    }

    @Override
    public boolean getTerrariaFuncUnlocked() {
        return this.getEntityData().get(TERRARIA_FUNC_UNLOCKED);
    }

    @Override
    public void setCobblemonFuncUnlocked(boolean value) {
        this.getEntityData().set(COBBLEMON_FUNC_UNLOCKED, value);
    }

    @Override
    public boolean getCobblemonFuncUnlocked() {
        return this.getEntityData().get(COBBLEMON_FUNC_UNLOCKED);
    }

    @Inject(at = @At("TAIL"), method = "defineSynchedData")
    protected void defineSynchedData(SynchedEntityData.Builder arg, CallbackInfo ci) {
        arg.define(TERRARIA_FUNC_UNLOCKED, false);
        arg.define(COBBLEMON_FUNC_UNLOCKED, false);
    }

    static {
        TERRARIA_FUNC_UNLOCKED = SynchedEntityData.defineId(Player.class, EntityDataSerializers.BOOLEAN);
        COBBLEMON_FUNC_UNLOCKED = SynchedEntityData.defineId(Player.class, EntityDataSerializers.BOOLEAN);
    }
}