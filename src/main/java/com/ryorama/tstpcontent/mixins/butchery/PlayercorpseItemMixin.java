package com.ryorama.tstpcontent.mixins.butchery;

import com.ryorama.tstpcontent.utils.IPlayerCorpse;
import net.mcreator.butcher.item.PlayercorpseitemItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.UUID;

@Mixin(PlayercorpseitemItem.class)
public abstract class PlayercorpseItemMixin extends Item implements IPlayerCorpse {
    @Unique
    public UUID playerUUID = new UUID(0L, 0L);

    public PlayercorpseItemMixin(Properties properties) {
        super(properties);
    }

    @Override
    public void overhaulcraft_compat$setPlayerUUID(UUID uuid) {
        playerUUID = uuid;
    }

    @Override
    public UUID overhaulcraft_compat$getPlayerUUID() {
        return playerUUID;
    }

    @Override
    public CompoundTag getShareTag(ItemStack stack)
    {
        CompoundTag compoundTag = stack.getTag();
        if (playerUUID != null) {
            compoundTag.putUUID("playerUUID", playerUUID);
        }
        return compoundTag;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundTag nbt)
    {
        if (nbt.getUUID("playerUUID") != null) {
            playerUUID = nbt.getUUID("playerUUID");
        }
        stack.setTag(nbt);
    }
}
