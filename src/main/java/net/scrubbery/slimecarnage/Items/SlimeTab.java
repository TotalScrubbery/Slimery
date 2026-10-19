package net.scrubbery.slimecarnage.Items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.block.ModBlocks;

import java.util.function.Supplier;

public class SlimeTab
{

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SlimeCarnage.MOD_ID);

    public static final Supplier<CreativeModeTab> SLIME_TAB = CREATIVE_MODE_TAB.register("slime_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORANGE_SLIME_EGG.get()))
                    .title(Component.translatable("creativetab.slimecarnage.slimestuff"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ORANGEGEL);
                        output.accept(ModItems.YELLOWGEL);
                        output.accept(ModItems.GREENGEL);
                        output.accept(ModItems.BLUEGEL);
                        output.accept(ModItems.REDGEL);
                        output.accept(ModItems.PURPLEGEL);
                        output.accept(ModItems.GREYGEL);

                        output.accept(ModItems.KATANAHANDLE);
                        output.accept(ModItems.KATANAGUARD);
                        output.accept(ModItems.KATANABLADE);
                        output.accept(ModItems.THEKATANA);

                        output.accept(ModItems.SLIME_BANANA);

                        output.accept(ModBlocks.ORANGE_SLIME_BLOCK);
                        output.accept(ModBlocks.RED_SLIME_BLOCK);
                        output.accept(ModBlocks.BLUE_SLIME_BLOCK);
                        output.accept(ModBlocks.YELLOW_SLIME_BLOCK);
                        output.accept(ModBlocks.VENDING_MACHINE_RED);
                        output.accept(ModBlocks.VENDING_MACHINE_GREEN);
                        output.accept(ModBlocks.TIKI_ORANGE);
                        output.accept(ModBlocks.TIKI_RED);
                        output.accept(ModBlocks.TIKI_BLUE);
                        output.accept(ModBlocks.TIKI_GREEN);
                        output.accept(ModBlocks.TIKI_YELLOW);

                        output.accept(ModItems.ORANGE_SLIME_EGG);
                        output.accept(ModItems.YELLOW_SLIME_EGG);
                        output.accept(ModItems.BLUE_SLIME_EGG);
                        output.accept(ModItems.RED_SLIME_EGG);
                        output.accept(ModItems.GREEN_SLIME_EGG);
                        output.accept(ModItems.CAMO_SLIME_EGG);
                        output.accept(ModItems.CACTUS_SLIME_EGG);
                        output.accept(ModItems.MONKEY_SLIME_EGG);
                        output.accept(ModItems.CAVE_SLIME_EGG);
                        output.accept(ModItems.FIERY_SLIME_EGG);
                        output.accept(ModItems.MOO_SLIME_EGG);
                        output.accept(ModItems.UNDER_SLIME_EGG);

                        output.accept(ModItems.OLD_MAN_EGG);
                        output.accept(ModItems.DOC_EGG);
                        output.accept(ModItems.MARIO_EGG);
                        output.accept(ModItems.LUIGI_EGG);
                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
