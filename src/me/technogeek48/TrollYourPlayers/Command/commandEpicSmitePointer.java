package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandEpicSmitePointer implements CommandExecutor {
	//private TrollYourPlayers plugin;

	public commandEpicSmitePointer(TrollYourPlayers trollYourPlayers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("epicsmitepointer")){
			Player player = (Player) sender;
			
			Block targetBlock = player.getTargetBlock(null, Integer.MAX_VALUE);
			Location targetLocation = targetBlock.getLocation();
			Location anvilTarget = new Location(player.getWorld(), targetLocation.getBlockX(), targetLocation.getBlockY() + 20, targetLocation.getBlockZ());
			
			targetLocation.getWorld().strikeLightning(targetLocation);
			targetLocation.getWorld().strikeLightning(targetLocation);
			targetLocation.getWorld().createExplosion(targetLocation, 5);
			targetLocation.getWorld().createExplosion(targetLocation, 5);
			anvilTarget.getBlock().setType(Material.ANVIL);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			anvilTarget.getBlock().setType(Material.LAVA);
			
			
		}
		return true;
	}

}
