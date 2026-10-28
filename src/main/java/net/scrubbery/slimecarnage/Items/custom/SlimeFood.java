package net.scrubbery.slimecarnage.Items.custom;

import net.minecraft.world.food.FoodProperties;

public class SlimeFood
{
    public static final FoodProperties SLIME_BANANA = new FoodProperties.Builder().nutrition(4)
            .saturationModifier(0.3f).fast().build();
    public static final FoodProperties SLIME_PIZZA = new FoodProperties.Builder().nutrition(6)
            .saturationModifier(0.7f).fast().build();

}
