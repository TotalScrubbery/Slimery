package net.scrubbery.slimecarnage.Items.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class SlimeFood
{
    public static final FoodProperties SLIME_BANANA = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.1f).fast().build();
}
