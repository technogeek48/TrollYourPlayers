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
import org.bukkit.plugin.java.JavaPlugin;

public class TrollYourPlayers extends JavaPlugin {
	
	public void onEnable(){
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
	}
	public void onDisable(){
		//do shit
	}
}