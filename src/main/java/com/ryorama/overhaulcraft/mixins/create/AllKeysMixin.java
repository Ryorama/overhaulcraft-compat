package com.ryorama.overhaulcraft.mixins.create;

import com.mojang.blaze3d.platform.InputConstants;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.simibubi.create.AllKeys;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@IfModLoaded("create")
@Mixin(AllKeys.class)
public class AllKeysMixin {
    /**
     * @author Ryorama
     * @reason Add following fix until merged: https://github.com/Creators-of-Create/Create/pull/10225
     */
    @Overwrite(remap = false)
    public static boolean isKeyDown(int key) {
        return (key != -1 && InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), key));
    }
}
