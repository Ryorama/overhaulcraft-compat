package com.ryorama.tstpcontent.mixins.thirstwastaken;

import com.ryorama.tstpcontent.TstpContentMod;
import dev.ghen.thirst.content.thirst.PlayerThirst;
import dev.ghen.thirst.foundation.config.CommonConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeConfigSpec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerThirst.class)
public class PlayerThirstMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;get()Ljava/lang/Object;"), remap = false)
    private Object peaceful_thirst$tickInject(ForgeConfigSpec.ConfigValue instance) {
        if (instance == CommonConfig.THIRST_DEPLETION_IN_PEACEFUL) {
            if (TstpContentMod.CONFIG.peacefulThirst) {
                instance.set(true);
            }
        }
        return instance.get();
    }
}