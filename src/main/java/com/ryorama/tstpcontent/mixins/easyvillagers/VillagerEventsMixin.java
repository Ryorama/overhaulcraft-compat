package com.ryorama.tstpcontent.mixins.easyvillagers;

import com.ryorama.tstpcontent.TstpContentMod;
import de.maxhenkel.easyvillagers.Main;
import de.maxhenkel.easyvillagers.events.VillagerEvents;
import de.maxhenkel.easyvillagers.net.MessagePickUpVillager;
import forge.net.mca.entity.VillagerEntityMCA;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerEvents.class)
public class VillagerEventsMixin {

    @Inject(at = @At(value = "INVOKE", target = "Lde/maxhenkel/easyvillagers/events/VillagerEvents;arePickupConditionsMet(Lnet/minecraft/world/entity/npc/Villager;)Z", shift = At.Shift.AFTER), method = "onClick", remap = false)
    public void onClick(PlayerInteractEvent.EntityInteract event, CallbackInfo ci) {
        TstpContentMod.LOGGER.info("Villager Pickup click pass 1");
        TstpContentMod.LOGGER.info("Is entity MCA Villager: " + (event.getTarget() instanceof VillagerEntityMCA));
        if (event.getTarget() instanceof VillagerEntityMCA) {
            TstpContentMod.LOGGER.info("Villager Pickup click pass 1");
            event.setCancellationResult(InteractionResult.FAIL);
            event.setCanceled(true);
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "Lde/maxhenkel/easyvillagers/events/VillagerEvents;arePickupConditionsMet(Lnet/minecraft/world/entity/npc/Villager;)Z", shift = At.Shift.AFTER), method = "onKeyInput", remap = false)
    public void onKeyInput(InputEvent.Key event, CallbackInfo ci) {
        Entity entityPointed2 = Minecraft.getInstance().crosshairPickEntity;
        TstpContentMod.LOGGER.info("Villager Pickup key pass 1");
        TstpContentMod.LOGGER.info("Is entity MCA Villager: " + (entityPointed2 instanceof VillagerEntityMCA));
        if (entityPointed2 instanceof VillagerEntityMCA) {
            TstpContentMod.LOGGER.info("Villager Pickup key pass 2");
            return;
        }
    }
}