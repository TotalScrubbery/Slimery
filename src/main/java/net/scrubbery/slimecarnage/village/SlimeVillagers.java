package net.scrubbery.slimecarnage.village;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scrubbery.slimecarnage.SlimeCarnage;
import net.scrubbery.slimecarnage.block.ModBlocks;

public class SlimeVillagers
{
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, SlimeCarnage.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, SlimeCarnage.MOD_ID);

    public static final Holder<PoiType> SLIME_POI = POI_TYPES.register("slime_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.VENDING_MACHINE_RED.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final Holder<VillagerProfession> SLIMER = VILLAGER_PROFESSIONS.register("slimer",
            () -> new VillagerProfession("slimer", holder -> holder.value() == SLIME_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == SLIME_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.GLASS_BREAK));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
