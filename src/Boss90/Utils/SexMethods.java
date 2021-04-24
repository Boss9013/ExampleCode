package Boss90.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class SexMethods {
	//Класс с методами
final public static void sendMessage(final Player p, final String config) {
	p.sendMessage(ChatColor.translateAlternateColorCodes('&',SexMain.plugin.getConfig().getString(config)));
}
final public static String ConfigString(final String config) {
	return ChatColor.translateAlternateColorCodes('&',SexMain.plugin.getConfig().getString(config));
}
final public static void sendMessage2(final Player p, final String message) {
	p.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
}
final public static void Effect(final Player p) {
    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 2));
    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 2));
    p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 2));
}
final public static void Help(final Player p){
	SexMethods.sendMessage(p, "Messages.SelectPage");
	TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aClick" ));
	message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/sex help"));
	message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click MY.").create() ) );
	p.spigot().sendMessage(message);
}
}