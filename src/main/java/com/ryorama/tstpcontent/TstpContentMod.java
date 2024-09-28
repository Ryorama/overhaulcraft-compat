package com.ryorama.tstpcontent;

import com.ryorama.tstpcontent.init.*;
import com.ryorama.tstpcontent.item.recipes.oresight.RandomiumPotionRecipe;
import com.ryorama.tstpcontent.reference.OresRef;
import com.thevortex.potionsmaster.init.ModPotions;
import com.thevortex.potionsmaster.init.ModRegistry;
import com.thevortex.potionsmaster.items.potions.recipes.oresight.CoalPotionRecipe;
import com.thevortex.potionsmaster.render.util.BlockStoreBuilder;
import com.thevortex.potionsmaster.render.util.xray.Controller;
import dev.xkmc.l2library.base.L2Registrate;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

import org.valkyrienskies.mod.client.IVSCamera;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Mod("tstp_content")
public class TstpContentMod {
	public static final Logger LOGGER = LogManager.getLogger(TstpContentMod.class);
	public static final String MODID = "tstp_content";
	public static final L2Registrate REGISTRATE = new L2Registrate(MODID);


	public TstpContentMod() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		TstpContentModSounds.REGISTRY.register(bus);
		TstpContentModEffects.REGISTRY.register(bus);
		TstpContentModBlocks.REGISTRY.register(bus);
		TstpContentModBlockEntities.REGISTRY.register(bus);
		TstpContentModItems.REGISTRY.register(bus);
		TstpContentModPotions.REGISTRY.register(bus);
		TstpContentModTabs.REGISTRY.register(bus);

		modBus.addListener(this::setup);
	}

	public void setup(FMLCommonSetupEvent event) {
		registerPotions();
	}

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	private static void registerPotions() {
		BrewingRecipeRegistry.addRecipe(new RandomiumPotionRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.of(TstpContentModItems.CALCINATED_RANDOMIUM_POWDER.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), TstpContentModPotions.RANDOMIUM_SIGHT.get())));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {

	}
}
