package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.scrubbery.slimecarnage.entity.slimes.BadSlime;

public class EntityMooSlime extends BadSlime
{
    public EntityMooSlime(EntityType<? extends BadSlime> entityType, Level level)
    {
        super(entityType, level);
        this.setLevel(1);
    }

}