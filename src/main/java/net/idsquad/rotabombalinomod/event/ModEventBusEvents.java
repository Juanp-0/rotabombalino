package net.idsquad.rotabombalinomod.event;

import net.idsquad.rotabombalinomod.RotabombalinoMod;
import net.idsquad.rotabombalinomod.entity.ModEntities;
import net.idsquad.rotabombalinomod.entity.client.TralaleroModel;
import net.idsquad.rotabombalinomod.entity.custom.TralaleroEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RotabombalinoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(TralaleroModel.LAYER_LOCATION, TralaleroModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
    event.put(ModEntities.TRALALERO.get(), TralaleroEntity.createAttributes().build());
    }
}
