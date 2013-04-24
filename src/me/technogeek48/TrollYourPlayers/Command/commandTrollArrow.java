package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandTrollArrow implements CommandExecutor {

	private TrollYourPlayers plugin;

	public commandTrollArrow(TrollYourPlayers plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		Player target = (player.getServer().getPlayer(args[0]));
		
		if(cmd.getName().equalsIgnoreCase("trollarrow")){
			Location arrowTargetLocation = new Location(target.getWorld(), target.getLocation().getBlockX(), target.getLocation().getBlockY() + 15, target.getLocation().getBlockZ());
			target.getWorld().spawnArrow(arrowTargetLocation, player.getLocation().getDirection(), 10, 0);
		}
		return true;
	}

}
