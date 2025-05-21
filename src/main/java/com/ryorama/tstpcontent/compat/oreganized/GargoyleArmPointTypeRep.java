package com.ryorama.tstpcontent.compat.oreganized;

import com.simibubi.create.content.kinetics.mechanicalArm.AllArmInteractionPointTypes;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmInteractionPoint;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmInteractionPointType;
import galena.oreganized.Oreganized;
import galena.oreganized.content.entity.GargoyleBlockEntity;
import galena.oreganized.index.OBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GargoyleArmPointTypeRep extends ArmInteractionPointType {
    public GargoyleArmPointTypeRep() {
        super(Oreganized.modLoc("gargoyle"));
    }

    public boolean canCreatePoint(Level level, BlockPos pos, BlockState state) {
        return state.is(OBlocks.GARGOYLE.get());
    }

    public @Nullable ArmInteractionPoint createPoint(Level level, BlockPos pos, BlockState state) {
        return new GargoyleArmPointTypeRep.Point(level, pos, state);
    }

    public class Point extends AllArmInteractionPointTypes.DepositOnlyArmInteractionPoint {
        public Point(Level level, BlockPos pos, BlockState state) {
            super(GargoyleArmPointTypeRep.this, level, pos, state);
        }

        public ItemStack insert(ItemStack stack, boolean simulate) {
            BlockEntity blockEntity = this.level.getBlockEntity(this.pos);
            if (blockEntity instanceof GargoyleBlockEntity gargoyle) {
                ItemStack cloned = stack.copy();
                gargoyle.interact(this.level, this.pos, null, cloned, simulate);
                return cloned;
            } else {
                return stack;
            }
        }
    }
}
