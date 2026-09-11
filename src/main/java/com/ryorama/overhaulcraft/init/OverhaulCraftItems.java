package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.items.CobbledimTeleportItem;
import com.ryorama.overhaulcraft.items.CustomizationGlobe;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OverhaulCraftItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(OverhaulCraft.MODID);

	//Misc Items
	public static final DeferredItem<Item> FRIED_DRAGON_EGG = REGISTRY.register("fried_dragon_egg", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> RANDOMIUM_ORE_CHUNK = REGISTRY.register("randomium_ore_chunk", () -> new Item(new Item.Properties()));

	//Utility Items
	public static final DeferredItem<Item> COBBLEDIM_TELEPORT_ITEM = REGISTRY.register("cobbledim_teleport_item", () -> new CobbledimTeleportItem(new Item.Properties()));
	public static final DeferredItem<Item> CUSTOMIZATION_GLOBE = REGISTRY.register("customization_globe", CustomizationGlobe::new);

	private static DeferredItem<Item> block(DeferredBlock<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
