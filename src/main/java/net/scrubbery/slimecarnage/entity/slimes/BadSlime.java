package net.scrubbery.slimecarnage.entity.slimes;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

import java.util.Random;


public class BadSlime extends Slime
{
    private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(BadSlime.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ID_LEVEL = SynchedEntityData.defineId(BadSlime.class, EntityDataSerializers.INT);
    public static final Logger LOGGER = LogUtils.getLogger();
    public int lev;
    Random rand = new Random();
    private boolean wasOnGround;

    public BadSlime(EntityType<? extends Slime> entityType, Level level)
    {
        super(entityType, level);
        this.lev = this.rand.nextInt(5) + 1;
        this.setLevel(this.lev);
        /*if (!level.isClientSide)
        {
            if (this.getLevel() == 1) {
                this.setSize(1, false);
            }
            else if (this.getLevel() == 2) {
                this.setSize(1, false);
            }
            else if (this.getLevel() == 3) {
                this.setSize(2, false);
            }
            else if (this.getLevel() == 4) {
                this.setSize(2, false);
            }
            else if (this.getLevel() == 5) {
                this.setSize(4, false);
            }
            else {
                this.dead = true;
            }
        }
        else
        {
            this.dead = true;
            //this.setSize(4, false);
        }*/
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(ID_SIZE, 1);
        builder.define(ID_LEVEL, 1);
    }

    @Override
    public void setSize(int size, boolean resetHealth)
    {
        if (this.getLevel() == 1) {
            this.xpReward = size  * 2;
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5F);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1.0);
            this.entityData.set(ID_SIZE, 1);
            LOGGER.info("1");
        }
        else if (this.getLevel() == 2) {
            this.xpReward = size * 2;
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4F);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(2.0);
            this.entityData.set(ID_SIZE, 1);
            LOGGER.info("2");
        }
        else if (this.getLevel() == 3) {
            this.xpReward = size * 2;
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3F);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(3.0);
            this.entityData.set(ID_SIZE, 2);
            LOGGER.info("3");
        }
        else if (this.getLevel() == 4) {
            this.xpReward = size * 2;
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25F);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0);
            this.entityData.set(ID_SIZE, 2);
            LOGGER.info("4");
        }
        else if (this.getLevel() == 5) {
            this.xpReward = size * 2;
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2F);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(5.0);
            this.entityData.set(ID_SIZE, 4);
            LOGGER.info("5");
        }
        else {
            this.xpReward = size;
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(1.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1F);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1.0);
            this.entityData.set(ID_SIZE, 1);
        }
        this.reapplyPosition();
        this.refreshDimensions();
        if (resetHealth)
        {
            this.setHealth(this.getMaxHealth());
        }
    }


    @Override
    public int getSize()
    {
        return this.entityData.get(ID_SIZE);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Level", this.getLevel());
        compound.putInt("Size", this.getSize() - 1);
        compound.putBoolean("wasOnGround", this.wasOnGround);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        this.setLevel(compound.getInt("Level"));
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
}

