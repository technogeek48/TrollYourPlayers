package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandTrollMus implements CommandExecutor{
	private TrollYourPlayers plugin;

	public commandTrollMus(TrollYourPlayers plugin) {
		//this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	if (cmd.getName().equalsIgnoreCase("trollmus")){ 
		Player player = (Player)sender;
		Player target = player.getServer().getPlayer(args[0]);
		if (args.length == 0){
			player.sendMessage(ChatColor.RED + "Please specify a player!");
			player.sendMessage(cmd.getUsage().toString());
		}else{
		if(target == null){
			sender.sendMessage(ChatColor.RED + "Player " + args[0].toString() + " was not trolled because he/she are not online");
		} else{
			//target.playSound(target.getLocation(), Sound.NOTE_PIANO, 1, 0);
			int start = 1;
			int end = 60;
			while(start != end){
				target.playSound(target.getLocation(), Sound.NOTE_PIANO, 1, 0);
				target.playSound(target.getLocation(), Sound.NOTE_BASS, 1, 0);
				target.playSound(target.getLocation(), Sound.NOTE_SNARE_DRUM, 1, 0);
				start++;
				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		}
	}
	return true;
}
}
