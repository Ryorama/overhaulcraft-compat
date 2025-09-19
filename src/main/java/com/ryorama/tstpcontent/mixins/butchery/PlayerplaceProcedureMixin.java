package com.ryorama.tstpcontent.mixins.butchery;

import com.google.common.collect.UnmodifiableIterator;
import com.ryorama.tstpcontent.utils.IPlayerCorpse;
import net.mcreator.butcher.block.HangingplayercorpseBlock;
import net.mcreator.butcher.block.PlayercorpseBlock;
import net.mcreator.butcher.init.ButcherModBlocks;
import net.mcreator.butcher.init.ButcherModItems;
import net.mcreator.butcher.procedures.PlayerplaceProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Map;

@Mixin(PlayerplaceProcedure.class)
public class PlayerplaceProcedureMixin {
    /**
     * @author Ryorama
     * @reason Add UUID when placed
     */
    @Overwrite(remap = false)
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity != null) {
            if (entity instanceof Player) {
                Player _player = ((Player)entity);
                ItemStack playerHand = _player.getMainHandItem();

                PlayercorpseBlock playercorpseBlock = (PlayercorpseBlock) ButcherModBlocks.PLAYERCORPSE.get();
                HangingplayercorpseBlock hangingplayercorpseBlock = (HangingplayercorpseBlock) ButcherModBlocks.HANGINGPLAYERCORPSE.get();

                if (playerHand.getItem().equals(ButcherModItems.PLAYERCORPSE.get()) || playerHand.getItem().equals(ButcherModItems.HANGINGPLAYERCORPSE.get())) {
                    if (((IPlayerCorpse)playercorpseBlock).overhaulcraft_compat$getPlayerUUID() != null) {
                        ((IPlayerCorpse)playercorpseBlock).overhaulcraft_compat$setPlayerUUID(((IPlayerCorpse)playerHand.getItem()).overhaulcraft_compat$getPlayerUUID());
                    }

                    if (((IPlayerCorpse)hangingplayercorpseBlock).overhaulcraft_compat$getPlayerUUID() != null) {
                        ((IPlayerCorpse)hangingplayercorpseBlock).overhaulcraft_compat$setPlayerUUID(((IPlayerCorpse)playerHand.getItem()).overhaulcraft_compat$getPlayerUUID());
                    } 
                }
                
                if (entity.isShiftKeyDown() || !entity.isShiftKeyDown()) {
                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ButcherModBlocks.HOOK_BLOCK.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ButcherModBlocks.ROPE.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ButcherModBlocks.ROPE_2.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ButcherModBlocks.ROPE_3.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ButcherModBlocks.ROPE_4.get()) {
                        if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.NORTH) {
                            if (world.getBlockState(BlockPos.containing(x, y, z - (double)1.0F)).getBlock() == Blocks.AIR) {
                                if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.swing(InteractionHand.MAIN_HAND, true);
                                }

                                world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() - 1)), ((new Object() {
                                    public BlockState with(BlockState _bs, Direction newValue) {
                                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_prop instanceof DirectionProperty _dp) {
                                            if (_dp.getPossibleValues().contains(newValue)) {
                                                return _bs.setValue(_dp, newValue);
                                            }
                                        }

                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        BlockState var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                return var10000;
                                            }
                                        }

                                        var10000 = _bs;
                                        return var10000;
                                    }
                                })).with(playercorpseBlock.defaultBlockState(), Direction.NORTH), 3);
                                ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                            }
                        } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.SOUTH) {
                            if (world.getBlockState(BlockPos.containing(x, y, z + (double)1.0F)).getBlock() == Blocks.AIR) {
                                if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.swing(InteractionHand.MAIN_HAND, true);
                                }

                                world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1)), ((new Object() {
                                    public BlockState with(BlockState _bs, Direction newValue) {
                                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_prop instanceof DirectionProperty _dp) {
                                            if (_dp.getPossibleValues().contains(newValue)) {
                                                return _bs.setValue(_dp, newValue);
                                            }
                                        }

                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        BlockState var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                return var10000;
                                            }
                                        }

                                        var10000 = _bs;
                                        return var10000;
                                    }
                                })).with(playercorpseBlock.defaultBlockState(), Direction.SOUTH), 3);
                                ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                            }
                        } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.WEST) {
                            if (world.getBlockState(BlockPos.containing(x - (double)1.0F, y, z)).getBlock() == Blocks.AIR) {
                                if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.swing(InteractionHand.MAIN_HAND, true);
                                }

                                world.setBlock(BlockPos.containing((entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() - 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                    public BlockState with(BlockState _bs, Direction newValue) {
                                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_prop instanceof DirectionProperty _dp) {
                                            if (_dp.getPossibleValues().contains(newValue)) {
                                                return _bs.setValue(_dp, newValue);
                                            }
                                        }

                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        BlockState var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                return var10000;
                                            }
                                        }

                                        var10000 = _bs;
                                        return var10000;
                                    }
                                })).with(playercorpseBlock.defaultBlockState(), Direction.WEST), 3);
                                ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                            }
                        } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.EAST) {
                            if (world.getBlockState(BlockPos.containing(x + (double)1.0F, y, z)).getBlock() == Blocks.AIR) {
                                if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.swing(InteractionHand.MAIN_HAND, true);
                                }

                                world.setBlock(BlockPos.containing((entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                    public BlockState with(BlockState _bs, Direction newValue) {
                                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_prop instanceof DirectionProperty _dp) {
                                            if (_dp.getPossibleValues().contains(newValue)) {
                                                return _bs.setValue(_dp, newValue);
                                            }
                                        }

                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        BlockState var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                return var10000;
                                            }
                                        }

                                        var10000 = _bs;
                                        return var10000;
                                    }
                                })).with(playercorpseBlock.defaultBlockState(), Direction.EAST), 3);
                                ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                            }
                        } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.UP) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entity;
                                _entity.swing(InteractionHand.MAIN_HAND, true);
                            }

                            if (entity.getDirection() == Direction.NORTH) {
                                if (world.getBlockState(BlockPos.containing(x, y + (double)1.0F, z)).getBlock() == Blocks.AIR) {
                                    if (world instanceof Level) {
                                        Level _level = (Level)world;
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                        }
                                    }

                                    world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (double)(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                        public BlockState with(BlockState _bs, Direction newValue) {
                                            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                            if (_prop instanceof DirectionProperty _dp) {
                                                if (_dp.getPossibleValues().contains(newValue)) {
                                                    return _bs.setValue(_dp, newValue);
                                                }
                                            }

                                            _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            BlockState var10000;
                                            if (_prop instanceof EnumProperty _ep) {
                                                if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                    var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                    return var10000;
                                                }
                                            }

                                            var10000 = _bs;
                                            return var10000;
                                        }
                                    })).with(playercorpseBlock.defaultBlockState(), Direction.SOUTH), 3);
                                    ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                    _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                                }
                            } else if (entity.getDirection() == Direction.SOUTH) {
                                if (world.getBlockState(BlockPos.containing(x, y + (double)1.0F, z)).getBlock() == Blocks.AIR) {
                                    if (world instanceof Level) {
                                        Level _level = (Level)world;
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                        }
                                    }

                                    world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                        public BlockState with(BlockState _bs, Direction newValue) {
                                            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                            if (_prop instanceof DirectionProperty _dp) {
                                                if (_dp.getPossibleValues().contains(newValue)) {
                                                    return _bs.setValue(_dp, newValue);
                                                }
                                            }

                                            _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            BlockState var10000;
                                            if (_prop instanceof EnumProperty _ep) {
                                                if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                    var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                    return var10000;
                                                }
                                            }

                                            var10000 = _bs;
                                            return var10000;
                                        }
                                    })).with(playercorpseBlock.defaultBlockState(), Direction.NORTH), 3);
                                    ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                    _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                                }
                            } else if (entity.getDirection() == Direction.WEST) {
                                if (world.getBlockState(BlockPos.containing(x, y + (double)1.0F, z)).getBlock() == Blocks.AIR) {
                                    if (world instanceof Level) {
                                        Level _level = (Level)world;
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                        }
                                    }

                                    world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                        public BlockState with(BlockState _bs, Direction newValue) {
                                            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                            if (_prop instanceof DirectionProperty _dp) {
                                                if (_dp.getPossibleValues().contains(newValue)) {
                                                    return _bs.setValue(_dp, newValue);
                                                }
                                            }

                                            _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            BlockState var10000;
                                            if (_prop instanceof EnumProperty _ep) {
                                                if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                    var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                    return var10000;
                                                }
                                            }

                                            var10000 = _bs;
                                            return var10000;
                                        }
                                    })).with(playercorpseBlock.defaultBlockState(), Direction.EAST), 3);
                                    ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                    _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                                }
                            } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing(x, y + (double)1.0F, z)).getBlock() == Blocks.AIR) {
                                if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                }

                                world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                    public BlockState with(BlockState _bs, Direction newValue) {
                                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_prop instanceof DirectionProperty _dp) {
                                            if (_dp.getPossibleValues().contains(newValue)) {
                                                return _bs.setValue(_dp, newValue);
                                            }
                                        }

                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        BlockState var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                return var10000;
                                            }
                                        }

                                        var10000 = _bs;
                                        return var10000;
                                    }
                                })).with(playercorpseBlock.defaultBlockState(), Direction.WEST), 3);
                                ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                            }
                        } else if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection() == Direction.DOWN) {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entity;
                                _entity.swing(InteractionHand.MAIN_HAND, true);
                            }

                            if (entity.getDirection() == Direction.NORTH) {
                                if (world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                                    if (world instanceof Level) {
                                        Level _level = (Level)world;
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                        }
                                    }

                                    world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                        public BlockState with(BlockState _bs, Direction newValue) {
                                            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                            if (_prop instanceof DirectionProperty _dp) {
                                                if (_dp.getPossibleValues().contains(newValue)) {
                                                    return _bs.setValue(_dp, newValue);
                                                }
                                            }

                                            _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            BlockState var10000;
                                            if (_prop instanceof EnumProperty _ep) {
                                                if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                    var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                    return var10000;
                                                }
                                            }

                                            var10000 = _bs;
                                            return var10000;
                                        }
                                    })).with(playercorpseBlock.defaultBlockState(), Direction.SOUTH), 3);
                                    ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                    _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                                }
                            } else if (entity.getDirection() == Direction.SOUTH) {
                                if (world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                                    if (world instanceof Level) {
                                        Level _level = (Level)world;
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                        }
                                    }

                                    world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                        public BlockState with(BlockState _bs, Direction newValue) {
                                            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                            if (_prop instanceof DirectionProperty _dp) {
                                                if (_dp.getPossibleValues().contains(newValue)) {
                                                    return _bs.setValue(_dp, newValue);
                                                }
                                            }

                                            _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            BlockState var10000;
                                            if (_prop instanceof EnumProperty _ep) {
                                                if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                    var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                    return var10000;
                                                }
                                            }

                                            var10000 = _bs;
                                            return var10000;
                                        }
                                    })).with(playercorpseBlock.defaultBlockState(), Direction.NORTH), 3);
                                    ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                    _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                                }
                            } else if (entity.getDirection() == Direction.WEST) {
                                if (world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                                    if (world instanceof Level) {
                                        Level _level = (Level)world;
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                        }
                                    }

                                    world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                        public BlockState with(BlockState _bs, Direction newValue) {
                                            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                            if (_prop instanceof DirectionProperty _dp) {
                                                if (_dp.getPossibleValues().contains(newValue)) {
                                                    return _bs.setValue(_dp, newValue);
                                                }
                                            }

                                            _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            BlockState var10000;
                                            if (_prop instanceof EnumProperty _ep) {
                                                if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                    var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                    return var10000;
                                                }
                                            }

                                            var10000 = _bs;
                                            return var10000;
                                        }
                                    })).with(playercorpseBlock.defaultBlockState(), Direction.EAST), 3);
                                    ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                    _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                                }
                            } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                                if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                }

                                world.setBlock(BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() - 1), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0F)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), ((new Object() {
                                    public BlockState with(BlockState _bs, Direction newValue) {
                                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_prop instanceof DirectionProperty _dp) {
                                            if (_dp.getPossibleValues().contains(newValue)) {
                                                return _bs.setValue(_dp, newValue);
                                            }
                                        }

                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        BlockState var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                                var10000 = _bs.setValue(_ep, newValue.getAxis());
                                                return var10000;
                                            }
                                        }

                                        var10000 = _bs;
                                        return var10000;
                                    }
                                })).with(playercorpseBlock.defaultBlockState(), Direction.WEST), 3);
                                ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                                _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                            }
                        }
                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcherModBlocks.HOOK_BLOCK.get()) {
                        if (world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                }
                            }

                            world.setBlock(BlockPos.containing(x, y - (double)1.0F, z), ((new Object() {
                                public BlockState with(BlockState _bs, Direction newValue) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (_prop instanceof DirectionProperty _dp) {
                                        if (_dp.getPossibleValues().contains(newValue)) {
                                            return _bs.setValue(_dp, newValue);
                                        }
                                    }

                                    _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                    BlockState var10000;
                                    if (_prop instanceof EnumProperty _ep) {
                                        if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                            var10000 = _bs.setValue(_ep, newValue.getAxis());
                                            return var10000;
                                        }
                                    }

                                    var10000 = _bs;
                                    return var10000;
                                }
                            })).with(hangingplayercorpseBlock.defaultBlockState(), ((new Object() {
                                public Direction getDirection(BlockState _bs) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (_prop instanceof DirectionProperty _dp) {
                                        return _bs.getValue(_dp);
                                    } else {
                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        Direction var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().toArray()[0] instanceof Direction.Axis) {
                                                var10000 = Direction.fromAxisAndDirection((Direction.Axis)_bs.getValue(_ep), Direction.AxisDirection.POSITIVE);
                                                return var10000;
                                            }
                                        }

                                        var10000 = Direction.NORTH;
                                        return var10000;
                                    }
                                }
                            })).getDirection(blockstate)), 3);
                            ItemStack _stktoremove = new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get());
                            _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcherModBlocks.ROPE.get()) {
                        if (world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("butcher:rope_pull")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("butcher:rope_pull")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                }
                            }

                            world.setBlock(BlockPos.containing(x, y - (double)1.0F, z), ((new Object() {
                                public BlockState with(BlockState _bs, Direction newValue) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (_prop instanceof DirectionProperty _dp) {
                                        if (_dp.getPossibleValues().contains(newValue)) {
                                            return _bs.setValue(_dp, newValue);
                                        }
                                    }

                                    _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                    BlockState var10000;
                                    if (_prop instanceof EnumProperty _ep) {
                                        if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                            var10000 = _bs.setValue(_ep, newValue.getAxis());
                                            return var10000;
                                        }
                                    }

                                    var10000 = _bs;
                                    return var10000;
                                }
                            })).with(hangingplayercorpseBlock.defaultBlockState(), ((new Object() {
                                public Direction getDirection(BlockState _bs) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (_prop instanceof DirectionProperty _dp) {
                                        return _bs.getValue(_dp);
                                    } else {
                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        Direction var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().toArray()[0] instanceof Direction.Axis) {
                                                var10000 = Direction.fromAxisAndDirection((Direction.Axis)_bs.getValue(_ep), Direction.AxisDirection.POSITIVE);
                                                return var10000;
                                            }
                                        }

                                        var10000 = Direction.NORTH;
                                        return var10000;
                                    }
                                }
                            })).getDirection(blockstate)), 3);
                            if (entity instanceof Player) {
                                Player _plr = (Player)entity;
                                if (_plr.getAbilities().instabuild) {
                                    return;
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entity;
                                ItemStack _setstack = (new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get())).copy();
                                ItemStack var10001;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var10001 = _livEnt.getMainHandItem();
                                } else {
                                    var10001 = ItemStack.EMPTY;
                                }

                                _setstack.setCount(var10001.getCount() - 1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcherModBlocks.ROPE_2.get()) {
                        if (world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("butcher:rope_pull")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("butcher:rope_pull")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                }
                            }

                            BlockPos _bp = BlockPos.containing(x, y, z);
                            BlockState _bs = (ButcherModBlocks.ROPE_3.get()).defaultBlockState();
                            BlockState _bso = world.getBlockState(_bp);
                            UnmodifiableIterator _livEnt = _bso.getValues().entrySet().iterator();

                            while(_livEnt.hasNext()) {
                                Map.Entry<Property<?>, Comparable<?>> entry = (Map.Entry)_livEnt.next();
                                Property _property = _bs.getBlock().getStateDefinition().getProperty((entry.getKey()).getName());
                                if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                        _bs = _bs.setValue(_property, (Comparable)entry.getValue());
                                    } catch (Exception var17) {
                                    }
                                }
                            }

                            world.setBlock(_bp, _bs, 3);
                            world.setBlock(BlockPos.containing(x, y - (double)1.0F, z), ((new Object() {
                                public BlockState with(BlockState _bs, Direction newValue) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (_prop instanceof DirectionProperty _dp) {
                                        if (_dp.getPossibleValues().contains(newValue)) {
                                            return _bs.setValue(_dp, newValue);
                                        }
                                    }

                                    _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                    BlockState var10000;
                                    if (_prop instanceof EnumProperty _ep) {
                                        if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                            var10000 = _bs.setValue(_ep, newValue.getAxis());
                                            return var10000;
                                        }
                                    }

                                    var10000 = _bs;
                                    return var10000;
                                }
                            })).with(hangingplayercorpseBlock.defaultBlockState(), ((new Object() {
                                public Direction getDirection(BlockState _bs) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (_prop instanceof DirectionProperty _dp) {
                                        return _bs.getValue(_dp);
                                    } else {
                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        Direction var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().toArray()[0] instanceof Direction.Axis) {
                                                var10000 = Direction.fromAxisAndDirection((Direction.Axis)_bs.getValue(_ep), Direction.AxisDirection.POSITIVE);
                                                return var10000;
                                            }
                                        }

                                        var10000 = Direction.NORTH;
                                        return var10000;
                                    }
                                }
                            })).getDirection(blockstate)), 3);
                            if (entity instanceof Player) {
                                Player _plr = (Player)entity;
                                if (_plr.getAbilities().instabuild) {
                                    return;
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entity;
                                ItemStack _setstack = (new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get())).copy();
                                ItemStack var87;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt2 = (LivingEntity)entity;
                                    var87 = _livEnt2.getMainHandItem();
                                } else {
                                    var87 = ItemStack.EMPTY;
                                }

                                _setstack.setCount(var87.getCount() - 1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcherModBlocks.ROPE_3.get()) {
                        if (world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                            if (world instanceof Level) {
                                Level _level = (Level)world;
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("butcher:rope_pull")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("butcher:rope_pull")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                }
                            }

                            BlockPos _bp = BlockPos.containing(x, y, z);
                            BlockState _bs = (ButcherModBlocks.ROPE_4.get()).defaultBlockState();
                            BlockState _bso = world.getBlockState(_bp);
                            UnmodifiableIterator _player2 = _bso.getValues().entrySet().iterator();

                            while(_player2.hasNext()) {
                                Map.Entry<Property<?>, Comparable<?>> entry = (Map.Entry)_player2.next();
                                Property _property = _bs.getBlock().getStateDefinition().getProperty((entry.getKey()).getName());
                                if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                        _bs = _bs.setValue(_property, (Comparable)entry.getValue());
                                    } catch (Exception var16) {
                                    }
                                }
                            }

                            world.setBlock(_bp, _bs, 3);
                            world.setBlock(BlockPos.containing(x, y - (double)1.0F, z), ((new Object() {
                                public BlockState with(BlockState _bs, Direction newValue) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (_prop instanceof DirectionProperty _dp) {
                                        if (_dp.getPossibleValues().contains(newValue)) {
                                            return _bs.setValue(_dp, newValue);
                                        }
                                    }

                                    _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                    BlockState var10000;
                                    if (_prop instanceof EnumProperty _ep) {
                                        if (_ep.getPossibleValues().contains(newValue.getAxis())) {
                                            var10000 = _bs.setValue(_ep, newValue.getAxis());
                                            return var10000;
                                        }
                                    }

                                    var10000 = _bs;
                                    return var10000;
                                }
                            })).with(hangingplayercorpseBlock.defaultBlockState(), ((new Object() {
                                public Direction getDirection(BlockState _bs) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (_prop instanceof DirectionProperty _dp) {
                                        return _bs.getValue(_dp);
                                    } else {
                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        Direction var10000;
                                        if (_prop instanceof EnumProperty _ep) {
                                            if (_ep.getPossibleValues().toArray()[0] instanceof Direction.Axis) {
                                                var10000 = Direction.fromAxisAndDirection((Direction.Axis)_bs.getValue(_ep), Direction.AxisDirection.POSITIVE);
                                                return var10000;
                                            }
                                        }

                                        var10000 = Direction.NORTH;
                                        return var10000;
                                    }
                                }
                            })).getDirection(blockstate)), 3);
                            if (entity instanceof Player) {
                                Player _plr = (Player)entity;
                                if (_plr.getAbilities().instabuild) {
                                    return;
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entity;
                                ItemStack _setstack = (new ItemStack(ButcherModItems.PLAYERCORPSEITEM.get())).copy();
                                ItemStack var88;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var88 = _livEnt.getMainHandItem();
                                } else {
                                    var88 = ItemStack.EMPTY;
                                }

                                _setstack.setCount(var88.getCount() - 1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                _player.getInventory().setChanged();
                            }
                        }
                    } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcherModBlocks.ROPE_4.get() && world.getBlockState(BlockPos.containing(x, y - (double)1.0F, z)).getBlock() == Blocks.AIR) {
                        world.destroyBlock(BlockPos.containing(x, y, z), false);
                    }
                }   
            }
        }
    }
}