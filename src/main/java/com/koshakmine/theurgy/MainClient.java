package com.koshakmine.theurgy;

import com.koshakmine.theurgy.blocks.AltarBlockEntity;
import com.koshakmine.theurgy.blocks.AltarBlockRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class MainClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(Main.ALTAR_BLOCK_ENTITY, AltarBlockRenderer::new);
    }
}
