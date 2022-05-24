package com.koshakmine.theurgy.blocks;


import com.koshakmine.theurgy.Main;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class AltarBlockRenderer<T extends BlockEntity> implements BlockEntityRenderer {


    public AltarBlockRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(BlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(entity instanceof AltarBlockEntity altar) {
            ItemStack stack = altar.getStack(0);
            matrices.push();
            if(!altar.getStack(0).isEmpty()) {
                matrices.translate(0.5, 1.1, 0.5);
                int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
                MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

            } else {
                matrices.translate(0.5, 1.1, 0.5);
                int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
                MinecraftClient.getInstance().getItemRenderer().renderItem(ItemStack.EMPTY, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
            }
            matrices.pop();
        }
    }
}
