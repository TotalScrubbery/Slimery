package net.scrubbery.slimecarnage.Items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.scrubbery.slimecarnage.Items.util.ModTags;

public class SlimeTiers
{
    public static final Tier SLIME = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SLIME_TOOL,
            1337, 7f, 3f, 20, () -> Ingredient.of(ModItems.BLUEGEL));

}
