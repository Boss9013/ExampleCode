package ru.Boss90.SexSystem.Utils;

import org.bukkit.ChatColor;

public class ConfigUtil {
	final public static String configGetString (String config) {
		return ChatColor.translateAlternateColorCodes('&',Main.plugin.getConfig().getString(config));
	}
}
