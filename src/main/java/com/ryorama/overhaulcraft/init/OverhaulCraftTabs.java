package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

//@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OverhaulCraftTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.CREATIVE_MODE_TAB);
	
	public static final RegistrySupplier<CreativeModeTab> TSTP_ORE_COMP = REGISTRY.register("tstp_ore_comp",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tstp_content.tstp_ore_comp")).icon(() -> new ItemStack(OverhaulCraftBlocks.RANDOMIUM_ORE_NETHER.get())).displayItems((parameters, tabData) -> {
				//Coal
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COAL_ORE_DUST.get().asItem());

				//Iron
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.IRON_ORE_DUST.get().asItem());

				//Gold
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.GOLD_ORE_DUST.get().asItem());

				//Copper
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.COPPER_ORE_DUST.get().asItem());

				//Lapis
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LAPIS_ORE_DUST.get().asItem());

				//Redstone
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.REDSTONE_ORE_DUST.get().asItem());

				//Diamond
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.DIAMOND_ORE_DUST.get().asItem());

				//Emerald
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.EMERALD_ORE_DUST.get().asItem());

				//Aluminum
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ALUMINUM_ORE_SCULK.get().asItem());

				//Lead
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.LEAD_ORE_SCULK.get().asItem());

				//Nickel
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.NICKEL_ORE_SCULK.get().asItem());

				//Osmium
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.OSMIUM_ORE_SCULK.get().asItem());

				//Platinum
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.PLATINUM_ORE_SCULK.get().asItem());

				//Silver
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.SILVER_ORE_SCULK.get().asItem());

				//Tin
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.TIN_ORE_SCULK.get().asItem());

				//Uranium
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.URANIUM_ORE_SCULK.get().asItem());

				//Zinc
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.ZINC_ORE_SCULK.get().asItem());

				//Randomium
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_NETHER.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_ABYSS.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_ASTRAL.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_CAKE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_LUNAR.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_SHADOW.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_DUST.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(OverhaulCraftBlocks.RANDOMIUM_ORE_SCULK.get().asItem());

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
	}

	public static void handleItemPlacements() {
		//CreativeModeTabContentsPopulator.mod(TstpContentMod.MODID).tab(CreativeModeTabs.INGREDIENTS).addItemsAfter(Ingredient.of(Items.SCUTE), TstpContentModItems.ARMADILLO_SCUTE); //.tab(ModRegistry.CREATIVE_TAB.getKey()).addItemsAfter(Ingredient.of(ModRegistry.UNOBTAINIUM_POWDER.get()), TstpContentModItems.RANDOMIUM_POWDER).addItemsAfter(Ingredient.of(ModRegistry.CALCINATEDUNOBTAINIUM_POWDER.get()), TstpContentModItems.CALCINATED_RANDOMIUM_POWDER);
	}
}