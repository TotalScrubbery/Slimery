package net.scrubbery.slimecarnage.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.entity.ModEntities;

import java.util.List;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> SPAWN_ORANGE_SLIME = registerKey("spawnorange");
    public static final ResourceKey<BiomeModifier> SPAWN_YELLOW_SLIME = registerKey("spawnyellow");
    public static final ResourceKey<BiomeModifier> SPAWN_RED_SLIME = registerKey("spawnred");
    public static final ResourceKey<BiomeModifier> SPAWN_BLUE_SLIME = registerKey("spawnblue");
    public static final ResourceKey<BiomeModifier> SPAWN_GREEN_SLIME = registerKey("spawngreen");
    public static final ResourceKey<BiomeModifier> SPAWN_CAMO_SLIME = registerKey("spawncamo");
    public static final ResourceKey<BiomeModifier> SPAWN_CACTUS_SLIME = registerKey("spawncactus");
    public static final ResourceKey<BiomeModifier> SPAWN_MONKEY_SLIME = registerKey("spawnmonkey");
    public static final ResourceKey<BiomeModifier> SPAWN_CAVE_SLIME = registerKey("spawncave");
    public static final ResourceKey<BiomeModifier> SPAWN_FIERY_SLIME = registerKey("spawnfiery");
    public static final ResourceKey<BiomeModifier> SPAWN_MOO_SLIME = registerKey("spawnmoo");
    public static final ResourceKey<BiomeModifier> SPAWN_UNDER_SLIME = registerKey("spawnunder");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        //var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_ORANGE_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BADLANDS), biomes.getOrThrow(Biomes.GROVE), biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS), biomes.getOrThrow(Biomes.FLOWER_FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBORANGESLIME.get(), 18, 1, 3))));

        context.register(SPAWN_YELLOW_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BEACH), biomes.getOrThrow(Biomes.DESERT)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBYELLOWSLIME.get(), 18, 1, 3))));

        context.register(SPAWN_BLUE_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.STONY_PEAKS), biomes.getOrThrow(Biomes.WINDSWEPT_HILLS), biomes.getOrThrow(Biomes.JAGGED_PEAKS)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBBLUESLIME.get(), 18, 1, 3))));

        context.register(SPAWN_RED_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBREDSLIME.get(), 18, 1, 3))));

        context.register(SPAWN_GREEN_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.MANGROVE_SWAMP), biomes.getOrThrow(Biomes.SWAMP)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBGREENSLIME.get(), 12, 1, 3))));

        context.register(SPAWN_CAMO_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBCAMOSLIME.get(), 16, 1, 2))));

        context.register(SPAWN_CACTUS_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBCACTUSSLIME.get(), 18, 1, 2))));

        context.register(SPAWN_MONKEY_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBMONKEYSLIME.get(), 16, 1, 2))));

        context.register(SPAWN_CAVE_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.BIRCH_FOREST), biomes.getOrThrow(Biomes.FOREST),biomes.getOrThrow(Biomes.DESERT), biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA),biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.MEADOW), biomes.getOrThrow(Biomes.BADLANDS), biomes.getOrThrow(Biomes.SNOWY_PLAINS)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBCAVESLIME.get(), 14, 1, 3))));

        context.register(SPAWN_FIERY_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.CRIMSON_FOREST), biomes.getOrThrow(Biomes.NETHER_WASTES)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBCAVESLIME.get(), 14, 1, 3))));

        context.register(SPAWN_MOO_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.MUSHROOM_FIELDS)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBMOOSLIME.get(), 18, 1, 3))));

        context.register(SPAWN_UNDER_SLIME, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.BIRCH_FOREST), biomes.getOrThrow(Biomes.FOREST),biomes.getOrThrow(Biomes.DESERT), biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA),biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.MEADOW), biomes.getOrThrow(Biomes.BADLANDS), biomes.getOrThrow(Biomes.SNOWY_PLAINS)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MOBCAVESLIME.get(), 14, 1, 3))));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(SlimeCarnage.MOD_ID, name));
    }
}