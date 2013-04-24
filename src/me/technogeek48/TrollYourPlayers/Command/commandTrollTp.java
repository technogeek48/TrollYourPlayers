package me.technogeek48.TrollYourPlayers.Command;

import me.technogeek48.TrollYourPlayers.TrollYourPlayers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandTrollTp implements CommandExecutor {
	//private TrollYourPlayers plugin;

	public commandTrollTp(TrollYourPlayers trollYourPlayers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("trolltp")){
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
			}
		return true;
	}

}
