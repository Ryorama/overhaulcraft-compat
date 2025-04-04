package com.ryorama.tstpcontent.mixins.potionmaster;

import com.ryorama.tstpcontent.utils.TstpTags;
import com.thevortex.potionsmaster.render.util.BlockData;
import com.thevortex.potionsmaster.render.util.BlockStoreBuilder;
import com.thevortex.potionsmaster.render.util.OutlineColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(BlockStoreBuilder.class)
public class BlockStoreBuilderMixin {

    @Shadow(remap = false)
    private static ArrayList<BlockData> list = new ArrayList();

    @Inject(at = @At("HEAD"), method = "init", remap = false)
    private static void init(CallbackInfo ci) {
        list.add(new BlockData("RandomiumOre", TstpTags.RANDOMIUM_ORE.toString(), new OutlineColor(149, 6, 189), false, 0));
        list.add(new BlockData("DraconiumOre", TstpTags.DRACONIUM_ORE.toString(), new OutlineColor(117, 13, 140), false, 0));
        list.add(new BlockData("SulfurOre", TstpTags.SULFUR_ORE.toString(), new OutlineColor(215, 224, 29), false, 0));
        list.add(new BlockData("NiterOre", TstpTags.NITER_ORE.toString(), new OutlineColor(214, 214, 203), false, 0));
    }
}
