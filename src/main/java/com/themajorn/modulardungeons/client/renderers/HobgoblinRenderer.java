package com.themajorn.modulardungeons.client.renderers;

import com.themajorn.modulardungeons.client.models.HobgoblinModel;
import com.themajorn.modulardungeons.common.entities.Hobgoblin;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HobgoblinRenderer extends GeoEntityRenderer<Hobgoblin> {
    public HobgoblinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HobgoblinModel());
    }

}
