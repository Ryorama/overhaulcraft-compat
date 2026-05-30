package com.ryorama.overhaulcraft.mixed;

public interface IDimensionAccessor {
    void oc$setIsNotOverworld();
    boolean oc$isNotOverworld();
    default boolean oc$isOverworld() {
        return !oc$isNotOverworld();
    }
    void oc$setIsConfluence();
    boolean oc$isConfluence();
    void oc$setIsCobblemon();
    boolean oc$isCobblemon();

    static IDimensionAccessor of(Object o) {
        return (IDimensionAccessor) o;
    }
}
