package ru.Boss90.SexSystem.Utils;

import org.bukkit.ChatColor;

public class ColorUtil {
	public static String parserColor (String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
}
