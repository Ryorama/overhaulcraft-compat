package com.ryorama.tstpcontent.mixins.structuregel;

import com.legacy.blue_skies.blocks.SkyPortalBlock;
import com.legacy.structure_gel.api.block.GelPortalBlock;
import com.legacy.structure_gel.api.dimension.portal.GelPortalLogic;
import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(GelPortalLogic.class)
public class GelPortalLogicMixin {

    @Shadow @Final public GelPortalBlock portal;

    /**
     * @author Ryorama
     * @reason Add custom config support
     */
    @Nullable
    @Overwrite(remap = false)
    public static boolean trySpawnPortal(Level level, BlockPos pos, GelPortalBlock portalBlock, List<Block> allowedInsideBlocks) {
        GelPortalLogic portal = GelPortalLogicAccessor.getPortalFrame(level, pos, portalBlock, allowedInsideBlocks);
        if (portalBlock instanceof SkyPortalBlock) {
            if (TstpContentMod.CONFIG.restrictDimensionTravelToPlanets) {
                return false;
            }
        }
        if (portal != null && portal.portalBlockCount == 0) {
            ((GelPortalLogicAccessor)portal).placePortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    @Mixin(GelPortalLogic.class)
    public interface GelPortalLogicAccessor {
        @Invoker("getPortalFrame")
        static GelPortalLogic getPortalFrame(Level level, BlockPos pos, GelPortalBlock portalBlock, List<Block> allowedInsideBlocks) {
            throw new AssertionError();
        }

        @Invoker("placePortalBlocks")
        void placePortalBlocks();
    }
}
