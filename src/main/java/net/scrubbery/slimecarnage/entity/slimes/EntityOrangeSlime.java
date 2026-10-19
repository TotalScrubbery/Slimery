package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.scrubbery.slimecarnage.particle.ModParticles;
import net.scrubbery.slimecarnage.particle.OrangeSlimeParticles;

import javax.annotation.Nullable;

public class EntityOrangeSlime extends BadSlime
{
    public EntityOrangeSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        //LOGGER.info("Level: " + this.getLevel() + " ");
        //LOGGER.info("Dmg: " + getAttackDamage() + " ");
    }

    protected boolean spawnCustomParticles()
    {
        return false;
    }

    protected ParticleOptions getParticleType()
    {
        return ModParticles.ORANGE_SLIME_PARTICLES.get();
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        RandomSource randomsource = level.getRandom();
        if (this.getLevel() == 1 && randomsource.nextInt(8) == 0) {
            Cow cow = EntityType.COW.create(this.level());
            if (cow != null) {
                cow.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                cow.finalizeSpawn(level, difficulty, spawnType, null);
                cow.startRiding(this);
            }
        }

        if (this.getLevel() == 2 && randomsource.nextInt(10) == 0) {
            Skeleton skele = EntityType.SKELETON.create(this.level());
            if (skele != null) {
                skele.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                skele.finalizeSpawn(level, difficulty, spawnType, null);
                skele.startRiding(this);
            }
        }

        if (this.getLevel() == 3 && randomsource.nextInt(12) == 0) {
            Zombie zomb = EntityType.ZOMBIE.create(this.level());
            if (zomb != null) {
                zomb.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                zomb.finalizeSpawn(level, difficulty, spawnType, null);
                zomb.startRiding(this);
            }
        }

        if (this.getLevel() == 4 && randomsource.nextInt(14) == 0) {
            Spider spidey = EntityType.SPIDER.create(this.level());
            if (spidey != null) {
                spidey.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                spidey.finalizeSpawn(level, difficulty, spawnType, null);
                spidey.startRiding(this);
            }
        }

        if (this.getLevel() == 5 && randomsource.nextInt(16) == 0) {
            Creeper creeper = EntityType.CREEPER.create(this.level());
            if (creeper != null) {
                creeper.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                creeper.finalizeSpawn(level, difficulty, spawnType, null);
                creeper.startRiding(this);
            }
        }

        int i = randomsource.nextInt(3);
        if (i < 2 && randomsource.nextFloat() < 0.5F * difficulty.getSpecialMultiplier()) {
            i++;
        }

        int j = 1 << i;
        this.setSize(j, true);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }
}

