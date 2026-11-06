package com.ryorama.overhaulcraft.mixins.supplementaries;

import com.ryorama.overhaulcraft.OverhaulCraftCommonConfig;
import net.mehvahdjukaar.supplementaries.common.items.AbstractMobContainerItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractMobContainerItem.class)
public class AbstractMobContainerItemMixin {
    @Inject(at = @At("HEAD"), method = "canCatch", cancellable = true)
    private <T extends Entity> void canCatch(T entity, Player player, CallbackInfoReturnable<Boolean> cir) {
        for (String blackListEntry : OverhaulCraftCommonConfig.SUPPLEMENTARIES_CAGE_ENTITY_BLACKLIST.get()) {
            EntityType<?> entityChecked = BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.parse(blackListEntry));
            if (entityChecked != null) {
                if (entityChecked.create(player.level()) == entity) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
