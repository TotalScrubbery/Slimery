package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.scrubbery.slimecarnage.particle.ModParticles;

import javax.annotation.Nullable;

public class EntityBlueSlime extends BadSlime
{
    public EntityBlueSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
    }

    protected boolean spawnCustomParticles()
    {
        return false;
    }

    protected ParticleOptions getParticleType()
    {
        return ModParticles.BLUE_SLIME_PARTICLES.get();
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        RandomSource randomsource = level.getRandom();
        if (this.getLevel() == 1 && randomsource.nextInt(8) == 0) {
            Llama lla = EntityType.LLAMA.create(this.level());
            if (lla != null) {
                lla.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                lla.finalizeSpawn(level, difficulty, spawnType, null);
                lla.startRiding(this);
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
            EnderMan end = EntityType.ENDERMAN.create(this.level());
            if (end != null) {
                end.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                end.finalizeSpawn(level, difficulty, spawnType, null);
                end.startRiding(this);
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