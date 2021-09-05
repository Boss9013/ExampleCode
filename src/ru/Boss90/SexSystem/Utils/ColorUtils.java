package ru.Boss90.SexSystem.Utils;

import org.bukkit.ChatColor;

public class ColorUtils {
	public static String parserColor (String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
}
