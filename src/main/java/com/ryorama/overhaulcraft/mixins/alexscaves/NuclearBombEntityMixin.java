//package com.ryorama.overhaulcraft.mixins.alexscaves;
//
//import com.github.alexmodguy.alexscaves.server.entity.item.NuclearBombEntity;
//import com.moulberry.mixinconstraints.annotations.IfModLoaded;
//import com.ryorama.overhaulcraft.OverhaulCraft;
//import com.ryorama.overhaulcraft.utils.ExtraFunc;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.level.Level;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
//
//@IfModLoaded("alexscaves")
//@Mixin(NuclearBombEntity.class)
//public abstract class NuclearBombEntityMixin extends Entity {
//
//    public NuclearBombEntityMixin(EntityType<?> entityType, Level level) {
//        super(entityType, level);
//    }
//
//    /**
//     * @author Ryorama
//     * @reason Add option for threaded explosion
//     */
//    @Overwrite(remap = false)
//    private void explode() {
//        ExtraFunc.createNukeExplosion(level(), this);
//    }
//}
