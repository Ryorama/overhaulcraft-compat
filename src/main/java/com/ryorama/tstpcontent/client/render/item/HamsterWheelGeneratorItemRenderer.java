package com.ryorama.tstpcontent.client.render.item;

import com.ryorama.tstpcontent.client.model.item.HamsterWheelGeneratorItemModel;
import com.ryorama.tstpcontent.item.HamsterWheelGeneratorItem;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class HamsterWheelGeneratorItemRenderer extends GeoItemRenderer<HamsterWheelGeneratorItem> {
    public HamsterWheelGeneratorItemRenderer() {
        super(new HamsterWheelGeneratorItemModel());
    }
}
