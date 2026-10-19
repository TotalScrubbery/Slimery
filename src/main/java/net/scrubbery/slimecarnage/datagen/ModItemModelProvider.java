package net.scrubbery.slimecarnage.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.scrubbery.slimecarnage.Items.ModItems;
import net.scrubbery.slimecarnage.SlimeCarnage;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, SlimeCarnage.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ORANGEGEL.get());
        basicItem(ModItems.GREENGEL.get());
        basicItem(ModItems.REDGEL.get());
        basicItem(ModItems.YELLOWGEL.get());
        basicItem(ModItems.BLUEGEL.get());
        basicItem(ModItems.GREYGEL.get());
        basicItem(ModItems.PURPLEGEL.get());

        basicItem(ModItems.SLIME_BANANA.get());

        basicItem(ModItems.ORANGE_SLIME_EGG.get());
        basicItem(ModItems.YELLOW_SLIME_EGG.get());
        basicItem(ModItems.BLUE_SLIME_EGG.get());
        basicItem(ModItems.RED_SLIME_EGG.get());
        basicItem(ModItems.GREEN_SLIME_EGG.get());
        basicItem(ModItems.CAMO_SLIME_EGG.get());
        basicItem(ModItems.CACTUS_SLIME_EGG.get());
        basicItem(ModItems.MONKEY_SLIME_EGG.get());
        basicItem(ModItems.CAVE_SLIME_EGG.get());
        basicItem(ModItems.FIERY_SLIME_EGG.get());
        basicItem(ModItems.MOO_SLIME_EGG.get());
        basicItem(ModItems.UNDER_SLIME_EGG.get());

        basicItem(ModItems.OLD_MAN_EGG.get());
        basicItem(ModItems.DOC_EGG.get());
        basicItem(ModItems.MARIO_EGG.get());
        basicItem(ModItems.LUIGI_EGG.get());
    }
}