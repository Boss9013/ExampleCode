

import java.io.*;
import org.bukkit.*;
import org.bukkit.plugin.java.*;
import org.bukkit.event.*;

import ru.Boss90.SexSystem.Commands.*;
import ru.Boss90.SexSystem.Events.*;
import ru.Boss90.SexSystem.Utils.*;

public class Main extends JavaPlugin implements Listener{
	public static Main plugin = new Main();

	final public void onEnable () {
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
