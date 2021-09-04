package ru.Boss90.SexSystem.Utils;

import org.bukkit.ChatColor;

public class ConfigUtils {
	final public static String configGetString (String config) {
		return ChatColor.translateAlternateColorCodes('&',Main.plugin.getConfig().getString(config));
	}
}
