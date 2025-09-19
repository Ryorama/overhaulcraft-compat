package com.ryorama.tstpcontent.mixins.butchery;

import com.ryorama.tstpcontent.utils.IPlayerCorpse;
import net.mcreator.butcher.block.entity.HangingplayerintestinesTileEntity;
import net.mcreator.butcher.block.entity.HangingplayerstomachTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.UUID;

@Mixin(HangingplayerintestinesTileEntity.class)
public abstract class HangingplayerIntestinsTileEntityMixin extends RandomizableContainerBlockEntity implements IPlayerCorpse {
    @Unique
    public UUID playerUUID = new UUID(0L, 0L);

    public HangingplayerIntestinsTileEntityMixin(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
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
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        if (overhaulcraft_compat$getPlayerUUID() != null) {
            overhaulcraft_compat$setPlayerUUID(compoundTag.getUUID("playerUUID"));
        }
    }

    @Override
    public void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        if (overhaulcraft_compat$getPlayerUUID() != null) {
            compoundTag.putUUID("playerUUID", overhaulcraft_compat$getPlayerUUID());
        }
    }
}
