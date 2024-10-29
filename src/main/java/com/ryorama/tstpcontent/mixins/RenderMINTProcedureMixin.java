package com.ryorama.tstpcontent.mixins;

import net.lointain.cosmos.procedures.RenderMINTProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderMINTProcedure.class)
public class RenderMINTProcedureMixin {
    @Inject(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;DD)V", at = @At(value = "INVOKE", target = "Lnet/lointain/cosmos/procedures/RenderMINTProcedure;system(Z)V"), remap = false)
    private static void execute(Event event, LevelAccessor world, Entity entity, double partialTick, double ticks, CallbackInfo ci) {
        System.out.println("RenderMINTProcedureMixin Running");
        if (entity.level().dimension().location().equals(new ResourceLocation("minecraft:overworld"))) {
            return;
        }
        if (entity.level().dimension().location().equals(new ResourceLocation("minecraft:overworld"))) {
            System.out.println("RenderMINTProcedureMixin Error. Did not return correctly");
        } else {
            System.out.println("RenderMINTProcedureMixin. Did not return, dimension is: " + entity.level().dimension());
        }
    }
}
