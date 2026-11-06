package com.ryorama.overhaulcraft;


import com.ryorama.overhaulcraft.init.*;
import com.ryorama.overhaulcraft.utils.ExternalDownloader;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod(OverhaulCraft.MODID)
public class OverhaulCraft {
	public static final Logger LOGGER = LogManager.getLogger(OverhaulCraft.class);
	public static final String MODID = "overhaulcraft";
	public final ExternalDownloader externalDownloader = new ExternalDownloader();
	public static final boolean isDev = true;

	//Pack Edition
	//0 - Normal
	//1 - Hardcore Version
	public static int packEd = 0;
	public OverhaulCraft(IEventBus bus, ModContainer modContainer, Dist dist) {
		modContainer.registerConfig(ModConfig.Type.COMMON, OverhaulCraftCommonConfig.SPEC);
		modContainer.registerConfig(ModConfig.Type.CLIENT, OverhaulCraftClientConfig.SPEC);

		OverhaulCraftMusic.REGISTRY.register(bus);
		OverhaulCraftPlacements.PLACEMENT_MODIFIER_TYPES.register(bus);
		OverhaulCraftPlacements.STRUCTURE_PLACEMENT_TYPES.register(bus);
		OverhaulCraftDataAttachments.REGISTRY.register(bus);
		OverhaulCraftMobEffects.REGISTRY.register(bus);
		OverhaulCraftBlocks.REGISTRY.register(bus);
		OverhaulCraftOreBlocks.init(bus);
		OverhaulCraftBlockEntities.REGISTRY.register();
		OverhaulCraftItems.REGISTRY.register(bus);
		OverhaulCraftTabs.REGISTRY.register();
		//OverhaulCraftEntityTypes.REGISTRY.register();
	}
}