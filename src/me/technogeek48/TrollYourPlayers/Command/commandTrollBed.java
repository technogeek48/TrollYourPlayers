package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandTrollBed implements CommandExecutor {
	//private TrollYourPlayers plugin;

	public commandTrollBed(TrollYourPlayers plugin) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("trollanvil")){
			Player player = (Player) sender;
			Player target = player.getServer().getPlayer(args[0]);
			Location currentTargetLocation = target.getLocation();
			int targetX = currentTargetLocation.getBlockX();
			int targetY = currentTargetLocation.getBlockY();
			int targetZ = currentTargetLocation.getBlockZ();
			Location newTargetLocation = new Location(target.getWorld(), targetX, targetY + 20, targetZ);
			Location oneTargetLocation = new Location(target.getWorld(), targetX, targetY + 19, targetZ);
			Location twoTargetLocation = new Location(target.getWorld(), targetX, targetY + 18, targetZ);
			Location threeTargetLocation = new Location(target.getWorld(), targetX, targetY + 17, targetZ);
			oneTargetLocation.getBlock().setType(Material.ANVIL);
			twoTargetLocation.getBlock().setType(Material.ANVIL);
			threeTargetLocation.getBlock().setType(Material.ANVIL);
			newTargetLocation.getBlock().setType(Material.ANVIL);
		}
		return true;
	}

}
