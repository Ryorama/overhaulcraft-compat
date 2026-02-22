package com.ryorama.overhaulcraft;


import com.ryorama.overhaulcraft.init.*;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



@Mod(OverhaulCraft.MODID)
public class OverhaulCraft {
	public static final Logger LOGGER = LogManager.getLogger(OverhaulCraft.class);
	public static final String MODID = "overhaulcraft";
	public static OverhaulCraftConfig CONFIG;

	public OverhaulCraft(IEventBus bus, ModContainer modContainer, Dist dist) {
		CONFIG = Configuration.registerConfig(OverhaulCraftConfig.class, ConfigFormats.json()).getConfigInstance();

		OverhaulCraftSounds.REGISTRY.register(bus);
		OverhaulCraftEffects.REGISTRY.register();
		OverhaulCraftBlocks.REGISTRY.register(bus);
		OverhaulCraftBlockEntities.REGISTRY.register();
		OverhaulCraftItems.REGISTRY.register(bus);
		OverhaulCraftPotions.REGISTRY.register();
		OverhaulCraftTabs.REGISTRY.register();
		OverhaulCraftEntityTypes.REGISTRY.register();
		OverhaulCraftChunkGenerators.REGISTRY.register();
		NeoForge.EVENT_BUS.addListener(OverhaulCraft::registerPotions);

		//DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TstpContentModTabs::handleItemPlacements);
	}

	private static void registerPotions(RegisterBrewingRecipesEvent event) {
		//event.getBuilder().addRecipe(Ingredient.of(getPotion(Potions.MUNDANE)), Ingredient.of(OverhaulCraftItems.CALCINATED_RANDOMIUM_POWDER.get()), PotionContents.createItemStack(Items.POTION, OverhaulCraftPotions.RANDOMIUM_SIGHT));
		//event.getBuilder().addRecipe(Ingredient.of(getPotion(Potions.MUNDANE)), Ingredient.of(OverhaulCraftItems.CALCINATED_DRACONIUM_POWDER.get()), PotionContents.createItemStack(Items.POTION, OverhaulCraftPotions.DRACONIUM_SIGHT));
		//event.getBuilder().addRecipe(Ingredient.of(getPotion(Potions.MUNDANE)), Ingredient.of(OverhaulCraftItems.CALCINATED_NITER_POWDER.get()), PotionContents.createItemStack(Items.POTION, OverhaulCraftPotions.NITER_SIGHT));
		//event.getBuilder().addRecipe(Ingredient.of(getPotion(Potions.MUNDANE)), Ingredient.of(OverhaulCraftItems.CALCINATED_SULFUR_POWDER.get()), PotionContents.createItemStack(Items.POTION, OverhaulCraftPotions.SULFUR_SIGHT));
	}

	private static ItemStack getPotion(Holder<Potion> potion) {
		ItemStack itemstack = Items.POTION.getDefaultInstance();
		itemstack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
		return itemstack;
	}
}