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
		if(cmd.getName().equalsIgnoreCase("void")){
			Player player = (Player) sender;
			Player target = (player.getServer().getPlayer(args[0]));
			
			if (args.length == 1)
			{
			Location currentTargetLocation = target.getLocation();
			int currentX = currentTargetLocation.getBlockX();
			int newY = -14;
			int currentZ = currentTargetLocation.getBlockZ();
			
			Location newTargetLocation = new Location(target.getWorld(), currentX, newY, currentZ);
			target.teleport(newTargetLocation);
			}else{
				player.sendMessage(ChatColor.RED + "Usage:");
				player.sendMessage(cmd.getUsage().toString());
			}
		}
		return true;
	}

}
