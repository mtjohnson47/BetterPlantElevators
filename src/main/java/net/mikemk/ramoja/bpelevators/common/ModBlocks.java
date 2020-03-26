package net.mikemk.ramoja.bpelevators.common;

import net.mikemk.ramoja.bpelevators.BPElevators;
import net.mikemk.ramoja.bpelevators.common.block.BlockShulkerRose;
import net.mikemk.ramoja.bpelevators.common.block.tile.TEShulkerRose;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
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

	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new BlockShulkerRose());
		GameRegistry.registerTileEntity(TEShulkerRose.class, new ResourceLocation(BPElevators.MODID, "shulkerrose"));
	}
}
