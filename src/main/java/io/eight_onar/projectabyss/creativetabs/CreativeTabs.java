package io.eight_onar.projectabyss.creativetabs;

import io.eight_onar.projectabyss.ProjectAbyss;
import io.eight_onar.projectabyss.item.Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> MOD_CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectAbyss.MOD_ID);

public static final RegistryObject<CreativeModeTab> TAB_ABYSS_ITEMS = MOD_CREATIVE_TABS.register("tab_abyss_items",
        ()-> CreativeModeTab
                .builder()
                .icon(() -> Items.PUPPY.get().getDefaultInstance())
                .title(Component.translatable("ctab.abyss_items"))
                .displayItems((pParameters, output) -> {
                    Items.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
                }).build());

    public static void register(IEventBus eventBus){
        MOD_CREATIVE_TABS.register(eventBus);
    }
}
