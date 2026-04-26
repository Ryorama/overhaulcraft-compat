package com.ryorama.overhaulcraft.mixins.easyvillagers;

import de.maxhenkel.easyvillagers.events.VillagerEvents;
import net.conczin.mca.entity.VillagerEntityMCA;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEvents.class)
public class VillagerEventsMixin {

    @Inject(at = @At("HEAD"), method = "arePickupConditionsMet")
    private static void arePickupConditionsMet(Villager villager, CallbackInfoReturnable<Boolean> cir) {
        if (villager instanceof VillagerEntityMCA) cir.setReturnValue(false);
    }
}