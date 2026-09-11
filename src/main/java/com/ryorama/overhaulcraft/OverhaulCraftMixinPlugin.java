package com.ryorama.overhaulcraft;

import com.moulberry.mixinconstraints.MixinConstraints;
import com.moulberry.mixinconstraints.mixin.MixinConstraintsBootstrap;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class OverhaulCraftMixinPlugin implements IMixinConfigPlugin {
    private String mixinPackage;

    @Override
    public void onLoad(String mixinPackage) {
        this.mixinPackage = mixinPackage;
        MixinConstraintsBootstrap.init(mixinPackage);
    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (targetClassName.equals("net.minecraft.world.level.biome.BiomeSource")) {
            OverhaulCraft.LOGGER.info(mixinClassName + " Mixing into BiomeSource");
        }
        if (targetClassName.equals("net.minecraft.world.level.chunk.ChunkGenerator")) {
            OverhaulCraft.LOGGER.info(mixinClassName + " Mixing into ChunkGenerator");
        }
        if (targetClassName.equals("net.minecraft.server.level.ChunkMap")) {
            OverhaulCraft.LOGGER.info(mixinClassName + " Mixing into ChunkMap");
        }
        if (targetClassName.equals("net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator")) {
            OverhaulCraft.LOGGER.info(mixinClassName + " Mixing into NoiseBasedChunkGenerator");
        }
        if (targetClassName.equals("net.minecraft.world.level.levelgen.structure.StructureSet")) {
            OverhaulCraft.LOGGER.info(mixinClassName + " Mixing into StructureSet");
        }
        if (targetClassName.equals("net.minecraft.world.level.levelgen.SurfaceSystem")) {
            OverhaulCraft.LOGGER.info(mixinClassName + " Mixing into SurfaceSystem");
        }

        if (this.mixinPackage != null && !mixinClassName.startsWith(this.mixinPackage)) {
            return true;
        }
        return MixinConstraints.shouldApplyMixin(mixinClassName);
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return List.of();
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
