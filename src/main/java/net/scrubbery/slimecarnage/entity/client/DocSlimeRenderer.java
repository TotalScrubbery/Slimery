package net.scrubbery.slimecarnage.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.client.renderer.entity.layers.SlimeOuterLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Slime;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.entity.slimes.EntityDocSlime;

@OnlyIn(Dist.CLIENT)
public class DocSlimeRenderer extends MobRenderer<EntityDocSlime, SlimeModel<EntityDocSlime>>
{

    public DocSlimeRenderer(EntityRendererProvider.Context er) {
        super(er, new SlimeModel<>(er.bakeLayer(ModelLayers.SLIME)), 0.25F);
        this.addLayer(new SlimeOuterLayer(this, er.getModelSet()));
    }
    @Override
    public ResourceLocation getTextureLocation(EntityDocSlime entity)
    {
        return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/docslime.png");
    }
    @Override
    public void render(EntityDocSlime entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.shadowRadius = 0.25F * (float)entity.getSize();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
    @Override
    protected void scale(EntityDocSlime livingEntity, PoseStack poseStack, float partialTickTime) {
        float f = 0.999F;
        poseStack.scale(0.999F, 0.999F, 0.999F);
        poseStack.translate(0.0F, 0.001F, 0.0F);
        float f1 = (float)livingEntity.getSize();
        float f2 = Mth.lerp(partialTickTime, livingEntity.oSquish, livingEntity.squish) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

}
