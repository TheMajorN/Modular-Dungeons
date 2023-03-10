package com.themajorn.modulardungeons.client.models;

import com.themajorn.modulardungeons.ModularDungeons;
import com.themajorn.modulardungeons.common.entities.Goblin;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoblinModel extends GeoModel<Goblin> {
    @Override
    public ResourceLocation getModelResource(Goblin animatable) {
        return new ResourceLocation(ModularDungeons.MODID, "geo/goblin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Goblin animatable) {
        return new ResourceLocation(ModularDungeons.MODID , "textures/entities/goblin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Goblin animatable) {
        return new ResourceLocation(ModularDungeons.MODID, "animations/goblin.animation.json");
    }
}
