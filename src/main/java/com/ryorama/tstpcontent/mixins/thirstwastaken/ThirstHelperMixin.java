package com.ryorama.tstpcontent.mixins.thirstwastaken;

import dev.ghen.thirst.api.ThirstHelper;
import dev.ghen.thirst.foundation.config.KeyWordConfig;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mixin(ThirstHelper.class)
public class ThirstHelperMixin {

    @Shadow(remap = false)
    public static Map<Item, Number[]> VALID_DRINKS;
    @Shadow(remap = false)
    public static Map<Item, Number[]> VALID_FOODS;
    @Shadow(remap = false)
    public static String keywordBlackList;
    @Shadow(remap = false)
    public static String keywordDrink;
    @Shadow(remap = false)
    public static String keywordSoup;
    @Shadow(remap = false)
    public static String keywordFruit;
    private static String builtinKeywordBlacklist = "(baked|dried|cooked|chops|roasted|donut|gummy|crate|bag|chips|pop|custard|jam|jelly|bucket|seed|scone|cookie|pie|pizza|bush|sapling|curry|cake|candy|bread|roll|rotten|yogurt)";

    /**
     * @author Ryorama
     * @reason Reorder to check for blacklisted keywords last
     */
    @Overwrite(remap = false)
    private static boolean checkKeywords(ItemStack itemStack)
    {
        if(!KeyWordConfig.ENABLE_KEYWORD_CONFIG.get())
            return false;

        if(!itemStack.isEdible())
            return false;

        String pattern = builtinKeywordBlacklist;
        Matcher matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE)
                .matcher(itemStack.getDescriptionId());

        if (matcher.find()) {
            return false;
        }

        pattern = keywordFruit;
        matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE)
                .matcher(itemStack.getDescriptionId());

        boolean hasWater = matcher.find();
        if(hasWater)
            VALID_FOODS.put(itemStack.getItem(), new Number[]{
                    KeyWordConfig.getFruitHydration(),
                    KeyWordConfig.getFruitQuenchness()
            });


        pattern = keywordDrink;
        matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE)
                .matcher(itemStack.getDescriptionId());

        hasWater = matcher.find();
        if(hasWater)
        {
            VALID_DRINKS.put(itemStack.getItem(), new Number[]{
                    KeyWordConfig.getDrinkHydration(),
                    KeyWordConfig.getDrinkQuenchness()
            });
            return true;
        }

        pattern = keywordSoup;
        matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE)
                .matcher(itemStack.getDescriptionId());

        hasWater = matcher.find();
        if(hasWater)
        {
            VALID_FOODS.put(itemStack.getItem(), new Number[]{
                    KeyWordConfig.getSoupHydration(),
                    KeyWordConfig.getSoupQuenchness()
            });
            return true;
        }

        pattern = keywordBlackList;
        matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE)
                .matcher(itemStack.getDescriptionId());

        if(matcher.find())
            return false;

        return hasWater;
    }
}
