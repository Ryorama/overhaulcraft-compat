package com.ryorama.overhaulcraft.mixins;

import com.ryorama.overhaulcraft.OverhaulCraft;
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
        if (OverhaulCraft.CONFIG.peacefulHunger) {
            if (instance.getDifficulty() == Difficulty.PEACEFUL) {
                return Difficulty.EASY;
            }
        }
        return instance.getDifficulty();
    }
}