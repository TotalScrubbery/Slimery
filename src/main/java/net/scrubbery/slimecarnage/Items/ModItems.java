package net.scrubbery.slimecarnage.Items;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scrubbery.slimecarnage.Items.custom.CricketBallItem;
import net.scrubbery.slimecarnage.Items.custom.NinjaStarItem;
import net.scrubbery.slimecarnage.Items.custom.SlimeFood;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.entity.ModEntities;

import java.util.List;
import java.util.Random;

public class ModItems
{

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SlimeCarnage.MOD_ID);

    //Gels
    public static final DeferredItem<Item> ORANGEGEL = ITEMS.register("orangegel",
        () -> new Item(new Item.Properties())
    {
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.slimecarnage.orangegel"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
    });
    public static final DeferredItem<Item> YELLOWGEL = ITEMS.register("yellowgel",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.yellowgel"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> REDGEL = ITEMS.register("redgel",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.redgel"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> GREENGEL = ITEMS.register("greengel",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.greengel"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BLUEGEL = ITEMS.register("bluegel",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.bluegel"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item>PURPLEGEL = ITEMS.register("purplegel",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.purplegel"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> GREYGEL = ITEMS.register("greygel",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.greygel"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //Ingot
    public static final DeferredItem<Item> RAWSLIMEINGOT = ITEMS.register("raw_slime_ingot",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.rawslimeingot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BAKEDSLIMEINGOT = ITEMS.register("baked_slime_ingot",
            () -> new Item(new Item.Properties()));
    //Armour
    public static final DeferredItem<ArmorItem> BLUE_SLIME_HELMET = ITEMS.register("blue_slime_helmet",
            () -> new SlimeArmourExtra(SlimeArmour.BLUE_SLIME_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> BLUE_SLIME_CHESTPLATE = ITEMS.register("blue_slime_chestplate",
            () -> new ArmorItem(SlimeArmour.BLUE_SLIME_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> BLUE_SLIME_LEGGINGS = ITEMS.register("blue_slime_leggings",
            () -> new ArmorItem(SlimeArmour.BLUE_SLIME_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> BLUE_SLIME_BOOTS = ITEMS.register("blue_slime_boots",
            () -> new ArmorItem(SlimeArmour.BLUE_SLIME_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static final DeferredItem<ArmorItem> RED_SLIME_HELMET = ITEMS.register("red_slime_helmet",
            () -> new SlimeArmourExtra(SlimeArmour.RED_SLIME_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> RED_SLIME_CHESTPLATE = ITEMS.register("red_slime_chestplate",
            () -> new ArmorItem(SlimeArmour.RED_SLIME_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> RED_SLIME_LEGGINGS = ITEMS.register("red_slime_leggings",
            () -> new ArmorItem(SlimeArmour.RED_SLIME_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> RED_SLIME_BOOTS = ITEMS.register("red_slime_boots",
            () -> new ArmorItem(SlimeArmour.RED_SLIME_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static final DeferredItem<ArmorItem> GREEN_SLIME_HELMET = ITEMS.register("green_slime_helmet",
            () -> new SlimeArmourExtra(SlimeArmour.GREEN_SLIME_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> GREEN_SLIME_CHESTPLATE = ITEMS.register("green_slime_chestplate",
            () -> new ArmorItem(SlimeArmour.GREEN_SLIME_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> GREEN_SLIME_LEGGINGS = ITEMS.register("green_slime_leggings",
            () -> new ArmorItem(SlimeArmour.GREEN_SLIME_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> GREEN_SLIME_BOOTS = ITEMS.register("green_slime_boots",
            () -> new ArmorItem(SlimeArmour.GREEN_SLIME_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static final DeferredItem<ArmorItem> YELLOW_SLIME_HELMET = ITEMS.register("yellow_slime_helmet",
            () -> new SlimeArmourExtra(SlimeArmour.YELLOW_SLIME_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> YELLOW_SLIME_CHESTPLATE = ITEMS.register("yellow_slime_chestplate",
            () -> new ArmorItem(SlimeArmour.YELLOW_SLIME_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> YELLOW_SLIME_LEGGINGS = ITEMS.register("yellow_slime_leggings",
            () -> new ArmorItem(SlimeArmour.YELLOW_SLIME_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> YELLOW_SLIME_BOOTS = ITEMS.register("yellow_slime_boots",
            () -> new ArmorItem(SlimeArmour.YELLOW_SLIME_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));
    //Food
    public static final DeferredItem<Item> SLIME_BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(SlimeFood.SLIME_BANANA))
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.banana"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> SLIME_PIZZA = ITEMS.register("pizzaslice",
            () -> new Item(new Item.Properties().food(SlimeFood.SLIME_PIZZA))
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.pizzaslice"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //weapon + parts
    public static final DeferredItem<Item> KATANAHANDLE = ITEMS.register("handle",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.handle"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> KATANAGUARD = ITEMS.register("guard",
        () -> new Item(new Item.Properties())
        {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.slimecarnage.guard"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });
    public static final DeferredItem<Item> KATANABLADE = ITEMS.register("blade",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.blade"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<SwordItem> THEKATANA = ITEMS.register("katana",
            () -> new SwordItem(SlimeTiers.SLIME, new Item.Properties().attributes(SwordItem.createAttributes(SlimeTiers.SLIME, 6, -2.4f)))
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.katana"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> NINJASTAR = ITEMS.register("ninjastar",
            () -> new NinjaStarItem(new Item.Properties().stacksTo(16))
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.ninjastar"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> CRICKETBALL = ITEMS.register("cricketball",
            () -> new CricketBallItem(new Item.Properties().stacksTo(16))
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.slimecarnage.cricketball"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

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

    public static final DeferredItem<Item> SNOW_SLIME_EGG = ITEMS.register("spawnsnow",
            () -> new DeferredSpawnEggItem(ModEntities.MOBSNOWSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> VAMPIRE_SLIME_EGG = ITEMS.register("spawnvampire",
            () -> new DeferredSpawnEggItem(ModEntities.MOBVAMPIRESLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> ICE_SLIME_EGG = ITEMS.register("spawnice",
            () -> new DeferredSpawnEggItem(ModEntities.MOBICESLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> NINJA_SLIME_EGG = ITEMS.register("spawnninja",
            () -> new DeferredSpawnEggItem(ModEntities.MOBNINJASLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> MUMMY_SLIME_EGG = ITEMS.register("spawnmummy",
            () -> new DeferredSpawnEggItem(ModEntities.MOBMUMMYSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> HEROBRINE_SLIME_EGG = ITEMS.register("spawnherobrine",
            () -> new DeferredSpawnEggItem(ModEntities.MOBHEROBRINESLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> GANG_SLIME_EGG = ITEMS.register("spawngang",
            () -> new DeferredSpawnEggItem(ModEntities.MOBGANGSLIME, 0xffffff, 0xffffff,
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

    public static final DeferredItem<Item> VILLAGER_EGG = ITEMS.register("spawnvillager",
            () -> new DeferredSpawnEggItem(ModEntities.NPCVILLAGERSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

        public static final DeferredItem<Item> LEO_EGG = ITEMS.register("spawnleo",
            () -> new DeferredSpawnEggItem(ModEntities.NPCLEONARDOSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> DON_EGG = ITEMS.register("spawndon",
            () -> new DeferredSpawnEggItem(ModEntities.NPCDONATELLOSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> RAPH_EGG = ITEMS.register("spawnraph",
            () -> new DeferredSpawnEggItem(ModEntities.NPCRAPHAELSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> MIKEY_EGG = ITEMS.register("spawnmikey",
            () -> new DeferredSpawnEggItem(ModEntities.NPCMICHELANGELOSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static final DeferredItem<Item> INUIT_EGG = ITEMS.register("spawninuit",
            () -> new DeferredSpawnEggItem(ModEntities.NPCINUITSLIME, 0xffffff, 0xffffff,
                    new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
