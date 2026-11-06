package com.ryorama.overhaulcraft.init;

import com.ryorama.overhaulcraft.OverhaulCraft;
import com.ryorama.overhaulcraft.world.filter.OnlyInCobblemonPlacementFilter;
import com.ryorama.overhaulcraft.world.placement.OnlyInCobblemonStructurePlacement;
import com.ryorama.overhaulcraft.world.placement.OnlyInOtherworldStructurePlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OverhaulCraftPlacements {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER_TYPES = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, OverhaulCraft.MODID);
    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<OnlyInCobblemonPlacementFilter>> ONLY_IN_COBBLEMON_PLACEMENT_FILTER = PLACEMENT_MODIFIER_TYPES.register("only_in_cobblemon", () -> () -> OnlyInCobblemonPlacementFilter.CODEC);

    public static final DeferredRegister<StructurePlacementType<?>> STRUCTURE_PLACEMENT_TYPES = DeferredRegister.create(Registries.STRUCTURE_PLACEMENT, OverhaulCraft.MODID);
    public static final DeferredHolder<StructurePlacementType<?>, StructurePlacementType<OnlyInOtherworldStructurePlacement>> ONLY_IN_OTHERWORLD_STRUCTURE_PLACEMENT = STRUCTURE_PLACEMENT_TYPES.register("only_in_otherworld", () -> () -> OnlyInOtherworldStructurePlacement.CODEC);
    public static final DeferredHolder<StructurePlacementType<?>, StructurePlacementType<OnlyInCobblemonStructurePlacement>> ONLY_IN_COBBLEMON_STRUCTURE_PLACEMENT = STRUCTURE_PLACEMENT_TYPES.register("only_in_cobblemon", () -> () -> OnlyInCobblemonStructurePlacement.CODEC);
}
