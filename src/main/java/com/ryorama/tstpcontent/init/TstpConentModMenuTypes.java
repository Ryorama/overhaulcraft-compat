package com.ryorama.tstpcontent.init;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import com.mrcrayfish.furniture.refurbished.util.Utils;
import com.ryorama.tstpcontent.inventory.RFElectricityGeneratorMenu;
import net.minecraft.world.inventory.MenuType;

@RegistryContainer
public class TstpConentModMenuTypes {
    public static final RegistryEntry<MenuType<RFElectricityGeneratorMenu>> RF_ELECTRICITY_GENERATOR = RegistryEntry.menuType(Utils.resource("rf_electricity_generator"), RFElectricityGeneratorMenu::new);;
}
