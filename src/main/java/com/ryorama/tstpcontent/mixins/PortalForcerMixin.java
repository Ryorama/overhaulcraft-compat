package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.portal.PortalForcer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PortalForcer.class)
public class PortalForcerMixin {

    @Inject(at = @At("HEAD"), method = "createPortal", cancellable = true)
    public void createPortal(BlockPos blockPos, Direction.Axis axis, CallbackInfoReturnable<Optional<BlockUtil.FoundRectangle>> info) {
        if (TstpContentMod.CONFIG.restrictNetherAndEndToPlanets) {
            info.setReturnValue(Optional.empty());
        }
    }
}