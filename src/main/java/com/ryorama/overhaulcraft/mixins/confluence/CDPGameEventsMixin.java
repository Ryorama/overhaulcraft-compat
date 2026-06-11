package com.ryorama.overhaulcraft.mixins.confluence;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import org.confluence.mod.util.ModUtils;
import org.mesdag.confluence_dimension_patch.common.CDPGameEvents;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@IfModLoaded("confluence_dimension_patch")
@Mixin(CDPGameEvents.class)
public class CDPGameEventsMixin {
    @Inject(at = @At("HEAD"), method = "mobSpawn$PositionCheck")
    private static void mobSpawn$PositionCheck(MobSpawnEvent.PositionCheck event, CallbackInfo ci) {
        if (event.getEntity().level().dimension() == OtherWorld.LEVEL) {
            if (!ModUtils.isFromConfluence(BuiltInRegistries.ENTITY_TYPE, event.getEntity().getType())) {
                event.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
            }
        }
    }
}
