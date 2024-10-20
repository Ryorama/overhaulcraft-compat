package com.ryorama.tstpcontent;

import com.ryorama.tstpcontent.init.*;
import com.ryorama.tstpcontent.item.recipes.oresight.RandomiumPotionRecipe;
import dev.xkmc.l2library.base.L2Registrate;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod("tstp_content")
public class TstpContentMod {
	public static final Logger LOGGER = LogManager.getLogger(TstpContentMod.class);
	public static final String MODID = "tstp_content";
	public static final L2Registrate REGISTRATE = new L2Registrate(MODID);
	public static TstpContentModConfig CONFIG = new TstpContentModConfig();


	public TstpContentMod() {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		AutoConfig.register(TstpContentModConfig.class, GsonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(TstpContentModConfig.class).getConfig();
		TstpContentModSounds.REGISTRY.register(bus);
		TstpContentModEffects.REGISTRY.register(bus);
		TstpContentModBlocks.REGISTRY.register(bus);
		TstpContentModBlockEntities.REGISTRY.register(bus);
		TstpContentModItems.REGISTRY.register(bus);
		TstpContentModPotions.REGISTRY.register(bus);
		TstpContentModTabs.REGISTRY.register(bus);


		bus.addListener(this::setup);
	}

	public void setup(FMLCommonSetupEvent event) {
		registerPotions();
	}

	private static void registerPotions() {
		BrewingRecipeRegistry.addRecipe(new RandomiumPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_RANDOMIUM_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.RANDOMIUM_SIGHT.get())));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {

	}
}
