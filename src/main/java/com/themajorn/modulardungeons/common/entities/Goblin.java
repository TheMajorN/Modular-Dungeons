package com.themajorn.modulardungeons.common.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;


public class Goblin extends Monster implements IAnimatable{

    public Goblin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 2)
                                                .add(Attributes.FOLLOW_RANGE, 20)
                                                .add(Attributes.MOVEMENT_SPEED, .27)
                                                .add(Attributes.MAX_HEALTH, 14);
    }
}
