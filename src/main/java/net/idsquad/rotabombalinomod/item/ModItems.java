package net.idsquad.rotabombalinomod.item;

import net.idsquad.rotabombalinomod.RotabombalinoMod;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RotabombalinoMod.MOD_ID);

    public static final RegistryObject<Item> NUCLEO_TRALALERO = ITEMS.register("altar_core",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRALALERO_SCALE = ITEMS.register("tralalero_scale",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRALALERO_SHOES = ITEMS.register("tralalero_shoes",
            () -> new ArmorItem(ModArmorMaterials.TRALALERO_SCALE_MATERIAL, ArmorItem.Type.BOOTS,
            new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
