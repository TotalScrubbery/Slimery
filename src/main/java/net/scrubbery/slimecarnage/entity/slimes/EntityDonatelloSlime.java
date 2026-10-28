package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityDonatelloSlime extends GoodSlime
{
    public EntityDonatelloSlime(EntityType<? extends GoodSlime> entityType, Level level)
    {
        super(entityType, level);
        this.fireImmune();
    }
}
