package net.idsquad.rotabombalinomod.item;

import net.idsquad.rotabombalinomod.RotabombalinoMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RotabombalinoMod.MOD_ID);


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
