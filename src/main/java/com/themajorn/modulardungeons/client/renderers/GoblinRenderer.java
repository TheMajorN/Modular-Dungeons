package com.themajorn.modulardungeons.client.renderers;

import com.themajorn.modulardungeons.client.models.GoblinModel;
import com.themajorn.modulardungeons.common.entities.Goblin;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GoblinRenderer extends GeoEntityRenderer<Goblin> {
    public GoblinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoblinModel());
    }

}
