package com.ryorama.overhaulcraft.datagen;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.datagen.client.OverhaulCraftBlockStateProvider;
import com.ryorama.overhaulcraft.datagen.server.BlockLootTables;
import com.ryorama.overhaulcraft.datagen.server.OverhaulCraftBlockTags;
import com.ryorama.overhaulcraft.datagen.server.OverhaulCraftEngLangProvider;
import com.ryorama.overhaulcraft.datagen.server.OverhaulCraftItemTags;
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

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = OverhaulCraft.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void registerDataGenerators(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            OverhaulCraftBlockTags blockTags = new OverhaulCraftBlockTags(packOutput, event.getLookupProvider(), fileHelper);

            generator.addProvider(true, new OverhaulCraftEngLangProvider(packOutput));
            generator.addProvider(true, blockTags);
            generator.addProvider(true, new OverhaulCraftItemTags(packOutput, event.getLookupProvider(), blockTags.contentsGetter(), fileHelper));
            generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new OverhaulCraftBlockStateProvider(generator, fileHelper));
        }
    }
}