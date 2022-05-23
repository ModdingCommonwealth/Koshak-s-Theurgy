package com.koshakmine.theurgy.blocks;

import com.koshakmine.theurgy.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class AltarBlockEntity extends BlockEntity {

    public AltarBlockEntity(BlockPos pos, BlockState state) {
        super(Main.ALTAR_BLOCK_ENTITY, pos, state);
    }
}
