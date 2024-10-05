
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.item.cuisinedelight.DarkPotItem;
import com.thevortex.potionsmaster.items.powders.base.BasePowder;
import com.thevortex.potionsmaster.items.powders.base.CalcinatedPowder;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import com.ryorama.tstpcontent.item.WoodItem;
import com.ryorama.tstpcontent.item.MushroomItem;
import com.ryorama.tstpcontent.item.LifeCrystalItem;
import com.ryorama.tstpcontent.item.IronItemItem;
import com.ryorama.tstpcontent.item.CopperItemItem;
import com.ryorama.tstpcontent.TstpContentMod;

public class TstpContentModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TstpContentMod.MODID);

	public static final RegistryObject<Item> IRON = REGISTRY.register("iron", () -> new IronItemItem());
	public static final RegistryObject<Item> COPPER = REGISTRY.register("copper", () -> new CopperItemItem());
	public static final RegistryObject<Item> MUSHROOM = REGISTRY.register("mushroom", () -> new MushroomItem());
	public static final RegistryObject<Item> FRIED_DRAGON_EGG = REGISTRY.register("fried_dragon_egg", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> WOOD = REGISTRY.register("wood", () -> new WoodItem());
	public static final RegistryObject<Item> LIFE_CRYSTAL = REGISTRY.register("life_crystal", () -> new LifeCrystalItem());
	public static final RegistryObject<Item> RANDOMIUM_POWDER = REGISTRY.register("randomium_powder", () -> new BasePowder(new Item.Properties()));
	public static final RegistryObject<Item> CALCINATED_RANDOMIUM_POWDER = REGISTRY.register("calcinatedrandomium_powder", () -> new CalcinatedPowder(new Item.Properties()));
	public static final RegistryObject<Item> MUSIC_DISC_1 = REGISTRY.register("music_disc_1", () -> new RecordItem(14, TstpContentModSounds.UNIVERSAL_COLLAPSE_EPIC.get(), new Item.Properties().stacksTo(1), 239 * 20));

	public static final RegistryObject<Item> GRASS_BLOCK = block(TstpContentModBlocks.GRASS_BLOCK);
	public static final RegistryObject<Item> DIRT_BLOCK = block(TstpContentModBlocks.DIRT_BLOCK);
	public static final RegistryObject<Item> SAND_BLOCK = block(TstpContentModBlocks.SAND_BLOCK);
	public static final RegistryObject<Item> SNOW = block(TstpContentModBlocks.SNOW);
	public static final RegistryObject<Item> GRASS = block(TstpContentModBlocks.GRASS);
	public static final RegistryObject<Item> WOOD_LOG = block(TstpContentModBlocks.WOOD_LOG);
	public static final RegistryObject<Item> CACTUS = block(TstpContentModBlocks.CACTUS);
	public static final RegistryObject<Item> FOREST_LEAVES = block(TstpContentModBlocks.FOREST_LEAVES);
	public static final RegistryObject<Item> ICE = block(TstpContentModBlocks.ICE);
	public static final RegistryObject<Item> COPPER_ORE = block(TstpContentModBlocks.COPPER_ORE);
	public static final RegistryObject<Item> STONE = block(TstpContentModBlocks.STONE);
	public static final RegistryObject<Item> IRON_ORE = block(TstpContentModBlocks.IRON_ORE);
	public static final RegistryObject<Item> MUSHROOM_PLANT = block(TstpContentModBlocks.MUSHROOM_PLANT);
	public static final RegistryObject<Item> LIFE_CRYSTAL_BLOCK = block(TstpContentModBlocks.LIFE_CRYSTAL_BLOCK);
	public static final RegistryObject<Item> CALORITE_MACHINE_CASING = block(TstpContentModBlocks.CALORITE_MACHINE_CASING);
	public static final RegistryObject<Item> OSTRUM_MACHINE_CASING = block(TstpContentModBlocks.OSTRUM_MACHINE_CASING);
	public static final RegistryObject<Item> HVAC_BLOCK = block(TstpContentModBlocks.HVAC_BLOCK);
	public static final ItemEntry<DarkPotItem> DARK_POT;

	static {
		DARK_POT = TstpContentMod.REGISTRATE.item("dark_cooking_pot", p -> new DarkPotItem(TstpContentModBlocks.DARK_POT.get(), p.stacksTo(1)))
				.model((ctx, pvd) -> pvd.getBuilder(ctx.getName()).parent(new ModelFile.UncheckedModelFile("builtin/entity")))
				.setData(ProviderType.LANG, NonNullBiConsumer.noop()).register();
	}
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
