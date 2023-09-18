package net.boneless.breadmod.item;

import net.boneless.breadmod.BreadMod;
import net.boneless.breadmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BreadMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> Bread_TAB = CREATIVE_MODE_TABS.register("bread_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BREAD_INGOT.get()))
                    .title(Component.translatable("creativetab.bread_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //base items first, polished, then hardned, than polished hardened

                        //base
                        pOutput.accept(ModItems.BREAD_INGOT.get());
                        pOutput.accept(ModItems.BREAD_STICK.get());

                        pOutput.accept(ModBlocks.BREAD_BLOCK.get());

                        //polished
                        pOutput.accept(ModBlocks.POLISHED_BREAD_BLOCK.get());

                        //hardened
                        pOutput.accept(ModBlocks.HARDENED_BREAD_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
