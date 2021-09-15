package ru.Boss90.SexSystem.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ChatUtil {
	public static void sendMessage (Player player, String sectionInConfig) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.plugin.getConfig().getString(sectionInConfig)));
	}
	final public static void help (Player p){
		sendMessage(p, "Messages.selectPage");
		TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aClick" ));
		message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/sex help"));
		message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click MY.").create() ) );
		p.spigot().sendMessage(message);
		
	}
}
