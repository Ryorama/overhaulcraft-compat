package com.ryorama.tstpcontent.mixins.nukeshell;

import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.ExtraFunc;
import com.snackpirate.nukemod3.NukeShellProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import rbasamoyai.createbigcannons.munitions.big_cannon.FuzedBigCannonProjectile;

@Mixin(NukeShellProjectile.class)
public abstract class NukeShellProjectileMixin extends FuzedBigCannonProjectile {


    protected NukeShellProjectileMixin(EntityType<? extends FuzedBigCannonProjectile> type, Level level) {
        super(type, level);
    }

    /**
     * @author Ryorama
     * @reason Add option for threaded explosion
    */
    @Overwrite(remap = false)
    private void nukeKaboom() {
        if (TstpContentMod.CONFIG != null) {
            if (TstpContentMod.CONFIG.threadedNukeExplosion) {
                ExtraFunc.createNukeExplosionThreaded(level(), this);
            } else {
                ExtraFunc.createNukeExplosion(level(), this);
            }
        }
    }
}
