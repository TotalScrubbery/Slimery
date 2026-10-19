package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;


public class GoodSlime extends PathfinderMob
{
    private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(GoodSlime.class, EntityDataSerializers.INT);
    private boolean wasOnGround;
    public float squish;
    public float oSquish;

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
        this.goalSelector.addGoal(1, new FloatGoal(this));
        //this.goalSelector.addGoal(2, new
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Mob.class, true));
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
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)(0.2F + 0.1F * (float)2));
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(0);
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
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, (double)100.0F).add(Attributes.MOVEMENT_SPEED, (double)0.2F).add(Attributes.ATTACK_DAMAGE, 0);
    }


}

