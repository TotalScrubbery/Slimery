package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;


public class EntityOldManSlime extends GoodSlime
{
    public EntityOldManSlime(EntityType<? extends GoodSlime> entityType, Level level)
    {

        super(entityType, level);
        this.fireImmune();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand)
    {
        Random rand = new Random();
        if (!this.level().isClientSide && hand == InteractionHand.OFF_HAND)
        {
            int i = rand.nextInt(6);
            if (i == 0)
            {
                player.sendSystemMessage(Component.literal("Old Man: It's dangerous to go alone! Take this."));
            }

            if (i == 1) {
                player.sendSystemMessage(Component.literal("Old Man: Eastmost penninsula is the secret."));
            }

            if (i == 2) {
                player.sendSystemMessage(Component.literal("Old Man: Take any one you want."));
            }

            if (i == 3) {
                player.sendSystemMessage(Component.literal("Old Man: Show This to the old woman."));
            }

            if (i == 4) {
                player.sendSystemMessage(Component.literal("Old Man: Take any road you want."));
            }

            if (i == 5) {
                player.sendSystemMessage(Component.literal("Old Man: Dodongo dislikes smoke."));
            }
        }

        return InteractionResult.PASS;
    }
}
