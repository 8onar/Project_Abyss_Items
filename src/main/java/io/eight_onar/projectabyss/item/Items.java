package io.eight_onar.projectabyss.item;

import io.eight_onar.projectabyss.ProjectAbyss;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectAbyss.MOD_ID);

    public static final RegistryObject<Item> PUPPY = ITEMS.register("puppy",
            () -> new Item(new Item.Properties().stacksTo(42)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
