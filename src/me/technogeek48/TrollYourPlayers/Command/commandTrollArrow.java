package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

public class commandTrollArrow implements CommandExecutor {

	private TrollYourPlayers plugin;

	public commandTrollArrow(TrollYourPlayers plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		int arrowStatus = 0;
		
		if(cmd.getName().equalsIgnoreCase("trollarrow")){
			if(args[0].equalsIgnoreCase("on")){
				arrowStatus = 1;
			}else if(args[0].equalsIgnoreCase("off")){
				arrowStatus = 0;
			}
			if(arrowStatus == 1){
				while (arrowStatus == 1){
					player.launchProjectile(Arrow.class);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				}
			}
		}
		
		return true;
	}

}
