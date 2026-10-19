package net.scrubbery.slimecarnage.entity.slimes;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;


public class EntityLuigiSlime extends GoodSlime
{
    public EntityLuigiSlime(EntityType<? extends GoodSlime> entityType, Level level)
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
                player.sendSystemMessage(Component.literal("Luigi: I'm willing to bet there's something cold in here."));
            }

            if (i == 1) {
                player.sendSystemMessage(Component.literal("Luigi: Let's-a go."));
            }

            if (i == 2) {
                player.sendSystemMessage(Component.literal("Luigi: Okey dokey!"));
            }

            if (i == 3) {
                player.sendSystemMessage(Component.literal("Luigi: Come here, Doggie..."));
            }

            if (i == 4) {
                player.sendSystemMessage(Component.literal("Luigi: Luigi Time!"));
            }

            if (i == 5) {
                player.sendSystemMessage(Component.literal("Luigi: I'm-a Luigi, number one!"));
            }
        }

        return InteractionResult.PASS;
    }
}
