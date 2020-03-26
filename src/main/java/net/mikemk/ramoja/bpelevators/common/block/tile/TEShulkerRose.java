package net.mikemk.ramoja.bpelevators.common.block.tile;

import java.util.List;
import java.util.Random;

import net.mikemk.ramoja.bpelevators.common.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

public class TEShulkerRose extends TileEntity implements ITickable {
	
	private static Random random;
	
	public TEShulkerRose() {
		super();
		if (random == null) {
			random = new Random();
		}
	}

	@Override
	public void update() {
		// This could be done every 10 or 20 ticks, but people will fall if there's any lag, so it's updating every tick.
		
		// Get a list of all entities in the operating range.  Flower pushes entities within 3x3x15 by default, with the middle
		// bottom row centered on the flower. 
		// There seems to be an off by one error here, if positive values are given to getPos().add().  Hence the 2 instead of 1.
		List<Entity> list = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(
                 getPos().add(-1, 0, -1), getPos().add(2, Config.shulkerRoseTime, 2)));
		for (Entity entity : list) {
			// If a player is sneaking, don't shoot them up.
			if (entity instanceof EntityPlayer && ((EntityPlayer)entity).isSneaking()) {
				continue;
			}
			// TODO: add a velocity cap
			// random velocity is so entities won't get stuck bouncing up and down on top of the shulker field.
			entity.addVelocity(random.nextDouble() * 0.01, 0.12, random.nextDouble() * 0.01);
		}
	}
}