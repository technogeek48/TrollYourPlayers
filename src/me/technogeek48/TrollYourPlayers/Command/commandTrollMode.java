package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class commandTrollMode implements CommandExecutor{
	private TrollYourPlayers plugin;

	public commandTrollMode(TrollYourPlayers plugin) {
		this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (cmd.getName().equalsIgnoreCase("trollmode")) { //trollmode cmd
		int trollmode;
		//cast player to sender
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
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "A troll was born.");
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
				Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "A trollzor haz diedzord.");
				Bukkit.getServer().getLogger().info("Player " + player.getDisplayName().toString() + " is no longer a troll.");
				player.setAllowFlight(false);
			
		}
	}
	return true;
}
}