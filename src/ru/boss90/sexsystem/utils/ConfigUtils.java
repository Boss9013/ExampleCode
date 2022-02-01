package ru.boss90.sexsystem.utils;

import javax.annotation.Nullable;
import org.bukkit.entity.Player;
import me.clip.placeholderapi.PlaceholderAPI;
import ru.boss90.sexsystem.main.*;

public class ConfigUtils {

	public static @Nullable String getTextFromConfig(String chapter, Player player) {
		return ColorUtils.parser(PlaceholderAPI.setPlaceholders(player, Main.plugin.getConfig().getString(chapter)
				.replace("%prefix%", getString("General.Settings.Prefix"))));
	}
	
	public static @Nullable String getString(String chapter) {
		return ColorUtils.parser(Main.plugin.getConfig().getString(chapter));
	}
	
}
