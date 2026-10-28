package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.scrubbery.slimecarnage.particle.ModParticles;

public class EntityNinjaSlime extends BadSlime
{
    public EntityNinjaSlime(EntityType<? extends BadSlime> entityType, Level level)
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
        return ModParticles.NINJA_SLIME_PARTICLES.get();
    }

    @Override
    public void tick()
    {
        super.tick();
        if (this.isInWater())
        {
            this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20), this);
        }
    }

    @Override
    protected float getAttackDamage()
    {
        return super.getAttackDamage() + 1.0F;
    }

}