package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.confluence.mod.common.init.ModTabs;
import org.confluence.mod.common.init.block.FunctionalBlocks;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OverhaulCraftTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.CREATIVE_MODE_TAB);
	
	public static final RegistrySupplier<CreativeModeTab> OVERHAULCRAFT_ORE_COMP = REGISTRY.register("ore_compat",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.overhaulcraft.ore_compat")).icon(() -> new ItemStack(Blocks.REDSTONE_ORE)).displayItems((parameters, tabData) -> {
				OverhaulCraftOreBlocks.ITEM_REGISTRY.getEntries().forEach(itemDeferredHolder -> tabData.accept(itemDeferredHolder.get()));
			}).build());
	
	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(OverhaulCraftItems.COBBLEDIM_TELEPORT_ITEM);
			tabData.accept(OverhaulCraftItems.CUSTOMIZATION_GLOBE);
			tabData.accept(OverhaulCraftItems.MOSQUITO_REPELLING_CHARM);
		}

		if (ExtraFunc.isModLoaded("confluence")) {
			if (tabData.getTabKey() == ModTabs.MISC.getKey()) {
				tabData.insertBefore(FunctionalBlocks.EARTHSHAKER_DEVICE.asItem().getDefaultInstance(), OverhaulCraftItems.MECHANICAL_WORM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
				tabData.insertBefore(FunctionalBlocks.DUAL_FLASH_LIGHTHOUSE.asItem().getDefaultInstance(), OverhaulCraftItems.MECHANICAL_EYE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
				tabData.insertBefore(FunctionalBlocks.PHANTOM_BASE_STATION.asItem().getDefaultInstance(), OverhaulCraftItems.MECHANICAL_SKULL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

				tabData.remove(FunctionalBlocks.EARTHSHAKER_DEVICE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
				tabData.remove(FunctionalBlocks.DUAL_FLASH_LIGHTHOUSE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
				tabData.remove(FunctionalBlocks.PHANTOM_BASE_STATION.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			}
		}

//		for (CreativeModeTab tab : BuiltInRegistries.CREATIVE_MODE_TAB.stream().toList()) {
//			for (Item item : BuiltInRegistries.ITEM.stream().toList()) {
//				if (item != ExtraFunc.getReplacementForItem(item)) {
//					if (tabData.getTab() == tab) {
//						tabData.remove(item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
//					}
//				}
//			}
//		}
	}
}