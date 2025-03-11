package com.ryorama.tstpcontent.datagen;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.datagen.client.BlockStates;
import com.ryorama.tstpcontent.datagen.server.BlockLootTables;
import com.ryorama.tstpcontent.datagen.server.CDIngredients;
import com.ryorama.tstpcontent.datagen.server.TstpBlockTags;
import com.ryorama.tstpcontent.datagen.server.TstpItemTags;
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
        if (event.includeServer()) {
            TstpBlockTags blockTags = new TstpBlockTags(packOutput, event.getLookupProvider(), fileHelper);

            generator.addProvider(true, blockTags);
            generator.addProvider(true, new TstpItemTags(packOutput, event.getLookupProvider(), blockTags.contentsGetter(), fileHelper));
            generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK))));
            generator.addProvider(true, new CDIngredients(event.getGenerator()));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new BlockStates(generator, fileHelper));
        }
    }
}
