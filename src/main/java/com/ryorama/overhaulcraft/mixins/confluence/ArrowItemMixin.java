package com.ryorama.overhaulcraft.mixins.confluence;


import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.confluence.mod.api.ITerraArrowProjectileWeaponItem;
import org.confluence.mod.common.entity.projectile.range.arrow.BaseArrowEntity;
import org.confluence.mod.common.init.ModEntities;
import org.confluence.mod.common.item.arrow.BaseTerraArrowItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@IfModLoaded("confluence")
@Mixin(ArrowItem.class)
public class ArrowItemMixin {
    @Inject(method = "createArrow", at = @At("HEAD"), cancellable = true)
    public void createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon, CallbackInfoReturnable<AbstractArrow> cir) {
        if (weapon != null && weapon.getItem() instanceof ITerraArrowProjectileWeaponItem<?> bow) {
            BaseTerraArrowItem.ModifyArrowBuilder modifyArrowBuilder = bow.getModifyArrowBuilder();
            if (modifyArrowBuilder.entityTransform != null) {
                BaseArrowEntity arrow = modifyArrowBuilder.entityTransform.factory().create(modifyArrowBuilder.entityTransform.type(), shooter, ammo.copyWithCount(1), weapon, null, modifyArrowBuilder);
                cir.setReturnValue(arrow);
                return;
            }
            BaseTerraArrowItem arrowItem = bow.getArrowModifier().getTransformArrow();
            if (arrowItem != null) {
                cir.setReturnValue(new BaseArrowEntity(ModEntities.ARROW_PROJECTILE.get(), shooter, ammo.copyWithCount(1), weapon, arrowItem, modifyArrowBuilder));
            }
        }
    }
}
