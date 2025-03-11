package com.ryorama.tstpcontent.datagen.server;

import com.ryorama.tstpcontent.TstpContentMod;
import dev.xkmc.cuisinedelight.content.logic.FoodType;
import dev.xkmc.cuisinedelight.content.logic.IngredientConfig;
import dev.xkmc.cuisinedelight.init.CuisineDelight;
import dev.xkmc.l2library.serial.config.ConfigDataProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;

public class CDIngredients extends ConfigDataProvider {
    public CDIngredients(DataGenerator generator) {
        super(generator, "TSTP CD Ingredients");
    }

    @Override
    public void add(Collector map) {
        List<Map.Entry<ResourceKey<Item>, Item>> itemReg = ForgeRegistries.ITEMS.getEntries().stream().toList();
        for (int i = 0; i < itemReg.size(); i++) {
            Item item = itemReg.get(i).getValue();
            TagKey<Item> crops = ItemTags.create(new ResourceLocation("forge:crops"));
            TagKey<Item> rawMeats = ItemTags.create(new ResourceLocation("forge:rawmeats"));
            TagKey<Item> rawFishes = ItemTags.create(new ResourceLocation("forge:raw_fishes"));


            if (item.getDefaultInstance().is(crops)) {
                map.add(CuisineDelight.INGREDIENT, new ResourceLocation(TstpContentMod.MODID, "crops"), IngredientConfig.build(
                        IngredientConfig.get(Ingredient.of(item), FoodType.VEG,180, 240, 80, 0.5f, 0.5f, 3, 10)
                ));
            }
            if (item.getDefaultInstance().is(rawMeats)) {
                map.add(CuisineDelight.INGREDIENT, new ResourceLocation(TstpContentMod.MODID, "meats"), IngredientConfig.build(
                        IngredientConfig.get(Ingredient.of(item), FoodType.MEAT,180, 240, 80, 0.5f, 0.5f, 3, 10)
                ));
            }
            if (item.getDefaultInstance().is(rawFishes)) {
                map.add(CuisineDelight.INGREDIENT, new ResourceLocation(TstpContentMod.MODID, "fishes"), IngredientConfig.build(
                        IngredientConfig.get(Ingredient.of(item), FoodType.SEAFOOD,180, 240, 80, 0.5f, 0.5f, 3, 10)
                ));
            }
        }
    }
}
