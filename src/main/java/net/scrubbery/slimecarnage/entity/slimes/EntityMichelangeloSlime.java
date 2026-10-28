package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityMichelangeloSlime extends GoodSlime
{
    public EntityMichelangeloSlime(EntityType<? extends GoodSlime> entityType, Level level)
    {
        super(entityType, level);
        this.fireImmune();
    }
}
