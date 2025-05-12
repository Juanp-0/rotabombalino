package net.idsquad.rotabombalinomod.entity;

import net.idsquad.rotabombalinomod.RotabombalinoMod;
import net.idsquad.rotabombalinomod.entity.custom.TralaleroEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RotabombalinoMod.MOD_ID);

    public static final RegistryObject<EntityType<TralaleroEntity>> TRALALERO =
            ENTITY_TYPES.register("tralalero", () -> EntityType.Builder.of(TralaleroEntity::new, MobCategory.CREATURE)
                    .sized(3f,3f).build("tralalero"));

    public static void  register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
