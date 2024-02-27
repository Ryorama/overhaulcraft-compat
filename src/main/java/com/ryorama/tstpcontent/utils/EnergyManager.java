package com.ryorama.tstpcontent.utils;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;

public class EnergyManager extends EnergyStorage {
    private boolean canExtract = true;

    public EnergyManager(int maxTransfer, int capacity) {
        super(capacity, maxTransfer, maxTransfer);
    }

    public int getMaxExtract() {
        return maxExtract;
    }

    public void setReceiveOnly() {
        canExtract = false;
    }

    public int getMaxEnergyReceived() {
        return this.maxReceive;
    }

    public void drainEnergy(int amount) {
        setEnergyStored(energy - amount);
    }

    public void addEnergy(int amount) {
        setEnergyStored(energy + amount);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergyStored(int energyStored) {
        this.energy = energyStored;
        if (this.energy > capacity) {
            this.energy = capacity;
        } else if (this.energy < 0) {
            this.energy = 0;
        }
    }

    public <T> LazyOptional<T> getCapability(Capability<T> capability) {
        if (capability == ForgeCapabilities.ENERGY) {
            return LazyOptional.of(() -> this).cast();
        }

        return LazyOptional.empty();
    }
}