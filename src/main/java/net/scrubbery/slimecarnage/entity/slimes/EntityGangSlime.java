package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.scrubbery.slimecarnage.entity.EntityCricketBall;
import net.scrubbery.slimecarnage.entity.EntityNinjaStar;

public class EntityGangSlime extends BadSlime implements RangedAttackMob
{
    public EntityGangSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setLevel(1);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 100, 8.0F));
        super.registerGoals();
    }

    @Override
    protected float getAttackDamage()
    {
        return super.getAttackDamage() + 1.0F;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        EntityCricketBall cricball = new EntityCricketBall(this.level(), this);
        double d0 = target.getEyeY() - 1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - cricball.getY();
        double d3 = target.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        cricball.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
        this.playSound(SoundEvents.SNOWBALL_THROW, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(cricball);
    }
}
