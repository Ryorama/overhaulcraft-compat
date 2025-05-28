package com.ryorama.tstpcontent;

import com.ryorama.tstpcontent.utils.ExtraFunc;
import net.minecraftforge.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class TstpContentModMixinConfig implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.equals("com.ryorama.tstpcontent.mixins.nirvana.GenericItemFillingMixin")) {
            if (!doesModExist("nirvana")) {
                TstpContentMod.LOGGER.info("Mixin " + mixinClassName + " will NOT be loaded");
                return false;
            } else {
                TstpContentMod.LOGGER.info("Mixin " + mixinClassName + " will be loaded");
            }
        }
        if (mixinClassName.equals("com.ryorama.tstpcontent.mixins.WaterFluidMixin")) {
            if (!doesModExist("solar_apocalypse")) {
                TstpContentMod.LOGGER.info("Mixin " + mixinClassName + " will NOT be loaded");
                return false;
            } else {
                TstpContentMod.LOGGER.info("Mixin " + mixinClassName + " will be loaded");
            }
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }

    public boolean doesModExist(String modid) {
        if (LoadingModList.get().getModFileById(modid) != null) {
            TstpContentMod.LOGGER.debug("Mod with id of " + modid + " does exist");
            return true;
        }
        TstpContentMod.LOGGER.debug("Mod with id of " + modid + " does not exist");
        return false;
    }
}
