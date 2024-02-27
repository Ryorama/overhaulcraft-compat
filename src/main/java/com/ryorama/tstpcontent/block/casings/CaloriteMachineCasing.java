package com.ryorama.tstpcontent.block.casings;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class CaloriteMachineCasing extends Block {
    public CaloriteMachineCasing() {
        super(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL));
    }
}
