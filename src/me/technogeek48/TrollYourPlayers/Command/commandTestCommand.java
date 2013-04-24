package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandTestCommand implements CommandExecutor {
	private TrollYourPlayers plugin;

	public commandTestCommand(TrollYourPlayers plugin) {
		//this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		//Player target = (player.getServer().getPlayer(args[0]));
		if(cmd.getName().equalsIgnoreCase("testcommand")){
			player.sendMessage("Message sent from command executor, " + player.getName().toString());
		}
		
		//---Return---//
		return true;
	}
}
