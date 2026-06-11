package com.ryorama.overhaulcraft.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import org.confluence.mod.util.ModUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@IfModLoaded("confluence_dimension_patch")
@Mixin(LootTable.class)
public class LootTableMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z"), method = "fill")
    public void fill(Container container, LootParams params, long seed, CallbackInfo ci, @Local LocalRef<ItemStack> itemStack) {
        if (!ExtraFunc.isConfluence(params.getLevel())) {
            if (ModUtils.isFromConfluence(BuiltInRegistries.ITEM, itemStack.get().getItem())) {
                OverhaulCraft.LOGGER.info("Removing confluence item " + itemStack.get().getDisplayName().getString() + " from loot");
                itemStack.set(ItemStack.EMPTY);
            }
        }
        if (!ExtraFunc.isCobblemonDim(params.getLevel())) {
            if (ExtraFunc.isFromCobblemon(BuiltInRegistries.ITEM, itemStack.get().getItem())) {
                OverhaulCraft.LOGGER.info("Removing cobblemon item " + itemStack.get().getDisplayName().getString() + " from loot");
                itemStack.set(ItemStack.EMPTY);
            }
        }
    }
}
