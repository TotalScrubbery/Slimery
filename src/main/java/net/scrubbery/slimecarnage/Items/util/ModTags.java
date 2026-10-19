package net.scrubbery.slimecarnage.Items.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.minecraft.resources.ResourceLocation;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_SLIME_TOOL = createTag("needs_slime_tool");
        public static final TagKey<Block> INCORRECT_FOR_SLIME_TOOL = createTag("incorrect_for_slime_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(SlimeCarnage.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(SlimeCarnage.MOD_ID, name));
        }
    }
}