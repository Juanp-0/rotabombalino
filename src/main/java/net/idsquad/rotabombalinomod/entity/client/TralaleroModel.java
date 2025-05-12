package net.idsquad.rotabombalinomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.idsquad.rotabombalinomod.RotabombalinoMod;
import net.idsquad.rotabombalinomod.entity.custom.TralaleroEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TralaleroModel<T extends TralaleroEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RotabombalinoMod.MOD_ID,"tralalero"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public TralaleroModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("upper").getChild("neck").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 10.3F, -3.0F));

        PartDefinition upper = body.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -6.0F, -12.0F, 8.0F, 8.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(0, 29).addBox(-1.0F, -5.0F, -11.0F, 2.0F, 6.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(42, 29).addBox(-11.0F, -5.0F, -11.0F, 2.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = upper.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(78, 67).addBox(1.0F, -5.0F, 1.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -5.1F, -7.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r2 = upper.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(42, 87).addBox(2.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -12.1F, -4.3F, -0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r3 = upper.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 79).addBox(2.0F, -3.0F, 2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -9.1F, -6.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition leg = upper.addOrReplaceChild("leg", CubeListBuilder.create(), PartPose.offset(2.7F, 5.6F, 8.5F));

        PartDefinition cube_r4 = leg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 87).addBox(0.0F, -3.0F, -18.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0114F, -0.0005F, 1.4843F));

        PartDefinition cube_r5 = leg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(86, 52).addBox(-2.0F, -3.0F, -18.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 1.0F, 0.0F, -0.0556F, 0.1186F, 1.1312F));

        PartDefinition cube_r6 = leg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 84).addBox(-2.0F, -3.0F, -18.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, -1.6F, -0.5F, -0.1005F, 0.084F, 0.6939F));

        PartDefinition shoe = leg.addOrReplaceChild("shoe", CubeListBuilder.create().texOffs(84, 27).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(54, 67).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(72, 22).addBox(-3.0F, 1.0F, -6.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(30, 54).addBox(-3.0F, 3.0F, -6.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 4.0F, -18.0F));

        PartDefinition leg2 = upper.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(-12.7F, 5.6F, 8.5F));

        PartDefinition cube_r7 = leg2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(86, 63).addBox(-3.0F, -3.0F, -18.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0114F, 0.0005F, -1.4843F));

        PartDefinition cube_r8 = leg2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(66, 85).addBox(-2.0F, -3.0F, -18.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 1.0F, 0.0F, -0.0556F, -0.1186F, -1.1312F));

        PartDefinition cube_r9 = leg2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(80, 81).addBox(-2.0F, -3.0F, -18.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, -1.6F, -0.5F, -0.1005F, -0.084F, -0.6939F));

        PartDefinition shoe2 = leg2.addOrReplaceChild("shoe2", CubeListBuilder.create().texOffs(84, 33).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 69).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 79).addBox(-2.0F, 1.0F, -6.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(58, 0).addBox(-2.0F, 3.0F, -6.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 4.0F, -18.0F));

        PartDefinition neck = upper.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(-5.0F, 1.0F, -5.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(66, 77).addBox(-2.0F, -5.0F, -16.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(30, 65).addBox(-3.0F, -6.0F, -13.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(58, 22).addBox(-2.0F, -3.0F, -19.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition lower = body.addOrReplaceChild("lower", CubeListBuilder.create(), PartPose.offset(-1.0F, 7.9F, 9.0F));

        PartDefinition leg3 = lower.addOrReplaceChild("leg3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r10 = leg3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(24, 87).addBox(0.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r11 = leg3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(84, 45).addBox(0.0F, -4.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.0F, -2.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition shoe3 = leg3.addOrReplaceChild("shoe3", CubeListBuilder.create().texOffs(84, 39).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 77).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(80, 76).addBox(-2.0F, 1.0F, -6.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(58, 11).addBox(-2.0F, 3.0F, -6.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.7F, -0.9F));

        PartDefinition tail = lower.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(-1.5F, -2.0F, 24.0F));

        PartDefinition cube_r12 = tail.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(24, 69).addBox(2.0F, -4.0F, 1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r13 = tail.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(86, 56).addBox(2.0F, -4.0F, 1.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r14 = tail.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(14, 84).addBox(2.0F, -4.0F, 1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, -2.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r15 = tail.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(48, 77).addBox(1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.5F, -4.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition tail3 = lower.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offset(0.0F, -7.9F, 4.0F));

        PartDefinition Tail3_r1 = tail3.addOrReplaceChild("Tail3_r1", CubeListBuilder.create().texOffs(0, 54).addBox(-2.0F, -5.0F, -4.0F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition tail2 = lower.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offset(0.0F, -6.9F, 13.0F));

        PartDefinition Tail2_r1 = tail2.addOrReplaceChild("Tail2_r1", CubeListBuilder.create().texOffs(60, 54).addBox(-1.0F, -4.0F, -4.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(TralaleroEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(TralaleroAnimations.tralalerotralala_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, TralaleroAnimations.tralalerotralala_idle, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root(){
        return body;
    }
}
