package com.ryorama.overhaulcraft;


import com.ryorama.overhaulcraft.init.*;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@Mod(TstpContentMod.MODID)
public class TstpContentMod {
	public static final Logger LOGGER = LogManager.getLogger(TstpContentMod.class);
	public static final String MODID = "overhaulcraft";
	public static TstpContentModConfig CONFIG;


	public TstpContentMod(IEventBus bus, ModContainer modContainer, Dist dist) {
		CONFIG = Configuration.registerConfig(TstpContentModConfig.class, ConfigFormats.json()).getConfigInstance();

		TstpContentModSounds.REGISTRY.register(bus);
		TstpContentModEffects.REGISTRY.register();
		TstpContentModBlocks.REGISTRY.register(bus);
		TstpContentModBlockEntities.REGISTRY.register();
		TstpContentModItems.REGISTRY.register(bus);
		TstpContentModPotions.REGISTRY.register();
		TstpContentModTabs.REGISTRY.register();
		TstpContentEntityTypes.REGISTRY.register();
		bus.addListener(this::setup);
		bus.addListener(this::postLoad);

		//DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TstpContentModTabs::handleItemPlacements);
	}

	public void setup(FMLCommonSetupEvent event) {
		registerPotions();
	}

	public void postLoad(FMLLoadCompleteEvent event) {
		LOGGER.info("Setting Up Custom Terraria Ore Gen");
	}

	private static void registerPotions() {
		LOGGER.info("Registering Custom Sight Potion Recipes");
		//BrewingRecipeRegistry.addRecipe(new RandomiumPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_RANDOMIUM_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.RANDOMIUM_SIGHT.get())));
		//BrewingRecipeRegistry.addRecipe(new DraconiumPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_DRACONIUM_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.DRACONIUM_SIGHT.get())));
		//BrewingRecipeRegistry.addRecipe(new SulfurPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_SULFUR_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.SULFUR_SIGHT.get())));
		//BrewingRecipeRegistry.addRecipe(new NiterPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_NITER_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.NITER_SIGHT.get())));
	}
}