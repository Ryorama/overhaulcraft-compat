package com.ryorama.overhaulcraft.items;

import com.ryorama.overhaulcraft.world.dimension.CobblemonDim;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;

public class CobbledimTeleportItem extends Item {
    public CobbledimTeleportItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 40;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            ServerLevel dimension = serverPlayer.server.getLevel(level.dimension() == CobblemonDim.LEVEL ? Level.OVERWORLD : CobblemonDim.LEVEL);
            serverPlayer.changeDimension(new DimensionTransition(dimension, serverPlayer.position().add(0, 0.1, 0), serverPlayer.getDeltaMovement(), serverPlayer.getXRot(), serverPlayer.getYRot(), entity -> {
                if (entity instanceof ServerPlayer serverPlayer1) {
                    serverPlayer1.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                }
            }));
            serverPlayer.getCooldowns().addCooldown(this, 20);
        }
        return InteractionResultHolder.pass(player.getItemInHand(usedHand));
    }
}
