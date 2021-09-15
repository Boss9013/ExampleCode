package ru.Boss90.SexSystem.Utils;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectUtil {
	public static void givePlayerEffects (Player player) {
		
		try {
			
		player.addPotionEffect (new PotionEffect(PotionEffectType.SLOW, 600, 2));
		player.addPotionEffect (new PotionEffect(PotionEffectType.BLINDNESS, 200, 2));
		player.addPotionEffect (new PotionEffect(PotionEffectType.WEAKNESS, 200, 2));
		
		}catch(IllegalStateException ignored) {}
		
	}
}