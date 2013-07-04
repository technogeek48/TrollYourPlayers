package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandEpicSmite implements CommandExecutor {
	//private TrollYourPlayers plugin;

	public commandEpicSmite(TrollYourPlayers trollYourPlayers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("epicsmite")){
			//credits to greatsword9 for base idea
			Player player = (Player) sender;
			Player target = (player.getServer().getPlayer(args[0]));
			if(args.length == 1){
				Location targetLocation = target.getLocation();
				Location anvilTarget = new Location(target.getWorld(), targetLocation.getBlockX(), targetLocation.getBlockY() + 25, targetLocation.getBlockZ());
				targetLocation.getWorld().strikeLightning(targetLocation);
				targetLocation.getWorld().strikeLightning(targetLocation);
				targetLocation.getWorld().createExplosion(targetLocation, 5);
				targetLocation.getWorld().createExplosion(targetLocation, 5);
				anvilTarget.getBlock().setType(Material.ANVIL);
				
			}else{
				player.sendMessage(ChatColor.RED + "Usage:");
				player.sendMessage(cmd.getUsage().toString());
			}
		}
		return true;
	}

}
