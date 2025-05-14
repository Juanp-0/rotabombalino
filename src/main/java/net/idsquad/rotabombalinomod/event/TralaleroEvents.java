package net.idsquad.rotabombalinomod.event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.idsquad.rotabombalinomod.RotabombalinoMod;
import net.idsquad.rotabombalinomod.item.ModItems;

@Mod.EventBusSubscriber(modid = RotabombalinoMod.MOD_ID)
public class TralaleroEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!player.level().isClientSide && event.phase == TickEvent.Phase.END) {
            ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
            if (boots.getItem() == ModItems.TRALALERO_SHOES.get()) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.MOVEMENT_SPEED,
                        100,  //
                        3,
                        false, false, true
                ));
            }
        }
    }
}
