package net.scrubbery.slimecarnage;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.scrubbery.slimecarnage.Items.ModItems;
import net.scrubbery.slimecarnage.Items.SlimeTab;
import net.scrubbery.slimecarnage.block.ModBlocks;
import net.scrubbery.slimecarnage.entity.ModEntities;
import net.scrubbery.slimecarnage.entity.client.*;
import net.scrubbery.slimecarnage.particle.*;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(SlimeCarnage.MOD_ID)
public class SlimeCarnage
{
    public static final String MOD_ID = "slimecarnage";
       public static final Logger LOGGER = LogUtils.getLogger();
    public SlimeCarnage(IEventBus modEventBus, ModContainer modContainer)
    {

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        SlimeTab.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.ENTITY_TYPES.register(modEventBus);

        ModParticles.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.ORANGEGEL);
            event.accept(ModItems.YELLOWGEL);
            event.accept(ModItems.GREENGEL);
            event.accept(ModItems.REDGEL);
            event.accept(ModItems.BLUEGEL);
            event.accept(ModItems.PURPLEGEL);
            event.accept(ModItems.GREYGEL);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            event.accept(ModBlocks.ORANGE_SLIME_BLOCK);
            event.accept(ModBlocks.RED_SLIME_BLOCK);
            event.accept(ModBlocks.BLUE_SLIME_BLOCK);
            event.accept(ModBlocks.YELLOW_SLIME_BLOCK);

        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntities.MOBORANGESLIME.get(), OrangeSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBYELLOWSLIME.get(), YellowSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBBLUESLIME.get(), BlueSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBREDSLIME.get(), RedSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBGREENSLIME.get(), GreenSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBCAMOSLIME.get(), CamoSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBCACTUSSLIME.get(), CactusSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBMONKEYSLIME.get(), MonkeySlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBCAVESLIME.get(), CaveSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBFIERYSLIME.get(), FierySlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBMOOSLIME.get(), MooSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MOBUNDERSLIME.get(), UnderSlimeRenderer::new);

            //NPCs
            EntityRenderers.register(ModEntities.NPCOLDMANSLIME.get(), OldManSlimeRenderer::new);
            EntityRenderers.register(ModEntities.NPCDOCSLIME.get(), DocSlimeRenderer::new);
            EntityRenderers.register(ModEntities.NPCMARIOSLIME.get(), MarioSlimeRenderer::new);
            EntityRenderers.register(ModEntities.NPCLUIGISLIME.get(), LuigiSlimeRenderer::new);
        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event)
        {
            event.registerSpriteSet(ModParticles.ORANGE_SLIME_PARTICLES.get(), OrangeSlimeParticles.Provider::new);
            event.registerSpriteSet(ModParticles.BLUE_SLIME_PARTICLES.get(), BlueSlimeParticles.Provider::new);
            event.registerSpriteSet(ModParticles.RED_SLIME_PARTICLES.get(), RedSlimeParticles.Provider::new);
            event.registerSpriteSet(ModParticles.YELLOW_SLIME_PARTICLES.get(), YellowSlimeParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GREEN_SLIME_PARTICLES.get(), GreenSlimeParticles.Provider::new);
            event.registerSpriteSet(ModParticles.MONKEY_SLIME_PARTICLES.get(), MonkeySlimeParticles.Provider::new);
        }

    }
}
