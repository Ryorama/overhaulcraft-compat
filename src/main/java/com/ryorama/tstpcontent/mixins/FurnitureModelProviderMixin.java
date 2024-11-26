package com.ryorama.tstpcontent.mixins;

import com.mrcrayfish.framework.Registration;
import com.mrcrayfish.furniture.refurbished.block.MetalType;
import com.mrcrayfish.furniture.refurbished.data.model.ModelTemplate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Arrays;

@Mixin(targets = "com.mrcrayfish.furniture.refurbished.data.FurnitureModelProvider")
public abstract class FurnitureModelProviderMixin extends BlockStateProvider {

    @Final
    @Shadow(remap = false)
    public static ExistingFileHelper.ResourceType TEXTURE;

    @Final
    @Shadow(remap = false)
    public static ExistingFileHelper.ResourceType MODEL;

    public FurnitureModelProviderMixin(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    /**
     * @author Ryorama
     * @reason Fix for dev environment
     */
    @Overwrite(remap = false)
    private void registerExistingResources(ExistingFileHelper helper) {
        ModelTemplate.all().forEach((model) -> {
            helper.trackGenerated(model, MODEL);
        });
        Registration.get(Registries.BLOCK).stream().filter((entry) -> {
            return entry.getId().getNamespace().equals("refurbished_furniture");
        }).forEach((entry) -> {
            helper.trackGenerated(this.blockTexture((Block)entry.get()), TEXTURE);
        });
    }
}
