package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public class PlayerMixin {

    //Thanks to Peaceful Hunger by jason13official for original code: https://legacy.curseforge.com/minecraft/mc-mods/peaceful-hunger
    @Redirect(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty peaceful_hunger$tickInject(Level instance) {
        if (TstpContentMod.CONFIG.peacefulHunger) {
            return Difficulty.EASY;
        }
        return instance.getDifficulty();
    }
}