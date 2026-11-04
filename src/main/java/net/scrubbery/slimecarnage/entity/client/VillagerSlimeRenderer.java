package net.scrubbery.slimecarnage.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SlimeOuterLayer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.scrubbery.slimecarnage.entity.slimes.EntityVillagerSlime;

@OnlyIn(Dist.CLIENT)
public class VillagerSlimeRenderer extends MobRenderer<EntityVillagerSlime, SlimeModel<EntityVillagerSlime>>
{

    public VillagerSlimeRenderer(EntityRendererProvider.Context er) {
        super(er, new SlimeModel<>(er.bakeLayer(ModelLayers.SLIME)), 0.25F);
        this.addLayer(new SlimeOuterLayer(this, er.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityVillagerSlime entity)
    {
        switch (entity.getVillagerData().getProfession().toString()) {
            case "farmer":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/farmerslime.png");
            case "librarian":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/profslime.png");
            case "cleric":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/priestslime.png");
            case "mason":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/smithslime.png");
            case "butcher":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/butcherslime.png");
            case "armorer":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/armorerslime.png");
            case "cartographer":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/cartographerslime.png");
            case "fisherman":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/farmerslime.png");
            case "fletcher":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/villagerslime.png");
            case "leatherworker":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/villagerslime.png");
            case "shepherd":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/farmerslime.png");
            case "toolsmith":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/smithslime.png");
            case "weaponsmith":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/smithslime.png");
            case "nitwit":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/nitwitslime.png");
            case "slimer":
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/slimerslime.png");
            default:
                return ResourceLocation.fromNamespaceAndPath("slimecarnage", "textures/entity/slime/villagerslime.png");
        }
    }
    @Override
    public void render(EntityVillagerSlime entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.shadowRadius = 0.25F;
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
    @Override
    protected void scale(EntityVillagerSlime livingEntity, PoseStack poseStack, float partialTickTime) {
        float f = 0.999F;
        poseStack.scale(0.999F, 0.999F, 0.999F);
        poseStack.translate(0.0F, 0.001F, 0.0F);
        float f1 = 1.0F;
        float f2 = 1.0F;
        float f3 = 1.0F;
        poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

}
