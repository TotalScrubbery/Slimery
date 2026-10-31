package net.scrubbery.slimecarnage.entity.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.scrubbery.slimecarnage.Items.ModItems;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.entity.ModEntities;
import net.scrubbery.slimecarnage.entity.slimes.*;
import net.scrubbery.slimecarnage.village.SlimeVillagers;

import java.util.List;

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
        event.put(ModEntities.MOBSNOWSLIME.get(), EntitySnowSlime.createAttributes().build());
        event.put(ModEntities.MOBVAMPIRESLIME.get(), EntityVampireSlime.createAttributes().build());
        event.put(ModEntities.MOBICESLIME.get(), EntityIceSlime.createAttributes().build());
        event.put(ModEntities.MOBNINJASLIME.get(), EntityNinjaSlime.createAttributes().build());
        event.put(ModEntities.MOBMUMMYSLIME.get(), EntityMummySlime.createAttributes().build());

        event.put(ModEntities.NPCOLDMANSLIME.get(), EntityOldManSlime.createMobAttributes().build());
        event.put(ModEntities.NPCDOCSLIME.get(), EntityDocSlime.createMobAttributes().build());
        event.put(ModEntities.NPCMARIOSLIME.get(), EntityMarioSlime.createMobAttributes().build());
        event.put(ModEntities.NPCLUIGISLIME.get(), EntityLuigiSlime.createMobAttributes().build());
        event.put(ModEntities.NPCVILLAGERSLIME.get(), EntityVillagerSlime.createMobAttributes().build());
        event.put(ModEntities.NPCLEONARDOSLIME.get(), EntityLeonardoSlime.createMobAttributes().build());
        event.put(ModEntities.NPCDONATELLOSLIME.get(), EntityDonatelloSlime.createMobAttributes().build());
        event.put(ModEntities.NPCRAPHAELSLIME.get(), EntityRaphaelSlime.createMobAttributes().build());
        event.put(ModEntities.NPCMICHELANGELOSLIME.get(), EntityMichelangeloSlime.createMobAttributes().build());
        event.put(ModEntities.NPCINUITSLIME.get(), EntityInuitSlime.createMobAttributes().build());

    }

    @SubscribeEvent
    public static void registerSpawns(RegisterSpawnPlacementsEvent event)
    {
        event.register(ModEntities.MOBORANGESLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBYELLOWSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBBLUESLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBREDSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBGREENSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBCAMOSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBCACTUSSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBMONKEYSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBCAVESLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                EntityCaveSlime::checkTheSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBFIERYSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBMOOSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBUNDERSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                EntityUnderSlime::checkTheSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBSNOWSLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBVAMPIRESLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.MOBICESLIME.get(),SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BadSlime::checkMySpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == SlimeVillagers.SLIMER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.ORANGEGEL, 13),
                    new ItemStack(ModItems.RAWSLIMEINGOT.get(), 4), 6, 3, 0.05f));

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.REDGEL, 2),
                    new ItemStack(ModItems.SLIME_PIZZA.get(), 1), 6, 2, 0.05f));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.YELLOWGEL, 2),
                    new ItemStack(ModItems.SLIME_BANANA.get(), 1), 6, 2, 0.05f));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.ORANGEGEL, 14),
                    new ItemStack(ModItems.KATANAGUARD.get(), 1), 6, 3, 0.05f));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.ORANGEGEL, 14),
                    new ItemStack(ModItems.KATANAHANDLE.get(), 1), 6, 2, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.BLUEGEL, 17),
                    new ItemStack(ModItems.BLUE_SLIME_BOOTS.get(), 1), 6, 4, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.BLUEGEL, 19),
                    new ItemStack(ModItems.BLUE_SLIME_HELMET.get(), 1), 6, 4, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.REDGEL, 17),
                    new ItemStack(ModItems.RED_SLIME_BOOTS.get(), 1), 6, 4, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.REDGEL, 19),
                    new ItemStack(ModItems.RED_SLIME_HELMET.get(), 1), 6, 4, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.YELLOWGEL, 17),
                    new ItemStack(ModItems.YELLOW_SLIME_BOOTS.get(), 1), 6, 4, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.YELLOWGEL, 19),
                    new ItemStack(ModItems.YELLOW_SLIME_HELMET.get(), 1), 6, 4, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.GREENGEL, 17),
                    new ItemStack(ModItems.GREEN_SLIME_BOOTS.get(), 1), 6, 4, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.GREENGEL, 19),
                    new ItemStack(ModItems.GREEN_SLIME_HELMET.get(), 1), 6, 4, 0.05f));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.BLUEGEL, 26),
                    new ItemStack(ModItems.BLUE_SLIME_LEGGINGS.get(), 1), 5, 5, 0.05f));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.REDGEL, 26),
                    new ItemStack(ModItems.RED_SLIME_LEGGINGS.get(), 1), 5, 5, 0.05f));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.YELLOWGEL, 26),
                    new ItemStack(ModItems.YELLOW_SLIME_LEGGINGS.get(), 1), 5, 5, 0.05f));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.GREENGEL, 26),
                    new ItemStack(ModItems.GREEN_SLIME_LEGGINGS.get(), 1), 5, 5, 0.05f));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.BLUEGEL, 33),
                    new ItemStack(ModItems.BLUE_SLIME_CHESTPLATE.get(), 1), 4, 6, 0.05f));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.REDGEL, 33),
                    new ItemStack(ModItems.RED_SLIME_CHESTPLATE.get(), 1), 4, 6, 0.05f));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.YELLOWGEL, 33),
                    new ItemStack(ModItems.YELLOW_SLIME_CHESTPLATE.get(), 1), 4, 6, 0.05f));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.GREENGEL, 33),
                    new ItemStack(ModItems.GREEN_SLIME_CHESTPLATE.get(), 1), 4, 6, 0.05f));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.BAKEDSLIMEINGOT.get(), 16),
                    new ItemStack(ModItems.THEKATANA.get(), 1), 2, 8, 0.05f));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(ModItems.ORANGEGEL, 18),
                new ItemStack(ModItems.KATANAGUARD.get(), 1), 1, 10, 0.2f));

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(ModItems.ORANGEGEL, 16),
                new ItemStack(ModItems.KATANAHANDLE.get(), 1), 1, 10, 0.2f));

        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(ModItems.BLUE_SLIME_CHESTPLATE.get(), 1),
                new ItemStack(ModItems.THEKATANA.get(), 1), 1, 10, 0.2f));
    }

}


