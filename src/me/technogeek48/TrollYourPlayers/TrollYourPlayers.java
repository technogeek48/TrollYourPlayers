package me.technogeek48.TrollYourPlayers;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TrollYourPlayers extends JavaPlugin {
	
	public void onEnable(){
		getLogger().info("Loaded TrollYourPlayers v.0.1");
	}
	
	public void onDisable(){
		getLogger().info("Unloaded TrollYourPlayers v.0.1");
	}
	
	//------------------------------//
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("silentsmite")){ // If the player typed /silentsmite then do the following...
			Player player = (Player) sender;
			Location pos = player.getLocation();
			String locstring = pos.toString();
			locstring.replaceAll("{"+"}", " ");
			//Location smiteRadius = player.getLocation().toString().replace("X, replacement);
			player.sendMessage("Debug Command");
			player.sendMessage("smiting you, your position is: " + locstring);
			player.getWorld().strikeLightning(pos);
			return true;
		} else if (cmd.getName().equalsIgnoreCase("trollmode")) {
			int trollmode;
			Player player = (Player) sender;
			if(player.getFlySpeed() == -1){
				trollmode = 0;
			} else {
				trollmode = 1;
			}
			if(trollmode == 0){
				player.sendMessage("Enabled TrollMode for " + player.getName());
				player.setAllowFlight(true);
				player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
			}else{
				
			}
			return true;
		}
		return false;
}
}
