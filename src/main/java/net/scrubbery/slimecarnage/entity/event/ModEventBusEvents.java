package net.scrubbery.slimecarnage.entity.event;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.entity.ModEntities;
import net.scrubbery.slimecarnage.entity.slimes.*;

@EventBusSubscriber(modid = SlimeCarnage.MOD_ID,
        value = {Dist.CLIENT})
public class ModEventBusEvents
{

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MOBORANGESLIME.get(), EntityOrangeSlime.createAttributes().build());
        event.put(ModEntities.MOBYELLOWSLIME.get(), EntityYellowSlime.createAttributes().build());
        event.put(ModEntities.MOBREDSLIME.get(), EntityRedSlime.createAttributes().build());
        event.put(ModEntities.MOBBLUESLIME.get(), EntityBlueSlime.createAttributes().build());
        event.put(ModEntities.MOBGREENSLIME.get(), EntityGreenSlime.createAttributes().build());
        event.put(ModEntities.MOBCAMOSLIME.get(), EntityCamoSlime.createAttributes().build());
        event.put(ModEntities.MOBCACTUSSLIME.get(), EntityCactusSlime.createAttributes().build());
        event.put(ModEntities.MOBMONKEYSLIME.get(), EntityMonkeySlime.createAttributes().build());
        event.put(ModEntities.MOBCAVESLIME.get(), EntityCaveSlime.createAttributes().build());
        event.put(ModEntities.MOBFIERYSLIME.get(), EntityFierySlime.createAttributes().build());
        event.put(ModEntities.MOBMOOSLIME.get(), EntityMooSlime.createAttributes().build());
        event.put(ModEntities.MOBUNDERSLIME.get(), EntityUnderSlime.createAttributes().build());

        event.put(ModEntities.NPCOLDMANSLIME.get(), EntityOldManSlime.createMobAttributes().build());
        event.put(ModEntities.NPCDOCSLIME.get(), EntityDocSlime.createMobAttributes().build());
        event.put(ModEntities.NPCMARIOSLIME.get(), EntityDocSlime.createMobAttributes().build());
        event.put(ModEntities.NPCLUIGISLIME.get(), EntityDocSlime.createMobAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawns(RegisterSpawnPlacementsEvent event)
    {
        event.register(ModEntities.MOBORANGESLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBYELLOWSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBBLUESLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBREDSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBGREENSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBCAMOSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBCACTUSSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBMONKEYSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBCAVESLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                EntityCaveSlime::checkTheSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBFIERYSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBMOOSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBUNDERSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                EntityUnderSlime::checkTheSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

}


