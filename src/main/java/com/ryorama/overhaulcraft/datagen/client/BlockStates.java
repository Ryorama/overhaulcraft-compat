package com.ryorama.overhaulcraft.datagen.client;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftBlocks;
import com.ryorama.overhaulcraft.init.OverhaulCraftOreBlocks;
import net.mehvahdjukaar.randomium.common.RandomiumOreBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.stream.Collectors;

public class BlockStates extends BlockStateProvider {
    public BlockStates(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), OverhaulCraft.MODID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        OverhaulCraftOreBlocks.BLOCK_REGISTRY.getEntries().forEach(blockDeferredHolder -> {
            String id = blockDeferredHolder.get().builtInRegistryHolder().getKey().location().getPath();
            if (id.contains("cake")) {
                ResourceLocation side = ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "block/ores/" + id);
                ResourceLocation top = ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, "block/ores/" + id + "_top");

                simpleBlockWithItem(blockDeferredHolder.get(), models().cubeBottomTop(id, side, top, top));
            } else {
                simpleBlockWithItem(blockDeferredHolder.get(), cubeAll(blockDeferredHolder.get()));
            }
        });
    }
}