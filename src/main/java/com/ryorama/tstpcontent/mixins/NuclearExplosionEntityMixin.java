package com.ryorama.tstpcontent.mixins;

import com.github.alexmodguy.alexscaves.client.particle.ACParticleRegistry;
import com.github.alexmodguy.alexscaves.server.entity.item.NuclearExplosionEntity;
import com.github.alexmodguy.alexscaves.server.entity.living.RaycatEntity;
import com.github.alexmodguy.alexscaves.server.entity.living.TremorzillaEntity;
import com.github.alexmodguy.alexscaves.server.misc.ACDamageTypes;
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry;
import com.github.alexmodguy.alexscaves.server.potion.ACEffectRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Iterator;
import java.util.Stack;

@Mixin(NuclearExplosionEntity.class)
public abstract class NuclearExplosionEntityMixin extends Entity{

    @Shadow(remap = false)
    private boolean spawnedParticle;
    @Shadow(remap = false)
    private Stack<BlockPos> destroyingChunks;
    @Shadow(remap = false)
    private boolean loadingChunks;

    public NuclearExplosionEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    /**
     * @author Ryorama
     * @reason Adjust damage/fling values. Make nuke a bit more survivable but still extremely hard
     */
    @Overwrite(remap = false)
    public void tick() {
        super.tick();
        int chunksAffected = this.getChunksAffected();
        int radius = chunksAffected * 15;
        int tickChunkCount;
        if (!this.spawnedParticle) {
            this.spawnedParticle = true;

            for(tickChunkCount = (int)Math.ceil(this.getY()); tickChunkCount > this.level().getMinBuildHeight() && (double)tickChunkCount > this.getY() - (double)((float)radius / 2.0F) && this.isDestroyable(this.level().getBlockState(BlockPos.containing(this.getX(), tickChunkCount, this.getZ()))); --tickChunkCount) {
            }

            this.level().addAlwaysVisibleParticle(ACParticleRegistry.MUSHROOM_CLOUD.get(), true, this.getX(), (tickChunkCount + 2), this.getZ(), this.getSize(), this.isIntentionalGameDesign() ? 1.0 : 0.0, 0.0);
        }

        if (this.tickCount > 40 && this.destroyingChunks.isEmpty()) {
            this.remove(Entity.RemovalReason.DISCARDED);
        } else {
            if (!this.level().isClientSide && !this.isNoGriefing()) {
                if (!this.loadingChunks && !this.isRemoved()) {
                    this.loadingChunks = true;
                    this.loadChunksAround(true);
                }

                int chunks;
                if (!this.destroyingChunks.isEmpty()) {
                    tickChunkCount = Math.min(this.destroyingChunks.size(), 3);

                    for(chunks = 0; chunks < tickChunkCount; ++chunks) {
                        this.removeChunk(radius);
                    }
                } else {
                    BlockPos center = this.blockPosition();
                    chunks = chunksAffected;
                    int i = -chunks;

                    while(true) {
                        if (i > chunks) {
                            this.destroyingChunks.sort((blockPos1, blockPos2) -> {
                                return Double.compare(blockPos2.distManhattan(this.blockPosition()), blockPos1.distManhattan(this.blockPosition()));
                            });
                            break;
                        }

                        for(int j = -chunks; j <= chunks; ++j) {
                            for(int k = -chunks; k <= chunks; ++k) {
                                this.destroyingChunks.push(center.offset(i * 16, j * 16, k * 16));
                            }
                        }

                        ++i;
                    }
                }
            }

            AABB killBox = this.getBoundingBox().inflate((double)((float)radius + (float)radius * 0.5F), (double)radius * 0.6, (double)((float)radius + (float)radius * 0.5F));
            float flingStrength = this.getSize() * 0.33F;
            float maximumDistance = (float)radius + (float)radius * 0.5F + 1.0F;
            Iterator var16 = this.level().getEntitiesOfClass(LivingEntity.class, killBox).iterator();

            while(var16.hasNext()) {
                LivingEntity entity = (LivingEntity)var16.next();
                float dist = entity.distanceTo(this);
                float damage = this.calculateDamage(dist, maximumDistance);
                Vec3 vec3 = entity.position().subtract(this.position()).add(0.0, 0.3, 0.0).normalize();
                float playerFling = entity instanceof Player ? 0.5F * flingStrength : flingStrength;
                if (damage > 0.0F) {
                    if (entity instanceof RaycatEntity) {
                        damage = 0.0F;
                    } else if (entity.getType().is(ACTagRegistry.RESISTS_RADIATION)) {
                        damage *= 0.25F;
                        playerFling *= 0.1F;
                        if (entity instanceof TremorzillaEntity) {
                            playerFling = 0.0F;
                            damage = 0.0F;
                        }
                    }

                    if (damage > 0.0F) {
                        entity.hurt(this.isIntentionalGameDesign() ? ACDamageTypes.causeIntentionalGameDesign(this.level().registryAccess()) : ACDamageTypes.causeNukeDamage(this.level().registryAccess()), damage);
                    }
                }

                entity.setDeltaMovement(vec3.scale(damage * 0.1F * playerFling));
                if (!this.isIntentionalGameDesign()) {
                    entity.addEffect(new MobEffectInstance(ACEffectRegistry.IRRADIATED.get(), 48000, this.getSize() <= 1.5F ? 1 : 2, false, false, true));
                }
            }
        }
    }

    @Shadow(remap = false)
    public abstract int getChunksAffected();

    @Shadow(remap = false)
    public abstract boolean isDestroyable(BlockState state);

    @Shadow(remap = false)
    public abstract boolean isNoGriefing();

    @Shadow(remap = false)
    public abstract boolean isIntentionalGameDesign();

    @Shadow(remap = false)
    public abstract float getSize();

    @Shadow(remap = false)
    public abstract float calculateDamage(float dist, float max);

    @Shadow(remap = false)
    private void loadChunksAround(boolean load) {}

    @Shadow(remap = false)
    private void removeChunk(int radius) {}
}
