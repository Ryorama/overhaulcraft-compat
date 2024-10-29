package com.ryorama.tstpcontent.init;

import com.thevortex.potionsmaster.items.powders.base.BasePowder;
import com.thevortex.potionsmaster.items.powders.base.CalcinatedPowder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.BlockItem;


import com.ryorama.tstpcontent.TstpContentMod;

public class TstpContentModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TstpContentMod.MODID);

	public static final RegistryObject<Item> FRIED_DRAGON_EGG = REGISTRY.register("fried_dragon_egg", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RANDOMIUM_POWDER = REGISTRY.register("randomium_powder", () -> new BasePowder(new Item.Properties()));
	public static final RegistryObject<Item> CALCINATED_RANDOMIUM_POWDER = REGISTRY.register("calcinatedrandomium_powder", () -> new CalcinatedPowder(new Item.Properties()));
	public static final RegistryObject<Item> MUSIC_DISC_1 = REGISTRY.register("music_disc_1", () -> new RecordItem(14, TstpContentModSounds.UNIVERSAL_COLLAPSE_EPIC.get(), new Item.Properties().stacksTo(1), 239 * 20));
	public static final RegistryObject<Item> RANDOMIUM_ORE_CHUNK = REGISTRY.register("randomium_ore_chunk", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> CALORITE_MACHINE_CASING = block(TstpContentModBlocks.CALORITE_MACHINE_CASING);
	public static final RegistryObject<Item> OSTRUM_MACHINE_CASING = block(TstpContentModBlocks.OSTRUM_MACHINE_CASING);
	public static final RegistryObject<Item> HVAC_BLOCK = block(TstpContentModBlocks.HVAC_BLOCK);

	//Coal
	public static final RegistryObject<Item> COAL_ORE_ABYSS = block(TstpContentModBlocks.COAL_ORE_ABYSS);
	public static final RegistryObject<Item> COAL_ORE_HOLYSTONE = block(TstpContentModBlocks.COAL_ORE_HOLYSTONE);
	public static final RegistryObject<Item> COAL_ORE_CAKE = block(TstpContentModBlocks.COAL_ORE_CAKE);
	public static final RegistryObject<Item> COAL_ORE_LUNAR = block(TstpContentModBlocks.COAL_ORE_LUNAR);
	public static final RegistryObject<Item> COAL_ORE_TURQUOISE = block(TstpContentModBlocks.COAL_ORE_TURQUOISE);
	public static final RegistryObject<Item> COAL_ORE_DARKSTONE = block(TstpContentModBlocks.COAL_ORE_DARKSTONE);
	public static final RegistryObject<Item> COAL_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.COAL_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> COAL_ORE_DEMONSTONE = block(TstpContentModBlocks.COAL_ORE_DEMONSTONE);
	public static final RegistryObject<Item> COAL_ORE_SHADOW = block(TstpContentModBlocks.COAL_ORE_SHADOW);
	public static final RegistryObject<Item> COAL_ORE_YELLOWSTONE = block(TstpContentModBlocks.COAL_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> COAL_ORE_TERRARIA = block(TstpContentModBlocks.COAL_ORE_TERRARIA);
	public static final RegistryObject<Item> COAL_ORE_DUST = block(TstpContentModBlocks.COAL_ORE_DUST);

	//Iron
	public static final RegistryObject<Item> IRON_ORE_HOLYSTONE = block(TstpContentModBlocks.IRON_ORE_HOLYSTONE);
	public static final RegistryObject<Item> IRON_ORE_ASTRAL = block(TstpContentModBlocks.IRON_ORE_ASTRAL);
	public static final RegistryObject<Item> IRON_ORE_CAKE = block(TstpContentModBlocks.IRON_ORE_CAKE);
	public static final RegistryObject<Item> IRON_ORE_LUNAR = block(TstpContentModBlocks.IRON_ORE_LUNAR);
	public static final RegistryObject<Item> IRON_ORE_DARKSTONE = block(TstpContentModBlocks.IRON_ORE_DARKSTONE);
	public static final RegistryObject<Item> IRON_ORE_DEMONSTONE = block(TstpContentModBlocks.IRON_ORE_DEMONSTONE);
	public static final RegistryObject<Item> IRON_ORE_SHADOW = block(TstpContentModBlocks.IRON_ORE_SHADOW);
	public static final RegistryObject<Item> IRON_ORE_YELLOWSTONE = block(TstpContentModBlocks.IRON_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> IRON_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.IRON_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> IRON_ORE_SKYRIUM = block(TstpContentModBlocks.IRON_ORE_SKYRIUM);
	public static final RegistryObject<Item> IRON_ORE_DUST = block(TstpContentModBlocks.IRON_ORE_DUST);

	//Gold
	public static final RegistryObject<Item> GOLD_ORE_HOLYSTONE = block(TstpContentModBlocks.GOLD_ORE_HOLYSTONE);
	public static final RegistryObject<Item> GOLD_ORE_CAKE = block(TstpContentModBlocks.GOLD_ORE_CAKE);
	public static final RegistryObject<Item> GOLD_ORE_LUNAR = block(TstpContentModBlocks.GOLD_ORE_LUNAR);
	public static final RegistryObject<Item> GOLD_ORE_TURQUOISE = block(TstpContentModBlocks.GOLD_ORE_TURQUOISE);
	public static final RegistryObject<Item> GOLD_ORE_DARKSTONE = block(TstpContentModBlocks.GOLD_ORE_DARKSTONE);
	public static final RegistryObject<Item> GOLD_ORE_DEMONSTONE = block(TstpContentModBlocks.GOLD_ORE_DEMONSTONE);
	public static final RegistryObject<Item> GOLD_ORE_SHADOW = block(TstpContentModBlocks.GOLD_ORE_SHADOW);
	public static final RegistryObject<Item> GOLD_ORE_YELLOWSTONE = block(TstpContentModBlocks.GOLD_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> GOLD_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.GOLD_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> GOLD_ORE_DUST = block(TstpContentModBlocks.GOLD_ORE_DUST);

	//Copper
	public static final RegistryObject<Item> COPPER_ORE_ABYSS = block(TstpContentModBlocks.COPPER_ORE_ABYSS);
	public static final RegistryObject<Item> COPPER_ORE_ASTRAL = block(TstpContentModBlocks.COPPER_ORE_ASTRAL);
	public static final RegistryObject<Item> COPPER_ORE_HOLYSTONE = block(TstpContentModBlocks.COPPER_ORE_HOLYSTONE);
	public static final RegistryObject<Item> COPPER_ORE_CAKE = block(TstpContentModBlocks.COPPER_ORE_CAKE);
	public static final RegistryObject<Item> COPPER_ORE_LUNAR = block(TstpContentModBlocks.COPPER_ORE_LUNAR);
	public static final RegistryObject<Item> COPPER_ORE_TURQUOISE = block(TstpContentModBlocks.COPPER_ORE_TURQUOISE);
	public static final RegistryObject<Item> COPPER_ORE_DARKSTONE = block(TstpContentModBlocks.COPPER_ORE_DARKSTONE);
	public static final RegistryObject<Item> COPPER_ORE_DEMONSTONE = block(TstpContentModBlocks.COPPER_ORE_DEMONSTONE);
	public static final RegistryObject<Item> COPPER_ORE_SHADOW = block(TstpContentModBlocks.COPPER_ORE_SHADOW);
	public static final RegistryObject<Item> COPPER_ORE_YELLOWSTONE = block(TstpContentModBlocks.COPPER_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> COPPER_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.COPPER_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> COPPER_ORE_SKYRIUM = block(TstpContentModBlocks.COPPER_ORE_SKYRIUM);
	public static final RegistryObject<Item> COPPER_ORE_DUST = block(TstpContentModBlocks.COPPER_ORE_DUST);

	//Lapis
	public static final RegistryObject<Item> LAPIS_ORE_ABYSS = block(TstpContentModBlocks.LAPIS_ORE_ABYSS);
	public static final RegistryObject<Item> LAPIS_ORE_ASTRAL = block(TstpContentModBlocks.LAPIS_ORE_ASTRAL);
	public static final RegistryObject<Item> LAPIS_ORE_HOLYSTONE = block(TstpContentModBlocks.LAPIS_ORE_HOLYSTONE);
	public static final RegistryObject<Item> LAPIS_ORE_CAKE = block(TstpContentModBlocks.LAPIS_ORE_CAKE);
	public static final RegistryObject<Item> LAPIS_ORE_LUNAR = block(TstpContentModBlocks.LAPIS_ORE_LUNAR);
	public static final RegistryObject<Item> LAPIS_ORE_TURQUOISE = block(TstpContentModBlocks.LAPIS_ORE_TURQUOISE);
	public static final RegistryObject<Item> LAPIS_ORE_DARKSTONE = block(TstpContentModBlocks.LAPIS_ORE_DARKSTONE);
	public static final RegistryObject<Item> LAPIS_ORE_DEMONSTONE = block(TstpContentModBlocks.LAPIS_ORE_DEMONSTONE);
	public static final RegistryObject<Item> LAPIS_ORE_SHADOW = block(TstpContentModBlocks.LAPIS_ORE_SHADOW);
	public static final RegistryObject<Item> LAPIS_ORE_YELLOWSTONE = block(TstpContentModBlocks.LAPIS_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> LAPIS_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.LAPIS_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> LAPIS_ORE_TERRARIA = block(TstpContentModBlocks.LAPIS_ORE_TERRARIA);
	public static final RegistryObject<Item> LAPIS_ORE_DUST = block(TstpContentModBlocks.LAPIS_ORE_DUST);

	//Redstone
	public static final RegistryObject<Item> REDSTONE_ORE_ABYSS = block(TstpContentModBlocks.REDSTONE_ORE_ABYSS);
	public static final RegistryObject<Item> REDSTONE_ORE_ASTRAL = block(TstpContentModBlocks.REDSTONE_ORE_ASTRAL);
	public static final RegistryObject<Item> REDSTONE_ORE_HOLYSTONE = block(TstpContentModBlocks.REDSTONE_ORE_HOLYSTONE);
	public static final RegistryObject<Item> REDSTONE_ORE_CAKE = block(TstpContentModBlocks.REDSTONE_ORE_CAKE);
	public static final RegistryObject<Item> REDSTONE_ORE_LUNAR = block(TstpContentModBlocks.REDSTONE_ORE_LUNAR);
	public static final RegistryObject<Item> REDSTONE_ORE_TURQUOISE = block(TstpContentModBlocks.REDSTONE_ORE_TURQUOISE);
	public static final RegistryObject<Item> REDSTONE_ORE_DARKSTONE = block(TstpContentModBlocks.REDSTONE_ORE_DARKSTONE);
	public static final RegistryObject<Item> REDSTONE_ORE_DEMONSTONE = block(TstpContentModBlocks.REDSTONE_ORE_DEMONSTONE);
	public static final RegistryObject<Item> REDSTONE_ORE_SHADOW = block(TstpContentModBlocks.REDSTONE_ORE_SHADOW);
	public static final RegistryObject<Item> REDSTONE_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.REDSTONE_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> REDSTONE_ORE_TERRARIA = block(TstpContentModBlocks.REDSTONE_ORE_TERRARIA);
	public static final RegistryObject<Item> REDSTONE_ORE_DUST = block(TstpContentModBlocks.REDSTONE_ORE_DUST);

	//Diamond
	public static final RegistryObject<Item> DIAMOND_ORE_ASTRAL = block(TstpContentModBlocks.DIAMOND_ORE_ASTRAL);
	public static final RegistryObject<Item> DIAMOND_ORE_HOLYSTONE = block(TstpContentModBlocks.DIAMOND_ORE_HOLYSTONE);
	public static final RegistryObject<Item> DIAMOND_ORE_CAKE = block(TstpContentModBlocks.DIAMOND_ORE_CAKE);
	public static final RegistryObject<Item> DIAMOND_ORE_LUNAR = block(TstpContentModBlocks.DIAMOND_ORE_LUNAR);
	public static final RegistryObject<Item> DIAMOND_ORE_TURQUOISE = block(TstpContentModBlocks.DIAMOND_ORE_TURQUOISE);
	public static final RegistryObject<Item> DIAMOND_ORE_DARKSTONE = block(TstpContentModBlocks.DIAMOND_ORE_DARKSTONE);
	public static final RegistryObject<Item> DIAMOND_ORE_DEMONSTONE = block(TstpContentModBlocks.DIAMOND_ORE_DEMONSTONE);
	public static final RegistryObject<Item> DIAMOND_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.DIAMOND_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> DIAMOND_ORE_SKYRIUM = block(TstpContentModBlocks.DIAMOND_ORE_SKYRIUM);
	public static final RegistryObject<Item> DIAMOND_ORE_DUST = block(TstpContentModBlocks.DIAMOND_ORE_DUST);

	//Emerald
	public static final RegistryObject<Item> EMERALD_ORE_ASTRAL = block(TstpContentModBlocks.EMERALD_ORE_ASTRAL);
	public static final RegistryObject<Item> EMERALD_ORE_HOLYSTONE = block(TstpContentModBlocks.EMERALD_ORE_HOLYSTONE);
	public static final RegistryObject<Item> EMERALD_ORE_CAKE = block(TstpContentModBlocks.EMERALD_ORE_CAKE);
	public static final RegistryObject<Item> EMERALD_ORE_LUNAR = block(TstpContentModBlocks.EMERALD_ORE_LUNAR);
	public static final RegistryObject<Item> EMERALD_ORE_TURQUOISE = block(TstpContentModBlocks.EMERALD_ORE_TURQUOISE);
	public static final RegistryObject<Item> EMERALD_ORE_DARKSTONE = block(TstpContentModBlocks.EMERALD_ORE_DARKSTONE);
	public static final RegistryObject<Item> EMERALD_ORE_DEMONSTONE = block(TstpContentModBlocks.EMERALD_ORE_DEMONSTONE);
	public static final RegistryObject<Item> EMERALD_ORE_SHADOW = block(TstpContentModBlocks.EMERALD_ORE_SHADOW);
	public static final RegistryObject<Item> EMERALD_ORE_YELLOWSTONE = block(TstpContentModBlocks.EMERALD_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> EMERALD_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.EMERALD_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> EMERALD_ORE_SKYRIUM = block(TstpContentModBlocks.EMERALD_ORE_SKYRIUM);
	public static final RegistryObject<Item> EMERALD_ORE_DUST = block(TstpContentModBlocks.EMERALD_ORE_DUST);

	//Aluminum
	public static final RegistryObject<Item> ALUMINUM_ORE_ABYSS = block(TstpContentModBlocks.ALUMINUM_ORE_ABYSS);
	public static final RegistryObject<Item> ALUMINUM_ORE_ASTRAL = block(TstpContentModBlocks.ALUMINUM_ORE_ASTRAL);
	public static final RegistryObject<Item> ALUMINUM_ORE_HOLYSTONE = block(TstpContentModBlocks.ALUMINUM_ORE_HOLYSTONE);
	public static final RegistryObject<Item> ALUMINUM_ORE_GLOOMSLATE = block(TstpContentModBlocks.ALUMINUM_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> ALUMINUM_ORE_SCULK = block(TstpContentModBlocks.ALUMINUM_ORE_SCULK);
	public static final RegistryObject<Item> ALUMINUM_ORE_CAKE = block(TstpContentModBlocks.ALUMINUM_ORE_CAKE);
	public static final RegistryObject<Item> ALUMINUM_ORE_LUNAR = block(TstpContentModBlocks.ALUMINUM_ORE_LUNAR);
	public static final RegistryObject<Item> ALUMINUM_ORE_TURQUOISE = block(TstpContentModBlocks.ALUMINUM_ORE_TURQUOISE);
	public static final RegistryObject<Item> ALUMINUM_ORE_DARKSTONE = block(TstpContentModBlocks.ALUMINUM_ORE_DARKSTONE);
	public static final RegistryObject<Item> ALUMINUM_ORE_DEMONSTONE = block(TstpContentModBlocks.ALUMINUM_ORE_DEMONSTONE);
	public static final RegistryObject<Item> ALUMINUM_ORE_SHADOW = block(TstpContentModBlocks.ALUMINUM_ORE_SHADOW);
	public static final RegistryObject<Item> ALUMINUM_ORE_YELLOWSTONE = block(TstpContentModBlocks.ALUMINUM_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> ALUMINUM_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.ALUMINUM_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> ALUMINUM_ORE_TERRARIA = block(TstpContentModBlocks.ALUMINUM_ORE_TERRARIA);
	public static final RegistryObject<Item> ALUMINUM_ORE_SKYRIUM = block(TstpContentModBlocks.ALUMINUM_ORE_SKYRIUM);
	public static final RegistryObject<Item> ALUMINUM_ORE_DUST = block(TstpContentModBlocks.ALUMINUM_ORE_DUST);

	//Lead
	public static final RegistryObject<Item> LEAD_ORE_ABYSS = block(TstpContentModBlocks.LEAD_ORE_ABYSS);
	public static final RegistryObject<Item> LEAD_ORE_ASTRAL = block(TstpContentModBlocks.LEAD_ORE_ASTRAL);
	public static final RegistryObject<Item> LEAD_ORE_HOLYSTONE = block(TstpContentModBlocks.LEAD_ORE_HOLYSTONE);
	public static final RegistryObject<Item> LEAD_ORE_GLOOMSLATE = block(TstpContentModBlocks.LEAD_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> LEAD_ORE_SCULK = block(TstpContentModBlocks.LEAD_ORE_SCULK);
	public static final RegistryObject<Item> LEAD_ORE_CAKE = block(TstpContentModBlocks.LEAD_ORE_CAKE);
	public static final RegistryObject<Item> LEAD_ORE_LUNAR = block(TstpContentModBlocks.LEAD_ORE_LUNAR);
	public static final RegistryObject<Item> LEAD_ORE_TURQUOISE = block(TstpContentModBlocks.LEAD_ORE_TURQUOISE);
	public static final RegistryObject<Item> LEAD_ORE_DARKSTONE = block(TstpContentModBlocks.LEAD_ORE_DARKSTONE);
	public static final RegistryObject<Item> LEAD_ORE_DEMONSTONE = block(TstpContentModBlocks.LEAD_ORE_DEMONSTONE);
	public static final RegistryObject<Item> LEAD_ORE_SHADOW = block(TstpContentModBlocks.LEAD_ORE_SHADOW);
	public static final RegistryObject<Item> LEAD_ORE_YELLOWSTONE = block(TstpContentModBlocks.LEAD_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> LEAD_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.LEAD_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> LEAD_ORE_SKYRIUM = block(TstpContentModBlocks.LEAD_ORE_SKYRIUM);
	public static final RegistryObject<Item> LEAD_ORE_DUST = block(TstpContentModBlocks.LEAD_ORE_DUST);

	//Nickel
	public static final RegistryObject<Item> NICKEL_ORE_ABYSS = block(TstpContentModBlocks.NICKEL_ORE_ABYSS);
	public static final RegistryObject<Item> NICKEL_ORE_ASTRAL = block(TstpContentModBlocks.NICKEL_ORE_ASTRAL);
	public static final RegistryObject<Item> NICKEL_ORE_HOLYSTONE = block(TstpContentModBlocks.NICKEL_ORE_HOLYSTONE);
	public static final RegistryObject<Item> NICKEL_ORE_GLOOMSLATE = block(TstpContentModBlocks.NICKEL_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> NICKEL_ORE_SCULK = block(TstpContentModBlocks.NICKEL_ORE_SCULK);
	public static final RegistryObject<Item> NICKEL_ORE_CAKE = block(TstpContentModBlocks.NICKEL_ORE_CAKE);
	public static final RegistryObject<Item> NICKEL_ORE_LUNAR = block(TstpContentModBlocks.NICKEL_ORE_LUNAR);
	public static final RegistryObject<Item> NICKEL_ORE_TURQUOISE = block(TstpContentModBlocks.NICKEL_ORE_TURQUOISE);
	public static final RegistryObject<Item> NICKEL_ORE_DARKSTONE = block(TstpContentModBlocks.NICKEL_ORE_DARKSTONE);
	public static final RegistryObject<Item> NICKEL_ORE_DEMONSTONE = block(TstpContentModBlocks.NICKEL_ORE_DEMONSTONE);
	public static final RegistryObject<Item> NICKEL_ORE_SHADOW = block(TstpContentModBlocks.NICKEL_ORE_SHADOW);
	public static final RegistryObject<Item> NICKEL_ORE_YELLOWSTONE = block(TstpContentModBlocks.NICKEL_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> NICKEL_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.NICKEL_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> NICKEL_ORE_TERRARIA = block(TstpContentModBlocks.NICKEL_ORE_TERRARIA);
	public static final RegistryObject<Item> NICKEL_ORE_SKYRIUM = block(TstpContentModBlocks.NICKEL_ORE_SKYRIUM);
	public static final RegistryObject<Item> NICKEL_ORE_DUST = block(TstpContentModBlocks.NICKEL_ORE_DUST);

	//Osmium
	public static final RegistryObject<Item> OSMIUM_ORE_ABYSS = block(TstpContentModBlocks.OSMIUM_ORE_ABYSS);
	public static final RegistryObject<Item> OSMIUM_ORE_ASTRAL = block(TstpContentModBlocks.OSMIUM_ORE_ASTRAL);
	public static final RegistryObject<Item> OSMIUM_ORE_HOLYSTONE = block(TstpContentModBlocks.OSMIUM_ORE_HOLYSTONE);
	public static final RegistryObject<Item> OSMIUM_ORE_GLOOMSLATE = block(TstpContentModBlocks.OSMIUM_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> OSMIUM_ORE_SCULK = block(TstpContentModBlocks.OSMIUM_ORE_SCULK);
	public static final RegistryObject<Item> OSMIUM_ORE_CAKE = block(TstpContentModBlocks.OSMIUM_ORE_CAKE);
	public static final RegistryObject<Item> OSMIUM_ORE_LUNAR = block(TstpContentModBlocks.OSMIUM_ORE_LUNAR);
	public static final RegistryObject<Item> OSMIUM_ORE_TURQUOISE = block(TstpContentModBlocks.OSMIUM_ORE_TURQUOISE);
	public static final RegistryObject<Item> OSMIUM_ORE_DARKSTONE = block(TstpContentModBlocks.OSMIUM_ORE_DARKSTONE);
	public static final RegistryObject<Item> OSMIUM_ORE_DEMONSTONE = block(TstpContentModBlocks.OSMIUM_ORE_DEMONSTONE);
	public static final RegistryObject<Item> OSMIUM_ORE_SHADOW = block(TstpContentModBlocks.OSMIUM_ORE_SHADOW);
	public static final RegistryObject<Item> OSMIUM_ORE_YELLOWSTONE = block(TstpContentModBlocks.OSMIUM_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> OSMIUM_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.OSMIUM_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> OSMIUM_ORE_TERRARIA = block(TstpContentModBlocks.OSMIUM_ORE_TERRARIA);
	public static final RegistryObject<Item> OSMIUM_ORE_SKYRIUM = block(TstpContentModBlocks.OSMIUM_ORE_SKYRIUM);
	public static final RegistryObject<Item> OSMIUM_ORE_DUST = block(TstpContentModBlocks.OSMIUM_ORE_DUST);

	//Platinum
	public static final RegistryObject<Item> PLATINUM_ORE_ABYSS = block(TstpContentModBlocks.PLATINUM_ORE_ABYSS);
	public static final RegistryObject<Item> PLATINUM_ORE_ASTRAL = block(TstpContentModBlocks.PLATINUM_ORE_ASTRAL);
	public static final RegistryObject<Item> PLATINUM_ORE_HOLYSTONE = block(TstpContentModBlocks.PLATINUM_ORE_HOLYSTONE);
	public static final RegistryObject<Item> PLATINUM_ORE_GLOOMSLATE = block(TstpContentModBlocks.PLATINUM_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> PLATINUM_ORE_SCULK = block(TstpContentModBlocks.PLATINUM_ORE_SCULK);
	public static final RegistryObject<Item> PLATINUM_ORE_CAKE = block(TstpContentModBlocks.PLATINUM_ORE_CAKE);
	public static final RegistryObject<Item> PLATINUM_ORE_LUNAR = block(TstpContentModBlocks.PLATINUM_ORE_LUNAR);
	public static final RegistryObject<Item> PLATINUM_ORE_TURQUOISE = block(TstpContentModBlocks.PLATINUM_ORE_TURQUOISE);
	public static final RegistryObject<Item> PLATINUM_ORE_DARKSTONE = block(TstpContentModBlocks.PLATINUM_ORE_DARKSTONE);
	public static final RegistryObject<Item> PLATINUM_ORE_DEMONSTONE = block(TstpContentModBlocks.PLATINUM_ORE_DEMONSTONE);
	public static final RegistryObject<Item> PLATINUM_ORE_SHADOW = block(TstpContentModBlocks.PLATINUM_ORE_SHADOW);
	public static final RegistryObject<Item> PLATINUM_ORE_YELLOWSTONE = block(TstpContentModBlocks.PLATINUM_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> PLATINUM_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.PLATINUM_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> PLATINUM_ORE_SKYRIUM = block(TstpContentModBlocks.PLATINUM_ORE_SKYRIUM);
	public static final RegistryObject<Item> PLATINUM_ORE_DUST = block(TstpContentModBlocks.PLATINUM_ORE_DUST);

	//Silver
	public static final RegistryObject<Item> SILVER_ORE_ABYSS = block(TstpContentModBlocks.SILVER_ORE_ABYSS);
	public static final RegistryObject<Item> SILVER_ORE_ASTRAL = block(TstpContentModBlocks.SILVER_ORE_ASTRAL);
	public static final RegistryObject<Item> SILVER_ORE_HOLYSTONE = block(TstpContentModBlocks.SILVER_ORE_HOLYSTONE);
	public static final RegistryObject<Item> SILVER_ORE_GLOOMSLATE = block(TstpContentModBlocks.SILVER_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> SILVER_ORE_SCULK = block(TstpContentModBlocks.SILVER_ORE_SCULK);
	public static final RegistryObject<Item> SILVER_ORE_CAKE = block(TstpContentModBlocks.SILVER_ORE_CAKE);
	public static final RegistryObject<Item> SILVER_ORE_LUNAR = block(TstpContentModBlocks.SILVER_ORE_LUNAR);
	public static final RegistryObject<Item> SILVER_ORE_TURQUOISE = block(TstpContentModBlocks.SILVER_ORE_TURQUOISE);
	public static final RegistryObject<Item> SILVER_ORE_DARKSTONE = block(TstpContentModBlocks.SILVER_ORE_DARKSTONE);
	public static final RegistryObject<Item> SILVER_ORE_DEMONSTONE = block(TstpContentModBlocks.SILVER_ORE_DEMONSTONE);
	public static final RegistryObject<Item> SILVER_ORE_SHADOW = block(TstpContentModBlocks.SILVER_ORE_SHADOW);
	public static final RegistryObject<Item> SILVER_ORE_YELLOWSTONE = block(TstpContentModBlocks.SILVER_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> SILVER_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.SILVER_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> SILVER_ORE_SKYRIUM = block(TstpContentModBlocks.SILVER_ORE_SKYRIUM);
	public static final RegistryObject<Item> SILVER_ORE_DUST = block(TstpContentModBlocks.SILVER_ORE_DUST);

	//Tin
	public static final RegistryObject<Item> TIN_ORE_ABYSS = block(TstpContentModBlocks.TIN_ORE_ABYSS);
	public static final RegistryObject<Item> TIN_ORE_ASTRAL = block(TstpContentModBlocks.TIN_ORE_ASTRAL);
	public static final RegistryObject<Item> TIN_ORE_HOLYSTONE = block(TstpContentModBlocks.TIN_ORE_HOLYSTONE);
	public static final RegistryObject<Item> TIN_ORE_GLOOMSLATE = block(TstpContentModBlocks.TIN_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> TIN_ORE_SCULK = block(TstpContentModBlocks.TIN_ORE_SCULK);
	public static final RegistryObject<Item> TIN_ORE_CAKE = block(TstpContentModBlocks.TIN_ORE_CAKE);
	public static final RegistryObject<Item> TIN_ORE_LUNAR = block(TstpContentModBlocks.TIN_ORE_LUNAR);
	public static final RegistryObject<Item> TIN_ORE_TURQUOISE = block(TstpContentModBlocks.TIN_ORE_TURQUOISE);
	public static final RegistryObject<Item> TIN_ORE_DARKSTONE = block(TstpContentModBlocks.TIN_ORE_DARKSTONE);
	public static final RegistryObject<Item> TIN_ORE_DEMONSTONE = block(TstpContentModBlocks.TIN_ORE_DEMONSTONE);
	public static final RegistryObject<Item> TIN_ORE_SHADOW = block(TstpContentModBlocks.TIN_ORE_SHADOW);
	public static final RegistryObject<Item> TIN_ORE_YELLOWSTONE = block(TstpContentModBlocks.TIN_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> TIN_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.TIN_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> TIN_ORE_SKYRIUM = block(TstpContentModBlocks.TIN_ORE_SKYRIUM);
	public static final RegistryObject<Item> TIN_ORE_DUST = block(TstpContentModBlocks.TIN_ORE_DUST);

	//Uranium
	public static final RegistryObject<Item> URANIUM_ORE_ABYSS = block(TstpContentModBlocks.URANIUM_ORE_ABYSS);
	public static final RegistryObject<Item> URANIUM_ORE_ASTRAL = block(TstpContentModBlocks.URANIUM_ORE_ASTRAL);
	public static final RegistryObject<Item> URANIUM_ORE_HOLYSTONE = block(TstpContentModBlocks.URANIUM_ORE_HOLYSTONE);
	public static final RegistryObject<Item> URANIUM_ORE_GLOOMSLATE = block(TstpContentModBlocks.URANIUM_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> URANIUM_ORE_SCULK = block(TstpContentModBlocks.URANIUM_ORE_SCULK);
	public static final RegistryObject<Item> URANIUM_ORE_CAKE = block(TstpContentModBlocks.URANIUM_ORE_CAKE);
	public static final RegistryObject<Item> URANIUM_ORE_LUNAR = block(TstpContentModBlocks.URANIUM_ORE_LUNAR);
	public static final RegistryObject<Item> URANIUM_ORE_TURQUOISE = block(TstpContentModBlocks.URANIUM_ORE_TURQUOISE);
	public static final RegistryObject<Item> URANIUM_ORE_DARKSTONE = block(TstpContentModBlocks.URANIUM_ORE_DARKSTONE);
	public static final RegistryObject<Item> URANIUM_ORE_DEMONSTONE = block(TstpContentModBlocks.URANIUM_ORE_DEMONSTONE);
	public static final RegistryObject<Item> URANIUM_ORE_SHADOW = block(TstpContentModBlocks.URANIUM_ORE_SHADOW);
	public static final RegistryObject<Item> URANIUM_ORE_YELLOWSTONE = block(TstpContentModBlocks.URANIUM_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> URANIUM_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.URANIUM_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> URANIUM_ORE_TERRARIA = block(TstpContentModBlocks.URANIUM_ORE_TERRARIA);
	public static final RegistryObject<Item> URANIUM_ORE_SKYRIUM = block(TstpContentModBlocks.URANIUM_ORE_SKYRIUM);
	public static final RegistryObject<Item> URANIUM_ORE_DUST = block(TstpContentModBlocks.URANIUM_ORE_DUST);

	//Zinc
	public static final RegistryObject<Item> ZINC_ORE_ABYSS = block(TstpContentModBlocks.ZINC_ORE_ABYSS);
	public static final RegistryObject<Item> ZINC_ORE_ASTRAL = block(TstpContentModBlocks.ZINC_ORE_ASTRAL);
	public static final RegistryObject<Item> ZINC_ORE_HOLYSTONE = block(TstpContentModBlocks.ZINC_ORE_HOLYSTONE);
	public static final RegistryObject<Item> ZINC_ORE_GLOOMSLATE = block(TstpContentModBlocks.ZINC_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> ZINC_ORE_SCULK = block(TstpContentModBlocks.ZINC_ORE_SCULK);
	public static final RegistryObject<Item> ZINC_ORE_CAKE = block(TstpContentModBlocks.ZINC_ORE_CAKE);
	public static final RegistryObject<Item> ZINC_ORE_LUNAR = block(TstpContentModBlocks.ZINC_ORE_LUNAR);
	public static final RegistryObject<Item> ZINC_ORE_TURQUOISE = block(TstpContentModBlocks.ZINC_ORE_TURQUOISE);
	public static final RegistryObject<Item> ZINC_ORE_DARKSTONE = block(TstpContentModBlocks.ZINC_ORE_DARKSTONE);
	public static final RegistryObject<Item> ZINC_ORE_DEMONSTONE = block(TstpContentModBlocks.ZINC_ORE_DEMONSTONE);
	public static final RegistryObject<Item> ZINC_ORE_SHADOW = block(TstpContentModBlocks.ZINC_ORE_SHADOW);
	public static final RegistryObject<Item> ZINC_ORE_YELLOWSTONE = block(TstpContentModBlocks.ZINC_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> ZINC_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.ZINC_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> ZINC_ORE_TERRARIA = block(TstpContentModBlocks.ZINC_ORE_TERRARIA);
	public static final RegistryObject<Item> ZINC_ORE_SKYRIUM = block(TstpContentModBlocks.ZINC_ORE_SKYRIUM);
	public static final RegistryObject<Item> ZINC_ORE_DUST = block(TstpContentModBlocks.ZINC_ORE_DUST);

	//Randomium
	public static final RegistryObject<Item> RANDOMIUM_ORE_NETHER = block(TstpContentModBlocks.RANDOMIUM_ORE_NETHER);
	public static final RegistryObject<Item> RANDOMIUM_ORE_ABYSS = block(TstpContentModBlocks.RANDOMIUM_ORE_ABYSS);
	public static final RegistryObject<Item> RANDOMIUM_ORE_HOLYSTONE = block(TstpContentModBlocks.RANDOMIUM_ORE_HOLYSTONE);
	public static final RegistryObject<Item> RANDOMIUM_ORE_CAKE = block(TstpContentModBlocks.RANDOMIUM_ORE_CAKE);
	public static final RegistryObject<Item> RANDOMIUM_ORE_ASTRAL = block(TstpContentModBlocks.RANDOMIUM_ORE_ASTRAL);
	public static final RegistryObject<Item> RANDOMIUM_ORE_LUNAR = block(TstpContentModBlocks.RANDOMIUM_ORE_LUNAR);
	public static final RegistryObject<Item> RANDOMIUM_ORE_TURQUOISE = block(TstpContentModBlocks.RANDOMIUM_ORE_TURQUOISE);
	public static final RegistryObject<Item> RANDOMIUM_ORE_GLOOMSLATE = block(TstpContentModBlocks.RANDOMIUM_ORE_GLOOMSLATE);
	public static final RegistryObject<Item> RANDOMIUM_ORE_SCULK = block(TstpContentModBlocks.RANDOMIUM_ORE_SCULK);
	public static final RegistryObject<Item> RANDOMIUM_ORE_DARKSTONE = block(TstpContentModBlocks.RANDOMIUM_ORE_DARKSTONE);
	public static final RegistryObject<Item> RANDOMIUM_ORE_DEEP_GREENSTONE = block(TstpContentModBlocks.RANDOMIUM_ORE_DEEP_GREENSTONE);
	public static final RegistryObject<Item> RANDOMIUM_ORE_DEMONSTONE = block(TstpContentModBlocks.RANDOMIUM_ORE_DEMONSTONE);
	public static final RegistryObject<Item> RANDOMIUM_ORE_SHADOW = block(TstpContentModBlocks.RANDOMIUM_ORE_SHADOW);
	public static final RegistryObject<Item> RANDOMIUM_ORE_YELLOWSTONE = block(TstpContentModBlocks.RANDOMIUM_ORE_YELLOWSTONE);
	public static final RegistryObject<Item> RANDOMIUM_ORE_TERRARIA = block(TstpContentModBlocks.RANDOMIUM_ORE_TERRARIA);
	public static final RegistryObject<Item> RANDOMIUM_ORE_SKYRIUM = block(TstpContentModBlocks.RANDOMIUM_ORE_SKYRIUM);
	public static final RegistryObject<Item> RANDOMIUM_ORE_DUST = block(TstpContentModBlocks.RANDOMIUM_ORE_DUST);


	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
