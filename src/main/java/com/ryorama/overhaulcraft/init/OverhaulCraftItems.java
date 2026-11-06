package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.items.CobbledimTeleportItem;
import com.ryorama.overhaulcraft.items.CustomizationGlobe;
import com.ryorama.overhaulcraft.items.bosssummon.MechanicalEye;
import com.ryorama.overhaulcraft.items.curios.MosquitoRepellingCharm;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.lib.util.LibDateUtils;
import org.confluence.mod.common.entity.boss.EyeOfCthulhu;
import org.confluence.mod.common.entity.boss.SkeletronPrime;
import org.confluence.mod.common.entity.boss.TheDestroyer;
import org.confluence.mod.common.entity.boss.TwinEyeEncounter;
import org.confluence.mod.common.init.entity.BossEntities;
import org.confluence.mod.common.item.common.BossSummoningItem;
import top.theillusivec4.curios.api.CuriosApi;

public class OverhaulCraftItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(OverhaulCraft.MODID);

	//Misc Items
	public static final DeferredItem<Item> FRIED_DRAGON_EGG = REGISTRY.register("fried_dragon_egg", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> RANDOMIUM_ORE_CHUNK = REGISTRY.register("randomium_ore_chunk", () -> new Item(new Item.Properties()));

	//Utility Items
	public static final DeferredItem<Item> COBBLEDIM_TELEPORT_ITEM = REGISTRY.register("cobbledim_teleport_item", () -> new CobbledimTeleportItem(new Item.Properties()));
	public static final DeferredItem<Item> CUSTOMIZATION_GLOBE = REGISTRY.register("customization_globe", CustomizationGlobe::new);

	//Boss Summons
	public static final DeferredItem<Item> MECHANICAL_EYE = REGISTRY.register("mechanical_eye", () -> new MechanicalEye((player) -> LibDateUtils.isNight(player.level())));
	public static final DeferredItem<BossSummoningItem> MECHANICAL_SKULL = REGISTRY.register("mechanical_skull", () -> new BossSummoningItem((player) -> LibDateUtils.isNight(player.level()), (level) -> new SkeletronPrime(BossEntities.SKELETRON_PRIME.get(), level)));
	public static final DeferredItem<BossSummoningItem> MECHANICAL_WORM = REGISTRY.register("mechanical_worm", () -> new BossSummoningItem((player) -> LibDateUtils.isNight(player.level()), (level) -> new TheDestroyer(BossEntities.THE_DESTROYER.get(), level)));

	//Curios
	public static final DeferredItem<Item> MOSQUITO_REPELLING_CHARM = REGISTRY.register("mosquito_repelling_charm", MosquitoRepellingCharm::new);

	public static void registerCurios() {
		CuriosApi.registerCurio(MOSQUITO_REPELLING_CHARM.get(), new MosquitoRepellingCharm());
	}

	private static DeferredItem<Item> block(DeferredBlock<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
