package net.idsquad.rotabombalinomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.idsquad.rotabombalinomod.RotabombalinoMod;
import net.idsquad.rotabombalinomod.entity.custom.TralaleroEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TralaleroRenderer extends MobRenderer<TralaleroEntity, TralaleroModel<TralaleroEntity>> {


    public TralaleroRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TralaleroModel<>(pContext.bakeLayer(TralaleroModel.LAYER_LOCATION)), 0.90f);
    }

    @Override
    public ResourceLocation getTextureLocation(TralaleroEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(RotabombalinoMod.MOD_ID,"textures/entity/tralalero/tralalero_gray.png");
    }

    @Override
    public void render(TralaleroEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        // Escalado personalizado para que el boss se vea más grande
        pPoseStack.scale(2.5f, 2.5f, 2.5f);

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }



}
