package ru.boss90.sexsystem.main;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.boss90.sexsystem.commands.*;
import ru.boss90.sexsystem.listeners.ClickTracking;
import ru.boss90.sexsystem.utils.EconomyProvider;

public class Main extends JavaPlugin implements Listener{
	
	public static Main plugin;

	public void onEnable () {
		plugin = this;
		saveDefaultConfig();
		EconomyProvider.init();
		getCommand("sex").setExecutor(new SubCommandSex());
		Bukkit.getPluginManager().registerEvents(new ClickTracking(), this);
	}

	public void onDisable () {}
}
