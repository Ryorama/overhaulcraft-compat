package com.ryorama.tstpcontent.mixins.butchery;

import com.ryorama.tstpcontent.utils.IPlayerCorpse;
import net.mcreator.butcher.configuration.CorpsesConfiguration;
import net.mcreator.butcher.init.ButcherModEnchantments;
import net.mcreator.butcher.init.ButcherModItems;
import net.mcreator.butcher.item.PlayercorpseitemItem;
import net.mcreator.butcher.procedures.PlayerdropProcedure;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;

@Mixin(PlayerdropProcedure.class)
public class PlayerdropProcedureMixin {
    /**
     * @author Ryorama
     * @reason Add player skin to corpse
     */
    @Overwrite(remap = false)
    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            ItemStack player_name = ItemStack.EMPTY;
            if ((entity instanceof Player || entity instanceof ServerPlayer || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("c:player")))) && (Boolean) CorpsesConfiguration.PLAYER_CORPSE.get()) {
                if (CorpsesConfiguration.SPECIFIC_TOOLS.get()) {
                    ItemStack var10000;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity) sourceentity;
                        var10000 = _livEnt.getMainHandItem();
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    if (var10000.getItem() != ButcherModItems.BONEBUTCHERSKNIFE.get()) {
                        if (sourceentity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity) sourceentity;
                            var10000 = _livEnt.getMainHandItem();
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() != ButcherModItems.BUTCHERS_KNIFE.get()) {
                            if (sourceentity instanceof LivingEntity) {
                                LivingEntity _livEnt = (LivingEntity) sourceentity;
                                var10000 = _livEnt.getMainHandItem();
                            } else {
                                var10000 = ItemStack.EMPTY;
                            }

                            if (var10000.getItem() != ButcherModItems.NETHERITE_BUTCHERS_KNIFE.get()) {
                                Enchantment var61 = ButcherModEnchantments.BUTCHERENCHANTMENT.get();
                                ItemStack var10001;
                                if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity) sourceentity;
                                    var10001 = _livEnt.getMainHandItem();
                                } else {
                                    var10001 = ItemStack.EMPTY;
                                }

                                if (EnchantmentHelper.getItemEnchantmentLevel(var61, var10001) == 0) {
                                    return;
                                }
                            }
                        }
                    }

                    PlayercorpseitemItem playercorpseitemItem = (PlayercorpseitemItem)ButcherModItems.PLAYERCORPSEITEM.get();
                    ((IPlayerCorpse)playercorpseitemItem).overhaulcraft_compat$setPlayerUUID(entity.getUUID());
                    player_name = new ItemStack(playercorpseitemItem);
                    player_name.getOrCreateTag().putBoolean("savedName", true);
                    player_name.setHoverName(Component.literal(entity.getDisplayName().getString()));
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, player_name);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BLUE_DYE));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.RED_DYE));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }
                } else if (!CorpsesConfiguration.SPECIFIC_TOOLS.get()) {
                    PlayercorpseitemItem playercorpseitemItem = (PlayercorpseitemItem)ButcherModItems.PLAYERCORPSEITEM.get();
                    ((IPlayerCorpse)playercorpseitemItem).overhaulcraft_compat$setPlayerUUID(entity.getUUID());
                    player_name = new ItemStack(playercorpseitemItem);
                    player_name.getOrCreateTag().putBoolean("savedName", true);
                    player_name.setHoverName(Component.literal(entity.getDisplayName().getString()));
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, player_name);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BLUE_DYE));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.RED_DYE));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }
                } else if (sourceentity instanceof Animal) {
                    if (CorpsesConfiguration.PLAYER_CORPSE.get()) {
                        PlayercorpseitemItem playercorpseitemItem = (PlayercorpseitemItem)ButcherModItems.PLAYERCORPSEITEM.get();
                        ((IPlayerCorpse)playercorpseitemItem).overhaulcraft_compat$setPlayerUUID(entity.getUUID());
                        player_name = new ItemStack(playercorpseitemItem);
                        player_name.getOrCreateTag().putBoolean("savedName", true);
                        player_name.setHoverName(Component.literal(entity.getDisplayName().getString()));
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel) world;
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, player_name);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }

                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel) world;
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }

                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel) world;
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }

                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel) world;
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BLUE_DYE));
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }

                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel) world;
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.RED_DYE));
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    }
                } else if (sourceentity instanceof Monster && CorpsesConfiguration.PLAYER_CORPSE.get()) {
                    PlayercorpseitemItem playercorpseitemItem = (PlayercorpseitemItem)ButcherModItems.PLAYERCORPSEITEM.get();
                    ((IPlayerCorpse)playercorpseitemItem).overhaulcraft_compat$setPlayerUUID(entity.getUUID());
                    player_name = new ItemStack(playercorpseitemItem);
                    player_name.getOrCreateTag().putBoolean("savedName", true);
                    player_name.setHoverName(Component.literal(entity.getDisplayName().getString()));
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, player_name);
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BLUE_DYE));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.RED_DYE));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }
                }
            }
        }
    }
}