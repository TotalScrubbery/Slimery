package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.scrubbery.slimecarnage.particle.ModParticles;

public class EntityRedSlime extends BadSlime
{
    public EntityRedSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
    }

    protected boolean spawnCustomParticles()
    {
        return false;
    }

    protected ParticleOptions getParticleType()
    {
        return ModParticles.RED_SLIME_PARTICLES.get();
    }
}