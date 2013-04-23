package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandVoid implements CommandExecutor {

	public commandVoid(TrollYourPlayers trollYourPlayers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fallofdoom")){
			//cast player to sender
			Player player = (Player) sender;
			//cast player to args[0]
			Player target = player.getServer().getPlayer(args[0]);
			Location targetLocation = target.getLocation();
			int targetY = targetLocation.getBlockY();
			int targetX = targetLocation.getBlockX();
			int targetZ = targetLocation.getBlockZ();
			float targetYaw = targetLocation.getYaw();
			float targetPitch = targetLocation.getPitch();
			//Make a new location with the y axis jacked up.
			Location newLocation = new Location(target.getWorld(), targetX, targetY + 256, targetZ, targetYaw, targetPitch);
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "Please specify a player!");
				player.sendMessage(cmd.getUsage().toString());
			}else{
			target.teleport(newLocation);
			}
		}
		return true;
	}

}
