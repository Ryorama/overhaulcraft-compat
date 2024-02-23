package com.ryorama.tstpcontent.client.model.item;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.item.HamsterWheelGeneratorItem;
import com.starfish_studios.hamsters.Hamsters;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HamsterWheelGeneratorItemModel extends AnimatedGeoModel<HamsterWheelGeneratorItem> {
    @Override
    public ResourceLocation getAnimationResource(HamsterWheelGeneratorItem hamsterWheel) {
        return new ResourceLocation(TstpContentMod.MODID, "animations/hamster_wheel.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(HamsterWheelGeneratorItem object) {
        return new ResourceLocation(TstpContentMod.MODID, "geo/block/hamster_wheel.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HamsterWheelGeneratorItem object) {
        return new ResourceLocation(TstpContentMod.MODID, "textures/blocks/hamster_wheel.png");
    }
}
