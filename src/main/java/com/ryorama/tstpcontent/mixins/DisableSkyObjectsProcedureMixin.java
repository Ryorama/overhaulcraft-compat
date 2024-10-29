package com.ryorama.tstpcontent.mixins;

import net.lointain.cosmos.procedures.DisableSkyObjectsProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DisableSkyObjectsProcedure.class)
public class DisableSkyObjectsProcedureMixin {
    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Z", remap = false)
    private static void execute(Event event, LevelAccessor world, Entity entity, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("DisableSkyObjectsMixin Running");
        if (entity == null) {
            cir.setReturnValue(false);
        } else {
            if (entity.level().dimension().location().equals(new ResourceLocation("minecraft:overworld"))) {
                renderSky(false, false, false, false, false, false);
            }
        }
    }

    @Shadow(remap = false)
    public static void renderSky(boolean deepSky, boolean sunlights, boolean sun, boolean moon, boolean stars, boolean abyss) {}
}
