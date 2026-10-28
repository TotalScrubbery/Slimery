package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.Level;
import net.scrubbery.slimecarnage.SlimeSounds;

public class EntityVillagerSlime extends Villager
{

    public EntityVillagerSlime(EntityType<? extends Villager> entityType, Level level)
    {
        super(entityType, level, VillagerType.PLAINS);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SLIME_SQUISH_SMALL;
    }

}
