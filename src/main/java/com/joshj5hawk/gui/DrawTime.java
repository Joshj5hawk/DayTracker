package com.joshj5hawk.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DrawDay extends Gui
{
	private Minecraft mc;
	private int day;
	private int hour;
	private int minute;
	private int second;
	public DrawDay(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent
	public void drawDay(RenderGameOverlayEvent.Post event)
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
		
		int worldTime = (int)world.getWorldTime();
		
		int totalWorldTime = (int)world.getTotalWorldTime();
		
		int day = (int)world.getWorldTime() / 24000;
		
		long hour = world.getWorldTime() / 1000 ;
		
		float minute = (float)second / 60.0F;
		
		long second =  (long)(world.getWorldTime()*3.6) % 86400;
		
		minecraft.fontRendererObj.drawString("Day: " + (world.getWorldTime() / 24000), 575, 350, 0xffffff);
		minecraft.fontRendererObj.drawString("World Time: " + worldTime, 500, 340, 0xffffff);
		minecraft.fontRendererObj.drawString("Total World Time: " + totalWorldTime, 500, 330, 0xffffff);
		minecraft.fontRendererObj.drawString("Time: " + hour + (minute < 10 ? ":0" : ":") + (int)minute, 500, 320, 0xffffff);
		
	}
}
