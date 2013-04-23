package me.technogeek48.TrollYourPlayers;

import me.technogeek48.TrollYourPlayers.Command.commandAnvilPointer;
import me.technogeek48.TrollYourPlayers.Command.commandEpicSmite;
import me.technogeek48.TrollYourPlayers.Command.commandEpicSmitePointer;
import me.technogeek48.TrollYourPlayers.Command.commandFallOfDoom;
import me.technogeek48.TrollYourPlayers.Command.commandMobRaid;
import me.technogeek48.TrollYourPlayers.Command.commandRageQuit;
import me.technogeek48.TrollYourPlayers.Command.commandSilentSmite;
import me.technogeek48.TrollYourPlayers.Command.commandSuperSmite;
import me.technogeek48.TrollYourPlayers.Command.commandTestCommand;
import me.technogeek48.TrollYourPlayers.Command.commandTrollAnvil;
import me.technogeek48.TrollYourPlayers.Command.commandTrollBed;
import me.technogeek48.TrollYourPlayers.Command.commandTrollMode;
import me.technogeek48.TrollYourPlayers.Command.commandTrollMus;
import me.technogeek48.TrollYourPlayers.Command.commandTrollTp;
import me.technogeek48.TrollYourPlayers.Command.commandVoid;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TrollYourPlayers extends JavaPlugin {
	
	public void onEnable(){
		//getCommand("example").setExecutor(new command---------(this));
		getCommand("testcommand").setExecutor(new commandTestCommand(this));
		getCommand("trollmus").setExecutor(new commandTrollMus(this));
		getCommand("trollmode").setExecutor(new commandTrollMode(this));
		getCommand("silentsmite").setExecutor(new commandSilentSmite(this));
		getCommand("supersmite").setExecutor(new commandSuperSmite(this));
		getCommand("trollbed").setExecutor(new commandTrollBed(this));
		getCommand("fallofdoom").setExecutor(new commandFallOfDoom(this));
		getCommand("trolltp").setExecutor(new commandTrollTp(this));
		getCommand("ragequit").setExecutor(new commandRageQuit(this));
		getCommand("trollanvil").setExecutor(new commandTrollAnvil(this));
		getCommand("anvilpointer").setExecutor(new commandAnvilPointer(this));
		getCommand("void").setExecutor(new commandVoid(this));
		getCommand("mobraid").setExecutor(new commandMobRaid(this));
		getCommand("epicsmite").setExecutor(new commandEpicSmite(this));
		getCommand("epicsmitepointer").setExecutor(new commandEpicSmitePointer(this));
		//getLogger().info("Loaded TrollYourPlayers v.0.1");
	}
	
	public void onDisable(){
		//getLogger().info("Unloaded TrollYourPlayers v.0.1");
	}
	
	//------------------------------//
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("supersmite")){
			Player player = (Player)sender;
			Player target = player.getServer().getPlayer(args[0]);
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "Please specify a player!");
				player.sendMessage(cmd.getUsage().toString());
			}
			if(target == null){
				sender.sendMessage(ChatColor.RED + "Player " + args[0].toString() + " was not trolled because he/she are not online");
			} else{
				Location targetLocation = target.getLocation();
				target.getWorld().strikeLightning(targetLocation).isEffect();
				target.getWorld().createExplosion(targetLocation, 3);
				target.getWorld().strikeLightning(targetLocation);
				target.getWorld().createExplosion(targetLocation, 3);
				target.getWorld().strikeLightning(targetLocation);
			}
		} else if(cmd.getName().equalsIgnoreCase("trollbed")){
			//cast player to sender
			Player player = (Player) sender;
			Player target = player.getServer().getPlayer(args[0]);
			if (args.length == 0){
				player.sendMessage(ChatColor.RED + "Please specify a player!");
				player.sendMessage(cmd.getUsage().toString());
			}else{
			if(target == null){
				sender.sendMessage(ChatColor.RED + "Player " + args[0].toString() + " was not trolled because he/she are not online");
			} else{
				Location targetBed = target.getBedSpawnLocation();
				if(targetBed == null){
					sender.sendMessage("Player doesn't have a bed.");
				}else{
				target.getWorld().createExplosion(targetBed, 5);
				}
			}
			}
			}else if(cmd.getName().equalsIgnoreCase("fallofdoom")){
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
			}else if(cmd.getName().equalsIgnoreCase("trolltp")){
				Player player = (Player) sender;
				//Player target = (player.getServer().getPlayer(args[0]));
				String option = args[0].toString();
				player.sendMessage("WIP");
				if (option.equalsIgnoreCase("set")){
					//File locationFile = new File(getDataFolder(), "trolltp.txt");
					//try{
						//FileInputStream imputStream1 = new FileInputStream(locationFile);
						//DataInputStream dataStream1 = new DataInputStream(imputStream1);
						//FileOutputStream fileOutput1 = new FileOutputStream(locationFile);
						//DataOutputStream dataOutput1 = new DataInputStream(fileOutput1);
						
						
					//}
				}
				}else if(cmd.getName().equalsIgnoreCase("ragequit")){
					Player player = (Player) sender;
					Player target = player.getServer().getPlayer(args[0]);
					
					if(args.length == 0){
						player.sendMessage(ChatColor.RED + "Please specify a player!");
						player.sendMessage(cmd.getUsage().toString());
					}else{
						Bukkit.getServer().broadcastMessage(target.getDisplayName() + " is a rager");
						target.chat("F*** THIS SERVER I RAGEQUIT");
						target.chat("F*** THIS SERVER I RAGEQUIT");
						target.chat("F*** THIS SERVER I RAGEQUIT");
						target.chat("F*** THIS SERVER I RAGEQUIT");
						target.chat("F*** THIS SERVER I RAGEQUIT");
						target.kickPlayer("RAGE QUIT");
					}
				}else if(cmd.getName().equalsIgnoreCase("trollanvil")){
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
				}else if(cmd.getName().equalsIgnoreCase("anvilpointer")){
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
				}else if(cmd.getName().equalsIgnoreCase("digstraightdown")){
					Player player = (Player) sender;
					//Player target = player.getServer().getPlayer(args[0]);
					if(args[0].isEmpty()){
						player.sendMessage("Specify a player!");
						player.sendMessage(cmd.getUsage().toString());
					}else{
						//target.setAllowFlight(false);
						//target.setGameMode(GameMode.ADVENTURE);
						//Bukkit.getServer().broadcastMessage(target.getDisplayName() + " broke the #1 rule of minecraft: NEVER DIG STRAIGHT DOWN!!!");
						//Location targetLocation = target.getLocation();
						//Location currentTargetBlock = new Location(target.getWorld(), targetLocation.getBlockX(), 14, targetLocation.getBlockZ());
						//Location newTargetBlock = new Location(target.getWorld(), targetLocation.getBlockX(), targetLocation.getBlockY() - 1, targetLocation.getBlockZ());
						////Location newTargetLocation = new Location(target.getWorld(), targetLocation.getBlockX(), targetLocation.getBlockY() - 2, targetLocation.getBlockZ());
						//currentTargetBlock.getBlock().setType(Material.LAVA);
						//int counterStart = currentTargetBlock.getBlockY();
						//int counterEnd = 14;
						
						//while(counterStart != counterEnd){
						//	counterStart--;
						//	targetLocation.getBlock
						}
						
					}else if(cmd.getName().equalsIgnoreCase("void")){
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
					}else if(cmd.getName().equalsIgnoreCase("tripout")){
						Player player = (Player) sender;
						Player target = (player.getServer().getPlayer(args[0]));
						if(args.length == 1){
							target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Integer.MAX_VALUE, 10));
						}else{
							player.sendMessage(ChatColor.RED + "Usage:");
							player.sendMessage(cmd.getUsage().toString());
						}
					}else if(cmd.getName().equalsIgnoreCase("mobraid")){
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
					}else if(cmd.getName().equalsIgnoreCase("epicsmitepointer")){
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