/*
package com.ryorama.tstpcontent.entities;

import com.ryorama.tstpcontent.init.TstpContentModItems;
import com.ryorama.tstpcontent.utils.IRadiationImmune;
import com.ryorama.tstpcontent.utils.TstpTags;
import com.starfish_studios.hamsters.HamstersConfig;
import com.starfish_studios.hamsters.blocks.HamsterWheelBlock;
import com.starfish_studios.hamsters.entities.Hamster;
import com.starfish_studios.hamsters.entities.util.SleepGoal;
import com.starfish_studios.hamsters.registry.HamstersSoundEvents;
import com.starfish_studios.hamsters.registry.HamstersTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.starfish_studios.hamsters.HamstersConfig.hamsterBurstStyle;
import static com.starfish_studios.hamsters.HamstersConfig.hamstersBurst;

public class RadsterEntity extends Hamster implements IRadiationImmune {

    public RadsterEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, (livingEntity -> {
            if (this.isTame()) {
                return false;
            }
            return true;
        })));
        this.goalSelector.addGoal(3, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0F, false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new HamsterTemptGoal(this, 1.0D, Ingredient.of(Items.EMERALD), true));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new HamsterGoToWheelGoal(this, 1.2D, 8));
        this.goalSelector.addGoal(7, new HamsterGoToBottleGoal(this, 1.2D, 8));
        this.goalSelector.addGoal(7, new HamsterGoToBowlGoal(this, 1.2D, 8));
        this.goalSelector.addGoal(8, new HamsterDismountGoal(this));
        this.goalSelector.addGoal(9, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new SleepGoal<>(this));
        this.goalSelector.addGoal(11, new LookAtPlayerGoal(this, Player.class, 6.0F) {
            @Override
            public void tick() {
                if (RadsterEntity.this.canUseMovementGoals()) super.tick();
            }
        });
        this.goalSelector.addGoal(12, new HamsterLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0F).add(Attributes.MOVEMENT_SPEED, 0.30F) .add(Attributes.ATTACK_DAMAGE, 2.5F);
    }

    @Override
    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Item item = itemStack.getItem();
        if (this.level().isClientSide()) {
            boolean canInteract = this.isOwnedBy(player) || this.isTame() || (this.isFood(itemStack) && !this.isTame());
            return canInteract ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (player.getCooldowns().isOnCooldown(itemStack.getItem()))
                return InteractionResult.FAIL;
            if (this.isTame()) {
                if (!player.isShiftKeyDown() && itemStack.isEmpty()) {
                    BlockPos wheelPos = this.findNearbyHamsterWheel();
                    if (wheelPos != null) {
                        HamsterWheelBlock.sitDown(this.level(), wheelPos, this);
                        return InteractionResult.SUCCESS;
                    }
                }
                if (itemStack.is(TstpContentModItems.RAD_SEEDS.get()) && this.getAge() == 0 && this.canFallInLove()) {
                    this.feedHamster(itemStack, player, true);
                    this.setInLove(player);
                    return InteractionResult.SUCCESS;
                } else if (this.isFood(itemStack)) {
                    this.feedHamster(itemStack, player, !hamstersBurst || this.getCheekLevel() < 3);
                    if (this.getAge() < 0) {
                        this.addAgeToHamster();
                    } else {
                        if (this.getCheekLevel() >= 3 && hamstersBurst) {
                            this.setHealth(0);
                            if (hamsterBurstStyle == HamstersConfig.BurstStyleEnum.CONFETTI) {
                                FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(this.level(), this, this.getX(), this.getEyeY(), this.getZ(), new ItemStack(Items.FIREWORK_ROCKET));
                                fireworkRocketEntity.setSilent(true);
                                fireworkRocketEntity.setInvisible(true);
                                this.level().addFreshEntity(fireworkRocketEntity);
                                fireworkRocketEntity.setDeltaMovement(0.0D, 0.0D, 0.0D);
                            } else if (hamsterBurstStyle == HamstersConfig.BurstStyleEnum.EXPLOSION) {
                                if (this.level() instanceof ServerLevel serverLevel)
                                    serverLevel.sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 5, 0.0D, 0.0D, 0.0D, 0.0D);
                                this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.MOB);
                            }
                            this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY(), this.getZ(), 3));
                            for (int seedItems = 0; seedItems < 4; seedItems++) {
                                ItemEntity seedsItem = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), new ItemStack(Items.WHEAT_SEEDS));
                                seedsItem.setDeltaMovement(this.getRandom().nextGaussian() * 0.1D,
                                        this.getRandom().nextGaussian() * 0.2D + 0.2D,
                                        this.getRandom().nextGaussian() * 0.1D);
                                this.level().addFreshEntity(seedsItem);
                            }
                        } else {
                            if (this.getCheekLevel() < 3) {
                                this.setCheekLevel(this.getCheekLevel() + 1);
                                player.getCooldowns().addCooldown(itemStack.getItem(), 20);
                            } else {
                                return InteractionResult.FAIL;
                            }
                        }
                    }
                    return InteractionResult.SUCCESS;
                } else if (this.isOwnedBy(player)) {
                    if (player.isShiftKeyDown() && itemStack.isEmpty()) {
                        this.catchHamster(player);
                        return InteractionResult.SUCCESS;
                    }
                    if (item instanceof DyeItem dyeItem) {
                        DyeColor dyeColor = dyeItem.getDyeColor();
                        if (dyeColor != this.getCollarColor()) {
                            this.setCollarColor(dyeColor);
                            this.playSound(SoundEvents.DYE_USE);
                            this.gameEvent(GameEvent.ENTITY_INTERACT, player);
                            if (!player.getAbilities().instabuild)
                                itemStack.shrink(1);
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

    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(TstpContentModItems.RAD_SEEDS.get()) && this.canUseMovementGoals();
    }

    @Override
    public void catchHamster(Player player) {
        //ToDo
    }
}
*/