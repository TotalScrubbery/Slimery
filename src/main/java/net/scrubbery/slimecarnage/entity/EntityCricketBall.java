package net.scrubbery.slimecarnage.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.scrubbery.slimecarnage.Items.ModItems;

public class EntityCricketBall extends ThrowableItemProjectile {

    public EntityCricketBall(EntityType<? extends EntityCricketBall> entityType, Level level)
    {
        super(entityType, level);
    }

    public EntityCricketBall(Level level, LivingEntity shooter) {
        super(ModEntities.CRICKETBALL.get(), shooter, level);
    }

    public EntityCricketBall(Level level, double x, double y, double z) {
        super(ModEntities.CRICKETBALL.get(), x, y, z, level);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 2.0f);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return new ItemStack(ModItems.CRICKETBALL.get()).getItem();
    }
}
