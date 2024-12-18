package com.ryorama.tstpcontent.mixins.hamster;

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.utils.Utils;
import com.starfish_studios.hamsters.HamstersConfig;
import com.starfish_studios.hamsters.entities.Hamster;
import com.starfish_studios.hamsters.entities.util.SleepingAnimal;
import com.starfish_studios.hamsters.registry.HamstersTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.EntityGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import software.bernie.geckolib.animatable.GeoEntity;

@Mixin(Hamster.class)
public abstract class HamsterMixin extends TamableAnimal implements GeoEntity, SleepingAnimal {

    protected HamsterMixin(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    /**
     * @author Ryorama
     * @reason Remove unnecessary sfx when hamster explodes
     */
    @Overwrite
    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Item item = itemStack.getItem();
        if (this.level().isClientSide()) {
            boolean canInteract = this.isOwnedBy(player) || this.isTame() || this.isFood(itemStack) && !this.isTame();
            return canInteract ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else if (player.getCooldowns().isOnCooldown(itemStack.getItem())) {
            return InteractionResult.FAIL;
        } else {
            if (this.isTame()) {
                if (itemStack.is(HamstersTags.HAMSTER_BREEDING_FOOD) && this.getAge() == 0 && this.canFallInLove()) {
                    this.feedHamster(itemStack, player, true);
                    this.setInLove(player);
                    return InteractionResult.SUCCESS;
                }

                if (this.isFood(itemStack)) {
                    this.feedHamster(itemStack, player, !HamstersConfig.hamstersBurst || this.getCheekLevel() < 3);
                    if (this.getAge() < 0) {
                        this.addAgeToHamster();
                    } else if (this.getCheekLevel() >= 3 && HamstersConfig.hamstersBurst) {
                        this.setHealth(0.0F);
                        if (HamstersConfig.hamsterBurstStyle == HamstersConfig.BurstStyleEnum.CONFETTI) {
                            FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(this.level(), this, this.getX(), this.getEyeY(), this.getZ(), Hamster.getFirework());
                            fireworkRocketEntity.setSilent(true);
                            fireworkRocketEntity.setInvisible(true);
                            this.level().addFreshEntity(fireworkRocketEntity);
                            fireworkRocketEntity.setDeltaMovement(0.0, 0.0, 0.0);
                        } else if (HamstersConfig.hamsterBurstStyle == HamstersConfig.BurstStyleEnum.EXPLOSION) {
                            Level var10 = this.level();
                            if (var10 instanceof ServerLevel) {
                                ServerLevel serverLevel = (ServerLevel) var10;
                                serverLevel.sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 5, 0.0, 0.0, 0.0, 0.0);
                            }

                            System.out.println("Hamster mouth" + interactionHand);
                            if (this.getItemInHand(interactionHand) == ACBlockRegistry.URANIUM_ROD.get().asItem().getDefaultInstance()) {
                                System.out.println("Hamster Nuke");
                                //Utils.createNukeExplosionWithSize(this.level(), this, 0.5f);
                                Utils.createNukeExplosion(this.level(), this);
                            } else {
                                this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.MOB);
                            }
                        }

                        this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY(), this.getZ(), 3));

                        for (int seedItems = 0; seedItems < 4; ++seedItems) {
                            ItemEntity seedsItem = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), new ItemStack(Items.WHEAT_SEEDS));
                            seedsItem.setDeltaMovement(this.getRandom().nextGaussian() * 0.1, this.getRandom().nextGaussian() * 0.2 + 0.2, this.getRandom().nextGaussian() * 0.1);
                            this.level().addFreshEntity(seedsItem);
                        }
                    } else {
                        if (this.getCheekLevel() >= 3) {
                            return InteractionResult.FAIL;
                        }

                        this.setCheekLevel(this.getCheekLevel() + 1);
                        player.getCooldowns().addCooldown(itemStack.getItem(), 20);
                    }

                    return InteractionResult.SUCCESS;
                }

                if (this.isOwnedBy(player)) {
                    if (player.isShiftKeyDown() && itemStack.isEmpty()) {
                        this.catchHamster(player);
                    }

                    if (item instanceof DyeItem) {
                        DyeItem dyeItem = (DyeItem) item;
                        DyeColor dyeColor = dyeItem.getDyeColor();
                        if (dyeColor != this.getCollarColor()) {
                            this.setCollarColor(dyeColor);
                            this.playSound(SoundEvents.DYE_USE);
                            this.gameEvent(GameEvent.ENTITY_INTERACT, player);
                            if (!player.getAbilities().instabuild) {
                                itemStack.shrink(1);
                            }

                            return InteractionResult.SUCCESS;
                        }
                    } else if (this.getSquishedTicks() <= 0) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.getNavigation().stop();
                        return InteractionResult.SUCCESS;
                    }
                }
            } else if (this.isFood(itemStack)) {
                this.feedHamster(itemStack, player, false);
                if (this.getRandom().nextInt(3) == 0) {
                    this.tame(player);
                    this.getNavigation().stop();
                    this.setOrderedToSit(true);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }

                return InteractionResult.SUCCESS;
            }

            return super.mobInteract(player, interactionHand);
        }
    }

    @Shadow(remap = false)
    protected abstract void feedHamster(ItemStack itemStack, Player player, boolean shouldHeal);

    @Shadow(remap = false)
    protected abstract void addAgeToHamster();

    @Shadow(remap = false)
    protected abstract int getSquishedTicks();

    @Shadow(remap = false)
    public abstract int getCheekLevel();

    @Shadow(remap = false)
    protected abstract void setCheekLevel(int cheekLevel);

    @Shadow(remap = false)
    public abstract DyeColor getCollarColor();

    @Shadow(remap = false)
    protected abstract void setCollarColor(DyeColor dyeColor);

    @Shadow(remap = false)
    protected abstract void catchHamster(Player player);
}