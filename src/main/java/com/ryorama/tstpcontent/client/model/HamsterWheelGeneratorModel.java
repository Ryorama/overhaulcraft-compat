package com.ryorama.tstpcontent.client.model;

import com.ryorama.tstpcontent.block.entity.HamsterWheelGeneratorBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class HamsterWheelGeneratorModel extends DefaultedBlockGeoModel<HamsterWheelGeneratorBlockEntity> {
    public HamsterWheelGeneratorModel() {
        super(new ResourceLocation("hamsters", "hamster_wheel"));
    }

    public ResourceLocation getAnimationResource(HamsterWheelGeneratorBlockEntity hamsterWheel) {
        return new ResourceLocation("hamsters", "animations/hamster_wheel.animation.json");
    }

    public RenderType getRenderType(HamsterWheelGeneratorBlockEntity animatable, ResourceLocation texture) {
        return RenderType.entityCutout(this.getTextureResource(animatable));
    }
}