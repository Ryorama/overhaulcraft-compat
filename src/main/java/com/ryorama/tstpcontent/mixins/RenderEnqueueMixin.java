package com.ryorama.tstpcontent.mixins;

import com.ryorama.tstpcontent.reference.OresRef;
import com.thevortex.potionsmaster.PotionsMaster;
import com.thevortex.potionsmaster.reference.Ores;
import com.thevortex.potionsmaster.render.util.BlockData;
import com.thevortex.potionsmaster.render.util.BlockInfo;
import com.thevortex.potionsmaster.render.util.BlockStore;
import com.thevortex.potionsmaster.render.util.WorldRegion;
import com.thevortex.potionsmaster.render.util.xray.Controller;
import com.thevortex.potionsmaster.render.util.xray.Render;
import com.thevortex.potionsmaster.render.util.xray.RenderEnqueue;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.*;

@Mixin(RenderEnqueue.class)
public class RenderEnqueueMixin {

    @Shadow(remap = false)
    private final WorldRegion box;

    public RenderEnqueueMixin(WorldRegion box) {
        this.box = box;
    }

    /**
     * @author Ryorama
     * @reason Add custom ores to the blockFinder
     */
    @Overwrite(remap = false)
    private void blockFinder() {
        HashMap<UUID, BlockData> blocks = Controller.getBlockStore().getStore();
        if (blocks.isEmpty() && !Render.ores.isEmpty()) {
            Render.ores.clear();
        }

        Level world = PotionsMaster.proxy.getClientPlayer().level();
        LocalPlayer player = PotionsMaster.proxy.getClientPlayer();
        List<BlockInfo> renderQueue = new ArrayList();

        for(int chunkX = this.box.minChunkX; chunkX <= this.box.maxChunkX; ++chunkX) {
            int x = chunkX << 4;
            int lowBoundX = x < this.box.minX ? this.box.minX - x : 0;
            int highBoundX = x + 15 > this.box.maxX ? this.box.maxX - x : 15;

            for(int chunkZ = this.box.minChunkZ; chunkZ <= this.box.maxChunkZ; ++chunkZ) {
                if (world.hasChunk(chunkX, chunkZ)) {
                    LevelChunk chunk = world.getChunk(chunkX, chunkZ);
                    LevelChunkSection[] extendsList = chunk.getSections();
                    int z = chunkZ << 4;
                    int lowBoundZ = z < this.box.minZ ? this.box.minZ - z : 0;
                    int highBoundZ = z + 15 > this.box.maxZ ? this.box.maxZ - z : 15;

                    for(int curExtend = this.box.minChunkY; curExtend <= this.box.maxChunkY; ++curExtend) {
                        LevelChunkSection ebs = extendsList[curExtend + (Math.abs(chunk.getMinBuildHeight()) >> 4)];
                        if (ebs != null) {
                            int y = curExtend << 4;
                            int lowBoundY = y < this.box.minY ? this.box.minY - y : 0;
                            int highBoundY = y + 15 > this.box.maxY ? this.box.maxY - y : 15;

                            for(int i = lowBoundX; i <= highBoundX; ++i) {
                                for(int j = lowBoundY; j <= highBoundY; ++j) {
                                    for(int k = lowBoundZ; k <= highBoundZ; ++k) {
                                        BlockState currentState = ebs.getBlockState(i, j, k);
                                        Optional<TagKey<Block>> firstTag = currentState.getTags().findFirst();
                                        if (firstTag.isPresent()) {
                                            TagKey<Block> block = firstTag.get();
                                            if (currentState.is(Ores.DIAMOND)) {
                                                block = Ores.DIAMOND;
                                            }

                                            if (currentState.is(Ores.LAPIS)) {
                                                block = Ores.LAPIS;
                                            }

                                            if (currentState.is(Ores.ALUMINIUM)) {
                                                block = Ores.ALUMINIUM;
                                            }

                                            if (currentState.is(Ores.COPPER)) {
                                                block = Ores.COPPER;
                                            }

                                            if (currentState.is(Ores.TIN)) {
                                                block = Ores.TIN;
                                            }

                                            if (currentState.is(Ores.LEAD)) {
                                                block = Ores.LEAD;
                                            }

                                            if (currentState.is(Ores.SILVER)) {
                                                block = Ores.SILVER;
                                            }

                                            if (currentState.is(Ores.GOLD)) {
                                                block = Ores.GOLD;
                                            }

                                            if (currentState.is(Ores.URANIUM)) {
                                                block = Ores.URANIUM;
                                            }

                                            if (currentState.is(Ores.NICKEL)) {
                                                block = Ores.NICKEL;
                                            }

                                            if (currentState.is(Ores.IRON)) {
                                                block = Ores.IRON;
                                            }

                                            if (currentState.is(Ores.OSMIUM)) {
                                                block = Ores.OSMIUM;
                                            }

                                            if (currentState.is(Ores.ZINC)) {
                                                block = Ores.ZINC;
                                            }

                                            if (currentState.is(Ores.EMERALD)) {
                                                block = Ores.EMERALD;
                                            }

                                            if (currentState.is(Ores.COAL)) {
                                                block = Ores.COAL;
                                            }

                                            if (currentState.is(Ores.REDSTONE)) {
                                                block = Ores.REDSTONE;
                                            }

                                            if (currentState.is(Ores.QUARTZ)) {
                                                block = Ores.QUARTZ;
                                            }

                                            if (currentState.is(Ores.BISMUTH)) {
                                                block = Ores.BISMUTH;
                                            }

                                            if (currentState.is(Ores.CRIMSONIRON)) {
                                                block = Ores.CRIMSONIRON;
                                            }

                                            if (currentState.is(Ores.PLATINUM)) {
                                                block = Ores.PLATINUM;
                                            }

                                            if (currentState.is(Ores.NETHERITE)) {
                                                block = Ores.NETHERITE;
                                            }

                                            if (currentState.is(Ores.ALLTHEMODIUM)) {
                                                block = Ores.ALLTHEMODIUM;
                                            }

                                            if (currentState.is(Ores.VIBRANIUM)) {
                                                block = Ores.VIBRANIUM;
                                            }

                                            if (currentState.is(Ores.UNOBTAINIUM)) {
                                                block = Ores.UNOBTAINIUM;
                                            }

                                            if (currentState.is(OresRef.RANDOMIUM)) {
                                                block = OresRef.RANDOMIUM;
                                            }

                                            BlockStore.BlockDataWithUUID dataWithUUID = Controller.getBlockStore().getStoreByReference(block.toString());
                                            if (dataWithUUID != null && dataWithUUID.getBlockData() != null && dataWithUUID.getBlockData().isDrawing()) {
                                                Math.max(0.0, (double)Controller.getRadius() - PotionsMaster.proxy.getClientPlayer().distanceToSqr(x + i, y + j, z + k) / (double)(Controller.getRadius() / 2));
                                                renderQueue.add(new BlockInfo(x + i, y + j, z + k, dataWithUUID.getBlockData().getColor().getColor(), 1.0));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        renderQueue.sort((t, t1) -> {
            return Double.compare(t1.distSqr(new Vec3i(player.getBlockX(), player.getBlockY(), player.getBlockZ())), t.distSqr(new Vec3i(player.getBlockX(), player.getBlockY(), player.getBlockZ())));
        });
        Render.ores.clear();
        Render.ores.addAll(renderQueue);
    }
}
