package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.confluence.mod.common.init.ModTabs;

//@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OverhaulCraftTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.CREATIVE_MODE_TAB);
	
	public static final RegistrySupplier<CreativeModeTab> OVERHAULCRAFT_ORE_COMP = REGISTRY.register("ore_compat",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.overhaulcraft.ore_compat")).icon(() -> new ItemStack(Blocks.REDSTONE_ORE)).displayItems((parameters, tabData) -> {
				OverhaulCraftOreBlocks.ITEM_REGISTRY.getEntries().forEach(itemDeferredHolder -> tabData.accept(itemDeferredHolder.get()));
			}).build());
	
	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			//tabData.remove(CroptopiaAdditionsModItems.CURRY_POWDER.get().getDefaultInstance());
			//tabData.remove(CroptopiaAdditionsModItems.RICE_FLOUR.get().getDefaultInstance());
			//tabData.remove(CroptopiaAdditionsModItems.RICE_NOODLE.get().getDefaultInstance());
		}
		if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			//tabData.accept(CroptopiaAdditionsModItems.CURRY_POWDER);
			//tabData.accept(CroptopiaAdditionsModItems.RICE_FLOUR);
			//tabData.accept(CroptopiaAdditionsModItems.RICE_NOODLE);
		}
		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			//tabData.remove(CCItems.RAW_SILVER.get().getDefaultInstance());
			//tabData.remove(GItems.RAW_SILVER.get().getDefaultInstance());
			//tabData.remove(CCItems.COPPER_NUGGET.get().getDefaultInstance());
			//tabData.remove(CItems.COPPER_NUGGET.get().getDefaultInstance());
			//tabData.remove(CCItems.SILVER_NUGGET.get().getDefaultInstance());
			//tabData.remove(GItems.SILVER_NUGGET.get().getDefaultInstance());
			//tabData.remove(CCItems.SILVER_INGOT.get().getDefaultInstance());
			//tabData.remove(GItems.SILVER_INGOT.get().getDefaultInstance());
		}
		if (tabData.getTabKey() == ModTabs.NATURAL_BLOCKS.getKey()) {
			//tabData.remove(NatureBlocks.CORRUPT_GRASS.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
		}
	}

	public static void handleItemPlacements() {
		//CreativeModeTabContentsPopulator.mod(OverhaulCraft.MODID).tab(ModRegistry.CREATIVE_TAB.getKey()).addItemsAfter(Ingredient.of(ModRegistry.UNOBTAINIUM_POWDER.get()), TstpContentModItems.RANDOMIUM_POWDER).addItemsAfter(Ingredient.of(ModRegistry.CALCINATEDUNOBTAINIUM_POWDER.get()), TstpContentModItems.CALCINATED_RANDOMIUM_POWDER);
	}
}