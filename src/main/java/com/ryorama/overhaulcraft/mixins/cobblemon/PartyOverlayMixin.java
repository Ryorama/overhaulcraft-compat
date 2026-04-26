package com.ryorama.overhaulcraft.mixins.cobblemon;

import com.cobblemon.mod.common.client.gui.PartyOverlay;
import com.ryorama.overhaulcraft.utils.IOverhaulPlayerData;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PartyOverlay.class, remap = false)
public class PartyOverlayMixin {
    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        Minecraft minecraftInstance = Minecraft.getInstance();
        if (!((IOverhaulPlayerData)minecraftInstance.player).getCobblemonFuncUnlocked()) ci.cancel();
    }
}
