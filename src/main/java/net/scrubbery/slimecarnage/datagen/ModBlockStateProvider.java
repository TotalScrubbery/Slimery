package net.scrubbery.slimecarnage.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SlimeCarnage.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ORANGE_SLIME_BLOCK);
        blockWithItem(ModBlocks.RED_SLIME_BLOCK);
        blockWithItem(ModBlocks.BLUE_SLIME_BLOCK);
        blockWithItem(ModBlocks.YELLOW_SLIME_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}

