package ru.boss90.sexsystem.utils;

import org.bukkit.entity.Player;

public class MessageUtils {
	
	public static void sendMessage (Player player, String sectionInConfig) {
		player.sendMessage(ConfigUtils.getTextFromConfig(sectionInConfig, player));
	}
	
}
