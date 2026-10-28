package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.scrubbery.slimecarnage.particle.ModParticles;

import javax.annotation.Nullable;

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

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        RandomSource randomsource = level.getRandom();
        if (randomsource.nextInt(75) == 0) {
            Parrot par = EntityType.PARROT.create(this.level());
            if (par != null) {
                par.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                par.finalizeSpawn(level, difficulty, spawnType, null);
                par.startRiding(this);
            }
        }
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

}