package com.ryorama.overhaulcraft.items.curios;

import com.github.alexthe666.alexsmobs.effect.AMEffectRegistry;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class MosquitoRepellingCharm extends Item implements ICurioItem {
    public MosquitoRepellingCharm() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (ExtraFunc.isModInstalled("alexsmobs")) {
            LivingEntity entity = slotContext.entity();
            long gameTime = entity.level().getGameTime();

            if (gameTime % 60 == 0) entity.addEffect(new MobEffectInstance(AMEffectRegistry.MOSQUITO_REPELLENT, 80, 0, false, false));
        }
    }
}