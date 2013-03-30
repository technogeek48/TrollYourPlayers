package me.technogeek48.TrollYourPlayers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TrollYourPlayers extends JavaPlugin {
	
	public void onEnable(){
		getLogger().info("Loaded TrollYourPlayers v.0.1");
	}
	
	public void onDisable(){
		getLogger().info("Unloaded TrollYourPlayers v.0.1");
	}
	
	//------------------------------//
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("trollmus")){ 
			Player target = (Bukkit.getServer().getPlayer(args[0]));
			if(target == null){
				sender.sendMessage(ChatColor.RED + "Player " + args[0].toString() + " was not trolled because he/she are not online");
			} else{
				//target.playSound(target.getLocation(), Sound.NOTE_PIANO, 1, 0);
				int start = 1;
				int end = 50;
				while(start != end){
					target.playSound(target.getLocation(), Sound.NOTE_PIANO, 1, 0);
					try {
						wait(2);
					} catch (InterruptedException e) {
						sender.sendMessage(ChatColor.RED + "The target player was not smited because of a server error, check console.");
						String error = e.toString();
						getLogger().severe("[TrollYourPlayers] You should never get this error unless something verry wierd happens:");
						getLogger().severe(error);
					}
				}
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("trollmode")) { //trollmode cmd
			int trollmode;
			Player player = (Player) sender;
			if(player.getActivePotionEffects().toString().contains("INVISIBILITY")){
				trollmode = 1;
			} else {
				trollmode = 0;
			}
			//if the player doesn't have trollmode, give him potion effects and play wither spawn sound.
			if(trollmode == 0){
					player.playSound(player.getLocation(), Sound.WITHER_SPAWN, 1, 0);
					player.sendMessage("Enabled TrollMode for " + player.getName());
					player.setAllowFlight(true);
					player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
					player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 10));
					player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 5));
					player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 5));
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 5));
					Bukkit.getServer().getLogger().info("Player " + player.getDisplayName().toString() + " has turned into a troll.");
			}else if(trollmode == 1){ //if the player already has trollmode, remove the potion effects and play wither death sound.
					player.playSound(player.getLocation(), Sound.WITHER_DEATH, 1, 0);
					player.sendMessage("Disabled trollmode for " + player.getName().toString());
					player.removePotionEffect(PotionEffectType.INVISIBILITY);
					player.removePotionEffect(PotionEffectType.SPEED);
					player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					player.removePotionEffect(PotionEffectType.JUMP);
					player.removePotionEffect(PotionEffectType.REGENERATION);
					player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					Bukkit.getServer().getLogger().info("Player " + player.getDisplayName().toString() + " is no longer a troll.");
					player.setAllowFlight(false);
				
			}
			return true;
		} else if(cmd.getName().equalsIgnoreCase("silentsmite")){
			Player target = (Bukkit.getServer().getPlayer(args[0]));
			if(target == null){
				sender.sendMessage(ChatColor.RED + "Player " + args[0].toString() + " was not trolled because he/she are not online");
			} else{
				target.getWorld().strikeLightning(target.getLocation());
				try {
					wait(2);
				} catch (InterruptedException e) {
					sender.sendMessage(ChatColor.RED + "The target player was not smited because of a server error, check console.");
					String error = e.toString();
					getLogger().severe("[TrollYourPlayers] You should never get this error unless something verry wierd happens:");
					getLogger().severe(error);
				}
				target.getWorld().strikeLightning(target.getLocation());
				target.playSound(target.getLocation(), Sound.WITHER_DEATH, 1, 0);
			}
		} else if(cmd.getName().equalsIgnoreCase("supersmite")){
			Player target = (Bukkit.getServer().getPlayer(args[0]));
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
			Player target = (Bukkit.getServer().getPlayer(args[0]));
			if(target == null){
				sender.sendMessage(ChatColor.RED + "Player " + args[0].toString() + " was not trolled because he/she are not online");
			} else{
				Location targetBed = target.getBedSpawnLocation();
				targetBed.getWorld().createExplosion(targetBed, 5);
			}
		}
		return false;
		}
}