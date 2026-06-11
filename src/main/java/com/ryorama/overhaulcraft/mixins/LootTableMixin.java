package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@IfModLoaded("confluence_dimension_patch")
@Mixin(LootTable.class)
public class LootTableMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z"), method = "fill")
    public void fill(Container container, LootParams params, long seed, CallbackInfo ci, @Local ItemStack itemStack) {
        ResourceLocation itemLocation = ExtraFunc.getLocationFromItemStack(itemStack);
        if (!ExtraFunc.isConfluence(params.getLevel())) {
            if (itemLocation.getNamespace().equals("confluence") || itemLocation.getNamespace().equals("terra_entity")) {
                OverhaulCraft.LOGGER.info("Removing confluence item " + itemStack.getDisplayName().getString() + " from loot");
                itemStack = ItemStack.EMPTY;
            }
        }
        if (!ExtraFunc.isCobblemonDim(params.getLevel())) {
            if (itemLocation.getNamespace().contains("cobblemon")) {
                OverhaulCraft.LOGGER.info("Removing cobblemon item " + itemStack.getDisplayName().getString() + " from loot");
                itemStack = ItemStack.EMPTY;
            }
        }
    }
}
