package com.ryorama.tstpcontent.mixins.butchery;

import com.ryorama.tstpcontent.utils.ExtraFunc;
import com.ryorama.tstpcontent.utils.IPlayerCorpse;
import net.mcreator.butcher.block.entity.PlayercorpseTileEntity;
import net.mcreator.butcher.block.renderer.HangingplayerarmlessTileRenderer;
import net.mcreator.butcher.block.renderer.HangingplayerchestopenTileRenderer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

@Mixin(HangingplayerchestopenTileRenderer.class)
public abstract class HangingPlayerChestOpenTileRendererMixin extends GeoBlockRenderer<PlayercorpseTileEntity> {
    public HangingPlayerChestOpenTileRendererMixin(GeoModel<PlayercorpseTileEntity> model) {
        super(model);
    }

    @Override
    public ResourceLocation getTextureLocation(PlayercorpseTileEntity animatable) {
        ResourceLocation fallbackTexture = new ResourceLocation("minecraft:textures/entity/player/steve.png");
        if (animatable.getLevel() != null) {
            if (((IPlayerCorpse)animatable).overhaulcraft_compat$getPlayerUUID() != null) {
                if (ExtraFunc.getPlayerSkinByUUID(animatable.getLevel(), ((IPlayerCorpse)animatable).overhaulcraft_compat$getPlayerUUID()) != null) {
                    return ExtraFunc.getPlayerSkinByUUID(animatable.getLevel(), ((IPlayerCorpse)animatable).overhaulcraft_compat$getPlayerUUID());
                }
            }
        }
        return fallbackTexture;
    }
}