package net.mikemk.ramoja.bpelevators;

import org.apache.logging.log4j.Logger;

import net.mikemk.ramoja.bpelevators.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BPElevators.MODID, name = BPElevators.NAME, version = BPElevators.VERSION)
public class BPElevators
{
	public static final String MODID = "bpelevators";
	public static final String NAME = "Better Plant Elevators";
	public static final String VERSION = "0.1";

	public static Logger logger;
	
	@SidedProxy(clientSide = "net.mikemk.ramoja.bpelevators.client.ClientProxy", serverSide = "net.mikemk.ramoja.bpelevators.server.ServerProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance
	public static BPElevators instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
}