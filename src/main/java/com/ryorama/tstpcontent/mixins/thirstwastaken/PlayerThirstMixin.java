package com.ryorama.tstpcontent.mixins.thirstwastaken;

import com.ryorama.tstpcontent.TstpContentMod;
import dev.ghen.thirst.content.thirst.PlayerThirst;
import net.minecraftforge.common.ForgeConfigSpec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerThirst.class)
public class PlayerThirstMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;get()Ljava/lang/Object;"), remap = false)
    private Object peaceful_thirst$tickInject(ForgeConfigSpec.ConfigValue instance) {
        return TstpContentMod.CONFIG.peacefulThirst;
    }
}