package net.scrubbery.slimecarnage.Items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scrubbery.slimecarnage.Items.custom.SlimeFood;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.entity.ModEntities;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SlimeCarnage.MOD_ID);

    //Gels
    public static final DeferredItem<Item> ORANGEGEL = ITEMS.register("orangegel",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOWGEL = ITEMS.register("yellowgel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REDGEL = ITEMS.register("redgel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREENGEL = ITEMS.register("greengel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLUEGEL = ITEMS.register("bluegel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item>PURPLEGEL = ITEMS.register("purplegel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREYGEL = ITEMS.register("greygel",
            () -> new Item(new Item.Properties()));
    //Food
    public static final DeferredItem<Item> SLIME_BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(SlimeFood.SLIME_BANANA)));
    //weapon + parts
    public static final DeferredItem<Item> KATANAHANDLE = ITEMS.register("handle",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> KATANAGUARD = ITEMS.register("guard",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> KATANABLADE = ITEMS.register("blade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<SwordItem> THEKATANA = ITEMS.register("katana",
            () -> new SwordItem(SlimeTiers.SLIME, new Item.Properties().attributes(SwordItem.createAttributes(SlimeTiers.SLIME, 6, -2.4f))));


    //Mob slimes
    public static final DeferredItem<Item> ORANGE_SLIME_EGG = ITEMS.register("spawnorange",
            () -> new DeferredSpawnEggItem(ModEntities.MOBORANGESLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> YELLOW_SLIME_EGG = ITEMS.register("spawnyellow",
            () -> new DeferredSpawnEggItem(ModEntities.MOBYELLOWSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> RED_SLIME_EGG = ITEMS.register("spawnred",
            () -> new DeferredSpawnEggItem(ModEntities.MOBREDSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> BLUE_SLIME_EGG = ITEMS.register("spawnblue",
            () -> new DeferredSpawnEggItem(ModEntities.MOBBLUESLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> GREEN_SLIME_EGG = ITEMS.register("spawngreen",
            () -> new DeferredSpawnEggItem(ModEntities.MOBGREENSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> CAMO_SLIME_EGG = ITEMS.register("spawncamo",
            () -> new DeferredSpawnEggItem(ModEntities.MOBCAMOSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> CACTUS_SLIME_EGG = ITEMS.register("spawncactus",
            () -> new DeferredSpawnEggItem(ModEntities.MOBCACTUSSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> MONKEY_SLIME_EGG = ITEMS.register("spawnmonkey",
            () -> new DeferredSpawnEggItem(ModEntities.MOBMONKEYSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> CAVE_SLIME_EGG = ITEMS.register("spawncave",
            () -> new DeferredSpawnEggItem(ModEntities.MOBCAVESLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> FIERY_SLIME_EGG = ITEMS.register("spawnfiery",
            () -> new DeferredSpawnEggItem(ModEntities.MOBFIERYSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> MOO_SLIME_EGG = ITEMS.register("spawnmoo",
            () -> new DeferredSpawnEggItem(ModEntities.MOBMOOSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> UNDER_SLIME_EGG = ITEMS.register("spawnunder",
            () -> new DeferredSpawnEggItem(ModEntities.MOBUNDERSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));


    //NPCs
    public static final DeferredItem<Item> OLD_MAN_EGG = ITEMS.register("spawnoldman",
            () -> new DeferredSpawnEggItem(ModEntities.NPCOLDMANSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> DOC_EGG = ITEMS.register("spawndoc",
            () -> new DeferredSpawnEggItem(ModEntities.NPCDOCSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> MARIO_EGG = ITEMS.register("spawnmario",
            () -> new DeferredSpawnEggItem(ModEntities.NPCMARIOSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> LUIGI_EGG = ITEMS.register("spawnluigi",
            () -> new DeferredSpawnEggItem(ModEntities.NPCLUIGISLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
