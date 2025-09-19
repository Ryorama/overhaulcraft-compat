package com.ryorama.overhaulcraft.mixins.pizzadelight;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.tiviacz.pizzadelight.common.PizzaBlockCalculator;
import com.tiviacz.pizzadelight.init.ModDataComponents;
import com.tiviacz.pizzadelight.items.PizzaSliceItem;
import com.tiviacz.pizzadelight.util.PizzaFoodBuilder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Collections;
import java.util.Optional;

@IfModLoaded("pizzadelight")
@Mixin(PizzaSliceItem.class)
public abstract class PizzaSliceItemMixin extends Item {
    public PizzaSliceItemMixin(Properties arg) {
        super(arg);
    }

    /**
     * @author Ryorama
     * @reason Add null check to prevent crash with some mods
     */
    @Overwrite(remap = false)
    public FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity) {
        FoodProperties foodProperties = stack.get(DataComponents.FOOD);
        if (foodProperties != null) {
            if (!foodProperties.canAlwaysEat()) {
                return foodProperties;
            } else {
                PizzaFoodBuilder newProps = (new PizzaFoodBuilder()).nutrition(foodProperties.nutrition()).saturationModifier(foodProperties.saturation()).alwaysEdible();
                if (stack.has(ModDataComponents.PIZZA_INGREDIENTS)) {
                    PizzaBlockCalculator calculator = new PizzaBlockCalculator(new ItemStackHandler((stack.get(ModDataComponents.PIZZA_INGREDIENTS)).getIngredients()));

                    for (FoodProperties.PossibleEffect effect : calculator.findEffects()) {
                        newProps.effect(effect.effectSupplier(), effect.probability());
                    }
                }

                return newProps.build();
            }
        }
        return new FoodProperties(2, 2, false, 3, Optional.empty(), Collections.emptyList());
    }
}