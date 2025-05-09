package net.idsquad.rotabombalinomod.block;

import net.idsquad.rotabombalinomod.RotabombalinoMod;
import net.idsquad.rotabombalinomod.block.custom.InvocationAltarBlock;
import net.idsquad.rotabombalinomod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister <Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RotabombalinoMod.MOD_ID);

    public static final RegistryObject<Block> ALTAR_ROTABOMBALINO = registerBlock("invocation_altar",
            () -> new InvocationAltarBlock(BlockBehaviour.Properties.of().noOcclusion().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)
                    .lightLevel(state -> state.getValue(InvocationAltarBlock.CLICKED) ? 15 : 0)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
