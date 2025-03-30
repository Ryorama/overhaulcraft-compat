package com.ryorama.tstpcontent.mixins.alexscaves;

import com.github.alexmodguy.alexscaves.server.entity.item.NuclearBombEntity;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.ExtraFunc;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(NuclearBombEntity.class)
public abstract class NuclearBombEntityMixin extends Entity {

    public NuclearBombEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    /**
     * @author Ryorama
     * @reason Add option for threaded explosion
     */
    @Overwrite(remap = false)
    private void explode() {
        if (TstpContentMod.CONFIG != null) {
            if (TstpContentMod.CONFIG.threadedNukeExplosion) {
                ExtraFunc.createNukeExplosionThreaded(level(), this);
            } else {
                ExtraFunc.createNukeExplosion(level(), this);
            }
        }
    }
}
