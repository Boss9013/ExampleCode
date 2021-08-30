package ru.Boss90.SexSystem.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ru.Boss90.SexSystem.Utils.Methods;

public class ClickTracking implements Listener {
	//Отслеживание клика игрока по игрушке
	
	@EventHandler
	public void playerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		if (a != Action.RIGHT_CLICK_BLOCK && a != Action.RIGHT_CLICK_AIR)
			return;
		final ItemStack item = p.getItemInHand();
		final ItemMeta meta = item.getItemMeta();
		if (meta == null)
			return;
		if (meta.getDisplayName() == null)
			return;
		if (meta.getLore() == null)
			return;
		if (meta.getLore().contains(Methods.ConfigString("Igryshka.Lore"))) {
		if (meta.getDisplayName().equals(Methods.ConfigString("Igryshka.Name"))) {
			p.sendTitle(Methods.ConfigString("Igryshka.Title"), Methods.ConfigString("Igryshka.Title2"), 20, 20, 20);
			Methods.Effect(p);
		}
	}
}
}