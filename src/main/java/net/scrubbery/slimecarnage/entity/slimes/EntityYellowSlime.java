package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.scrubbery.slimecarnage.particle.ModParticles;

public class EntityYellowSlime extends BadSlime
{
    public EntityYellowSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
    }

    protected boolean spawnCustomParticles()
    {
        return false;
    }

    protected ParticleOptions getParticleType()
    {
        return ModParticles.YELLOW_SLIME_PARTICLES.get();
    }
}
