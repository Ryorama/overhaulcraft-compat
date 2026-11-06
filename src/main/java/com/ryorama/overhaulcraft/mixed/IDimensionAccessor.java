package com.ryorama.overhaulcraft.mixed;

public interface IDimensionAccessor {
    void oc$setIsNotReplacable();
    boolean oc$IsNotReplacable();
    void oc$setIsConfluence();
    boolean oc$isConfluence();
    void oc$setIsCobblemon();
    boolean oc$isCobblemon();

    static IDimensionAccessor of(Object o) {
        return (IDimensionAccessor) o;
    }
}