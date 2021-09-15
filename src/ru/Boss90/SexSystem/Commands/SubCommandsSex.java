package ru.Boss90.SexSystem.Commands;

import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.Boss90.SexSystem.Utils.*;

public class SubCommandsSex implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  
		if (!(sender instanceof Player)) {
	    	System.out.println("You are not a player");
	    	return true;
		}
		
		//variables
		
		final Player commandSender = (Player) sender;
	    List<String> listOffers = Main.plugin.getConfig().getStringList("randomOffers");
	    Random randomInt = new Random();
	    int index = randomInt.nextInt(listOffers.size());
	    String randomWord = listOffers.get(index);
		ItemStack toy = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta metaToy = toy.getItemMeta();
		ArrayList<String> list = new ArrayList<>();
		
	    if (!commandSender.hasPermission("SexSystem.useSubCommands")) {
	    	
	        ChatUtil.sendMessage(commandSender, "Messages.noPerm");
	        return true;
	        
	    }
	    
	    if (args.length == 0) {
	    	
			ChatUtil.help(commandSender);
			return true;
			
	    }
	    
	    //SUBCOMMANDS
	    
		if (args[0].equalsIgnoreCase("buy")) {

            list.add(ConfigUtil.configGetString("Toy.lore"));
            metaToy.setDisplayName(ConfigUtil.configGetString("Toy.name"));
            metaToy.setLore(list);
            toy.setItemMeta(metaToy);
            commandSender.getInventory().addItem(toy);
            EconomyProvider.takeMoney(commandSender, Main.plugin.getConfig().getInt("Settings.priceToy"));
            ChatUtil.sendMessage(commandSender, "Messages.buyToy");
            
		}
		
		if (args[0].equalsIgnoreCase("help")) {
			
				List<String> helpMessages = Main.plugin.getConfig().getStringList("helpForPlugin");
				for(String helpMsg : helpMessages) {
					commandSender.sendMessage(ColorUtil.parserColor(helpMsg));
				}
				return true;		
		}
		
		if (args[0].equalsIgnoreCase("call")) {
			
				if (args.length == 1) {
					
					ChatUtil.sendMessage(commandSender, "Messages.error");
					return true;
					
				}
				if (Bukkit.getPlayer(args[1]) == null) {
					
					ChatUtil.sendMessage(commandSender, "Messages.offlinePartner");
					return true;
					
				}
				if (args[1].contains(commandSender.getName())) {
					
					ChatUtil.sendMessage(commandSender, "Messages.isPartnerSender");
					return true;
					
				}
				if (commandSender.getLocation().distance(Bukkit.getPlayer(args[1]).getLocation()) >= Main.plugin.getConfig().getInt("Settings.distance")) {
					ChatUtil.sendMessage(commandSender, "Messages.distance");
			    	return true;
			    }
				
				EffectUtil.givePlayerEffects(commandSender); //This method adds the effect to the player: SLOW, BLINDNESS, WEAKNESS, for 10 seconds with level 2.
				ChatUtil.sendMessage(commandSender, "Messages.sucessSex"); //This method sends the player a text with a color translation from the config.
				commandSender.sendMessage(ColorUtil.parserColor(randomWord));
				EffectUtil.givePlayerEffects(Bukkit.getPlayer(args[1]));
				ChatUtil.sendMessage(Bukkit.getPlayer(args[1]), "Messages.sucessSex");
				Bukkit.getPlayer(args[1]).sendMessage(ColorUtil.parserColor(randomWord));
				
		}
		return true; 
}
}
