package com.ryorama.overhaulcraft.events;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.OverhaulCraftClientConfig;
import com.ryorama.overhaulcraft.init.OverhaulCraftMusic;
import com.ryorama.overhaulcraft.utils.ExtraFunc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.confluence.mod.common.entity.boss.*;
import org.confluence.mod.common.gameevent.*;
import org.confluence.mod.common.init.ModBiomes;
import org.confluence.mod.common.init.block.DecorativeBlocks;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.block.OreBlocks;
import org.mesdag.confluence_dimension_patch.common.OtherWorld;

@EventBusSubscriber(modid = OverhaulCraft.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void playerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = event.getEntity().level();

        if (level.isClientSide()) {
            AABB bossMusicRange = new AABB(player.blockPosition()).inflate(150);
            AABB wofMusicRange = new AABB(player.blockPosition()).inflate(500);

            if (OverhaulCraftClientConfig.PLAY_BOSS_MUSIC.get()) {
                if (!level.getEntitiesOfClass(KingSlime.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.KING_SLIME, level);
                } else if (!level.getEntitiesOfClass(EyeOfCthulhu.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.BOSS1, level);
                } else if (!level.getEntitiesOfClass(EaterOfWorlds.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.EATER_OF_WORLDS, level);
                } else if (!level.getEntitiesOfClass(BrainOfCthulhu.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.BOSS3, level);
                } else if (!level.getEntitiesOfClass(Skeletron.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.SKELETRON, level);
                } else if (!level.getEntitiesOfClass(QueenBee.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.QUEEN_BEE, level);
                } else if (!level.getEntitiesOfClass(DeerClops.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.DEERCLOPS, level);
                } else if (!level.getEntitiesOfClass(WallOfFlesh.class, wofMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.BOSS2, level);
                } else if (!level.getEntitiesOfClass(TheDestroyer.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.THE_DESTROYER, level);
                } if (!level.getEntitiesOfClass(Retinazer.class, bossMusicRange).isEmpty() || !level.getEntitiesOfClass(Spazmatism.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.THE_TWINS, level);
                } else if (!level.getEntitiesOfClass(SkeletronPrime.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.SKELETRON_PRIME, level);
                } else if (!level.getEntitiesOfClass(LunaticCultist.class, bossMusicRange).isEmpty()) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.LUNATIC_CULTIST, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(SlimeRainGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.SLIME_RAIN, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(PumpkinMoonGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.PUMPKIN_MOON, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(FrostMoonGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.FROST_MOON, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(BloodMoonGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.EERIE, level);
                } else if (GameEventSystem.INSTANCE.isEventStarted(GoblinArmyGameEvent.KEY)) {
                    ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.GOBLIN_ARMY, level);
                } else if (ExtraFunc.canPlayTerrariaMusic(player) && player.level().dimension().equals(OtherWorld.LEVEL)) {
                    if (ExtraFunc.enoughOfBlocksForMusic(level, player, 10, OreBlocks.METEORITE_ORE.get())) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.EERIE, level);
                    } else if (ExtraFunc.enoughOfBlocksForMusic(level, player, 15, DecorativeBlocks.GREEN_BRICKS.FULL.get(), DecorativeBlocks.BLUE_BRICKS.FULL.get(), DecorativeBlocks.PINK_BRICKS.FULL.get(), DecorativeBlocks.CRACKED_GREEN_BRICKS.get(), DecorativeBlocks.CRACKED_BLUE_BRICKS.get(), DecorativeBlocks.CRACKED_PINK_BRICKS.get()) && player.position().y() <= 35) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.DUNGEON, level);
                    } else if (ExtraFunc.enoughOfBlocksForMusic(level, player, 15, ModBlocks.SHIMMER.get())) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.AETHER, level);
                    } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_TUNDRA)) && player.position().y() > 35) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.CRIMSON, level);
                    } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_TUNDRA)) && player.position().y() <= 35) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERGROUND_CRIMSON, level);
                    } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_TUNDRA)) && player.position().y() > 35) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.CORRUPTION, level);
                    } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_TUNDRA)) && player.position().y() <= 35) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERGROUND_CORRUPTION, level);
                    } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_TUNDRA)) && player.position().y() > 35) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.HALLOW, level);
                    } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_TUNDRA)) && player.position().y() <= 35) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERGROUND_HALLOW, level);
                    } else if (level.getBiome(player.blockPosition()).is(ModBiomes.GLOWING_MUSHROOM)) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.MUSHROOM, level);
                    } else if (ExtraFunc.isPlayerInHell(player)) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERWORLD, level);
                    } else if (player.position().y() <= 35) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERGROUND1, level);
                    } else if (level.isRaining()) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.RAIN, level);
                    } else if (player.position().y() >= 180) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.SPACE, level);
                    } else if (ExtraFunc.accurateIsDay(level)) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.DAY1, level);
                    } else if (!ExtraFunc.accurateIsDay(level)) {
                        ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.NIGHT, level);
                    } else if (ExtraFunc.canPlayTerrariaMusic(player) && player.level().dimension().equals(OtherWorld.LEVEL)) {
                        if (ExtraFunc.enoughOfBlocksForMusic(level, player, 10, OreBlocks.METEORITE_ORE.get())) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.EERIE, level);
                        } else if (ExtraFunc.enoughOfBlocksForMusic(level, player, 15, DecorativeBlocks.GREEN_BRICKS.FULL.get(), DecorativeBlocks.BLUE_BRICKS.FULL.get(), DecorativeBlocks.PINK_BRICKS.FULL.get(), DecorativeBlocks.CRACKED_GREEN_BRICKS.get(), DecorativeBlocks.CRACKED_BLUE_BRICKS.get(), DecorativeBlocks.CRACKED_PINK_BRICKS.get()) && player.position().y() <= 35) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.DUNGEON, level);
                        } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_TUNDRA)) && player.position().y() > 35) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.CRIMSON, level);
                        } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CRIMSON_TUNDRA)) && player.position().y() <= 35) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERGROUND_CRIMSON, level);
                        } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_TUNDRA)) && player.position().y() > 35) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.CORRUPTION, level);
                        } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_CORRUPTION_TUNDRA)) && player.position().y() <= 35) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERGROUND_CORRUPTION, level);
                        } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_TUNDRA)) && player.position().y() > 35) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.HALLOW, level);
                        } else if ((level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_DESERT) || level.getBiome(player.blockPosition()).is(ModBiomes.THE_HALLOW_TUNDRA)) && player.position().y() <= 35) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERGROUND_HALLOW, level);
                        } else if (level.getBiome(player.blockPosition()).is(ModBiomes.GLOWING_MUSHROOM)) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.MUSHROOM, level);
                        } else if (ExtraFunc.isPlayerInHell(player)) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERWORLD, level);
                        } else if (player.position().y() <= 35) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.UNDERGROUND1, level);
                        } else if (level.isRaining()) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.RAIN, level);
                        } else if (player.position().y() >= 180) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.SPACE, level);
                        } else if (ExtraFunc.accurateIsDay(level)) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.DAY1, level);
                        } else if (!ExtraFunc.accurateIsDay(level)) {
                            ExtraFunc.updateCurrentMusic(OverhaulCraftMusic.NIGHT, level);
                        }
                    } else {
                        ExtraFunc.stopCustomMusic(level);
                    }
                }
            }
        }
    }
}
