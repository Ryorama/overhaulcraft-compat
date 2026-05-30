package com.ryorama.overhaulcraft.mixed;

import net.minecraft.world.level.levelgen.structure.StructureSet;

public interface IStructureSet {
    void oc$setIsNotFromCobblemon(boolean not);

    boolean oc$isNotFromCobblemon();

    void oc$setIsNotFromConfluence(boolean not);

    boolean oc$isNotFromConfluence();

    static IStructureSet of(StructureSet value) {
        return (IStructureSet) (Record) value;
    }
}
