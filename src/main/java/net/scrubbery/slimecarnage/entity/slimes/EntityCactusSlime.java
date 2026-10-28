package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class EntityCactusSlime extends BadSlime
{
    public EntityCactusSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setLevel(1);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        RandomSource randomsource = level.getRandom();
        if (randomsource.nextInt(75) == 0) {
            Rabbit rab = EntityType.RABBIT.create(this.level());
            if (rab != null) {
                rab.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                rab.finalizeSpawn(level, difficulty, spawnType, null);
                rab.startRiding(this);
            }
        }
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    protected float getAttackDamage()
    {
        return super.getAttackDamage() + 1.0F;
    }

}