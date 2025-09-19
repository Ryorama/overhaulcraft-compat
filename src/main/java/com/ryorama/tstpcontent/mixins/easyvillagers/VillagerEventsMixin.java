package com.ryorama.tstpcontent.mixins.easyvillagers;

import de.maxhenkel.easyvillagers.events.VillagerEvents;
import forge.net.mca.entity.VillagerEntityMCA;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(VillagerEvents.class)
public class VillagerEventsMixin {

    /**
     * @author Ryorama
     * @reason Prevent MCA villagers from being picked up
     */
    @Overwrite(remap = false)
    public static boolean arePickupConditionsMet(Villager villager) {
        if (!(villager instanceof VillagerEntityMCA)) {
            if (!villager.isAlive()) {
                return false;
            } else {
                return !villager.isSleeping();
            }
        }
        return false;
    }
}