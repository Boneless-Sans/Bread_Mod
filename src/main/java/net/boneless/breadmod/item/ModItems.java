package net.boneless.breadmod.item;

import net.boneless.breadmod.BreadMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, BreadMod.MOD_ID);

    public static final RegistryObject<Item> BREAD_INGOT = ITEM.register("bread_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEM.register(eventBus);
    }
}
