package com.ryorama.overhaulcraft.init;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.ryorama.overhaulcraft.utils.IOverhaulPlayerData;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;

public class OverhaulCraftCommands {
    public static void setTerrariaFuncUnlocked(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal("setTerrariaFuncUnlocked").then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("value", BoolArgumentType.bool()).executes(ctx -> {
            Player player = EntityArgument.getPlayer(ctx, "player");
            boolean value = ctx.getArgument("value", Boolean.class);
            ((IOverhaulPlayerData)player).setTerrariaFuncUnlocked(value);
            return 0;
        }))));
    }

    public static void setCobblemonFuncUnlocked(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal("setCobblemonFuncUnlocked").then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("value", BoolArgumentType.bool()).executes(ctx -> {
            Player player = EntityArgument.getPlayer(ctx, "player");
            boolean value = ctx.getArgument("value", Boolean.class);
            ((IOverhaulPlayerData)player).setCobblemonFuncUnlocked(value);
            return 0;
        }))));
    }
}
