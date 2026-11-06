package com.ryorama.overhaulcraft.mixins;

import com.ryorama.overhaulcraft.OverhaulCraftCommonConfig;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FoodData.class)
public class FoodDataMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty peaceful_hunger$tickInject(Level instance) {
        if (OverhaulCraftCommonConfig.PEACEFUL_HUNGER.get()) {
            if (instance.getDifficulty() == Difficulty.PEACEFUL) {
                return Difficulty.EASY;
            }
        }
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