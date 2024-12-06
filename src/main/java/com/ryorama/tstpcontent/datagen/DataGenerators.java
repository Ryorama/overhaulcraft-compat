package com.ryorama.tstpcontent.datagen;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.datagen.client.BlockStates;
import com.ryorama.tstpcontent.datagen.server.BlockLootTables;
import com.ryorama.tstpcontent.datagen.server.BlockTags;
import com.ryorama.tstpcontent.datagen.server.ItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TstpContentMod.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void registerDataGenerators(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        TstpContentMod.LOGGER.info("Running Datagen Tstp");
        if (event.includeServer()) {
            BlockTags blockTags = new BlockTags(packOutput, event.getLookupProvider(), fileHelper);

            generator.addProvider(true, blockTags);
            generator.addProvider(true, new ItemTags(packOutput, event.getLookupProvider(), blockTags.contentsGetter(), fileHelper));
            generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK))));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new BlockStates(generator, fileHelper));
        }
    }
}
