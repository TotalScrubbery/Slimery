package net.scrubbery.slimecarnage.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.scrubbery.slimecarnage.Items.ModItems;
import net.scrubbery.slimecarnage.SlimeCarnage;
import org.slf4j.Logger;

public class EntityNinjaStar extends ThrowableItemProjectile {

    public EntityNinjaStar(EntityType<? extends EntityNinjaStar> entityType, Level level)
    {
        super(entityType, level);
    }

    public EntityNinjaStar(Level level, LivingEntity shooter) {
        super(ModEntities.NINJASTAR.get(), shooter, level);
    }

    public EntityNinjaStar(Level level, double x, double y, double z) {
        super(ModEntities.NINJASTAR.get(), x, y, z, level);
    }

    /*public EntityNinjaStar(LivingEntity shooter, Level level) {
        super(ModEntities.NINJASTAR.get(), shooter, level, new ItemStack(ModItems.NINJASTAR.get()), null);
    }*/

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 3.0f);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    /*@Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.NINJASTAR.get());
    }*/

    @Override
    protected Item getDefaultItem() {
        return new ItemStack(ModItems.NINJASTAR.get()).getItem();
    }
}
