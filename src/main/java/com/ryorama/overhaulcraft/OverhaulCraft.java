package com.ryorama.overhaulcraft;


import com.ryorama.overhaulcraft.init.*;
import com.ryorama.overhaulcraft.utils.ExternalDownloader;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod(OverhaulCraft.MODID)
public class OverhaulCraft {
	public static final Logger LOGGER = LogManager.getLogger(OverhaulCraft.class);
	public static final String MODID = "overhaulcraft";
	public final ExternalDownloader externalDownloader = new ExternalDownloader();
	public static final boolean isDev = true;
	public static OverhaulCraftConfig CONFIG;

	//Pack Edition
	//0 - Normal
	//1 - Hardcore Version
	public static int packEd = 0;

	public OverhaulCraft(IEventBus bus, ModContainer modContainer, Dist dist) {
		CONFIG = Configuration.registerConfig(OverhaulCraftConfig.class, ConfigFormats.json()).getConfigInstance();

		OverhaulCraftMusic.REGISTRY.register(bus);
		OverhaulCraftBlocks.REGISTRY.register(bus);
		OverhaulCraftOreBlocks.init(bus);
		OverhaulCraftBlockEntities.REGISTRY.register();
		OverhaulCraftItems.REGISTRY.register(bus);
		OverhaulCraftTabs.REGISTRY.register();
		OverhaulCraftEntityTypes.REGISTRY.register();

		bus.addListener(this::constructModEvent);
		bus.addListener(this::loadCompleteEvent);
	}

	public void constructModEvent(FMLConstructModEvent event) {
		if (!isDev) {
			externalDownloader.handleExternalMods();
		}
	}

	public void loadCompleteEvent(FMLLoadCompleteEvent event) {
		//DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> OverhaulcraftTabs::handleItemPlacements);
	}
}