package net.scrubbery.slimecarnage.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.entity.slimes.*;

import java.util.function.Supplier;

public class ModEntities
{
    //Mob slimes
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, SlimeCarnage.MOD_ID);

    public static final Supplier<EntityType<EntityOrangeSlime>> MOBORANGESLIME = ENTITY_TYPES.register("orange_slime", () ->
            register("orange_slime", EntityType.Builder.<EntityOrangeSlime>of(EntityOrangeSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityYellowSlime>> MOBYELLOWSLIME = ENTITY_TYPES.register("yellow_slime", () ->
            register("yellow_slime", EntityType.Builder.<EntityYellowSlime>of(EntityYellowSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityBlueSlime>> MOBBLUESLIME = ENTITY_TYPES.register("blue_slime", () ->
            register("blue_slime", EntityType.Builder.<EntityBlueSlime>of(EntityBlueSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityRedSlime>> MOBREDSLIME = ENTITY_TYPES.register("red_slime", () ->
            register("red_slime", EntityType.Builder.<EntityRedSlime>of(EntityRedSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityGreenSlime>> MOBGREENSLIME = ENTITY_TYPES.register("green_slime", () ->
            register("green_slime", EntityType.Builder.<EntityGreenSlime>of(EntityGreenSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityCamoSlime>> MOBCAMOSLIME = ENTITY_TYPES.register("camo_slime", () ->
            register("camo_slime", EntityType.Builder.<EntityCamoSlime>of(EntityCamoSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityCactusSlime>> MOBCACTUSSLIME = ENTITY_TYPES.register("cactus_slime", () ->
            register("cactus_slime", EntityType.Builder.<EntityCactusSlime>of(EntityCactusSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityMonkeySlime>> MOBMONKEYSLIME = ENTITY_TYPES.register("monkey_slime", () ->
            register("monkey_slime", EntityType.Builder.<EntityMonkeySlime>of(EntityMonkeySlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityCaveSlime>> MOBCAVESLIME = ENTITY_TYPES.register("cave_slime", () ->
            register("cave_slime", EntityType.Builder.<EntityCaveSlime>of(EntityCaveSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityFierySlime>> MOBFIERYSLIME = ENTITY_TYPES.register("fiery_slime", () ->
            register("fiery_slime", EntityType.Builder.<EntityFierySlime>of(EntityFierySlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityMooSlime>> MOBMOOSLIME = ENTITY_TYPES.register("moo_slime", () ->
            register("moo_slime", EntityType.Builder.<EntityMooSlime>of(EntityMooSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityUnderSlime>> MOBUNDERSLIME = ENTITY_TYPES.register("under_slime", () ->
            register("under_slime", EntityType.Builder.<EntityUnderSlime>of(EntityUnderSlime::new, MobCategory.MONSTER)
                    .sized(0.5F, 0.5F)));

    /*To create:
        Ice Slime
        Mummy Slime
        Ninja Slime
        Snow Slime
        Ninja Turtle Slimes
    */

    //NPC slimes
    public static final Supplier<EntityType<EntityOldManSlime>> NPCOLDMANSLIME = ENTITY_TYPES.register("old_man_slime", () ->
            register("old_man_slime", EntityType.Builder.<EntityOldManSlime>of(EntityOldManSlime::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityDocSlime>> NPCDOCSLIME = ENTITY_TYPES.register("doc_slime", () ->
            register("doc_slime", EntityType.Builder.<EntityDocSlime>of(EntityDocSlime::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityMarioSlime>> NPCMARIOSLIME = ENTITY_TYPES.register("mario_slime", () ->
            register("mario_slime", EntityType.Builder.<EntityMarioSlime>of(EntityMarioSlime::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)));

    public static final Supplier<EntityType<EntityLuigiSlime>> NPCLUIGISLIME = ENTITY_TYPES.register("luigi_slime", () ->
            register("luigi_slime", EntityType.Builder.<EntityLuigiSlime>of(EntityLuigiSlime::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)));

    public static void registerEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.MOBORANGESLIME.get(), EntityOrangeSlime.createAttributes().build());
        event.put(ModEntities.MOBYELLOWSLIME.get(), EntityYellowSlime.createAttributes().build());
        event.put(ModEntities.MOBBLUESLIME.get(), EntityBlueSlime.createAttributes().build());
        event.put(ModEntities.MOBGREENSLIME.get(), EntityGreenSlime.createAttributes().build());
        event.put(ModEntities.MOBREDSLIME.get(), EntityRedSlime.createAttributes().build());
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

    public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder)
    {
        return builder.build(id);
    }

}
