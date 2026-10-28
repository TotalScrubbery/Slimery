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
        if (!this.level().isClientSide && hand == InteractionHand.OFF_HAND)
        {
            int i = rand.nextInt(6);
            if (i == 0)
            {
                player.sendSystemMessage(Component.literal("Doc: Marty, is that you?"));
            }

            if (i == 1) {
                player.sendSystemMessage(Component.literal("Doc: 1.21 Gigawatts!"));
            }

            if (i == 2) {
                player.sendSystemMessage(Component.literal("Doc: Great Scott!"));
            }

            if (i == 3) {
                player.sendSystemMessage(Component.literal("Doc: Roads? Where we're going we don't need roads."));
            }

            if (i == 4) {
                player.sendSystemMessage(Component.literal("Doc: 88 miles per hour."));
            }

            if (i == 5) {
                player.sendSystemMessage(Component.literal("Doc: I Finally Invent Something That Works!"));
            }
        }

        return InteractionResult.PASS;
    }

}
