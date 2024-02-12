package com.ryorama.tstpcontent.client.model;

import com.ryorama.tstpcontent.block.entity.HamsterWheelGeneratorBlockEntity;
import com.starfish_studios.hamsters.Hamsters;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HamsterWheelGeneratorModel extends AnimatedGeoModel<HamsterWheelGeneratorBlockEntity> {
    @Override
    public ResourceLocation getAnimationResource(HamsterWheelGeneratorBlockEntity hamsterWheel) {
        return new ResourceLocation(Hamsters.MOD_ID, "animations/hamster_wheel.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(HamsterWheelGeneratorBlockEntity object) {
        return new ResourceLocation(Hamsters.MOD_ID, "geo/block/hamster_wheel.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HamsterWheelGeneratorBlockEntity object) {
        return new ResourceLocation(Hamsters.MOD_ID, "textures/block/hamster_wheel.png");
    }
}