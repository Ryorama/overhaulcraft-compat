/*
package com.ryorama.tstpcontent.mixins.ftbquests;

import com.llamalad7.mixinextras.sugar.Local;
import dev.ftb.mods.ftblibrary.config.ConfigGroup;
import dev.ftb.mods.ftblibrary.config.Tristate;
import dev.ftb.mods.ftbquests.quest.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Quest.class)
public abstract class QuestMixin extends QuestObject implements Movable {

    @Shadow private Chapter chapter;
    private Tristate hideUnlessModInstalled;

    public QuestMixin(long id, Chapter chapter) {
        super(id);

        hideUnlessModInstalled = Tristate.DEFAULT;
    }

    @Inject(at = @At(value = "INVOKE", target = "Ldev/ftb/mods/ftbquests/quest/QuestObject;writeData(Lnet/minecraft/nbt/CompoundTag;)V", shift = At.Shift.AFTER), method = "writeData")
    public void writeData(CompoundTag nbt, CallbackInfo ci) {
        hideUnlessModInstalled.write(nbt, "hide_unless_mod_installed");
    }

    @Inject(at = @At("TAIL"), method = "readData")
    public void readData(CompoundTag nbt, CallbackInfo ci) {
        hideUnlessModInstalled = Tristate.read(nbt, "hide_unless_mod_installed");
    }

    @Inject(at = @At("HEAD"), method = "writeNetData")
    public void writeNetData(FriendlyByteBuf buffer, CallbackInfo ci) {
        hideUnlessModInstalled.write(buffer);
    }

    @Inject(at = @At("HEAD"), method = "readNetData")
    public void readNetData(FriendlyByteBuf buffer, CallbackInfo ci) {
        hideUnlessModInstalled = Tristate.read(buffer);
    }

    @Inject(at = @At("TAIL"), method = "fillConfigGroup")
    public void fillConfigGroup(ConfigGroup config, CallbackInfo ci, @Local ConfigGroup visibility) {
        visibility.addTristate("hide_until_deps_complete", hideUnlessModInstalled, v -> hideUnlessModInstalled = v);
    }

    @Inject(at = @At("HEAD"), method = "isVisible")
    public boolean isVisible(TeamData data) {
        if (hideUnlessModInstalled.get(((ChapterAccessor)(Object)chapter).hideUnlessModInstalled())) {
            return false;
        }
        return isVisible(data);
    }
}
*/