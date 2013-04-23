package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandSilentSmite implements CommandExecutor{
	private TrollYourPlayers plugin;

	public commandSilentSmite(TrollYourPlayers plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("silentsmite")){
			//cast player to sender
			Player player = (Player)sender;
			Player target = player.getServer().getPlayer(args[0]);
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "Please specify a player!");
				player.sendMessage(cmd.getUsage().toString());
			}else{
			if(target == null){
				sender.sendMessage(ChatColor.RED + "Player " + args[0].toString() + " was not trolled because he/she are not online");
			} else{
				target.getWorld().strikeLightning(target.getLocation());
				target.getWorld().strikeLightning(target.getLocation());
				target.playSound(target.getLocation(), Sound.WITHER_DEATH, 1, 0);
			}
			}
		}
		return true;
	}
}
