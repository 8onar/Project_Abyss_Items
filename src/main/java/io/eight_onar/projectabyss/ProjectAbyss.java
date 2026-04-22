package io.eight_onar.projectabyss;

import com.mojang.logging.LogUtils;
import io.eight_onar.projectabyss.item.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ProjectAbyss.MOD_ID)
public class ProjectAbyss
{
    public static final String MOD_ID = "eight_onarpaitm";

    private static final Logger LOGGER = LogUtils.getLogger();


    public ProjectAbyss(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        Items.register(modEventBus);
//        Blocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreativeTab);
        MinecraftForge.EVENT_BUS.register(this);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    public void addCreativeTab(BuildCreativeModeTabContentsEvent tabContentsEvent){
        if (tabContentsEvent.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            tabContentsEvent.accept(Items.PUPPY);
        }
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
