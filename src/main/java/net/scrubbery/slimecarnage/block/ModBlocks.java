package net.scrubbery.slimecarnage.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scrubbery.slimecarnage.Items.ModItems;
import net.scrubbery.slimecarnage.SlimeCarnage;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SlimeCarnage.MOD_ID);

       public static final DeferredBlock<Block> ORANGE_SLIME_BLOCK = registerBlock("orange_slime_block",
            () -> new OrangeSlimeBlock((BlockBehaviour.Properties.of().strength(2f).sound(SoundType.SLIME_BLOCK))));
    public static final DeferredBlock<Block> RED_SLIME_BLOCK = registerBlock("red_slime_block",
            () -> new OrangeSlimeBlock((BlockBehaviour.Properties.of().strength(2f).sound(SoundType.SLIME_BLOCK))));
    public static final DeferredBlock<Block> BLUE_SLIME_BLOCK = registerBlock("blue_slime_block",
            () -> new OrangeSlimeBlock((BlockBehaviour.Properties.of().strength(2f).sound(SoundType.SLIME_BLOCK))));
    public static final DeferredBlock<Block> YELLOW_SLIME_BLOCK = registerBlock("yellow_slime_block",
            () -> new OrangeSlimeBlock((BlockBehaviour.Properties.of().strength(2f).sound(SoundType.SLIME_BLOCK))));

    public static final DeferredBlock<Block> VENDING_MACHINE_RED = registerBlock("vending_machine_bottom_red",
            () -> new VendingMachineRed(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.STONE).lightLevel(state -> 6)));
    public static final DeferredBlock<Block> VENDING_MACHINE_GREEN = registerBlock("vending_machine_bottom_green",
            () -> new VendingMachineGreen((BlockBehaviour.Properties.of().strength(4f).sound(SoundType.STONE).lightLevel(state -> 6))));

    public static final DeferredBlock<Block> TIKI_ORANGE = registerBlock("tiki_orange_bottom",
            () -> new TikiOrange((BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD).lightLevel(state -> 15))));
    public static final DeferredBlock<Block> TIKI_RED = registerBlock("tiki_red_bottom",
            () -> new TikiRed((BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD).lightLevel(state -> 15))));
    public static final DeferredBlock<Block> TIKI_BLUE = registerBlock("tiki_blue_bottom",
            () -> new TikiBlue((BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD).lightLevel(state -> 15))));
    public static final DeferredBlock<Block> TIKI_GREEN = registerBlock("tiki_green_bottom",
            () -> new TikiGreen((BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD).lightLevel(state -> 15))));
    public static final DeferredBlock<Block> TIKI_YELLOW = registerBlock("tiki_yellow_bottom",
            () -> new TikiYellow((BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD).lightLevel(state -> 15))));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}


