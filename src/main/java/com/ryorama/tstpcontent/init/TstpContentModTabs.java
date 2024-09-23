
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryorama.tstpcontent.init;

import com.thevortex.potionsmaster.init.ModRegistry;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.ryorama.tstpcontent.TstpContentMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TstpContentModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TstpContentMod.MODID);
	public static final RegistryObject<CreativeModeTab> TSTP_GT = REGISTRY.register("tstp_gt",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tstp_content.tstp_gt")).icon(() -> new ItemStack(TstpContentModBlocks.CALORITE_MACHINE_CASING.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TstpContentModBlocks.CALORITE_MACHINE_CASING.get().asItem());
				tabData.accept(TstpContentModBlocks.OSTRUM_MACHINE_CASING.get().asItem());
			}).build());
	public static final RegistryObject<CreativeModeTab> TSTP_TAS = REGISTRY.register("tstp_tas",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tstp_content.tstp_tas")).icon(() -> new ItemStack(TstpContentModBlocks.HVAC_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TstpContentModBlocks.HVAC_BLOCK.get().asItem());
			}).build());
	public static final RegistryObject<CreativeModeTab> TSTP_MRCF = REGISTRY.register("tstp_mrcf",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tstp_content.tstp_mrcf")).icon(() -> new ItemStack(TstpContentModBlocks.LIGHT_RF_ELECTRICITY_GENERATOR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TstpContentModBlocks.LIGHT_RF_ELECTRICITY_GENERATOR.get().asItem());
				tabData.accept(TstpContentModBlocks.DARK_RF_ELECTRICITY_GENERATOR.get().asItem());
			}).build());
	public static final RegistryObject<CreativeModeTab> TSTP_CONTENT_TERRARIA = REGISTRY.register("tstp_content_terraria",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tstp_content.tstp_content_terraria")).icon(() -> new ItemStack(TstpContentModBlocks.GRASS_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TstpContentModBlocks.DIRT_BLOCK.get().asItem());
				tabData.accept(TstpContentModBlocks.GRASS_BLOCK.get().asItem());
				tabData.accept(TstpContentModBlocks.SAND_BLOCK.get().asItem());
				tabData.accept(TstpContentModBlocks.SNOW.get().asItem());
				tabData.accept(TstpContentModBlocks.WOOD_LOG.get().asItem());
				tabData.accept(TstpContentModBlocks.CACTUS.get().asItem());
				tabData.accept(TstpContentModBlocks.FOREST_LEAVES.get().asItem());
				tabData.accept(TstpContentModBlocks.ICE.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE.get().asItem());
				tabData.accept(TstpContentModBlocks.STONE.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE.get().asItem());
				tabData.accept(TstpContentModItems.IRON.get());
				tabData.accept(TstpContentModItems.COPPER.get());
				tabData.accept(TstpContentModItems.MUSHROOM.get());
				tabData.accept(TstpContentModItems.WOOD.get());
				tabData.accept(TstpContentModItems.LIFE_CRYSTAL.get());
				tabData.accept(TstpContentModBlocks.LIFE_CRYSTAL_BLOCK.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(TstpContentModBlocks.MUSHROOM_PLANT.get().asItem());
		}
		if (tabData.getTabKey() == ModRegistry.CREATIVE_TAB.getKey()) {
			tabData.accept(TstpContentModItems.RANDOMIUM_POWDER);
			tabData.accept(TstpContentModItems.CALCINATED_RANDOMIUM_POWDER);
		}
	}
}
