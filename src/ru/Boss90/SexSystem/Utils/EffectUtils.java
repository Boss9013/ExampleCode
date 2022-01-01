package ru.boss90.sexsystem.utils;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectUtils {
	public static void givePlayerEffects (Player player) {
			
		player.addPotionEffect (new PotionEffect(PotionEffectType.SLOW, 600, 2));
		player.addPotionEffect (new PotionEffect(PotionEffectType.BLINDNESS, 200, 2));
		player.addPotionEffect (new PotionEffect(PotionEffectType.WEAKNESS, 200, 2));
		
	}
}