package com.ryorama.overhaulcraft.events;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.init.OverhaulCraftSounds;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.confluence.mod.common.gameevent.*;
import org.confluence.mod.common.init.ModBiomes;
import org.confluence.mod.common.init.block.DecorativeBlocks;
import org.confluence.mod.common.init.block.OreBlocks;
import org.confluence.terraentity.entity.boss.*;
import org.confluence.terraentity.entity.boss.wallofflesh.WallOfFlesh;

import java.util.Arrays;
import java.util.List;

@EventBusSubscriber(modid = OverhaulCraft.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void playerTick(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        Level level = event.getEntity().level();
        AABB bossMusicRange = new AABB(player.blockPosition()).inflate(150);
        AABB wofMusicRange = new AABB(player.blockPosition()).inflate(500);

        if (OverhaulCraft.CONFIG.playTerrariaMusic) {
            if (level.isClientSide()) {
                if (!level.getEntitiesOfClass(KingSlime.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.BOSS1, level);
                } else if (!level.getEntitiesOfClass(EyeOfCthulhu.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.BOSS1, level);
                } else if (!level.getEntitiesOfClass(EaterOfWorlds.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.BOSS1, level);
                } else if (!level.getEntitiesOfClass(BrainOfCthulhu.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.BOSS3, level);
                } else if (!level.getEntitiesOfClass(Skeletron.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.BOSS1, level);
                } else if (!level.getEntitiesOfClass(QueenBee.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.BOSS5, level);
                } else if (!level.getEntitiesOfClass(Deerclops.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.DEERCLOPS, level);
                } else if (!level.getEntitiesOfClass(WallOfFlesh.class, wofMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.BOSS2, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(SlimeRainGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.SLIME_RAIN, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(PumpkinMoonGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.PUMPKIN_MOON, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(FrostMoonGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.FROST_MOON, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(BloodMoonGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.EERIE, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(GoblinArmyGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.GOBLIN_ARMY, level);
                } else if (enoughOfBlocksForMusic(level, player, 10, OreBlocks.METEORITE_ORE.get())) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.EERIE, level);
                } else if (enoughOfBlocksForMusic(level, player, 15, DecorativeBlocks.GREEN_BRICKS.get(), DecorativeBlocks.BLUE_BRICKS.get(), DecorativeBlocks.PINK_BRICKS.get(), DecorativeBlocks.CRACKED_GREEN_BRICKS.get(), DecorativeBlocks.CRACKED_BLUE_BRICKS.get(), DecorativeBlocks.CRACKED_PINK_BRICKS.get()) && player.position().y() <= 35) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.DUNGEON, level);
                } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_TUNDRA)) && player.position().y() > 35) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.CRIMSON, level);
                } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_TUNDRA)) && player.position().y() <= 35) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.UNDERGROUND_CRIMSON, level);
                } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_TUNDRA)) && player.position().y() > 35) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.CORRUPTION, level);
                } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_TUNDRA)) && player.position().y() <= 35) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.UNDERGROUND_CORRUPTION, level);
                } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_TUNDRA)) && player.position().y() > 35) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.HALLOW, level);
                } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_TUNDRA)) && player.position().y() <= 35) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.UNDERGROUND_HALLOW, level);
                } else if (level.getBiome(player.blockPosition()).is(ModBiomes.GLOWING_MUSHROOM)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.MUSHROOM, level);
                } else if (isPlayerInHell(player)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.UNDERWORLD, level);
                } else if (player.position().y() <= 35 && isPlayerInOverworld(player)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.UNDERGROUND1, level);
                } else if (level.isRaining() && isPlayerInOverworld(player)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.RAIN, level);
                } else if (player.position().y() >= 180 && isPlayerInOverworld(player)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.SPACE, level);
                } else if (workingIsDay(level) && isPlayerInOverworld(player)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.DAY1, level);
                } else if (!workingIsDay(level) && isPlayerInOverworld(player)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftSounds.NIGHT, level);
                }
            }
        }
    }

    public static boolean workingIsDay(Level level) {
        return level.getDayTime() % 24000L < 15000L || level.getDayTime() % 24000L > 22500L;
    }

    public static boolean isPlayerInOverworld(Player player) {
        if (OverhaulCraft.CONFIG.alwaysPlayTerrariaMusic) {
            return true;
        } else {
            if (player.level().dimensionTypeRegistration().is(ResourceLocation.fromNamespaceAndPath("confluence_dimension_patch", "otherworld"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPlayerInHell(Player player) {
        if (OverhaulCraft.CONFIG.alwaysPlayTerrariaMusic) {
            if (player.level().dimensionTypeRegistration().is(ResourceLocation.fromNamespaceAndPath("minecraft", "the_nether")) || player.level().getBiome(player.getOnPos()) == ModBiomes.ASH_WASTELAND || player.level().getBiome(player.getOnPos()) == ModBiomes.ASH_FOREST) {
                return true;
            }
        } else {
            if (player.level().getBiome(player.getOnPos()) == ModBiomes.ASH_WASTELAND || player.level().getBiome(player.getOnPos()) == ModBiomes.ASH_FOREST) {
                return true;
            }
        }
        return false;
    }

    public static boolean enoughOfBlocksForMusic(Level level, Player player, int range, Block block) {
        int blockCount = 0;
        for(int x = -range; x < range; ++x) {
            for (int y = -range; y < range; ++y) {
                for (int z = -range; z < range; ++z) {
                    BlockPos pos2 = new BlockPos((int) (player.position().x() + x), (int) (player.position().y() + y), (int) (player.position().z() + z));
                    BlockState blockState = level.getBlockState(pos2);

                    if (blockState.is(block)) {
                        blockCount++;
                    }
                }
            }
        }
        System.out.println("Music Block Count: " + blockCount);
        if (blockCount >= range) {
            return true;
        }
        return false;
    }

    public static boolean enoughOfBlocksForMusic(Level level, Player player, int range, Block... block) {
        int blockCount = 0;
        List<Block> blockList = Arrays.stream(block).toList();

        for(int x = -range; x < range; ++x) {
            for (int y = -range; y < range; ++y) {
                for (int z = -range; z < range; ++z) {
                    BlockPos pos2 = new BlockPos((int) (player.position().x() + x), (int) (player.position().y() + y), (int) (player.position().z() + z));
                    BlockState blockState = level.getBlockState(pos2);

                    for (int l = 0; l < blockList.size(); l++) {
                        if (blockState.is(blockList.get(l))) {
                            blockCount++;
                        }
                    }
                }
            }
        }
        System.out.println("Music Block Count: " + blockCount);
        if (blockCount >= range) {
            return true;
        }
        return false;
    }
}
