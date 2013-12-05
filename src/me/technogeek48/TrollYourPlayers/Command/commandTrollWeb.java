package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandTrollWeb implements CommandExecutor {

	public commandTrollWeb(TrollYourPlayers trollYourPlayers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("trollweb")){
			Player player = (Player) sender;
			Player target = (player.getServer().getPlayer(args[0]));
			
			if (args.length == 1 && target != null){
			Location targetLocation = target.getLocation();
			Location feetLocation = new Location(target.getWorld(), targetLocation.getX(), targetLocation.getY() -1, targetLocation.getZ());
			
			targetLocation.getBlock().setType(Material.WEB);
			feetLocation.getBlock().setType(Material.WEB);
			
			player.sendMessage(target.getDisplayName() + " has been trapped in webs");
			
			}else{
				player.sendMessage(ChatColor.RED + "Usage:");
				player.sendMessage(cmd.getUsage().toString());
			}
		}
		return true;
	}

}
