package com.ryorama.overhaulcraft.mixins.potionmaster;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.overhaulcraft.utils.TstpTags;
import com.thevortex.potionsmaster.render.util.BlockData;
import com.thevortex.potionsmaster.render.util.BlockStoreBuilder;
import com.thevortex.potionsmaster.render.util.OutlineColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@IfModLoaded("potionsmaster")
@Mixin(BlockStoreBuilder.class)
public class BlockStoreBuilderMixin {

    @Shadow(remap = false)
    private static ArrayList<BlockData> list = new ArrayList();

    @Inject(at = @At("HEAD"), method = "init", remap = false)
    private static void init(CallbackInfo ci) {
        list.add(new BlockData("randomium", TstpTags.RANDOMIUM_ORE.toString(), 1496189, false, 0)); //new OutlineColor(149, 6, 189)
        list.add(new BlockData("draconium", TstpTags.DRACONIUM_ORE.toString(), 11713140, false, 0)); //new OutlineColor(117, 13, 140)
        list.add(new BlockData("sulfur", TstpTags.SULFUR_ORE.toString(), 21522429, false, 0)); //new OutlineColor(215, 224, 29)
        list.add(new BlockData("niter", TstpTags.NITER_ORE.toString(), 214214203, false, 0)); // new OutlineColor(214, 214, 203)
    }
}
