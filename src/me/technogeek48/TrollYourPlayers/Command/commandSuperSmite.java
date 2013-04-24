package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandSuperSmite implements CommandExecutor{
	private TrollYourPlayers plugin;

	public commandSuperSmite(TrollYourPlayers plugin) {
		//this.plugin = plugin;
	}
	
	@Override
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
		}
		return true;
	}
}
