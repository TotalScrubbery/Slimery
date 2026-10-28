package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.UUID;


public class GoodSlime extends PathfinderMob implements NeutralMob
{
    private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(GoodSlime.class, EntityDataSerializers.INT);
    private boolean wasOnGround;
    public float squish;
    public float oSquish;

    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(10, 20);
    private int remainingPersistentAngerTime;
    @Nullable
    private UUID persistentAngerTarget;

    public GoodSlime(EntityType<? extends GoodSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setPersistenceRequired();
        squish = 0f;
        oSquish = 0f;
    }

    protected boolean spawnCustomParticles() { return true; }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.5, 32.0F));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.7));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector
                .addGoal(
                        3, new NearestAttackableTargetGoal<>(this, EntityNinjaSlime.class, 5, false, false, p_28879_ -> p_28879_ instanceof Enemy)
                );
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(ID_SIZE, 1);
    }

    public void setSize(int size, boolean resetHealth)
    {
        this.entityData.set(ID_SIZE, 1);
        this.reapplyPosition();
        this.refreshDimensions();
        if (resetHealth)
        {
            this.setHealth(this.getMaxHealth());
        }
    }

    public int getSize()
    {
        return this.entityData.get(ID_SIZE);
    }

    float getSoundPitch() {
        float f = 0.8F;
        return ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * f;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Size", this.getSize() - 1);
        compound.putBoolean("wasOnGround", this.wasOnGround);
    }


    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        this.setSize(compound.getInt("Size") + 1, false);
        super.readAdditionalSaveData(compound);
        this.wasOnGround = compound.getBoolean("wasOnGround");
    }

    public static AttributeSupplier.Builder createMobAttributes()
    {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 100.0)
            .add(Attributes.MOVEMENT_SPEED, 0.25)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
            .add(Attributes.ATTACK_DAMAGE, 4.0)
            .add(Attributes.STEP_HEIGHT, 1.0);
        //return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, (double)100.0F).add(Attributes.MOVEMENT_SPEED, (double)0.2F).add(Attributes.ATTACK_DAMAGE, 0);
    }
    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    @Override
    public void setRemainingPersistentAngerTime(int time) {
        this.remainingPersistentAngerTime = time;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID target) {
        this.persistentAngerTarget = target;
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }
}

