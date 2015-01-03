package com.joshj5hawk.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.joshj5hawk.lib.Strings;

public class ConfigurationFile 
{
	public static Configuration config;
	public static boolean debug = false;
	//public static float summoningRotationSpeed;
	
	public static void init(File configFile)
	{
		//Creates Config Files
		if(config == null)
		{
			config = new Configuration(configFile);
			loadConfiguration();
		}
	}
	
	private static void loadConfiguration()
	{
		debug = config.getBoolean("debugMode", Configuration.CATEGORY_GENERAL, false, "Debug Mode: Displays WorldTime on screen");
		
		if(config.hasChanged())
		{
			config.save();
		}
	}
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Strings.modid))
		{
			loadConfiguration();
		}
	}
}
