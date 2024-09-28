package com.ryorama.tstpcontent.block.cuisine_delight.entity;

import com.ryorama.tstpcontent.init.TstpContentModItems;
import com.ryorama.tstpcontent.item.cuisinedelight.DarkPotItem;
import dev.xkmc.cuisinedelight.content.item.SpatulaItem;
import dev.xkmc.cuisinedelight.content.logic.CookingData;
import dev.xkmc.l2library.base.tile.BaseBlockEntity;
import dev.xkmc.l2modularblock.tile_api.TickableBlockEntity;
import dev.xkmc.l2serial.serialization.SerialClass;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.entity.HeatableBlockEntity;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;

import javax.annotation.Nonnull;

@SerialClass
public class DarkPotBlockEntity extends BaseBlockEntity implements HeatableBlockEntity, TickableBlockEntity {

    public DarkPotBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @SerialClass.SerialField(toClient = true)
    public ItemStack baseItem = TstpContentModItems.DARK_POT.asStack();

    @Nonnull
    @SerialClass.SerialField(toClient = true)
    public CookingData cookingData = new CookingData();

    @SerialClass.SerialField(toClient = true)
    private int stirTimer = 0;
    @Override
    public boolean requiresDirectHeat() {
        return true;
    }

    public void tick() {
        if (level == null || !isHeated()) return;
        if (level.isClientSide) {
            BlockPos pos = getBlockPos();
            RandomSource random = level.random;
            double r0 = 0.3D;
            double r1 = 0.2D;
            if (random.nextFloat() < 0.2F) {
                double x = pos.getX() + 0.5D + (random.nextDouble() * 2 - 1) * r0;
                double y = pos.getY() + 0.5D + 0.2D;
                double z = pos.getZ() + 0.5D + (random.nextDouble() * 2 - 1) * r0;
                level.addParticle(ParticleTypes.BUBBLE_POP, x, y, z, 0.0D, 0.0D, 0.0D);
            }

            if (random.nextFloat() < 0.05F) {
                double x = pos.getX() + 0.5D + (random.nextDouble() * 2 - 1) * r1;
                double y = pos.getY() + 0.5D;
                double z = pos.getZ() + 0.5D + (random.nextDouble() * 2 - 1) * r1;
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                level.addParticle(ModParticleTypes.STEAM.get(), x, y, z, 0.0D, motionY, 0.0D);
            }
        }
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (stirTimer > 0) {
            stirTimer--;
        }
    }
    public boolean isHeated() {
        if (level == null) return false;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (!isHeated(level, getBlockPos().offset(x, 0, z))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPotItem(ItemStack stack) {
        baseItem = stack.copy();
        var data = DarkPotItem.getData(stack);
        if (data != null) {
            cookingData = data;
        }
        DarkPotItem.setData(baseItem, null);
        sync();
    }

    public boolean isCooking() {
        return cookingData.contents.size() > 0;
    }

    public NonNullList<ItemStack> getItems() {
        return NonNullList.create();
    }

    public ItemStack toItemStack() {
        ItemStack ans = baseItem.copy();
        if (cookingData.contents.size() > 0) {
            DarkPotItem.setData(ans, cookingData);
        }
        return ans;
    }

    public boolean canCook() {
        return baseItem.getEnchantmentLevel(Enchantments.FIRE_ASPECT) > 0 ||
                this.level != null && this.isHeated(this.level, this.getBlockPos());
    }

    public boolean slowCook() {
        return baseItem.getEnchantmentLevel(Enchantments.FIRE_ASPECT) == 1 &&
                this.level != null && !this.isHeated(this.level, this.getBlockPos());
    }

    public float getStirPercent(float pTick) {
        return Math.max(0, stirTimer - pTick) / SpatulaItem.ANIM_TIME;
    }

    public void stir(long gameTime, int reduce) {
        cookingData.stir(gameTime, reduce);
        stirTimer = SpatulaItem.ANIM_TIME;
        sync();
    }
}