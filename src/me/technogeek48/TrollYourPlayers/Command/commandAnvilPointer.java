package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandAnvilPointer implements CommandExecutor {
	private TrollYourPlayers plugin;

	public commandAnvilPointer(TrollYourPlayers trollYourPlayers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("anvilpointer")){
			Player player = (Player) sender;
			//get the targeted block
			Block targetBlock = player.getTargetBlock(null, Integer.MAX_VALUE);
			Location oneTargetLocation = new Location(player.getWorld(), targetBlock.getLocation().getBlockX(), targetBlock.getLocation().getBlockY() + 20, targetBlock.getLocation().getBlockZ());
			Location twoTargetLocation = new Location(player.getWorld(), targetBlock.getLocation().getBlockX(), targetBlock.getLocation().getBlockY() + 19, targetBlock.getLocation().getBlockZ());
			Location threeTargetLocation = new Location(player.getWorld(), targetBlock.getLocation().getBlockX(), targetBlock.getLocation().getBlockY() + 18, targetBlock.getLocation().getBlockZ());
			Location fourTargetLocation = new Location(player.getWorld(), targetBlock.getLocation().getBlockX(), targetBlock.getLocation().getBlockY() + 17, targetBlock.getLocation().getBlockZ());
			
			oneTargetLocation.getBlock().setType(Material.ANVIL);
			twoTargetLocation.getBlock().setType(Material.ANVIL);
			threeTargetLocation.getBlock().setType(Material.ANVIL);
			fourTargetLocation.getBlock().setType(Material.ANVIL);
		}
		return false;
	}

}
