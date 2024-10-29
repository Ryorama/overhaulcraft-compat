package com.ryorama.tstpcontent.init;

import com.thevortex.potionsmaster.init.ModRegistry;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
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

	public static final RegistryObject<CreativeModeTab> TSTP_ORE_COMP = REGISTRY.register("tstp_ore_comp",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tstp_content.tstp_ore_comp")).icon(() -> new ItemStack(TstpContentModBlocks.RANDOMIUM_ORE_NETHER.get())).displayItems((parameters, tabData) -> {
				//Coal
				tabData.accept(TstpContentModBlocks.COAL_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.COAL_ORE_DUST.get().asItem());

				//Iron
				tabData.accept(TstpContentModBlocks.IRON_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.IRON_ORE_DUST.get().asItem());

				//Gold
				tabData.accept(TstpContentModBlocks.GOLD_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.GOLD_ORE_DUST.get().asItem());

				//Copper
				tabData.accept(TstpContentModBlocks.COPPER_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.COPPER_ORE_DUST.get().asItem());

				//Lapis
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.LAPIS_ORE_DUST.get().asItem());

				//Redstone
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.REDSTONE_ORE_DUST.get().asItem());

				//Diamond
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.DIAMOND_ORE_DUST.get().asItem());

				//Emerald
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.EMERALD_ORE_DUST.get().asItem());

				//Aluminum
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.ALUMINUM_ORE_SCULK.get().asItem());

				//Lead
				tabData.accept(TstpContentModBlocks.LEAD_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.LEAD_ORE_SCULK.get().asItem());

				//Nickel
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.NICKEL_ORE_SCULK.get().asItem());

				//Osmium
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.OSMIUM_ORE_SCULK.get().asItem());

				//Platinum
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.PLATINUM_ORE_SCULK.get().asItem());

				//Silver
				tabData.accept(TstpContentModBlocks.SILVER_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.SILVER_ORE_SCULK.get().asItem());

				//Tin
				tabData.accept(TstpContentModBlocks.TIN_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.TIN_ORE_SCULK.get().asItem());

				//Uranium
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.URANIUM_ORE_SCULK.get().asItem());

				//Zinc
				tabData.accept(TstpContentModBlocks.ZINC_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.ZINC_ORE_SCULK.get().asItem());

				//Randomium
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_NETHER.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_ABYSS.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_ASTRAL.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_HOLYSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_CAKE.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_LUNAR.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_TURQUOISE.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_DARKSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_DEMONSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_SHADOW.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_YELLOWSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_DEEP_GREENSTONE.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_TERRARIA.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_DUST.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_SKYRIUM.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_GLOOMSLATE.get().asItem());
				tabData.accept(TstpContentModBlocks.RANDOMIUM_ORE_SCULK.get().asItem());

			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == ModRegistry.CREATIVE_TAB.getKey()) {
			tabData.accept(TstpContentModItems.RANDOMIUM_POWDER);
			tabData.accept(TstpContentModItems.CALCINATED_RANDOMIUM_POWDER);
		}
	}
}
