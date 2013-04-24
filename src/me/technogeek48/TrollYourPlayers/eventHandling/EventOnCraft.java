package me.technogeek48.TrollYourPlayers.eventHandling;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

public class EventOnCraft implements Listener{
	private TrollYourPlayers plugin;
	
	@EventHandler
	public void CraftItemEvent(CraftItemEvent event){
		Material recipyResult = event.getRecipe().getResult().getType();
		ItemStack recipyItem = event.getRecipe().getResult();
		if(recipyResult == Material.BED);{
			recipyItem.setType(Material.SPONGE);
		}
		
	}
}
