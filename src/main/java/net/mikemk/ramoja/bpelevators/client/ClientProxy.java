package net.mikemk.ramoja.bpelevators.client;

import net.mikemk.ramoja.bpelevators.BPElevators;
import net.mikemk.ramoja.bpelevators.common.CommonProxy;
import net.mikemk.ramoja.bpelevators.common.ModBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		BPElevators.logger.info("model registration started");
		ModBlocks.initModels();
		BPElevators.logger.info("model registration ended");
	}
}
