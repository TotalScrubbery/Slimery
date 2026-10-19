package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class EntityCaveSlime extends BadSlime
{
    public EntityCaveSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setLevel(1);
    }

    public static boolean checkTheSpawnRules(EntityType<EntityCaveSlime> cave, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random)
    {
        if (pos.getY() >= level.getSeaLevel())
        {
            return false;
        }
        else
        {
            int i = level.getMaxLocalRawBrightness(pos);
            int j = 4;

            return i > random.nextInt(j) ? false : checkMobSpawnRules(cave, level, spawnType, pos, random);
        }
    }

    @Override
    protected float getAttackDamage()
    {
        return super.getAttackDamage() + 1.0F;
    }

}