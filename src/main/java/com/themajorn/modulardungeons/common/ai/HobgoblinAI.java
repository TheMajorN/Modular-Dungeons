package com.themajorn.modulardungeons.common.ai;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.themajorn.modulardungeons.common.entities.Hobgoblin;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.schedule.Activity;

public class HobgoblinAI {
    public static Brain<?> makeBrain(Brain<Hobgoblin> brain) {
        initCoreActivity(brain);
        initIdleActivity(brain);
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.useDefaultActivity();
        return brain;
    }
    private static void initCoreActivity(Brain<Hobgoblin> brain) {
        brain.addActivity(Activity.CORE, 0,
                ImmutableList.of(
                        new LookAtTargetSink(45, 90),
                        new MoveToTargetSink()
                ));
    }

    private static void initIdleActivity(Brain<Hobgoblin> brain) {
        brain.addActivityWithConditions(Activity.IDLE,
                ImmutableList.of(
                        //Pair.of(1, SetEntityLookTargetSometimes.create(EntityType.PLAYER, 6.0F, UniformInt.of(30, 60))),
                        Pair.of(1, new RunOne<>(
                                ImmutableList.of(
                                        Pair.of(RandomStroll.stroll(1.0F), 2),
                                        Pair.of(SetWalkTargetFromLookTarget.create(1.0F, 3), 2),
                                        Pair.of(new DoNothing(30, 60), 1))))),
                ImmutableSet.of());
    }

    public static void updateActivity(Hobgoblin hobgoblin) {
        hobgoblin.getBrain().setActiveActivityToFirstValid(
                ImmutableList.of(
                        Activity.IDLE));
    }
}
