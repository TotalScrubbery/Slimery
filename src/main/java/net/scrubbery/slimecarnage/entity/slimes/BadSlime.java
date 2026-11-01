package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.dimension.DimensionType;

import javax.annotation.Nullable;
import java.util.Random;

public class BadSlime extends Slime
{
    private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(BadSlime.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ID_LEVEL = SynchedEntityData.defineId(BadSlime.class, EntityDataSerializers.INT);
    public int lev;
    Random rand = new Random();
    private boolean wasOnGround;

    public BadSlime(EntityType<? extends Slime> entityType, Level level)
    {
        super(entityType, level);
        this.lev = this.rand.nextInt(5) + 1;
        this.setLevel(this.lev);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(ID_SIZE, 1);
        builder.define(ID_LEVEL, 1);
    }

    @Override
    public void setSize(int size, boolean resetHealth) {
        int i = Mth.clamp(size, 1, 127);
        //this.entityData.set(ID_SIZE, i);
        this.reapplyPosition();
        this.refreshDimensions();
        if (this.getLevel() == 1)
        {
            this.xpReward = size  * 2;
            this.entityData.set(ID_SIZE, 1);
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(2.0);
            this.getAttribute(Attributes.SCALE).setBaseValue((double) (1));
        }
        else {
            this.entityData.set(ID_SIZE, i);
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double) (i * 10));
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double) (i + 1));
            if (i == 1) {
                this.getAttribute(Attributes.SCALE).setBaseValue((double) (1));
            }
            if (i == 2) {
                this.getAttribute(Attributes.SCALE).setBaseValue((double) (1.1));
            }
            if (i == 4) {
                this.getAttribute(Attributes.SCALE).setBaseValue((double) (1.2));
            }
        }
        if (resetHealth) {
            this.setHealth(this.getMaxHealth());
        }
        //SlimeCarnage.LOGGER.info("" + this.getSize());
        this.xpReward = i;
    }

    @Override
    public int getSize()
    {
        return this.entityData.get(ID_SIZE);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Level", this.getLevel() - 1);
        compound.putInt("Size", this.getSize() - 1);
        compound.putBoolean("wasOnGround", this.wasOnGround);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        this.setLevel(compound.getInt("Level") + 1);
        this.setSize(compound.getInt("Size") + 1, false);
        super.readAdditionalSaveData(compound);
        this.wasOnGround = compound.getBoolean("wasOnGround");
    }

    public void setLevel(int par1)
    {
        this.entityData.set(ID_LEVEL, par1);
    }

    public int getLevel()
    {
        return this.entityData.get(ID_LEVEL);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    protected boolean spawnCustomParticles()
    {
        return true;
    }

    @Override
    protected boolean isDealsDamage()
    {
        return this.isEffectiveAi();
    }

    @Override
    protected float getAttackDamage()
    {
        return super.getAttackDamage();
    }

    public static boolean isDarkEnoughToSpawn(ServerLevelAccessor level, BlockPos pos, RandomSource random) {
        if (level.getBrightness(LightLayer.SKY, pos) > random.nextInt(32)) {
            return false;
        } else {
            DimensionType dimensiontype = level.dimensionType();
            int i = dimensiontype.monsterSpawnBlockLightLimit();
            if (i < 15 && level.getBrightness(LightLayer.BLOCK, pos) > i) {
                return false;
            } else {
                int j = level.getLevel().isThundering() ? level.getMaxLocalRawBrightness(pos, 10) : level.getMaxLocalRawBrightness(pos);
                return j <= dimensiontype.monsterSpawnLightTest().sample(random);
            }
        }
    }

    public static boolean checkMySpawnRules(
            EntityType<? extends BadSlime> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random
    )
    {
        if (pos.getY() >= 64)
        {
            BlockPos blockpos = pos.below();
            return level.getDifficulty() != Difficulty.PEACEFUL && spawnType == MobSpawnType.SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type) && isDarkEnoughToSpawn(level, pos, random);
        }
        else
        {
            return false;
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        RandomSource randomsource = level.getRandom();
        int i = randomsource.nextInt(3);
        if (i < 2 && randomsource.nextFloat() < 0.5F * difficulty.getSpecialMultiplier()) {
            i++;
        }

        int j = 1 << i;
        this.setSize(j, true);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

}

