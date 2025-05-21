package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.WolfVarient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;


@Mixin(WolfRenderer.class)
public class WolfRenderMixin {

    public Map<Integer, String> varientMap = new HashMap<>();

    @Inject(at = @At("TAIL"), method = "<init>")
    public void init(EntityRendererProvider.Context arg, CallbackInfo ci) {
        varientMap.put(1, "ashen");
        varientMap.put(2, "black");
        varientMap.put(3, "chestnut");
        varientMap.put(4, "pale");
        varientMap.put(5, "rusty");
        varientMap.put(6, "snowy");
        varientMap.put(7, "spotted");
        varientMap.put(8, "striped");
        varientMap.put(9, "woods");
    }

    /**
     * @author Ryorama
     * @reason Add wolf varients
     */
    @Overwrite
    public ResourceLocation getTextureLocation(Wolf arg) {
        int wolfVariant;

        if (arg instanceof WolfVarient) {
            wolfVariant = arg.getEntityData().get(((WolfVarient) arg).getVariant());
        } else {
            wolfVariant = 4;
        }

        for (int v = 0; v < varientMap.size(); v++) {
            int varientId = varientMap.keySet().stream().toList().get(v);
            String varientType = varientMap.values().stream().toList().get(v);
            if (varientId == wolfVariant) {
                if (varientId == 4) {
                    if (arg.isTame()) {
                        return new ResourceLocation("textures/entity/wolf/wolf_tame.png");
                    } else {
                        return arg.isAngry() ? new ResourceLocation("textures/entity/wolf/wolf_angry.png") : new ResourceLocation("textures/entity/wolf/wolf.png");
                    }
                } else {
                    if (arg.isTame()) {
                        return new ResourceLocation("textures/entity/wolf/wolf_" + varientType + "_tame.png");
                    } else {
                        return arg.isAngry() ? new ResourceLocation("textures/entity/wolf/wolf_" + varientType + "_angry.png") : new ResourceLocation("textures/entity/wolf/wolf_" + varientType + ".png");
                    }
                }
            }
        }

        if (arg.isTame()) {
            return new ResourceLocation("textures/entity/wolf/wolf_tame.png");
        } else {
            return arg.isAngry() ? new ResourceLocation("textures/entity/wolf/wolf_angry.png") : new ResourceLocation("textures/entity/wolf/wolf.png");
        }
    }
}
