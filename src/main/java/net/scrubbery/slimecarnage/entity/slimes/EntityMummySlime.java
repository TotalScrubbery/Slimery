package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityMummySlime extends BadSlime
{
    public EntityMummySlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setLevel(1);
    }

}