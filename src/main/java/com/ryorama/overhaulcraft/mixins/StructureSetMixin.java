package com.ryorama.overhaulcraft.mixins;


import com.ryorama.overhaulcraft.mixed.IStructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(StructureSet.class)
public abstract class StructureSetMixin implements IStructureSet {
    @Unique
    private boolean oc$notFromConfluence;

    @Override
    public void oc$setIsNotFromConfluence(boolean not) {
        this.oc$notFromConfluence = not;
    }

    @Override
    public boolean oc$isNotFromConfluence() {
        return oc$notFromConfluence;
    }

    @Unique
    private boolean oc$notFromCobblemon;

    @Override
    public void oc$setIsNotFromCobblemon(boolean not) {
        this.oc$notFromCobblemon = not;
    }

    @Override
    public boolean oc$isNotFromCobblemon() {
        return oc$notFromCobblemon;
    }
}