package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.thevortex.potionsmaster.items.powders.base.BasePowder;
import com.thevortex.potionsmaster.items.powders.base.CalcinatedPowder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OverhaulCraftItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(OverhaulCraft.MODID);
	
	//Ore Sight Stuff
	public static final DeferredItem<Item> RANDOMIUM_POWDER = REGISTRY.register("randomium_powder", () -> new BasePowder(1, new Item.Properties()));
	public static final DeferredItem<Item> CALCINATED_RANDOMIUM_POWDER = REGISTRY.register("calcinatedrandomium_powder", () -> new CalcinatedPowder(1, new Item.Properties()));
	public static final DeferredItem<Item> DRACONIUM_POWDER = REGISTRY.register("draconium_powder", () -> new BasePowder(1, new Item.Properties()));
	public static final DeferredItem<Item> CALCINATED_DRACONIUM_POWDER = REGISTRY.register("calcinateddraconium_powder", () -> new CalcinatedPowder(1, new Item.Properties()));
	public static final DeferredItem<Item> SULFUR_POWDER = REGISTRY.register("sulfur_powder", () -> new BasePowder(1, new Item.Properties()));
	public static final DeferredItem<Item> CALCINATED_SULFUR_POWDER = REGISTRY.register("calcinatedsulfur_powder", () -> new CalcinatedPowder(1, new Item.Properties()));
	public static final DeferredItem<Item> NITER_POWDER = REGISTRY.register("niter_powder", () -> new BasePowder(1, new Item.Properties()));
	public static final DeferredItem<Item> CALCINATED_NITER_POWDER = REGISTRY.register("calcinatedniter_powder", () -> new CalcinatedPowder(1, new Item.Properties()));

	//Misc Items
	public static final DeferredItem<Item> FRIED_DRAGON_EGG = REGISTRY.register("fried_dragon_egg", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> RANDOMIUM_ORE_CHUNK = REGISTRY.register("randomium_ore_chunk", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> RAD_SEEDS = REGISTRY.register("rad_seed", () -> new Item(new Item.Properties()));

	//Block Items
	//Coal
	public static final DeferredItem<Item> COAL_ORE_ABYSS = block(OverhaulCraftBlocks.COAL_ORE_ABYSS);
	public static final DeferredItem<Item> COAL_ORE_HOLYSTONE = block(OverhaulCraftBlocks.COAL_ORE_HOLYSTONE);
	public static final DeferredItem<Item> COAL_ORE_CAKE = block(OverhaulCraftBlocks.COAL_ORE_CAKE);
	public static final DeferredItem<Item> COAL_ORE_LUNAR = block(OverhaulCraftBlocks.COAL_ORE_LUNAR);
	public static final DeferredItem<Item> COAL_ORE_TURQUOISE = block(OverhaulCraftBlocks.COAL_ORE_TURQUOISE);
	public static final DeferredItem<Item> COAL_ORE_DARKSTONE = block(OverhaulCraftBlocks.COAL_ORE_DARKSTONE);
	public static final DeferredItem<Item> COAL_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.COAL_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> COAL_ORE_DEMONSTONE = block(OverhaulCraftBlocks.COAL_ORE_DEMONSTONE);
	public static final DeferredItem<Item> COAL_ORE_SHADOW = block(OverhaulCraftBlocks.COAL_ORE_SHADOW);
	public static final DeferredItem<Item> COAL_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.COAL_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> COAL_ORE_DUST = block(OverhaulCraftBlocks.COAL_ORE_DUST);

	//Iron
	public static final DeferredItem<Item> IRON_ORE_HOLYSTONE = block(OverhaulCraftBlocks.IRON_ORE_HOLYSTONE);
	public static final DeferredItem<Item> IRON_ORE_ASTRAL = block(OverhaulCraftBlocks.IRON_ORE_ASTRAL);
	public static final DeferredItem<Item> IRON_ORE_CAKE = block(OverhaulCraftBlocks.IRON_ORE_CAKE);
	public static final DeferredItem<Item> IRON_ORE_LUNAR = block(OverhaulCraftBlocks.IRON_ORE_LUNAR);
	public static final DeferredItem<Item> IRON_ORE_DARKSTONE = block(OverhaulCraftBlocks.IRON_ORE_DARKSTONE);
	public static final DeferredItem<Item> IRON_ORE_DEMONSTONE = block(OverhaulCraftBlocks.IRON_ORE_DEMONSTONE);
	public static final DeferredItem<Item> IRON_ORE_SHADOW = block(OverhaulCraftBlocks.IRON_ORE_SHADOW);
	public static final DeferredItem<Item> IRON_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.IRON_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> IRON_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.IRON_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> IRON_ORE_SKYRIUM = block(OverhaulCraftBlocks.IRON_ORE_SKYRIUM);
	public static final DeferredItem<Item> IRON_ORE_DUST = block(OverhaulCraftBlocks.IRON_ORE_DUST);

	//Gold
	public static final DeferredItem<Item> GOLD_ORE_HOLYSTONE = block(OverhaulCraftBlocks.GOLD_ORE_HOLYSTONE);
	public static final DeferredItem<Item> GOLD_ORE_CAKE = block(OverhaulCraftBlocks.GOLD_ORE_CAKE);
	public static final DeferredItem<Item> GOLD_ORE_LUNAR = block(OverhaulCraftBlocks.GOLD_ORE_LUNAR);
	public static final DeferredItem<Item> GOLD_ORE_TURQUOISE = block(OverhaulCraftBlocks.GOLD_ORE_TURQUOISE);
	public static final DeferredItem<Item> GOLD_ORE_DARKSTONE = block(OverhaulCraftBlocks.GOLD_ORE_DARKSTONE);
	public static final DeferredItem<Item> GOLD_ORE_DEMONSTONE = block(OverhaulCraftBlocks.GOLD_ORE_DEMONSTONE);
	public static final DeferredItem<Item> GOLD_ORE_SHADOW = block(OverhaulCraftBlocks.GOLD_ORE_SHADOW);
	public static final DeferredItem<Item> GOLD_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.GOLD_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> GOLD_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.GOLD_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> GOLD_ORE_DUST = block(OverhaulCraftBlocks.GOLD_ORE_DUST);

	//Copper
	public static final DeferredItem<Item> COPPER_ORE_ABYSS = block(OverhaulCraftBlocks.COPPER_ORE_ABYSS);
	public static final DeferredItem<Item> COPPER_ORE_ASTRAL = block(OverhaulCraftBlocks.COPPER_ORE_ASTRAL);
	public static final DeferredItem<Item> COPPER_ORE_HOLYSTONE = block(OverhaulCraftBlocks.COPPER_ORE_HOLYSTONE);
	public static final DeferredItem<Item> COPPER_ORE_CAKE = block(OverhaulCraftBlocks.COPPER_ORE_CAKE);
	public static final DeferredItem<Item> COPPER_ORE_LUNAR = block(OverhaulCraftBlocks.COPPER_ORE_LUNAR);
	public static final DeferredItem<Item> COPPER_ORE_TURQUOISE = block(OverhaulCraftBlocks.COPPER_ORE_TURQUOISE);
	public static final DeferredItem<Item> COPPER_ORE_DARKSTONE = block(OverhaulCraftBlocks.COPPER_ORE_DARKSTONE);
	public static final DeferredItem<Item> COPPER_ORE_DEMONSTONE = block(OverhaulCraftBlocks.COPPER_ORE_DEMONSTONE);
	public static final DeferredItem<Item> COPPER_ORE_SHADOW = block(OverhaulCraftBlocks.COPPER_ORE_SHADOW);
	public static final DeferredItem<Item> COPPER_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.COPPER_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> COPPER_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.COPPER_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> COPPER_ORE_SKYRIUM = block(OverhaulCraftBlocks.COPPER_ORE_SKYRIUM);
	public static final DeferredItem<Item> COPPER_ORE_DUST = block(OverhaulCraftBlocks.COPPER_ORE_DUST);

	//Lapis
	public static final DeferredItem<Item> LAPIS_ORE_ABYSS = block(OverhaulCraftBlocks.LAPIS_ORE_ABYSS);
	public static final DeferredItem<Item> LAPIS_ORE_ASTRAL = block(OverhaulCraftBlocks.LAPIS_ORE_ASTRAL);
	public static final DeferredItem<Item> LAPIS_ORE_HOLYSTONE = block(OverhaulCraftBlocks.LAPIS_ORE_HOLYSTONE);
	public static final DeferredItem<Item> LAPIS_ORE_CAKE = block(OverhaulCraftBlocks.LAPIS_ORE_CAKE);
	public static final DeferredItem<Item> LAPIS_ORE_LUNAR = block(OverhaulCraftBlocks.LAPIS_ORE_LUNAR);
	public static final DeferredItem<Item> LAPIS_ORE_TURQUOISE = block(OverhaulCraftBlocks.LAPIS_ORE_TURQUOISE);
	public static final DeferredItem<Item> LAPIS_ORE_DARKSTONE = block(OverhaulCraftBlocks.LAPIS_ORE_DARKSTONE);
	public static final DeferredItem<Item> LAPIS_ORE_DEMONSTONE = block(OverhaulCraftBlocks.LAPIS_ORE_DEMONSTONE);
	public static final DeferredItem<Item> LAPIS_ORE_SHADOW = block(OverhaulCraftBlocks.LAPIS_ORE_SHADOW);
	public static final DeferredItem<Item> LAPIS_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.LAPIS_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> LAPIS_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.LAPIS_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> LAPIS_ORE_DUST = block(OverhaulCraftBlocks.LAPIS_ORE_DUST);

	//Redstone
	public static final DeferredItem<Item> REDSTONE_ORE_ABYSS = block(OverhaulCraftBlocks.REDSTONE_ORE_ABYSS);
	public static final DeferredItem<Item> REDSTONE_ORE_ASTRAL = block(OverhaulCraftBlocks.REDSTONE_ORE_ASTRAL);
	public static final DeferredItem<Item> REDSTONE_ORE_HOLYSTONE = block(OverhaulCraftBlocks.REDSTONE_ORE_HOLYSTONE);
	public static final DeferredItem<Item> REDSTONE_ORE_CAKE = block(OverhaulCraftBlocks.REDSTONE_ORE_CAKE);
	public static final DeferredItem<Item> REDSTONE_ORE_LUNAR = block(OverhaulCraftBlocks.REDSTONE_ORE_LUNAR);
	public static final DeferredItem<Item> REDSTONE_ORE_TURQUOISE = block(OverhaulCraftBlocks.REDSTONE_ORE_TURQUOISE);
	public static final DeferredItem<Item> REDSTONE_ORE_DARKSTONE = block(OverhaulCraftBlocks.REDSTONE_ORE_DARKSTONE);
	public static final DeferredItem<Item> REDSTONE_ORE_DEMONSTONE = block(OverhaulCraftBlocks.REDSTONE_ORE_DEMONSTONE);
	public static final DeferredItem<Item> REDSTONE_ORE_SHADOW = block(OverhaulCraftBlocks.REDSTONE_ORE_SHADOW);
	public static final DeferredItem<Item> REDSTONE_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.REDSTONE_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> REDSTONE_ORE_DUST = block(OverhaulCraftBlocks.REDSTONE_ORE_DUST);

	//Diamond
	public static final DeferredItem<Item> DIAMOND_ORE_ASTRAL = block(OverhaulCraftBlocks.DIAMOND_ORE_ASTRAL);
	public static final DeferredItem<Item> DIAMOND_ORE_HOLYSTONE = block(OverhaulCraftBlocks.DIAMOND_ORE_HOLYSTONE);
	public static final DeferredItem<Item> DIAMOND_ORE_CAKE = block(OverhaulCraftBlocks.DIAMOND_ORE_CAKE);
	public static final DeferredItem<Item> DIAMOND_ORE_LUNAR = block(OverhaulCraftBlocks.DIAMOND_ORE_LUNAR);
	public static final DeferredItem<Item> DIAMOND_ORE_TURQUOISE = block(OverhaulCraftBlocks.DIAMOND_ORE_TURQUOISE);
	public static final DeferredItem<Item> DIAMOND_ORE_DARKSTONE = block(OverhaulCraftBlocks.DIAMOND_ORE_DARKSTONE);
	public static final DeferredItem<Item> DIAMOND_ORE_DEMONSTONE = block(OverhaulCraftBlocks.DIAMOND_ORE_DEMONSTONE);
	public static final DeferredItem<Item> DIAMOND_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.DIAMOND_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> DIAMOND_ORE_SKYRIUM = block(OverhaulCraftBlocks.DIAMOND_ORE_SKYRIUM);
	public static final DeferredItem<Item> DIAMOND_ORE_DUST = block(OverhaulCraftBlocks.DIAMOND_ORE_DUST);

	//Emerald
	public static final DeferredItem<Item> EMERALD_ORE_ASTRAL = block(OverhaulCraftBlocks.EMERALD_ORE_ASTRAL);
	public static final DeferredItem<Item> EMERALD_ORE_HOLYSTONE = block(OverhaulCraftBlocks.EMERALD_ORE_HOLYSTONE);
	public static final DeferredItem<Item> EMERALD_ORE_CAKE = block(OverhaulCraftBlocks.EMERALD_ORE_CAKE);
	public static final DeferredItem<Item> EMERALD_ORE_LUNAR = block(OverhaulCraftBlocks.EMERALD_ORE_LUNAR);
	public static final DeferredItem<Item> EMERALD_ORE_TURQUOISE = block(OverhaulCraftBlocks.EMERALD_ORE_TURQUOISE);
	public static final DeferredItem<Item> EMERALD_ORE_DARKSTONE = block(OverhaulCraftBlocks.EMERALD_ORE_DARKSTONE);
	public static final DeferredItem<Item> EMERALD_ORE_DEMONSTONE = block(OverhaulCraftBlocks.EMERALD_ORE_DEMONSTONE);
	public static final DeferredItem<Item> EMERALD_ORE_SHADOW = block(OverhaulCraftBlocks.EMERALD_ORE_SHADOW);
	public static final DeferredItem<Item> EMERALD_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.EMERALD_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> EMERALD_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.EMERALD_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> EMERALD_ORE_SKYRIUM = block(OverhaulCraftBlocks.EMERALD_ORE_SKYRIUM);
	public static final DeferredItem<Item> EMERALD_ORE_DUST = block(OverhaulCraftBlocks.EMERALD_ORE_DUST);

	//Aluminum
	public static final DeferredItem<Item> ALUMINUM_ORE_ABYSS = block(OverhaulCraftBlocks.ALUMINUM_ORE_ABYSS);
	public static final DeferredItem<Item> ALUMINUM_ORE_ASTRAL = block(OverhaulCraftBlocks.ALUMINUM_ORE_ASTRAL);
	public static final DeferredItem<Item> ALUMINUM_ORE_HOLYSTONE = block(OverhaulCraftBlocks.ALUMINUM_ORE_HOLYSTONE);
	public static final DeferredItem<Item> ALUMINUM_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.ALUMINUM_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> ALUMINUM_ORE_SCULK = block(OverhaulCraftBlocks.ALUMINUM_ORE_SCULK);
	public static final DeferredItem<Item> ALUMINUM_ORE_CAKE = block(OverhaulCraftBlocks.ALUMINUM_ORE_CAKE);
	public static final DeferredItem<Item> ALUMINUM_ORE_LUNAR = block(OverhaulCraftBlocks.ALUMINUM_ORE_LUNAR);
	public static final DeferredItem<Item> ALUMINUM_ORE_TURQUOISE = block(OverhaulCraftBlocks.ALUMINUM_ORE_TURQUOISE);
	public static final DeferredItem<Item> ALUMINUM_ORE_DARKSTONE = block(OverhaulCraftBlocks.ALUMINUM_ORE_DARKSTONE);
	public static final DeferredItem<Item> ALUMINUM_ORE_DEMONSTONE = block(OverhaulCraftBlocks.ALUMINUM_ORE_DEMONSTONE);
	public static final DeferredItem<Item> ALUMINUM_ORE_SHADOW = block(OverhaulCraftBlocks.ALUMINUM_ORE_SHADOW);
	public static final DeferredItem<Item> ALUMINUM_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.ALUMINUM_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> ALUMINUM_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.ALUMINUM_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> ALUMINUM_ORE_SKYRIUM = block(OverhaulCraftBlocks.ALUMINUM_ORE_SKYRIUM);
	public static final DeferredItem<Item> ALUMINUM_ORE_DUST = block(OverhaulCraftBlocks.ALUMINUM_ORE_DUST);

	//Lead
	public static final DeferredItem<Item> LEAD_ORE_ABYSS = block(OverhaulCraftBlocks.LEAD_ORE_ABYSS);
	public static final DeferredItem<Item> LEAD_ORE_ASTRAL = block(OverhaulCraftBlocks.LEAD_ORE_ASTRAL);
	public static final DeferredItem<Item> LEAD_ORE_HOLYSTONE = block(OverhaulCraftBlocks.LEAD_ORE_HOLYSTONE);
	public static final DeferredItem<Item> LEAD_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.LEAD_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> LEAD_ORE_SCULK = block(OverhaulCraftBlocks.LEAD_ORE_SCULK);
	public static final DeferredItem<Item> LEAD_ORE_CAKE = block(OverhaulCraftBlocks.LEAD_ORE_CAKE);
	public static final DeferredItem<Item> LEAD_ORE_LUNAR = block(OverhaulCraftBlocks.LEAD_ORE_LUNAR);
	public static final DeferredItem<Item> LEAD_ORE_TURQUOISE = block(OverhaulCraftBlocks.LEAD_ORE_TURQUOISE);
	public static final DeferredItem<Item> LEAD_ORE_DARKSTONE = block(OverhaulCraftBlocks.LEAD_ORE_DARKSTONE);
	public static final DeferredItem<Item> LEAD_ORE_DEMONSTONE = block(OverhaulCraftBlocks.LEAD_ORE_DEMONSTONE);
	public static final DeferredItem<Item> LEAD_ORE_SHADOW = block(OverhaulCraftBlocks.LEAD_ORE_SHADOW);
	public static final DeferredItem<Item> LEAD_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.LEAD_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> LEAD_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.LEAD_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> LEAD_ORE_SKYRIUM = block(OverhaulCraftBlocks.LEAD_ORE_SKYRIUM);
	public static final DeferredItem<Item> LEAD_ORE_DUST = block(OverhaulCraftBlocks.LEAD_ORE_DUST);

	//Nickel
	public static final DeferredItem<Item> NICKEL_ORE_ABYSS = block(OverhaulCraftBlocks.NICKEL_ORE_ABYSS);
	public static final DeferredItem<Item> NICKEL_ORE_ASTRAL = block(OverhaulCraftBlocks.NICKEL_ORE_ASTRAL);
	public static final DeferredItem<Item> NICKEL_ORE_HOLYSTONE = block(OverhaulCraftBlocks.NICKEL_ORE_HOLYSTONE);
	public static final DeferredItem<Item> NICKEL_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.NICKEL_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> NICKEL_ORE_SCULK = block(OverhaulCraftBlocks.NICKEL_ORE_SCULK);
	public static final DeferredItem<Item> NICKEL_ORE_CAKE = block(OverhaulCraftBlocks.NICKEL_ORE_CAKE);
	public static final DeferredItem<Item> NICKEL_ORE_LUNAR = block(OverhaulCraftBlocks.NICKEL_ORE_LUNAR);
	public static final DeferredItem<Item> NICKEL_ORE_TURQUOISE = block(OverhaulCraftBlocks.NICKEL_ORE_TURQUOISE);
	public static final DeferredItem<Item> NICKEL_ORE_DARKSTONE = block(OverhaulCraftBlocks.NICKEL_ORE_DARKSTONE);
	public static final DeferredItem<Item> NICKEL_ORE_DEMONSTONE = block(OverhaulCraftBlocks.NICKEL_ORE_DEMONSTONE);
	public static final DeferredItem<Item> NICKEL_ORE_SHADOW = block(OverhaulCraftBlocks.NICKEL_ORE_SHADOW);
	public static final DeferredItem<Item> NICKEL_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.NICKEL_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> NICKEL_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.NICKEL_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> NICKEL_ORE_SKYRIUM = block(OverhaulCraftBlocks.NICKEL_ORE_SKYRIUM);
	public static final DeferredItem<Item> NICKEL_ORE_DUST = block(OverhaulCraftBlocks.NICKEL_ORE_DUST);

	//Osmium
	public static final DeferredItem<Item> OSMIUM_ORE_ABYSS = block(OverhaulCraftBlocks.OSMIUM_ORE_ABYSS);
	public static final DeferredItem<Item> OSMIUM_ORE_ASTRAL = block(OverhaulCraftBlocks.OSMIUM_ORE_ASTRAL);
	public static final DeferredItem<Item> OSMIUM_ORE_HOLYSTONE = block(OverhaulCraftBlocks.OSMIUM_ORE_HOLYSTONE);
	public static final DeferredItem<Item> OSMIUM_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.OSMIUM_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> OSMIUM_ORE_SCULK = block(OverhaulCraftBlocks.OSMIUM_ORE_SCULK);
	public static final DeferredItem<Item> OSMIUM_ORE_CAKE = block(OverhaulCraftBlocks.OSMIUM_ORE_CAKE);
	public static final DeferredItem<Item> OSMIUM_ORE_LUNAR = block(OverhaulCraftBlocks.OSMIUM_ORE_LUNAR);
	public static final DeferredItem<Item> OSMIUM_ORE_TURQUOISE = block(OverhaulCraftBlocks.OSMIUM_ORE_TURQUOISE);
	public static final DeferredItem<Item> OSMIUM_ORE_DARKSTONE = block(OverhaulCraftBlocks.OSMIUM_ORE_DARKSTONE);
	public static final DeferredItem<Item> OSMIUM_ORE_DEMONSTONE = block(OverhaulCraftBlocks.OSMIUM_ORE_DEMONSTONE);
	public static final DeferredItem<Item> OSMIUM_ORE_SHADOW = block(OverhaulCraftBlocks.OSMIUM_ORE_SHADOW);
	public static final DeferredItem<Item> OSMIUM_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.OSMIUM_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> OSMIUM_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.OSMIUM_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> OSMIUM_ORE_SKYRIUM = block(OverhaulCraftBlocks.OSMIUM_ORE_SKYRIUM);
	public static final DeferredItem<Item> OSMIUM_ORE_DUST = block(OverhaulCraftBlocks.OSMIUM_ORE_DUST);

	//Platinum
	public static final DeferredItem<Item> PLATINUM_ORE_ABYSS = block(OverhaulCraftBlocks.PLATINUM_ORE_ABYSS);
	public static final DeferredItem<Item> PLATINUM_ORE_ASTRAL = block(OverhaulCraftBlocks.PLATINUM_ORE_ASTRAL);
	public static final DeferredItem<Item> PLATINUM_ORE_HOLYSTONE = block(OverhaulCraftBlocks.PLATINUM_ORE_HOLYSTONE);
	public static final DeferredItem<Item> PLATINUM_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.PLATINUM_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> PLATINUM_ORE_SCULK = block(OverhaulCraftBlocks.PLATINUM_ORE_SCULK);
	public static final DeferredItem<Item> PLATINUM_ORE_CAKE = block(OverhaulCraftBlocks.PLATINUM_ORE_CAKE);
	public static final DeferredItem<Item> PLATINUM_ORE_LUNAR = block(OverhaulCraftBlocks.PLATINUM_ORE_LUNAR);
	public static final DeferredItem<Item> PLATINUM_ORE_TURQUOISE = block(OverhaulCraftBlocks.PLATINUM_ORE_TURQUOISE);
	public static final DeferredItem<Item> PLATINUM_ORE_DARKSTONE = block(OverhaulCraftBlocks.PLATINUM_ORE_DARKSTONE);
	public static final DeferredItem<Item> PLATINUM_ORE_DEMONSTONE = block(OverhaulCraftBlocks.PLATINUM_ORE_DEMONSTONE);
	public static final DeferredItem<Item> PLATINUM_ORE_SHADOW = block(OverhaulCraftBlocks.PLATINUM_ORE_SHADOW);
	public static final DeferredItem<Item> PLATINUM_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.PLATINUM_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> PLATINUM_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.PLATINUM_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> PLATINUM_ORE_SKYRIUM = block(OverhaulCraftBlocks.PLATINUM_ORE_SKYRIUM);
	public static final DeferredItem<Item> PLATINUM_ORE_DUST = block(OverhaulCraftBlocks.PLATINUM_ORE_DUST);

	//Silver
	public static final DeferredItem<Item> SILVER_ORE_ABYSS = block(OverhaulCraftBlocks.SILVER_ORE_ABYSS);
	public static final DeferredItem<Item> SILVER_ORE_ASTRAL = block(OverhaulCraftBlocks.SILVER_ORE_ASTRAL);
	public static final DeferredItem<Item> SILVER_ORE_HOLYSTONE = block(OverhaulCraftBlocks.SILVER_ORE_HOLYSTONE);
	public static final DeferredItem<Item> SILVER_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.SILVER_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> SILVER_ORE_SCULK = block(OverhaulCraftBlocks.SILVER_ORE_SCULK);
	public static final DeferredItem<Item> SILVER_ORE_CAKE = block(OverhaulCraftBlocks.SILVER_ORE_CAKE);
	public static final DeferredItem<Item> SILVER_ORE_LUNAR = block(OverhaulCraftBlocks.SILVER_ORE_LUNAR);
	public static final DeferredItem<Item> SILVER_ORE_TURQUOISE = block(OverhaulCraftBlocks.SILVER_ORE_TURQUOISE);
	public static final DeferredItem<Item> SILVER_ORE_DARKSTONE = block(OverhaulCraftBlocks.SILVER_ORE_DARKSTONE);
	public static final DeferredItem<Item> SILVER_ORE_DEMONSTONE = block(OverhaulCraftBlocks.SILVER_ORE_DEMONSTONE);
	public static final DeferredItem<Item> SILVER_ORE_SHADOW = block(OverhaulCraftBlocks.SILVER_ORE_SHADOW);
	public static final DeferredItem<Item> SILVER_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.SILVER_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> SILVER_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.SILVER_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> SILVER_ORE_SKYRIUM = block(OverhaulCraftBlocks.SILVER_ORE_SKYRIUM);
	public static final DeferredItem<Item> SILVER_ORE_DUST = block(OverhaulCraftBlocks.SILVER_ORE_DUST);

	//Tin
	public static final DeferredItem<Item> TIN_ORE_ABYSS = block(OverhaulCraftBlocks.TIN_ORE_ABYSS);
	public static final DeferredItem<Item> TIN_ORE_ASTRAL = block(OverhaulCraftBlocks.TIN_ORE_ASTRAL);
	public static final DeferredItem<Item> TIN_ORE_HOLYSTONE = block(OverhaulCraftBlocks.TIN_ORE_HOLYSTONE);
	public static final DeferredItem<Item> TIN_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.TIN_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> TIN_ORE_SCULK = block(OverhaulCraftBlocks.TIN_ORE_SCULK);
	public static final DeferredItem<Item> TIN_ORE_CAKE = block(OverhaulCraftBlocks.TIN_ORE_CAKE);
	public static final DeferredItem<Item> TIN_ORE_LUNAR = block(OverhaulCraftBlocks.TIN_ORE_LUNAR);
	public static final DeferredItem<Item> TIN_ORE_TURQUOISE = block(OverhaulCraftBlocks.TIN_ORE_TURQUOISE);
	public static final DeferredItem<Item> TIN_ORE_DARKSTONE = block(OverhaulCraftBlocks.TIN_ORE_DARKSTONE);
	public static final DeferredItem<Item> TIN_ORE_DEMONSTONE = block(OverhaulCraftBlocks.TIN_ORE_DEMONSTONE);
	public static final DeferredItem<Item> TIN_ORE_SHADOW = block(OverhaulCraftBlocks.TIN_ORE_SHADOW);
	public static final DeferredItem<Item> TIN_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.TIN_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> TIN_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.TIN_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> TIN_ORE_SKYRIUM = block(OverhaulCraftBlocks.TIN_ORE_SKYRIUM);
	public static final DeferredItem<Item> TIN_ORE_DUST = block(OverhaulCraftBlocks.TIN_ORE_DUST);

	//Uranium
	public static final DeferredItem<Item> URANIUM_ORE_ABYSS = block(OverhaulCraftBlocks.URANIUM_ORE_ABYSS);
	public static final DeferredItem<Item> URANIUM_ORE_ASTRAL = block(OverhaulCraftBlocks.URANIUM_ORE_ASTRAL);
	public static final DeferredItem<Item> URANIUM_ORE_HOLYSTONE = block(OverhaulCraftBlocks.URANIUM_ORE_HOLYSTONE);
	public static final DeferredItem<Item> URANIUM_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.URANIUM_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> URANIUM_ORE_SCULK = block(OverhaulCraftBlocks.URANIUM_ORE_SCULK);
	public static final DeferredItem<Item> URANIUM_ORE_CAKE = block(OverhaulCraftBlocks.URANIUM_ORE_CAKE);
	public static final DeferredItem<Item> URANIUM_ORE_LUNAR = block(OverhaulCraftBlocks.URANIUM_ORE_LUNAR);
	public static final DeferredItem<Item> URANIUM_ORE_TURQUOISE = block(OverhaulCraftBlocks.URANIUM_ORE_TURQUOISE);
	public static final DeferredItem<Item> URANIUM_ORE_DARKSTONE = block(OverhaulCraftBlocks.URANIUM_ORE_DARKSTONE);
	public static final DeferredItem<Item> URANIUM_ORE_DEMONSTONE = block(OverhaulCraftBlocks.URANIUM_ORE_DEMONSTONE);
	public static final DeferredItem<Item> URANIUM_ORE_SHADOW = block(OverhaulCraftBlocks.URANIUM_ORE_SHADOW);
	public static final DeferredItem<Item> URANIUM_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.URANIUM_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> URANIUM_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.URANIUM_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> URANIUM_ORE_SKYRIUM = block(OverhaulCraftBlocks.URANIUM_ORE_SKYRIUM);
	public static final DeferredItem<Item> URANIUM_ORE_DUST = block(OverhaulCraftBlocks.URANIUM_ORE_DUST);

	//Zinc
	public static final DeferredItem<Item> ZINC_ORE_ABYSS = block(OverhaulCraftBlocks.ZINC_ORE_ABYSS);
	public static final DeferredItem<Item> ZINC_ORE_ASTRAL = block(OverhaulCraftBlocks.ZINC_ORE_ASTRAL);
	public static final DeferredItem<Item> ZINC_ORE_HOLYSTONE = block(OverhaulCraftBlocks.ZINC_ORE_HOLYSTONE);
	public static final DeferredItem<Item> ZINC_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.ZINC_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> ZINC_ORE_SCULK = block(OverhaulCraftBlocks.ZINC_ORE_SCULK);
	public static final DeferredItem<Item> ZINC_ORE_CAKE = block(OverhaulCraftBlocks.ZINC_ORE_CAKE);
	public static final DeferredItem<Item> ZINC_ORE_LUNAR = block(OverhaulCraftBlocks.ZINC_ORE_LUNAR);
	public static final DeferredItem<Item> ZINC_ORE_TURQUOISE = block(OverhaulCraftBlocks.ZINC_ORE_TURQUOISE);
	public static final DeferredItem<Item> ZINC_ORE_DARKSTONE = block(OverhaulCraftBlocks.ZINC_ORE_DARKSTONE);
	public static final DeferredItem<Item> ZINC_ORE_DEMONSTONE = block(OverhaulCraftBlocks.ZINC_ORE_DEMONSTONE);
	public static final DeferredItem<Item> ZINC_ORE_SHADOW = block(OverhaulCraftBlocks.ZINC_ORE_SHADOW);
	public static final DeferredItem<Item> ZINC_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.ZINC_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> ZINC_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.ZINC_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> ZINC_ORE_SKYRIUM = block(OverhaulCraftBlocks.ZINC_ORE_SKYRIUM);
	public static final DeferredItem<Item> ZINC_ORE_DUST = block(OverhaulCraftBlocks.ZINC_ORE_DUST);

	//Randomium
	public static final DeferredItem<Item> RANDOMIUM_ORE_NETHER = block(OverhaulCraftBlocks.RANDOMIUM_ORE_NETHER);
	public static final DeferredItem<Item> RANDOMIUM_ORE_ABYSS = block(OverhaulCraftBlocks.RANDOMIUM_ORE_ABYSS);
	public static final DeferredItem<Item> RANDOMIUM_ORE_HOLYSTONE = block(OverhaulCraftBlocks.RANDOMIUM_ORE_HOLYSTONE);
	public static final DeferredItem<Item> RANDOMIUM_ORE_CAKE = block(OverhaulCraftBlocks.RANDOMIUM_ORE_CAKE);
	public static final DeferredItem<Item> RANDOMIUM_ORE_ASTRAL = block(OverhaulCraftBlocks.RANDOMIUM_ORE_ASTRAL);
	public static final DeferredItem<Item> RANDOMIUM_ORE_LUNAR = block(OverhaulCraftBlocks.RANDOMIUM_ORE_LUNAR);
	public static final DeferredItem<Item> RANDOMIUM_ORE_TURQUOISE = block(OverhaulCraftBlocks.RANDOMIUM_ORE_TURQUOISE);
	public static final DeferredItem<Item> RANDOMIUM_ORE_GLOOMSLATE = block(OverhaulCraftBlocks.RANDOMIUM_ORE_GLOOMSLATE);
	public static final DeferredItem<Item> RANDOMIUM_ORE_SCULK = block(OverhaulCraftBlocks.RANDOMIUM_ORE_SCULK);
	public static final DeferredItem<Item> RANDOMIUM_ORE_DARKSTONE = block(OverhaulCraftBlocks.RANDOMIUM_ORE_DARKSTONE);
	public static final DeferredItem<Item> RANDOMIUM_ORE_DEEP_GREENSTONE = block(OverhaulCraftBlocks.RANDOMIUM_ORE_DEEP_GREENSTONE);
	public static final DeferredItem<Item> RANDOMIUM_ORE_DEMONSTONE = block(OverhaulCraftBlocks.RANDOMIUM_ORE_DEMONSTONE);
	public static final DeferredItem<Item> RANDOMIUM_ORE_SHADOW = block(OverhaulCraftBlocks.RANDOMIUM_ORE_SHADOW);
	public static final DeferredItem<Item> RANDOMIUM_ORE_YELLOWSTONE = block(OverhaulCraftBlocks.RANDOMIUM_ORE_YELLOWSTONE);
	public static final DeferredItem<Item> RANDOMIUM_ORE_SKYRIUM = block(OverhaulCraftBlocks.RANDOMIUM_ORE_SKYRIUM);
	public static final DeferredItem<Item> RANDOMIUM_ORE_DUST = block(OverhaulCraftBlocks.RANDOMIUM_ORE_DUST);

	private static DeferredItem<Item> block(DeferredBlock<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
