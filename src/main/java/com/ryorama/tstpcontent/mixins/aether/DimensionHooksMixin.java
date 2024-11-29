package com.ryorama.tstpcontent.mixins.aether;

import com.aetherteam.aether.event.hooks.DimensionHooks;
import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionHooks.class)
public class DimensionHooksMixin {
    @Inject(at = @At("HEAD"), method = "createPortal", cancellable = true, remap = false)
    private static void createPortal(Player player, Level level, BlockPos pos, Direction direction, ItemStack stack, InteractionHand hand, CallbackInfoReturnable<Boolean> info) {
        if (TstpContentMod.CONFIG.restrictDimensionTravelToPlanets) {
            info.cancel();
        }
    }
}
