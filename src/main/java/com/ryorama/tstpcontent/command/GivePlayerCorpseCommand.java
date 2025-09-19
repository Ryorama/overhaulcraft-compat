package com.ryorama.tstpcontent.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.ryorama.tstpcontent.utils.IPlayerCorpse;
import net.mcreator.butcher.init.ButcherModItems;
import net.mcreator.butcher.item.PlayercorpseitemItem;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class GivePlayerCorpseCommand {
    public GivePlayerCorpseCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("givePlayerCorpse").executes(this::execute));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        PlayercorpseitemItem playercorpseitemItem = (PlayercorpseitemItem) ButcherModItems.PLAYERCORPSEITEM.get();
        ((IPlayerCorpse)playercorpseitemItem).overhaulcraft_compat$setPlayerUUID(player.getUUID());
        ItemStack corpseItemStack = new ItemStack(playercorpseitemItem);
        corpseItemStack.getOrCreateTag().putBoolean("savedName", true);
        corpseItemStack.setHoverName(Component.literal(player.getDisplayName().getString()));
        player.getInventory().add(corpseItemStack);
        player.containerMenu.broadcastChanges();
        return 1;
    }
}
