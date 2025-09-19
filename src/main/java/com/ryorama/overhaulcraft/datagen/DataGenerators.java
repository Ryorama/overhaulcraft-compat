package com.ryorama.overhaulcraft.datagen;

import com.ryorama.overhaulcraft.TstpContentMod;
import com.ryorama.overhaulcraft.datagen.client.BlockStates;
import com.ryorama.overhaulcraft.datagen.server.BlockLootTables;
import com.ryorama.overhaulcraft.datagen.server.TstpBlockTags;
import com.ryorama.overhaulcraft.datagen.server.TstpItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = TstpContentMod.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void registerDataGenerators(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            TstpBlockTags blockTags = new TstpBlockTags(packOutput, event.getLookupProvider(), fileHelper);

            generator.addProvider(true, blockTags);
            generator.addProvider(true, new TstpItemTags(packOutput, event.getLookupProvider(), blockTags.contentsGetter(), fileHelper));
            generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new BlockStates(generator, fileHelper));
        }
    }
}