/*
package com.ryorama.tstpcontent.block.entity.hauntedharvest;

import com.ryorama.tstpcontent.block.hauntedharvest.ModCarvedTaintedPumpkinBlock;
import net.mehvahdjukaar.hauntedharvest.blocks.ModCarvedPumpkinBlock;
import net.mehvahdjukaar.hauntedharvest.blocks.ModCarvedPumpkinBlockTile;
import net.mehvahdjukaar.hauntedharvest.blocks.PumpkinType;
import net.mehvahdjukaar.hauntedharvest.client.CarvingManager;
import net.mehvahdjukaar.hauntedharvest.client.gui.CarvingGui;
import net.mehvahdjukaar.hauntedharvest.configs.CommonConfigs;
import net.mehvahdjukaar.hauntedharvest.reg.ModRegistry;
import net.mehvahdjukaar.moonlight.api.client.model.ExtraModelData;
import net.mehvahdjukaar.moonlight.api.client.model.ModelDataKey;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ModCarvedTaintedPumpkinBlockTile extends ModCarvedPumpkinBlockTile {
    public static final ModelDataKey<CarvingManager.Key> CARVING = new ModelDataKey(CarvingManager.Key.class);
    private UUID owner = null;
    private boolean waxed = false;
    private boolean[][] pixels = new boolean[16][16];
    private CarvingManager.Key textureKey = null;

    public ModCarvedTaintedPumpkinBlockTile(BlockPos pos, BlockState state) {
        super((BlockEntityType) ModRegistry.MOD_CARVED_PUMPKIN_TILE.get(), pos, state);
        this.clear();
    }

    public PumpkinType getPumpkinType() {
        BlockState state = this.getBlockState();
        return ((ModCarvedTaintedPumpkinBlock)state.getBlock()).getType(state);
    }

    public ExtraModelData getExtraModelData() {
        return ExtraModelData.builder().with(CARVING, this.getTextureKey()).build();
    }

    public CarvingManager.Key getTextureKey() {
        if (this.textureKey == null) {
            this.refreshTextureKey();
        }

        return this.textureKey;
    }

    public void refreshTextureKey() {
        this.textureKey = CarvingManager.Key.of(packPixels(this.pixels), this.getPumpkinType());
    }

    public void afterDataPacket(ExtraModelData oldData) {
        this.refreshTextureKey();
        super.afterDataPacket(oldData);
    }

    public void setChanged() {
        if (this.level != null && !this.level.isClientSide) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
            super.setChanged();
        }
    }

    public void load(CompoundTag compound) {
        super.load(compound);
        this.loadOwner(compound);
        this.waxed = compound.contains("Waxed") && compound.getBoolean("Waxed");
        this.acceptPixels(compound.getLongArray("Pixels"));
    }

    public void acceptPixels(long[] p) {
        this.pixels = new boolean[16][16];
        if (p.length != 0) {
            this.pixels = unpackPixels(p);
        }

    }

    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        this.savePixels(compound);
        this.saveOwner(compound);
    }

    public CompoundTag savePixels(CompoundTag compound) {
        if (this.waxed) {
            compound.putBoolean("Waxed", true);
        }

        compound.putLongArray("Pixels", packPixels(this.pixels));
        return compound;
    }

    public static long[] packPixels(boolean[][] pixels) {
        long[] packed = new long[4];
        long n = 0L;
        int ind = 0;

        for(int a = 0; a < pixels.length; ++a) {
            int s = 0;

            for(int i = 0; i < pixels.length; ++i) {
                s |= (toShort(pixels[a][i]) & 1) << i;
            }

            n |= (long)s << a % 4 * 16;
            if ((a + 1) % 4 == 0) {
                packed[ind] = n;
                n = 0L;
                ++ind;
            }
        }

        return packed;
    }

    private static short toShort(boolean b) {
        return (short)(b ? 1 : 0);
    }

    private static boolean toBoolean(short b) {
        return b == 1;
    }

    public static boolean[][] unpackPixels(long[] packed) {
        boolean[][] bytes = new boolean[16][16];
        int k = 0;
        long[] var3 = packed;
        int var4 = packed.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            long l = var3[var5];

            for(int j = 0; j < 4; ++j) {
                for(int i = 0; i < 16; ++i) {
                    bytes[k][i] = toBoolean((short)((int)(l >> i + j * 16 & 1L)));
                }

                ++k;
            }
        }

        return bytes;
    }

    public void clear() {
        for(int x = 0; x < this.pixels.length; ++x) {
            for(int y = 0; y < this.pixels[x].length; ++y) {
                this.pixels[x][y] = false;
            }
        }

    }

    public boolean isEmpty() {
        boolean[][] var1 = this.pixels;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            boolean[] pixel = var1[var3];
            boolean[] var5 = pixel;
            int var6 = pixel.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                boolean b = var5[var7];
                if (b) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setPixel(int x, int y, boolean b) {
        this.pixels[x][y] = b;
    }

    public boolean getPixel(int xx, int yy) {
        return this.pixels[xx][yy];
    }

    public void setPixels(boolean[][] pixels) {
        this.pixels = pixels;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    public Direction getDirection() {
        return this.getBlockState().getValue(ModCarvedTaintedPumpkinBlock.FACING);
    }

    public @Nullable UUID getOwner() {
        return this.owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public void openScreen(Level level, BlockPos pos, Player player) {
        CarvingGui.open(this, player.getDirection().getOpposite());
    }

    public void setWaxed(boolean b) {
        this.waxed = b;
    }

    public boolean isWaxed() {
        return this.waxed;
    }

    public ModCarvedPumpkinBlock.CarveMode getCarveMode() {
        return this.getPumpkinType().isJackOLantern() ? CommonConfigs.JACK_O_LANTERN_CARVE_MODE.get() : CommonConfigs.PUMPKIN_CARVE_MODE.get();
    }

    public ItemStack getItemWithNBT() {
        ItemStack itemstack = new ItemStack(this.getBlockState().getBlock());
        if (!this.isEmpty()) {
            CompoundTag tag = this.savePixels(new CompoundTag());
            if (!tag.isEmpty()) {
                itemstack.addTagElement("BlockEntityTag", tag);
            }
        }

        return itemstack;
    }
}
 */