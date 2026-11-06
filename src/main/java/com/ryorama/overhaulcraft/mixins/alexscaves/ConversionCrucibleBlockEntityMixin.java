package com.ryorama.overhaulcraft.mixins.alexscaves;

import com.github.alexmodguy.alexscaves.server.block.blockentity.ConversionCrucibleBlockEntity;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.OverhaulCraftCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@IfModLoaded("alexscaves")
@Mixin(ConversionCrucibleBlockEntity.class)
public abstract class ConversionCrucibleBlockEntityMixin extends BlockEntity {

    public ConversionCrucibleBlockEntityMixin(BlockEntityType<?> entityType, BlockPos blockPos, BlockState blockState) {
        super(entityType, blockPos, blockState);
    }

    @ModifyReturnValue(at = @At("RETURN"), method = "getConversionAreaWidth")
    public float getConversionAreaWidth(float original) {
        return OverhaulCraftCommonConfig.CONVERSION_CRUCIBLE_RADIUS.get();
    }
}
