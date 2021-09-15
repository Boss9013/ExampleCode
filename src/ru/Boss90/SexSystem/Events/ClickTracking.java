package ru.Boss90.SexSystem.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import ru.Boss90.SexSystem.Utils.*;
import org.bukkit.event.*;

public class ClickTracking implements Listener{
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void playerInteract(final PlayerInteractEvent e) {
		
		final Player interactPlayer = e.getPlayer();
		final Action playerAction = e.getAction();
		final ItemStack itemInHandPlayer = interactPlayer.getItemInHand();
		final ItemMeta metaItemInHandPlayer = itemInHandPlayer.getItemMeta();
		
        new BukkitRunnable() {
        	
        	public void run() {
		
		if (playerAction != Action.RIGHT_CLICK_BLOCK && playerAction != Action.RIGHT_CLICK_AIR)
			return;
			
		if(metaItemInHandPlayer.getLore() == null || metaItemInHandPlayer.getDisplayName() == null)
			return;
		if (metaItemInHandPlayer.getLore().contains(ConfigUtil.configGetString("Toy.lore"))
		 || metaItemInHandPlayer.getDisplayName().equals(ConfigUtil.configGetString("Toy.name"))){
			interactPlayer.sendTitle(ConfigUtil.configGetString("Toy.titleOneLine"), ConfigUtil.configGetString("Toy.titleTwoLine"), 20, 20, 20);
			EffectUtil.givePlayerEffects(interactPlayer); //This method adds the effect to the player: SLOW, BLINDNESS, WEAKNESS, for 10 seconds with level 2.
		}
		
        	}
        }.runTaskLaterAsynchronously(Main.plugin, 30L);
	}
}