package com.ryorama.tstpcontent.block.casings;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class OstrumMachineCasing extends Block {
    public OstrumMachineCasing() {
        super(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL));
    }
}
