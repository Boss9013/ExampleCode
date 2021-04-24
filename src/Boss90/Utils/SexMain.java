package Boss90.Utils;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import Boss90.Commands.CommandSex;
import Boss90.Events.Igryshka;

public class SexMain extends JavaPlugin implements Listener{
	public static SexMain plugin;

	final public void onEnable() {
		plugin = this;
		final File config = new File(getDataFolder() + File.separator + "config.yml");
		if (!config.exists()) {
			getLogger().info("Creating new file config...");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		getDataFolder().mkdirs();
		EconomyManager.init();
		getCommand("sex").setExecutor(new CommandSex());
		Bukkit.getPluginManager().registerEvents(new Igryshka(), this);
	}

	final public void onDisable() {}
}
