package com.ryorama.tstpcontent.inventory;

import com.mrcrayfish.furniture.refurbished.blockentity.IPowerSwitch;
import com.mrcrayfish.furniture.refurbished.inventory.IPowerSwitchMenu;
import com.mrcrayfish.furniture.refurbished.inventory.SimpleContainerMenu;
import com.ryorama.tstpcontent.init.TstpConentModMenuTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;

public class RFElectricityGeneratorMenu extends SimpleContainerMenu implements IPowerSwitchMenu {
    private final ContainerData data;

    public RFElectricityGeneratorMenu(int windowId, Inventory playerInventory) {
        this(windowId, playerInventory, new SimpleContainer(0), new SimpleContainerData(6));
    }

    public RFElectricityGeneratorMenu(int windowId, Inventory playerInventory, Container container, ContainerData data) {
        super(TstpConentModMenuTypes.RF_ELECTRICITY_GENERATOR.get(), windowId, container);
        checkContainerDataCount(data, 6);
        container.startOpen(playerInventory.player);
        this.data = data;
        this.addPlayerInventorySlots(8, 84, playerInventory);
        this.addDataSlots(data);
    }

    private boolean isFuel(ItemStack stack) {
        return false;
    }

    public int getEnergy() {
        return this.data.get(0);
    }

    public int getTotalEnergy() {
        return this.data.get(1);
    }

    public boolean isEnabled() {
        return this.data.get(2) != 0;
    }

    public boolean isOverloaded() {
        return this.data.get(3) != 0;
    }

    public boolean isPowered() {
        return this.data.get(4) != 0;
    }

    public int getNodeCount() {
        return this.data.get(5);
    }

    public void toggle() {
        Container var2 = this.container;
        if (var2 instanceof IPowerSwitch powerSwitch) {
            powerSwitch.togglePower();
        }

    }

    @Override
    public ItemStack quickMoveStack(Player arg, int i) {
        return null;
    }
}
