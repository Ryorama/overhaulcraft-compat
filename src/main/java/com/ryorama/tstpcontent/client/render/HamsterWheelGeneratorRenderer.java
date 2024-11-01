package com.ryorama.tstpcontent.client.render;

import com.ryorama.tstpcontent.block.entity.HamsterWheelGeneratorBlockEntity;
import com.ryorama.tstpcontent.client.model.HamsterWheelGeneratorModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;


public class HamsterWheelGeneratorRenderer extends GeoBlockRenderer<HamsterWheelGeneratorBlockEntity> {
    public HamsterWheelGeneratorRenderer() {
        super(new HamsterWheelGeneratorModel());
    }
}