package com.ryorama.tstpcontent.mixins.ballistix;

import ballistix.common.blast.Blast;
import ballistix.common.blast.BlastNuclear;
import ballistix.common.blast.IHasCustomRenderer;
import ballistix.common.entity.EntityMissile;
import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;

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
                List<EntityMissile> missileList = this.world.getEntitiesOfClass(EntityMissile.class, new AABB(position, new BlockPos((int) (position.getX() + (16 * AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get())), (int) (position.getY() + (16 * AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get())), (int) (position.getZ() + (16 * AlexsCaves.COMMON_CONFIG.nukeExplosionSizeModifier.get())))));
                for (EntityMissile entityMissile : missileList) {
                    entityMissile.remove(Entity.RemovalReason.KILLED);
                }
                return true;
            }
        }
        return false;
    }
}
