package com.ryorama.overhaulcraft.init;

import com.mojang.serialization.Codec;
import com.ryorama.overhaulcraft.OverhaulCraft;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class OverhaulCraftDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, OverhaulCraft.MODID);

    public static final Supplier<AttachmentType<Boolean>> TERRARIA_FUNC_UNLOCKED = REGISTRY.register("terraria_func_unlocked", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());
    public static final Supplier<AttachmentType<Boolean>> COBBLEMON_FUNC_UNLOCKED = REGISTRY.register("cobblemon_func_unlocked", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());
}
