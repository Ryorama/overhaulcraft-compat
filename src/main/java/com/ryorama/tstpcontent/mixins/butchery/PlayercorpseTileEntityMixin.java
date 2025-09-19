package com.ryorama.tstpcontent.mixins.butchery;

import com.ryorama.tstpcontent.utils.IPlayerCorpse;
import net.mcreator.butcher.block.entity.PlayercorpseTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.UUID;

@Mixin(PlayercorpseTileEntity.class)
public abstract class PlayercorpseTileEntityMixin extends RandomizableContainerBlockEntity implements IPlayerCorpse {
    @Unique
    public UUID playerUUID = new UUID(0L, 0L);

    public PlayercorpseTileEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public PlayercorpseTileEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, UUID playerUUID) {
        super(blockEntityType, blockPos, blockState);
        overhaulcraft_compat$setPlayerUUID(playerUUID);
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
