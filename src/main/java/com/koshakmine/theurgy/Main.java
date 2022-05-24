package com.koshakmine.theurgy;

import com.koshakmine.theurgy.blocks.AltarBlock;
import com.koshakmine.theurgy.blocks.AltarBlockEntity;
import com.koshakmine.theurgy.items.TheurgioumSword;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	static String MOD_ID = "theurgy";
	//Items
	public static final TheurgioumSword TheurgioumSword = new TheurgioumSword(ToolMaterials.NETHERITE, 7, -2.5F, new FabricItemSettings().maxCount(1));
	public static final Item BloodyEssence = new Item(new Item.Settings());
	public static final Item BloodyStone = new Item(new Item.Settings());
	public static final Item TheurgioumIngot = new Item(new Item.Settings());
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//Blocks
	public static final AltarBlock ALTAR_BLOCK = new AltarBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static BlockEntityType<AltarBlockEntity> ALTAR_BLOCK_ENTITY;



	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "theurgioum_sword"), TheurgioumSword);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "theurgioum_ingot"), TheurgioumIngot);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bloody_essence"), BloodyEssence);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bloody_stone"), BloodyStone);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "altar_block"), ALTAR_BLOCK);
		ALTAR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "theurgy:altar_block_entity", FabricBlockEntityTypeBuilder.create(AltarBlockEntity::new, ALTAR_BLOCK).build(null));

		//Events

		LOGGER.info("Loading all magic things...");
	}
	//Creative tabs
	public static final ItemGroup KoshaksTheurgyTab = FabricItemGroupBuilder.create(
					new Identifier(MOD_ID, "theurgytab"))
			.icon(() -> new ItemStack(BloodyEssence))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(TheurgioumSword));
				stacks.add(new ItemStack(TheurgioumIngot));
				stacks.add(new ItemStack(BloodyEssence));
				stacks.add(new ItemStack(BloodyStone));
			})
			.build();
}
