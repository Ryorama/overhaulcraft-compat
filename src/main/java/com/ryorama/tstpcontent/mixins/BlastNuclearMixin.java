package com.ryorama.tstpcontent.mixins;

import ballistix.common.blast.Blast;
import ballistix.common.blast.BlastNuclear;
import ballistix.common.blast.IHasCustomRenderer;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlastNuclear.class)
public abstract class BlastNuclearMixin extends Blast implements IHasCustomRenderer {

    protected BlastNuclearMixin(Level world, BlockPos position) {
        super(world, position);
    }

    /**
     * @author Ryorama
     * @reason Modify to use alex's caves explosion
     */
    @Overwrite(remap = false)
    public void doPreExplode() {}

    /**
     * @return
     * @author Ryorama
     * @reason Modify to use alex's caves explosion
     */
    @Overwrite(remap = false)
    public boolean doExplode(int callCount) {
        if (TstpContentMod.CONFIG != null) {
            if (this.world != null) {
                if (TstpContentMod.CONFIG.threadedNukeExplosion) {
                    Utils.createNukeExplosionWithVec3(this.world, new Vec3(this.position.getX(), this.position.getY(), this.position.getZ()));
                } else {
                    Utils.createNukeExplosionWithVec3(this.world, new Vec3(this.position.getX(), this.position.getY(), this.position.getZ()));
                }
                return true;
            }
        }
        return false;
    }
}
