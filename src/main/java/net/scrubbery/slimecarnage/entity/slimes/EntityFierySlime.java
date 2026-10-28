package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class EntityFierySlime extends BadSlime
{
    public EntityFierySlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setLevel(1);
    }

    @Override
    public void playerTouch(Player entity) {
        if (this.isDealsDamage()) {
            this.dealDamage(entity);
            entity.igniteForTicks(60);
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        RandomSource randomsource = level.getRandom();
        if (randomsource.nextInt(75) == 0) {
            Piglin plin = EntityType.PIGLIN .create(this.level());
            if (plin != null) {
                plin.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                plin.finalizeSpawn(level, difficulty, spawnType, null);
                plin.startRiding(this);
            }
        }
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    protected float getAttackDamage()
    {
        return super.getAttackDamage() + 2.0F;
    }

}