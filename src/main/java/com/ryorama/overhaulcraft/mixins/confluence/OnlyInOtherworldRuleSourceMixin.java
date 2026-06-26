package com.ryorama.overhaulcraft.mixins.confluence;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.mixed.IDimensionAccessor;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.mesdag.confluence_dimension_patch.common.OnlyInOtherworldRuleSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(OnlyInOtherworldRuleSource.class)
public class OnlyInOtherworldRuleSourceMixin {
    @Shadow @Final private SurfaceRules.RuleSource otherworld;

    @ModifyReturnValue(at = @At("RETURN"), method = "apply(Lnet/minecraft/world/level/levelgen/SurfaceRules$Context;)Lnet/minecraft/world/level/levelgen/SurfaceRules$SurfaceRule;", remap = false)
    public SurfaceRules.SurfaceRule apply(SurfaceRules.SurfaceRule original, SurfaceRules.Context context) {
        return IDimensionAccessor.of(context.system).oc$isConfluence() ? otherworld.apply(context) : (x, y, z) -> null;
    }
}