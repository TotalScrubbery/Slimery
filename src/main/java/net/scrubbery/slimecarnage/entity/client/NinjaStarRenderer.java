package net.scrubbery.slimecarnage.entity.client;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractArrow;

public class NinjaStarRenderer<T extends AbstractArrow> extends ArrowRenderer
{
    public NinjaStarRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/item/ninjastar.png");
    }
}
