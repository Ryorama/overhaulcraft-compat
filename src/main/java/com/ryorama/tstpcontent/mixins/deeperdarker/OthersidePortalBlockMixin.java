package com.ryorama.tstpcontent.mixins.deeperdarker;

import com.kyanite.deeperdarker.content.blocks.OthersidePortalBlock;
import com.ryorama.tstpcontent.TstpContentMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(OthersidePortalBlock.class)
public abstract class OthersidePortalBlockMixin {

    /**
     * @author Ryorama
     * @reason Add custom config support
     */
    @Overwrite(remap = false)
    public boolean spawnPortal(LevelAccessor worldIn, BlockPos pos) {
        OthersidePortalBlock.OthersidePortalShape portal = this.isPortal(worldIn, pos);
        if (!TstpContentMod.CONFIG.restrictDimensionTravelToPlanets) {
            if (portal != null && !OthersidePortalBlockAccessor.trySpawningPortal(worldIn, pos, portal)) {
                portal.createPortalBlocks();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Shadow(remap = false)
    public abstract OthersidePortalBlock.OthersidePortalShape isPortal(LevelAccessor level, BlockPos pos);

    @Mixin(OthersidePortalBlock.class)
    public interface OthersidePortalBlockAccessor {
        @Invoker("trySpawningPortal")
        static boolean trySpawningPortal(LevelAccessor world, BlockPos pos, OthersidePortalBlock.OthersidePortalShape portal) {
            throw new AssertionError();
        }
    }
}