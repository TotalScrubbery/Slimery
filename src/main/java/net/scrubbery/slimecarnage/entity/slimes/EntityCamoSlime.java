package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class EntityCamoSlime extends BadSlime
{
    public EntityCamoSlime(EntityType<? extends BadSlime> entityType, Level level)
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
            Silverfish sil = EntityType.SILVERFISH.create(this.level());
            if (sil != null) {
                sil.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                sil.finalizeSpawn(level, difficulty, spawnType, null);
                sil.startRiding(this);
            }
        }
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

}