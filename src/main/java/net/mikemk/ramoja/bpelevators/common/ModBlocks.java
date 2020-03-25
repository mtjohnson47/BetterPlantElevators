package net.mikemk.ramoja.bpelevators.common;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

	private ModBlocks() {
	}
	
	@ObjectHolder("bpelevators:shulkerrose")
	public static BlockShulkerRose shulkerRose;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		shulkerRose.initModel();
	}
}
