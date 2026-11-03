package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.scrubbery.slimecarnage.entity.EntityNinjaStar;
import net.scrubbery.slimecarnage.particle.ModParticles;

public class EntityNinjaSlime extends BadSlime implements RangedAttackMob
{
    public EntityNinjaSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setLevel(1);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 100, 8.0F));
        super.registerGoals();
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

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        EntityNinjaStar ninstar = new EntityNinjaStar(this.level(), this);
        double d0 = target.getEyeY() - 1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - ninstar.getY();
        double d3 = target.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        ninstar.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
        this.playSound(SoundEvents.SNOWBALL_THROW, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(ninstar);
    }

}