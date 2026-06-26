package com.ryorama.overhaulcraft.mixins.confluence;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.common.block.natural.ShadowOrbBlock;
import org.confluence.terraentity.init.TESounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShadowOrbBlock.class)
public abstract class ShadowOrbMixin extends Block {
    public ShadowOrbMixin(Properties properties) {
        super(properties);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lorg/confluence/mod/util/ModUtils;summonBoss(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lorg/confluence/terraentity/entity/boss/AbstractTerraBossBase;Z)V"), method = "onRemove")
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston, CallbackInfo ci) {
        level.playSound(null, pos, TESounds.ROAR.get(), SoundSource.BLOCKS);
    }
}