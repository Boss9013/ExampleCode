package ru.Boss90.SexSystem.Utils;

import java.io.*;
import org.bukkit.*;
import org.bukkit.plugin.java.*;
import org.bukkit.event.*;

import ru.Boss90.SexSystem.Commands.*;
import ru.Boss90.SexSystem.Events.*;

public class Main extends JavaPlugin implements Listener{
	public static Main plugin;

	final public void onEnable () {
		plugin = this;
		final File config = new File(getDataFolder() + File.separator + "config.yml");
		if (!config.exists()) {
			getLogger().info("Creating new file config...");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		getDataFolder().mkdirs();
		SexSystemEconomyManager.init();
		getCommand("sex").setExecutor(new SubCommands());
		Bukkit.getPluginManager().registerEvents(new ClickTracking(), this);
	}

	final public void onDisable () {}
}
