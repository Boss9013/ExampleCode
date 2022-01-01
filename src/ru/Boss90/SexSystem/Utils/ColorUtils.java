package ru.boss90.sexsystem.utils;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;

public class ColorUtils {
	
	public static @Nonnull String parser (String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
}
