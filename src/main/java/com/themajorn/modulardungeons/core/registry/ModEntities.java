package com.themajorn.modulardungeons.core.registry;

import com.themajorn.modulardungeons.ModularDungeons;
import com.themajorn.modulardungeons.common.entities.Goblin;
import com.themajorn.modulardungeons.common.entities.Hobgoblin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModularDungeons.MODID);

    public static final RegistryObject<EntityType<Goblin>> GOBLIN = ENTITIES.register("goblin",
            () -> EntityType.Builder.of(Goblin::new, MobCategory.MONSTER)
                .sized(1.5f,1.5f) //temporary size
                .build(new ResourceLocation(ModularDungeons.MODID, "goblin").toString()));

    public static final RegistryObject<EntityType<Hobgoblin>> HOBGOBLIN = ENTITIES.register("hobgoblin",
            () -> EntityType.Builder.of(Hobgoblin::new, MobCategory.MONSTER)
                    .sized(1.5f,1.5f) //temporary size
                    .build(new ResourceLocation(ModularDungeons.MODID, "hobgoblin").toString()));
}
