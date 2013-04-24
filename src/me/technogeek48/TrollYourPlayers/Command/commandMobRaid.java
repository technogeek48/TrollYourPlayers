package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class commandMobRaid implements CommandExecutor {
	//private TrollYourPlayers plugin;

	public commandMobRaid(TrollYourPlayers trollYourPlayers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("mobraid")){
			//Credits to greatsword9 for the base idea
			Player player = (Player) sender;
			Player target = (player.getServer().getPlayer(args[0]));
			
			if(args.length == 1){
			Location currentTargetLocation = target.getLocation();
			Location mobSpawnLocation = new Location(target.getWorld(), currentTargetLocation.getBlockX() + 25, currentTargetLocation.getBlockY() ,currentTargetLocation.getBlockZ() + 25);
			
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.WITHER);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ENDER_DRAGON);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.CREEPER);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.CREEPER);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.CREEPER);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.CREEPER);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ENDERMAN);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ENDERMAN);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ENDERMAN);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ENDERMAN);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ENDERMAN);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.SKELETON);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.SKELETON);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.SKELETON);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.SKELETON);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.SKELETON);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.SKELETON);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ZOMBIE);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ZOMBIE);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ZOMBIE);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ZOMBIE);
			target.getWorld().spawnEntity(mobSpawnLocation, EntityType.ZOMBIE);
			}else{
				player.sendMessage(ChatColor.RED + "Usage:");
				player.sendMessage(cmd.getUsage().toString());
			}
		}
		return true;
	}

}
