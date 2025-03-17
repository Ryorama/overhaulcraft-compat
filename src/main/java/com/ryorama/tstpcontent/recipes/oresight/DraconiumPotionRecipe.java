package com.ryorama.tstpcontent.recipes.oresight;

import com.ryorama.tstpcontent.init.TstpContentModItems;
import com.ryorama.tstpcontent.init.TstpContentModPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;

public class DraconiumPotionRecipe extends BrewingRecipe {
    public DraconiumPotionRecipe(Ingredient input, Ingredient ingredient, ItemStack output) {
        super(input, ingredient, output);
    }

    public boolean isInput(ItemStack input) {
        return (PotionUtils.getPotion(input) == Potions.MUNDANE);
    }

    public boolean isIngredient(ItemStack ingredient) {
        return (ingredient.getItem().asItem() == TstpContentModItems.CALCINATED_DRACONIUM_POWDER.get());
    }

    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        return (isInput(input) && isIngredient(ingredient)) ? getOutput().copy() : ItemStack.EMPTY;
    }

    public ItemStack getOutput() {
        return PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.DRACONIUM_SIGHT.get());
    }
}