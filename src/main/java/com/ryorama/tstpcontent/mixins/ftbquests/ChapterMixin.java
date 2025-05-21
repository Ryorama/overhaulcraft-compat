/*
package com.ryorama.tstpcontent.mixins.ftbquests;

import com.llamalad7.mixinextras.sugar.Local;
import dev.ftb.mods.ftblibrary.config.ConfigGroup;
import dev.ftb.mods.ftblibrary.math.Bits;
import dev.ftb.mods.ftbquests.quest.Chapter;
import dev.ftb.mods.ftbquests.quest.QuestObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chapter.class)
public abstract class ChapterMixin extends QuestObject implements ChapterAccessor {
    private boolean hideUnlessModInstalled;

    public ChapterMixin(long id) {
        super(id);
        hideUnlessModInstalled = false;
    }

    @Override
    public boolean hideUnlessModInstalled() {
        return this.hideUnlessModInstalled;
    }

    @Inject(at = @At(value = "INVOKE", target = "Ldev/ftb/mods/ftbquests/quest/QuestObject;writeData(Lnet/minecraft/nbt/CompoundTag;)V", shift = At.Shift.AFTER), method = "writeData")
    public void writeData(CompoundTag nbt, CallbackInfo ci) {
        if (this.hideUnlessModInstalled) {
            nbt.putBoolean("hide_unless_mod_installed", true);
        }
    }

    @Inject(at = @At("TAIL"), method = "readData")
    public void readData(CompoundTag nbt, CallbackInfo ci) {
        this.hideUnlessModInstalled = nbt.getBoolean("hide_unless_mod_installed");
    }

    @Inject(at = @At("HEAD"), method = "writeNetData")
    public void writeNetData(FriendlyByteBuf buffer, CallbackInfo ci, @Local int flags) {
        flags = Bits.setFlag(flags, 4, this.hideUnlessModInstalled);
    }

    @Inject(at = @At("HEAD"), method = "readNetData")
    public void readNetData(FriendlyByteBuf buffer, CallbackInfo ci, @Local int flags) {
        this.hideUnlessModInstalled = Bits.getFlag(flags, 4);
    }

    @Inject(at = @At("TAIL"), method = "fillConfigGroup")
    public void fillConfigGroup(ConfigGroup config, CallbackInfo ci, @Local ConfigGroup visibility) {
        visibility.addBool("hide_unless_mod_installed", this.hideUnlessModInstalled, (v) -> {
            this.hideUnlessModInstalled = v;
        }, false);
    }
}
*/