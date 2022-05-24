package com.koshakmine.theurgy.blocks;

import com.koshakmine.theurgy.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class AltarBlockEntity extends BlockEntity implements Inventory {

    public AltarBlockEntity(BlockPos pos, BlockState state) {
        super(Main.ALTAR_BLOCK_ENTITY, pos, state);
    }
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, new ItemStack(Main.BloodyStone));
    @Override
    public int size() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack stack = Inventories.splitStack(inventory, slot, amount);
        return stack;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack stack = Inventories.removeStack(inventory, slot);
        return stack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        inventory.set(slot, stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return !(player.squaredDistanceTo(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) > 64.0D);
    }

    @Override
    public void clear() {
        inventory.clear();
    }
}
