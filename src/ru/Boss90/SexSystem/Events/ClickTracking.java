package ru.Boss90.SexSystem.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.Boss90.SexSystem.Utils.*;

public class ClickTracking implements Listener {
	
	@EventHandler
	public void playerInteract(final PlayerInteractEvent e) {
		final Player interactPlayer = e.getPlayer();
		final Action playerAction = e.getAction();
		if (playerAction != Action.RIGHT_CLICK_BLOCK && playerAction != Action.RIGHT_CLICK_AIR)
			return;
		@SuppressWarnings("deprecation")
		final ItemStack itemInHandPlayer = interactPlayer.getItemInHand();
		final ItemMeta metaItemInHandPlayer = itemInHandPlayer.getItemMeta();
		
		if (metaItemInHandPlayer.getLore().contains(ConfigUtils.configGetString("Toy.Lore"))) {
		if (metaItemInHandPlayer.getDisplayName().equals(ConfigUtils.configGetString("Toy.Name"))) {
			interactPlayer.sendTitle(ConfigUtils.configGetString("Toy.Title"), ConfigUtils.configGetString("Toy.Title2"), 20, 20, 20);
			EffectUtils.givePlayerEffects(interactPlayer); //This method adds the effect to the player: SLOW, BLINDNESS, WEAKNESS, for 10 seconds with level 2.
		}
	}
}
}