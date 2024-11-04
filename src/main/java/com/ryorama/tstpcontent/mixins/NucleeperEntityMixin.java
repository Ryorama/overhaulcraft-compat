package com.ryorama.tstpcontent.mixins;

import com.github.alexmodguy.alexscaves.server.entity.living.NucleeperEntity;
import com.github.alexmodguy.alexscaves.server.entity.util.ActivatesSirens;
import mekanism.api.Coord4D;
import mekanism.api.radiation.IRadiationManager;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NucleeperEntity.class)
public abstract class NucleeperEntityMixin extends Monster implements ActivatesSirens, PowerableMob {

    protected NucleeperEntityMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("TAIL"), method = "explode", remap = false)
    private void explode(CallbackInfo ci) {
        IRadiationManager radiationManager = IRadiationManager.INSTANCE;
        if (radiationManager.isRadiationEnabled()) {
            radiationManager.radiate(new Coord4D(new Vec3i((int) position().x, (int) position().y, (int) position().z), level()), 10);
        }
    }
}
