/*
package com.ryorama.overhaulcraft.datagen.client;

import com.ryorama.overhaulcraft.TstpContentMod;
import net.mehvahdjukaar.randomium.common.RandomiumOreBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.stream.Collectors;

public class BlockStates extends BlockStateProvider {
    public BlockStates(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), TstpContentMod.MODID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        getKnownBlocks().forEach(this::handleOres);
    }

    private void handleOres(Block block) {
        if((block instanceof DropExperienceBlock) || (block instanceof RedStoneOreBlock) || (block instanceof RandomiumOreBlock)) {
            String oretype = Registries.BLOCK.getResourceKey(block).get().location().getPath();
            if (oretype.contains("cake")) {
                TstpContentMod.LOGGER.info("Block Name: " + oretype);
                ResourceLocation side = new ResourceLocation(TstpContentMod.MODID, "block/" + oretype);
                ResourceLocation top = new ResourceLocation(TstpContentMod.MODID, "block/" + oretype + "_top");
                simpleBlockWithItem(block, models().cubeBottomTop(oretype, side, top, top));
            } else {
                simpleBlockWithItem(block, cubeAll(block));
            }
        }
    }

    protected Iterable<Block> getKnownBlocks()
    {
        return TstpContentModBlocks.REGISTRY.getEntries().stream().map(RegistryObject::get).filter(block -> !(block instanceof LiquidBlock)).collect(Collectors.toList());
    }
}
 */