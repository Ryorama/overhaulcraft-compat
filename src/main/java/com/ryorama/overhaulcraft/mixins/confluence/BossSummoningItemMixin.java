package com.ryorama.overhaulcraft.mixins.confluence;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.mixed.IBossSummonSound;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.confluence.mod.common.init.ModSoundEvents;
import org.confluence.mod.common.item.common.BossSummoningItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BossSummoningItem.class)
public abstract class BossSummoningItemMixin extends Item implements IBossSummonSound {
    @Unique
    public SoundEvent summonSound = ModSoundEvents.ROAR.get();

    public BossSummoningItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/InteractionResultHolder;success(Ljava/lang/Object;)Lnet/minecraft/world/InteractionResultHolder;"), method = "use")
    public void use(Level level, Player player, InteractionHand usedHand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        OverhaulCraft.LOGGER.info("Summon Sound: " + summonSound);
        level.playSound(null, player.getOnPos(), summonSound, SoundSource.NEUTRAL);
    }

    @Override
    public SoundEvent oc$getSummonSound() {
        return summonSound;
    }

    @Override
    public void oc$setSummonSound(SoundEvent summonSound) {
        this.summonSound = summonSound;
    }
}
