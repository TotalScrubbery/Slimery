package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.scrubbery.slimecarnage.SlimeSounds;
import net.scrubbery.slimecarnage.particle.ModParticles;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityVampireSlime extends BadSlime
{
    Random rando = new Random();
    public int sd;

    public EntityVampireSlime(EntityType<? extends BadSlime> entityType, Level level)
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
        return ModParticles.BAT_SLIME_PARTICLES.get();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (!super.doHurtTarget(entity)) {
            return false;
        } else {
            if (entity instanceof LivingEntity) {
                this.heal(1f);
            }

            return true;
        }
    }

    protected boolean isSunSensitive() {
        return true;
    }

    @Override
    public void aiStep() {
        if (this.isAlive()) {
            boolean flag = this.isSunSensitive() && this.isSunBurnTick();
            if (flag) {
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);
                if (!itemstack.isEmpty()) {
                    if (itemstack.isDamageableItem()) {
                        Item item = itemstack.getItem();
                        itemstack.setDamageValue(itemstack.getDamageValue() + this.random.nextInt(2));
                        if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
                            this.onEquippedItemBroken(item, EquipmentSlot.HEAD);
                            this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                        }
                    }

                    flag = false;
                }

                if (flag) {
                    this.igniteForSeconds(8.0F);
                }
            }
        }

        super.aiStep();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        this.sd = this.rando.nextInt(2) + 1;
        if(sd == 1)
        {
            return SlimeSounds.VAMP_LAUGH.get();
        }
        else
        {
            return SlimeSounds.VAMP_AMB.get();
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.BAT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BAT_DEATH;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        RandomSource randomsource = level.getRandom();
        if (randomsource.nextInt(75) == 0) {
            Witch witch = EntityType.WITCH.create(this.level());
            if (witch != null) {
                witch.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                witch.finalizeSpawn(level, difficulty, spawnType, null);
                witch.startRiding(this);
            }
        }
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }
}