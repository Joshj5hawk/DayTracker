package com.joshj5hawk.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.joshj5hawk.handler.ConfigurationFile;

public class DrawDay
{
	private Minecraft mc;
	public DrawDay(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent
	public void drawDay(RenderGameOverlayEvent.Text event)
	{
		if (event.isCancelable() || event.type != ElementType.TEXT)
		{
			return;
		}
		render(mc);
	}
	
	public void render(Minecraft minecraft)
	{
		WorldClient world = Minecraft.getMinecraft().theWorld;
		int h = minecraft.displayHeight / 2;
		int w = minecraft.displayWidth / 2;
		int worldTime = (int)world.getWorldTime();
		
		minecraft.fontRendererObj.drawString("Day: " + (world.getWorldTime() < 24000 ? "1" : (world.getWorldTime() / 24000 + 1)), h, w, 0xffffff);
		
		if(ConfigurationFile.debug == true)
		{
			minecraft.fontRendererObj.drawString("World Time: " + worldTime, 500, 340, 0xffffff);
		}
		
	}
}
