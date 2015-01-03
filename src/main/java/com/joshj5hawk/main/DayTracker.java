package com.joshj5hawk.main;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.joshj5hawk.gui.DrawDay;
import com.joshj5hawk.handler.ConfigurationFile;
import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.proxies.CommonProxy;


@Mod(modid = Strings.modid, version = Strings.version, name = Strings.name)
public class DayTracker
{
	
	@SidedProxy(clientSide = "com.joshj5hawk.proxies.ClientProxy", serverSide = "com.joshj5hawk.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preInit)
	{
		//Config
		ConfigurationFile.init(preInit.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new DrawDay(Minecraft.getMinecraft()));
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent init)
	{
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postInit)
	{
		
	}
	
}