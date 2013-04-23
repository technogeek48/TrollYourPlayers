package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandRageQuit implements CommandExecutor {
	private TrollYourPlayers plugin;

	public commandRageQuit(TrollYourPlayers trollYourPlayers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ragequit")){
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
		}
		return true;
	}

}
