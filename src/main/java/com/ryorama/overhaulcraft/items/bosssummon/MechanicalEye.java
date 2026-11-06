package com.ryorama.overhaulcraft.items.bosssummon;

import com.google.common.collect.Streams;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.confluence.lib.common.component.ModRarity;
import org.confluence.lib.common.item.CustomRarityItem;
import org.confluence.mod.common.entity.boss.TwinEyeEncounter;
import org.confluence.mod.common.gameevent.LanternNightGameEvent;
import org.confluence.mod.common.init.entity.BossEntities;

import java.util.function.Predicate;

public class MechanicalEye extends CustomRarityItem {
    private final Predicate<Player> condition;

    public MechanicalEye(Predicate<Player> condition) {
        super(new Item.Properties(), ModRarity.BLUE);
        this.condition = condition;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        if (level instanceof ServerLevel serverLevel) {
            if (this.condition.test(player)) {
                if (Streams.stream(serverLevel.getAllEntities()).anyMatch((entity) -> entity.getType() == BossEntities.SPAZMATISM.get().create(level).getType()) || Streams.stream(serverLevel.getAllEntities()).anyMatch((entity) -> entity.getType() == BossEntities.RETINAZER.get().create(level).getType())) {
                    return InteractionResultHolder.fail(itemStack);
                }

                if (!player.hasInfiniteMaterials()) {
                    itemStack.shrink(1);
                }

                TwinEyeEncounter.summon(serverLevel, player.position(), player);
                LanternNightGameEvent.INSTANCE.forceEnd();
            }
        }

        return InteractionResultHolder.success(itemStack);
    }
}
