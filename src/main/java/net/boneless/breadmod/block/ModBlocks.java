package net.boneless.breadmod.block;

import net.boneless.breadmod.BreadMod;
import net.boneless.breadmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BreadMod.MOD_ID);

    public static final RegistryObject<Block> BREAD_BLOCK = registerBlock("bread_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK)));
    public static final RegistryObject<Block> POLISHED_BREAD_BLOCK = registerBlock("polished_bread_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> HARDENED_BREAD_BLOCK = registerBlock("hardened_bread_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANVIL)));

    //setup
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
