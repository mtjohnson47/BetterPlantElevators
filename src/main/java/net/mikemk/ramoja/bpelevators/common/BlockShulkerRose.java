package net.mikemk.ramoja.bpelevators.common;

import net.mikemk.ramoja.bpelevators.BPElevators;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockShulkerRose extends BlockBush {

	public BlockShulkerRose() {
		super();
		this.setUnlocalizedName(BPElevators.MODID + ".shulkerrose");
		this.setRegistryName("shulkerrose");
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "normal"));
	}

}
