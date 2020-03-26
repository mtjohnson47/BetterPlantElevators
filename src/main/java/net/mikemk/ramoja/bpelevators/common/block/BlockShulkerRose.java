package net.mikemk.ramoja.bpelevators.common.block;

import net.mikemk.ramoja.bpelevators.BPElevators;
import net.mikemk.ramoja.bpelevators.common.block.tile.TEShulkerRose;
import net.minecraft.block.BlockBush;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockShulkerRose extends BlockBush implements ITileEntityProvider {

	public BlockShulkerRose() {
		super();
		this.setUnlocalizedName(BPElevators.MODID + ".shulkerrose");
		this.setRegistryName("shulkerrose");
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "normal"));
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TEShulkerRose();
	}
}
