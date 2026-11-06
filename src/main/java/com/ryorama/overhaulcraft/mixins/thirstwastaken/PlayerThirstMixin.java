package com.ryorama.overhaulcraft.mixins.thirstwastaken;

import cn.mlus.thirst.content.thirst.PlayerThirst;
import cn.mlus.thirst.foundation.config.CommonConfig;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.OverhaulCraftCommonConfig;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@IfModLoaded("thirst")
@Mixin(PlayerThirst.class)
public class PlayerThirstMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;get()Ljava/lang/Object;"), remap = false)
    private Object peaceful_thirst$tickInject(ModConfigSpec.ConfigValue instance) {
        if (instance.getSpec() == CommonConfig.THIRST_DEPLETION_IN_PEACEFUL.getSpec()) return OverhaulCraftCommonConfig.PEACEFUL_THIRST.get();
        return instance;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    public Difficulty tick(Level instance) {
        if (!OverhaulCraftCommonConfig.STAT_DECREASE_DURING_BOSS.get()) {
            if (instance instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel) instance;
                if (ExtraFunc.isBossAlive(serverLevel)) {
                    return Difficulty.PEACEFUL;
                }
            }
        }
        return instance.getDifficulty();
    }
}