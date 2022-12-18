package com.themajorn.modulardungeons.client.mobrenderevents;

import com.themajorn.modulardungeons.ModularDungeons;
import com.themajorn.modulardungeons.common.entities.Goblin;
import com.themajorn.modulardungeons.core.registry.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModularDungeons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class EntityRenderer {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GOBLIN.get(), Goblin.createAttributes().build());
    }

}
