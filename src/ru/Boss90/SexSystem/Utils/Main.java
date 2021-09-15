package ru.Boss90.SexSystem.Utils;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.Boss90.SexSystem.Commands.*;
import ru.Boss90.SexSystem.Events.*;

public class Main extends JavaPlugin implements Listener{
	
	public static Main plugin;

	public void onEnable () {
		plugin = this;
		
		File config = new File(getDataFolder() + File.separator + "config.yml");
		if (!config.exists()) {
			getLogger().info("Creating new file config...");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		getDataFolder().mkdirs();
		EconomyProvider.init();
		
		getCommand("sex").setExecutor(new SubCommandsSex());
		Bukkit.getPluginManager().registerEvents(new ClickTracking(), this);
	}

	public void onDisable () {}
}
