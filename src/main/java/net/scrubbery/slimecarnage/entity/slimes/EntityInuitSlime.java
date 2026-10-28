package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;


public class EntityInuitSlime extends GoodSlime
{
    public EntityInuitSlime(EntityType<? extends GoodSlime> entityType, Level level)
    {

        super(entityType, level);
        this.fireImmune();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand)
    {
        Random rand = new Random();
        if (!this.level().isClientSide  && hand == InteractionHand.OFF_HAND)
        {
            int i = rand.nextInt(6);
            if (i == 0)
            {
                player.sendSystemMessage(Component.literal("Roger: Beware of bears."));
            }

            if (i == 1) {
                player.sendSystemMessage(Component.literal("Roger: Bit nippy out there"));
            }

            if (i == 2) {
                player.sendSystemMessage(Component.literal("Roger: AVALANCHE!"));
            }

            if (i == 3) {
                player.sendSystemMessage(Component.literal("Roger: All I see is white for miles."));
            }

            if (i == 4) {
                player.sendSystemMessage(Component.literal("Roger: An iceberg crashed into my house!"));
            }

            if (i == 5) {
                player.sendSystemMessage(Component.literal("Roger: Woah!"));
            }
        }

        return InteractionResult.PASS;
    }
}
