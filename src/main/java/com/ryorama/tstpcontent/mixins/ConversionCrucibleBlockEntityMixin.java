package com.ryorama.tstpcontent.mixins;

import com.github.alexmodguy.alexscaves.server.block.blockentity.ConversionCrucibleBlockEntity;
import com.ryorama.tstpcontent.TstpContentMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ConversionCrucibleBlockEntity.class)
public class ConversionCrucibleBlockEntityMixin {

    /**
     * @author Ryorama
     * @reason Make conversion crucible radius configurable
     */
    @Overwrite(remap = false)
    public float getConversionAreaWidth() {
        return TstpContentMod.CONFIG.conversionCrucibleRadius;
    }
}
