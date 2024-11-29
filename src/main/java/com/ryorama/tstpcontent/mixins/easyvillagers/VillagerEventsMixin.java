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

@Mixin(VillagerEvents.class)
public class VillagerEventsMixin {
    /**
     * @author Ryorama
     * @reason Prevent MCA Villagers from being picked up
     */
    @Overwrite(remap = false)
    public void onClick(PlayerInteractEvent.EntityInteract event) {
        if (event.getLevel().isClientSide) {
            if (event.getTarget() instanceof Villager) {
                TstpContentMod.LOGGER.info("Villager Pass 1-1");
                if (!(event.getTarget() instanceof VillagerEntityMCA)) {
                    TstpContentMod.LOGGER.info("Villager Pass 1-2");
                    if (Main.CLIENT_CONFIG.enableRightClickPickup.get()) {
                        Villager villager = (Villager) event.getTarget();
                        Player player = event.getEntity();
                        if (player.isShiftKeyDown()) {
                            if (VillagerEvents.arePickupConditionsMet(villager)) {
                                Main.SIMPLE_CHANNEL.sendToServer(new MessagePickUpVillager(villager.getUUID()));
                                event.setCancellationResult(InteractionResult.SUCCESS);
                                event.setCanceled(true);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @author Ryorama
     * @reason Prevent MCA Villagers from being picked up
     */
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    @Overwrite(remap = false)
    public void onKeyInput(InputEvent.Key event) {
        if (Main.PICKUP_KEY.consumeClick()) {
            Entity pointedEntity = Minecraft.getInstance().crosshairPickEntity;
            if (pointedEntity instanceof Villager) {
                TstpContentMod.LOGGER.info("Villager Pass 2-1");
                if (!(pointedEntity instanceof VillagerEntityMCA)) {
                    TstpContentMod.LOGGER.info("Villager Pass 2-2");
                    Villager villager = (Villager) pointedEntity;
                    if (VillagerEvents.arePickupConditionsMet(villager)) {
                        Main.SIMPLE_CHANNEL.sendToServer(new MessagePickUpVillager(villager.getUUID()));
                    }
                }
            }
        }
    }
}