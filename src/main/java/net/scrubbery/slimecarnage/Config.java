package net.scrubbery.slimecarnage;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    static final ModConfigSpec SPEC = BUILDER.build();

    public static final ModConfigSpec.IntValue SPAWN_RATE = BUILDER
                .comment("Lower number means less spawns, set to 0 for no spawns")
                .translation("config.slimecarnage.spawn_rate")
                .defineInRange("spawn_rate", 100, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue MIN_IN_GROUP = BUILDER
            .comment("Minimum amount of slimes in a group that spawns")
            .translation("config.slimecarnage.min_in_group")
            .defineInRange("min_in_group", 1, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue MAX_IN_GROUP = BUILDER
            .comment("Maximum amount of slimes in a group that spawns")
            .translation("config.slimecarnage.max_in_group")
            .defineInRange("max_in_group", 3, 0, Integer.MAX_VALUE);

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }
}
