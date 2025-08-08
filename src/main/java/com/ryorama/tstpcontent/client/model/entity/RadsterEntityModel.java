package com.ryorama.tstpcontent.client.model.entity;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.entities.RadsterEntity;
import com.starfish_studios.hamsters.Hamsters;
import com.starfish_studios.hamsters.HamstersConfig;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class RadsterEntityModel extends DefaultedEntityGeoModel<RadsterEntity> {

    public RadsterEntityModel() {
        super(Hamsters.id("hamster"), true);
    }

    @Override
    public ResourceLocation getModelResource(RadsterEntity hamster) {
        return Hamsters.id("geo/entity/hamster.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RadsterEntity hamster) {
        return new ResourceLocation(TstpContentMod.MODID, "textures/entity/radster.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RadsterEntity hamster) {
        return Hamsters.id("animations/hamster.rp_anim.json");
    }

    @Override
    public void setCustomAnimations(RadsterEntity hamster, long instanceId, AnimationState<RadsterEntity> animationState) {

        super.setCustomAnimations(hamster, instanceId, animationState);
        if (animationState == null) return;

        CoreGeoBone root = this.getAnimationProcessor().getBone("root");
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");
        CoreGeoBone sleep = this.getAnimationProcessor().getBone("sleep");
        CoreGeoBone cheeks = this.getAnimationProcessor().getBone("cheeks");
        CoreGeoBone leftCheek = this.getAnimationProcessor().getBone("left_cheek");
        CoreGeoBone rightCheek = this.getAnimationProcessor().getBone("right_cheek");

        cheeks.setHidden(hamster.getMainHandItem().isEmpty());
        float cheekDefaultScale = 1.0F;

        if (hamster.getCheekLevel() > 0) {

            cheeks.setHidden(false);
            float cheekScale = cheekDefaultScale + (hamster.getCheekLevel() * 0.2F);

            leftCheek.setScaleX(cheekScale);
            leftCheek.setScaleY(cheekScale);
            leftCheek.setScaleZ(cheekScale);

            rightCheek.setScaleX(cheekScale);
            rightCheek.setScaleY(cheekScale);
            rightCheek.setScaleZ(cheekScale);

        } else {
            cheeks.setScaleX(cheekDefaultScale);
            cheeks.setScaleY(cheekDefaultScale);
            cheeks.setScaleZ(cheekDefaultScale);
        }

        if (HamstersConfig.hamstersBurst && hamster.getCheekLevel() > 1) root.setRotZ((float) Math.sin(System.currentTimeMillis() * 0.05D) * 0.1F * (hamster.getCheekLevel() * 0.05F));

        // Ensures there are no strange eye glitches when the hamster is sleeping or awake.

        if (!hamster.isBaby()) sleep.setHidden(!hamster.isSleeping());

        float headScale = hamster.isBaby() ? 1.4F : 1.0F;
        if (hamster.isBaby()) head.setPosY(0.0F);

        head.setScaleX(headScale);
        head.setScaleY(headScale);
        head.setScaleZ(headScale);
    }
}