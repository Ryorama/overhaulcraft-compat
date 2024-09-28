package com.ryorama.tstpcontent.item.cuisinedelight;

import com.ryorama.tstpcontent.block.cuisine_delight.entity.DarkPotBlockEntity;
import com.ryorama.tstpcontent.client.PotBEWLR;
import dev.xkmc.cuisinedelight.content.logic.CookingData;
import dev.xkmc.cuisinedelight.content.logic.IngredientConfig;
import dev.xkmc.cuisinedelight.init.data.CDConfig;
import dev.xkmc.cuisinedelight.init.data.LangData;
import dev.xkmc.l2serial.serialization.codec.TagCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.CookingPotItem;
import vectorwing.farmersdelight.common.registry.ModSounds;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class DarkPotItem extends CookingPotItem {
    private static final String KEY_ROOT = "CookingData";

    @Nullable
    public static CookingData getData(ItemStack stack) {
        var tag = stack.getTagElement(KEY_ROOT);
        if (tag == null) return null;
        return TagCodec.fromTag(tag, CookingData.class);
    }

    public static void setData(ItemStack stack, @Nullable CookingData data) {
        if (data == null) {
            stack.getOrCreateTag().remove(KEY_ROOT);
            return;
        }
        var tag = TagCodec.valueToTag(data);
        if (tag != null) {
            stack.getOrCreateTag().put(KEY_ROOT, tag);
        }
    }

    public static boolean canUse(ItemStack stack, Player player, Level level) {
        if (getData(stack) != null) return true;
        if (stack.getEnchantmentLevel(Enchantments.FIRE_ASPECT) > 0) return true;
        return isPlayerNearHeatSource(player, level);
    }

    public static void playSound(Player player, Level level) {
        Vec3 pos = player.position();
        double x = pos.x() + 0.5D;
        double y = pos.y();
        double z = pos.z() + 0.5D;
        if (level.random.nextInt(50) == 0) {
            level.playLocalSound(x, y, z, ModSounds.BLOCK_COOKING_POT_BOIL.get(), SoundSource.BLOCKS,
                    0.4F, level.random.nextFloat() * 0.2F + 0.9F, false);
        }
    }

    public static void playSound(Player player, Level level, SoundEvent event) {
        Vec3 pos = player.position();
        double x = pos.x() + 0.5D;
        double y = pos.y();
        double z = pos.z() + 0.5D;
        level.playLocalSound(x, y, z, event, SoundSource.BLOCKS,
                0.4F, level.random.nextFloat() * 0.2F + 0.9F, false);
    }

    public DarkPotItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack skilletStack = player.getItemInHand(hand);
        if (!canUse(skilletStack, player, level)) {
            if (!level.isClientSide()) {
                ((ServerPlayer) player).sendSystemMessage(LangData.MSG_NO_HEAT.get(), true);
            }
            return InteractionResultHolder.fail(skilletStack);
        }
        CookingData data = getData(skilletStack);
        if (data != null && data.contents.size() >= CDConfig.COMMON.maxIngredient.get()) {
            if (!level.isClientSide()) {
                ((ServerPlayer) player).sendSystemMessage(LangData.MSG_FULL.get(), true);
            }
            return InteractionResultHolder.fail(skilletStack);
        }
        InteractionHand otherHand = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack otherStack = player.getItemInHand(otherHand);

        if (!otherStack.isEmpty()) {
            IngredientConfig.IngredientEntry entry = IngredientConfig.get().getEntry(otherStack);
            if (entry != null) {
                if (!level.isClientSide()) {
                    long time = level.getGameTime();
                    if (data == null) {
                        data = new CookingData();
                    }
                    int amount = 1 + getEnchantmentLevel(skilletStack, Enchantments.BLOCK_EFFICIENCY);
                    data.addItem(otherStack.split(amount), time);
                    setData(skilletStack, data);
                } else {
                    playSound(player, level, ModSounds.BLOCK_SKILLET_ADD_FOOD.get());
                }
            } else {
                if (!level.isClientSide()) {
                    ((ServerPlayer) player).sendSystemMessage(LangData.MSG_NOT_INGREDIENT.get(), true);
                }
            }
        } else {
            if (!level.isClientSide()) {
                ((ServerPlayer) player).sendSystemMessage(LangData.MSG_PLACE_HELP.get(), true);
            }
        }
        return InteractionResultHolder.fail(skilletStack);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(PotBEWLR.EXTENSIONS);
    }

    @Override
    protected boolean updateCustomBlockEntityTag(BlockPos pos, Level level, @Nullable Player player, ItemStack stack, BlockState state) {
        BlockItem.updateCustomBlockEntityTag(level, player, pos, stack);
        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof DarkPotBlockEntity be) {
            be.setPotItem(stack);
            return true;
        } else {
            return false;
        }
    }

    //------

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {

    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        return stack;
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int count) {
    }

    private static boolean isPlayerNearHeatSource(Player player, LevelReader level) {
        if (player.isOnFire()) {
            return true;
        } else {
            BlockPos pos = player.blockPosition();
            for (BlockPos nearbyPos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
                if (level.getBlockState(nearbyPos).is(ModTags.HEAT_SOURCES)) {
                    return true;
                }
            }
        }
        return false;
    }
}
