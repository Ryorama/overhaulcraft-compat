//package com.ryorama.overhaulcraft.mixins.alexscaves;
//
//import com.github.alexmodguy.alexscaves.server.block.blockentity.ConversionCrucibleBlockEntity;
//import com.moulberry.mixinconstraints.annotations.IfModLoaded;
//import com.ryorama.overhaulcraft.OverhaulCraft;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
//
//@IfModLoaded("alexscaves")
//@Mixin(ConversionCrucibleBlockEntity.class)
//public abstract class ConversionCrucibleBlockEntityMixin extends BlockEntity {
//
//    public ConversionCrucibleBlockEntityMixin(BlockEntityType<?> entityType, BlockPos blockPos, BlockState blockState) {
//        super(entityType, blockPos, blockState);
//    }
//
//    /**
//     * @author Ryorama
//     * @reason Make conversion crucible radius configurable
//     */
//    @Overwrite(remap = false)
//    public float getConversionAreaWidth() {
//        return OverhaulCraft.CONFIG.conversionCrucibleRadius;
//    }
//}
