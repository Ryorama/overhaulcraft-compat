package com.ryorama.tstpcontent;

import com.ryorama.terrariamod.blocks.BlocksT;
import com.ryorama.terrariamod.world.TerrariaChunkGenerator;
import com.ryorama.tstpcontent.init.*;
import com.ryorama.tstpcontent.recipes.oresight.DraconiumPotionRecipe;
import com.ryorama.tstpcontent.recipes.oresight.NiterPotionRecipe;
import com.ryorama.tstpcontent.recipes.oresight.RandomiumPotionRecipe;
import com.ryorama.tstpcontent.recipes.oresight.SulfurPotionRecipe;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.MinecraftForge;
import software.bernie.geckolib.GeckoLib;

import java.util.ArrayList;
import java.util.List;


@Mod(TstpContentMod.MODID)
public class TstpContentMod {
	public static final Logger LOGGER = LogManager.getLogger(TstpContentMod.class);
	public static final String MODID = "tstp_content";
	public static TstpContentModConfig CONFIG;


	public TstpContentMod() {
		CONFIG = Configuration.registerConfig(TstpContentModConfig.class, ConfigFormats.json()).getConfigInstance();
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		TstpContentModSounds.REGISTRY.register(bus);
		TstpContentModEffects.REGISTRY.register(bus);
		TstpContentModBlocks.REGISTRY.register(bus);
		TstpContentModBlockEntities.REGISTRY.register(bus);
		TstpContentModItems.REGISTRY.register(bus);
		TstpContentModPotions.REGISTRY.register(bus);
		TstpContentModTabs.REGISTRY.register(bus);
		bus.addListener(this::setup);
		bus.addListener(this::postLoad);
		GeckoLib.initialize();
	}

	public void setup(FMLCommonSetupEvent event) {
		registerPotions();
	}

	public void postLoad(FMLLoadCompleteEvent event) {
		LOGGER.info("Setting Up Custom Terraria Ore Gen");
		setupTerrariaOreGen();
	}

	private static void registerPotions() {
		LOGGER.info("Registering Custom Sight Potion Recipes");
		BrewingRecipeRegistry.addRecipe(new RandomiumPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_RANDOMIUM_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.RANDOMIUM_SIGHT.get())));
		BrewingRecipeRegistry.addRecipe(new DraconiumPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_DRACONIUM_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.DRACONIUM_SIGHT.get())));
		BrewingRecipeRegistry.addRecipe(new SulfurPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_SULFUR_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.SULFUR_SIGHT.get())));
		BrewingRecipeRegistry.addRecipe(new NiterPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_NITER_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.NITER_SIGHT.get())));
	}

	public void setupTerrariaOreGen() {
		List<Block> replacingBlocks = new ArrayList<>();
		replacingBlocks.add(BlocksT.STONE_BLOCK.get());
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.COAL_ORE_TERRARIA.get(), replacingBlocks, 800, 10, 30);
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.LAPIS_ORE_TERRARIA.get(), replacingBlocks, 1300, 3, 8);
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.REDSTONE_ORE_TERRARIA.get(), replacingBlocks, 1300, 3, 8);
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.ALUMINUM_ORE_TERRARIA.get(), replacingBlocks, 1100, 4, 10);
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.NICKEL_ORE_TERRARIA.get(), replacingBlocks, 1100, 4, 10);
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.OSMIUM_ORE_TERRARIA.get(), replacingBlocks, 1100, 4, 10);
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.URANIUM_ORE_TERRARIA.get(), replacingBlocks, 1500, 8, 25);
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.ZINC_ORE_TERRARIA.get(), replacingBlocks, 1100, 4, 10);
		TerrariaChunkGenerator.addCustomOreToWorldGen(TstpContentModBlocks.RANDOMIUM_ORE_TERRARIA.get(), replacingBlocks, 600, 1, 2);
	}
}