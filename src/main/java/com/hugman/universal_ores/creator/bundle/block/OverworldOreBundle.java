package com.hugman.universal_ores.creator.bundle.block;

import com.hugman.dawn.api.creator.BlockCreator;
import com.hugman.dawn.api.creator.bundle.Bundle;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class OverworldOreBundle extends Bundle {
	private final BlockCreator COAL_ORE, IRON_ORE, GOLD_ORE, COPPER_ORE, LAPIS_ORE, REDSTONE_ORE, EMERALD_ORE, DIAMOND_ORE;

	/**
	 * Creates a creator bundle containing all vanilla ores in a certain block.
	 *
	 * @param name     The name of the block in which the ores will be in. (example: "granite")
	 * @param settings The block settings for all the ores.
	 */
	public OverworldOreBundle(String name, AbstractBlock.Settings settings) {
		BlockCreator.Builder builder = new BlockCreator.Builder().settings(settings).itemGroup(ItemGroup.BUILDING_BLOCKS);
		COAL_ORE = put(builder.copy().name(name + "_coal_ore").provider(s -> new OreBlock(s, UniformIntProvider.create(0, 2))).build());
		IRON_ORE = put(builder.copy().name(name + "_iron_ore").provider(OreBlock::new).build());
		COPPER_ORE = put(builder.copy().name(name + "_copper_ore").provider(OreBlock::new).build());
		GOLD_ORE = put(builder.copy().name(name + "_gold_ore").provider(OreBlock::new).build());
		REDSTONE_ORE = put(builder.copy().name(name + "_redstone_ore").provider(RedstoneOreBlock::new).settings(FabricBlockSettings.copyOf(settings).ticksRandomly().luminance((state) -> (Boolean) state.get(Properties.LIT) ? 9 : 0)).build());
		EMERALD_ORE = put(builder.copy().name(name + "_emerald_ore").provider(s -> new OreBlock(s, UniformIntProvider.create(3, 7))).build());
		LAPIS_ORE = put(builder.copy().name(name + "_lapis_ore").provider(s -> new OreBlock(s, UniformIntProvider.create(2, 5))).build());
		DIAMOND_ORE = put(builder.copy().name(name + "_diamond_ore").provider(s -> new OreBlock(s, UniformIntProvider.create(3, 7))).build());
	}

	public Block coal() {
		return COAL_ORE.getValue();
	}

	public Block iron() {
		return IRON_ORE.getValue();
	}

	public Block gold() {
		return GOLD_ORE.getValue();
	}

	public Block copper() {
		return COPPER_ORE.getValue();
	}

	public Block lapis() {
		return LAPIS_ORE.getValue();
	}

	public Block redstone() {
		return REDSTONE_ORE.getValue();
	}

	public Block emerald() {
		return EMERALD_ORE.getValue();
	}

	public Block diamond() {
		return DIAMOND_ORE.getValue();
	}
}
