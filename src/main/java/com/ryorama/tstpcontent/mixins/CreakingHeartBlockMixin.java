package com.ryorama.tstpcontent.mixins;

import linfox.earlyupdatetwo.block.CreakingHeartBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CreakingHeartBlock.class)
public abstract class CreakingHeartBlockMixin extends Block {

    @Shadow protected abstract void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder);

    public CreakingHeartBlockMixin(Properties properties) {
        super(properties);
        this.createBlockStateDefinition(this.defaultBlockState().ro);
    }
}