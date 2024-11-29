package com.ryorama.tstpcontent.mixins.twilightforest;

import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import twilightforest.TFConfig;
import twilightforest.TFTickHandler;
import twilightforest.init.custom.Enforcement;
import twilightforest.item.BrittleFlaskItem;
import twilightforest.util.LandmarkUtil;
import twilightforest.world.registration.TFGenerationSettings;

@Mixin(TFTickHandler.class)
public abstract class TFTickHandlerMixin {

    /**
     * @author Ryorama
     * @reason Add custom config support
     */
    @SubscribeEvent
    @Overwrite(remap = false)
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        Player eventPlayer = event.player;
        if (eventPlayer instanceof ServerPlayer player) {
            Level var4 = player.level();
            if (var4 instanceof ServerLevel world) {
                if (!TstpContentMod.CONFIG.restrictDimensionTravelToPlanets) {
                    if (!(Boolean) TFConfig.COMMON_CONFIG.disablePortalCreation.get() && event.phase == TickEvent.Phase.END && player.tickCount % (TFConfig.COMMON_CONFIG.checkPortalDestination.get() ? 100 : 20) == 0) {
                        if (TFConfig.COMMON_CONFIG.adminOnlyPortals.get()) {
                            if (world.getServer().getProfilePermissions(player.getGameProfile()) != 0) {
                                checkForPortalCreation(player, world, 4.0F);
                            }
                        } else {
                            checkForPortalCreation(player, world, 32.0F);
                        }
                    }
                }

                if (event.phase == TickEvent.Phase.END && player.tickCount % 20 == 0) {
                    BrittleFlaskItem.ticker();
                }

                if (event.phase == TickEvent.Phase.END && player.tickCount % 20 == 0 && LandmarkUtil.isProgressionEnforced(world) && TFGenerationSettings.usesTwilightChunkGenerator(world) && !player.isCreative() && !player.isSpectator()) {
                    Enforcement.enforceBiomeProgression(player, world);
                }

                if (event.phase == TickEvent.Phase.END && player.tickCount % 100 == 0 && LandmarkUtil.isProgressionEnforced(world) && TFGenerationSettings.usesTwilightChunkGenerator(world)) {
                    if (!player.isCreative() && !player.isSpectator()) {
                        TFTickHandlerAccessor.checkForLockedStructuresSendPacket(player, world);
                    } else {
                        sendAllClearPacket(player);
                    }
                }

            }
        }
    }

    @Shadow(remap = false)
    private static void sendAllClearPacket(Player player) {
    }

    @Shadow(remap = false)
    private static void checkForPortalCreation(ServerPlayer player, Level world, float rangeToCheck) {}

    @Mixin(TFTickHandler.class)
    public interface TFTickHandlerAccessor {
        @Invoker("checkForLockedStructuresSendPacket")
        private static boolean checkForLockedStructuresSendPacket(Player player, ServerLevel world) {
            throw new AssertionError();
        }
    }
}
