package com.ryorama.tstpcontent.mixins;

import com.github.alexmodguy.alexscaves.server.entity.item.NuclearBombEntity;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.Utils;
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
                Utils.createNukeExplosionThreaded(level(), this);
            } else {
                Utils.createNukeExplosion(level(), this);
            }
        }
    }
}
