package me.technogeek48.TrollYourPlayers;

//import org.bukkit.ChatColor;
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
		if (cmd.getName().equalsIgnoreCase("silentsmite")){ // If the player typed /silentsmite then do the following...
			Player player = (Player) sender;
			Location pos = player.getLocation();
			//Location smiteRadius = player.getLocation().toString().replace("X, replacement);
			//player.sendMessage("Debug Command");
			//player.sendMessage("smiting you, your position is: " + pos.toString().replaceAll("{", " "));
			player.getWorld().strikeLightning(pos).isEffect();
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
			//detect if the player requested the quiet argument, then dont play wither sound.
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
					player.giveExp(9001);
			}else if(trollmode == 1){ //if the player already has trollmode, remove the potion effects and play wither death sound.
					player.playSound(player.getLocation(), Sound.WITHER_DEATH, 1, 0);
					player.sendMessage("Disabled trollmode for " + player.getName().toString());
					player.removePotionEffect(PotionEffectType.INVISIBILITY);
					player.removePotionEffect(PotionEffectType.SPEED);
					player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					player.removePotionEffect(PotionEffectType.JUMP);
					player.removePotionEffect(PotionEffectType.REGENERATION);
					player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					player.setAllowFlight(false);
				
			}
			return true;
		} else if(cmd.getName().equalsIgnoreCase("trollmus")){
			Player target = (Bukkit.getServer().getPlayer(args[0]));
			if(target == null){
				sender.sendMessage(ChatColor.RED + "Player " + args[0].toString() + " is not online!");
			}
		}
		return false;
}
}
