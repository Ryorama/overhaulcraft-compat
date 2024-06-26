
package com.ryorama.tstpcontent.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IronItemItem extends Item {
	public IronItemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
