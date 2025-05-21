package com.ryorama.tstpcontent.mixins.exdeorum;

import com.google.common.collect.Lists;
import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thedarkcolour.exdeorum.item.RandomResultItem;

import java.util.List;

@Mixin(RandomResultItem.RandomArmorTrim.class)
public class RandomArmorTrimMixin {
    private static final List<Item> NEW_POSSIBLE_TRIMS = Lists.newArrayList(
            Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE
    );

    /**
     * @author Ryorama
     * @reason Add more trims
     */
    @Overwrite(remap = false)
    protected List<Item> getPossibilities() {
        TstpContentMod.LOGGER.info("Template Possibilities: " + getPossibilities() + ". New Possible Trims List: " + NEW_POSSIBLE_TRIMS);
        return NEW_POSSIBLE_TRIMS;
    }
}
