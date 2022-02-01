package ru.boss90.sexsystem.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import ru.boss90.sexsystem.utils.*;
import ru.boss90.sexsystem.main.Main;
import org.bukkit.event.*;

public class ClickTracking implements Listener{
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void playerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemMeta metaItemInHand = player.getInventory().getItemInMainHand().getItemMeta();
		
		Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
		
				if (event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_AIR)
					return;
					
				if(metaItemInHand.getLore() == null || metaItemInHand.getDisplayName() == null)
					return;
				
				if (metaItemInHand.getLore().contains(ConfigUtils.getString("Toy.Lore")) || metaItemInHand.getDisplayName().equals(ConfigUtils.getString("Toy.Name"))){
					player.sendTitle(ConfigUtils.getString("Toy.TitleOneLine"), ConfigUtils.getString("Toy.TitleTwoLine"), 20, 20, 20);
					EffectUtils.givePlayerEffects(player); //This method adds the effect to the player: SLOW, BLINDNESS, WEAKNESS, for 10 seconds with level 2.
				}
		
        	}
			
        },10L);
	}
}