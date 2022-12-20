package com.themajorn.modulardungeons.common.entities;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Dynamic;
import com.themajorn.modulardungeons.common.ai.HobgoblinAI;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;


public class Hobgoblin extends Monster implements GeoAnimatable {

    protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES =
            ImmutableList.of(MemoryModuleType.PATH,
                    MemoryModuleType.LOOK_TARGET,
                    MemoryModuleType.WALK_TARGET);

    protected static final ImmutableList<SensorType<? extends Sensor<? super Hobgoblin>>> SENSOR_TYPES =
            ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES,
                    SensorType.NEAREST_PLAYERS,
                    SensorType.HURT_BY,
                    SensorType.NEAREST_ITEMS);


    protected Brain.@NotNull Provider<Hobgoblin> brainProvider() {
        return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
    }

    protected Brain<?> makeBrain(@NotNull Dynamic<?> dynamic) {
        return HobgoblinAI.makeBrain(this.brainProvider().makeBrain(dynamic));
    }

    public Brain<Hobgoblin> getBrain() {
        return (Brain<Hobgoblin>)super.getBrain();
    }
    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public Hobgoblin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.MOVEMENT_SPEED, .40)
                .add(Attributes.MAX_HEALTH, 30);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    public double getTick(Object object) {
        return 0;
    }

    @Override
    protected void customServerAiStep() {
        this.level.getProfiler().push("hobgoblinBrain");
        this.getBrain().tick((ServerLevel)this.level, this);
        this.level.getProfiler().pop();
        this.level.getProfiler().push("hobgoblinActivityUpdate");
        HobgoblinAI.updateActivity(this);
        this.level.getProfiler().pop();
        super.customServerAiStep();
    }
}
