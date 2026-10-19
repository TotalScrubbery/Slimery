package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

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

    @Override
    public void setSize(int size, boolean resetHealth)
    {
        this.xpReward = size  * 2;
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0);
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5F);
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1.0);

        this.reapplyPosition();
        this.refreshDimensions();
        if (resetHealth)
        {
            this.setHealth(this.getMaxHealth());
        }
    }

    @Override
    protected float getAttackDamage()
    {
        return super.getAttackDamage() + 2.0F;
    }

}