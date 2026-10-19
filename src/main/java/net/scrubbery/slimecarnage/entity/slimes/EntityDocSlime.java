package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;


public class EntityDocSlime extends GoodSlime
{
    public EntityDocSlime(EntityType<? extends GoodSlime> entityType, Level level)
    {

        super(entityType, level);
        this.fireImmune();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand)
    {
        Random rand = new Random();
        int i = rand.nextInt(6);
        //if (!player.level().isClientSide)

            if (i == 0 && !player.level().isClientSide)
            {
                player.sendSystemMessage(Component.literal("Doc: Marty, is that you?"));
                return InteractionResult.PASS;
            }
            else if (i == 1 && !player.level().isClientSide)
            {
                player.sendSystemMessage(Component.literal("Doc: 1.21 Gigawatts!"));
                return InteractionResult.PASS;
            }
            else if (i == 2 && !player.level().isClientSide)
            {
                player.sendSystemMessage(Component.literal("Doc: Great Scott!"));
                return InteractionResult.PASS;
            }
            else if (i == 3 && !player.level().isClientSide)
            {
                player.sendSystemMessage(Component.literal("Doc: Roads? Where we're going we don't need roads."));
                return InteractionResult.PASS;
            }
            else if (i == 4 && !player.level().isClientSide)
            {
                player.sendSystemMessage(Component.literal("Doc: 88 miles per hour."));
                return InteractionResult.PASS;
            }
            else if (i == 5 && !player.level().isClientSide)
            {
                player.sendSystemMessage(Component.literal("Doc: I Finally Invent Something That Works!"));
                return InteractionResult.PASS;
            }
            else
            {
                return InteractionResult.FAIL;
            }


        //return InteractionResult.FAIL;

    }

}
