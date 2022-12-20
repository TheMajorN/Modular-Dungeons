package com.themajorn.modulardungeons.client.models;

import com.themajorn.modulardungeons.ModularDungeons;
import com.themajorn.modulardungeons.common.entities.Hobgoblin;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HobgoblinModel extends GeoModel<Hobgoblin> {
    @Override
    public ResourceLocation getModelResource(Hobgoblin animatable) {
        return new ResourceLocation(ModularDungeons.MODID, "geo/goblin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Hobgoblin animatable) {
        return new ResourceLocation(ModularDungeons.MODID , "textures/entities/goblin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Hobgoblin animatable) {
        return new ResourceLocation(ModularDungeons.MODID, "animations/goblin.animation.json");
    }
}
