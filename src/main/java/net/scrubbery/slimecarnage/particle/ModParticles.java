package net.scrubbery.slimecarnage.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scrubbery.slimecarnage.SlimeCarnage;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, SlimeCarnage.MOD_ID);

    public static final Supplier<SimpleParticleType> ORANGE_SLIME_PARTICLES =
            PARTICLE_TYPES.register("orange_slime_particles", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> BLUE_SLIME_PARTICLES =
                PARTICLE_TYPES.register("blue_slime_particles", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> RED_SLIME_PARTICLES =
            PARTICLE_TYPES.register("red_slime_particles", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> YELLOW_SLIME_PARTICLES =
            PARTICLE_TYPES.register("yellow_slime_particles", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> GREEN_SLIME_PARTICLES =
            PARTICLE_TYPES.register("green_slime_particles", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> MONKEY_SLIME_PARTICLES =
            PARTICLE_TYPES.register("monkey_slime_particles", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> BAT_SLIME_PARTICLES =
            PARTICLE_TYPES.register("bat_slime_particles", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> NINJA_SLIME_PARTICLES =
            PARTICLE_TYPES.register("ninja_slime_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
