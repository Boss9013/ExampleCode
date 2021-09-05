package ru.Boss90.SexSystem.Utils;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectUtils {
	final public static void givePlayerEffects (Player p) {
		p.addPotionEffect (new PotionEffect(PotionEffectType.SLOW, 600, 2));
		p.addPotionEffect (new PotionEffect(PotionEffectType.BLINDNESS, 200, 2));
		p.addPotionEffect (new PotionEffect(PotionEffectType.WEAKNESS, 200, 2));
	}
}