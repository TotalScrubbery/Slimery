package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;


public class EntityMarioSlime extends GoodSlime
{
    public EntityMarioSlime(EntityType<? extends GoodSlime> entityType, Level level)
    {

        super(entityType, level);
        this.fireImmune();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand)
    {
        Random rand = new Random();
        if (!this.level().isClientSide)
        {
            int i = rand.nextInt(6);
            if (i == 0)
            {
                player.sendSystemMessage(Component.literal("Mario: It's a-me, Mario!"));
            }

            if (i == 1) {
                player.sendSystemMessage(Component.literal("Mario: Let's-a go."));
            }

            if (i == 2) {
                player.sendSystemMessage(Component.literal("Mario: A-wa-wa-wa-wa-wa!"));
            }

            if (i == 3) {
                player.sendSystemMessage(Component.literal("Mario: Here we go!"));
            }

            if (i == 4) {
                player.sendSystemMessage(Component.literal("Mario: Wa-hoo!"));
            }

            if (i == 5) {
                player.sendSystemMessage(Component.literal("Mario: Luigi!"));
            }
        }

        return InteractionResult.PASS;
    }

}
