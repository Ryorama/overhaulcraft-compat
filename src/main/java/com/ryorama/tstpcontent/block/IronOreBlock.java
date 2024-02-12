
package com.ryorama.tstpcontent.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

import com.ryorama.tstpcontent.init.TstpContentModItems;

public class IronOreBlock extends Block {
	public IronOreBlock() {
		super(BlockBehaviour.Properties
				.of(Material.STONE).sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("tstp_content:tink1")), () -> new SoundEvent(new ResourceLocation("block.stone.step")),
						() -> new SoundEvent(new ResourceLocation("tstp_content:tink0")), () -> new SoundEvent(new ResourceLocation("tstp_content:tink0")), () -> new SoundEvent(new ResourceLocation("tstp_content:tink0"))))
				.strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
			return tieredItem.getTier().getLevel() >= 1;
		return false;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(TstpContentModItems.IRON_ITEM.get()));
	}
}
