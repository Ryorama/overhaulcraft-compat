package com.ryorama.overhaulcraft.mixins;

import com.ryorama.overhaulcraft.OverhaulCraft;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(MusicManager.class)
public class MusicManagerMixin {
    @Shadow
    @Nullable
    public SoundInstance currentMusic;

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;getSituationalMusic()Lnet/minecraft/sounds/Music;", shift = At.Shift.AFTER), method = "tick", cancellable = true)
    public void tick(CallbackInfo ci) {
        if (currentMusic != null) {
            if (currentMusic.getLocation().equals(OverhaulCraft.MODID)) {
                ci.cancel();
            }
        }
    }
}
