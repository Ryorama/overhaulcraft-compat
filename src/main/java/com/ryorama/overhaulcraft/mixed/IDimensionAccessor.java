package com.ryorama.overhaulcraft.mixed;

public interface IDimensionAccessor {
    void oc$setIsOverworld(boolean value);
    boolean oc$isOverworld();
    void oc$setIsConfluence(boolean value);
    boolean oc$isConfluence();
    void oc$setIsCobblemon(boolean value);
    boolean oc$isCobblemon();

    static IDimensionAccessor of(Object o) {
        return (IDimensionAccessor) o;
    }
}