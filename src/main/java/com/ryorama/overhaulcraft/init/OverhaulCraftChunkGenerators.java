package com.ryorama.overhaulcraft.init;

import com.mojang.serialization.MapCodec;
import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.world.TerrariaChunkGenerator;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.chunk.ChunkGenerator;

import java.util.function.Supplier;

public class OverhaulCraftChunkGenerators {
    public static final DeferredRegister<MapCodec<? extends ChunkGenerator>> REGISTRY = DeferredRegister.create(OverhaulCraft.MODID, Registries.CHUNK_GENERATOR);

    public static final RegistrySupplier<MapCodec<? extends ChunkGenerator>> TERRARIA_CHUNK_GENERATOR = registerChunkGenerator("terraria", () -> TerrariaChunkGenerator.CODEC);

    static RegistrySupplier<MapCodec<? extends ChunkGenerator>> registerChunkGenerator(String name, Supplier<MapCodec<? extends ChunkGenerator>> generator) {
        return REGISTRY.register(ResourceLocation.fromNamespaceAndPath(OverhaulCraft.MODID, name), generator);
    }
}
