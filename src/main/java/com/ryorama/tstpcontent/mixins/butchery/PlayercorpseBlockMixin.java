package com.ryorama.tstpcontent.mixins.butchery;

import com.ryorama.tstpcontent.utils.IPlayerCorpse;
import net.mcreator.butcher.block.PlayercorpseBlock;
import net.mcreator.butcher.block.entity.PlayercorpseTileEntity;
import net.mcreator.butcher.init.ButcherModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nullable;
import java.util.UUID;

@Mixin(PlayercorpseBlock.class)
public abstract class PlayercorpseBlockMixin extends BaseEntityBlock implements EntityBlock, IPlayerCorpse {
    @Unique
    public UUID playerUUID = new UUID(0L, 0L);

    protected PlayercorpseBlockMixin(Properties properties) {
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

    /**
     * @author Ryorama
     * @reason Add UUID when creating entity
     */
    @Overwrite(remap = false)
    @Nullable
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        if (overhaulcraft_compat$getPlayerUUID() != null) {
            PlayercorpseTileEntity corpseEntity = ButcherModBlockEntities.PLAYERCORPSE.get().create(blockPos, blockState);
            ((IPlayerCorpse)corpseEntity).overhaulcraft_compat$setPlayerUUID(this.overhaulcraft_compat$getPlayerUUID());
            return corpseEntity;
        }
        return ButcherModBlockEntities.PLAYERCORPSE.get().create(blockPos, blockState);
    }
}
