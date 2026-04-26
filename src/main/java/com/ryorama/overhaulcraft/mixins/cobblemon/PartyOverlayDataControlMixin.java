package com.ryorama.overhaulcraft.mixins.cobblemon;

import com.cobblemon.mod.common.client.gui.PartyOverlayDataControl;
import com.ryorama.overhaulcraft.utils.IOverhaulPlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PartyOverlayDataControl.class, remap = false)
public class PartyOverlayDataControlMixin {
    @Inject(at = @At("HEAD"), method = "playSound", cancellable = true)
    private void playSound(SoundEvent soundEvent, CallbackInfoReturnable<SoundInstance> cir) {
        Minecraft minecraftInstance = Minecraft.getInstance();
        if (!((IOverhaulPlayerData)minecraftInstance.player).getCobblemonFuncUnlocked()) cir.setReturnValue(null);
    }
}
