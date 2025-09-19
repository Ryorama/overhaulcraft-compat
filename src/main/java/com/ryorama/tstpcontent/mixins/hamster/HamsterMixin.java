package com.ryorama.tstpcontent.mixins.hamster;

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import com.ryorama.tstpcontent.TstpContentMod;
import com.ryorama.tstpcontent.entities.RadsterEntity;
import com.ryorama.tstpcontent.init.TstpContentEntityTypes;
import com.ryorama.tstpcontent.utils.ExtraFunc;
import com.ryorama.tstpcontent.utils.TstpTags;
import com.starfish_studios.hamsters.HamstersConfig;
import com.starfish_studios.hamsters.entities.Hamster;
import com.starfish_studios.hamsters.entities.util.SleepingAnimal;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.EntityGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.GeoEntity;

import java.util.Iterator;

import static com.starfish_studios.hamsters.entities.Hamster.getNearbyAvoidedEntities;

@IfModLoaded("hamsters")
@Mixin(Hamster.class)
public abstract class HamsterMixin extends TamableAnimal implements GeoEntity, SleepingAnimal {

    @Shadow
    public abstract boolean isFood(ItemStack itemStack);

    protected HamsterMixin(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    /**
     * @author Ryorama
     * @reason Adjustments
     * */
    public void aiStep() {
        super.aiStep();
        if (this.level() != null) {
            if (HamstersConfig.hamstersSquish) {
                Iterator var1 = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox()).iterator();

                while (var1.hasNext()) {
                    Player player = (Player) var1.next();
                    if (!player.onGround() && player.getDeltaMovement().y() < 0.0) {
                        if (HamstersConfig.jumpHurtsHamsters && EnchantmentHelper.getEnchantmentLevel(Enchantments.FALL_PROTECTION, player) == 0 && this.getSquishedTicks() <= 0 && !this.hasCustomName()) {
                            this.hurt(this.damageSources().generic(), 1.0F);
                        }

                        this.squishHamster();
                    }
                }
            }

            if (this.getSquishedTicks() > 0) {
                this.setSquishedTicks(this.getSquishedTicks() - 1);
                this.setDeltaMovement(0.0, 0.0, 0.0);
                if (this.getSquishedTicks() == 10) {
                    this.playSound(HamstersSoundEvents.HAMSTER_UNSQUISH);
                }
            }

            if (getNearbyAvoidedEntities(this).isEmpty()) {
                if (this.getSleepCooldownTicks() > 0) {
                    this.setSleepingCooldownTicks(this.getSleepCooldownTicks() - 1);
                }
            } else if (this.isSleeping()) {
                this.setSleeping(false);
            } else {
                this.setDefaultSleepingCooldown();
            }

            if (this.isInWheel() && this.getCheekLevel() > 0 && this.tickCount % 100 == 0) {
                this.setCheekLevel(this.getCheekLevel() - 1);
            }

            if (this.getDrinkingCooldownTicks() > 0) {
                this.setDrinkingCooldownTicks(this.getDrinkingCooldownTicks() - 1);
            }

            if (this.getMountingCooldownTicks() > 0) {
                this.setMountingCooldownTicks(this.getMountingCooldownTicks() - 1);
            }

            if (this.getDismountingCooldownTicks() > 0) {
                this.setDismountingCooldownTicks(this.getDismountingCooldownTicks() - 1);
            }

            if (this.getBirthCountdown() > 0) {
                this.setBirthCountdown(this.getBirthCountdown() - 1);
            }

            if (HamstersConfig.hamstersBurst) {
                if (this.level().isClientSide()) {
                    if (this.getCheekLevel() == 2 && this.tickCount % 10 == 0) {
                        this.level().addParticle(ParticleTypes.SPLASH, this.getX(), this.getY(1.2), this.getZ(), 0.0, 0.2, 0.0);
                        this.playSound(HamstersSoundEvents.HAMSTER_BEG);
                    } else if (this.getCheekLevel() == TstpContentMod.CONFIG.maxHamsterCheekSize && this.tickCount % 5 == 0) {
                        this.level().addParticle(ParticleTypes.SPLASH, this.getX(), this.getY(1.2), this.getZ(), 0.0, 0.2, 0.0);
                    }
                } else if (this.isAlive() && this.getCheekLevel() >= 2 && this.tickCount % (80 - this.getCheekLevel() * 10) == 0) {
                    this.playSound(HamstersSoundEvents.HAMSTER_BEG);
                }
            }
        }
    }

    /**
     * @author Ryorama
     * @reason Making multiple adjustments
     */
    @Overwrite
    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Item item = itemStack.getItem();
        if (this.level() != null) {
            if (this.level().isClientSide()) {
                boolean canInteract = this.isOwnedBy(player) || this.isTame() || this.isFood(itemStack) && !this.isTame();
                return canInteract ? InteractionResult.CONSUME : InteractionResult.PASS;
            } else if (player.getCooldowns().isOnCooldown(itemStack.getItem())) {
                return InteractionResult.FAIL;
            } else {
                if (this.isTame()) {
                    if (!(itemStack.equals(ItemStack.EMPTY))) {
                        if (itemStack.is(HamstersTags.HAMSTER_FOOD) && this.getAge() == 0 && this.canFallInLove()) {
                            this.feedHamster(itemStack, player, true);
                            this.setInLove(player);
                            return InteractionResult.SUCCESS;
                        }

                        if (this.isFood(itemStack)) {
                            this.feedHamster(itemStack, player, !HamstersConfig.hamstersBurst || this.getCheekLevel() < TstpContentMod.CONFIG.maxHamsterCheekSize);
                        } else {
                            this.feedHamsterNonFood(itemStack, player, !HamstersConfig.hamstersBurst || this.getCheekLevel() < TstpContentMod.CONFIG.maxHamsterCheekSize);
                        }
                        if (this.getAge() < 0) {
                            this.addAgeToHamster();
                        } else if (this.getCheekLevel() >= TstpContentMod.CONFIG.maxHamsterCheekSize && HamstersConfig.hamstersBurst) {
                            this.setHealth(0.0F);
                            if (HamstersConfig.hamsterBurstStyle == HamstersConfig.BurstStyleEnum.CONFETTI) {
                                FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(this.level(), this, this.getX(), this.getEyeY(), this.getZ(), new ItemStack(Items.FIREWORK_ROCKET));
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
                                TstpContentMod.LOGGER.info("Item in hamster main hand: " + this.getMainHandItem());
                                TstpContentMod.LOGGER.info("Item rod is: " + ACBlockRegistry.URANIUM_ROD.get().asItem().getDefaultInstance());

                                if (this.getItemInHand(InteractionHand.MAIN_HAND).is(TstpTags.FUEL_RODS)) {
                                    TstpContentMod.LOGGER.info("Hamster Nuke");
                                    int uraniumRodCount = this.getItemInHand(InteractionHand.MAIN_HAND).getCount();
                                    BlockPos oldHamsterPos = this.getOnPos();
                                    ExtraFunc.createNukeExplosionWithSize(this.level(), this, 0.5f * uraniumRodCount);
                                    if (random.nextInt(0, 50) == 0) {
                                        RadsterEntity radsterEntity = new RadsterEntity(TstpContentEntityTypes.RADSTER.get(), this.level());
                                        this.level().addFreshEntity(radsterEntity);
                                        radsterEntity.setPos(oldHamsterPos.getX(), oldHamsterPos.getY(), oldHamsterPos.getZ());
                                    }
                                    this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.MOB);
                                }
                            }
                            this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY(), this.getZ(), 3));

                            for (int seedItems = 0; seedItems < 4; ++seedItems) {
                                ItemEntity seedsItem = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), new ItemStack(Items.WHEAT_SEEDS));
                                seedsItem.setDeltaMovement(this.getRandom().nextGaussian() * 0.1, this.getRandom().nextGaussian() * 0.2 + 0.2, this.getRandom().nextGaussian() * 0.1);
                                this.level().addFreshEntity(seedsItem);
                            }
                            return InteractionResult.SUCCESS;
                        } else {
                            if (this.getCheekLevel() >= TstpContentMod.CONFIG.maxHamsterCheekSize) {
                                return InteractionResult.FAIL;
                            }

                            this.setCheekLevel(this.getCheekLevel() + 1);
                            player.getCooldowns().addCooldown(itemStack.getItem(), 20);

                            return InteractionResult.SUCCESS;
                        }


                        if (this.isOwnedBy(player)) {
                            if (player.isShiftKeyDown() && itemStack.isEmpty()) {
                                this.catchHamster(player);
                                return InteractionResult.SUCCESS;
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
        return super.mobInteract(player, interactionHand);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lcom/starfish_studios/hamsters/entities/Hamster;playEatingSound(Lnet/minecraft/world/item/ItemStack;)V", shift = At.Shift.AFTER), method = "feedHamster", remap = false)
    private void feedHamster(ItemStack itemStack, Player player, boolean shouldHeal, CallbackInfo ci) {
        if (this.isOwnedBy(player)) {
            this.setCheekLevel(this.getCheekLevel() + 1);
        }
    }

    private void feedHamsterNonFood(ItemStack itemStack, Player player, boolean shouldHeal) {
        if (this.level() != null) {
            if (this.isOwnedBy(player)) {
                if (!player.getCooldowns().isOnCooldown(itemStack.getItem())) {
                    this.playEatingSound(itemStack);
                    if (this.getHealth() < this.getMaxHealth() && shouldHeal) {
                        this.heal(this.getMaxHealth() / 4.0F);
                    }

                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }

                    if (this.getItemInHand(InteractionHand.MAIN_HAND).getItem() == itemStack.getItem()) {
                        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(itemStack.getItem(), this.getItemInHand(InteractionHand.MAIN_HAND).getCount() + 1));
                    } else {
                        ItemEntity itemEntity = new ItemEntity(this.level(), this.getOnPos().getX(), this.getOnPos().getY(), this.getOnPos().getZ(), this.getItemInHand(InteractionHand.MAIN_HAND));
                        this.level().addFreshEntity(itemEntity);
                        this.setCheekLevel(this.getCheekLevel() - 1);
                        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(itemStack.getItem(), 1));
                    }
                }
            }
        }
    }

    @Shadow(remap = false)
    public abstract void feedHamster(ItemStack itemStack, Player player, boolean shouldHeal);

    @Shadow(remap = false)
    public abstract void addAgeToHamster();

    @Shadow(remap = false)
    public abstract int getSquishedTicks();

    @Shadow(remap = false)
    public abstract int getCheekLevel();

    @Shadow(remap = false)
    public abstract void setCheekLevel(int cheekLevel);

    @Shadow(remap = false)
    public abstract DyeColor getCollarColor();

    @Shadow(remap = false)
    public abstract void setCollarColor(DyeColor dyeColor);

    @Shadow(remap = false)
    public abstract void catchHamster(Player player);

    @Shadow(remap = false)
    public abstract void squishHamster();

    @Shadow(remap = false)
    public abstract void setSquishedTicks(int squishedTicks);

    @Shadow(remap = false)
    public abstract boolean isInWheel();

    @Shadow(remap = false)
    public abstract int getSleepCooldownTicks();

    @Shadow(remap = false)
    public abstract void setSleepingCooldownTicks(int sleepingCooldownTicks);

    @Shadow(remap = false)
    public abstract int getBirthCountdown();

    @Shadow(remap = false)
    public abstract void setBirthCountdown(int birthCountdown);

    @Shadow(remap = false)
    public abstract void setDefaultSleepingCooldown();

    @Shadow(remap = false)
    public abstract int getDrinkingCooldownTicks();

    @Shadow(remap = false)
    public abstract void setDrinkingCooldownTicks(int drinkingCooldownTicks);

    @Shadow(remap = false)
    public abstract int getMountingCooldownTicks();

    @Shadow(remap = false)
    public abstract void setMountingCooldownTicks(int mountingCooldownTicks);

    @Shadow(remap = false)
    public abstract int getDismountingCooldownTicks();

    @Shadow(remap = false)
    public abstract void setDismountingCooldownTicks(int dismountingCooldownTicks);

    @Shadow(remap = false)
    public abstract void playEatingSound(ItemStack itemStack);
}