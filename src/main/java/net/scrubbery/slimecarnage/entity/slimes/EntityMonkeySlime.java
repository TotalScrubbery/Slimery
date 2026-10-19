package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.scrubbery.slimecarnage.particle.ModParticles;

public class EntityMonkeySlime extends BadSlime
{
    public EntityMonkeySlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setLevel(1);
    }

    protected boolean spawnCustomParticles()
    {
        return false;
    }

    protected ParticleOptions getParticleType()
    {
        return ModParticles.MONKEY_SLIME_PARTICLES.get();
    }

}