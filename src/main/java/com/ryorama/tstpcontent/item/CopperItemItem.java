
package com.ryorama.tstpcontent.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CopperItemItem extends Item {
	public CopperItemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
