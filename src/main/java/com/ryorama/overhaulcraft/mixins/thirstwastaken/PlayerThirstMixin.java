package com.ryorama.overhaulcraft.mixins.thirstwastaken;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.OverhaulCraft;
import dev.ghen.thirst.content.thirst.PlayerThirst;
import dev.ghen.thirst.foundation.config.CommonConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@IfModLoaded("thirst")
@Mixin(PlayerThirst.class)
public class PlayerThirstMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;get()Ljava/lang/Object;"), remap = false)
    private Object peaceful_thirst$tickInject(ModConfigSpec.ConfigValue instance) {
        if (instance.getSpec().equals(CommonConfig.THIRST_DEPLETION_IN_PEACEFUL.getSpec())) {
            return OverhaulCraft.CONFIG.peacefulThirst;
        }
        return instance;
    }
}
