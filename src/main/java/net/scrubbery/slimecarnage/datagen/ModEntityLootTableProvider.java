package net.scrubbery.slimecarnage.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootTable;
import net.scrubbery.slimecarnage.entity.ModEntities;

import java.util.Set;
import java.util.stream.Stream;

public class ModEntityLootTableProvider extends EntityLootSubProvider
{
    public ModEntityLootTableProvider(HolderLookup.Provider registries)
    {
        super(FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    public void generate() {
        //var enchantments = this.output.lookup(Registries.ENCHANTMENT);

       /* add(ModEntities.MOBORANGESLIME.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(Items.FEATHER)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.between(1, 3))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())));*/

        add(ModEntities.MOBORANGESLIME.get(), LootTable.lootTable());
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().map(Holder::value);
    }
}