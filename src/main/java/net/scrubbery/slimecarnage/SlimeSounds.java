package net.scrubbery.slimecarnage;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SlimeSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, SlimeCarnage.MOD_ID);

    public static final Supplier<SoundEvent> VAMP_AMB = registerSoundEvent("vamp_amb");
    public static final Supplier<SoundEvent> VAMP_LAUGH = registerSoundEvent("vamp_laugh");

    public static final Supplier<SoundEvent> MARIO_DEATH = registerSoundEvent("mario_die");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(SlimeCarnage.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}